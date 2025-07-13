package sorting;

public class QuickSort <T extends Comparable<T>> extends Sorter<T> {
    private int partition(T[] arr, int p, int r) {
        T x = arr[r];
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

    public void quickSort(T[] arr, int p, int r) {
        if(p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    @Override
    public T[] sort(T[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }
}
