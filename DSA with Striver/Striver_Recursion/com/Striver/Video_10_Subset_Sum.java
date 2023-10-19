package com.Striver;

import java.util.ArrayList;
import java.util.Collections;

public class Video_10_Subset_Sum {
    // Time Complexity O(2^n + 2^n*log2^n) because for sorting time complexity is O(n*log n).
    public static void subsetSum(int [] arr, int ind , int sum, ArrayList<Integer> list){
        if(ind == arr.length){
            list.add(sum);
            return;
        }
        // for taking
        subsetSum(arr,ind+1,sum+arr[ind], list);

        // for not taking
        subsetSum(arr,ind+1,sum,list);
    }
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        subsetSum(arr,0,0,list);
        Collections.sort(list);
        System.out.println(list);
    }
}
