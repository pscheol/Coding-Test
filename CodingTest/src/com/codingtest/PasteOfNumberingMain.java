package com.codingtest;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2667 : 단지번호 붙이기
 */
public class PasteOfNumberingMain {
    static int[][] table;
    static int[][] dist;
    static int ret = 0;
    static int[][] path = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        table = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] splitLine = in.readLine().split("");
            for (int j = 0; j < splitLine.length; j++) {
                table[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && dist[i][j] == 0) {
                    ret = 0;
                    bfs(i, j, n, ++cnt);
                    list.add(ret);
                }
            }
        }
        list.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        sb.append("\n");
        list.sort(Integer::compareTo);
        for (Integer i : list) {
            sb.append(i);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        in.close();
    }

    static class Edge {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int i , int j, int n ,int cnt) {
        Queue<Edge> queue = new LinkedList<>();
        dist[i][j] = cnt;
        ret++;
        queue.offer(new Edge(i, j));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = e.x + path[k][0];
                int ny = e.y + path[k][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (table[nx][ny] == 1 && dist[nx][ny] == 0) {
                        dist[nx][ny] = cnt;
                        ret++;
                        queue.offer(new Edge(nx,ny));
                    }
                }
            }
        }

    }
    public static void dfs(int i, int j, int n, int cnt) {
        dist[i][j] = cnt;
        ret++;
        for (int k = 0; k < 4; k++) {
            int nx = i + path[k][0];
            int ny = j + path[k][1];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (table[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dfs(nx, ny ,n, cnt);
                }
            }
        }
    }
}
