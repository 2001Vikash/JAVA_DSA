package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_04_Search_Element_in_Rotated_Sorted_Array_I {

    // In this problem we are given an array that is Rotated sorted array, and a target, we have to find that target in the array.
    // Array is having only unique elements, in next problem we will see that how to manage, if duplicates are present in array as well.

    public static void elementInRotatedSortedArray(){
        int[] arr = {7,8,9,1,2,3,4,5,6};
        int n = arr.length;
        int target = 1;

        // Brute force -> In brute manner, we will solve it using linear search, the moment we find element == target we will return index otherwise -1.
        // TC -> O(n),SC -> O(1).

        // Optimal solution -> Here we can see that array is sorted but rotated, so array is sorted, it means we can think about Binary search
        // Because, whenever we see search in sorted area it means we should have to think about the Binary search.
        // In this we can not apply BS directly, because array is sorted in parts, it means we have to identify, that which part is not sorted and which one is sorted.
        // means, if arr[0] > arr[mid], then we can say that left half is not sorted but right half is sorted.

        // TC -> O(log n) with base 2, and SC -> O(1).

        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                System.out.println("Yes target is found at index : " + mid);
                return;
            }

            // left half is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && arr[mid] >= target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else{
                // right half is sorted

                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        System.out.println("Sorry! But Element in not found in array.");
    }

    public static void main(String[] args) {
        elementInRotatedSortedArray();
    }
}
