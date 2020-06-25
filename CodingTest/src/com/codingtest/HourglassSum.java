package com.codingtest;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class HourglassSum {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[] sum = new int[16];
        int result = 0;
        int k = 0;
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                sum[k] = arr[y - 1][x - 1] + arr[y-1][x] + arr[y - 1][x + 1];
                sum[k] += arr[y][x];
                sum[k] += arr[y + 1][x - 1] + arr[y + 1][x] + arr[y + 1][x + 1];
                k++;

            }
        }

        result = sum[0];
        for (int i = 1; i < sum.length; i++) {
            result = Math.max(result, sum[i]);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        /*int[][] arr = new int[][] {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4 ,0}
        };*/

        /*int[][] arr = new int[][] {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };*/

        int[][] arr = new int[][] {
                {3, 7, -3, 0, 1, 8},
                {1, -4, -7, -8, -6, 5},
                {-8, 1, 3, 3, 5, 7},
                {-2, 4, 3, 1, 2, 7},
                {2, 4, -5, 1, 8, 4},
                {5, -7, 6, 5, 2, 8}
        };

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
