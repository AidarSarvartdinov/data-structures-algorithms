package com.aidar.ds.LinkedList;

public class Main {
    public static void main(String[] args) {
        
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
            if (successor != null) {
                successor.predecessor = this;
            }
        }
    }

    public void add(T element) {
        Node node = new Node(element);
        if (this.start == null) {
            this.start = node;
        } else {
            this.end.setSuccessor(node);
        }
        this.end = node;

        this.size += 1;
    }

    public void addAtIndex(T element, int index) {
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
        
        Node newNode = new Node(element);
        if (index == 0) {
            this.start = newNode;
            newNode.setSuccessor(node);
        } else {
            node.predecessor.setSuccessor(newNode);
            newNode.setSuccessor(node);
        }
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

    public T remove(int index) {
        Node node;
        if (index == 0) {
            node = this.start;
            if (this.size > 1) {
                this.start = this.start.successor;
                this.start.predecessor = null;
            } else {
                this.start = null;
                this.end = null;
            }
        } else {
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
            node.predecessor.setSuccessor(node.successor);
        }
        
        this.size -= 1;
        return node.value;
    }

    public void set(T element, int index) {
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
        Node newNode = new Node(element);
        
        if (this.size == 1) {
            this.start = newNode;
            this.end = newNode;
        } else {
            if (index == 0) {
                this.start = newNode;
                this.start.setSuccessor(node.successor);
            } else if (index == this.size - 1) {
                this.end = newNode;
                node.predecessor.setSuccessor(newNode);
            } else {
                newNode.setSuccessor(node.successor);
                node.predecessor.setSuccessor(newNode);
                
            }
            
        }
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (this.size == 0) return "[]";
        String res = "[";
        Node node = this.start;
        res += node.value;
        for (int i = 0; i < this.size - 1; i++) {
            node = node.successor;
            res += ", " + node.value;
        }

        return res + "]";
    }

}
