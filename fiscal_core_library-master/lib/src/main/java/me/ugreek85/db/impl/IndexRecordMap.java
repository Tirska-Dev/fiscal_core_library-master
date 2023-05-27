package me.ugreek85.db.impl;


import me.ugreek85.db.IDataHashMap;

import java.io.File;
import java.util.regex.Pattern;

public class IndexRecordMap extends RecordMap{

    public IndexRecordMap(File root, String collectionName, Pattern keyValidationPattern, IDataHashMap<String, File> dataHash) {
        super(root, collectionName, keyValidationPattern, dataHash);
    }
}
