package com.codingtest;

import java.util.Arrays;

public class MinAbsSum {
    public static void main(String[] args) {
        MinAbsSum m = new MinAbsSum();
        int[] a = {-2,1, 2, 5};
        System.out.println(m.solution(a));
    }

    public int solution(int[] A) {
        final int n = A.length;
        if (n == 0) {
            return 0;
        }

        final int[] abs = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            abs[i] = Math.abs(A[i]);
            max = Math.max(max, abs[i]);
            sum += abs[i];
        }

        int[] counts = new int[max + 1];
        for (int i = 0; i < n; i++) {
            counts[abs[i]] = counts[abs[i]] + 1;
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < max; i++) {
            final int count = counts[i];
            if (count > 0) {
                for (int j = 0; j <= sum; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = count;
                    } else if (j >= i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }

        int result = sum;
        for (int i = 0, limit = sum / 2+1; i < limit; i++) {
            if (dp[i] >= 0) {
                result = Math.min(result, sum -2 * i);
            }
        }
        return result;
    }
}
