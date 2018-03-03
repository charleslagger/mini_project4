package com.tsdv.miniproject4;

import java.util.Scanner;

public class DictionaryForm {
    private static Dictionary dic;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        dic = new Dictionary(10);

        addNew();

        findWord();


//        deleteWord();
//
//        findWord();
    }

    private static void findWord() {
        System.out.println("Enter staffId to find: ");
        String key = sc.next();

        Item item = dic.find(key);
        if(item == null){
            System.out.println("Don't exist staff id in DB");
        }else{
            System.out.println("Info staff is: " + item.getValue());
        }

    }

    private static void addNew() {

        dic.insert("ID001", "Nguyen Van A");
        dic.insert("ID002","Le Van B");
        dic.insert("ID003", "Tran Thi C");
        dic.insert("ID004", "Le Van D");
    }

    private static void deleteWord() {
        dic.delete(sc.next());
    }
}
