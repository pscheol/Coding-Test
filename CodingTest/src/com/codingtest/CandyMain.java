package com.codingtest;

import java.util.Scanner;

/**
 * 3085 사탕게임
 */
public class CandyMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.next().toCharArray();
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swap(a, i, j, 'R');
                    int tmp = check(a);
                    if (ans < tmp)
                        ans = tmp;
                    swap(a, i, j, 'R');
                }
                if (i + 1 < n) {
                    swap(a, i, j, 'C');
                    int tmp = check(a);
                    if (ans < tmp)
                        ans = tmp;
                    swap(a, i, j, 'C');
                }
            }
        }
        System.out.println(ans);
    }

    static void swap(char[][] a, int i, int j, char type) {
        char t = a[i][j];
        if (type == 'R') {
            a[i][j] = a[i][j + 1];
            a[i][j + 1] = t;
        } else if (type == 'C') {
            a[i][j] = a[i + 1][j];
            a[i + 1][j] = t;
        }
    }

    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = (a[i][j] == a[i][j - 1]) ? cnt + 1 : 1;
                if (ans < cnt)
                    ans = cnt;
            }
            cnt = 1;
            for (int j = 1; j < n; j++) {
                cnt = (a[j][i] == a[j - 1][i]) ? cnt + 1 : 1;
                if (ans < cnt)
                    ans = cnt;
            }
        }
        return ans;
    }
}
