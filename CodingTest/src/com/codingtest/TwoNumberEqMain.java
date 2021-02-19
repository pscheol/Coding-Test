package com.codingtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 수의 합이 target과 같은지
 */
public class TwoNumberEqMain {
    public static void main(String[] args) {
        int[] data = {3, 4, 1, 2};
        System.out.println(twoNumberEq2(data, 5));
    }

    /**
     * O(n)
     * @param data
     * @param target
     * @return
     */
    public static boolean twoNumberEq2(int[]data, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < data.length; i++) {
            int num = data[i];
            int sum = target - num;

            if (set.contains(sum)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    /**
     * O(n^2)
     * @param data
     * @param target
     * @return
     */
    public static boolean twoNumberEq(int[] data, int target) {
        for (int i = 0; i < data.length; i++){
            for (int j = i+1; j< data.length; j++) {
                if (data[i] + data[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * O(nlogn)
     * @param data
     * @param target
     * @return
     */
    public static boolean twoNumberEq1(int[] data, int target) {
        Arrays.sort(data);
        for (int i = 0, j= data.length-1; i < j;){
            int sum = data[i] + data[j];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                System.out.println("j=" + j);
                j--;
            } else {
                System.out.println("i=" + i);
                i++;
            }
        }
        return false;
    }


}
