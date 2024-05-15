package org.example;

public class LinkedList {
    private Node head;
    private int length;

    public LinkedList(){
        this.head = null;
        this.length = 0;
    }

    public void addToFirst(int data){
        Node newElement = new Node(data);
        Node temp = this.head;
        this.head = newElement;
        newElement.setNext(temp);
        this.length++;
    }

    public void addToEnd(int data){
        Node newElement = new Node(data);
        if (head == null){
            this.head = newElement;
        }
        else {
            Node trav = this.head;
            while(trav.getNext() != null)
                trav = trav.getNext();
            trav.setNext(newElement);
        }
        this.length++;
    }

    public void addAt(int data, int position){
        int index = 0;
        if (this.head == null)
            this.addToFirst(data);
        else {
            Node newElement = new Node(data);
            Node trav = this.head;
            index++;
            while ((trav.getNext() != null) && (index < position - 1)){
                index++;
                trav = trav.getNext();
            }
            newElement.setNext(trav.getNext());
            trav.setNext(newElement);
        }
        this.length++;
        System.out.printf("Inserted (%d) at position %d%n", data, index + 1);
    }

    public void searchList(int searchItem){
        int position = search(searchItem);
        if (position == 0)
            System.out.println("Search item is not in the list.");
        else
            System.out.printf("Search item (%d) was found at position (%d).%n", searchItem, position);
    }

    public void deleteElement(int deleteElement){
        int elementPosition = this.search(deleteElement);
        Node trav = this.head;

        if (elementPosition == 0)
            System.out.printf("Data (%d) does not exist.%n", deleteElement);
        else if (elementPosition == 1) {
            trav = trav.getNext();
            this.head = trav;
        }else if (elementPosition == this.length) {
            for (int idx = 1; idx < this.length - 1; idx++)
                trav = trav.getNext();
            trav.setNext(null);
        }else {
            System.out.println("Delete position -> " + elementPosition);
            for (int idx = 0; idx < elementPosition - 2; idx++)
                trav = trav.getNext();
            Node delElement = trav.getNext();
            trav.setNext(delElement.getNext());
        }
    }

    public void displayList(){
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

    private int search(int searchItem){
        int position = 0;
        boolean isFound = false;

        if(this.head == null)
            System.out.println("List is empty.");
        else {
            Node trav = this.head;
            while (trav != null){
                position++;
                if (trav.getData() == searchItem) {
                    isFound = true;
                    break;
                }
                trav = trav.getNext();
            }
        }
        if (!isFound)
            position = 0;
        return position;
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.setNext(null);
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
