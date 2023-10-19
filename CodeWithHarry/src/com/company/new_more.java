package com.company;
import java.util.Scanner;
public class new_more {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        double d= sc.nextDouble();
        sc.nextLine();
        String str = sc.nextLine();
        sc.close();


        // Write your code here.

        System.out.println("String: " + str);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }
}
