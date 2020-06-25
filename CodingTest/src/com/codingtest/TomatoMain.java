package com.codingtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 7576 : 토마토
 */
public class TomatoMain {
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};
    static int[][] table;
    static int[][] dist;

    public static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        table = new int[n][m];
        dist = new int[n][m];

        Queue<Edge> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = scan.nextInt();
                dist[i][j] = -1;
                if (table[i][j] == 1) {
                    queue.add(new Edge(i, j));
                    dist[i][j] = 0;
                }
            }
        }


        bfs(queue, n, m);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result < dist[i][j]) {
                    result = dist[i][j];
                }
                if (table[i][j] == 0 && dist[i][j] == -1) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(Queue<Edge> queue, int n, int m) {
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + X[i];
                int ny = y + Y[i];
                if (0 <= nx && nx < n && 0 <= ny && m > ny) {
                    if (table[nx][ny] == 0 && dist[nx][ny] == -1) {
                        queue.offer(new Edge(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }
    }
}
