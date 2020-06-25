package com.codingtest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 15655 : N 과 M (6)
 */
public class NMOf6 {
    static boolean[] check = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }
        Arrays.sort(num, 0, n);
        System.out.print(go(0,0,n,m));
    }

  public static String go(int idx, int start, int n ,int m) {
    if (idx == m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < m; i ++) {
            sb.append(num[a[i]]);
            if (i != m-1) sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }
    StringBuilder sb = new StringBuilder();
    for (int i = start; i < n; i++) {
        if (check[i]) continue;;
        check[i] = true;
        a[idx] = i;
        sb.append(go(idx+1, i+1, n,m));
        check[i] = false;
    }
    return sb.toString();
  }
}
