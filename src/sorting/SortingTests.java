package sorting;

import java.util.Arrays;

public class SortingTests {
    public static void main(String[] args) {
        int rangeMax = 100;

        Sorter<Integer>[] sorters = new Sorter[]{
                new InsertionSort<>(),
                new MergeSort<>(),
                new HeapSort<>(),
                new QuickSort<>(),
                new CountingSort(rangeMax),
                new RadixSort(new InsertionSort<>()),
        };

        for(Sorter<Integer> sorter : sorters) {
            Integer[] input = new Integer[10];
            for(int i = 0; i < input.length; i++)
                input[i] = (int) (Math.random() * 100);

            testSorter(sorter, input);
        }

        {
            BucketSort bucketSort = new BucketSort(new InsertionSort<>());
            Double[] input = new Double[10];
            for (int i = 0; i < input.length; i++)
                input[i] = Math.random();

            testSorter(bucketSort, input);
        }
    }

    static <T extends Comparable<T>> void testSorter(Sorter<T> sorter, T[] input) {
        System.out.println(sorter.getClass().getName() + ":");
        System.out.println("  Input: " + Arrays.toString(input));

        T[] output = sorter.sort(input);
        System.out.println("  Output: " + Arrays.toString(output));
        System.out.println("  Is Sorted: " + isSorted(output));
    }

    static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }
}
