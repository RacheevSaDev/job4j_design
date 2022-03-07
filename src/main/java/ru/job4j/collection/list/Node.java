package ru.job4j.collection.list;

public class Node<V> {
    private V value;
    private Node nextNode;

    public Node(V val) {
        this.value = val;
        nextNode = null;
    }

    public V getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
