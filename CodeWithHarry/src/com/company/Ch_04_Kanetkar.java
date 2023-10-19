package com.company;
import java.util.Scanner;
public class Ch_04_Kanetkar {
    public static void main(String[] args) {

        //  PROBLEM --> (a)

        Scanner sc = new Scanner(System.in);
        char c= sc.next().charAt(0);
        if(c=='$'||c=='&'||c=='@'||c=='#'){
            System.out.println("Special symbol!");
        }
        else{
            System.out.println("Not");
        }
    }
}
