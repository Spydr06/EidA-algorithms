package sorting;

public abstract class RangedSorter <T extends Number & Comparable<T>> extends Sorter<T> {
    private final T min, max;

    public RangedSorter(T min, T max) {
        assert min.compareTo(max) <= 0;
        this.min = min;
        this.max = max;
    }

    public T getRangeMin() {
        return this.min;
    }

    public T getRangeMax() {
        return this.max;
    }
}
