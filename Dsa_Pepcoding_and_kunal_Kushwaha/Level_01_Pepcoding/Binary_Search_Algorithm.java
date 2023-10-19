package Level_01_Pepcoding;
import java.util.*;
public class Binary_Search_Algorithm {
//    public static void main(String[] args) {
//        // Firstly we need to make sure that our array must be in Sorted manner.
//
//        int[] arr = {2,4,6,9,11,12,14,20,36,48};
//        int target = 48;
//        int start = 0, end = arr.length-1;
//        boolean ans = false;
//        while(start <= end){
//            int mid = start + (end - start)/2;// we can face a problem if we make start + end it can be go for out of bound of int
//            // that's why we can take mid as start + (end-start)/2.
//            if(arr[mid] == target){
//                ans = true;
//                break;
//            }
//            if(target > arr[mid]){
//                start = mid+1;
//            }else if(target<arr[mid]){
//                end = mid-1;
//            }
//        }
//        System.out.println(ans);
//    }


    // So we know that if we want to apply Binary search then array must be in sorted.
    // but problem is that if we do not know that array is sorted in ascending or descending order then
    // we need to follow the another thing that is

    // ORDER AGNOSTIC BINARY SEARCH

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3};
        int ans = orderAgnosticBs(arr,7);
        System.out.println(ans);
    }
    static int orderAgnosticBs(int[] arr, int target){
        if(arr.length == 0)return -1;
        int start = 0;
        int end = arr.length - 1;
        if(arr[start] < arr[end]){
            while(start <= end){
                int mid = start + (end - start)/2;
                if(target > arr[mid]){
                    start = mid + 1;
                }else if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
        }else{
            while(start <= end){
                int mid = start + (end - start)/2;
                if(target > arr[mid]){
                    end = mid - 1;
                }else if(target < arr[mid]){
                    start = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
}
