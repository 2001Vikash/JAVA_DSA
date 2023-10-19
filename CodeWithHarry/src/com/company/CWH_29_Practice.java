package com.company;
import javax.sound.midi.Soundbank;
import java.util.Scanner;
public class CWH_29_Practice {
    public static void main(String[] args) {
        // Question 1
//        Scanner sc = new Scanner(System.in);
//        float[] arr;//={23.5f,45.5f,67.5f,55.5f};
//       arr = new float[5];
//       for(int j=0;j< arr.length;j++){
//           arr[j] = sc.nextFloat();
//       }
//        float sum =0;
//        for(int i=0;i< arr.length;i++){
//            System.out.println(arr[i]);
//            sum = sum + arr[i];
//        }
        // OR
//        for (float num:arr){
//            sum = sum +num;
//        }
//        System.out.println("----------");
//        System.out.println(sum);

        // Question 2
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your number which you want to search");
//        int n = sc.nextInt();
//        int[] arr = {12, 34, 21, 54, 32};
//        boolean isInArray = false;
//        for (int i = 0; i < arr.length; i++) {
//            if (n == arr[i]) {
//               isInArray = true;
//                 break;
//// Or we can also use for-each -loop and in if we write n==element.
//            }
//        }
//        if(isInArray){
//            System.out.println("Yes Element present here");
//        }
//        else {
//            System.out.println("No Element is not present here");
//        }

        // Question 3

//        int [] marks = {89,98,78,87,76};// Its marks of all students in Physics.
//        float avg,sum=0;
//        for(int elements:marks){
//            sum =sum+elements;
//        }
//        avg=(sum)/marks.length;
//        System.out.println("The average marks of all students in Physics :: " + avg);

        // Question 4

//        int [][] mat1 = {{1,2,3},
//                         {4,5,6}};// Its a 2x3 matrix or 2-D array.
//        int [][] mat2 = {{2,3,4},
//                        {5,6,7}};
//        int [][] result = {{0,0,0},
//                           {0,0,0}};
//        // so if perform addition in matrix then both matrix have same size 2x3.
//       // System.out.println(mat1.length);// if we print the length of mat1 then length is no of rows.
//      //  System.out.println(mat1[0].length);// it gives us no of columns.
//        for (int i=0;i<mat1.length;i++){
//            for (int j=0;j<mat1[i].length;j++) {
//                result[i][j] = mat1[i][j] + mat2[i][j];
//                System.out.print(result[i][j]);
//               System.out.print(" ");
//            }
//            System.out.println("");
//        }

        // Question 5

//        Scanner sc = new Scanner(System.in);
//        System.out.println("PLease Enter your elements of array");
//        int [] arr = new int [5];
//        for (int j=0;j<5;j++){
//            arr[j]=sc.nextInt();
//        }
//        System.out.println("This is your reverse  Array");
//        for (int i=(arr.length-1);i>=0;i--){
//            System.out.println(arr[i]);
//        }  // OR
                  // it is swap based concept.
//        int [] arr = {12,4,56,76,87,34};
//        int l = arr.length;
//        int n = Math.floorDiv(l,2);
//        int temp;
//        for(int i=0;i<n;i++) {// n ke jagah pr hm l/2 bhi rakh sakte hai.
//            temp = arr[i];
//            arr[i] = arr[l - 1 - i];
//            arr[l - 1 - i] = temp;
//        }
//        for(int elements :arr){
//            System.out.print(elements + " ");
//        }

        // Question 6
//
//      //  Scanner sc = new Scanner(System.in);
//       // System.out.println("PLease Enter your elements of array");
//        int max= Integer.MIN_VALUE; // or -2147483648;
//        int [] arr = {23,-1,-76,-887,-545};//new int [5];
//
//         for (int e:arr){
//             if(e>max){
//                 max=e;
//             }
//         }
//        System.out.println("The maximum value is = "+ max);

        // Question 7

//        int [] a= {432,546,342,0,-123,53,32,345};
//        int min =Integer.MAX_VALUE; // or 2147483647;
//        for(int e:a){
//            if(e<min){
//                min=e;
//            }
//        }
//        System.out.println("The minimum value is = " + min);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);

        // Question 8;
//
//            int [] arr = {123,453,6557,443,35,345};
//            boolean isSorted = true;
//            for(int i=0;i< (arr.length-1);i++){
//                if(arr[i]>arr[i+1]){
//                    isSorted=false;
//                    break;
//                }
//            }
//            if(isSorted){
//                System.out.println("Array is Sorted in ascending order");
//            }
//            else{
//                System.out.println("Array is not Sorted in ascending order ");
//            }
    }
}