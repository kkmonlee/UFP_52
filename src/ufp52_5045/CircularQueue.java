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
public class CircularQueue {
    int capacity;               // maximum queue size
    int head;             // head and tail pointers
    int tail;
    int numElements;            // size of the queue
    
    int[] queue;                   // the queue
    
    // Constructor method
    CircularQueue(final int size) {
        capacity = size;
        head = 0;
        tail = -1;
        numElements = 0;
        queue = new int[capacity];
    }
    
    // Polymorphic constructor
    CircularQueue() {
        capacity = 7;
        head = 0;
        tail = -1;
        numElements = 0;
        queue = new int[capacity];
    }
    
    // Checks whether the queue is empty or not
    boolean isEmpty() {
        return numElements == 0;
    }
    
    // Checks whether the queue is full or not
    boolean isFull() {
        return numElements == capacity;
    }
    
    // Removes the first element (in head pointer) from the array
    // Decrements the size of the queue by 1
    int delete() {
        if (!isEmpty()) {
            int value = queue[head];
            queue[head] = 0;
            head = (head + 1) % capacity;
            numElements--;
            
            return value;
            
        } else {
            System.err.println("Queue empty! \n");
            return '?';
        }
    }
    
    // Adds the new element to the (tail + 1) pointer
    // Increments size of the queue by 1
    void insert(int element) {
        if (!isFull()) {
            tail = (tail + 1) % capacity;
            queue[tail] = element;
            numElements++;
        } else 
            System.err.println("Queue full! \n");
    }
    
    // Prints the head, tail, size of the array, and the elements in queue[]
    void print() {
        System.out.println("Size of queue: " + numElements);
        System.out.println("Head pointer: " + head);
        System.out.println("Tail pointer: " + tail);
        System.out.print("Elements in queue: ");
        
        for (int i = 0; i < capacity; i++) {
            System.out.print("Queue[" + i + "]=" + queue[i] + ", ");
            
        }
        System.out.println();
        
    }
}
