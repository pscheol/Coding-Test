package com.codingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Plus123 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- != 0) {
            int n = Integer.parseInt(reader.readLine());
            int dp[] = new int[n+1];
            dp[0] = 1;
            for (int i = 1;  i <= n; i++) {
                for (int j = 1; j <= 3 && i-j >= 0; j++) {
                    dp[i] += dp[i-j];
                }
            }
            System.out.println(dp[n]);

        }
    }

}
