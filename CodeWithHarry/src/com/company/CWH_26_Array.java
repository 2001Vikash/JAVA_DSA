package com.company;

public class CWH_26_Array {
    public static void main(String[] args) {
        /* Classroom of 500 students --> we need to store marks of all these students
        we have tow option
                1--> use 500 variables
                2--> use Arrays(recommended)*/
        // There are mainly three way to represent an Array in Java.
        // 1--> Declaration and memory Allocation.
        //int [] marks= new int[5];
        // 2--> Declaration and then memory Allocation.
//        int [] mark;
//        mark = new int[5];
//        // initialization
//        mark[0]=54;
//        mark[1]=94;
//        mark[2]=54;
//        mark[3]=84;
//        mark[4]=57;
//        mark[4]=67;// --> isse 57 ke jagah pr 67 aa jayega(overwriting)
        //mark[5]=56;--> its throw an error because memory allocation 0-4 hai.
        // 3-->  Declaration , memory Allocation ,and initialization happen together.
        int[] mark = {23,43,54,35,24};
        System.out.println(mark[4]);
    }
}
