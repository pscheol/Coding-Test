package com.codingtest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OddMain {
    public static void main(String[] args) {
        OddMain m = new OddMain();
        int[] a ={9, 3, 9, 3, 9, 7, 9};

        System.out.println(m.solution3(a));

    }

    public int solution3(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
    public int solution2(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        for (int i = 0 ; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int l = A.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < l; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) +1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 1) {
                result = e.getKey();
            }
        }
        return result;
    }
}
