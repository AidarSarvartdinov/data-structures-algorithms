package com.aidar.ds.hashMap;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new MyHashMap<String, Integer>(10);
        map.put("One", 1);
        map.put("AAA", 3);
        System.out.println(map.get("One"));
        System.out.println(map.size());
        map.remove("One");
        System.out.println(map.get("One"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }
}

interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);

    int size();
    boolean isEmpty();
}

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap<K, V> implements Map<K, V> {
    private List<KeyValuePair<K, V>>[] hashTable;
    private int mapSize;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        hashTable = new List[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        KeyValuePair<K, V> entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
        } else {
            int hash = getHash(key);
            hashTable[hash].add(new KeyValuePair<K, V>(key, value));
            mapSize++;
        }
    }

    @Override
    public V get(K key) {
        KeyValuePair<K, V> entry = getEntry(key);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int hash = getHash(key);
        for (KeyValuePair<K, V> entry: hashTable[hash]) {
            if (entry.key.equals(key)) {
                hashTable[hash].remove(entry);
                mapSize--;
                return;
            }
        }
    }

    @Override
    public int size() {
        return mapSize;
    }

    @Override
    public boolean isEmpty() {
        return mapSize <= 0;
    }

    private KeyValuePair<K, V> getEntry(K key) {
        int hash = getHash(key);
        for (KeyValuePair<K, V> entry : hashTable[hash]) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
