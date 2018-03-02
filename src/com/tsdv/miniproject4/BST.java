package com.tsdv.miniproject4;

public class BST {
    private BSTNode root;

    public void insert(Item item) {
        if (item.getKey() == null) throw new IllegalArgumentException("calls put() with a null key");
        if (item.getStaffInfo() == null) {
            delete(item.getKey());
            return;
        }
        root = put(root, item);
    }

    private BSTNode put(BSTNode x, Item item) {
        if (x == null) return new BSTNode(item, 1);
        int cmp = item.getKey().compareTo(x.getItem().getKey());
        if (cmp < 0) x.setLeftChild(put(x.getLeftChild(), item));
        else if (cmp > 0) x.setRightChild(put(x.getRightChild(), item));
        else x.getItem().setStaffInfo(item.getStaffInfo());
        x.setSize(1 + size(x.getLeftChild()) + size(x.getRightChild()));
        return x;
    }

    private int size(BSTNode x) {
        if (x == null) return 0;
        else return x.getSize();
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
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
        x.setSize(size(x.getLeftChild()) + size(x.getRightChild()) + 1);
        return x;
    }

    private BSTNode min(BSTNode x) {
        if (x.getLeftChild() == null) return x;
        else return min(x.getLeftChild());
    }

    private BSTNode deleteMin(BSTNode x) {
        if (x == null) return x.getRightChild();
        x.setLeftChild(deleteMin(x.getLeftChild()));
        x.setSize(size(x.getLeftChild()) + size(x.getRightChild()) + 1);
        return x;
    }


    public Item find(String key) {

        if (key == null) {
            return null;
        }

        return getItemByKey(key);
    }

    private Item getItemByKey(String key) {
        return search(root, key);
    }

    private Item search(BSTNode x, String key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.getItem().getKey());
        if (cmp < 0) return search(x.getLeftChild(), key);
        else if (cmp > 0) return search(x.getRightChild(), key);
        else return x.getItem();
    }
}
