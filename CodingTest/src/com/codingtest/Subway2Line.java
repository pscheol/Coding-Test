package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 16947번 - 서울 지하철 2호선baekjoon
 */
public class Subway2Line {
    private static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0 ; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]) - 1;
            int v2 = Integer.parseInt(line[1]) - 1;
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }


    }
}
