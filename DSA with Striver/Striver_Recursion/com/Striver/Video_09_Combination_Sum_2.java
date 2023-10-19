package com.Striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Video_09_Combination_Sum_2 {
    // Bruit Force Solution.
//    public static  void comb2(int [] arr , ArrayList<Integer> list , int i, int target, HashSet<Integer> set ){
//        if(i == arr.length){
//            if(target == 0){
//                for(int j=0;j<list.size();j++){
//                    set.add(list.get(i));
//                }
//            }
//            return;
//        }
//        if(arr[i]<=target){
//           list.add(arr[i]);
//           comb2(arr,list,i+1,target-arr[i] , set);
//           list.remove(list.size()-1);
//        }
//        comb2(arr,list,i+1,target , set);
//    }
//
//    public static HashSet<Integer> comb(int [] arr,  ArrayList<Integer> list, int target){
//        HashSet<Integer> set = new HashSet<>();
//        comb2(arr,list,0,8,set);
//        return set;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,1,1,2,2,4};
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println( comb(arr, list ,4));
//    }

    // best case.
// Time Complexity O(2^n*k) and space complexity O(k*x).
//    public static void comb(int[] arr , ArrayList<Integer> list, int ind , int target){
//            if(target == 0){
//                System.out.print(list+" ");
//                return;
//            }
//            for(int j=ind;j<arr.length;j++){
//                if(j>ind && arr[j]==arr[j-1]) continue;
//                if(arr[j]>target) break;
//                // pick up
//                list.add(arr[j]);
//                comb(arr,list,j+1,target-arr[j]);
//                list.remove(list.size()-1);
//            }
//      }

//    public static void comb2(int[] arr , int ind , int target , List<List<Integer>> ans, ArrayList<Integer> list ){
//        if(target == 0) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//
//        for(int i=0;i<arr.length;i++){
//            if(i>ind && arr[i]==arr[i-1]) continue;
//            if(arr[i]>target) break;
//
//            list.add(arr[i]);
//            comb2(arr,i+1, target-arr[i],ans,list);
//            list.remove(list.size()-1);
//        }
//    }
//    public static List<List<Integer>> comb1(int[] arr, int target){
//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(arr);
//        comb2(arr,0,4, ans, new ArrayList<>());
//        return ans;
//    }
//    public static void main(String[] args) {
//        int[] arr ={1,1,1,2,2};
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(comb1(arr,4));
//    }  // some doubt in this code.
    // for this doubt I did copy this code which is next line . but it is also for distinct elements.
public static List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] nums = {1,1,1,2,2};
        List<List<Integer>> output = combinationSum(nums, 4);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y+" ");
            System.out.println();
        }
    }
}

