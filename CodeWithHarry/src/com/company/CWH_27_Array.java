package com.company;

import javax.sound.midi.Soundbank;

public class CWH_27_Array {
    public static void main(String[] args) {
//        int [] marks = {34,56,32,45,78};
//        System.out.println(marks.length);
//        System.out.println(marks[2]);
//        float [] marks1 = {23.4f,56.7f,87.65f,45.5f,32.56f};
//        System.out.println(marks1.length);
//        System.out.println(marks1[2]);
//        String [] students = {"Vikash","Mukesh", "Sattu","Shiwam","gk"};
//        System.out.println(students.length);
//        System.out.println(students[2]);
        int [] marks = {34,56,32,45,78};
        // Display the Array elements(naive(masum) way)
//        System.out.println(marks[0]);
//        System.out.println(marks[1]);
//        System.out.println(marks[2]);
//        System.out.println(marks[3]);
//        System.out.println(marks[4]);
        // Display using For Loop.
//        for (int i=0;i<marks.length;i++){// its also called Array Traversal.
//            System.out.println(marks[i]);
//        }
        // Display in reverse order
//        for (int i= (marks.length-1);i!=-1;i--){// or i>=0 bhi likh sakte hai
//            System.out.println(marks[i]);
//        }
        // Display using for-each-loop// here only elements are printed no information about indexing.
        for (int element:marks) {
            System.out.println(element);
        }
    }
}
