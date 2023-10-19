package com.Striver;

import java.util.*;

public class Video_08_Combination_Sum {

    // medium level question
// Time  Complexity O(2^t*k) and Space Complexity O(k*x) where x is no matching combination.
//    public  static  void Combination(int [] arr , ArrayList<Integer> list , int i , int target){
//        if(i==arr.length){
//            if(target == 0){
////                System.out.print(" [ ");
////                for(int j=0;j<list.size();j++){
////                    System.out.print(list.get(j)+" ");
//              System.out.print(list+" ");
//               // }
//              //  System.out.print("]"+" ");
//            }
//            return;
//        }
//        if(arr[i]<=target){
//            list.add(arr[i]);
//            Combination(arr,list,i,target-arr[i]);
//          list.remove(list.size()-1);
//        }
//        Combination(arr,list,i+1,target);
//    }
//    public static void main(String[] args) {
//        int [] arr = {2,3,6,7};
//        ArrayList<Integer> list = new ArrayList<>();
//       Combination(arr , list, 0, 7);
//       // But here we need to that how we can make list of list in Java
//    }

    // Same Question using List of List.


        public  static  void Combination(int [] arr , ArrayList<Integer> list , int i , int target,List<List<Integer>> ans){
        if(i==arr.length){
            if(target == 0){
//                System.out.print(" [ ");
//                for(int j=0;j<list.size();j++){
//                    System.out.print(list.get(j)+" ");
             System.out.print(list+" ");
//                ans.add(new ArrayList<>(list)); // This Line is in doubt.
               // }
              //  System.out.print("]"+" ");
            }
            return;
        }
        if(arr[i]<=target){
            list.add(arr[i]);
            Combination(arr,list,i,target-arr[i],ans);
          list.remove(list.size()-1);
        }
        Combination(arr ,list ,i+1,target,ans);
    }
    public static List<List<Integer>> listOfList(int [] arr , int target ) {
        List<List<Integer>> ans = new ArrayList<>();
        Combination (arr, new ArrayList<>()  , 0 , target ,ans);
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        ArrayList<Integer> list = new ArrayList<>();
       listOfList(arr , 7);
    }
}
