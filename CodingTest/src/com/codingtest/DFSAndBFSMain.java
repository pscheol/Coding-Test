package com.codingtest;

import java.util.*;

/**
 * 1260 : DFS와 BFS
 */
public class DFSAndBFSMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //정점의 개수
        int m = scan.nextInt(); //간선의 개수
        int v = scan.nextInt(); //탐색을 시작할 정점의 번호

        //인접 리스트로 저장
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        dfs(adjList, stack, v);
        System.out.println();
        bfs(adjList, queue, v);
        System.out.println();
    }

    /**
     * 깊이 우선 탐색 DFS
     * @param adjList
     * @param stack
     * @param v
    */
    public static void dfs(List<List<Integer>> adjList, Stack<Integer> stack, int v) {
        //방문했다고 표시
        stack.push(v);
        System.out.print(v);
        adjList.get(v).sort(Integer::compareTo);
        for (Integer vertex : adjList.get(v)) {
            if (!stack.isEmpty() && stack.search(vertex) == -1) {
                System.out.print(" ");
                dfs(adjList, stack, vertex);
            }
        }
    }

    /**
     * 너비 우선 탐색 BFS
     * @param adjList
     * @param queue
     * @param v
     */
    public static void bfs(List<List<Integer>> adjList, Queue<Integer> queue, int v) {
        boolean[] check = new boolean[adjList.size()+1];
        //1. 방문했음을 표시
        check[v] = true;
        System.out.print(v);
        //2. queue 에 정점 v삽입
        queue.offer(v);
        while (!queue.isEmpty()) {
            //4. queue에서 정점 v 삭제
            int vertex = queue.poll();
            //5. 인접 정점 탐색
            for (Integer ver : adjList.get(vertex)) {
                //6. 탐색하지 않았다면
                if (!check[ver]) {
                    //방문했다고 ququq에 삽입
                    queue.offer(ver);
                    check[ver] = true;
                    System.out.print(" ");
                    System.out.print(ver);
                }
            }
        }
    }
}
