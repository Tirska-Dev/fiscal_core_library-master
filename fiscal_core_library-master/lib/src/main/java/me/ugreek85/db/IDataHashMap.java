package me.ugreek85.db;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IDataHashMap<KeyType, LocationType> {

    void add(Supplier<LocationType> location, KeyType key);
    boolean exists(Supplier<LocationType> location, KeyType key);
    void delete(Supplier<LocationType> location, KeyType key);
    void deleteAll(Supplier<LocationType> location, Predicate<KeyType> matcher);
}
