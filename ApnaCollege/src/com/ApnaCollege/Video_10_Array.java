package com.ApnaCollege;
import java.util.*;
public class Video_10_Array {
    public static void main(String[] args) {
       //int [] marks=new int [3]; //or
       // int marks []=new int[3];
//        int [] marks={97,99,98};
//        // or // int marks[]={97,98,99};
////        marks[0]=98;//phy
////        marks[1]=99;// maths
////        marks[2]=97;// eng
////        System.out.println(marks[0]);
////        System.out.println(marks[1]);
////        System.out.println(marks[2]);
//        for(int i=0;i<3;i++){
//            System.out.println(marks[i]);
//        }
        // Taking inputs of array
        Scanner sc = new Scanner(System.in);
//        int size=sc.nextInt();
//        int [] numbers=new int[size];
//        for(int i=0;i<size;i++){
//            numbers[i]=sc.nextInt();
//        }
//        for(int i=0;i<size;i++){
//            System.out.println(numbers[i]);
//        }
        // is case me kewal 0 print hoga i=1 karne pr bhi kyoki java automatic 0 se initialize kr deta ydi hum nhi karte hai
        /*
        int me 0
        float me 0.0
        String me "" null
        boolean me false
        ye sb java me automatic initialize hota hai ydi hum initiantion nhi karte hai
        but c++ me garbage value stored ho jati hai.
         */
//        for(int i=0;i<size;i++){
//            System.out.println(numbers[i]);
//        }
        // Question -1
//        int x=sc.nextInt();
//        int array[]={23,45,65,32};
//        for(int i=0;i< array.length;i++){
//            if(array[i]==x){
//                System.out.println(i);
//                break;
//            }
//        }
        // Home work Problem -1
//        int size=sc.nextInt();
//        String array[]=new String[size];
//        System.out.println("Please enter the name");
//        for(int i=0;i<size;i++){
//            array[i]=sc.nextLine();
//        }
//        for(int i=0;i<size;i++){
//            System.out.println(array[i]);
//        }
        // Home work Problem -2
//        int arr[]={1,34,21,93};
//        int max=Integer.MIN_VALUE;
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//            if(arr[i]<min) {
//                min=arr[i];
//            }
//        }
//        System.out.println(max+", "+min);
        // Home work Problem -3
        boolean res =false;
        int size=sc.nextInt();
        int arr[]=new int[size];
        System.out.println("Please enter your element of array");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<size;i++){
            if(arr[i-1]>arr[i]){
                res=false;
                break;
            } else {
                res=true;
            }
        }
        if(res==true){
            System.out.println("Array is sorted in ascending order");
        } else{
            System.out.println("Array is not sorted in ascending order");
        }
    }
}
