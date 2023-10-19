package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_06_Minimum_in_Rotated_Sorted_Array {

  // In this problem we are given a rotated sorted array, and we have to find the minimal element in the array, array contains unique elements.


    public static void minimumInRotatedSortedArray(){
        int[] arr = {4,5,6,7,0,1,2};
        int n = arr.length;

        // As,Brute force solution we can use linear search, typical O(n) solution, means find min in the array.

        // But as we know that Array is in sorted order, means we have to think about Binary search as optimal solution.
        // So, here we will use property of sorted things, as we know that we have to eliminate the half of the array in Binary search
        // here we will eliminate sorted half but before doing this, we will take our answer as minimal, because we know that if part is sorted then where is minimal element present.

        // This solution is for unique elements, but if we want to do also for duplicate then we can use previous concept.

        int low = 0, high = n-1, ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;

            // As well, we can do some optimization, if both half of the array is sorted then we will peek our min and no need to do further search.

            if(arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            if(arr[low] <= arr[mid]){
                // means left half is sorted
                ans = Math.min(ans, arr[low]);// here we know that at index low, minimal element is present, if that beat our answer then take it.
                low = mid + 1;
            }else{
                // means right half is sorted.
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }

        System.out.println("Min element in the array is = " + ans);
    }

    public static void main(String[] args) {
        minimumInRotatedSortedArray();
    }
}
