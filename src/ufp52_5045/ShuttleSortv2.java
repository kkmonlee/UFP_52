/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

/**
 * Sorts an array of integers into ascending order recursively: 
 * (FIRST PASS) 
 * Step 1:  Compares the first 2 numbers. If number on the right is smaller, 
 *          then swap.
 * Step 2:  Move one step forward in the list and compare the 2 numbers. If
 *          number of the right is smaller than swap.
 * Step 3:  Repeat step 2 until all numbers on the right have been compared.
 *
 */
public class ShuttleSortv2 {
    
    static int data[] = {9, 5, 1, 4, 7, 2, 3, 8, 6, 10};
    
    /**
     * Sorts an array of integers called data[] in ascending order.
     * Sorts a data pair with index given (first element of the pair)
     * 
     * @param m Index
     */
    static void sort(int m) {
        
        if ((data[m] > data[m + 1])) {
            
            int temp = data[m];
            data[m] = data[m + 1];
            data[m + 1] = temp;
            
            m--;
            
            if (m != -1) {
                sort(m);
            }
        }
    }
    
    public static void main(String[] args) {
        // Gets number of elements in the array
        int numElements = data.length;
        
        System.out.println("Unsorted array: \n");
        for (int d : data) {
            System.out.print(d + ", ");
        }
        
        for (int i = 0; i < numElements - 1; i++) {
            sort(i);
        }
        
        System.out.println("\nSorted array: \n");
        for (int d : data) {
            System.out.print(d + ", ");
        }
    }
}
