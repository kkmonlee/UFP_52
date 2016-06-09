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
public class LinkedListv2 {
    
    // referring to head node
    private Node head;
    private int listCount;
    
    // Constructor
    public LinkedListv2() {
        // This list will be empty so the reference to head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }
    
    // Appends the specified element to the end of the list
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        // Starting from head of the node to the end of the list
        while(current.getNext() != null) {
            current = current.getNext();
        }
        
        // Last node's next reference is set to the new node
        current.setNext(temp);
        // Increment the number of elements
        listCount++;
    }
    
    // Inserts the specified element at the specified position in the list
    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        // Go to the specified index or last element in the list
        // Whichever comes first
        
        // !!! Indexes start at position 1, not 0 !!!
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        
        // Set new node's "next node" reference to this node's "next node" reference
        temp.setNext(current.getNext());
        // Set this node's "next node" reference to the new node
        current.setNext(temp);
        // Incremement the number of elements
        listCount++;
    }
    
    // Returns the element at the specified position in the list
    public Object get(int index) {
        // Index must be 1 or higher
        if (index <=  0) 
            return null;
        
        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) 
                return null;
            
            current = current.getNext();
        }
        return current.getData();
    }
    
    // Removes the element at the specified position in the list
    public boolean remove(int index) {
        // Index must be in range
        if (index < 1 || index > size())
            return false;
        
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;
            
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        // Decremement the number of elements
        listCount--;
        return true;
    }
    
    // Returns the number of elements in the list
    public int size() {
        return listCount;
    }
    
    public String toString() {
        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }
    
    private class Node {
        // Reference to next node in chain
        // or value is null if there isn't a node
        Node next;
        // Data carried by the specified node
        // Any data type
        Object data;
        
        // Constructor
       public Node(Object _data) {
           next = null;
           data = _data;
       }
       
       // Constructor if we want to specify the node 
       // to point to
       public  Node(Object _data, Node _next) {
           next = _next;
           data = _data;
       }
       
       public Object getData() {
           return data;
       }
       
       public void setData(Object _data) {
           data = _data;
       }
       
       public Node getNext() {
           return next;
       }
       
       public void setNext(Node _next) {
           next = _next;
       }
    }
    
}

