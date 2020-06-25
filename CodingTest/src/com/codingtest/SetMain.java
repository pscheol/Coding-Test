package com.codingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 11723 : 집합
 *
 */
public class SetMain {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 20;
        int m = Integer.parseInt(in.readLine());
        int s = 0;
        while(m-- != 0) {
            String[] split = in.readLine().split(" ");
            int x = 0;
            if (split.length != 1)
                x = Integer.parseInt(split[1]) - 1;

            switch (split[0]) {
                case "add":
                    s = s | (1 << x);
                    break;
                case "remove":
                    s = s & ~(1 << x);
                    break;
                case "check":
                    int check = s & (1 << x);
                    out.write(((check == 0) ? 0 : 1)+"\n");
                    break;
                case "toggle":
                    s = s ^ (1 << x);
                    break;
                case "all":
                    s = (s << n) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        out.flush();
        in.close();;
        out.close();

    }
}
