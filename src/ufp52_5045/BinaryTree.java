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
public class BinaryTree {
    
    BinaryNode info[];      // Array of nodes used
    int maxNodes;           // Number of nodes
    int root;               // Position of root node in the array
    int free;               // Position of the first free node in the array
    
    // Create an empty tree
    BinaryTree(int size) {
        
        maxNodes = size;
        info = new BinaryNode[maxNodes];
        root = -1;
        free = 0;
        
        for (int position = 0; position < maxNodes - 1; position++) {
            info[position] = new BinaryNode(null);
            info[position].leftChild = position + 1;
        }
        
        info[maxNodes - 1] = new BinaryNode(null);
        info[maxNodes -1].leftChild = -1;
        
    }
    
    // Create a tree with 1 node (aka root) with a given value
    BinaryTree(int size, Object rootValue) {
        maxNodes = size;
        info[0] = new BinaryNode(rootValue);
        
        for (int position = 1; position < maxNodes - 1; position++) {
            info[position] = new BinaryNode(null);
            info[position].leftChild = position + 1;
        }
        
        info[maxNodes - 1] = new BinaryNode(null);
        info[maxNodes - 1].leftChild = -1;
    }
    
}
