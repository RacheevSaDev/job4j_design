package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public int size() {
        return in.size() + out.size();
    }

    public T poll() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        if (out.size() == 0) {
            while (in.size() != 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
