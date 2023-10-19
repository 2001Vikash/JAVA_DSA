package com.Striver;

import java.util.*;

public class Video_12_and_13_Print_All_Permutation {
//    // Print all Permutation for a String or an Array.
//    // Approach --> 1
//    //  Time Complexity O(n!*n) ans  space complexity O(n!)+O(n).
////    public static void permutation(int[] arr , boolean [] map , ArrayList<Integer> list , List<List<Integer>> ans){
////        if(list.size() == arr.length){
////            ans.add(new ArrayList<>(list));
////            return;
////        }
////        for(int i=0;i<arr.length;i++){
////            if(!(map[i])) {
////                map[i] = true;
////                list.add(arr[i]);
////                permutation(arr ,map, list, ans);
////                list.remove(list.size() - 1);
////                map[i]=false;
////            }
////        }
////    }
////    public static List<List<Integer>> printAns(int[] arr){
////        List<List<Integer>> ans = new ArrayList<>();
////        boolean [] map = new boolean[arr.length];// isme by default false store hai kyoki in java hamesh 0 store rhta hai.
////        ArrayList<Integer> list = new ArrayList<>();
////        permutation(arr,  map ,list, ans);
////        return ans;
////    }
////    public static void main(String[] args) {
////        int[] arr = {1,2,3};
////        System.out.println(printAns(arr));
////    }
//
    // Approach --> 2 Which has less Space Complexity than Approach 1
    // Time Complexity O(n!*n) and Space Complexity O(n!).
//    public static void permutation(int ind , int[] arr){
//        if(ind == arr.length){
//            System.out.print("( ");
//          for(int i=0;i<arr.length;i++){
//              System.out.print(arr[i]+" ");
//          }
//            System.out.print(") ");
//            return;
//        }
//        for(int i=ind; i<arr.length; i++){
//
//            int temp = arr[i];
//            arr[i]=arr[ind];
//            arr[ind]=temp;
//
//            permutation(i+1,arr);
//
//            int temp1 = arr[i];
//            arr[i]=arr[ind];
//            arr[ind]=temp1;
//        }
//     }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        permutation(0,arr);
//    } // OR

    public static void work(int [] arr , int ind ,  List<List<Integer>> ans){
        if(ind == arr.length){
            ArrayList<Integer>  list = new ArrayList<>();
            for(int i=0;i< arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind; i<arr.length; i++){
            swap(i,ind,arr);
            work(arr,ind+1,ans);
            swap(i,ind,arr);
        }
    }
    public static void swap(int i, int j, int [] arr){
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static List<List<Integer>> printAns(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        work (arr,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr ={1,2,1};
        System.out.println(printAns(arr));
    }
}
