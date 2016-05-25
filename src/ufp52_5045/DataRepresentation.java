/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

import java.util.Scanner;

/**
 *
 * @author master
 */
public class DataRepresentation {
    
    Scanner userInput;
    
    DataRepresentation() {
        userInput = new Scanner(System.in);
    }
    
    
    // Define a method to acomplish each of the tasks you have been set
    void showNumbers() {
        int index;
        System.out.println("This is the showNumbers() method");

        // display the first 5 positive integers
        for (index = 1; index < 6; index++) {
            System.out.printf("%d\n", index);
        }
    }

    // method to display a prompt string
    // and read a single integer from the user
    // Note there is no check for invalid input
    // returns the value of the integer entered by the user
    int getInteger(String promptStr) {
        String inputStr;
        int value;
        System.out.println(promptStr);
        inputStr = userInput.nextLine();
        value = Integer.parseInt(inputStr);
        return (value);
    }

    // method to display a prompt string and read a single real number from the user
    // Note there is no check for invalid input
    // returns the value of the real number entered by the user as a float type
    float getReal(String promptStr) {
        String inputStr;
        float value;
        System.out.println(promptStr);
        inputStr = userInput.nextLine();
        value = Float.parseFloat(inputStr);
        return (value);
    }

    // method to display a prompt string
    // and read a text string from the user
    // Note there is no check for invalid input
    // returns the value of the text entered by the user
    String getText(String promptStr) {
        String inputStr;
        String valueStr;
        System.out.println(promptStr);
        valueStr = userInput.nextLine();
        return (valueStr);
    }
    
    // When decimal entered, output's the binary equivalent of the integer
    void denaryToBinary()
    {
        System.out.println("Enter the number you want to convert to binary: \n");
        int userNumber = userInput.nextInt();

        // If the input is negative or exceeds 255 then print error
        if (userNumber > 255 || userNumber < 0)
        {
            System.out.println("Integer is either negative or too big. \n");
        }
        else {
            String binary = "";         // This is the string representation of a binary number

            // We need i < 8 because the number must be 8 digits long
            for (int i = 0; i < 8; i++) {
                // If the remainder of userNumber when divided by 2 is equal to 1, then add "1" to the binary String
                if (userNumber % 2 == 1)
                {
                    binary = '1' + binary;  // Adding a character "1" to String binary
                }

                // If remainder of userNumber when divided by 2 is 0, that implies that it is divisible by 2
                // therefore we add "0"
                if (userNumber % 2 == 0)
                {
                    binary = '0' + binary;
                }

                userNumber = userNumber / 2;

                System.out.println("Binary equivalent is: " + binary);
            }

        }
    }

    // Converts binary to decimal
    int binaryToDenary() {
        String input = getText("Please enter a binary number: \n");

        int x = 128;        // maximum value of the first bit
        int total = 0;      // will contain successive values

        for (int i = 0; i < 8; i++) {
            // If the FIRST value of the binary is a 1 then it must be 128
            if (input.charAt(i) == '1') {
                total = total + (x * 1);
            }

            x = x / 2;
        }

        System.out.println("Equivalent: " + total);
        return total;
    }

    // Prints the hexa to binary output
    void doHex() {
        String input = getText("Enter a hexadecimal number: \n").toUpperCase();
        System.out.println(hexToBinary(input) + "\n");
    }

    // Converts hexadecimal to binary
    int hexToBinary(String hex) {
        final String digits = "0123456789ABCDEF";

        int counter = hex.length() - 1;
        int sum = 0;

        for (char c : hex.toCharArray()) {
            int i = digits.indexOf(c);
            sum = (int) (sum + (Math.pow(16, counter)) * i);
            counter--;
        }

        return sum;
    }

    // Prints the decimal to hexa output
    void binaryToHex() {
        int decimalResult = binaryToDenary();
        System.out.println(denaryToHex(decimalResult));
    }

    // Prints the decimal to hexa output
    void printHex() {
        int input = getInteger("Enter a denary number you want converted to hexa: \n");
        System.out.println(denaryToHex(input));
    }

    // Changes decimal to hexadecimal
    String denaryToHex(int decimal) {
        final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hex = "";

        while (decimal != 0) {
            int remainder = decimal % 16;
            hex = hexDigits[remainder] + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    void printDenary() {
        String input = getText("Enter a hexadecimal that you want converted to denary: \n");
        System.out.println(hexToDenary(input));
    }

    // Changes hexadecimal to decimal
    int hexToDenary(String hex) {
        final String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int value = 0;
        int i = 0;
        do {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            value = 16 * value + d;

            i++;
        } while (i < hex.length());

        return value;
    }
    
}
