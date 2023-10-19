package com.company;
import java.util.Scanner;
public class CWH_19_Chapter4_practice {
    public static void main(String[] args) {
        //Question -1
//        int a=10;
//           if(a==11){
//               System.out.println("I am 11");
//           }
//           else{
//               System.out.println("I am not 11");
//           }
        // Question-2
//        Scanner sc= new Scanner((System.in));
//        byte m1,m2,m3;// byte kyoki value 100 tk hi rakhani hai so memory uses come hoga\
//        System.out.println("Enter your number in Physics");
//        m1=sc.nextByte();
//        if(m1<=100){
//            System.out.println("Yes next Please");
//        }
//        else{
//            System.out.println("Its not a valid marks!");
//        }
//        System.out.println("Enter your number in Chemistry");
//        m2=sc.nextByte();
//        if(m2<=100){
//            System.out.println("Yes next Please");
//        }
//        else{
//            System.out.println("Its not a valid marks!");
//
//        }
//        
//        System.out.println("Enter your number in Mathematics");
//        m3=sc.nextByte();
//        if(m3<=100){
//            System.out.println("Now ready for knowing your Result ");
//        }
//        else{
//            System.out.println("Its not a valid marks!");
//        }
//        float total= (m1+m2+m3)/3.0f;
//        System.out.println("Your overall percentage is :: "+total);
//        if(total>=40&&m1>=33&&m2>=33&&m3>=33){
//            System.out.println("Congratulations! You are passed ");
//        }
//        else {
//            System.out.println("Sorry! Please try again later You are Fail");
//        }
        // Question-3
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Note! All amount in Lakhs per annum:: "+"Enter your per annum income");
//        float income = sc.nextFloat();
//        float tax=0;
//        if(income<=2.5f){
//            tax=tax+0;
//        } else if (income>2.5f&&income<=5.0f) {
//            tax = tax + 0.05f*(income-2.5f);
//        } else if (income>5.0f&&income<=10.0f) {
//             tax = tax + 0.05f*(5.0f-2.5f);
//             tax = tax + 0.2f*(income-5.0f);
//        } else if (income>10.0f) {
//            tax = tax + 0.05f*(5.0f-2.5f);
//            tax = tax + 0.2f*(10.0f-5.0f);
//            tax = tax + 0.3f*(income-10.0f);
//        }
//        System.out.println("Your overall tax for one year is = "+tax*(100000));
        // Question 4
//        Scanner sc=new Scanner(System.in);
//        byte input = sc.nextByte();
//        switch (input) {
//            case 1 -> System.out.println("Monday");
//            case 2 -> System.out.println("Tuesday");
//            case 3 -> System.out.println("Wednesday");
//            case 4 -> System.out.println("Thursday");
//            case 5 -> System.out.println("Friday");
//            case 6 -> System.out.println("Saturday");
//            case 7 -> System.out.println("Sunday");
//            default -> System.out.println("Please press a right key!");
//        }
        // OR
//        switch (input){
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("Please press a right key!");
//        }
        //Question 5
//        Scanner sc = new Scanner(System.in);
//        int year = sc.nextInt();
//           if((year%4==0) && (year%100!=0) || (year%400==0)){
//               System.out.println("This year is a Leap Year !");
//           }
//           else {
//               System.out.println("Not a Leap year sorry!");
//           }
        Scanner sc = new Scanner(System.in);
        String website = sc.next();
        if (website.endsWith(".org")) {
            System.out.println("This is an organizational website ");
        } else if (website.endsWith(".com")) {
            System.out.println("This is commercial website");

        } else if (website.endsWith(".in")) {
            System.out.println("This is an Indian website");
        }
    }
}