package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int prompt;
        System.out.println("""
                Welcome to Republican International School
                Enter
                    1. To see list of all registered students.
                    2. To add a new student.
                    3. To search for a student.
                    4. To delete a student.
                    0. To exit the program.
                """);

        do {
            System.out.print("> ");
             prompt = input.nextInt();
             input.nextLine();
            if (prompt == 1)
                StudentManagement.displayStudentsList();
            else if (prompt == 2) {
                System.out.println("Enter name of new student: ");
                String newStudent = input.nextLine();
                StudentManagement.addStudent(newStudent);
            }else if (prompt == 3){
                System.out.println("Enter name of student to search: ");
                String searchStudent = input.nextLine();
                StudentManagement.searchStudent(searchStudent);
            }
            else if (prompt == 4){
                System.out.println("Enter name of student to delete: ");
                String deleteStudent = input.nextLine();
                StudentManagement.deleteStudent(deleteStudent);
            }
        } while (prompt != 0);

    }
}