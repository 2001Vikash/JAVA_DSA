package com.ApnaCollege;
import java.util.Scanner;
public class Variables {
    public static void main(String[] args) {
        // output
//        System.out.println("Hello Vikku");
//        System.out.println("*\n**\n***\n****");
        // Variables--> its means that its value can change for a particular problem.
        // for ex--> String,float,double,boolean,int ,long,short,byte,char etc.
//        int a=10,b=5;
//        int cal=(a*b)/(a-b);
//        System.out.println(cal);
//        System.out.println(a+b);

        // Input.
        Scanner sc=new Scanner(System.in);
       // String name=sc.next();// he gives only one single word or tolken
        // nextInt(),next.double(),next.Float()....etc.
//        String name=sc.nextLine();
//        System.out.println(name);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int sum=a+b;
        System.out.println(sum);

    }
}
