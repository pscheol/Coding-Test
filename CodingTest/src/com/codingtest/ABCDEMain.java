package com.codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABCDEMain {
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean check[];
    static int isResult = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            list.get(from).add(to);
            list.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, 0);
            if (isResult == 1)
                break;
        }
        System.out.println(isResult);
    }

    static void dfs(int x, int idx) {
        if (idx == 4) {
            isResult = 1;
            return;
        }
        check[x] = true;
        for (Integer val : list.get(x)) {
            if (!check[val]) {
                dfs(val, idx + 1);
            }
            if (isResult == 1) return;
        }
        check[x] = false;
    }
}
