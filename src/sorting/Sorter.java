package sorting;

public abstract class Sorter<T extends Comparable<T>> {
    public abstract T[] sort(T[] input);
}
