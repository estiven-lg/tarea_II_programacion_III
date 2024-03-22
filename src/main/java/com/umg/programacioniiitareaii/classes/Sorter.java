package com.umg.programacioniiitareaii.classes;

import java.util.Arrays;

public class Sorter {

  

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
}
