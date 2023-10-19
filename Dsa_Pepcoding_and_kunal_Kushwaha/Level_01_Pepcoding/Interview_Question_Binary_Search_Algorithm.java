package Level_01_Pepcoding;
import java.util.Arrays;

public class Interview_Question_Binary_Search_Algorithm {
//    public static void main(String[] args) {
//     // If given array is sorted in any problem then firstly we need to try binary search then we can go for another options.
//
//     // Problem --> 1 --> Ceiling of a Number. means smallest element in array greater or equal to the target element.
//
//              int[] arr = {2,3,5,9,14,16,18};
//              int ans = ceilingOfNumber(arr, 19);
//              int res = floorOfNumber(arr,1);
//              System.out.println("Ceiling value of a number in array = "+ans);
//              // if we want greatest small number for that target then we need to return arr[end].
//        System.out.println("Floor value of a number in array = "+res);
//
//        // means FIND A FLOOR OF NUMBER.--> Greatest number that is smaller or equal to the target.
//            }
//    static int ceilingOfNumber(int[] arr, int target){
//        if(target > arr[arr.length-1]){
//            return -1;
//        }
//        int start  = 0;
//        int end = arr.length-1;
//        while(start<=end){
//            int mid  = start + (end - start)/2;
//            if(target > arr[mid]){
//                start = mid + 1;
//            }else if(target < arr[mid]){
//                end = mid - 1;
//            }else{
//                return arr[mid];
//            }
//        }
//        return arr[start];
//    }
//    static int floorOfNumber(int[] arr, int target){
//        if(target < arr[0]){
//            return -1;
//        }
//        int start  = 0;
//        int end = arr.length-1;
//        while(start<=end){
//            int mid  = start + (end - start)/2;
//            if(target > arr[mid]){
//                start = mid + 1;
//            }else if(target < arr[mid]){
//                end = mid - 1;
//            }else{
//                return arr[mid];
//            }
//        }
//        return arr[end];
//    }


    // Find first and last position of an element in Sorted Array.


//    public static void main(String[] args) {
//        int[] arr = {5,6,7,7,7,7,8,8,8,8,10};
//        System.out.println(Arrays.toString(findFirstAndLastPos(arr,6)));
//    }
//    static int[] findFirstAndLastPos(int[] arr , int target){
//        if(arr.length == 0 || target > arr[arr.length-1]) return new int[]{-1,-1};
//        // find first occurrence of target.
//        int start = 0;
//        int end = arr.length - 1;
//        int mid = 0, m = 0;
//        while(start <= end){
//            mid = start + (end - start)/2;
//
//            if(target > arr[mid]){
//                    start = mid + 1;
//            }else if(target < arr[mid]){
//                end = mid - 1;
//            }else {
//                end = mid - 1;
//            }
//        }
//
//        // find last occurrence of target.
//        int s = 0;
//        int e = arr.length - 1;
//        while(s<=e){
//             m = s + (e - s)/2;
//
//            if(target > arr[m]){
//                s = m + 1;
//            }else if(target < arr[m]){
//                e = m - 1;
//            }else {
//                s = m + 1;
//            }
//        }
//        if(arr[start] == target && arr[e] == target)
//           return new int[]{start, e};
//
//        return new int[]{-1,-1};
//    }


    // We can write as also to same code.


//    public static void main(String[] args) {
//        int[] arr = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(findFirstAndLastPos(arr, 7)));
//    }
//    static int[] findFirstAndLastPos(int[] arr , int target){
//        int[] ans = {-1,-1};
//      //  if(arr.length == 0 || target > arr[arr.length - 1]) return ans;// it's not mandatory.
//
//        // Find first Occurrence of target
//
//        ans[0] = search(arr, target, true);
//
//        // find last occurrence of target
//         if(ans[0] != -1)
//          ans[1] = search(arr, target, false);
//
//        return ans;
//    }
//
//    static int search(int[] arr, int target, boolean firstInd){
//        int res = -1;
//        int start = 0;
//        int end = arr.length - 1;
//        while(start <= end){
//            int mid = start + (end - start)/2;
//            if(target > arr[mid]){
//              start = mid + 1;
//            }else if (target < arr[mid]){
//                end = mid - 1;
//            }else{
//                res = mid;
//                if(firstInd){
//                    end = mid - 1;
//                }else{
//                    start = mid + 1;
//                }
//            }
//        }
//        return res;
//    }


