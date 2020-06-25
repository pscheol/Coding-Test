package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1261번 : 알고스팟
 */
public class AlgoSpotMain {
    static int[][] table;
    static int[][] dist;
    static int[][] path = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Edge {
        int x;
        int y;
        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] splitNM = in.readLine().split(" ");
        int m = Integer.parseInt(splitNM[0]);
        int n = Integer.parseInt(splitNM[1]);
        table = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] splitV = in.readLine().split("");
            for (int j = 0; j < m; j++) {
                table[i][j] = Integer.parseInt(splitV[j]);
            }
        }
        in.close();
        Queue<Edge> queue = new LinkedList<>();
        Queue<Edge> next_queue = new LinkedList<>();
        queue.offer(new Edge(0, 0));
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        bfs(queue, next_queue, n, m);

        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dist[n - 1][m - 1]);
    }

    public static void bfs(Queue<Edge> queue, Queue<Edge> next_queue, int n, int m) {
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + path[k][0];
                int ny = y + path[k][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (dist[nx][ny] == -1) {
                        if (table[nx][ny] == 0) {
                            dist[nx][ny] = dist[x][y];
                            queue.offer(new Edge(nx, ny));
                        } else {
                            dist[nx][ny] = dist[x][y] + 1;
                            next_queue.offer(new Edge(nx, ny));
                        }
                    }
                }
            }
            if (queue.isEmpty()) {
                queue = next_queue;
                next_queue = new LinkedList<>();
            }
        }
    }
}