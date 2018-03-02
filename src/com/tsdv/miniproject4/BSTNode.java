package com.tsdv.miniproject4;

public class BSTNode {
    private Item item;
    private BSTNode leftChild;
    private BSTNode rightChild;

    private int size; //number of nodes in sub trees

    public BSTNode(Item item, int size) {
        this.item = item;
        this.leftChild = null;
        this.rightChild = null;
        this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