    // Find Position of an element in a sorted array of infinite numbers

// So here problem is that if we apply binary search due to sorted array then how we can find start and end
    // because we have not array.length means we need to find out our start ans end for taking some chunk(means some
// elements and check that our target is exists in this range or not if yes then we can apply binary search for that
    // particular reason.
    // We can also optimize our chunk works with the help of binary search we know that in binary search we
//   go for n to 1 dividing by 2 only. and takes time log n. means if we go to 1 to n multiplying by 2 in every chunk.
    // it will also take long n time complexity.


//    public static void main(String[] args) {
//
//        // for infinity array in actually we have length but we will not use because of array is infinity.
//
//        int[] arr = {2,3,5,6,7,8,10,11,12,15,20,23,30,32,33,34};
//        int ans = posTarget(arr, 33);
//        System.out.println(ans);
//    }
//    static int[] potentialChunk(int[] arr , int target){
//        int s = 0;
//        int e = 1;
//       // int size = 2;
//        while(target > arr[e]){
////           s = e + 1;
////           e = e + 2*size;
////           size *= 2;
//            // we can use is also like that.
//            int newStart = e + 1;
//             e = e + (e - s + 1)*2;
//             s = newStart;
//        }
//        return new int[]{s,e};
//    }
//
//    static int posTarget(int[] arr , int target){
//        // So find out a chunk which puts our target value.
//
//        int[] res = potentialChunk(arr , target);
//
//        int start = res[0];
//        int end = res[1];
//        while(start <= end){
//            int mid = start + (end - start)/2;
//            if(target > arr[mid]){
//                start = mid + 1;
//            }else if(target < arr[mid]){
//                end = mid - 1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//    }


    // Peak Index in a Mountain Array / monotonic Array.
    // Increases first then after decreasing


//    public static void main(String[] args) {
//      // so here we need to go for max value.
//        // firstly we go for linear search then after we try to solve it using binary search.
//
//        // Using Linear Search
//
////        int[] arr = {0,2,1,-1};
////        int max = arr[0];
////        for (int i = 0; i < arr.length; i++) {
////             if(arr[i] > max){
////                 max = arr[i];
////             }
////        }
////        int ind = 0;
////        for (int i = 0; i < arr.length; i++) {
////            if(arr[i] == max){
////                ind = i;
////                break;
////            }
////        }
////        System.out.println("Peak Index is = "+ind);
//
//
//        // Using Binary Search
//        // also provided in question that there is no any duplicates. but we can put duplicates.
//
//        int[] arr = {1,2,1,3,5,6,4};
//        int start = 0;
//        int end = arr.length - 1;
//        int mid = 0;
//        while(start < end){
//             mid = start + (end - start)/2;
//
//            if(arr[mid] > arr[mid + 1]){
//                // here we can put mid - 1. but we need to change loop condition that is =.
//                // it means we are in decreasing part of array that means mid can be our ans but we need to check in left
//                // again that's why we put here mid only at the place of mid - 1.
//                end = mid ;
//            }else{
//                // here we know that now we are in increasing part that's why we know that arr[mid+1]>arr[mid]
//                // that's why we put here mid + 1.
//                start = mid + 1;
//            }
//        }
//        // we can put here start and end both also.
//        System.out.println(" Peak element is = "+arr[start]+", and index of that number is = "+start);
//    }


