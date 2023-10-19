package DP;

import java.util.Arrays;

public class DP_54_Partition_Array_For_Maximum_Sum_Front_Partition {

    // In this question we have given an array with n elements and k. here k means none of the partition length exceed k.
    // means every partition length must have less than or equal to k.
    // Whenever we will do a partition then in that partition every element will be change with maximum element for that partition.

    // This problem is also like a Palindrome partition-II means here will use front partition concept.


    public static int viaRecursion(int i, int k, int[] arr){
        if(i == arr.length)return 0;

        int maxi = -(int)1e9;
        int maxAns = -(int)1e9;
        int len = 0;
        int sum = 0;

        for(int ind = i; ind < Math.min(arr.length, i + k); ind++){
            len++;
            maxi = Math.max(maxi, arr[ind]);

            sum = (maxi * len) + viaRecursion(ind+1, k, arr);

            maxAns = Math.max(maxAns, sum);
        }

        return maxAns;
    }

    // We know that in recursion time complexity will be exponential and also there are overLapping sub-problems then we will use memoization.

    public static int viaMemoization(int i, int k, int[] arr, int[] dp){

        // TC -> O(n*k) and SC -> O(n) + O(n).

        if(i == arr.length)return 0;

        if(dp[i] != -1)return dp[i];

        int maxi = -(int)1e9;
        int maxAns = -(int)1e9;
        int len = 0;


        for(int ind = i; ind < Math.min(arr.length, i + k); ind++){
            len++;
            maxi = Math.max(maxi, arr[ind]);

            int sum = (maxi * len) + viaMemoization(ind+1, k, arr, dp);

            maxAns = Math.max(maxAns, sum);
        }

        return dp[i] = maxAns;
    }


    public static int viaTabulation(int[] arr, int k){

        // TC -> O(n*K), SC -> O(n) for dp array.

        int n = arr.length;
        int[] dp = new int[n+1];
        // base case
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--){
            int maxi = -(int)1e9;
            int maxAns = -(int)1e9;
            int len = 0;


            for(int ind = i; ind < Math.min(arr.length, i + k); ind++){
                len++;
                maxi = Math.max(maxi, arr[ind]);

                int sum = (maxi * len) + dp[ind+1];

                maxAns = Math.max(maxAns, sum);
            }

              dp[i] = maxAns;
        }

        return dp[0];
    }




    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;

      //  System.out.println(viaRecursion(0, k, arr));


//        int[] dp = new int[arr.length];
//        Arrays.fill(dp, -1);
//        System.out.println(viaMemoization(0, k, arr, dp));

        System.out.println(viaTabulation(arr, k));
    }
}
