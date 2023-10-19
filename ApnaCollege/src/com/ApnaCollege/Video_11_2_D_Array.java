package com.ApnaCollege;

import java.util.Scanner;

public class Video_11_2_D_Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of row");
        int row=sc.nextInt();
        System.out.println("Enter the value of column");
        int column =sc.nextInt();
        int [][] arr = new int[row][column];
        System.out.println("Please enter the value of matrix element");
        //input
        //row
//        for(int i=0;i<row;i++){
//            // columns
//            for(int j=0;j<column;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }
//        // output
//
//        for(int i=0;i<row;i++){
//            for(int j=0;j<column;j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println("");
//        }
        // we can use single loop again and again till we want. But we can make easy this problem using nested loops.

        // Questions..

       // input
       // row
//        for(int i=0;i<row;i++){
//            // columns
//            for(int j=0;j<column;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }
//        System.out.println("Enter the value of your number which you want to search in matrix");
//        int x=sc.nextInt();
//        boolean res=false;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<column;j++){
//                if(arr[i][j]==x){
//                    System.out.println(" index of that element is = "+i+","+j);
//                    res=true;
//                    break;// ye inner loop se bahar jayega
//                }
//                else{
//                    res=false;
//                }
//            }
//            if(res==true){
//                break;// aur outer loop se
//            }
//        }
//        if(res==false){
//            System.out.println("Element is not exist in matrix");
//        }

        // Homework Question -1
        // find the transpose of a Matrix

//        // row
//                for(int i=0;i<row;i++){
//            // columns
//            for(int j=0;j<column;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }
//                // First Way
////        int transArr[][]=new int[row][column];
////                for(int i=0;i<row;i++){
////                    for(int j=0;j<column;j++){
////                        transArr[i][j]=arr[j][i];
////                        System.out.print(transArr[i][j]+" ");
////                    }
////                    System.out.println("");
////                }
//
//        // Second Way..
//        for(int j=0;j<column;j++){
//            for(int i=0;i<row;i++){
//                System.out.print(arr[i][j]+" ");// yha 01 ka 10 ho gya hai.
//            }
//            System.out.println("");
//        }

        // Homework Problem-2

//  Find a Spiral matrix. I want to continue this question after some time.....
    }
}
