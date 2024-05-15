package org.example;

import java.util.Scanner;

public class StudentManagement {
    private static int INIT_STUDENT_SIZE = 3;
    private static final int INCREASE_CAPACITY = 2;
    private static int arrayIdx = 0;
    public static String[] students = new String[INIT_STUDENT_SIZE];

    public static void addStudent(String newStudent){
        Scanner input = new Scanner(System.in);
        if (arrayIdx > INIT_STUDENT_SIZE - 1) {
            System.out.println("Student List is full");
            System.out.println("Do you want to extend class size(y/n): ");
            String cmd = input.nextLine();
            if (cmd.equalsIgnoreCase("y"))
                expandClassSize();
            else
                return;
        }
        students[arrayIdx] = newStudent;
        arrayIdx++;
        System.out.println("*** Student added successfully ***");
    }

    private static void expandClassSize() {
        INIT_STUDENT_SIZE += INCREASE_CAPACITY;
        String[] newStudents = new String[INIT_STUDENT_SIZE];

        if (arrayIdx >= 0) System.arraycopy(students, 0, newStudents, 0, arrayIdx);
        students = newStudents;
    }

    public static void deleteStudent(String student){
        int delIdx;
//        String[] newArray = new String[arrayIdx - 2];
        for (delIdx = 0; delIdx < arrayIdx; delIdx++){
            if (students[delIdx].contains(student))
                break;
        }
        for (; delIdx < arrayIdx; delIdx++)
            students[delIdx] = students[delIdx + 1];
        arrayIdx -= 1;
    }

    public static void searchStudent(String student){
        int idx = 0;
        for (; idx < arrayIdx; idx++){
            if (students[idx].contains(student))
                break;
        }

        if (idx == arrayIdx)
            System.out.printf("No student exist with name(%s)\n", student);
        else
            System.out.printf("Student found\n\t%d. %s\n", idx+1, students[idx]);
    }

    public static void displayStudentsList() {
        System.out.println("List of registered students");
        for (int idx = 0; idx < arrayIdx; idx++)
            System.out.printf("\t%d. %s\n", idx + 1, students[idx]);
    }
}
