package com.umg.programacioniiitareaii.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {

    public static double[] selection(double[] numbers) {

        for (int I = 0; I < numbers.length; I++) {
            double temp = numbers[I];
            int minPosition = I;

            for (int II = I; II < numbers.length; II++) {
                if (numbers[II] < numbers[minPosition]) {
                    minPosition = II;
                }
            }

            numbers[I] = numbers[minPosition];
            numbers[minPosition] = temp;
        }
        return numbers;

    }

    public static double[] bubble(double[] numbers) {
        for (int I = numbers.length - 1; I > 0; I--) {
            for (int II = 0; II < I; II++) {
                double rightNum = numbers[II], leftNum = numbers[II + 1];
                if (rightNum > leftNum) {
                    numbers[II] = leftNum;
                    numbers[II + 1] = rightNum;
                }
            }
        }
        return numbers;
    }

    public static double[] insertion(double[] numbers) {
        for (int I = 1; I < numbers.length; I++) {
            for (int II = I; II > 0; II--) {
                double rightNum = numbers[II - 1], leftNum = numbers[II];
                if (leftNum < rightNum) {
                    numbers[II - 1] = leftNum;
                    numbers[II] = rightNum;
                }

            }
        }
        return numbers;
    }

    private static List<Double> insertion(List<Double> numbers) {
        for (int I = 1; I < numbers.size(); I++) {
            for (int II = I; II > 0; II--) {
                double rightNum = numbers.get(II - 1), leftNum = numbers.get(II);
                if (leftNum < rightNum) {
                    numbers.set(II - 1, leftNum);
                    numbers.set(II, rightNum);
                }

            }
        }
        return numbers;
    }

    public static double[] merge(double[] numbers) {
        int n = numbers.length;

        if (n == 1) {
            return numbers;
        }

        if (n == 2) {
            double leftNum = numbers[0], rightNum = numbers[1];
            if (leftNum > rightNum) {
                numbers[0] = rightNum;
                numbers[1] = leftNum;
            }

            return numbers;
        }

        int halfPoint = (int) Math.ceil(n / 2.0);

        double[] leftArray = Sorter.merge(Arrays.copyOfRange(numbers, 0, halfPoint));
        double[] rightArray = Sorter.merge(Arrays.copyOfRange(numbers, halfPoint, n));

        int l = 0, r = 0, i = 0;

        while (l < leftArray.length || r < rightArray.length) {

            if (l == leftArray.length) {
                numbers[i] = rightArray[r];
                r++;
                i++;
                continue;
            }

            if (r == rightArray.length) {
                numbers[i] = leftArray[l];
                l++;
                i++;
                continue;
            }

            if (leftArray[l] <= rightArray[r]) {
                numbers[i] = leftArray[l];
                l++;
                i++;
                continue;
            }

            if (rightArray[r] <= leftArray[l]) {
                numbers[i] = rightArray[r];
                r++;
                i++;
                continue;
            }
        }

        return numbers;
    }

    public static double[] quick(double[] numbers) {
        int n = numbers.length;

        if (n < 1) {
            return numbers;
        }

        if (n == 2) {
            double leftNum = numbers[0], rightNum = numbers[1];
            if (leftNum > rightNum) {
                numbers[0] = rightNum;
                numbers[1] = leftNum;
            }

            return numbers;
        }

        int pivotPosition = 0;
        double pivot = numbers[(n - 1)];

        for (int I = 0; I < (n - 1); I++) {
            if (numbers[I] < pivot) {
                if (I != 0) {

                    double tmp = numbers[I];
                    numbers[I] = numbers[I - 1];
                    numbers[I - 1] = tmp;
                }
                pivotPosition++;
            }
        }

        double[] sorterLeft = Sorter.quick(Arrays.copyOfRange(numbers, 0, pivotPosition));
        double[] sorterRight = Sorter.quick(Arrays.copyOfRange(numbers, pivotPosition, (n - 1)));
        int i = 0;
        for (double Li : sorterLeft) {
            numbers[i] = Li;
            i++;
        }

        numbers[i] = pivot;
        i++;

        for (double Ri : sorterRight) {
            numbers[i] = Ri;
            i++;
        }
        return numbers;
    }

    private static double[] heapify(double numbers[], int n, int i) {

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && numbers[l] > numbers[largest]) {
            largest = l;
        }

        if (r < n && numbers[r] > numbers[largest]) {
            largest = r;
        }

        if (largest != i) {
            double swap = numbers[i];
            numbers[i] = numbers[largest];
            numbers[largest] = swap;

            heapify(numbers, n, largest);
        }
        return numbers;
    }

    public static double[] heap(double[] numbers) {
        int n = numbers.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            numbers = heapify(numbers, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            double temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;

            numbers = heapify(numbers, i, 0);
        }
        return numbers;

    }

    public static int[] count(int[] numbers) {
        int N = numbers.length;
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        int[] countArray = new int[max + 1];

        for (int i = 0; i < N; i++) {
            countArray[numbers[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[numbers[i]] - 1] = numbers[i];
            countArray[numbers[i]]--;
        }

        return outputArray;
    }

    static public int[] radix(int numbers[]) {
        int n = numbers.length;
        int max = numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        for (int III = 1; max / III > 0; III *= 10) {
            for (int II = 0; II < n - 1; II++) {

                int min_idx = II;
                for (int I = II + 1; I < n; I++) {
                    if (numbers[I] / III < numbers[min_idx] / III) {
                        min_idx = I;
                    }
                }

                int temp = numbers[min_idx];
                numbers[min_idx] = numbers[II];
                numbers[II] = temp;
            }
        }
        return numbers;
    }

    public static double[] bucket(double[] numbers) {
        int n = numbers.length;
        int max = (int) numbers[0];
        for (int i = 1; i < n; i++) {
            if (numbers[i] > max) {
                max = (int) numbers[i];
            }
        }

        int divisor = (int) Math.pow(10, Math.log10(max) + 1);

        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bi = (int) (n * (numbers[i] / divisor));
            buckets[bi].add(numbers[i]);
        }

        for (int i = 0; i < n; i++) {
            buckets[i] = Sorter.insertion(buckets[i]);
        }

        // 4) Concatenate all buckets into numbers[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                numbers[index++] = buckets[i].get(j);
            }
        }
        return numbers;
    }
}
