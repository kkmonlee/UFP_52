/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;
import java.util.*;

/**
 *
 * @author Atul Anand Sinha
 */
public class InfixToPostfixv2 {
    // Initializing the stack
    Stack4 stack;
    // Initializing constants within the class
    private static final char   ADD = '+',
                                SUBTRACT = '-';
    
    private static final char   MULTIPLY = '*',
                                DIVIDE = '/';
    
    private static final char   POWER = '^';
    
    private static final char   OBRACKET = '(',
                                CBRACKET = ')';
    
    /**
     * Constructor
     * @param capacity size of the stack
     */
    public InfixToPostfixv2(int capacity) {
        /**
        * Test case: 
        *      capacity = 10 to 25
        *      infix    = (1+2)*(3+4)^(12-5)
        *               = 23*(134-3^7*(3-5))
        *      @throws NullPointerException
        */
        stack = new Stack4(capacity);
    }
    
    /**
     * Tells whether Char c is an operator or not
     * @param c character
     * @return true if c is an operator, false otherwise
     */
    private boolean isOperator(char c) {
        return c == ADD ||
               c == SUBTRACT || 
               c == MULTIPLY || 
               c == DIVIDE || 
               c == POWER || 
               c == OBRACKET || 
               c == CBRACKET;
    }
    
    /**
     * Tells whether c is a space
     * @param c character
     * @return true if c is a space, false otherwise
     */
    private boolean isSpace(char c) {
        return (c == ' ');
    }
    
    /**
     * Tells whether op1 has lower precedence than op2
     * @param op1 operator on the Left Hand Side
     * @param op2 operator on the Right Hand Side
     * @return true if op1 has lower precedence than op2, false otherwise
     */
    private boolean lowerPrecedence(char op1, char op2) {
        
        // Do not need break since this method will return a boolean value
        switch (op1) {
            case ADD:
            case SUBTRACT:
                return !(op2 == ADD || op2 == SUBTRACT);
            case MULTIPLY:
            case DIVIDE:
                return op2 == POWER || op2 == CBRACKET;
            case POWER:
                return op2 == OBRACKET;
            case OBRACKET:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * Converts Infix to Postfix
     * @param infix infix String
     * @return postfix String
     */
    public String convertToPostfix(String infix) {
        char c;
        // StringTokenizer will concatenate the string by operators
        // True means that the delimited characters (operators) are also returned and not ignored
        StringTokenizer tokenizer = new StringTokenizer(infix, "+-*/^() ", true);
        // Constructs a string builder with no characters with the capacity of infix.length
        StringBuilder postfix = new StringBuilder(infix.length());
        
        while (tokenizer.hasMoreTokens()) {     
           String token = tokenizer.nextToken();
           c = token.charAt(0);         
           
           /**
            * If the current token is a single digit/character value and 
            * is an operator, do:
            */
           if ((token.length() == 1) && isOperator(c) ) {    
                /**
                * While: the stack isn't empty and the value at the top of the 
                * stack does not take precedence over the first character in the tokenizer
                * 
                * Do: Pop the stack and add the popped value to the postfix string
                * as well as a space.
                */
               while (!stack.isEmpty() && !lowerPrecedence((stack.peek()).charAt(0), c)) {
                   
                   postfix.append(" ").append(stack.pop());
               
               }
                
               /**
                * If the first character of the token is a closing bracket, do:
                *   Check if the latest value on the stack is not an opening bracket.
                *   If yes then:
                *       Pop the value into the postfix string with a space
                *   Otherwise:
                *       Push the token onto the stack
                */
                if (c == CBRACKET) {
                    String operator = stack.pop();

                    while (operator.charAt(0)!= OBRACKET) {
                        postfix.append(" ").append(operator);
                        operator = stack.pop();  
                    }

                }
                else {
                    stack.push(token);
                }
           }
           /**
            * If the current token is a single digit/character value 
            * and also is a space, do:
            */
           else if ((token.length() == 1) && isSpace(c)) {   
               // do nothing, just a random space value in the string
           }
           /**
            * Otherwise the token must be a number (digit)
            */
           else {
               postfix.append(" ").append(token);  
           }
           
        }
        while (!stack.isEmpty()) {
            postfix.append(" ").append((String)stack.pop());
        }
     
        return postfix.toString();
    }
}

class Stack4 {
    
    int maxSize;
    String[] stackArray;
    int pointer;
    Stack4(int max) {
        maxSize = max;
        stackArray = new String[maxSize];
        pointer = -1;
    }
    
    void push(String j) {
        stackArray[++pointer] = j;
        
    }
    
    String pop() {
        return stackArray[pointer--];
    }
    
    String peek() {
        return stackArray[pointer];
    }
    
    boolean isEmpty() {
        return (pointer == -1);
    }
    
    public static void main(String[] args) {
        RPNv3 rpn = new RPNv3();
        String infix = "23*(134-3^7*(3-5))";
        
        InfixToPostfixv2 converter = new InfixToPostfixv2(infix.length());
        
        System.out.println("infix: " + infix);
        String n = converter.convertToPostfix(infix);
        System.out.println("postfix: " + n);
        System.out.println("evalutation: " + rpn.calculate(n));
    }
    
}


