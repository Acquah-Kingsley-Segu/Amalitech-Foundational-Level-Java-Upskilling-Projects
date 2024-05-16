package org.amalitech;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static String operators = "*/+-";
    private static LinkedListStack operandStack = new LinkedListStack();
    private static String usedOperators = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String arithmetic;
        System.out.println("""
                **************************************************************
                *                Welcome to CalculateIT App                  *
                *    Enter your arithmetic operations after the (>) prompt   *
                *               Enter 'q' to exist program                   *
                **************************************************************
                """);
        System.out.print("> ");
        arithmetic = input.nextLine();
        String[] operations = arithmetic.split(" ");
        Main.calculatorEngine(operations, arithmetic);
    }

    private static int performSubtraction(int op1,  int op2){
        return op1 - op2;
    }

    private static int performAddition(int op1, int op2){
        return op1 + op2;
    }

    private static int performMultiplication(int op1, int op2) {
        return op1 * op2;
    }

    private static int performDivision(int op1, int op2){
        return op1 / op2;
    }

    /**
     * checks if * or / operator exist after a + or - operator
     * @param operation arithmetic to check
     * @param idx index where the + or - operator was encountered
     * @return true if found or false otherwise
     */
    private static boolean checkNextOperator(String[] operation, int idx){
        boolean exist = false;
        while (idx < operation.length && !exist){
            exist = Main.operators.substring(0, 2).contains(operation[idx]);
            idx += 2;
        }
        return exist;
    }

    private static void calculatorEngine(String[] operations, String arithmetic){
        for (int idx = 0; idx < operations.length; idx++) {
            if (!Main.operators.contains(operations[idx])) // get operands from operations
                Main.operandStack.push(Integer.parseInt(operations[idx]));
            else if ((!Main.operators.substring(0, 2).contains(operations[idx])) &&
                    (Main.operators.substring(2, 4).contains(operations[idx]))) { // get only + and - symbols

                if (Main.checkNextOperator(operations, idx)) {
                    System.out.println(operations[idx] + " = " + Main.checkNextOperator(operations, idx));
                    Main.usedOperators = Main.usedOperators.concat(operations[idx]);
                }
                else if ((operations[idx].equals("-")) && (idx + 1 < operations.length - 1))
                {
                    int op1 = Main.operandStack.pop();
                    int op2 = Integer.parseInt(operations[++idx]);
                    int result = Main.performSubtraction(op1, op2);
                    System.out.printf("%n%d %s %d = %d%n", op1, operations[idx - 1], op2, result);
                    Main.operandStack.push(result);
                }
                else if ((operations[idx].equals("+")) && (idx + 1 < operations.length - 1)) {
                    int op1 = Main.operandStack.pop();
                    int op2 = Integer.parseInt(operations[++idx]);
                    int result = Main.performAddition(op1, op2);
                    System.out.printf("%n%d %s %d = %d%n", op1, operations[idx - 1], op2, result);
                    Main.operandStack.push(result);
                }else
                    Main.usedOperators = Main.usedOperators.concat(operations[idx]);
            }
            else if (Main.operators.substring(0, 2).contains(operations[idx])) { // get only * and / symbols
                int op1 = Main.operandStack.pop();
                int op2 = Integer.parseInt(operations[++idx]);
                int result;
                if (operations[idx - 1].equals("*"))
                    result = Main.performMultiplication(op1, op2);
                else
                    result = Main.performDivision(op1, op2);
                System.out.printf("%n%d %s %d = %d%n", op1, operations[idx - 1], op2, result);
                Main.operandStack.push(result);
            }
            Main.operandStack.displayStack();
        }
        Main.operandStack.reverseStack();
        Main.operandStack.displayStack();
        System.out.println(usedOperators);
        for (int idx = 0; idx < Main.usedOperators.length(); idx++){
            if (Main.usedOperators.charAt(idx) == '-')
            {
                int op2 = Main.operandStack.pop();
                int op1 = Main.operandStack.pop();
                int result = Main.performSubtraction(op2, op1);
                System.out.printf("%n%d %s %d = %d", op2, usedOperators.charAt(idx), op1, result);
                Main.operandStack.push(result);
            } else if (Main.usedOperators.charAt(idx) == '+') {
                int op1 = Main.operandStack.pop();
                int op2 = Main.operandStack.pop();
                int result = Main.performAddition(op1, op2);
                System.out.printf("%n%d %s %d = %d", op1, usedOperators.charAt(idx), op2, result);
                Main.operandStack.push(result);
            }
        }
        if (Main.operandStack.length() == 1)
            System.out.printf("%n%s = %d%n", arithmetic, Main.operandStack.pop());
        else
            System.out.printf("Double check your question(%s) ", arithmetic);
    }
}