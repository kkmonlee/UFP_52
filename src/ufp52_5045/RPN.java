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
    
    Stack stack = new Stack();
    
    int calculate(String[] arr) {
        
        int returnValue = 0;
        String operators = "+-*/";
        
        for (String t : arr) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                
                switch(index) {
                    case 0:
                        stack.push(Integer.valueOf(a + b));
                        break;
                    case 1:
                        
                }
            }
        }
        
    }
    
}
