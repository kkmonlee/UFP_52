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
public class RPNv3 {
    
    Stack stack = new Stack("50");
    
    int calculate(String expression) {
        
        int returnValue;
        String operators = "+-*/^";
        String symbol;
        
        StringTokenizer token = new StringTokenizer(expression, " ");
        
        
        while (token.hasMoreTokens()) {
            symbol = token.nextToken();
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
                    case 4:
                        double result = Math.pow(b, a);
                        int result2 = (int)result;
                        
                        stack.push(result2);
                        break;
                }
            }
        } // end while
        
        returnValue = stack.pop();
        
        return returnValue;
    }
    
    public static void main(String[] args) {
        RPNv3 rpn = new RPNv3();
        
        rpn.calculate("2 7 ^");
    }
    
}