    // Find in Mountain Array


//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,3,1};
//          int start = 0;
//          int peak = findPeakElementIndex(arr);
//          int target = 3;
//          int ans = agnosticBinarySearch(arr, target, start, peak);
//          if(ans == -1){
//              int ans2 = agnosticBinarySearch(arr, target, peak+1, arr.length-1);
//              ans = ans2;
//          }
//        System.out.println(ans);
//    }
//    static int findPeakElementIndex(int[] arr){
//        int ans = 0;
//        int start = 0;
//        int end = arr.length - 1;
//
//        while(start <= end){
//            int mid = start + (end - start)/2;
//            if(arr[mid] > arr[mid + 1]){
//                // means you are in descending order.
//                end = mid - 1;
//            }else{
//                // you are in ascending order.
//                start = mid + 1;
//            }
//            ans = start;
//        }
//        return ans;
//    }
//    static int agnosticBinarySearch(int[] arr , int target, int start, int end){
//
//        if(arr[start] < arr[end]){
//            while(start <= end){
//                int mid = start + (end - start)/2;
//                if(target > arr[mid]){
//                    start = mid + 1;
//                }else if(target < arr[mid]){
//                    end = mid - 1;
//                }else{
//                    return mid;
//                }
//            }
//        }else{
//            while(start <= end){
//                int mid = start + (end - start)/2;
//                if(target > arr[mid]){
//                    end = mid - 1;
//                }else if(target < arr[mid]){
//                    start = mid + 1;
//                }else{
//                    return mid;
//                }
//            }
//        }
//        return -1;
//    }


    // Search in Rotated Sorted Array.

// So here we try to learn Rotated Binary Search

    // Approach --> 1. Find the pivot (means changing point) in the array
    // Pivot is nothing but max element in the array.
//    public static void main(String[] args) {
//        int[] arr = {3,1}; // so there is problem in 2 length array which last element is  1.
//        int target = 1;
//        int pivot = findPivot(arr);
//        int ans = searchInRotatedArray(arr, target, 0, pivot);
//        if(ans == -1){
//            ans = searchInRotatedArray(arr, target, pivot + 1, arr.length - 1);
//        }
//        System.out.println(ans);
//    }
//    static int findPivot(int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (mid>end && arr[mid] > arr[mid + 1]) {
//                return mid;
//            } else if(mid>start && arr[mid - 1] > arr[mid]) {
//                return mid - 1;
//            }else if(arr[start] > arr[mid]){
//                end = mid - 1;
//            }else if(arr[start] < arr[mid]){
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }
//    static int searchInRotatedArray(int[] arr , int target, int start, int end){
//
//            while(start <= end){
//                int mid = start + (end - start)/2;
//                if(target > arr[mid]){
//                    start = mid + 1;
//                }else if(target < arr[mid]){
//                    end = mid - 1;
//                }else{
//                    return mid;
//                }
//            }
//        return -1;
//    }


    // Let's try to minimize this....


//    public static void main(String[] args) {
//        // I will try to do this problem with help of Recursion and we can merge all three method in Recursion method.
//    }


    // So above code will not work for duplicates values. So here we will try to solve for duplicate value.


//        public static void main(String[] args) {
//        int[] arr = {2,2,9,2,2};
//        int target = 1;
//        int pivot = findPivot(arr);
//            System.out.println(pivot);
//        int ans = searchInRotatedArray(arr, target, 0, pivot);
//        if(ans == -1){
//            ans = searchInRotatedArray(arr, target, pivot + 1, arr.length - 1);
//        }
//        System.out.println(ans);
//    }
//    static int findPivot(int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (mid>end && arr[mid] > arr[mid + 1]) {
//                return mid;
//            }
//            if(mid>start && arr[mid - 1] > arr[mid]) {
//                return mid - 1;
//            }
////            if(arr[start] > arr[mid]){
////                end = mid - 1;
////            }else { // if(arr[start] < arr[mid])
////                start = mid + 1;
////            }   // For duplicate we need to change here.
//
//            // if elements at middle , start , end are equal then just skip the duplicates
//            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
//                // Note :: if these elements at start and end were the pivot??
//                // so let's check first start
//
//                if(arr[start] > arr[start + 1]){
//                    return start;
//                }
//                start++;
//
//                // then check end pivot or not
//                if(arr[end] < arr[end - 1]){
//                    return end - 1;// same as second case
//                }
//                end--;
//
//                // left side is sorted so pivot is in right side.
//            }else if(arr[start] < arr[mid] || (arr[start] == arr[mid]) && arr[mid] > arr[end]){
//                start = mid + 1;
//            }else{
//                end = mid - 1;
//            }
//        }
//        return -1;
//    }
//    static int searchInRotatedArray(int[] arr , int target, int start, int end){
//
//            while(start <= end){
//                int mid = start + (end - start)/2;
//                if(target > arr[mid]){
//                    start = mid + 1;
//                }else if(target < arr[mid]){
//                    end = mid - 1;
//                }else{
//                    return mid;
//                }
//            }
//        return -1;
//    }

