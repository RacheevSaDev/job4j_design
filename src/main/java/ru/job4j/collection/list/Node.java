package ru.job4j.collection.list;

public class Node<V> {
    private V value;
    private Node<V> nextNode;

    public Node(V val) {
        this.value = val;
        nextNode = null;
    }

    public V getValue() {
        return value;
    }

    public Node<V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<V> nextNode) {
        this.nextNode = nextNode;
    }
}
