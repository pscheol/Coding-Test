package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoDots {
    private static char[][] dotTable;
    private static final int[][] PATH = { {0,1}, {1,0}, {0,-1}, {-1,0} };
    private static int[][] dist;
    private static boolean[][] CHECK;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nmLine = in.readLine().split(" ");
        int n = Integer.parseInt(nmLine[0]);
        int m = Integer.parseInt(nmLine[1]);
        CHECK = new boolean[n][m];
        dotTable = new char[n][m];
        for (int i = 0 ; i < n; i++) {
            String line = in.readLine();
            for (int j = 0; j < m; j++) {
                dotTable[i][j] = line.charAt(j);
            }
        }

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (CHECK[i][j]) continue;
                dist = new int[n][m];
                if (dfs(i,j, n, m, 1, dotTable[i][j])) {
                    for (int a = 0 ; a < n; a++) {
                        for (int b = 0; b < m; b++) {
                            System.out.print(dist[a][b]);
                        }
                        System.out.println();
                    }
                    System.out.println("YES");
                    return;
                }

            }
        }
        System.out.println("NO");
    }
    public static boolean dfs(int i, int j, int n, int m, int cnt, char color) {
        if (CHECK[i][j]) {
            if (cnt - dist[i][j] >= 4)
                return true;
            else
                return false;
        }
        CHECK[i][j] = true;
        dist[i][j] = cnt;

        for (int k = 0; k < 4; k++) {
            int x = i + PATH[k][0];
            int y = j + PATH[k][1];
            if (0 <= x && x < n && 0 <= y && y < m) {
                if (dotTable[x][y] == color) {
                    if (dfs(x, y, n, m, cnt+1, color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
