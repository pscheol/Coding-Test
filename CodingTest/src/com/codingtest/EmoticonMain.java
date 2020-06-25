package com.codingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 14226 : 이모티콘
 */
public class EmoticonMain {
    static int[][] dist;

    static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();

        dist = new int[S + 1][S + 1];
        for (int i = 0; i <= S; i++) {
            Arrays.fill(dist[i], -1);
        }

        bfs(S);

        int ans = -1;
        for (int i = 0; i <= S; i++) {
            if (dist[S][i] != -1 && ans == -1 || ans > dist[S][i]) {
                ans = dist[S][i];
            }
        }
        System.out.println(ans);
    }

    /**
     * @param S
     */
    public static void bfs(int S) {
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(1, 0));
        dist[1][0] = 0;

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int s = e.x;
            int c = e.y;
            if (dist[s][s] == -1) {
                dist[s][s] = dist[s][c] + 1;
                queue.add(new Edge(s, s));
            }
            if (s + c <= S && dist[s + c][c] == -1) {
                dist[s + c][c] = dist[s][c] + 1;
                queue.add(new Edge(s + c, c));
            }
            if (s - 1 >= 0 && dist[s - 1][c] == -1) {
                dist[s - 1][c] = dist[s][c] + 1;
                queue.add(new Edge(s - 1, c));
            }
        }
    }
}
