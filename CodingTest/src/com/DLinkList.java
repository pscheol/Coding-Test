package com;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DLinkList<T> {
    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;
        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node() {

        }
    }


    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        addLast(item);
    }

    public void first(T item) {
        Node<T> newNode = new Node<>(item);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
    }
    public void last(T item) {
        Node<T> newNode = new Node<>(item);
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }
    public void addFirst(T item) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(item, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
    }

    public void addLast(T item) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(item, l, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
    }

    public T remove() {
        return firstRemove();
    }
    public T firstRemove() {
        final Node<T> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unLinkFirst(f);
    }

    public T lastRemove() {
        final Node<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unLinkLast(l);
    }

    public T unLinkFirst(Node<T> f) {
        final T element = f.item;
        final Node<T> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;

        return element;
    }
    public T unLinkLast(Node<T> l) {
        final T element = l.item;
        final Node<T> prev = l.prev;
        l.prev = null;
        l.item = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        return element;
    }

    public T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> prev = x.prev;
        final Node<T> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.prev = null;
        }
        x.item = null;

        return element;
    }
}
