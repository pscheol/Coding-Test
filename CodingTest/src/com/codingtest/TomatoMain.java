package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 7576 : 토마토
 */
public class TomatoMain {
    public static final int[][] PATH = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int[][] table;
    public static int[][] dist;

    public static class Edge {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] MNLine = in.readLine().split(" ");
        int m = Integer.parseInt(MNLine[0]);
        int n = Integer.parseInt(MNLine[1]);
        table = new int[n][m];
        dist = new int[n][m];

        Queue<Edge> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(split[j]);
                table[i][j] = v;
                dist[i][j] = -1;
                if (v == 1) {
                    dist[i][j] = 0;
                    queue.offer(new Edge(i, j));
                }
            }
        }
        in.close();

        bfs(queue, n, m);

        int result = -1;
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
            for (int k = 0; k < 4; k++) {
                int nx = x + PATH[k][0];
                int ny = y + PATH[k][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (table[nx][ny] != -1 && dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.offer(new Edge(nx, ny));
                    }
                }
            }
        }
    }
}
