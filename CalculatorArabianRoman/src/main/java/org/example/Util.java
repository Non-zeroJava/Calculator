package org.example;

import java.util.InputMismatchException;

public class Util {
    /**
     * Метод проверяющий колличество знаков
     */
    public void countCharacters(String userInput) {
        int totalCharacters = 0;
        char temp;
        for (int i = 0; i < userInput.length(); i++) {

            temp = userInput.charAt(i);
            if (temp == '+')
                totalCharacters++;
            if (temp == '-')
                totalCharacters++;
            if (temp == '/')
                totalCharacters++;
            if (temp == '*')
                totalCharacters++;
        }
        if (totalCharacters > 1) {
            throw new RuntimeException();
        }
    }

    /**
     * метод проверяющий является ли строка числом
     */
    public boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

  
    public void zeroExam(String resultRoman) {
        if (String.valueOf(0).equals(resultRoman)) {
            throw new RuntimeException();
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
                    throw new RuntimeException();

                }
                break;
            default:
                throw new IllegalArgumentException("throws Exception ");
        }
        return result;


    }


}