// another program for max with Binary search.
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,0};
//        int start = 0;
//        int end = arr.length - 1;
//        int ans = arr[0];
//        while(start <= end){
//            int mid = start + (end - start)/2;
//            if(arr[mid] <= ans){
//                end = mid - 1;
//            }else{
//                ans = arr[mid];
//                start = mid;
//            }
//        }
//
//        System.out.println(ans);
//    }


    // Find the Rotation count in Rotated Sorted Array.


//    public static void main(String[] args) {
//        int[] arr = {66 ,67 ,7 ,10 ,14 ,19 ,27 ,33 ,36 ,40 ,44 ,54 ,60};
//        int ans = indexOfMax(arr);
//      //  System.out.println(ans);
//        System.out.println("Array is Rotated "+ (ans + 1) + " times");
//    }
//    static int indexOfMax(int[] arr){
//        int start = 0;
//        int end = arr.length - 1;
//
//        while(start <= end){
//            int mid = start + (end - start)/2;
//            if(mid < end && arr[mid] > arr[mid + 1]){
//                return mid;
//            }
//            if(mid > start && arr[mid - 1] > arr[mid]){
//                return mid - 1;
//            }
//            if(arr[start] > arr[mid]){
//                end = mid - 1;
//
//            }else{
//                start = mid + 1;
//
//            }
//        }
//        return -1;
//    }


    // Split Array Largest Question...find lowest maximum sum in sub array part.


//    public static void main(String[] args) {
    // Firstly I will try to solve it with help of Bruit Force solution
    //       int[] arr = {7, 2, 5, 10, 8};
    // Here m = 2 which is only possible. m is no of partition.
    // if m = 1 then what we can do. this solution is only for m = 2;
//        int allSum = 0;
//        for(int i=0; i<arr.length; i++){
//            allSum+=arr[i];
//        }
//        int sum1 = 0;
//        int sum2 = 0;
//        int max = 0;
//        int ansMin = 1000000;
//        for(int i=0; i<arr.length; i++){
//              sum1 = sum1 + arr[i];
//              sum2 = allSum - sum1;
//              max = Math.max(sum1,sum2);
//              ansMin = Math.min(ansMin , max);
//        }
//        System.out.println(ansMin);


    // Now we are going for less than O(n) time complexity. that is O(n*log(sum(mid)));

//        int ans = splitArray(arr, 2);
//        System.out.println(ans);
//
//     }
//     static int splitArray(int[] arr, int m){
//        int start = 0;
//        int end = 0;
//        for(int i = 0; i < arr.length; i++){
//            start = Math.max(start , arr[i]);
//            end += arr[i];
//        }
//        // Binary search
//
//         while(start < end){
//             // try for the potential ans with the help of middle.
//             int mid = start + (end - start) / 2;
//
//             // calculate how many pieces of array you can divide. this in with this max sum.
//             int sum = 0;
//             int pieces = 1;// min pieces can be 1 which is nothing but array itself.
//             for(int num : arr){
//                 if(sum + num > mid){
//                     // you can't add this in this sub array, make new one
//                     // say you add this num in new sub array then sum = num;
//                     sum = num;
//                     pieces++;
//                 }else{
//                     sum += num;
//                 }
//             }
//             if(pieces > m){
//                 start = mid + 1;
//             }else{
//                 end = mid;
//             }
//         }
//         return end; // here start == end.
//     }


    // Binary Search in 2-D Array...  Searching in Matrices.

    // If elements are in random in matrices then we need to go for Linear search.

    // If Sorted in Row wise and Column wise manner then we can go for Binary Search..
    // If a matrix is sorted in col wise and row wise means it is not shorted strictly.
    // so here we can't apply Binary Search.

