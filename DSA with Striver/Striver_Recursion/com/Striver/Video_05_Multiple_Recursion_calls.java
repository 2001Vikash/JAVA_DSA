package com.Striver;

public class Video_05_Multiple_Recursion_calls {

    //  Print Fibonacci number

    // Time Complexity (2^n) not exactly but exponential in nature.
//    public static int printFib(int n){
//        if(n==0){
//            return 0 ;
//        }
//        if(n==1){
//            return 1;
//        }
//        return printFib(n-1)+printFib(n-2);
//
//    }
//    public static void main(String[] args) {
//        System.out.println(printFib(3));
//    }

    // OR

//    public static void printFib(int n, int a, int b){
//        if(n==2){
//            return;
//        }
//        int c = a+b;
//        System.out.print(c+" ");
//        printFib(n-1,b,c);
//    }
//    public static void main(String[] args) {
//        int n=6;
//        if(n==1) {
//            System.out.print("0 ");
//        }
//            else if(n==2){
//            System.out.print("0 "+"1 ");
//            }
//         else {
//            System.out.print("0 "+"1 ");
//            printFib(n, 0, 1);
//        }
//    }


//    public static void main(String[] args) {
//
//    }
}
