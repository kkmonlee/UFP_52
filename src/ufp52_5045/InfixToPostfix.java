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
    Stack3 stack;
    String input;
    String output = "";
    
    InfixToPostfix(String in) {
        input = in;
        int stackSize = input.length();
        stack = new Stack3(stackSize);
    }
    
    String calculate() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    getOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    getOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    getParent(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output = output + stack.pop();
        }
        System.out.println(" " + output);
        return output;
    }
    
    void getOperator(char op1, int precedence1) {
        
        while (!stack.isEmpty()) {
            char topOperator = (char) stack.pop();
            if (topOperator == '(') {
                stack.push(topOperator);
                break;
            } else {
                int precedence2;
                if (topOperator == '+' || topOperator == '-') {
                    precedence2 = 1;
                } else {
                    precedence2 = 2;
                }
                
                if (precedence2 < precedence1) {
                    stack.push(topOperator);
                    break;
                } else {
                    output = output + topOperator;
                }
            }
        }
        stack.push(op1);
    }
    
    void getParent(char ch) {
        while (!stack.isEmpty()) {
            char chx = (char) stack.pop();
            if (chx == '(') {
                break;
            } else {
                output = output + chx;
            }
        }
    }
    
    
}

class Stack3 {
    
    int maxSize;
    char[] stackArray;
    int pointer;
    Stack3(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        pointer = -1;
    }
    
    void push(char j) {
        stackArray[++pointer] = j;
    }
    
    char pop() {
        return stackArray[pointer--];
    }
    
    char peek() {
        return stackArray[pointer];
    }
    
    boolean isEmpty() {
        return (pointer == -1);
    }
    
}
