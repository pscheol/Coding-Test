package com.codingtest;

import java.util.*;

/**
 * 1707 이분그래프(Bipartite Graph)
 */
public class BipartiteGraphMain {
    private static List<List<Integer>> adjList;
    private static int[] colors;
    private static boolean isBipartite;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- != 0) {
            int v = scan.nextInt(); //vertex
            int e = scan.nextInt(); //edge

            //init
            adjList = new ArrayList<>();
            colors = new int[v + 1]; //이분그래프를 분리할 테이블
            isBipartite = true;

            for (int i = 0 ; i <= v; i ++) {
                adjList.add(new ArrayList<>());
                colors[i] = 0;
            }

            //무방향 그래프 값 삽입
            for (int i = 0; i < e; i++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                adjList.get(from).add(to);
                adjList.get(to).add(from);
            }


            //모든 정점의 길이만큼 수행.
            for (int i = 1; i <= v; i++) {
                if (!isBipartite) { // 이분그래프가 아니면 더 이상 루프를 돌 필요가 없으므로 Break
                    break;
                }
                if (colors[i] == 0) {
                    bfs(i, 1); //RED 1, GREEN -1 형식으로 분리
                }
            }
            System.out.println(isBipartite ? "YES":"NO");
        }
    }


    public static void dfs(int v, int color) {
        colors[v] = color;
        for (Integer vertex : adjList.get(v)) {
            //시작정점과 인접 정점의 색이 같으면 이분 그래프가 아니므로 리턴
            if (colors[vertex] == color) {
                isBipartite = false;
                return;
            }
            //해당 정점을 방문하지 않았으면
            if (colors[vertex] == 0) {
                dfs(vertex, -color);
            }
        }
    }
    public static void bfs(int v, int color) {
        Queue<Integer> queue = new LinkedList<>();
        colors[v] = color;
        queue.offer(v);
        int tmpColor = color;
        while (!queue.isEmpty()) {
            int dequeue = queue.poll();
            color = colors[dequeue] == 1 ? -1 : 1; //RED 1, GREEN -1 형식으로 분리;
            for (Integer vertex : adjList.get(dequeue)) {
                //시작정점과 인접 정점의 색이 같으면 이분 그래프가 아니므로 리턴
                if (colors[vertex] != 0 && colors[vertex] == colors[dequeue]) {
                    isBipartite = false;
                    return;
                }
                //해당 정점을 방문하지 않았을 경우
                if (colors[vertex] == 0) {
                    colors[vertex] = color;
                    queue.offer(vertex);
                }
            }
        }
    }
}
