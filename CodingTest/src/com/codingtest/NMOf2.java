package com.codingtest;

import java.util.Scanner;

/**
 * 15650 : N 과 M (2)
 */
public class NMOf2 {
    static boolean[] check = new boolean[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        sol(0, 1, n, m);
    }

    public static void sol(int idx, int start, int n , int m) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i]);
                if (i != m - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            if (check[i]) continue;
            check[i] = true;
            a[idx] = i;
            sol(idx + 1, i+1, n, m);
            check[i] = false;
        }
    }
}
