package ds;

public interface Dictionary<K, V extends Dictionary.Entry<K>> {
    interface Entry<K> {
        K getKey();
    }

    V search(K key);
    void insert(V value);
    void delete(V value);
}
