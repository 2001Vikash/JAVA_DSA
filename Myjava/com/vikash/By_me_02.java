package com.vikash;
import java.util.Scanner;
public class By_me_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your positive numer ");
        int n =sc.nextInt();
       int sum=0;
//        while(n!=0){
//            sum = sum + n%10;
//            n=n/10;
//
//        }
//        for(int i=0;i<n;n=n/10){
//            sum = sum + n%10;
//        }
//        do{
//            sum = sum + n%10;
//            n = n/10;
//        }while(n!=0);
        System.out.println("This is the sum of your number is = " + sum);
    }
}
