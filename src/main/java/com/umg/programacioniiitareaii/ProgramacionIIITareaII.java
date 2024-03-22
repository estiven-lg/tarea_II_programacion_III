package com.umg.programacioniiitareaii;

import com.umg.programacioniiitareaii.classes.Sorter;

public class ProgramacionIIITareaII {

    public static void main(String[] args) {
        double[] numbers = {15.3,15.2, 156.5, 65.5, 98.5, 79.1,5};

        for (double i : Sorter.quick(numbers)) {
            System.out.println(i);
        }
    }
}
