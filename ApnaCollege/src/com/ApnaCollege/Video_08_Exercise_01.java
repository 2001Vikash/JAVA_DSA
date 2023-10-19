package com.ApnaCollege;

import java.util.Scanner;
/*
Java - Introduction to Programming
        Exercise 1
 */
public class Video_08_Exercise_01 {
    // Question -1
//    public static int Avg(int i,int j,int k){
//        return (i+j+k)/3;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        int b=sc.nextInt();
//        int c=sc.nextInt();
//        System.out.println("Average of given three numbers = "+Avg(a,b,c));
//    }
    // Question -2
//    public static int calcOddSum(int a){
//        int sum=0;
//        for(int i=1;i<=a;i++){
//            if(i%2!=0){
//                sum=sum+i;
//            }
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        System.out.println("Sum of all od numbers = "+calcOddSum(n));
//    }

    // Question -3

//    public static int greaterNum(int i, int j){
//        if(i>j){
//            return i;
//        }
//        else if(j>i){
//            return j;
//        }
//        else{
//            System.out.println("Both are equal");
//            return 0;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        int b=sc.nextInt();
//        System.out.println("greater number is ="+greaterNum(a,b));
//    }

    // 4. Write a function that takes in the radius as input and returns the circumference of a circle.
//    public static float circumference(float r){
//        float pi=3.14f;
//        return 2*pi*r;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        float radius=sc.nextFloat();
//        System.out.println("Circumference of the given circle is = "+circumference(radius));
//    }

    // Question -5
//    public static void voteForAge(int age){
//        if(age>=18){
//            System.out.println("You are eligible for Vote ");
//        }else {
//            System.out.println("Not eligible for Vote");
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int age=sc.nextInt();
//        //System.out.println(voteForAge(age));ye wrong hoga kyoki kuchh return ho nhi rha hai
//        voteForAge(age);
//    }

    // Question -6
//    public static void main(String[] args) {
//        int i=1;
//        do{
//            System.out.println("Hello Vikku");
//        }while(i==1);
//    }

    //Question -7
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int count0=0;
//        int countPos=0;
//        int countNeg=0;
//        while(true){
//            System.out.println("If we want to exit then press 'E' "+"Otherwise you can press for next any Alphabet ");
//            char  vy=sc.next().charAt(0);
//            if(vy=='E'){
//                break;
//            }
//            System.out.println("Please any integers pos, neg or zero");
//            int n=sc.nextInt();
//            if(n>0){
//                countPos++;
//            } else if (n==0) {
//                count0++;
//            }
//            else if(n<0){
//                countNeg++;
//            }
//
//        }
//        System.out.println("No of zero = "+count0+", No of positive integers = "+countPos+", No of negative ="+ countNeg);
//    }

    // Question-8
//    public static int calcPower(int x,int n){
//        int result=1;
//        for(int i=1;i<=n;i++){
//            result=result*x;
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        System.out.println("Please enter the value of x snd n");
//        int x= sc.nextInt();
//        int n=sc.nextInt();
//        System.out.println("x to the power n = "+calcPower(x,n));
//    }

    // Question -9

//    public static int greatestFactor(int n1, int n2){
//        int ans=0;
//        for(int i=1;i<=n2;i++){
//            if(n1%i==0&&n2%i==0){
//                ans=i;
//            }
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Please enter the value of your both numbers");
//        int n1=sc.nextInt();
//        int n2=sc.nextInt();
//        System.out.println("Greatest common factor = "+greatestFactor(n1,n2));
//    }

           //   Question -10

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Please enter the value of n");
//        int n=sc.nextInt();
//        int a=0,b=1,c;
//        System.out.print(a+" "+b+" ");
//        for(int i=2;i<=n;i++){
//         c=a+b;
//         a=b;
//         b=c;
//            System.out.print(c+" ");
//        }
//    }
}
