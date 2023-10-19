package com.company;
import com.sun.tools.javac.Main;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class CWH_06_Exercise01 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Total num of each subject");
        int total = sc.nextInt();
        System.out.println("Put the number in Maths");
        int maths = sc.nextInt();
        System.out.println("Put the number in Physics");
        int phy = sc.nextInt();
        System.out.println("Put the number in Chemistry");
        int chem = sc.nextInt();
        System.out.println("Put the number in English");
        int eng = sc.nextInt();
        System.out.println("Put the number in Hindi");
        int hindi = sc.nextInt();
        float obtained=maths+phy+chem+eng+hindi;

        float form=(obtained*100.0f)/(5*total);
        float cgpa=obtained/(5*10);
        System.out.println(form);
        System.out.println(cgpa);

    }
}
