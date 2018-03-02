package com.tsdv.miniproject4;

import java.util.Scanner;

public class DictionaryForm {
    private static Dictionary dic;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dic = new Dictionary(10);

        addNew();
        findWord(sc.next());

        deleteWord(sc.next());

        findWord(sc.next());
    }

    private static void deleteWord(String id) {
        dic.delete(id);
    }

    private static void findWord(String id) {

        if(dic.find(id) == null){
            System.out.println("Don't exist staff id in DB");
        }else{
            System.out.println("Info staff is: " + dic.find(id).getStaffInfo().toString());
        }

    }

    private static void addNew() {

        dic.insert("ID001", new StaffInfo("Nguyen Van A", 24, StaffInfo.Gender.MALE));
        dic.insert("ID002", new StaffInfo("Le Van B", 30, StaffInfo.Gender.FEMALE));
        dic.insert("ID003", new StaffInfo("Tran Thi C", 25, StaffInfo.Gender.FEMALE));
        dic.insert("ID004", new StaffInfo("Le Van D", 22, StaffInfo.Gender.MALE));
    }
}
