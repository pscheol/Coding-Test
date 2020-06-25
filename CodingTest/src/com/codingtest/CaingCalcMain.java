package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 6064 카잉달력
 */
public class CaingCalcMain {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- != 0) {
            String[] split = in.readLine().split(" ");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            int x = Integer.parseInt(split[2]) - 1;
            int y = Integer.parseInt(split[3]) - 1;
            boolean isOk = false;
            for (int i = x; i < (n * m); i += m) {
                if (i % n == y) {
                    System.out.println(i + 1);
                    isOk = true;
                    break;
                }
            }
            if (!isOk) {
                System.out.println(-1);
            }
        }
        in.close();
    }
}
