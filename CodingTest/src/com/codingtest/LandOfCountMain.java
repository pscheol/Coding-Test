package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 4963 섬의 개수
 */
public class LandOfCountMain {
    private static int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};

    private static int[][] table;
    private static boolean[][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] splitWH = in.readLine().split(" ");
            int weight = Integer.parseInt(splitWH[0]);
            int height = Integer.parseInt(splitWH[1]);
            if (weight == 0 && height == 0) {
                break;
            }

            table = new int[height][weight];
            check = new boolean[height][weight];
            for (int i = 0; i < height; i++) {
                String[] splitV = in.readLine().split(" ");
                for (int j = 0; j < splitV.length; j++) {
                    table[i][j] = Integer.parseInt(splitV[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < weight; j++) {
                    if (table[i][j] == 1 && !check[i][j]) {
                        dfs(i, j, height, weight);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int h, int w, int height, int weight) {
        check[h][w] = true;
        for (int k = 0; k < 8; k++) {
            int nh = h + X[k];
            int nw = w + Y[k];
            if (0 <= nh && nh < height && 0 <= nw && nw < weight) {
                if (table[nh][nw] == 1 && !check[nh][nw]) {
                    dfs(nh, nw, height, weight);
                }
            }
        }
    }
}
