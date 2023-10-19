package DP;

import java.util.Arrays;

public class DP_19_0_1_Knapsack_Problem {
    // Recursion to Single Array space Optimized Approach
    // Very, very Important Problem

    // This problem states that a thief who wanted to steal some items from some house and in the house there are some Items have value and their weight.
    // and he has a bag which is only able to put things in under given weight.
    // for ex. n = 3, wt -> 3,4,5, corresponding values -> 30, 50, 60 And bag can not sustain weight more than 8 kg.
    // so try to find out the maximum possible value to be in limit of 8 kg.
    // here we are not considering fraction part of the value.

    // Will the greedy approach will work for that -> answer is to that is NO.
    // let us see -> n = 3, bag can take -> 6 Kg, wt -> 3,2,5 val -> 30,40,60. here greedy will not work. because uniformity is not there.

    // That's why we are trying out all combination and among those we will take best of them.

    // so inorder to write recurrence we have to follow some rules
    // 1 -> express in terms of index, wt, 2 -> do all stuffs possible on index and wt, 3 -> take max value.
    // f(n-1, wt) means till the n-1 what maximal value you can generate with weight of bag wt.

    public static int viaRecursion(int ind, int W, int[] wt, int[] value){

        // Time complexity -> O(2^n), SC -> O(n) for recursion stack space.

        if(ind == 0){
            if(wt[ind] <= W){
                return value[ind];
            }else{
                return 0;// because we can not take things from here.
            }
        }
        int notTake = viaRecursion(ind-1, W, wt, value);// means if we are not taking anything then there is only skipping steps.
        int take = (int)-1e9;
        if(wt[ind] <= W){
            take = value[ind] + viaRecursion(ind-1, W-wt[ind], wt, value);
        }

        return Math.max(take, notTake);
    }


    public static int viaMemoization(int ind, int W, int[] wt, int[] value, int[][] dp){

        // TC -> O(n*w) and SC -> O(n*w) + O(n).

        if(ind == 0){
            if(wt[0] <= W){
                return value[0];
            }else{
                return 0;
            }
        }
        if(dp[ind][W] != -1){
            return -1;
        }
        int notTake = viaMemoization(ind-1, W, wt, value, dp);
        int take = (int)-1e9;
        if(wt[ind] <= W){
            take = value[ind] + viaMemoization(ind-1, W-wt[ind], wt, value, dp);
        }

        return dp[ind][W] = Math.max(notTake, take);
    }

    // We can optimize stack space vai Tabulation.
// base case, try to write nested loop as much as changing parameters, copy the recurrence and replace f as dp.
    public static int viaTabulation(int n, int W, int[] wt, int[] value){
        int[][] dp = new int[n][W+1];
        // base case.
//        for(int w = 0; w <= W; w++) {
//            if (wt[0] <= w) {
//                dp[0][w] = value[0];
//            } else {
//                dp[0][w] = 0;
//            }
//        }

        // OR

        for(int i = wt[0]; i <= W; i++){
            dp[0][i] = value[0];
        }

        for(int i = 1; i < n; i++){
            for(int w = 0; w <= W; w++){
                int noTake = dp[i-1][w];
                int take = (int)-1e9;
                if(wt[i] <= w){
                    take = value[i] + dp[i-1][w-wt[i]];
                }

                dp[i][w] = Math.max(take, noTake);
            }
        }
        return dp[n-1][W];
    }

    public static int viaSpaceOptimization(int n, int W, int[] wt, int[] value){

        // TC -> O(n*w), SC -> O(n*w).

        int[] prev = new int[W+1], curr = new int[W+1];
        for(int w = wt[0]; w <= W; w++)prev[w] = value[0];

        for(int ind = 1; ind < n; ind++){
            for(int w = 0; w <= W; w++){ // we can also loop it in reverse for this loop because there is no any dependency of previous element of this row
                // we are using only previous row rather of previous value of current row.
                int notTake = prev[w];
                int take = (int)-1e9;
                if(wt[ind] <= w){
                    take = value[ind] + prev[w-wt[ind]];
                }
                curr[w] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[W];
    }

    // We can optimize it more because there is no any use of previous of current index that's why instead of using current array we can use previous itself.
    // means if I am trying to fill from the right and go for left then when we will move for left then there is no any again use of right things
    // means we can change that values which means there is no need of current array.
    // we can't do it from 0 to W because left guys will be required for the right guys, but we are just overwritten, but this thing if we are doing in reverse then it will be right
    // because there use of right guys to calculate left guys. that's why we will traverse from W to till 0.

    public static int viaMoreSpaceOptimization(int n, int W, int[] wt, int[] value){
        int[] prev = new int[W+1];
        for(int w = wt[0]; w <= W; w++)prev[w] = value[0];

        for(int i = 1; i < n; i++){
            for(int w = W; w >= 0; w--){
                int notTake = prev[w];
                int take = (int)-1e9;
                if(wt[i] <= w){
                    take = value[i] + prev[w-wt[i]];
                }
                prev[w] = Math.max(notTake, take);
            }
        }
        return prev[W];
    }

    public static void main(String[] args) {
        int n = 3;
        int W = 6;//kg
        int[] wt = {3,2,5};// in kg.
        int[] value = {30,40,60};

       // System.out.println(viaRecursion(n-1, W, wt, value));

//        int[][] dp = new int[n][W+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(n-1, W, wt, value, dp));

      //  System.out.println(viaTabulation(n, W, wt, value));

       // System.out.println(viaSpaceOptimization(n, W, wt, value));

        System.out.println(viaMoreSpaceOptimization(n-1, W, wt, value));
    }
}
