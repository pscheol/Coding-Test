package com.codingtest;

public class MergSortMain {
    static int[] source;
    public static void main(String[] args) {
        int[] list = {5,2,3,6,1,7,9,10};
        source = new int[list.length];


        mSort(list, 0, list.length-1);

        for (int i = 0 ; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void mSort(int[] list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mSort(list , left , mid);
            mSort(list , mid + 1 , right);
            merge(list ,left ,mid ,right);
        }
    }
    public static void merge(int[] list , int left ,int mid ,int right) {
        int ls = left;
        int rs = mid + 1;
        int k =  left;

        while (ls <= mid && rs <= right) {
            if (list[ls] <= list[rs]) {
                source[k++] = list[ls++];
            } else {
                source[k++] = list[rs++];
            }
        }

        if (ls > mid) {
            for (int i = rs; i <= right; i++) {
                source[k++] = list[i];
            }
        } else {
            for (int i = ls; i <= mid; i++) {
                source[k++] = list[i];

            }
        }

        for (int i = left; i <= right; i++) {
            list[i] = source[i];
        }
    }
}
