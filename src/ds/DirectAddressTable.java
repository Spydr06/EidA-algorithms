package ds;

public class DirectAddressTable<V> extends Array<DirectAddressTable.Entry<V>> implements OrderedDictionary<Integer, DirectAddressTable.Entry<V>> {
    public static class Entry<V> implements Dictionary.Entry<Integer> {
        private final int key;
        private V value;

        public Entry(int key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + " -> " + value.toString();
        }
    }

    public DirectAddressTable(int size) {
        super(size);
    }

    @Override
    public Entry<V> search(Integer key) {
        return get(key);
    }

    @Override
    public void insert(Entry<V> value) {
        set(value.getKey(), value);
    }

    @Override
    public void delete(Entry<V> value) {
        set(value.getKey(), null);
    }

    @Override
    public Entry<V> minimum() {
        for(int i = 0; i < size(); i++) {
            Entry<V> x = get(i);
            if(x != null)
                return x;
        }
        return null;
    }

    @Override
    public Entry<V> maximum() {
        for(int i = size() - 1; i >= 0; i--) {
            Entry<V> x = get(i);
            if(x != null)
                return x;
        }
        return null;
    }

    @Override
    public Entry<V> successor(Entry<V> x) {
        for(int i = x.getKey(); i < size(); i++) {
            Entry<V> y = get(i);
            if(y != null)
                return y;
        }
        return null;
    }

    @Override
    public Entry<V> predecessor(Entry<V> x) {
        for(int i = x.getKey(); i >= 0; i--) {
            Entry<V> y = get(i);
            if(y != null)
                return y;
        }
        return null;
    }
}
