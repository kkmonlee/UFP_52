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
public class Stack {
    
    
    int pointer;
    int capacity = 10;
    int arr[] = new int[capacity];
    
    Stack(String size) {
        capacity = Integer.valueOf(size);
        pointer = -1;
    }
    
    
    
    void push(int element) {
        if (pointer < capacity -1) {
            
            pointer++;
            arr[pointer] = element;
            
            System.out.println("Element " + element + " has been pushed onto the Stack. \n");
            print();
        } else {
            System.out.println("Stack overflow! \n");
        }
    }
    
    int pop() {
        
        int value = 0;
        
        if (pointer >= 0) {
            value = arr[pointer];
            pointer--;
            System.out.println("The latest element has been removed/popped. \n");
            print();
            
        } else {
            System.out.println("Stack underflow! \n");
            System.exit(0);
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
    
    char printPointer() {
        return (char) pointer;
    }
    
    char peek(char element) {
        if (arr[pointer] == element) {
            return element;
        }
        return 0;
    }
    
    boolean isEmpty() {
        return (pointer == -1);
    }

    // machine generated
    boolean peek(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
