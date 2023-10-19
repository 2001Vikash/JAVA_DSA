package com.company;

public class CWH_33_VarArgs {
//    static int sum(int a, int b){
//        return a+b;
//    }
//    static int sum(int a, int b,int c){
//        return a+b+c;
//    }
//    static int sum(int a, int b , int c, int d){
//        return a+b+c+d;
//    } // So here is need to make more methods for sum
    // This problem can  solve by VarArgs methods in using only one methods.
    static int sum(int x,int ...arr){// here ...arr is called as VarArgs.
     // avaible as int [] arr.// If we want to give atleast one argument then write int a, int ...arr.
        int result =x;
        for (int a: arr){
            result +=a;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to VarArgs tutorial !");
       // System.out.println(sum());// Its behaves like as an empty Array. because here is no passing arguments.print 0.
        // atleast one argument is required.
        System.out.println(sum(1));
        System.out.println(sum(4,3));
        System.out.println(sum(4,3,5));
        System.out.println(sum(4,3,5,6));
        System.out.println(sum(4,3,5,6,2));
    }
}
