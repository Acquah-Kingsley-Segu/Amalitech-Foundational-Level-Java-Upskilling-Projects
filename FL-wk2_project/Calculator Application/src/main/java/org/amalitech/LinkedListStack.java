package org.amalitech;

public class LinkedListStack {
    private Node head;

    public LinkedListStack() {
        this.head = null;
    }

    public void push(int data){
        if (this.head == null){
            this.head = new Node(data);
        }
        else {
            Node trav = this.head;
            while (trav.getNext() != null)
                trav = trav.getNext();
            Node newNode = new Node(data);
            trav.setNext(newNode);
        }
    }

    public int pop(){
        if (this.isEmpty())
            return -1;
        Node trav = this.head;
        if (trav.getNext() == null) {
            this.head = null;
            return trav.getData();
        }
        while (trav.getNext().getNext() != null)
            trav = trav.getNext();
        Node popElement = trav.getNext();
        trav.setNext(null);
        return popElement.getData();
    }

    public void displayStack(){
        if (this.head == null)
            System.out.println("List is empty");
        Node trav = this.head;
        while (trav != null){
            System.out.printf("%d", trav.getData());
            if (trav.getNext() != null)
                System.out.print(" -> ");
            trav = trav.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void reverseStack(){
        Node trav, temp;
        if (this.head == null)
            System.out.println("Stack is empty.");
        else if (this.head.getNext() != null){
            trav = this.head;
            temp = trav.getNext();
            trav.setNext(null);
            while(temp.getNext() != null){
                this.head = temp;
                temp = temp.getNext();
                this.head.setNext(trav);
                trav = this.head;
            }
            this.head = temp;
            this.head.setNext(trav);
        }
    }

    public int length(){
        int len = 0;
        Node temp = this.head;
        if (this.head == null)
            return len;
        while (temp != null){
            len++;
            temp = temp.getNext();
        }
        return len;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
