package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_01_Introduction {

    // Binary Search -> It is a searching algorithm, which works in less time and as wel limited search space.

    // 1. Real Life ex. =>

    // for ex. if we want to search something in Dictionary like "Vikash" then we have to go at that place from where V is starting, then and so on,
    // like that we can search easily, due to in sorted manner.
    // So, let us assume, that if we open dictionary from its half, and we see that the character is T, means before T we will never find V, we can ignore
    // that part, and go for the second part, it means our search space is reduced, this is real life example of Binary search.
    // So, Binary search is also like that, It is only applicable for the sorted area always.

    // 2. Coding problem examples ->  imagine we have an array in sorted order : {3,4,6,7,9,12,16,17}, target = 6, n = 8 ,here we can apply BS.

    // 3. Iterative code ->

    public static void BinarySearchIterativeCode(int[] arr, int n, int target){
        int low = 0, high = n-1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == target){
                System.out.println("Yes element is present at index : " + mid);
                return;
            }else if(target > arr[mid]) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println("Sorry! Element is not found");
    }

    // 4. Recursive code

    public static int BinarySearchRecursiveCode(int[] arr, int low, int high, int target){

        if(low > high){
            return -1; // base case
        }

        int mid = (low + high) / 2;

        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return BinarySearchRecursiveCode(arr, mid+1, high, target);
        }else{
            return BinarySearchRecursiveCode(arr, low, mid-1, target);
        }
    }


    // 5. Time Complexity -> O(log n) with base 2.

    // 6. Overflow case ->
    // So, as we know that generally, we will work on array in Binary search, as we know that array can 10^5/10^6/10^7 size.
    // So, what if, low = 0, high = Integer.MAX_VALUE,
    // then it will go for integer overflow(if we are trimming from left side and low reach at high) at the time of doing (low + high)/2.
    // So, we have two ways to resolve it, one is using long, and another one, which is more intuitive and better than taking long space, that is
    // int mid = low + (high - low) / 2 => which is same as (low + high) / 2. If we calculate it. ,here we are subtracting, means we will not go beyond integer max value.

    public static void main(String[] args) {
        int[] arr = {3,4,6,7,9,12,16,17};
        int n = arr.length;
        int target = 13;

        BinarySearchIterativeCode(arr, n, target);
        System.out.println(BinarySearchRecursiveCode(arr, 0, n-1, target));
    }
}
