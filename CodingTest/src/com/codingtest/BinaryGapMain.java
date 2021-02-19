package com.codingtest;

public class BinaryGapMain {
    public static void main(String[] args) {
        BinaryGapMain b = new BinaryGapMain();
        System.out.println(b.solution(805306373));
    }
    public int solution(int N) {
        String bst = Integer.toBinaryString(N);
        boolean isFlag = false;
        int result = 0;
        int count = 0;
        for (char c : bst.toCharArray()) {
            if (c-'0' == 1) {
                isFlag = true;
                result = Math.max(result, count);
                count = 0;
            } else {
                if (isFlag) {
                    count++;
                }
            }
        }
        return result;
    }
}
