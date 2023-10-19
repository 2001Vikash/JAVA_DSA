package com.Striver;

import java.util.*;

public class Video_11_Subset_Sum_2 {

    // Print All Combination of a set that is Power set. But duplicate subset is not allowed.

//    public static void printPowerSet(int[] arr, int ind, ArrayList<Integer> list,HashSet<Integer> set){
//        if(ind == arr.length){
//           set.add(); // I have confusion that how I can convert list into set.
//            return;
//        }
//        // to be.
//        list.add(arr[ind]);
//        printPowerSet(arr,ind+1,list,set);
//        // to be not
//        list.remove(list.size()-1);
//        printPowerSet(arr,ind+1,list,set);
//    }
//    public static void main(String[] args) {
//        int [] arr = {1,2,2};
//        ArrayList<Integer> list = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//        printPowerSet(arr,0,list,set);
//    }
    // above solution is a bruit force solution.
    // for less complexity ...
// Time complexity O(2^n*n) and space complexity O(2^n*k) and auxiliary space O(n). where n is depth of tree.
    // and k is for writing ans.
    public static void powerSet(int [] arr , int ind , ArrayList<Integer> list , List<List<Integer>> ansList) {

            ansList.add(new ArrayList<>(list));
// here is my mistake I was taking a base case but there is no need to any base Case.
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;

            list.add(arr[i]);
            powerSet(arr, i + 1, list , ansList);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> ansList(int [] arr, int ind) {
        List<List<Integer>> ansList = new ArrayList<>();
        powerSet(arr,0 , new ArrayList<>() ,ansList);
        return ansList;
    }
            public static void main(String[] args) {
            int[] arr = {1,2,2};
       // firstly we need to sort array in increasing order .
                Arrays.sort(arr);
      ArrayList<Integer> list = new ArrayList<>();
                System.out.println( ansList(arr,0));
    }
}
