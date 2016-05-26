/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

/**
 *
 * @author master
 */

import java.awt.*;
import acm.program.*;
import acm.graphics.*;
import java.util.Scanner;

public class SierpinskiCarpet extends GraphicsProgram {
// attributes
    Scanner userInput;
    final int MAX_RECURSE=5;
    int recurseLevel; // recursion level 1..5
    int minSub; // min length of sub square (at least 3)
    
    public void run() {
        
        userInput = new Scanner(System.in);
        recurseLevel=getInteger("Enter recursion level (1-5)");
        minSub=power(3, MAX_RECURSE + 1 -recurseLevel);
        
        // draw black background square 20 in and 20 down from the edge of the screen       
        GRect square = new GRect(20, 20, 242, 242);
        square.setFilled(true);
        add(square);

        // recursively draw all the white squares on top
        // note that 243 is 3^5
        // so the sequence of side lengths is 243,81,27,9,3
        drawCarpet(20, 20, 243);
        
        getInteger("Press a key: ");
    }

    // recursive function to draw each level of the carpet
    // side should be an integer power of 3 to make things easier
    public void drawCarpet(int x, int y, int side) {
        // draw single white square in middle
        int sub = side / 3; // length of sub-squares
        GRect square = new GRect(x + sub, y + sub, sub - 1, sub - 1);
        square.setFilled(true);
        square.setColor(Color.WHITE);
        add(square);

        if (sub >= minSub) {
            // now draw eight sub-Carpets around the white square
            drawCarpet(x, y, sub);
            drawCarpet(x + sub, y, sub);
            drawCarpet(x + 2 * sub, y, sub);
            drawCarpet(x, y + sub, sub);
            drawCarpet(x + 2 * sub, y + sub, sub);
            drawCarpet(x, y + 2 * sub, sub);
            drawCarpet(x + sub, y + 2 * sub, sub);
            drawCarpet(x + 2 * sub, y + 2 * sub, sub);
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
    // very limited range power calculation for this local example only
    int power(int value,int exponent) {
        int result=1;
        for (int i=0;i<exponent;i++) {
            result*=value;
        }
        return(result);
    }

}

