package com.codingtest;

import java.util.*;

public class BruteForceMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            a[i] = scan.nextInt();
            sum += a[i];
        }
        int[] result = dwarfOf7(a, sum);
        if (result == null) {
            return;
        }
        Arrays.sort(result);
        for (int i = 2 ;i <result.length; i++) {
            System.out.println(result[i]);

        }
    }

    public static int[] dwarfOf7(int a[], int sum) {
        for (int i =0 ; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (a[i] + a[j]) == 100) {
                    a[i] = a[j] = -1;
                    return a;
                }
            }
        }
        return null;
    }
}