package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;
    private int nextIndex;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        this.index = -1;
        this.nextIndex = -1;
    }

    private boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        for (int i = index + 1; i < data.length; i++) {
            if (isEven(data[i])) {
                nextIndex = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index = nextIndex;
        return data[index];
    }
}
