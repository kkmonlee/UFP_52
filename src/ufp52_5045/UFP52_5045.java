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
public class UFP52_5045 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BinaryTree b = new BinaryTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(9);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);
        System.out.println("Original tree: ");
        b.display(BinaryTree.root);
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
	System.out.println("Delete Node with no children (2) : " + b.delete(2));		
	b.display(BinaryTree.root);
	System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
	b.display(BinaryTree.root);
	System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
	b.display(BinaryTree.root);
        
        
        
        
        
        
        
        
//        Stack stack = new Stack();
//        
//        stack.push(80);
//        stack.push(28);
//        stack.push(231);
//        stack.print();
//        stack.pop();
        
        
        
//        CircularQueue queue = new CircularQueue();
//        queue.print();
//        queue.insert(78);
//        queue.print();
//        queue.delete();
//        queue.print();
//        queue.insert(99);
//        queue.print();
       
//        SierpinskiCarpet carpet = new SierpinskiCarpet();
//        carpet.run();
        
        
    }
    
}
