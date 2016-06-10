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
public class LinkedList {
    final int capacity = 10;
    String item[] = new String[capacity];
    int itemSize = 0;
    int currentLocation;
    
    // Adds items (element) onto the item[] array
    void addItems(String element) {
        if (element != null) {
            item[itemSize] = element;
            itemSize++;
        }
    }
    
    // Deletes item (element) from the item[] array
    void deleteItems(String element) {
        int flag = 0;
        if (itemSize > 0) {
            for (int i = 0; i < itemSize; i++) {
                if (item[i].equals(element)) {
                    flag = 1;
                    currentLocation = i;
                    break;
                }
            }
            
            if (flag == 0) {
                System.out.println("No such element to delete such as '" + element + "'");
            } else if (flag == 1) {
                for (int i = currentLocation + 1; i < itemSize; i++) {
                    item[currentLocation] = item[i];
                    currentLocation++;
                }
                itemSize--;
                System.out.println("'" + element + "' element is deleted.");
            }
        }
    }
    
    // Prints all the elements in the array
    void viewItems() {
        if (itemSize > 0) {
            System.out.println("The elements in the Linked List are: ");
            for (int i = 0; i < itemSize; i++) {
                System.out.print(item[i] + ", ");
            }
            System.out.println();
        }
    }
    
    public static void main (String a[]) {
        LinkedList list = new LinkedList();
        
        list.addItems("a");
        list.addItems("b");
        list.addItems("c");
        list.viewItems();
        
        list.deleteItems("b");
        list.viewItems();
    }
}
