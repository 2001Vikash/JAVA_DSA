package com.Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Travelling_day_knpToHome {
 //   public static void main(String[] args) {
//        int sum = 0;
//        int n = 23415;
//        for(int i=n;n!=0;n=n/10){
//            int rem = n%10;
//            sum = sum*10 + rem;
//        }
//        System.out.println((sum));


//        Scanner sc = new Scanner(System.in);
//        int [][] arr = new int[3][3];
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length;j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }

//        int arr1 [][] = new int[3][3];
//        for(int i=0;i< arr.length;i++){
//            for(int j=0;j< arr.length;j++){
//                arr1[i][j] = arr[j][i];
//                System.out.print(arr1[i][j]+" ");
//            }
//            System.out.println();
//        }
        // OR

//        for(int j=0;j< arr.length;j++){
//            for(int i=0;i< arr.length;i++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

        // Print subsequences which sum is = k;
//    }

//    public static void prinS(int [] arr , ArrayList<Integer> list , int i, int sum, int k){
//        if(i>=arr.length){
//            if(sum==k){
//                for(int j=0;j<list.size();j++) {
//                    System.out.print(list.get(j) + " ");
//                }
//                System.out.println("");
//            }
//
//            return;
//        }
//        // to be
//        list.add(arr[i]);
//       // sum+=arr[i] // so we need to know that what is the difference between this statement and next statement.
//        prinS(arr,list,i+1,sum+arr[i] ,k);
//        // not to be
//        list.remove(list.size()-1);
//     //   sum-=list.get(list.size()-1);
//        prinS(arr,list,i+1,sum,k);
//    }
//
//    public static void main(String[] args) {
//        int [] arr = {1,2,1};
//        ArrayList<Integer> list = new ArrayList<>();
//        prinS(arr, list,0,0,2);
//    }

//    public static void main(String[] args) {
//        int[] arr = {1,-3,0,2,-3,-3,0};
//        int count = 0;
//        Arrays.sort(arr);
//        for(int i=0;i<arr.length;i++){
//            if(arr[ arr.length -1 ] == arr[i]){
//                count++;
//            }
//        }
//        System.out.println(count);
//    } //  this solution has more time complexity.

//    public static void main(String[] args) {
//        int arr[] = {0,1,2,3,3,-4,-4};
//        int count =0;
//        int max=0;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]>max){
//                max=arr[i];
//                count=1;
//            }else if(arr[i]==max){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }

//    public static int f(int n){
//        if(n==0){
//            return  1;
//        }
//        return n*f(n-1);
//    }
//    public static ArrayList<Integer> ans(int N){
//        ArrayList<Integer> list = new ArrayList<>();
//        int t = N;
//        for(int i=9;i>=0;i--){
//            while (t-f(i)>=0){
//                list.add(i);
//                t-=f(i);
//                if(t==0)break;
//            }
//        }
//        Collections.reverse(list);// yaha sort bhi kr skte hai but reverse me less T complexity hogi than sorting.
//        return list;
//    }
//    public static void main(String[] args) {
//        int N=40321;
//        System.out.println(ans(N));
//    }


//    public static void main(String[] args) {
//        int n=9;
//        for(int i=2; i*i<=n; i++){
//            if(n%i==0){
//                System.out.println(i);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,4};
        int res =1;
        for(int i=1; i<6; i++){
            if(a[i-1]!=a[i]){
                a[i]=a[i];
                res++;
                System.out.println(a[i]);
            }

        }

      //  System.out.println(res);
    }
}
