/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

import java.util.StringTokenizer;

/**
 *
 * @author master
 */
public class ShuntingYard {
    String operators = "/*+-"; // descending priority
    Stack2 stack = new Stack2();
    
    String infixToRPN(String infix) {
        String postfixStr = "";
        StringTokenizer tokenizer = new StringTokenizer(infix, " "); // delimited by (space)
        String symbol;
        
        while (tokenizer.hasMoreTokens()) {
            symbol = tokenizer.nextToken();
            if (isOperator(infix)) {
                stack.push(symbol);
            } else if (symbol.equals("(")) {
                stack.push(symbol);
            } else if (symbol.equals(")")) {
                
                do {
                    
                    symbol = stack.pop();
                    if (!symbol.equals("(")) {
                        postfixStr += symbol;
                    }
                    
                } while (!symbol.equals("("));
                // Pop operators off the stack until top of the stack
                // is an opening bracket
            } else { // this must be an operand
                postfixStr += symbol;
                
                
            }
            
            System.out.println("Symbol = " + symbol + " PostfixStr = " + postfixStr);
            
            
        } // endwhile
        String i = stack.pop();
        while (!i.equals("0")) {
            postfixStr += stack.pop();
            
        }
        
        return postfixStr;
        
    }
    
    boolean isOperator(String token) {
        return operators.contains(token);
    }
    
    
}

class Stack2 {
    int pointer;
    final int capacity = 100;
    String arr[] = new String[capacity];
    
    Stack2() {
        
        pointer = -1;
    }
    
    
    
    void push(String element) {
        if (pointer < capacity -1) {
            
            pointer++;
            arr[pointer] = element;
            
            System.out.println("Element " + element + " has been pushed onto the Stack. \n");
            //print();
        } else {
            System.out.println("Stack overflow! \n");
        }
    }
    
    String pop() {
        
        String value = "0";
        
        if (pointer >= 0) {
            value = arr[pointer];
            pointer--;
            System.out.println("The latest element has been removed/popped. \n");
            //print();
            
        } else {
            System.out.println("Stack underflow! \n");
        }
        return value;
        
    }
    
    void print() {
        
        if (pointer >= 0) {
            System.out.println("Elements in the stack are: \n");
            
            for (int i = 0; i <= pointer; i++) {
                System.out.println(arr[i]);
            }
            
            
        }
        
    }
}
