package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int prompt;
        System.out.println("""
                Welcome to Singly Linked List Program
                   Enter
                     1. To see data in the list.
                     2. To add a new number to the start of list.
                     3. To add a new number to the end of list.
                     4. To add a new number to a specific position of list.
                     5. To search for a number in the list.
                     6. To delete a number from the list.
                     0. To exit the program.
                """);
        do {
            System.out.print("> ");
            prompt = input.nextInt();
            if (prompt == 1)
                linkedList.displayList();
            else if (prompt == 2) {
                System.out.print("Enter the number: ");
                int data = input.nextInt();
                input.nextLine();
                linkedList.addToFirst(data);
            }else if (prompt == 3){
                System.out.print("Enter the number: ");
                int data = input.nextInt();
                input.nextLine();
                linkedList.addToEnd(data);
            }
            else if (prompt == 4){
                System.out.print("Enter the number: ");
                int data = input.nextInt();
                input.nextLine();
                System.out.print("Enter the position to insert: ");
                int position = input.nextInt();
                input.nextLine();
                linkedList.addAt(data, position);
            } else if (prompt == 5) {
                System.out.print("Enter the number to search: ");
                int searchItem = input.nextInt();
                input.nextLine();
                linkedList.searchList(searchItem);
            }
            else if (prompt == 6){
                System.out.print("Enter the number to delete: ");
                int deleteItem = input.nextInt();
                input.nextLine();
                linkedList.deleteElement(deleteItem);
            }
        } while (prompt != 0);
    }
}