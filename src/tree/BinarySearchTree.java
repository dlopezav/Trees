/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;
import java.util.*;
/**
 *
 * @author dlopezav
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable <? super T>> {

    private static class BinaryNode<T> {

        T element; // The data in the node
        BinaryNode<T> left; //Left child
        BinaryNode<T> right; //Right child

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty(T x) {
        root = null;
    }
    
    public void insert(T x) {
        root = insert(x, root);
    }

    public BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if(t == null){
            return new BinaryNode<T>(x,null,null);
        }
        int compare = x.compareTo(t.element);
        if (compare < 0){
            t.left = insert(x, t.left);
        }else if (compare > 0){
            t.right = insert(x,t.right);
        }else{
            
        }
        return t;
    }


    public BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) // exception!
        {
            return null;
        } else if (t.left == null){
            return t;
        }
        return findMin(t.left);
    }


    public BinaryNode<T> findMax(BinaryNode<T> t) {
            if (t == null) // exception!
            {
                return null;
            } else if (t.right == null) // maximum found
            {
                return t;
            }
            return findMax(t.right);
    }

    public boolean contains(T x, BinaryNode<T> t) {
            if ( t == null){
                return false;
            }
            int compare = x.compareTo(t.element);
            if(compare > 0){
                return contains(x,t.right);
            }
            if(compare < 0){
                return contains(x,t.left);
            }else{
                return true;
            }
    }

    

    public boolean isEmpty() {
           return root == null;
    }

    

    public BinaryNode<T> remove(T x, BinaryNode<T> t) {
            if (t == null) // exception!
            {
                return null;
            }
            int compare = x.compareTo(t.element);
            if (compare <0){
                return remove(x, t.left);
            }else if(compare >0){
                return remove(x, t.right);
            }else if  (t.left != null && t.right != null){
                t.element = findMin(t.right).element;
                t.right = remove (t.element, t.right);
            }else{
                if( t.left != null ) { 
                    t = t.left;
                }else{
                    t = t.right;
                }
            }
            return t;
    }


    public void printTreePRE(BinaryNode<T> t){
        if(t != null){
            System.out.println(t.element);
            printTreePRE(t.left);
            printTreePRE(t.right);
        }
    }
    public void printTreePOST(BinaryNode<T> t){
        if(t != null){
            printTreePRE(t.left);
            printTreePRE(t.right);
            System.out.println(t.element);
        }
    }
    public void printTreeIN(BinaryNode<T> t){
        if(t != null){
            printTreePRE(t.left);
            System.out.println(t.element);
            printTreePRE(t.right);
        }
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }
        

    
    };
