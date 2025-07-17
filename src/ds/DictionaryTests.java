package ds;

public class DictionaryTests {
    public static void main(String[] args) {
        DirectAddressTable<String> dat = new DirectAddressTable<>(32);

        DirectAddressTable.Entry<String>[] datTestEntries = new DirectAddressTable.Entry[10];
        for(int i = 0; i < datTestEntries.length; i++) {
            int key = (int)(Math.random() * dat.size());
            String value = "Test value [Key " + key + "]";
            datTestEntries[i] = new DirectAddressTable.Entry<>(key, value);
        }

        testDictionary(dat, datTestEntries);

        HashTable<Integer, String>[] hashTables = new HashTable[]{
                new ChainedHashTable<>(10),
                new LinearHashTable<>(20),
        };

        HashTable.HashEntry<Integer, String>[] hashTestEntries = new HashTable.HashEntry[10];
        for(int i = 0; i < hashTestEntries.length; i++) {
            int key = (int) (Math.random() * 1024);
            String value = "Test value [Key " + key + "]";
            hashTestEntries[i] = new HashTable.HashEntry<>(key, value);
        }

        for (HashTable<Integer, String> hashTable : hashTables) {
            testDictionary(hashTable, hashTestEntries);
        }
    }

    private static <E extends Dictionary.Entry<Integer>> void testDictionary(Dictionary<Integer, E> dict, E[] entries) {
        System.out.println("Testing dictionary " + dict.getClass().getName());
        for(E entry : entries) {
            dict.insert(entry);
        }

        System.out.println(dict);

        for(int i = 0; i < entries.length / 2; i++) {
            dict.delete(entries[i]);
        }

        System.out.println(dict);

        for(int i = entries.length / 2; i < entries.length; i++) {
            E entry = dict.search(entries[i].getKey());
            E removed = dict.search(entries[i - entries.length / 2].getKey());
            assert entry != null;
            assert removed == null;
        }
    }
}
