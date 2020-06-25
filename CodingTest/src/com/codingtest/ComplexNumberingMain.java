package com.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 단지 번호 붙이기
 */
public class ComplexNumberingMain {

    private static int[][] table;
    private static int[][] chk;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int rt = 0;
    private List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        table = new int[n][n];
        chk = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = in.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                table[i][j] = Integer.parseInt(split[j]);
            }
        }
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 1 && chk[i][j] == 0) {
                    rt = 0;
                    dfs(i ,j, ++cnt, n);
                    list.add(rt);
                }
            }
        }
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

    public static void dfs(int x, int y, int cnt, int n) {
        chk[x][y] = cnt;
        rt++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (table[nx][ny] == 1 && chk[nx][ny] == 0) {
                    dfs(nx, ny, cnt, n);
                }
            }
        }
    }
}
