package com.amit.javaPractise;

import java.util.Arrays;

/*
Consider a big party where N guests came to it and a log register for guest’s entry and exit times was maintained. Find the minimum time at which there were maximum guests at the party. Note that entries in the register are not in any order.

Note: Guests are leaving after the exit times.

Input: N = 5
Entry= {1, 2,10, 5, 5}
Exit = {4, 5, 12, 9, 12}
Output: 3 5
Explanation: At time 5 there were guest number 2, 4 and 5 present.

Input: N = 7
Entry= {13, 28, 29, 14, 40, 17, 3}
Exit = {107, 95, 111, 105, 70, 127, 74}
Output: 7 40
Explanation: At time 40 there were all 7 guests present in the party.
 */
public class MaximumIntervalsOverlap {
    public static void main(String[] args) {
        int N = 5;
        int[] entry = {1, 2, 10, 5, 5};
        int[] exit = {4, 5, 12, 9, 12};
        System.out.println((Arrays.toString(findMaxGuests(entry, exit, N))));
    }

    public static int[] findMaxGuests(int[] Entry, int[] Exit, int N) {
        Arrays.sort(Entry);
        Arrays.sort(Exit);
        int ansTime = 0, mxCount = 0, count = 0;
        int i = 0, j = 0;
        while (i < N && j < N) {
            if (Entry[i] <= Exit[j]) {
                count++;
                if (count > mxCount) {
                    mxCount = count;
                    ansTime = Entry[i];
                }
                i++;
            } else {
                count--;
                j++;
            }
        }
        return new int[]{mxCount, ansTime};
    }
}
