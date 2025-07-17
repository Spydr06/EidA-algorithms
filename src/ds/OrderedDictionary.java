package ds;

public interface OrderedDictionary<K extends Comparable<K>, V extends Dictionary.Entry<K>> extends Dictionary<K, V> {
    V minimum();
    V maximum();

    V successor(V x);
    V predecessor(V x);
}
