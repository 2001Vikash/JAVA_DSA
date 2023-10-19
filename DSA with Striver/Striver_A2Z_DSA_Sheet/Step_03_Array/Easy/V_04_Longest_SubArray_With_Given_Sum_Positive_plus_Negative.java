package Step_03_Array.Easy;

import java.util.HashMap;

public class V_04_Longest_SubArray_With_Given_Sum_Positive_plus_Negative {

    // Question 1: Longest SubArray with given sum K , only for +ve integers.

    // Imp Note : SubArray => It means contiguous part of array is known as SubArray.

    // Problem states that we have given an array and sum integer k, we have to find longest subArray, which sum is = k,

    public static void longestSubArrayWithSumKForPositiveIntegers(){

        int[] arr = {1,2,3,4};
        int sumK = 0;
        int n = arr.length;

        // Brute Force. -> Generate all the subArrays and, find the desire ANS.

     /*   int maxLen = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                // subArray from i to j
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                }
                if(sum == sumK)maxLen = Math.max(maxLen, (j-i+1));
            }
        }
        System.out.println(maxLen); */

        // Can we optimize our Brute force solution because above code is like O(n^3), Answer is to that Yes
       /* int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == sumK){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
            }
        }
        System.out.println(maxLen); */ // So, this is O(n^2) with O(1) space complexity.


        // Now then after we will move Better Solution for this Question.
        // And, in better solution we are going to use Hashing(using HashMap) -> Thought process behind the Hashing =>
        // So, it means that if there exists a subArray with sum K as currentIndex as the last element,
        // then after if total sum of that subArray is x, then we will search (x-k) for our desire subArray. (reverse maths)

     /*   int maxLen = 0;
        int sum = 0;
        HashMap<Integer,Integer> prevSumMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == sumK){
                maxLen = Math.max(maxLen, i+1);
            }
            int prevSum = sum - sumK; // if we have required sum k, then from start of that subArray, there should be sum-k present, if yes then we got a new length subArray
            if(prevSumMap.containsKey(prevSum)){
                int len = i - prevSumMap.get(prevSum);
                maxLen = Math.max(maxLen, len);
            }

            // If we will not, check this condition then it will not work for zero for ex, (2,0,0,3) answer = 3, but it will give 1 because, it will save
            // in map, 2 with 2 index means it will update that, so we have not, update the index, because we are searching max length, now it will be fine.

            if(!prevSumMap.containsKey(sum))
               prevSumMap.put(sum, i);
        }
        // Note -> This is a better solution for the +ve elements, but it will be optimal for the +ve,-ve elements because we can not optimize it more
        // if array is containing +ve, -ve elements both.
        System.out.println(maxLen);

        // TC for this => In c++ it will like O(n log n) for ordered map, but in Java it will O(n) for average case, but in worst case it can be O(n^2)
        // because for containsKey() in worst case it will take O(n) for searching.
        // SC -> O(N) in worst case.

        */

   // but if the array contains only 0 and, +ve integers, then we can make an optimal solution but not for -ve,+ve.

        // So, optimal solution is done via two pointer method with greedy approach.
        // So,thought process is that when we start from 0th index, then we are bound to take subArray which is giving sum k, so if we exceed it, then reduce from start.

        int maxLen = 0;
        int sum = 0;
        int i = 0, j = 0;
        while(i < n){
            sum += arr[i];

            while(j <= i && sum > sumK){ // j <= i means till you have subArray.
                sum -= arr[j++];
            }
            if(sum == sumK){
                maxLen = Math.max(maxLen, i-j+1);
            }
            i++;
        }
        System.out.println(maxLen);

        // TC -> in worst case O(2n), SC -> O(1), inner loop run overall O(n), because it is not running n time at every iteration.
    }

    public static void main(String[] args) {

        longestSubArrayWithSumKForPositiveIntegers();
    }
}
