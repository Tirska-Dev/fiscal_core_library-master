package me.ugreek85.db;


import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface IRecordMap<KeyType, DataType, LocationType> {

    void set(KeyType key, DataType data);
    Optional<DataType> get(KeyType key);
    Optional<DataType> getIfValid(KeyType key);
    boolean exists(KeyType key);
    void delete(KeyType key);
    Set<KeyType> keySet(Predicate<KeyType> predicate);
    Set<KeyType> keySet();
    Supplier<LocationType> getLocation();
}
