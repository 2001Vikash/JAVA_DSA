package com.company;
import java.util.Scanner;
public class CWH_35_Practice_problem {

    // PROBLEM  1

    // recursive method
//        static void printmul(int i , int n){
//        if(i==11){
//            return;
//        }
//         // i=1; ye barbar i=1 kr dega so its shoe stack overflow.
//        System.out.println(n*i);
//        printmul(i+1,n);
//
//    }
    // itrative method
//    static void mult(int n) {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(n + " x " + i + " = " + n * i);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        printmul(1,x);
//    }
       //  PROBLEM 2

//    static void printStar(int n){
//        for(int i=0;i<n;i++){
//            int j=0;
//            for(;j<=i;j++){
//                System.out.print(" * ");
//            }
//            System.out.println("");
//        }
//    }
//    public static void main(String[] args) {
//           printStar(5);
//    }

          // PROBLEM 3
//        static void Printsum(int a,int n, int sum){
//
//            if(a==n){
//                sum = sum+a;
//                System.out.println(sum);
//                return;
//            }
//            sum+=a;
//            Printsum(a+1,n,sum);
//            return ;
//        }
//    public static void main(String[] args) {
//        Printsum(1,5,0);
//    }  // OR
//      static int Printsum(int n){
//          if(n==5){
//              return 0;
//          }
//          int sump1  = Printsum(n+1);
//          int result = n+sump1;
//          return result;
//      }
//    public static void main(String[] args) {
//        int x =0;
//        System.out.println(Printsum(x));
//    }  // OR

//        static
//         int sumRec(int n){
//            if(n==6){
//                return 0;
//            }
//            return n+sumRec(n+1);
//        }
//          public static void main(String[] args) {
//              int x=1;
//              System.out.println(sumRec(x));
//          }

    // PROBLEM 4

//      static void printStar(int n){
//          for(int i=n;i!=0;i--){
//              for(int j=0;j<=i;j++){
//                  System.out.print("* ");
//              }
//              System.out.println("");
//          }
//      }
//    public static void main(String[] args) {
//        printStar(5);
//    }

    // PROBLEM 5

//       static int fib(int n){
//           if(n==1 || n==2){
//               return n-1;
//           }
//           return fib(n-1)+fib(n-2);
//    }
//    public static void main(String[] args) {
//           Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your number");
//           int x= sc.nextInt();
//        System.out.println("Its "+x+" Fibonacci term = "+fib(x));
//    }

    // PROBLEM 6

//     static float Avg(float sum,int ...arr){
//         for(int i=0;i< arr.length;i++){
//             sum = sum+arr[i];
//         }
//         return (sum/ arr.length);
//     }
//    public static void main(String[] args) {
//        System.out.println(Avg(0,2,4,5,6,7,6));
//    }

    // PROBLEM 7

//     static void recStar(int n){
//         if(n==5){
//             return;
//         }
//         recStar(n+1);
//         for(int i=0;i<n;i++){
//             System.out.print("* ");
//         }
//         System.out.println("");
//     }
//    public static void main(String[] args) {
//        recStar(1);
//    }

    // PROBLEM 8

//    static void recStar(int n){
//        if(n==0){
//            return;
//        }
//        recStar(n-1);
//        for(int i=0;i<n;i++){
//            System.out.print("* ");
//        }
//        System.out.println("");
//    }
//    public static void main(String[] args) {
//        recStar(5);
//    }

    // PROBLEM 9

//    static float forn(float c){
//       float result =  (c * (9.0f/5) + 32) ;
//       return result;
//
//    }
//    public static void main(String[] args) {
//        float celsious = 37.0f;// in degree centigrade
//        System.out.println("Temperature in Fohrenheit = "+forn(celsious));
//    }

    // PROBLEM 10

//    public static void main(String[] args) {
//        Scanner vy = new Scanner(System.in);
//        System.out.println("Enter your number of first natural numbers");
//        int n= vy.nextInt();
//        int [] arr = new int[n];
//        System.out.println("Now Enter your numbers");
//        for(int i=0;i< arr.length;i++){
//            arr[i]=vy.nextInt();
//        }
//       float sum = 0;
//        for (int j=0;j< arr.length;j++){
//            sum =sum+arr[j];
//        }
//        float avg = sum/n;
//        System.out.println("This is the average value of first "+n+" natural numbers = "+avg);
//    }
}