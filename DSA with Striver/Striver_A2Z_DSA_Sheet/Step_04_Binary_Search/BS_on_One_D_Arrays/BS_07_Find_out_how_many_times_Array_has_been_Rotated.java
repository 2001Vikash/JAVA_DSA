package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_07_Find_out_how_many_times_Array_has_been_Rotated {

    // In this problem we are given an array that is rotated from somewhere, we have to find that how many times has array been rotated.
    // And, array contains unique numbers.

    // So, if we see clearly, then we can say that at whichever index is containing minimal number that many number of times has array been rotated.
    // Now, as we know that in previous problem we have solved that how to find min in rotated sorted array, so we will use that concept with tracking index.

    // here, we can also use same concept for the duplicates but with the help of previous duplicate problem's solution.
    /*  for the duplicate -> just with the help of this code which we have to add it in the minimal code.
            if(arr[mid] == arr[low] && arr[high] == arr[mid]){
                low++;
                high--;
                continue;
            } */
    public static void numberOfRotation(){
        int[] arr = {3,4,5,1,2};
        int n = arr.length;

        int low = 0, high = n-1, index = -1, mini = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[low] <= arr[high]){
                // it means array is sorted already without rotation.
                if(arr[low] < mini){
                    mini = arr[low];
                    index = low;
                }
                break;
             }

            if(arr[low] <= arr[mid]){
                if(arr[low] < mini){
                    mini = arr[low];
                    index = low;
                }
                low = mid + 1;
            }else{
                if(arr[mid] < mini){
                    mini = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }

        System.out.println("Number of rotations is = " + index);
        System.out.println("Minimal number in the array is = " + mini);
    }

    public static void main(String[] args) {
        numberOfRotation();
    }
}