//    public static void main(String[] args) {
//        int[][] mat = { {10,20,30,40},
//                        {15,25,35,45},
//                        {28,29,37,49},
//                        {33,34,38,50} };
//        int target = 49;
//        System.out.println(Arrays.toString(SearchInMatrices(mat , target)));
//    }
//
//    // It's created by me and I think time complexity will may be O(n log n).
//
////    static int[] SearchInMatrices(int[][] mat , int target){
////        for(int row = 0; row < mat.length; row++){
////            int start = 0;
////            int end = mat[row].length - 1;
////            while(start <= end){
////                int mid = start + (end - start)/2;
////                if(target > mat[row][mid]){
////                    start = mid + 1;
////                }else if(target < mat[row][mid]){
////                    end = mid - 1;
////                }else{
////                    return new int[]{row , mid};
////                }
////            }
////        }
////        return new int[]{-1,-1};
////    }
//
//    // Here we try to solve it in O(n).
//
//    static int[] SearchInMatrices(int[][] mat, int target){
//        int row = 0;
//        int col = mat.length - 1;
//        while(row < mat.length && col >= 0){
//            if(mat[row][col] == target){
//                return new int[]{row , col};
//            }
//            if(mat[row][col] < target){
//                row++;
//            }else{
//                col--;
//            }
//        }
//        return new int[]{-1,-1};
//    }


    // Sorted Matrix.... means --> Elements in the matrix is either in increasing order or decreasing order.
// So it is called Strictly sorted matrix.
    // that means here we can apply Binary Search.

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println(Arrays.toString(searchIn2D(mat,14)));
    }
    //  search in the provided rows and provided columns.

    static int[] binarySearch(int[][] mat, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (mat[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (mat[row][mid] < target) {
                cEnd = mid - 1;
            } else {
                cStart = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
        static int[] searchIn2D ( int[][] mat, int target){
            int rows = mat.length;
            int cols = mat[0].length;// be cautious , matrix may be empty.
            if (rows == 1) {
                return binarySearch(mat, 0, 0, cols - 1, target);
            }

            // run the loop till 2 rows are remaining
            int rStart = 0;
            int rEnd = rows - 1;
            int cMid = cols / 2;
            while(rStart < (rEnd - 1)){
                int mid = rStart + (rEnd - rStart) / 2;
                if(mat[mid][cMid] == target){
                    return new int[]{mid , cMid};
                }
                if(target > mat[mid][cMid]){
                    // ignore the above rows
                    rStart = mid;
                }else{
                    // ignore the lower rows.
                    rEnd = mid;
                }
            }
            // ones this loop is ended and now we have 2 rows
            // check whether the target is in the column of 2 rows
            if(mat[rStart][cMid] == target){
                return new int[]{rStart , cMid};
            }
            if(mat[rStart + 1][cMid] == target){
                return new int[]{rStart + 1 , cMid};
            }
            // otherwise search in 1st half
            if(target <= mat[rStart][cMid - 1]){
                return binarySearch(mat,rStart,0,cMid - 1,target);
            }
            // otherwise search in 2nd half
            if(target >= mat[rStart + 1][cMid - 1] && target <= mat[rStart][cols - 1]){
                return binarySearch(mat,rStart,cMid + 1,cols - 1,target);
            }
            // otherwise search in 3rd half
            if(target <= mat[rStart + 1][cMid - 1]){
                return binarySearch(mat,rStart + 1,0,cMid - 1,target);
            }
            // otherwise search in 4th half
           else{ // (target >= mat[rStart + 1][cMid + 1])
                return binarySearch(mat,rStart + 1,cMid + 1,cols - 1,target);
            }
        }
}
