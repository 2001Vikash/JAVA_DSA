package Level_01_Pepcoding;
import java.util.*;
import java.util.Arrays;

public class Linear_Search_Algorithm_by_KS {
    public static void main(String[] args) {
        //   int[] arr = {18,12,9,14,77,50};
        // find whether 14 exists in array or not.

        // Time complexity ... O(n). it means that how the time grows as your input grows.

//        boolean res = false;
//        for(int value : arr){
//            if(value==14){
//                res  = true;
//                break;
//            }
//        }
//        if(res){
//            System.out.println("YES");
//        }else{
//            System.out.println("NO");
//        }

        // Search in Strings

//        String s  = "Vikash";
//        char target = 'a';
//        // its create a character array
//        System.out.println(Arrays.toString(s.toCharArray()));
//        System.out.println(search(s,target));
//    }
//    static boolean search(String s, char target){
//        if(s.length()==0){
//            return false;
//        }
////       for(int i=0; i<s.length(); i++){
////           if(s.charAt(i)==target){
////               return true;
////           }
////       }
//        // using for each loop
//
//        for(char ch : s.toCharArray()){
//            if(ch == target)return true;
//        }
//       return false;


        // Search in 2-D Array

//        int[][] arr = new int[][]{ // we can write it like as also but here we initialise array as well as.
        // so its already know that this is array that means we can skip this things.
//                         {23,4,1},
//                         {18,12,3,9},
//                         {78,99,34,56},
//                         {17,12},
//                                        };
//        int[][] arr = {
//                {23,4,1},
//                {18,12,3,9},
//                {78,99,34,56},
//                {17,12},
//        };
//
//        int[] ans = search2DArray(arr, 99);
//        System.out.println(Arrays.toString(ans));
//    }
//    static int[] search2DArray(int[][] arr, int target){
//
//        if(arr.length == 0) {
//            return new int[]{-1,-1};
//        }
//        for (int row = 0; row <arr.length ; row++) {
//            for (int col = 0; col <arr[row].length ; col++) {
//                if(arr[row][col]==target){
//                    return new int[]{row,col};
//                }
//            }
//        }
//        return new int[]{-1,-1};


        // Find max in 2-D Array.

//        int[][] arr = {
//                {23,4,1},
//                {18,12,3,9},
//                {78,99,34,56},
//                {17,12},
//        };
//      maxMinIn2DArray(arr);
//    }
//
//    static void maxMinIn2DArray(int[][] arr){
//        if(arr.length == 0)return;
//        int max = arr[0][0];
//        int min = arr[0][0];
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                if (anInt > max) max = anInt;
//                if (anInt < min) min = anInt;
//            }
//        }
//        System.out.println("Maximum " + +max +" ,  and Minimum "+min);
//    }


        // Find even no of digits in array

        int[] arr = {126,254,2,66,7899};
         int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(noOfDigit(arr[i])%2==0) count++;
        }
        System.out.println(count);
    }
    static int noOfDigit(int n){
      //  return (int)(Math.log10((n))) + 1;// this is shortcut to count digits
        if(n<0)n=n*-1;
        if(n == 0)return 1;
        int d = 0;
        for(int i=n; n!=0; n=n/10) d++;
        return d;
    }
}
