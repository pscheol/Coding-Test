package com;

public class Heap {
    int[] heap = new int[200];
    int size = 0;

    public void addMaxHeap(int key) {
        int i = ++size; //힙 크기 증가
        while (i != 1 && key > heap[i / 2]) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = key; //새로운 노드 삽입
    }

    public int removeMaxHeap() {
        int item = heap[1]; //루트 노드 값
        int tmp = heap[size]; //마지막 노드
        int parent = 1;
        int child = 2;
        heap[size--] = 0;

        while (child <= size) {
            //현재 노드의 자식노드 중 더 큰 값을 찾음
            if (child < size && heap[child] < heap[child + 1]) {
                child++;
            }
            //더 큰 자식 노드보다 마지막노드가 크면 break;
            if (tmp >= heap[child]) {
                break;
            }
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = tmp;
        return item;
    }

    public void getMaxHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i]);
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.addMaxHeap(1);
        h.addMaxHeap(2);
        h.addMaxHeap(3);
        h.addMaxHeap(4);
        h.addMaxHeap(5);
        h.addMaxHeap(6);
        h.addMaxHeap(7);
        h.addMaxHeap(8);
        h.addMaxHeap(9);
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());
        System.out.println(h.removeMaxHeap());

        for (int i : h.heap) {
            System.out.println("heap=" + i);
        }
    }
}
