package com;

import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.NoSuchElementException;

public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;
    private int size = 0;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T remove() {
        if (top == null)
            throw new NullPointerException();
        Object removeDate = top.data;
        top = top.next;
        size--;
        return (T) removeDate;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return (T) top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.remove());
        System.out.println(stack.peek());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.remove());
        System.out.println(stack.isEmpty());
    }

}
