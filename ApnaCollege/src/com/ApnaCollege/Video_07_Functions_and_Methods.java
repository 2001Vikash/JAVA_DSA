package com.ApnaCollege;

import java.util.Scanner;

public class Video_07_Functions_and_Methods {
    // Question -->1
//    public static void printMyName(String name){// it can work nicely without public.
//        System.out.println(name);
//        return;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String name=sc.nextLine();
//        printMyName(name);
//    }
    // Question -->2
//    public static  int returnSum(int i,int j){
//        int sum=i+j;
//        return sum;
//    }
//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int a= sc.nextInt();
//        int b=sc.nextInt();
//        System.out.println(returnSum(a,b));
//    }
    // Question -->3
//    public static  int calculateProduct(int i,int j){
//        int p=i*j;
//        return p;
//        // return i*j bhi work karega
//    }
//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        int a= sc.nextInt();
//        int b=sc.nextInt();
//        System.out.println("Product ="+calculateProduct(a,b));
//    }
    // Question -->
// imp note--> void function hai to return nahi bhi karenge to work ho jayega
//    public static void factorial(int k){
//        int f=1;
//        if(k<0){
//            System.out.println("Invalid inputs");
//            return ;// ye return nhi rahega to programe aage bhi execute hoga. aur neg value pr bhi ans 1 aayega
//        }
//        for(int i=1;i<=k;i++){
//            f=f*i;
//        }
//        System.out.println(f);
//        return;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        factorial(n);
//    }

    // Homework Problem -->1

//    public static void checkPrime(int a){
//        int d=0;
//        for(int i=1;i<=a;i++){
//            if(a%i==0){
//                d++;
//            }
//        }
//        if(d==2){
//            System.out.println("Prime");
//        }
//        else{
//            System.out.println("Not Prime");
//        }
//        return;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        checkPrime(n);
//    }

      // Homework Problem -->2
//      public static void checkEvenOrNot(int a){
//
//        if(a%2==0){
//            System.out.println("Even");
//        }
//        else{
//            System.out.println("Odd");
//        }
//        return;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        checkEvenOrNot(n);
//    }
    // Homework Problem -->3

//    public static void printTable(int a){
//        System.out.println("Table of "+a+" is:");
//        for(int i=1;i<=10;i++){
//            System.out.println(a+" x "+i+" = "+a*i);
//        }
//        return;
//    }
//      public static void main(String[] args) {
//          Scanner sc= new Scanner(System.in);
//          int n=sc.nextInt();
//          printTable(n);
//      }


    }

