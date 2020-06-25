package com.codingtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 1697 : 숨바꼭질
 * 13913 : 숨바꼭질 4
 */
public class HideAndSeekMain {
    public static final int MAX = 100001;
    public static int[] dist;
    public static boolean[] chk;
    public static int[] logs = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        dist = new int[MAX];
        chk = new boolean[MAX];
        dist[n] = 0;
        chk[n] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        bfs(queue);
        System.out.println(dist[k]);
        // 13913 숨바꼭질 4 start
        Stack<Integer> stack = new Stack<>();
        for (int i = k; i != n; i = logs[i]) {
            stack.push(i);
        }
        stack.push(n);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        // 13913 숨바꼭질 4 End
    }

    public static void bfs(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int now = queue.poll();
            compare(queue, now, now - 1);
            compare(queue, now, now + 1);
            compare(queue, now, now * 2);
        }
    }

    private static void compare(Queue<Integer> queue, int from, int to) {
        if (to >= 0 && to < MAX && !chk[to]) {
            queue.offer(to);
            chk[to] = true;
            logs[to] = from;
            dist[to] = dist[from] + 1;
        }
    }
}
