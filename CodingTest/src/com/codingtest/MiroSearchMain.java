package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2178 : 미로탐색
 */
public class MiroSearchMain {
    private static int[][] table;
    private static boolean[][] check;
    private static int[][] dist;
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};

    public static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] splitnm = in.readLine().split(" ");
        int n = Integer.parseInt(splitnm[0]);
        int m = Integer.parseInt(splitnm[1]);

        table = new int[n][m];
        check = new boolean[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] splitLine = in.readLine().split("");
            for (int j = 0; j < splitLine.length; j++) {
                table[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        bfs(n, m);
        System.out.println(dist[n - 1][m - 1]);
        in.close();
    }

    public static void bfs(int n, int m) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + X[k];
                int ny = y + Y[k];
                if (0 <= nx && n > nx && 0 <= ny && m > ny) {
                    if (table[nx][ny] == 1 && !check[nx][ny]) {
                        queue.offer(new Edge(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}
