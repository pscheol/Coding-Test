package com;

public class StackQueue<T> {
    private Stack<T>  front = new Stack<>();
    private Stack<T> rear = new Stack<>();
    public void add(T item) {
        rear.add(item);
    }

    public T dequeue() {
        if (front.isEmpty()) {
            while (!rear.isEmpty()) {
                front.add(rear.remove());
            }
        }
        return front.remove();
    }

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.add(60);
        queue.add(70);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
