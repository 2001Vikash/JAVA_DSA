package DP;

import java.util.Arrays;

public class DP_04_Frog_with_k_Jump {
    // Lecture 03 follow up Question...

    public static int viaRecursion(int ind, int k, int[] energy){ // where k is jumps
        // TC -> O(n^k) like that
        if(ind == 0){
            return 0;
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++) {
            if (ind - i >= 0) {
                int jump = viaRecursion(ind - i, k, energy) + Math.abs(energy[ind] - energy[ind - i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return minEnergy;
    }

    public static int viaMemoization(int ind, int k, int[] ene, int[] dp){

        // Time complexity -> O(n*k).
        // Space complexity -> O(n) for stack space and O(n) for dp.

        if(ind == 0){
            return 0; // if I am at 0 then there is no any energy required.
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(ind - i >= 0){
                int jump = viaMemoization(ind-i, k, ene, dp) + Math.abs(ene[ind] - ene[ind-i]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }
        return dp[ind] = minEnergy;
    }

    public static int viaTabulation(int n, int k, int[] arr){

        // Time Complexity -> O(n*k)
        // Space complexity -> O(n) only for DP. recursion stack space is reduced
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i-j >= 0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {

        // Rule
        // treat ind, do all stuffs on ind, return min.

        int n = 6;
        int k = 5;
        int[]arr = {30,10,60,10,60,50};
       // System.out.println(viaRecursion(n-1, k, arr));

//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        System.out.println(viaMemoization(n-1,k,arr,dp));

        System.out.println(viaTabulation(n, k, arr));


 // Space Optimization ->
           // Yes we can do it because we have only requirement of k previous elements that means
        // we need to store to only k elements in any list instead of maintaining a DP array.
        // But at the time of maintaining the list we need to remove last element and set first element as curr.
        // To doing this we can optimize space from O(n) to O(k).
        // But in the worst case if k == n then there is no any profit of this
        // so we can say that here space optimization is not necessary because in worst case it will behave same.


    }
}
