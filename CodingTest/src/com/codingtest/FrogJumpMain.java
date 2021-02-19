package com.codingtest;

public class FrogJumpMain {
    public static void main(String[] args) {
        FrogJumpMain m = new FrogJumpMain();
        System.out.println(m.solution(10,85, 30));
    }
    public int solution(int X, int Y, int D) {
        int dist = Y - X;
        return (dist / D) + (dist % D == 0 ? 0 : 1);
    }
}
