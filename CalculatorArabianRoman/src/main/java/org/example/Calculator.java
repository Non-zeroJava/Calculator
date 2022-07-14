package org.example;

import java.util.Scanner;

import static org.example.Roman.convertNumToRoman;
import static org.example.Roman.romanToNumber;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;
    static Util util = new Util();

    public static void main(String[] args) {
        String userInput = scanner.nextLine();

        calc(userInput);


    }

    public static void calc(String userInput) {

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

                    result = Util.calculated(number1, number2, operation);
                    System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
                    System.exit(1);

                } else {

                    throw new RuntimeException();
                }

            } else {
                number1 = romanToNumber(chislo01.toUpperCase());
                number2 = romanToNumber(chislo02.toUpperCase());
                if (number1 < 0 && number2 < 0) {
                    result = 0;


                } else {

                    result = Util.calculated(number1, number2, operation);

                    String resultRoman = convertNumToRoman(result);
                    util.zeroExam(resultRoman);


                    System.out.println(chislo01.toUpperCase() + " " + operation + " " + chislo02.toUpperCase() + " = " + resultRoman.toUpperCase());

                    System.exit(1);

                }

            }

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ae) {
            throw new RuntimeException();
        }
    }





}