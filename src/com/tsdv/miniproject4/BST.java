package com.tsdv.miniproject4;

public class BST {
    private BSTNode root;

    public void insert(Item I) {
        if (I.getKey() == null) throw new IllegalArgumentException("calls insert() with a null key");
        if (I.getValue() == null) {
            delete(I.getKey());
            return;
        }
        root = insert(root, I);
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    public Item find(String k) {
        if (k == null) {
            throw new IllegalArgumentException("calls find() with a null key");
        }

        return find(root, k);
    }

    private Item find(BSTNode x, String key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.getItem().getKey());
        if (cmp < 0) return find(x.getLeftChild(), key);
        else if (cmp > 0) return find(x.getRightChild(), key);
        else return x.getItem();
    }

    private BSTNode insert(BSTNode r, Item item) {
        if (r == null) return new BSTNode(item, 1);
        int cmp = item.getKey().compareTo(r.getItem().getKey());
        if (cmp < 0) r.setLeftChild(insert(r.getLeftChild(), item));
        else if (cmp > 0) r.setRightChild(insert(r.getRightChild(), item));
        else r.getItem().setValue(item.getValue());
        return r;
    }

    private BSTNode delete(BSTNode x, String key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.getItem().getKey());
        if (cmp < 0) x.setLeftChild(delete(x.getLeftChild(), key));
        else if (cmp > 0) x.setRightChild(delete(x.getRightChild(), key));
        else {
            if (x.getRightChild() == null) return x.getLeftChild();
            if (x.getLeftChild() == null) return x.getRightChild();
            BSTNode t = x;
            x = min(t.getRightChild());
            x.setRightChild(deleteMin(t.getRightChild()));
            x.setLeftChild(t.getLeftChild());
        }

        return x;
    }

    private BSTNode min(BSTNode r) {
        if (r.getLeftChild() == null) return r;
        else return min(r.getLeftChild());
    }

    private BSTNode deleteMin(BSTNode r) {
        if (r.getLeftChild() == null) return r.getRightChild();
        r.setLeftChild(deleteMin(r.getLeftChild()));
        return r;
    }
}
