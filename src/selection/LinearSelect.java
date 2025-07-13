package selection;

import sorting.Sorter;

public class LinearSelect<T extends Comparable<T>> extends Selector<T> {
    private final Sorter<T> baseSorter;

    public LinearSelect(Sorter<T> baseSorter) {
        this.baseSorter = baseSorter;
    }

    private int partitionAround(T[] arr, int p, int r, T x) {
        int i = p - 1;

        for(int j = p; j <= r; j++) {
            if(arr[j].compareTo(x) <= 0) {
                i++;

                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        T tmp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = tmp;

        return i + 1;
    }

    private T linearSelect(T[] arr, int p, int r, int i) {
        while((r - p + 1) % 5 != 0) {
            for(int j = p + 1; j <= r; j++) {
                if(arr[p].compareTo(arr[j]) > 0) {
                    T tmp = arr[p];
                    arr[p] = arr[j];
                    arr[j] = arr[p];
                }
            }

            if(i == 1)
                return arr[p];

            p++;
            i--;
        }

        int g = (r - p + 1) / 5;
        T[] xs = (T[]) new Comparable[5];

        for(int j = p; j < p + g; j++) {
            // create temporary array to use existing sorters
            for(int k = 0; k < 5; k++)
                xs[k] = arr[j + k * g];

            xs = baseSorter.sort(xs);

            // write back
            for(int k = 0; k < 5; k++)
                arr[j + k * g] = xs[k];
        }

        T x = linearSelect(arr, p + 2 * g, p + 3 * g, (int) Math.ceil((double) g / 2.0));
        int q = partitionAround(arr, p, r, x);

        int k = q - p + 1;
        if(i == k)
            return arr[q];
        else if(i < k)
            return linearSelect(arr, p, q - 1, i);
        else
            return linearSelect(arr, q + 1, r, i - k);
    }

    @Override
    public T select(T[] input, int i) {
        // TODO: FIXME i offset by one and general algorithm sometimes breaks
        return linearSelect(input, 0, input.length - 1, i + 1);
    }
}
