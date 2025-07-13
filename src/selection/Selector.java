package selection;

public abstract class Selector<T extends Comparable<T>> {
    public abstract T select(T[] input, int i);
}
