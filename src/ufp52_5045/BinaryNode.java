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
public class BinaryNode {
    
    Object data;                // Information that is to be stored in the node.
    int leftChild;              // Index of the node's left child
    int rightChild;             // Index of the node's right child
    
    public BinaryNode(Object info) {
        data = info;
        leftChild = -1;         // -1 means there is no child
        rightChild = -1;
    }
    
}
