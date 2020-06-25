package com.codingtest;

import java.util.*;

/**
 * 11724 연결요소
 */
public class ConnectedComponentMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //정점의 개수
        int m = scan.nextInt(); //간선의 개수

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] check = new boolean[n+1];
        int cnt = 0;
        for (int i = 1 ; i <= n; i ++) {
            if(!check[i]) {
                bfs(adjList, check, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    /**
     * DFS
     * @param adjList
     * @param check
     * @param v
     */
    public static void dfs(List<List<Integer>> adjList, boolean[] check, int v) {
        if (check[v]) {
            return;
        }
        check[v] = true;
        for (Integer vertex : adjList.get(v)) {
            if (!check[vertex]) {
                dfs(adjList, check, vertex);
            }
        }
    }

    /**
     * BFS
     * @param adjList
     * @param check
     * @param v
     */
    public static void bfs(List<List<Integer>> adjList, boolean[] check, int v) {
        Queue<Integer> queue = new LinkedList<>();
        check[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int dequeue = queue.poll();
            for (int vertex : adjList.get(dequeue)) {
                if (!check[vertex]) {
                    check[vertex] = true;
                    queue.offer(vertex);
                }
            }
        }
    }
}
