package ds;

public class LinearHashTable<K, V> extends Array<HashTable.HashEntry<K, V>> implements HashTable<K, V> {
    public LinearHashTable(int size) {
        super(size);
    }

    private int hash(K k, int i) {
        return (k.hashCode() + i * Integer.hashCode(k.hashCode())) % size();
    }

    public Integer linearSearch(K key) {
        int i = 0;
        do {
            int q = hash(key, i);
            HashEntry<K, V> entry = get(q);
            if(entry != null && entry.getKey().equals(key))
                return q;

            i++;
        } while(i < size());

        return null;
    }

    @Override
    public HashEntry<K, V> search(K key) {
        Integer q = linearSearch(key);
        if(q == null)
            return null;

        return get(q);
    }

    @Override
    public void insert(HashEntry<K, V> value) {
        int i = 0;
        do {
            int q = hash(value.getKey(), i);
            if(get(q) == null) {
                set(q, value);
                return;
            }

            i++;
        } while(i < size());

        throw new IndexOutOfBoundsException();
    }

    public void linearProbingHashDelete(int q) {
        while(true) {
            set(q, null);
            int p = q;
            HashEntry<K, V> entry;

            do {
                p = (p + 1) % size();
                entry = get(p);
                if (entry == null)
                    return;
            } while(hash(entry.getKey(), q) >= hash(entry.getKey(), p));

            set(q, entry);
            q = p;
        }
    }

    @Override
    public void delete(HashEntry<K, V> value) {
        int q = linearSearch(value.getKey());
        linearProbingHashDelete(q);
    }
}
