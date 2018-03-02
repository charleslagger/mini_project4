package com.tsdv.miniproject4;

public class Dictionary {
    private int size;
    private BST[] bsts;

    public Dictionary(int size) {
        this.size = size;
        this.bsts = new BST[size];
    }

    public Item find(String key){
        int index = hash(key);

        if(bsts[index] == null){
            return null;
        }

        return bsts[index].find(key);
    }

    public void insert(String key, StaffInfo value){
        int index = hash(key);

        if(bsts[index] == null){
            bsts[index] = new BST();
        }

        bsts[index].insert(new Item(key, value));
    }

    // hash value between 0 and m-1
    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }


    public void delete(String key) {
        int index = hash(key);

        if(bsts[index] == null){
            throw new NullPointerException("Staff's id doesn't exist");
        }

        bsts[index].delete(key);
    }
}
