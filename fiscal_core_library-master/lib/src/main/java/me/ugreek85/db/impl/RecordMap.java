package me.ugreek85.db.impl;

import me.ugreek85.db.IDataHashMap;
import me.ugreek85.db.IRecordMap;

import java.io.*;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

abstract class RecordMap implements IRecordMap<String, byte[], File> {

    private final File root;
    private final Pattern keyValidationPattern;
    private final File collectionRoot;
    private IDataHashMap<String, File> dataHash;
    private MessageDigest digest;
    private byte[] buffer;
    private final Pattern hashRecordPattern;

    public RecordMap(File root, String collectionName, Pattern keyValidationPattern, IDataHashMap<String, File> dataHash) {
        this.root = root;
        this.keyValidationPattern = keyValidationPattern;
        this.collectionRoot = new File(this.root, collectionName);
        this.dataHash = dataHash;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        buffer = new byte[1024];
        hashRecordPattern = Pattern.compile(".*\\.[0-9a-f]{64}");
    }

    private File getFile(String key){
        return new File(collectionRoot, key);
    }

    private boolean isValidKey(String key)
    {
        return keyValidationPattern.matcher(key).matches();
    }

    private void validateKey(String key)
    {
        if(!isValidKey(key))
            throw new RuntimeException(
                    String.format("Key %s is not valid for pattern: %s", key, keyValidationPattern.pattern())
            );
    }

    private void createCollectionIfNotExists()
    {
        if(!collectionRoot.exists()) collectionRoot.mkdirs();
    }

    private File getCollectionRoot() {
        return collectionRoot;
    }

    private String getDataHashKey(String key, String hash) {
        return String.format("%s.%s", key, hash);
    }

    private void saveDataHash(String key, String hash){
        dataHash.add(this::getCollectionRoot, getDataHashKey(key, hash));
    }

    private boolean isHashRecord(String name){
        return hashRecordPattern.matcher(name).matches();
    }

    private void deleteDataHash(String key){

        dataHash.deleteAll(this::getCollectionRoot, (name) -> name.startsWith(key + ".") && isHashRecord(name));
    }

    private Pair readValue(String key) throws IOException {

        try(DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(new File(collectionRoot, key)), digest))
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int len;
            while (true) {
                len = digestInputStream.read(buffer);
                if(len == -1) break;
                out.write(buffer, 0, len);
            }
            return new Pair(out.toByteArray(), getHex(digestInputStream.getMessageDigest().digest()));
        }

    }

    private String writeValue(String key, byte[] value) throws IOException {

        try(DigestOutputStream digestInputStream = new DigestOutputStream(new FileOutputStream(getFile(key)), digest))
        {
            digestInputStream.write(value);
            return getHex(digestInputStream.getMessageDigest().digest());
        }
    }


    private String getHex(byte[] digest)
    {
        return new BigInteger(1, digest).toString(16);
    }


    private boolean isRecordValid(String key, String hash) {
        return dataHash.exists(this::getCollectionRoot, String.format("%s.%s", key, hash));
    }

    private class Pair
    {
        public byte[] data;
        public String hash;

        public Pair(byte[] data, String hash) {
            this.data = data;
            this.hash = hash;
        }
    }

    @Override
    public void delete(String key) {

        validateKey(key);

        getFile(key).delete();
        deleteDataHash(key);
    }

    @Override
    public boolean exists(String key) {
        return getFile(key).exists();
    }

    @Override
    public Supplier<File> getLocation() {
        return this::getCollectionRoot;
    }

    @Override
    public Set<String> keySet() {
        String[] list = getCollectionRoot().list((dir, name) -> isValidKey(name));
        if(list == null) return new HashSet<>();
        return Arrays.stream(list).collect(Collectors.toSet());
    }

    @Override
    public Set<String> keySet(Predicate<String> predicate) {

        String[] list = getCollectionRoot().list((dir, name) -> isValidKey(name) && predicate.test(name));
        if(list == null) return new HashSet<>();
        return Arrays.stream(list).collect(Collectors.toSet());
    }

    @Override
    public Optional<byte[]> getIfValid(String key) {

        validateKey(key);
        File file = getFile(key);
        if(file.exists()) {
            try {

                Pair pair = readValue(key);
                if(isRecordValid(key, pair.hash)) return Optional.of(pair.data);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return Optional.empty();
    }

    @Override
    public void set(String key, byte[] data) {

        validateKey(key);
        createCollectionIfNotExists();

        try {
            String hash = writeValue(key, data);
            saveDataHash(key, hash);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<byte[]> get(String key) {

        validateKey(key);
        File file = getFile(key);
        if(!file.exists()) return Optional.empty();

        try {

            Pair pair = readValue(key);
            return Optional.of(pair.data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
