package com.amit.javaPractise;

import java.math.BigInteger;

public class MultiplyTwoStrings {

    public static void main(String[] args) {
        String num1 = "498828660196";
        String num2 = "840477629533";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        BigInteger bg = new BigInteger(num1);
        BigInteger bg1 = new BigInteger(num2);
        return String.valueOf(bg.multiply(bg1));
    }
}
