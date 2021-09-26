package com.company;

public class Tree {

    private Node root;

    public void add(int value){
        root = addRecursive(value, root);
    }

    private Node addRecursive(int value, Node node){
        if(node == null){
            Node newNode = new Node();
            newNode.setValue(value);
            return newNode;
        }
        if (value < node.getValue()){
            node.setLeft(addRecursive(value, node.getLeft()));
        }else if(value > node.getValue()){
            node.setRight(addRecursive(value, node.getRight()));
        }else{
            return node;
        }
        return node;
    }

    public boolean search(int value){
        return searchRecursive(value, root);
    }

    private boolean searchRecursive(int value, Node node){
        if(node == null){
            return false;
        }
        if(value == node.getValue()){
            return true;
        }
        if(value < node.getValue()){
            return searchRecursive(value, node.getLeft());
        }
        if(value > node.getValue()){
            return searchRecursive(value, node.getRight());
        }
        return false;
    }

    public void delete(int value){
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.getValue()) {
            //if it is a leaf
            if(node.getLeft() == null && node.getRight() == null){
                return null;
            }
            //if it has only left or right
            if (node.getRight() == null) {
                return node.getLeft();
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            //both
            int smallestValue = findSmallestValue(node.getRight());
            node.setValue(smallestValue);
            node.setRight(deleteRecursive(node.getRight(), smallestValue));
            return node;
        }
        if (value < node.getValue()) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
            return node;
        }
       node.setRight(deleteRecursive(node.getRight(), value));
        return node;
    }

    public void straightPrint(){
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getValue() + " ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    public void symmetricalPrint(){
        printInorder(root);
        System.out.println();
    }

    private void printInorder(Node node){
        if(node == null){
            return;
        }
        printInorder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInorder(node.getRight());
    }

    public void reversePrint(){
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node node){
        if(node == null){
            return;
        }
        printPostorder(node.getLeft());
        printPostorder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    private int findSmallestValue(Node node) {
        while(node != null && node.getLeft() != null){
            node = node.getLeft();
        }
        assert node != null;
        return node.getValue();
    }
}
