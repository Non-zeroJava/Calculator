package org.example;

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
            System.out.println("throws Exception ");
            System.exit(1);
        }
    }

    /**
     * метод проверяющий, является ли строка числом
     */
    public boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}