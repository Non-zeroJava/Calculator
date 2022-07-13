package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Roman.convertNumToRoman;
import static org.example.Roman.romanToNumber;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;


    public static void main(String[] args) {
        String userInput = scanner.nextLine();

        Util util = new Util();
        util.countCharacters(userInput);


        char[] numbers = new char[10];

        try {

            for (int i = 0; i < userInput.length(); i++) {
                numbers[i] = userInput.charAt(i);
                if (numbers[i] == '+') {
                    operation = '+';
                }
                if (numbers[i] == '-') {
                    operation = '-';
                }
                if (numbers[i] == '*') {
                    operation = '*';
                }
                if (numbers[i] == '/') {
                    operation = '/';
                }

            }
            String numbersString = String.valueOf(numbers);
            String[] symbols = numbersString.split("[+-/*]");


            String chislo01 = symbols[0];
            String chislo02 = symbols[1].trim();


            if (util.isDigit(chislo01) && util.isDigit(chislo01)) {

                number1 = Integer.parseInt(chislo01);
                number2 = Integer.parseInt(chislo02);

                int a = 1;
                int b = 10;

                if (number1 >= a && number1 <= b && number2 >= a && number2 <= b) {
                    result = calculated(number1, number2, operation);
                    System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
                    System.exit(1);

                } else {
                    System.out.println("throws Exception ");
                    System.exit(1);
                }

            } else {
                number1 = romanToNumber(chislo01.toUpperCase());
                number2 = romanToNumber(chislo02.toUpperCase());
                if (number1 < 0 && number2 < 0) {
                    result = 0;


                } else {

                    result = calculated(number1, number2, operation);

                    String resultRoman = convertNumToRoman(result);
                    System.out.println(chislo01.toUpperCase() + " " + operation + " " + chislo02.toUpperCase() + " = " + resultRoman.toUpperCase());
                    System.exit(1);
                }

            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ae) {
            System.out.println("throws Exception ");
        }


    }


    public static int calculated(int num1, int num2, char op) {

        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("throws Exception ");
                    System.exit(1);

                    break;

                }
                break;
            default:
                throw new IllegalArgumentException("throws Exception ");
        }
        return result;


    }


}