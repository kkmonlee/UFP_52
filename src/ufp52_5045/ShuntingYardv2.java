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
public class ShuntingYardv2 {
    Stack stackValues = new Stack("10");
    Stack stackOps = new Stack("10");
    
    int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        
        for (int i = 0; i < tokens.length; i++) {
            // If the token is space then skip
            if (tokens[i] == ' ') {
            }
            
            // If current token is a number, push it to stack
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder buffer = new StringBuilder();
                // Might be more than 1 digit in a number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    buffer.append(tokens[i++]);
                }
                stackValues.push(Integer.parseInt(buffer.toString()));
            }
            
            // If current token is an opening bracket, push it to operator stack
            else if (tokens[i] == '(') {
                stackOps.push(tokens[i]);
            }
            
            // If current token is a closing bracket, push it to operator stack
            else if (tokens[i] == ')') {
                while (stackOps.peek(tokens[i]) != '(') {
                    stackValues.push(calculate((char) stackOps.pop(), stackValues.pop(), stackValues.pop()));
                }
                stackOps.pop();
            }
            
            // If current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/') {
                
                // While top of stackOps has same or greater precedence to current
                // token, apply operator on top of stackOps to the top 2 elements in
                // stackValue.
                while (!stackOps.isEmpty()) {
                    while (hasPrecedence(tokens[i], stackOps.printPointer())) {
                        stackValues.push(calculate((char) stackOps.pop(), stackValues.pop(), stackValues.pop()));
                    }
                }
                // Push current token to stackOps
                stackOps.push(tokens[i]);
            }
            
            stackOps.print();
            stackValues.print();
            
        }
        
        // Apply remaining values to stackOps
        while (!stackOps.isEmpty()) {
            stackValues.push(calculate((char) stackOps.pop(), stackValues.pop(), stackValues.pop()));
            
        }
        
        return stackValues.pop();
    }
    
    // Returns true if op2 has higher or same precedence as op1
    // otherwise returns false
    boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    
    // Method to apply an operator called "op" on operands "a"
    // and "b"
    // Returns the result
    int calculate(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
