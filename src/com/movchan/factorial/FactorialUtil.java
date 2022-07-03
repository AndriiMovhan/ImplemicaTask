package com.movchan.factorial;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Utility class for factorial operations
 */
public class FactorialUtil {

    /**
     * Because it is a Utility class, the constructor is private
     */
    private FactorialUtil() {
    }

    /**
     * Method is used to calculate the factorial from the passed number
     *
     * @param number from which number the factorial should be calculated
     * @return calculated factorial
     */
    public static BigInteger getFactorial(int number) {

        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    /**
     * Method is used to calculate the sum of the digits in the passed number
     *
     * @param number any number
     * @return calculated sum of digits
     */
    public static int calculateDigitsSum(BigInteger number) {
        String strNum = number.toString();
        int sum = 0;
        for (int i = 0; i < strNum.length(); i++) {
            sum += Character.digit(strNum.charAt(i), 10);
        }

        return sum;
    }

    /**
     * Method start task
     *
     * @param scanner what user write
     */
    public static void runFactorialTask(Scanner scanner) {
        System.out.println("Find the sum of the digits in the number 100! (i.e. 100 factorial)" +
                "\nEnter from which digit you want take factorial?");
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            if (str.equals("exit")) {
                return;
            }

            int digital;
            try {
                digital = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.err.println("Please enter correct digit\nTry again:");
                continue;
            }

            if (digital < 0) {
                System.err.println("You must write only positive digit\nTry again:");
            } else {
                BigInteger result = getFactorial(digital);
                System.out.println("factorial of " + digital + " = " + result);
                System.out.println("the sum of the digits in the number of " + digital + "! = " + calculateDigitsSum(result));
                System.out.println("Enter another digit \nor write \"exit\" to go to the main page");
            }
        }
    }
}