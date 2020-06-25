package com.codingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeOfOne {
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 0;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + 1;
            if (i % 2 == 0 && table[i] > table[i / 2] + 1) {
                table[i] = table[i / 2] + 1;
            }
            if (i % 3 == 0 && table[i] > table[i / 3] + 1) {
                table[i] = table[i / 3] + 1;
            }
        }
        out.write("" + table[n]);
        out.flush();
        out.close();
        in.close();
    }
}
