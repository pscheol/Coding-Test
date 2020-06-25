package com.codingtest;

import java.util.Scanner;

/**
 * 1748 수 이어쓰기 1
 */
public class LinkNumberOfWriteMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long ans = 0;
        for (int s = 1, len = 1; s<=n; s*=10, len++) {
            int e = s * 10 - 1;
            if (e > n) {
                e = n;
            }
            ans += (long)(e - s + 1) * len;
        }
        System.out.println(ans);
    }
}
