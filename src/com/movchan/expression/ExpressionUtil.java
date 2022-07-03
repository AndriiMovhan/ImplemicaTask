package com.movchan.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionUtil {

    /**
     * Because it is a Utility class, the constructor is private
     */
    private ExpressionUtil() {
    }

    /**
     *
     * @param list where we write correct brackets
     * @param leftBracketsCount count of left brackets
     * @param rightBracketsCount count of right brackets
     * @param brackets massive with corrects brackets
     * @param count bracket’s position
     */
    public static void addBrackets(List<String> list, int leftBracketsCount, int rightBracketsCount, char[] brackets, int count) {
        if (leftBracketsCount < 0 || rightBracketsCount < leftBracketsCount) {
            return; // incorrect state and out of recursion
        }

        if (leftBracketsCount == 0 && rightBracketsCount == 0) {    // no more brackets, so we write brackets in the list
            list.add(String.copyValueOf(brackets));
        } else {
            if (leftBracketsCount > 0) {    // add left bracket
                brackets[count] = '(';
                addBrackets(list, leftBracketsCount - 1, rightBracketsCount, brackets, count + 1);
            }

            if (rightBracketsCount > leftBracketsCount) {   // add right bracket
                brackets[count] = ')';
                addBrackets(list, leftBracketsCount, rightBracketsCount - 1, brackets, count + 1);
            }
        }
    }

    /**
     * Method start task
     *
     * @param scanner what user write
     */
    public static void runExpressionTask(Scanner scanner) {
        System.out.println("Find the number of correct bracket expressions containing N opening and N closing brackets" +
                "\nEnter how many brackets you want?");
        while (scanner.hasNext()) {
            String s = scanner.nextLine();

            if (s.equals("exit")) {
                return;
            }

            int count;
            try {
                count = Integer.parseInt(s);
                if (Integer.parseInt(s) <= 0) {
                    System.err.println("You must write digit only bigger 0\nTry again:");
                } else {
                    char[] brackets = new char[count * 2];
                    List<String> list = new ArrayList<>();
                    addBrackets(list, count, count, brackets, 0);
                    System.out.println("Array of bracers: " + list);
                    System.out.println("Number of bracers options: " + list.size());
                    System.out.println("Enter another digit \nor write \"exit\" to go to the main page");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter correct digit\nTry again:");
            }
        }
    }
}
