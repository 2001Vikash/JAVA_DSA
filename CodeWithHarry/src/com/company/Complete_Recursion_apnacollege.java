package com.company;

public class Complete_Recursion_apnacollege {
//    static void printNum(int n){
//        if(n==0){// base case
//            return;
//        }
//        System.out.println(n);//print
//        printNum(n-1);// recursion
//    }
//
//    public static void main(String[] args) {
//        int x=5;
//        printNum(x);
//    }
//        // RECURSION EASY PROBLEM 1
//    public static void main(String[] args) {
//         printNum(5);
//    }
//    static void printNum(int n){
//        if(n==10){// base case
//            return;
//        }
//        System.out.println(n);//print
//        printNum(n+1);// recursion
//    }
//         //RECURSION EASY PROBLEM 2
//public static void main(String[] args) {
//          printNum(1);
//}
          //RECURSION EASY PROBLEM 3
 // static void sumNum(int a,int n,int sum ){
//        if (a==n){
//            sum+=a;
//            System.out.println(sum);
//            return;
//        }
//       sum+=a;
//        sumNum(a+1,n,sum);
//        System.out.println(a);
 //   } // OR
//         static int sumNum(int n){
//             if(n==6){
//                 return 0;
//             }
//             int sum_call = sumNum(n+1);
//             int result = n + sum_call;
//             return result;
//         }
//public static void main(String[] args) {
//  //sumNum(1,5,0);
//    System.out.println(sumNum(1));
//}
    //RECURSION EASY PROBLEM 4
//    static int fact(int n){
//        if(n==0 || n==1){
//
//           return 1;
//        }
//          int fact_in = fact(n-1);
//        int factorial = n*fact_in;
//
//        return factorial;
//    }
//public static void main(String[] args) {
//    System.out.println(fact(6));
//} //OR
//        static void sumNum(int a,int n,int fact ){
//        if (a==n){
//            fact*=a;
//            System.out.println(fact);
//            return;
//        }
//       fact*=a;
//        sumNum(a+1,n,fact);
//        System.out.println(a);
//    }
//public static void main(String[] args) {
//  sumNum(1,5,1);
//}
        // RECURSION EASY PROBLEM 5
//    static void printFib(int a ,int b, int n){
//        if(n==0){
//            return;
//        }
//          int c = a+b;
//        System.out.print(" "+c);
//        printFib(b,c,n-1);
//    }
//public static void main(String[] args) {
//    int a=0,b=1,num=7;
//    System.out.print(a+ " "+b);
//
//    printFib(a,b,num-2);// n-2 kyoki 0 ,1 hamne pahle hi print kra liya hai
//}
    // RECURSION EASY PROBLEM 6
//    static int printPow(int x,int n){
//        if(x==0 ){
//            return 0;
//        }
//        if (n==0){ // n==0 , x==0 se pahle lete hai to 0^0 =1 dega.
//            return 1;
//        }
//              int xpownm1 = printPow(x,n-1); //here n is the height of stack.
//            int xpow = x*xpownm1;
//            return xpow;
//    }
//public static void main(String[] args) {
//    System.out.println(printPow(1,0));
//}
    // RECURSION EASY PROBLEM 6 --> PRINT x^n (STACK HEIGHT = log n)
//    static int powccalc(int x ,int n){
//        if(x==0){
//            return 0;
//        }
//        if(n==0){
//            return 1;
//        }
//        if(n%2==0){// if n is even
//            return powccalc(x,n/2)* powccalc(x,n/2);
//        }
//        else{// if n is odd.
//            return powccalc(x,n/2)* powccalc(x,n/2)*x;
//        }
//    }
//public static void main(String[] args) {
//    System.out.println(powccalc(1,0));
//}
}
