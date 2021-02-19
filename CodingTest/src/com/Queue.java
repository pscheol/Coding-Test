package com;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue<T> {
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }
    public T remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T removeData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removeData;
    }
    public T peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
    }

}
