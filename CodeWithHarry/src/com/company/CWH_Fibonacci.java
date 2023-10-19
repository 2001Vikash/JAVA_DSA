package com.company;
import java.util.Scanner;
public class CWH_Fibonacci {
    public static void main(String[] args) {
        // Fibonacci series = 0,1,1,2,3,5,8,13,21.....
        // fib(n) = fib(n-1) + fib(n-2).
       // int n=5;// 5 numbers of fibonacci series.
        Scanner sc = new Scanner(System.in);
        System.out.println("Which number of fibonacci series you want to print!");
        int n = sc.nextInt();
       int n1=0,n2=1,n3=1;
      //  System.out.print(n1 + " "+ n2);
        if(n==1){
            System.out.println(n1);
        }
        else {
            for (int i = 2; i < n; i++) {
                n3 = n2 + n1;
//           System.out.print(" " + n3);
                n1 = n2;
                n2 = n3;
            }

            System.out.print("This is your "+n+"th fibonacci number = " + n3);
        }
    }
}
