package Step_03_Array.Medium;

import java.util.*;

public class V_11_Next_Permutation {

    // Problem states that you are given an array of integers(can be duplicates), And we have to find the Next Permutation.

    // Permutation -> So, if we have an array like that 1,2,3 then, rearrangements of array elements is known as Permutation that will be n! times, where n is the number of elements in the array.

    // Next Permutation -> It is nothing but, we have to find permutation in dictionary order means 1,2,3 then 1,3,2 then 2,1,3 like

    // So, problem states that we have to find the next permutation means if we have 3,1,2 then next permutation will be 3,2,1 that will be our answer.
    // But we have to think about one edge case that is what happened if they are asking next permutation of 3,2,1 as we know that there is no next,
    // So, in this case we have fall back to first permutation of given thing that will be 1,2,3 in this case.

    public static void nextPermutation(){
       // int[] arr = {3,1,2};
        int arr[] = {2,1,5,4,3,0,0};
        int n = arr.length;

        // Brute force -> generate all permutation in sorted order and, search next of the given thing with modulo, because it will help us for edge case.
        // We will not do it because it will take a lot of time, but go to recursion playlist video 13-14 to see the generation of all permutation.

        // So there is no better solution for this but if we are using c++ then we have a c++ stl library as nextPermutation and provide the answer.

        // Optimal solution ->
        // for this approach we will see the Observation using this ex.  arr[] = {2,1,5,4,3,0,0}, then we will move on to the Algorithm -> Dry Run
        // Note -> Please watch the video again at the time of Revision.

        // Observations from dictionary -> 1. Longer prefix match means raj, rax, rbc so here we can see that ra match which is possible longer prefix match. So, we can do it using break point
        //                              -> 2. Find the break points if we will find a[n-i-1] < a[n-i], and if we will find break point then after we have to
        //                                    find the greater element than the break point element but smaller from right to the break point.
        //                              -> 3. After that keep the remaining things as much as smaller (means in a increasing sorted order).

        // If there is no deep it means index = -1, means we have to return the reverse of the array. This is edge case.

        // Time complexity in Worst case will be O(3n) and SC -> O(1).

        // step-1: find the break point.
        int ind = -1;
        for(int i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }

        // Step-2: find greater of break point but smaller one -> So, as we know that in right from the break point all are sorted so
        // If found the swap it

        for(int i = n-1; i >= ind; i--){
            if(arr[i] > arr[ind]){
                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
                break;
            }
        }

        // Step-3: Reverse the remaining because after the swapping we know array is still in sorted mode means reverse it, because we have to find increasing order according to our Observations.

        // reverse the array
        int left = ind + 1, right = n-1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        if(ind == -1){
            // reverse the whole array.
            int s = 0, e = n-1;
            while(s < e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++; e--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        nextPermutation();
    }
}
