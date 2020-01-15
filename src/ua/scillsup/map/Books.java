package ua.scillsup.map;

public interface Book<K, Val> extends Iterable<Val>{
    boolean insert(K key, Val value);
    boolean delete (K key);
    V get(K key);
    int size();
}
