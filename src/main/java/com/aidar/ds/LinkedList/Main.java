package com.aidar.ds.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        System.out.println(l.get(6));
        System.out.println(l.get(4));
    }
}

class LinkedList<T> {
    private int size;
    private Node start;
    private Node end;

    
    class Node {
        T value;
        Node predecessor;
        Node successor;

        Node(T value) {
            this.value = value;
        }

        void setSuccessor(Node successor) {
            this.successor = successor;
            successor.predecessor = this;
        }
    }

    public void add(T element) {
        Node node = new Node(element);
        if (this.start == null) {
            this.start = node;
            this.end = node;
        } else {
            this.end.setSuccessor(node);
        }
        this.end = node;

        this.size += 1;
    }

    public T get(int index) {
        Node node;
        if (index <= this.size - index - 1) {
            node = this.start;
            for (int i = 0; i != index; i++) {
                node = node.successor;
            }
        } else {
            node = this.end;
            for (int i = this.size-1; i != index; i--) {           
                node = node.predecessor;
            }
        }
        return node.value;
    }

}
