package com.codingtest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 7562 : 나이트의 이동
 */
public class MoveOfKnightMain {
    private static int[][] PATH = {{1,2}, {2,1}, {-1,2}, {-2,1}, {1,-2}, {2,-1}, {-1,-2}, {-2,-1}};
    private static int[][] depth;
    static class Edge {
        int x;
        int y;
        Edge (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- != 0) {
            int l = scan.nextInt();
            depth = new int[l][l];

            int sx = scan.nextInt();
            int sy = scan.nextInt();
            int dx = scan.nextInt();
            int dy = scan.nextInt();

            for (int i = 0; i < l; i++) {
                Arrays.fill(depth[i], -1);
            }

            Queue<Edge> queue = new LinkedList<>();
            queue.offer(new Edge(sx,sy));
            depth[sx][sy] = 0; //시작
            bfs(queue, l);
            System.out.println(depth[dx][dy]);
        }
    }

    public static void bfs(Queue<Edge> queue, int l) {
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int x = e.x;
            int y = e.y;
            for (int k = 0 ; k < 8; k ++) {
                int nx = x + PATH[k][0];
                int ny = y + PATH[k][1];
                if (nx >= 0 && nx < l && ny >=0 && ny < l) {
                    if (depth[nx][ny] == -1) {
                        depth[nx][ny] = depth[x][y] + 1;
                        queue.add(new Edge(nx, ny));
                    }
                }
            }
        }
    }
}
