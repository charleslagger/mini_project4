package com.tsdv.miniproject4;

public class BSTNode {
    private Item data;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(Item data, int size) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Item getItem() {
        return data;
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
}
