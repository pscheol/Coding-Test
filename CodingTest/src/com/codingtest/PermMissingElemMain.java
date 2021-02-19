package com.codingtest;

import java.util.Arrays;

public class PermMissingElemMain {
    public static void main(String[] args) {
        PermMissingElemMain m = new PermMissingElemMain();
        int[] a = {2, 3, 1, 5};
        System.out.println(m.solution(a));
    }

    public int solution(int[] A) {
        int sum = 0;
        for (int i = 1; i <= A.length + 1; i++) {
            sum+= i;
        }
        for (int i: A) {
            sum-= i;
        }
        return sum;
    }
}
