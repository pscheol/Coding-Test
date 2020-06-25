package com.codingtest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        /*int length = a.length;

        for (int i = 0; i < d; i++) {
            int tmp = a[0];
            for (int j = 0; j< length-1; j++) {
                a[j] = a[j+1];
            }
            a[length- 1] = tmp;
            return a;
        }*/

        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = a.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(a, d, rotated, 0,n-d);
        System.arraycopy(a, 0, rotated, n - d, d);
        return rotated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        /*String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }*/

        int[] a = {1,2,3,4,5};
        int d = 4;
        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

