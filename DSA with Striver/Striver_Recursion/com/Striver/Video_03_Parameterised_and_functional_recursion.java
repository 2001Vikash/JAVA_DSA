package com.Striver;
public class Video_03_Parameterised_and_functional_recursion {

    // Problem --> Sum of first n natural numbers.
    // Sum with the help of recursive or functional way.
//    public static int calcSum(int n){
//        if(n==0){
//            return 0;
//        }
//        return n+ calcSum(n-1);
//    }
//    public static void main(String[] args) {
//        System.out.println(calcSum(5));
//    }

    // Sum with the help of parameterised way.
//    public static void printSum(int i, int sum){
//        if(i<1){
//            System.out.println(sum);
//            return;
//        }
//        printSum(i-1,sum+i);
//    }
//    public static void main(String[] args) {
//        printSum(5,0);
//    }


    // Factorial of n.
    // this is a recursive way.
//    public static int calcFact(int n){
//        if(n==0){
//            return 1;
//        }
//        return n* calcFact(n-1);
//    }
//    public static void main(String[] args) {
//        int n=5;
//        System.out.println("Factorial of "+n+" is = "+calcFact(n));
//    }

    // parameterised way
// Time complexity O(n) and space complexity which is auxiliary space or stack space is also O(n).
//    public static void printFact(int n,int f){
//        if(n==0){
//            System.out.println(f);
//            return ;
//        }
//        printFact(n-1,f*n);
//    }
//    public static void main(String[] args) {
//        printFact(5,1);
//    }
}
