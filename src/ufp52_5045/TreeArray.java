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
public class TreeArray {
    
    int[] left = new int[] {1, 2, -1, 4, -1, -1, -1, 8, -1};
    int[] right = new int[] {6, 3, -1, 5, -1, -1, 7, -1, -1};
    int[] data = new int[] {6, 2, 1, 4, 3, 5, 7, 9, 8};
    
    // left, right, root
    void postOrder(int index) {
        
        if (left[index] != -1) {
            postOrder(left[index]);
        }
        
        if (right[index] != -1) {
            postOrder(right[index]);
        }
        
        System.out.println(data[index]);
        
    }
    
    // left, root, right
    void inOrder(int index) {
        
        if (left[index] != -1) {
            inOrder(left[index]);
        }
        
        System.out.println(data[index]);
        
        if (right[index] != -1) {
            inOrder(right[index]);
        }
        
    }
    
    // root, left, right
    void preOrder(int index) {
        
        System.out.println(data[index]);
        
        if (left[index] != -1) {
            preOrder(left[index]);
        }
        
        if (right[index] != -1) {
            preOrder(right[index]);
        }
        
    }
    
    
}
