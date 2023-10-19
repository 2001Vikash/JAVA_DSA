package Step_03_Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class V_24_Merge_Sorted_Arrays_without_Extra_Space {

    // In this problem we are given two sorted arrays and, we have to merge them without using any extra space.
    // ( You have to solve it without using extra space is not provide in interview we have to do it as optimal solution), that is problem.

    public static void mergeTwoSortedArray(){
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {0,2,6,8,9};
        int n = arr1.length, m = arr2.length;

        // Brute force -> In this we will be using a third array for the storing answer with size n+m.
        // TC -> O(2*(n+m)), SC-> O(n+m)

     /* ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                ans.add(arr1[i]);
                i++;
            }else{
                ans.add(arr2[j]);
                j++;
            }
        }
        while(i < n)ans.add(arr1[i++]);
        while(j < m)ans.add(arr2[j++]);
        // After that we have to put all the elements in given both array in sorted order.

        i = 0; j = 0;
        for(int k = 0; k < ans.size(); k++){
            if(i < n){
                arr1[i] = ans.get(k);
                i++;
            }else{
                if(j < m){
                   arr2[j] = ans.get(k);
                   j++;
                }
            }
        }
        System.out.println(Arrays.toString(arr1) + " , " + Arrays.toString(arr2));*/


        // Optimal Solution -> Now we will move for the optimal solution here, means we have to remove extra space that is O(n+m).

        // So as we know that we have sorted arrays, so we will compare last element of arr1 with first element of arr2, if they are not the right position
        // then we will swap them, and at the end sort the both array , like this we can solve it in constant space.
        // TC -> O(min(n,m)) + O(n log n + m log m), SC -> O(1).

    /*    int left = n-1, right = 0;
        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1) + " , " + Arrays.toString(arr2)); */

        // Next optimal solution -> Solution 2 is based on a technique that is Gap method. we will find gap as the summation of both array size / 2 of ceil.
        // then after put the pointers with maintaining this gap, and in next iteration do, gap/2 and take ceil value till 1. and repeat the same thing.
        // TC -> O(log(n+m)) + O(n+m), O(1).

        int len = n+m;
        int gap = (len / 2) + (len % 2); // here len%2 will give one if the number is an odd number, and if it is even then it will give 0, because there will be coming an integer value.

        while(gap > 0){
            int left = 0, right = gap;

            while(right < len){
                // arr1 and arr2
                if(left < n && right >= n){
                    swap(arr1, arr2, left, right-n);
                }
                // arr2 and arr2
                else if(left >= n){
                    swap(arr2, arr2, left-n, right-n);// -n for finding corresponding index.
                }else{
                    // arr1 and arr1.
                    swap(arr1, arr1, left, right);
                }
                left++; right++;
            }

            if(gap == 1)break; // means 1 will once and then after it will do break.
            gap = (gap/2) + (gap%2);
        }

        System.out.println(Arrays.toString(arr1) + " , " + Arrays.toString(arr2));
    }
    public static void swap(int[] a, int[] b, int i, int j){
        if(a[i] > b[j]){
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
        }
    }

    public static void main(String[] args) {
        mergeTwoSortedArray();
    }
}
