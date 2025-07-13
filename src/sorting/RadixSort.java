package sorting;

public class RadixSort extends RangedSorter<Integer> {
    public class Digits implements Comparable<Digits> {
        int value;

        private Digits(int value) {
            this.value = value;
        }

        private int getDigit() {
            return (this.value / (int) Math.pow(10, currentDigit)) % 10;
        }

        private int getValue() {
            return this.value;
        }

        @Override
        public int compareTo(Digits o) {
            return Integer.signum(this.getDigit() - o.getDigit());
        }
    }

    private int currentDigit;
    private final Sorter<Digits> baseSorter;

    public RadixSort(Sorter<Digits> baseSorter) {
        super(0, Integer.MAX_VALUE);
        this.baseSorter = baseSorter;
    }

    private int maxDigits(Integer[] arr) {
        int max = 0;
        for(Integer i : arr) {
            int d = (int) (Math.log10(i) + 1);
            if(d > max)
                max = d;
        }
        return max;
    }

    @Override
    public Integer[] sort(Integer[] input) {
        int d = maxDigits(input);
        int n = input.length;

        Digits[] digits = new Digits[n];
        for(int i = 0; i < n; i++)
            digits[i] = new Digits(input[i]);

        for(currentDigit = 0; currentDigit < d; currentDigit++) {
            digits = baseSorter.sort(digits);
        }

        Integer[] output = new Integer[n];
        for(int i = 0; i < n; i++)
            output[i] = digits[i].getValue();

        return output;
    }
}
