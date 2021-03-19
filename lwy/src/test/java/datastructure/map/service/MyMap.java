package datastructure.map.service;

public interface MyMap<K, V> {
    void add(K key,V value);
    V remove(K key);
    void set(K key,V newValue);
    int size();
    boolean isEmpty();
    boolean contain(K key);
}
