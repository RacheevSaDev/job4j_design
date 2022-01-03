package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    @SuppressWarnings("checkstyle:LeftCurly")
    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        expandArray();
        this.container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T prevElement = get(index);
        container[index] = newValue;
        modCount++;
        return prevElement;
    }

    @Override
    public T remove(int index) {
        T prevElement = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return prevElement;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index;
            final private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index != size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }

    private void expandArray() {
        if (size == container.length) {
            this.container  = Arrays.copyOf(container,
                    container.length != 0 ? container.length * 2 : 1);
        }
    }
}
