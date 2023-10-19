package com.Striver;
import java.util.*;
public class Video_07_Kinds_of_Problem_on_Recursion {

    // Print Subsequence Whose sum is k.

//    public static void printSumOfSeq(int [] arr, ArrayList<Integer> list, int i, int k){
//        if(i>=arr.length){
//            int sum=0;
//            for(int j=0;j<list.size();j++){
//                sum+=list.get(j);
//            }
//            if(sum==k){
//                for(int j = 0; j < list.size(); j++){
//                    System.out.print(list.get(j)+" ");
//                }
//                System.out.println("");
//            }
//
//            return;
//        }
//        // to be
//        list.add(arr[i]);
//        printSumOfSeq(arr,list,i+1,k);
//        // to be not
//        list.remove(list.size()-1);
//        printSumOfSeq(arr,list,i+1,k);
//    }
//    public static void main(String[] args) {
//        int arr [] = {1,2,1};
//        ArrayList<Integer> list = new ArrayList<>();
//        printSumOfSeq(arr,list,0,2);
//    }

    // Same problem with less Time complexity.
    // and i same problem we change that first related sum and not any other
//    public static boolean flag = false;
//    public static void printSumOfSeq(int [] arr, ArrayList<Integer> list, int i, int k,int sum){
//        if(i>=arr.length){
//            if(sum==k && flag==false){
//                flag = true;
//                for(int j = 0; j < list.size(); j++){
//                    System.out.print(list.get(j)+" ");
//                }
//                System.out.println("");
//
//            }
//           return;
//        }
//        // to be
//        list.add(arr[i]);
//
//        printSumOfSeq(arr,list,i+1,k,sum+ arr[i]);
//        // to be not
//        list.remove(list.size()-1);
//
//        printSumOfSeq(arr,list,i+1,k,sum);
//    }
//    public static void main(String[] args) {
//        int arr [] = {1,2,1};
//        ArrayList<Integer> list = new ArrayList<>();
//        printSumOfSeq(arr,list,0,2,0);
//    }
    // And we can also do it without any global variable.

//    public static boolean printSumOfSeq(int [] arr, ArrayList<Integer> list, int i, int k,int sum) {
//        if (i >= arr.length) {
//            if (sum == k) {
//                for (int j = 0; j < list.size(); j++) {
//                    System.out.print(list.get(j) + " ");
//                    return true;
//                }
//                System.out.println("");
//            }
//            return false;
//        }
//            // to be
//            list.add(arr[i]);
//
//            if(printSumOfSeq(arr, list, i + 1, k, sum + arr[i])==true){
//                return true;
//            }
//            // to be not
//            list.remove(list.size() - 1);
//
//          if(printSumOfSeq(arr, list, i + 1, k, sum)==true) return true;
//
//        return false;
//    }
//    public static void main(String[] args) {
//        int arr [] = {1,2,1};
//        ArrayList<Integer> list = new ArrayList<>();
//       boolean result = printSumOfSeq(arr,list,0,2,0);
//
//    }

//    public static boolean printS(int [] arr, ArrayList<Integer> list , int i,int sum){
//        if(i>=arr.length){
//            if(sum==3){
//                for(int j=0;j<list.size();j++){
//                    System.out.print(list.get(j)+" ");
//                    return true;
//                }
//                System.out.println();
//            }
//            return false;
//        }
//        list.add(arr[i]);
//        if(printS(arr,list,i+1,sum+=arr[i]) == true ){
//            return true;
//        }
//        list.remove(list.size()-1);
//        if(printS(arr,list,i+1 ,sum) == true ){
//            return true;
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        int [] arr = {1,2,1};
//        ArrayList<Integer> list = new ArrayList<>();
//       boolean result =  printS(arr,list,0,0);
//        System.out.println(result);
//    }

    // Count the subsequences with sum = k.
// time complexity O(2^n)

    public static int printCount(int [] arr , int i , int k , int sum){
        // if array contains positive elements the
        // for less time complexity we can put it one extra base case that is
        // if array has not +ve elements then we can go for  worst case.
        if(sum> k ) return 0;
        if( i==arr.length ){
            if(sum == k){
                return 1;
            }
            return 0;
            }

        // to be
        int l= printCount(arr,i+1,k,sum+arr[i]);
        // not to be
        int r =  printCount(arr,i+1,k,sum);
        return l+r ;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,1};
        System.out.println(printCount(arr,0,4,0));
    }
}
