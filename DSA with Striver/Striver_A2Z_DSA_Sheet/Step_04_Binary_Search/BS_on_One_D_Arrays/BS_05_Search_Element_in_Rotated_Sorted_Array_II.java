package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_05_Search_Element_in_Rotated_Sorted_Array_II {

    // This is similar as previous question, one thing is extra here that is here can be duplicate elements in the array.
    // In this problem we do not have to return the indexes because we can not do it using Binary search, we can not return multiple index using BS, for that we have to use Linear search.
    // means, in this problem we just have to tell that target is present in the array or not, means return true or false.

    // if arr[low] == arr[mid] == arr[high], this is our problem in duplicate cases, so just we have to trim down this one and our job will be done.
    // So, in this case we will just try to shrink our search space.

    // TC -> in avg case we can say that O(log n) base 2. but if in array lots of duplicate elements probably, more than n/2, then we will say O(n/2) in worst case.

    public static void elementInRotatedArrayII(){
        int[] arr = {7,8,1,2,3,3,3,4,5,6};
        int n = arr.length;
        int target = 1;

        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                System.out.println("TRUE");
                return;
            }

            // for the duplicate
            if(arr[mid] == arr[low] && arr[high] == arr[mid]){
                low++;
                high--;
                continue;
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

        System.out.println("FALSE");
    }

    public static void main(String[] args) {
        elementInRotatedArrayII();
    }
}
