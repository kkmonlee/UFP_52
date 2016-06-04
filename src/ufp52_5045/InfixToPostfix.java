/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

/**
 *
 * @author Atul Anand Sinha
 */
public class InfixToPostfix {
    Stack stack;
    String input;
    String output = "";
    
    InfixToPostfix(String in) {
        input = in;
        int stackSize = input.length();
        stack = new Stack(in);
    }
    
    
}
