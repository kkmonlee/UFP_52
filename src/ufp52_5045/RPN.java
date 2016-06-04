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
public class RPN {
    
    Stack stack = new Stack("10");
    
    int calculate(String[] arr) {
        
        int returnValue = 0;
        String operators = "+-*/";
        
        
        for (String t : arr) {
            if (!operators.contains(t)) {
                stack.push(Integer.parseInt(t));
            } else {
                int a = stack.pop(); // operand 2
                int b = stack.pop(); // operand 1
                int index = operators.indexOf(t);
                
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
