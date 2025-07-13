package sorting;

public class CountingSort extends RangedSorter<Integer> {
    public CountingSort(int max) {
        super(0, max);
    }

    @Override
    public Integer[] sort(Integer[] arr) {
        int k = super.getRangeMax() - super.getRangeMin();
        int n = arr.length;

        Integer[] b = new Integer[n];
        int[] c = new int[k + 1];

        for(int i = 0; i <= k; i++)
            c[i] = 0;

        for(int j = 0; j < n; j++)
            c[arr[j]]++;

        for(int i = 1; i <= k; i++)
            c[i] = c[i] + c[i - 1];

        for(int j = n - 1; j >= 0; j--) {
            b[c[arr[j]] - 1] = arr[j];
            c[arr[j]]--;
        }

        return b;
    }
}
