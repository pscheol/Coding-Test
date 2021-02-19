package com.codingtest;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerMain {
    /*public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }


        for (int i = 1; i <= A.length+1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }*/

    public static void main(String[] args) {
//        int[] a = {-6, -91, 1011, 10, 9, -4, -5, -1, 473};
//        System.out.println(solution2(a));
//        solution(5555);
        String[] a = {"co", "dil", "ity"};
        String[] aa = {"abc", "yyy", "def", "csv"};
        String[] bb = {"eva", "jqw", "tyn", "jan"};
        String[] cc = {"potato", "kayak", "banana", "racecar"};

        SmallestIntegerMain m = new SmallestIntegerMain();
        System.out.println(m.solution4(a));
        System.out.println(m.solution4(aa));
        System.out.println(m.solution4(bb));
        System.out.println(m.solution4(cc));
    }

    /**
     * task 3
     * recursion solution
     */
    int resultLength = 0;

    public int solution3(String[] A) {
        // write your code in Java SE 8
        resultLength = 0;
        go(A, 0, "");

        return resultLength;
    }

    /*
    task 3
    * loop solution
     */
    public int solution4(String[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (!isDuplicateChar(A[i])) {
                continue;
            }
            StringBuilder s = new StringBuilder(A[i]);
            for (int j = i + 1; j < A.length; j++) {
                if (isDuplicateChar(s + A[j])) {
                    s.append(A[j]);
                    result = Math.max(result, s.toString().length());
                }
            }
        }
        return result;
    }

    /**
     * param A
     *
     * @param idx
     * @param str
     */
    private void go(String[] A, int idx, String str) {
        if (isDuplicateChar(str)) {
            resultLength = Math.max(resultLength, str.length());
            for (int i = idx; i < A.length; i++) {
                String concatStr = str + A[i];
                if (isDuplicateChar(concatStr)) {
                    go(A, i + 1, concatStr);
                }
            }
        }
    }

    /*
     * O(log n)
     */
    public boolean isDuplicateChar(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    /**
     * task2
     *
     * @param A
     * @return
     */
    public static int solution2(int[] A) {
        // write your code in Java SE 8
        int digit = A[0]; //int digit = 0 에서 int digit = A[0]; 으로 수정
        for (int i = 1; i < A.length; i++) {
            if (A[i] < 10 && A[i] > -10) {
                digit = Math.max(digit, A[i]);
            }
        }
        return digit;
    }

    /**
     * Task 1
     *
     * @param N
     */
    public static void solution(int N) {
        int enable_print = N % 10;

        while (N > 0) {
            if (N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }

            N = N / 10;
//            System.out.println("N = N / 10 = " + N);
        }
    }
}
