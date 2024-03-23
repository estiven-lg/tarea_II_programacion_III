package com.umg.programacioniiitareaii;

import com.umg.programacioniiitareaii.classes.Sorter;
import java.util.Arrays;
import java.util.Scanner;

public class ProgramacionIIITareaII {

    public static double[] parseArrayDouble(String[] strNums) {
        int n = strNums.length;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(strNums[i]);
        }
        return nums;
    }

    public static int[] parseArrayInt(String[] strNums) {
        int n = strNums.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        boolean exit = false;
        int option = -1;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Ingresa una serie de numeros separado por coma:");

            String[] strNums = input.nextLine().split(",");

            System.out.println("----que algorimo de ordenamiento deseas usar ?----\n\n");
            System.out.println("1.Selection sort (selección)");
            System.out.println("2.Bubble sort (burbuja)");
            System.out.println("3.Insertion sort (inserción)");
            System.out.println("4.Merge sort (combinación)");
            System.out.println("5.Quick sort (rápida)");
            System.out.println("6.Heap sort (montón)");
            System.out.println("7.Counting sort (conteo)");
            System.out.println("8.Radix sort (raíz)");
            System.out.println("9.Bucket sort (cubo)");
            System.out.println("0.salir");

            option = Integer.parseInt(input.next());
            input.nextLine();

            switch (option) {
                case 1 -> {
                    double[] sortList1 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Selection Sort :"+Arrays.toString(sortList1));
                }
                case 2 -> {
                    double[] sortList2 = Sorter.bubble(parseArrayDouble(strNums));
                    System.out.println("Bubble Sort :"+Arrays.toString(sortList2));
                }
                case 3 -> {
                    double[] sortList3 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Insertion Sort :"+Arrays.toString(sortList3));
                }

                case 4 -> {
                    double[] sortList4 = Sorter.merge(parseArrayDouble(strNums));
                    System.out.println("Merge Sort :"+Arrays.toString(sortList4));
                }
                case 5 -> {
                    double[] sortList5 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Quick Sort :"+Arrays.toString(sortList5));
                }
                case 6 -> {
                    double[] sortList6 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Heap Sort :"+Arrays.toString(sortList6));
                }
                case 7 -> {
                    double[] sortList7 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Counting Sort :"+Arrays.toString(sortList7));
                }
                case 8 -> {
                    double[] sortList8 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Radix Sort :"+Arrays.toString(sortList8));
                }
                case 9 -> {
                    double[] sortList9 = Sorter.insertion(parseArrayDouble(strNums));
                    System.out.println("Bucket Sort :"+Arrays.toString(sortList9));
                }
                default ->
                    exit = true;

            }

        } while (!exit);

    }
}
