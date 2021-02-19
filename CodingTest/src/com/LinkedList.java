package com;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }
    }

    private Node<T> headNode;
    private Node<T> lastNode;
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (headNode == null) {
            headNode = new Node<>();
        }
        if (headNode.next == null) {
            lastNode = newNode;
        } else {
            newNode.next = headNode.next;
        }
        headNode.next = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (headNode == null) {
            headNode = new Node<>();
        }
        if (headNode.next == null) {
            headNode.next = newNode;
        } else {
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }
    public T removeFirst() {
        if (headNode.next == null) {
            throw new NoSuchElementException();
        }
        Node<T> remove = headNode.next;
        headNode.next = remove.next;
        if (headNode.next == null) {
            lastNode = headNode;
        }
        return remove.data;
    }
    public T removeLast() {
        if (headNode.next == null) {
            throw new NoSuchElementException();
        }
        Node<T> tmp = headNode;
        while (tmp.next != null && tmp.next != lastNode) {
            tmp = tmp.next;
        }
        T removeData = lastNode.data;
        tmp.next = null;
        lastNode = tmp;
        return removeData;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println("re: "+list.removeLast());
        System.out.println("re: "+list.removeLast());
        System.out.println("re: "+list.removeLast());
        System.out.println("re: "+list.removeLast());

//        list.removeFirst();
        Node<Integer> head = list.headNode.next;
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(24);
        list.addLast(30);
        list.addLast(40);
        head = list.headNode.next;

        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
