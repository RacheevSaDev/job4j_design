package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;
    private int modCount;

    public SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(E value) {
        if (size == 0) {
            head = new Node<>(value);
        } else {
            Node<E> pointer = head;
            while (pointer.getNextNode() != null) {
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(new Node(value));
        }
        modCount++;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNextNode();
        }
        return pointer.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> pointer = head;
            final private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return pointer != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = (E) pointer.getValue();
                pointer = pointer.getNextNode();
                return value;
            }
        };
    }
}