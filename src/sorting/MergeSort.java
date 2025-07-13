package sorting;

public class MergeSort <T extends Comparable<T>> extends Sorter<T> {
    private void merge(T[] arr, int p, int q, int r) {
        int nl = q - p + 1;
        int nr = r - q;

        T[] ll = (T[]) new Comparable[nl];
        T[] lr = (T[]) new Comparable[nr];

        for(int i = 0; i < nl; i++)
            ll[i] = arr[p + i];
        for(int j = 0; j < nr; j++)
            lr[j] = arr[q + j + 1];

        int i = 0;
        int j = 0;
        int k = p;

        while(i < nl && j < nr) {
            if(ll[i].compareTo(lr[j]) <= 0) {
                arr[k] = ll[i];
                i++;
            }
            else {
                arr[k] = lr[j];
                j++;
            }
            k++;
        }

        while(i < nl) {
            arr[k] = ll[i];
            i++;
            k++;
        }

        while(j < nr) {
            arr[k] = lr[j];
            j++;
            k++;
        }
    }

    private void mergeSort(T[] arr, int p, int r) {
        if(p >= r)
            return;

        int q = (int) Math.floor((double) (p + r) / 2);
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    @Override
    public T[] sort(T[] input) {
        mergeSort(input, 0, input.length - 1);
        return input;
    }
}
