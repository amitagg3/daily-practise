package com.amit.javaPractise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Leetcode-1347 : Minimum Number of Steps to Make Two Strings Anagram

You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 */

public class MinimumStepsToMakeTwoStringAnagram {

    public static void main(String[] args) {
        String s = "leetcode", t = "practice";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();
        //Creating list of character from string
        List<Character> ls = s.chars().mapToObj(e -> (char) e).toList();
        List<Character> lt = t.chars().mapToObj(e -> (char) e).toList();

        // Storing values of one string and decreasing the value of other if it exists
        for (int i = 0; i < t.length(); i++) {
            hm.put(lt.get(i), hm.getOrDefault(lt.get(i), 0) + 1);
            hm.put(ls.get(i), hm.getOrDefault(ls.get(i), 0) - 1);
        }
        //count all the positive values
        return hm.values().stream().filter(e -> e > 0).mapToInt(Integer::intValue).sum();
    }
}
