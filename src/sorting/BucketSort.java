package sorting;

import java.util.LinkedList;
import java.util.List;

public class BucketSort extends RangedSorter<Double> {
    Sorter<Double> baseSorter;

    public BucketSort(Sorter<Double> baseSorter) {
        super(0.0, 1.0);
        this.baseSorter = baseSorter;
    }

    @Override
    public Double[] sort(Double[] arr) {
        int n = arr.length;
        List<Double>[] b = new LinkedList[n];

        for(int i = 0; i < n; i++)
            b[i] = new LinkedList<>();

        for(int i = 0; i < n; i++)
            b[(int) Math.floor((double) n * arr[i])].add(arr[i]);

        Double[] c = new Double[n];
        int j = 0;

        for(int i = 0; i < n; i++) {
            Double[] d = b[i].toArray(new Double[0]);
            d = baseSorter.sort(d);
            System.arraycopy(d, 0, c, j, d.length);
            j += d.length;
        }

        return c;
    }
}
