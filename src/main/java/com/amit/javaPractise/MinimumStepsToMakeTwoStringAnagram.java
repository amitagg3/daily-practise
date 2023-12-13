package com.amit.javaPractise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
