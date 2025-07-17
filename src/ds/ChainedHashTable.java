package ds;

import java.util.LinkedList;

public class ChainedHashTable<K, V> extends Array<LinkedList<HashTable.HashEntry<K, V>>> implements HashTable<K, V> {
    public ChainedHashTable(int size) {
        super(size);

        for(int i = 0; i < size(); i++) {
            set(i, new LinkedList<>());
        }
    }

    private int hash(K key) {
        return key.hashCode() % size();
    }

    private HashEntry<K, V> listSearch(LinkedList<HashTable.HashEntry<K, V>> list, K key) {
        return list.stream().filter(entry -> entry.equals(key)).findFirst().orElse(null);
    }

    @Override
    public HashEntry<K, V> search(K key) {
        return listSearch(get(hash(key)), key);
    }

    @Override
    public void insert(HashEntry<K, V> value) {
        get(hash(value.getKey())).addFirst(value);
    }

    @Override
    public void delete(HashEntry<K, V> value) {
        get(hash(value.getKey())).remove(value);
    }
}
