package com.amit.javaPractise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Leetcode-4 : Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).boxed().collect(Collectors.toList());
        int len = mergedList.size();
        Collections.sort(mergedList);
        int i = len / 2;
        if (len % 2 == 0) {
            return (double) (mergedList.get(i - 1) + mergedList.get(i)) / 2;
        } else {
            return mergedList.get((i));
        }
    }
}
