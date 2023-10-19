package Level_01_Pepcoding;
import java.util.Arrays;
public class Merge_Sort_using_Recursion_with_KK {

    // Merge sort -> In this sorting algorithm we use divide and conquer rule means we divide bigger problem in to smaller problem
    //           -> Means in merge sort we divide array in to the two parts and tell the recursion hey you sort this both part and give me the ans
     //          -> when results come then we merge both thing as original array

    /*
    Steps -->
              -> Divide array into 2 parts.
              -> get both part sorted via recursion
              -> Merge the sorted parts using two pointers method at 0th index of both
     */


//    public static void main(String[] args) {
//       int[] arr = {5,4,3,2,1};
//       int[] ans = mergeSort(arr);
//        System.out.println(Arrays.toString(ans));
//        System.out.println(Arrays.toString(arr));
//    }
//    static int[] mergeSort(int[] arr){
//        if(arr.length == 1){
//            return arr;
//        }
//
//        int mid = arr.length / 2; // if mid = 2.something then mid = 2.
//
//        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));// here mid is means last value of range is exclusive
//        // copyOfRange means new array being created and pass into recursion calls
//        // means same value but different Object means actually we created new Object like that
//        // means the original array will be not sorted how to do that we will see.
//
//        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));// hence new object created for every function call
//
//        return merge(left, right);
//    }
//    static int[] merge(int[] left, int[] right){
//        int[] mix = new int[left.length + right.length];
//        int i = 0 , j = 0;
//        int k = 0; // which is going for the mix array
//        while (i < left.length && j < right.length){
//            if(left[i] < right[j]){
//                mix[k] = left[i];
//                i++;
//            }else {
//                mix[k] = right[j];
//                j++;
//            }
//            k++;
//        }
//
//        // it may be possible that one of the array is not completed
//        // hence copy the remaining elements because we know whatever in last that will bigger than from whatever in mix
//        while (i < left.length){
//            mix[k] = left[i];
//            i++;
//            k++;
//        }
//
//        while (j < right.length){
//            mix[k] = right[i];
//            j++;
//            k++;
//        }
//        return mix;
//    }


    /*
    Time complexity -->
                          N                 = N
                    N/2        N/2          = N
                N/4     N/4  N/4  N/4       = N
                .        .    .    .          .
                .        .    .    .          .
                .        .    .    .          .
                1 1 1 1 1 1....   N times  = N

             * At every level, N elements are being merged.
             * total no of levels - N/2^0 -> N/2^1 -> N/2^2 ....-> 1  lets assume if last level is k then
             * 1 = N/2^k => k = log(N) with base 2.
             * how many merged getting every level N means comparison at every level is also N.
             * what are the total levels that is log n.
             * and each level comparison is N


             * means Total complexity O(n*log(N)).

         Space Complexity / Auxiliary space = O(n). which is max height of tree
     */

    // How to sort in place means original array sorted .
    // instead of creating new array (array object) means without using copyOfRange.
    // we can check indexes values like start , end , mid ....

    // Recurrence relation -> T(n) = T(n/2) + T(n/2) + (n-1)(comparison to merge two array and except last because last will not check with anyone.
    //                      => 2T(N/2) + (N-1).
    // Time Complexity with AkaraBazzi formula we find xlog x + 1

    // Means Time Complexity  = O(x*log(x)).

    // In place merge sorting means don't need to use new array only modify the original array

//    public static void main(String[] args) {
//        int[] arr = {4, 1, 3, 9, 7};
//        mergeSortInPlace(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void mergeSortInPlace(int[] arr, int start, int end){
//        if(end - start == 1){
//            return;
//        }
//        int mid = start + (end-start)/ 2;
//
//        mergeSortInPlace(arr, start, mid);
//        mergeSortInPlace(arr, mid, end);
//
//        mergeInPlace(arr, start, mid, end);
//    }
//    static void mergeInPlace(int[] arr , int s, int m, int e ){
//        int i = s;
//        int j = m;
//        int k = 0;
//        int[] mix = new int[e - s];
//
//        while(i < m && j < e){
//            if(arr[i] < arr[j]) {
//                mix[k] = arr[i];
//                i++;
//            }else{
//                mix[k] = arr[j];
//                j++;
//            }
//            k++;
//        }
//        while(i < m){
//            mix[k] = arr[i];
//            i++;
//            k++;
//        }
//        while(j < e){
//            mix[k] = arr[j];
//            j++;
//            k++;
//        }
//        for (int l = 0; l < mix.length; l++) {
//            arr[s+l] = mix[l];
//        }
//    }

//    public static void main(String[] args) {
//        int[] arr = {5,4,3,2,1};
//        mergeSortInPlace(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void mergeSortInPlace(int[] arr, int start, int end){
//        if(start < end) {
//            int mid = start + (end - start) / 2;
//
//            mergeSortInPlace(arr, start, mid);
//            mergeSortInPlace(arr, mid+1, end);
//
//            mergeInPlace(arr, start, mid, end);
//        }
//    }
//    static void mergeInPlace(int[] arr , int s, int m, int e ){
//        int i = s;
//        int j = m+1;
//        int k = 0;
//        int[] mix = new int[e - s + 1];
//
//        while(i <= m && j <= e){
//            if(arr[i] < arr[j]) {
//                mix[k] = arr[i];
//                i++;
//            }else{
//                mix[k] = arr[j];
//                j++;
//            }
//            k++;
//        }
//        while(i <= m){
//            mix[k] = arr[i];
//            i++;
//            k++;
//        }
//        while(j <= e){
//            mix[k] = arr[j];
//            j++;
//            k++;
//        }
//       // k=0;
//        for (int n = 0,l = s; l <= e; n++, l++) {
//            arr[l] = mix[n];
//          //  k++;
//        }
//    }



//  IT'S CREATED BY ME......


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr, int start, int end){
        if(start == end){
            return;
        }
        int mid = start + (end-start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    static void merge(int[] arr, int s, int m, int e){
        int i = s;
        int j = m+1;
        int k = 0;
        int[] mix = new int[e-s+1];
        while (i <= m && j <= e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= m){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j <= e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        // updating the original array with same index
        k = 0;
        for(int l = s; l <= e; l++){
            arr[l] = mix[k];
            k++;
        }
    }
}
