package com.codingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DynamicMain {
    private static final long MOD = 1000000009L;
    private static final int LENGTH = 100000;
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        /*long[][] dp = plus123_5();
        while (t-- != 0) {
            int n = Integer.parseInt(in.readLine());
            out.write("" + (dp[n][1] + dp[n][2] + dp[n][3]) % MOD);
            out.write("\n");
            out.flush();
        }*/

        String[] split = in.readLine().split(" ");
        int[] a = new int[t];
        for (int i = 0; i < split.length; i++) {
            a[i] = Integer.parseInt(split[i]);
        }
        out.write("" + continuitySum(a));
        out.flush();
        in.close();
        out.close();
    }

    public static long continuitySum(int[] a) {
        long[] dp = new long[a.length];
        long result = dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i-1] + a[i], a[i]);
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
    public static int lis(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < (dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = -1;
        for (int i = 0; i< dp.length; i++) {
            if (result < dp[i]) {
                result = dp[i];

            }
        }
        return result;
    }

    public static long[][] plus123_5() {
        long[][] dp = new long[LENGTH + 1][4];
        for (int i = 1; i <= LENGTH; i++) {
            dp[i][1] = (i == 1) ? 1 : (dp[i-1][2] + dp[i-1][3]) % MOD;

            if (i - 2 >= 0) {
                dp[i][2] = (i == 2) ? 1 : (dp[i-2][1] + dp[i-2][3]) % MOD;
            }
            if (i - 3 >= 0) {
                dp[i][3] = (i == 3) ? 1 : (dp[i-3][1] + dp[i-3][2]) % MOD;
            }
        }
        return dp;
    }

    public static int makeNumberOne(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i / 2] + (i % 2), dp[i / 3] + (i % 3)) + 1;
        }
        return dp[n];
    }

    public static int plus123(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3 && i - j >= 0; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public static int card(int n, int[] a) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + a[j]);
            }
        }
        return dp[n];
    }
}
