package sorting;

public class HeapSort <T extends Comparable<T>> extends Sorter<T> {
    int heapSize = 0;

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void maxHeapify(T[] arr, int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;

        if(l < heapSize && arr[l].compareTo(arr[i]) > 0)
            largest = l;
        if(r < heapSize && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        if(largest != i) {
            T tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, largest);
        }
    }

    private void buildMaxHeap(T[] arr) {
        heapSize = arr.length;
        for(int i = (heapSize - 1) / 2; i >= 0; i--)
            maxHeapify(arr, i);
    }

    @Override
    public T[] sort(T[] input) {
        buildMaxHeap(input);

        for(int i = input.length - 1; i > 0; i--) {
            T tmp = input[i];
            input[i] = input[0];
            input[0] = tmp;

            heapSize--;
            maxHeapify(input, 0);
        }

        return input;
    }
}
