package com.codingtest;

import java.util.Scanner;

/**
 * 날짜계산 1476
 */
public class CalcDateMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e = scan.nextInt() - 1;
        int s = scan.nextInt() - 1;
        int m = scan.nextInt() - 1;
        for (int i = 0; ; i++) {
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
