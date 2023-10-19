package Step_03_Array.Medium;

import java.util.Arrays;

public class V_06_Sort_an_Arrays_of_0s_1s_and_2s {

    // Problem states that we have given an array only consisting three elements 0, 1 and 2. We have to sort the array in the form of 0's, 1's & 2's.


    public static void sortArray(){
        int[] arr = {2,1,2,1,2,0,0,0,1,2,0,1,2,1,2,0,0,2,2};
        int n  = arr.length;

        // Brute force
        //-> It can be using a sorting algorithm, that can be, Merge sort(TC - O(n log n), sc-O(n)), Quick sort etc.
       // Arrays.sort(arr);

        // Better approach
        // -> So, as we know that array contains only three elements so ,count them and according to their count value put them into the array.
        // TC -> O(2n), SC -> O(1) that means constant space.
/*
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0)cnt0++;
            else if(arr[i] == 1)cnt1++;
            else cnt2++;
        }
        int i = 0;

        while(true){
            if(cnt0 != 0){
                arr[i++] = 0;
                cnt0--;
            }else if(cnt1 != 0){
                arr[i++] = 1;
                cnt1--;
            }else if(cnt2 != 0){
                arr[i++] = 2;
                cnt2--;
            }else{
                break;
            }
        } */

        // Optimal solution
       // It will obtain by "Dutch National Flag Algorithm"

        // So, algorithm is used three pointers that is low, mid, high
        //  -> Algorithm revolves around three rules :
        // 1. Everything from 0.....low - 1, elements will be 0 that is nothing but extreme left.
        // 2. Everything from low.....mid-1, elements should be 1.
        // 3. Everything from high+1....n-1, elements should be 2, that is nothing but extreme right.
        // And one thing we will assume that mid to high array is unsorted, so initially, we will assume that array is unsorted, means mid will be at 0 and high will be at n-1.

        // TC -> O(n), SC->O(1)

        int low = 0, mid = 0, high = n-1;

        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
         sortArray();
    }
}
