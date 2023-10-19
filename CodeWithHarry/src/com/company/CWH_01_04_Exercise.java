package com.company;
import java.util.Scanner;
public class CWH_01_04_Exercise {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value in Kilometer");
        double a=sc.nextDouble();
        double miles=(0.625)*a;
        System.out.print("Its value in miles::  ");
        System.out.print(miles);

    }
}
