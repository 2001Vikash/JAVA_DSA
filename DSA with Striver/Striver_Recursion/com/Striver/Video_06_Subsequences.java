package com.Striver;

import java.util.ArrayList;

public class Video_06_Subsequences {

    /* Print all subsequences
    for ex. (3,1,2)
    {} , 3,2 (not contiguous) 1,2  1  2  3  3,1  3,1,2 and these all contiguous.
     */
//    static void printSubArrays(int[] arr, int start, int end)
//    {
//        // Stop if we have reached the end of the array
//        if (end == arr.length)
//            return;
//            // Increment the end point and start from 0
//        else if (start > end)
//            printSubArrays(arr, 0, end + 1);
//            // Print the subarray and increment the starting
//            // point
//        else {
//            System.out.print("[");
//            for (int i = start; i < end; i++)
//                System.out.print(arr[i] + ", ");
//            System.out.println(arr[end] + "]");
//            printSubArrays(arr, start + 1, end);
//        }
//        return;
//    }
//
//    public static void main(String args[])
//    {
//        int[] arr = { 1, 2, 3 };
//        printSubArrays(arr, 0, 0);
//    }
    // OR
//  time complexity O(n*2^n). and space complexity O(n). because depth of the tree is = no of element in array.
    public static void printSubs(int [] arr , int i, ArrayList<Integer> vy){

        if(i>=arr.length){
            for(int j=0;j<vy.size();j++) {
                System.out.print(vy.get(j)+" ");
            }
            if(vy.size()==0){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        // we can also take first to not be
        printSubs(arr,i+1,vy);
       // to be
        vy.add(arr[i]);
        printSubs(arr,i+1,vy);
        // to not be
        //System.out.println(i+"%"); means i=jaha se call hua hai wahi rahega
        vy.remove(vy.size()-1);
//        printSubs(arr,i+1,vy);
    }
    public static void main(String[] args) {
        int [] arr= {3,1,2};
        ArrayList<Integer> vy  = new ArrayList<>();
        printSubs(arr,0,vy);

    }

//    public static void printArr(ArrayList<Integer> vy, int i, int [] arr){
//        if(i==arr.length) {
//            for (int j = 0; j < vy.size(); j++) {
//                System.out.println(vy.get(j));
//            }
//            return;
//        }
//        vy.add(arr[i]);
//        printArr(vy,i+1,arr);
//    }
//    public static void main(String[] args) {
//        int [] arr = {1,2,3};
//        ArrayList<Integer> vy = new ArrayList<>();
//        printArr(vy,0,arr);
//    }
}
