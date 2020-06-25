package com.codingtest;

import java.util.Map;
import java.util.Scanner;

public class TreeHeightAndWeightMain {
    static Node[] nodes = new Node[10001];
    static int[] left = new int[10001];
    static int[] right = new int[10001];
    static int[] cnt = new int[10001];
    static int order = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            nodes[x] = new Node(y, z);
            if (y != -1) cnt[y] += 1;
            if (z != -1) cnt[z] += 1;
        }
        int root = 0;
        inorder(root, 1);
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = nodes[i].depth;
            int order = nodes[i].order;
            if (left[depth] == 0) {
                left[depth] = order;
            } else {
                left[depth] = Math.max(right[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxDepth = Math.max(maxDepth, depth);
        }

        int ans = 0;
        int ans_level = 0;
        for (int i = 1; i <=maxDepth; i++) {
            if (ans < right[i] - left[i]+1) {
                ans = right[i] - left[i]+1;
                ans_level = i;

            }
        }
        System.out.println(ans_level + " " + ans);
    }

    static class Node {
        int left;
        int right;
        public int order;
        public int depth;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void inorder(int node, int depth) {
        if (node == -1) {
            return;
        }
        inorder(nodes[node].left, depth + 1);
        nodes[node].order = ++order;
        nodes[node].depth = depth;
        inorder(nodes[node].right, depth + 1);
    }


}