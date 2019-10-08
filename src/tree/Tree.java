/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author dlopezav
 */
public class Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> enteros = new BinarySearchTree();
        enteros.insert(8);
        enteros.insert(9);
        enteros.insert(12);
        enteros.insert(4);
        enteros.insert(3);
        enteros.insert(7);
        //enteros.print();
        enteros.printTreePOST(enteros.getRoot());
        System.out.println(enteros.findMin());
    }
    
}
