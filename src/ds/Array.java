package ds;

import java.util.Arrays;

public class Array<T> {
    private T[] values;

    public Array(int size) {
        values = (T[]) new Object[size];
    }

    public int size() {
        return values.length;
    }

    public T get(int index) {
        if(index < 0 || index >= values.length)
            throw new IndexOutOfBoundsException(index);

        return values[index];
    }

    public void set(int index, T x) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException(index);

        values[index] = x;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
