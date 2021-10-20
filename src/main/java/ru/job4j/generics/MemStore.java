package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        return mem.replace(id, findById(id), model);
    }

    @Override
    public boolean delete(String id) {
        T modelFound = findById(id);
        if (modelFound != null) {
            mem.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}