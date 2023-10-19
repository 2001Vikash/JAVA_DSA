package DP;

import java.util.Arrays;

public class DP_14_Subset_Sum_Equals_to_Target {

    // Identify DP on Subsequences/Subsets/Sub-array and Ways to Solve them
    // any contiguous or non-contiguous part of array can be subsequences. Subsequences have to follow the order. It cn be and can not be with subset

    // So to solve our questions we need to generate all the subsequences and check that it is equal to the given target or not.
    // Here I have to explore finding power set with the help of Bit Manipulation.

    public static boolean viaRecursion(int ind, int[] arr, int target){

        // Time complexity -> O(2^n)., sc -> O(n) stack auxiliary space

        if(target == 0){
            return true;
        }
        if(ind == 0){
            return (arr[ind] == target);
        }
        boolean nonTake = viaRecursion(ind-1, arr, target);
        boolean take = false;
        if(target >= arr[ind]){
            take = viaRecursion(ind-1, arr, target-arr[ind]);
        }

        return (nonTake || take);
    }

    // Over here there are multiple overlapping sub-problems that makes a thing to use dynamic programming memoization
    // so firstly figure out the changing state like what are changing in recursion
    // here ind and target are changing.
    // assume the constraints ind <= 10^3 and target <= 10^3
// Time complexity for the memoization is O(n*target) and space complexity O(n*target) + O(n) for auxiliary space

    public static boolean viaMemoization(int ind, int[] arr, int target, int[][] dp){
        if(target == 0)return true;
        if(ind == 0)return arr[0] == target;
        if(dp[ind][target] != -1){
            return dp[ind][target] == 1;
        }
        boolean nonTake = viaMemoization(ind-1, arr, target, dp);
        boolean take = false;
        if(target >= arr[ind]){
            take = viaMemoization(ind-1, arr, target - arr[ind], dp);
        }
        boolean ans = take || nonTake;
        dp[ind][target] = ans ? 1 : 0;
        return ans;
    }

//    public static boolean viaMe(int ind, int[] arr, int target, int[] dp){
//        if(target == 0)return true;
//        if(ind == 0)return arr[0] == target;
//        if(dp[ind] != -1){
//            return dp[ind] == 1;
//        }
//        boolean nonTake = viaMe(ind-1, arr, target, dp);
//        boolean take = false;
//        if(target >= arr[ind]){
//            take = viaMe(ind-1, arr, target-arr[ind], dp);
//        }
//        boolean ans = take || nonTake;
//        dp[ind] = ans ? 1 : 0;
//        return ans;
//    } // we can do it because here target is also changing that's why it will never give right answer.


    // In tabulation, we just do things for base case and nested loops. nested loop == no. of changing states and in reverse order of Memoization.
// TC -> O(n*target), and SC -> O(n*target).

    public static boolean viaTabulation(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length][target+1];

        // base case
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = true;
        }
        if(arr[0] < target + 1) {
            dp[0][arr[0]] = true;// second base case
        }

        for(int ind = 1; ind < arr.length; ind++){
            for(int tar = 1; tar <= target; tar++){
                boolean nonTake = dp[ind-1][tar];
                boolean take = false;
                if(tar >= arr[ind]){
                    take = dp[ind-1][tar-arr[ind]];
                }

                dp[ind][tar] = take || nonTake;
            }
        }
        return dp[arr.length-1][target];
    }

    public static boolean viaSpaceOptimization(int[] arr, int target){
        // here we need to understand like every 0th column will always be true according to our first base case.

        boolean[] prev = new boolean[target+1], curr = new boolean[target+1];
        prev[0] = curr[0] = true;
        if(arr[0] < target+1) {
            prev[arr[0]] = true;
        }
        for(int ind = 1; ind < arr.length; ind++){
            for(int tar = 1; tar <= target; tar++){
                boolean nonTake = prev[tar];
                boolean take = false;
                if(tar >= arr[ind]){
                    take = prev[tar-arr[ind]];
                }

                curr[tar] = take || nonTake;
            }
            prev = curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 30;
        //System.out.println(viaRecursion(arr.length-1, arr, target));

//        int[][] dp = new int[arr.length][target+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(arr.length-1, arr, target, dp));

      //  System.out.println(viaTabulation(arr, target));

        System.out.println(viaSpaceOptimization(arr, target));

//        int[] dp = new int[arr.length];
//        Arrays.fill(dp, -1);
//        System.out.println(viaMe(arr.length-1, arr, target, dp));// we can't to do it. because it is wrong process to solve it.
    }
}
