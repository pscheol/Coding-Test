package com.codingtest;

import java.util.Scanner;

/**
 * 15649 : N 과 M (1)
 */
public class NMOf1 {
    static boolean[] check = new boolean[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        sol(0, n, m);
    }

    public static void sol(int idx, int n , int m) {
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
        for (int i = 1; i <= n; i++) {
            if (check[i]) continue;
            check[i] = true;
            a[idx] = i;
            sol(idx + 1, n, m);
            check[i] = false;
        }
    }
}
