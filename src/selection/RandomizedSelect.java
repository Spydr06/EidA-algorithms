package selection;

public class RandomizedSelect<T extends Comparable<T>> extends Selector<T> {
    private int randomizedPartition(T[] arr, int p, int r) {
        int rand = p + (int) (Math.random() * (r - p));
        T x = arr[rand];
        arr[rand] = arr[r];
        arr[r] = x;

        int i = p - 1;

        for(int j = p; j < r; j++) {
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

    private T randomizedSelect(T[] arr, int p, int r, int i) {
        if(p == r)
            return arr[p];

        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if(i == k)
            return arr[q];
        else if(i < k)
            return randomizedSelect(arr, p, q - 1, i);
        else
            return randomizedSelect(arr, q + 1, r, i - k);
    }

    @Override
    public T select(T[] input, int i) {
        // FIXME: i offset by 1
        return randomizedSelect(input, 0, input.length - 1, i + 1);
    }
}
