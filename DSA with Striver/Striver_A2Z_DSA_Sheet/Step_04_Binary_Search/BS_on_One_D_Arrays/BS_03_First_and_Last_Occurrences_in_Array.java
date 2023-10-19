package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_03_First_and_Last_Occurrences_in_Array {

    // First problem is that we are given a sorted array and an integer x, and we have to find the first and last occurrences of that number in the array.

    public static void firstAndLastOccurrences(){
        int[] arr = {2,4,6,8,8,8,11,13};
        int n = arr.length;
        int x = 8;

        // Brute force solution -> In this we will use linear iteration to find occurrences, or we can also do, from 0th index iteration to get first occurrences
        // and, for the last occurrences, we will do iteration from the last index, that is n-1.
        // TC -> O(n), SC -> O(1).

  /*      int first = -1, last = -1;
        for(int i = 0; i < n; i++){
//            if(arr[i] == x && first == -1){
//                first = i;
//                last = i;
//            }
//            else if( last != -1 && arr[last] == arr[i]){
//                last = i;
//            }
            if(arr[i] == x){
                if(first == -1)first = i;
                last = i;
            }
        }
        System.out.println(first + ", " + last); */


        // Now, we have to optimize it, and from O(n), where can we go, that is nothing but log n, so array is sorted now we can think about Binary search.

        // So, previously, we have done Lower bound and upper bound, so for the finding first index, we will apply lower bound directly, and for the
        // last index, or occurrence, we will apply upper bound and whatever that will return, our answer will be upper-bound index - 1.

        // But, here are some edge cases, that is what if number is not present in array then in this case lower bound will return next big element or length of the array,
        // it means in lower bound, we have to check that whatever index lower bound is returning that index contains x/target or not.

        // TC -> O(2* log n), SC -> O(1).

     /*
        int first, last;

        first = lowerBound(arr, x);
        if(first == arr.length || arr[first] != x){
            System.out.println("Not found");
        }else {
            System.out.println("First occurrence of x is at index : " + first);
        }

        last = upperBound(arr, x);
        if(last > 0 && arr[last-1] != x){
            System.out.println("Not found");
        }else {
            System.out.println("Last occurrence of x is at index : " + (last-1));
        }

    }
    public static int lowerBound(int[] arr, int x){
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid =  low + (high - low) / 2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x){
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid =  low + (high - low) / 2;
            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans; */


        // In lots of interview, people generally used to tell that, you have to do it using simple binary search, means without using LowerBound or upperBound.

        // As we know that we have to find the first and last occurrence of the given x, means we have to apply Binary search two times.


        // for the first occurrence

        int first = -1;
        int low = 0, high = n-1;
        while(low <= high){

            int mid = low + (high - low) / 2;
            if(arr[mid] == x){
                first = mid;
                high = mid - 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        low = 0; high = n-1;
        int last = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;
            if(arr[mid] == x){
                last = mid;
                low = mid + 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        System.out.println("First occurrence = " + first + ", and Last occurrence = " + last);
    }

    public static void main(String[] args) {
        firstAndLastOccurrences();
    }
}
