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
public class RPNv2 {
    
    Stack stack = new Stack("10");
    
    int calculate(String expression) {
        
        int returnValue;
        String operators = "+-*/";
        String symbol;
        
        for (int i = 0; i < expression.length(); i++) {
            symbol = expression.substring(i, i + 1);
            if (!operators.contains(symbol)) {
                stack.push(Integer.parseInt(symbol));
            } else {
                int a = stack.pop(); // operand 2
                int b = stack.pop(); // operand 1
                int index = operators.indexOf(symbol);
                
                switch(index) {
                    case 0:
                        stack.push(a + b);
                        break;
                    case 1:
                        stack.push(b - a);
                        break;
                    case 2:
                        stack.push(a * b);
                        break;
                    case 3:
                        stack.push(b / a);
                        break;
                }
            }
        }
        
        returnValue = stack.pop();
        
        return returnValue;
        
    }
    
}
