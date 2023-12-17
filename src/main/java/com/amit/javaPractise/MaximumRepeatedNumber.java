package com.amit.javaPractise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Find maximum repeated number in an array using one for loop

 */
public class MaximumRepeatedNumber {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 5, 6, 6, 6, 6, 6, 8, 5, 9, 1, 7, 1};
        int max = 0;
        int maxNum = 0;
        int maxTemp;
        //To convert int[] array to Integer List
        List<Integer> list = Arrays.stream(a).boxed().toList();
        for (Integer i : list) {
            maxTemp = Collections.frequency(list, i);
            if (max <= maxTemp) {
                max = maxTemp;
                maxNum = i;
            }
        }
        System.out.println(maxNum);


    }
}
