package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_02_Implement_Lower_Bound_and_Upper_Bound {

    // Lower bound -> the smallest index such that arr[i] >= n, where n will be given.
    // for ex, arr[] = {3,5,8,15,19}, as we know that array should be in sorted order., if n = 5, then index = 2, if 6 then 3 like that.
    // if we do not find lower bound index then return arr.length(hypothetically). If numbers are repeating then we have to return the smallest index.


    public static void lowerBound(){
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        int n = arr.length;
        int target = 9;

        // Brute force solution will linear search.

        // But as we know that we are given sorted array, and whenever we will be having sorted search space then we will use Binary search.

        // It is very imp algo, we just have to keep it in mind
        // TC -> O(log n) with base 2 and Space complexity will be constant.

          int low = 0, high = n-1;
          int ans = n; // this will be our answer if we do not find any answer.

          while (low <= high){
              int mid = low + (high - low) / 2;
              if(arr[mid] >= target){
                  ans = mid;
                  high = mid - 1; // because we are finding lower bound means the smallest index, even if we find our answer we will go for another min ind if possible.[[
              }else{
                  low = mid + 1;
              }
          }

        System.out.println(ans);
    }

    public static void upperBound(){
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        int n = arr.length;
        int target = 9;

        // Upper bound -> This will be same as lower bound, but without equality symbol.
        // means, the smallest index such that arr[ind] > x.
        // same as lower bound if we do not find answer then we will return size of the array as answer.

        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }


    public static void searchInsertPosition(){

        // In this problem we are given a sorted array, and a target, you have to search the target in teh array
        // if we find the element then return the index of that element, if we do not find the element in the array then we have
        // to find a position where we can insert that target, which will help us to maintain sorted order of array as well.

        // In solution, if we see clearly then we can see that this is nothing but lower bound, means we just have to return the lower bound for the array.


        int[] arr = {1,2,4,7};
        int n = arr.length;
        int k = 0;

        int low = 0, high = n-1, ind = n;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] >= k){
                ind = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        System.out.println("Ans : " + ind);
    }


    // Next Question is -> Floor and Ceil in sorted array.
    // here floor means => largest Number in array <= x,  and Ceil => smallest number in array >= x.

    public static int CeilValue(int[] arr, int x){
        // This is exactly similar like lower bound
        int n = arr.length;
        int ans = -1; // if ans does not exist

        int low = 0, high = n-1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x){
                ans = arr[mid];
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return  ans;
    }

    public static int FloorValue(int[] arr, int x){
        // This is exactly similar like lower bound
        int n = arr.length;
        int ans = -1; // if ans does not exist

        int low = 0, high = n-1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= x){
                ans = arr[mid];
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return  ans;
    }

    public static void floorCeil(){
        int[] arr = {10,20,30,40,50};
        int n = arr.length;
        int x = 25;

        System.out.println("Floor value of " + x + " = " + FloorValue(arr, x));
        System.out.println("Ceil value of " + x + " = " + CeilValue(arr, x));
    }

    public static void main(String[] args) {
//           lowerBound();
//           upperBound();

          // searchInsertPosition();

        floorCeil();
    }
}
