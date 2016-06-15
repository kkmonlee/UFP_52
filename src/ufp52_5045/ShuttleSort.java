/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufp52_5045;

import java.util.Arrays;

/**
 * Sorts an array of integers into ascending order: 
 * (FIRST PASS) 
 * Step 1:  Compares the first 2 numbers. If number on the right is smaller, 
 *          then swap.
 * Step 2:  Move one step forward in the list and compare the 2 numbers. If
 *          number of the right is smaller than swap.
 * Step 3:  Repeat step 2 until all numbers on the right have been compared.
 *
 */
public class ShuttleSort {

    /**
     * Sorts an array of integers in ascending orders.
     *
     * @param arr the array of elements
     */
    static void sort(int[] arr) {
        boolean swapped = false;
        int start = 0;
        int end = arr.length - 1;

        do {
            /**
             * Reset the swapped flag on entering the loop because it might be
             * true from a previous iteration.
             */
            swapped = false;

            // Loop goes from top to bottom
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            
            // If the number on the RHS is greater than LHS then nothing to do
            if (!swapped) {
                // Break out of this loop
                break;
            }
            
            /**
             * Otherwise, reset the swapped flag so it can be used in the next
             * pass.
             */
            swapped = false;
            
            /**
             * Move the end point back by 1, because the item at the end 
             * is in its correct position.
             */
            end--;
            
            /**
             * Loop from top to bottom, similarly comparing like above.
             */
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            
            /**
             * Increase the starting point because the last stage would have
             * moved the next smallest number to its correct position.
             */
            start++;
            
        } while (swapped);

        System.out.println(Arrays.toString(arr) + ", ");
    }
    
    /**
     * Swaps a and b around in the array
     * 
     * @param array the array of integers
     * @param a first element
     * @param b second element
     */
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int unsortedArray[] = {1, 4, 2, 62, 234, 212, 12, 74, 46};
        sort(unsortedArray);
    }

}
