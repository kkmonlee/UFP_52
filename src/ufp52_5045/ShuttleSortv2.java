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
// Recursive version
public class ShuttleSortv2 {
    
    static int data[] = {9, 5, 1, 4, 7, 2, 3, 8, 6, 10};
    
    static void sort(int m, int n) {
        if ((data[m] > data[n])) {
            int temp = data[m];
            data[m] = data[n];
            data[n] = temp;
            
            m--;
            n--;
            
            if (m != -1) {
                sort(m, n);
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
            sort(i, i + 1);
        }
        
        System.out.println("Sorted array: \n");
        for (int d : data) {
            System.out.print(d + ", ");
        }
    }
}
