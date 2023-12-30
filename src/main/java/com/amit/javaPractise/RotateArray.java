package com.amit.javaPractise;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
Leetcode-189 : Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int j = 1;
        int len = nums.length;
        int temp;
        while (j <= k) {
            temp = nums[len - 1];
            IntStream.iterate(len - 1, i -> i > 0, i -> i - 1).forEach(i -> nums[i] = nums[i - 1]);
            nums[0] = temp;
            j++;
        }
    }
}

