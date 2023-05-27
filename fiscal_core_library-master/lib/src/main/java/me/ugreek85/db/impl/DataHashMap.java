package me.ugreek85.db.impl;
import me.ugreek85.db.IDataHashMap;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DataHashMap implements IDataHashMap<String, File> {

    private File getFile(Supplier<File> location, String key)
    {
        return new File(location.get(), key);
    }

    @Override
    public void add(Supplier<File> location, String key) {
        try {
            if(!getFile(location, key).createNewFile())
            {
                throw new RuntimeException(String.format("Key %s was not added", key));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(Supplier<File> location, String key) {
        return getFile(location, key).exists();
    }

    @Override
    public void delete(Supplier<File> location, String key) {
        getFile(location, key).delete();
    }

    @Override
    public void deleteAll(Supplier<File> location, Predicate<String> matcher) {
        File[] files = location.get().listFiles((dir, name) -> matcher.test(name));
        if(files != null) Arrays.stream(files).forEach(File::delete);
    }
}
