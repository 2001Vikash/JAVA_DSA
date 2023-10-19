package Level_01_Pepcoding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recursion_Arrays_Questions_with_KK {

    // Find whether the array is sorted in increasing order or not using recursion

//    public static void main(String[] args) {
//
//        int[] arr = {-2,-1,0};
//        System.out.println(isSorted(arr, 0));
//    }
//    // firstly breaking down it in smaller problem
//    static boolean isSorted(int[] arr, int i){// pass by the value of the reference. for the arr.
//        if(i >= arr.length - 1){
//            return true;
//        }
////        if(arr[i] > arr[i+1]){
////            return false;
////        }else{
////            return isSorted(arr, i+1);// every arr in function call where from it is called they are reference variable and pointing to the same object.
    // Means if in any recursion call you modify the array , the array will be modified for all the other recursion calls.
////        }
//
//        // OR
//        return (arr[i] < arr[i+1]) && (isSorted(arr, i+1));
//    }


    // Find an item in array using recursion with linear search.

//    public static void main(String[] args) {
//        int[] arr = {3,2,1,8,9};
//        int target = 18;
//        System.out.println(find(arr, target,0));
//        System.out.println(find2(arr, target, 0));
//    }
//    static int find(int[] arr, int target, int i){
//        if(i >= arr.length){
//            return -1;
//        }
//        if(arr[i] == target){
//            return i;
//        }else{
//            return find(arr, target,i+1);
//        }
//    }
//    static boolean find2(int[] arr, int target, int i){
//        if(i >= arr.length){
//            return false;
//        }
//       return arr[i] == target || find2(arr, target, i+1);
//    }


    // Find all indexes of the target...

//    public static void main(String[] args) {
//        int[] arr = {2,3,1,4,4,5};
//        findAllIndexes(arr, 4,0);
//        System.out.println(list);
//    }
//    static  ArrayList<Integer> list = new ArrayList<>();
//    static void findAllIndexes(int[] arr, int target, int i){
////        ArrayList<Integer> list = new ArrayList<>();
//          // I am not able to understand that why it is not working we need to make list static globally. otherwise return type must be list.
    // but now I am able to understand that for every recursion calls list will be new object(created every function call) means whatever we have in last
    // at the time of base condition true then that list will be new and print empty list and return.
//         // we will cover it in oops.
//        // one way is we can add list in as parameter in the function
//        if(i == arr.length){
//            System.out.println(list);
//            return;
//        }
//
//        if(arr[i] == target){
//            list.add(i);// if we take else also here whenever if condition is true after that it will return
//        }
//        findAllIndexes(arr, target, i+1);
//    }

    // OR

//    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 4, 4, 5};
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(findAllIndexes(arr, 0, 4, list));
       // System.out.println(list); // ans will same as like [3,4] means hence this list are modified
//    }
//
//    static ArrayList<Integer> findAllIndexes(int[] arr, int i, int target, ArrayList<Integer> list) {
//        if (i == arr.length) {
//            return list;
//        }
//        if (arr[i] == target) {
//            list.add(i);// here of course reference variable will be different but list object is one.
    // all function call list variable (name is same but different reference variable) pointing to the same object. and add in that object.
    // Means adding indexes in same object just via different-2 reference variable.
//        }
//        return findAllIndexes(arr, i + 1, target, list);
//    }


/* Summary -->  VVIP
    Goal -> return the list without taking list in argument
    challenges => return will be arrayList but
       problem => Every call will have a new list. previously if in call something add in list then everywhere changed
                  due to same object but here is not possible due to new object created after every call
                  How do we connect this answer which exists in individual function call
                  so ans is we can add elements at the time of returning
 */

    // let's see

//    public static void main(String[] args) {
//        int[] arr = {2,3,1,4,4,5};
//        System.out.println(findAllIndexes(arr, 0,4));
//    }
//    static ArrayList<Integer> findAllIndexes(int[] arr, int i, int target){
//        ArrayList<Integer> list = new ArrayList<>();
//        if(i == arr.length){
//            return list;
//        }
//        // This will contain answer for that function call only.
//        if(arr[i] == target){
//            list.add(i);
//        }
//        ArrayList<Integer> ans =  findAllIndexes(arr, i+1, target);
//        list.addAll(ans); // what ever ans have it will add with list.
//        return list;
//    }



    // Question -> Rotated Binary Search

    public static void main(String[] args) {
     int[] arr = {5,6,7,8,9,1,2,3};
        System.out.println(search(arr, 9, 0, arr.length-1));
    }
    static int search(int[] arr , int target, int s, int e){
        if(s > e){
            return -1;
        }
        int m = s + (e-s) / 2;
        if(arr[m] == target){
            return m;
        }
        if(arr[s] <= arr[m]){
            if(target <= arr[m] && target >= arr[s]){
                return search(arr, target, s, m-1);
            }else{
                return search(arr, target, m+1, e);
            }
        }else{
            if(target >= arr[m] && target <= arr[e]){
                return search(arr, target, m+1, e);
            }else{
                return search(arr, target, s, m-1);
            }
        }
    }
}