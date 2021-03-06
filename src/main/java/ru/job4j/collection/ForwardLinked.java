package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public int getSize() {
        return this.size;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public boolean revert() {
        boolean res = this.size != 0 && this.size != 1;
        if (res) {
            Node<T> previous = null;
            Node<T> pointer = head;

            while (pointer != null) {
                Node<T> next = pointer.next;
                pointer.next = previous;
                previous = pointer;
                pointer = next;
            }
            head = previous;
        }
        return res;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head.value = null;
        Node<T> next = head.next;
        head.next = null;
        head = next;
        size--;
        return value;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
