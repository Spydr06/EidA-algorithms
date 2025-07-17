package ds;

public interface HashTable<K, V> extends Dictionary<K, HashTable.HashEntry<K, V>> {
    class HashEntry<K, V> implements Dictionary.Entry<K> {
        private final K key;
        private final V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return key.toString() + " -> " + value.toString();
        }
    }
}
