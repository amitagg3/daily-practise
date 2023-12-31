package com.amit.javaPractise;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int sub=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }else{
                count=1;
            }
            if(count>2){
                int j=i+1;
                int k=i;
                while(nums[i]<nums[j]) {
                    swapArray(nums, k, j);
                    count = 0;
                    k++;
                    j++;
                }
                sub++;
            }


        }
        System.out.println(Arrays.toString(nums));

        return nums.length-sub;
    }

    public static void swapArray(int[] nums,int start,int end){
        while(start<end-1){
            nums[start]=nums[++start];
        }

    }
}
