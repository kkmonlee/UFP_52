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
    final int capacity = 5;
    int arr[] = new int[capacity];
    
    Stack() {
        
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
    
    void pop() {
        
        if (pointer >= 0) {
            
            pointer--;
            System.out.println("The latest element has been removed/popped. \n");
            print();
            
        } else {
            System.out.println("Stack underflow! \n");
        }
        
        
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
