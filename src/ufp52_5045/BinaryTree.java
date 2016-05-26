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
    
    public static BinaryNode root;
    
    BinaryTree() {
        BinaryTree.root = null;
    }
    
    boolean find(int id) {
        
        BinaryNode current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
    
    boolean delete(int id) {
        
        BinaryNode parent = root;
        BinaryNode current = root;
        boolean isLeftChild = false;
        
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            
            if (current == null) {
                return false;
            }
        }
        
        // Node is found
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
        // If the node has only 1 child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        
        // Found the minimum element in the correct sub tree
        else if (current.left != null && current.right != null) {
            BinaryNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        
        return true;
                
    }
    
    BinaryNode getSuccessor(BinaryNode deleteNode) {
        BinaryNode successor = null;
        BinaryNode successorParent = null;
        BinaryNode current = deleteNode.right;
        
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }
    
    void insert(int id) {
        BinaryNode newNode = new BinaryNode(id);
        if (root == null) {
            root = newNode;
            return;
        }
        
        BinaryNode current = root;
        BinaryNode parent;
               
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    void display(BinaryNode root) {
        if (root != null) {
            display(root.left);
            System.out.println(" " + root.data);
            display(root.right);
        }
    }
    
    
    
}
