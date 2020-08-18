package com.ttyc.thread.interview;

import java.util.Arrays;

public class BigSum {

    public static void main(String[] args) {
        String s1 = "123456789";
        String s2 = "4312453";

        String sum = sum(s1, s2);
        System.out.println("sum = " + sum);
    }

    private static String sum(String s1, String s2) {
        char[] arr1 = (new StringBuilder(s1)).reverse().toString().toCharArray();
        char[] arr2 = (new StringBuilder(s2)).reverse().toString().toCharArray();

        int length = Math.max(arr1.length, arr2.length);

        if(arr1.length < length) {
            arr1 = grow(arr1, length);
        }

        if(arr2.length < length) {
            arr2 = grow(arr2, length);
        }

        boolean over = false;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch1 = arr1[i];
            char ch2 = arr2[i];

            int sum = (ch1 - '0') + (ch2 - '0');
            if(over) {
                sum++;
            }
            if (sum > 10) {
                int mod = sum % 10;
                ret.append(mod);
                over = true;
            }else {
                ret.append(sum);
                over = false;
            }
        }
        return ret.reverse().toString();
    }

    private static char[] grow(char[] arr, int newSize) {
        int length = arr.length;
        char[] ret = Arrays.copyOf(arr, newSize);

        for (int i = length; i < newSize; i++) {
            ret[i] = '0';
        }
        return ret;
    }
}
