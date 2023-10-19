package com.ApnaCollege;
import java.util.Scanner;
public class Video_04_loops {
    public static void main(String[] args) {
        // for loop
//        for(int counter=0;counter<100;counter++){// condition ko hata dene pr it behaves likes infinite loop.
//            System.out.println("Hello Vikash");
//        }
//        for(int counter=0;counter<=10;counter++){
//            System.out.print(counter+" ");
//        }
        // while loop
//        int i=0;
//        while(i<11){
//            System.out.println(i);
//            i++;
//        }
        // Do while loop
//        int i=0;
//        do{
//            System.out.println(i);
//            i++;
//        }while(i<11);
//        int i=12;
//        do{
//            System.out.println(i);
//            i++;
//        }while(i<11);
        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter your last number of natural number");
//        int num=sc.nextInt();
//        int sum=0;
//        for(int i=1;i<=num;i++){
//            sum+=i;
//        }
//        System.out.println(sum);
        int num=sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(num+"x"+i+"="+num*i);
        }
    }
}
