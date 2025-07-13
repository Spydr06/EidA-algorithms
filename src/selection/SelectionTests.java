package selection;

import sorting.InsertionSort;

import java.util.Arrays;

public class SelectionTests {
    public static void main(String[] args) {
        Selector<Integer>[] selectors = new Selector[]{
                new RandomizedSelect<>(),
                new LinearSelect<>(new InsertionSort<Integer>()),
        };

        for(Selector<Integer> selector : selectors) {
            Integer[] input = new Integer[20];
            for(int i = 0; i < input.length; i++)
                input[i] = (int) (Math.random() * 100);

            System.out.println(selector.getClass().getName() + ":");
            System.out.println("  Input: " + Arrays.toString(input));

            int selectAt = (int) (Math.random() * input.length);
            System.out.println("  Select at: " + selectAt);

            Integer at = selector.select(input, selectAt);

            Integer[] sorted = new InsertionSort<Integer>()
                    .sort(input);

            System.out.println("  Sorted: " + Arrays.toString(sorted));

            if(sorted[selectAt].equals(at))
                System.out.println("  Entry is " + at);
            else
                System.out.println("  Got entry " + at + ", but expected " + sorted[selectAt]);
        }
    }
}
