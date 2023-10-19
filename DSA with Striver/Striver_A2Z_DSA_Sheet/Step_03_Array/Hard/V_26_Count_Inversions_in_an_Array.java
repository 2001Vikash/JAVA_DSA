package Step_03_Array.Hard;
import java.util.*;
public class V_26_Count_Inversions_in_an_Array {


    // Problem states that you are given an array of integers and, you have to find the number of pairs in the array which follow i < j && arr[i] > arr[j]


    public static void countInversions(){
        int[] arr = {5,3,2,4,1};
        int n = arr.length;

        // Brute force solution -> In this we will check for every possible pairs, and if they will follow the rules then we will add in count.
        // TC -> O(n^2), SC -> O(1).

        /*int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);*/


        // Optimal solution -> we have to optimize the solution from n^2 to less like n log n or n.
        // So, if we will have two sorted parts of the array, as left right, then we can use two pointer approach (explain in video please watch again).
        // As we know that in, merge sort we divide the array in to two parts and sort then after merge them. Do dry run for better understanding.
        // after generating pairs from the last call in merge sort(single elements) then they will be in sorted order means they will not generate
        // another pairs within the self, they only see for the right parts of the array.
        // TC -> O(n log n) this is for merge sort(we are adding only one extra line in merge sort), SC -> O(n) for temp array to merge the data, and we are changing the main array.

        int ans = mergeSort(0, n-1, arr);
        System.out.println(ans);
    }

    public static int merge(int low, int high, int mid, int[] arr){
        int[] temp = new int[high - low + 1];
        int left = low, right = mid+1;
        int k = 0;
        int cnt = 0;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[k] = arr[left];
                left++;
            }else{
                // right is smaller, here we will find our answer.
                temp[k] = arr[right];
                cnt += (mid - left + 1);
                right++;
            }
            k++;
        }
        while(left <= mid)temp[k++] = arr[left++];
        while(right <= high)temp[k++] = arr[right++];

        for(int i = 0; i < temp.length; i++){
            arr[i+low] = temp[i];
        }
        return cnt;
    }

    public static int mergeSort(int low, int high, int[] arr){
        if(low >= high){
            return 0;
        }

        int cnt = 0;
        int mid = (low + high) / 2;
        cnt += mergeSort(low, mid, arr);
        cnt += mergeSort(mid+1, high, arr);
        cnt += merge(low, high, mid, arr);
        return cnt;
    }

    public static void main(String[] args) {
        countInversions();
    }
}
