package com.company;

import java.util.Scanner;

public class CWH_Switch_Enhance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Age");
        int age=sc.nextInt();// -> its indicates switch enhance mode.

        switch (age) {// in switch case variable can be anything.like String , char ,bool ,float etc.
            case 18 -> {
                System.out.println("You are going to become adult!");
                System.out.println("You are going to become adult!");
                System.out.println("You are going to become adult!");
            }// ise nhi lahayenge to case 18 true hone pr yahA SE niche tk sabhi print ho jayega
            case 23 ->// aur ek bar break hone ke baad ye switch loop se bahar nikal jayega23
                    System.out.println("You are going to a job!");
            case 60 -> System.out.println("You are going to become retired!");
            default -> System.out.println("Enjoy your life!");
        }
        System.out.println("Thanks for using my java code ! ");
    }
}
