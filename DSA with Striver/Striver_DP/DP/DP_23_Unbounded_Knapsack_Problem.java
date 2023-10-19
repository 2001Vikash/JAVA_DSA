package DP;

import java.util.Arrays;

public class DP_23_Unbounded_Knapsack_Problem {

    // main difference between 0-1 knapsack and this problem is that in 0-1 was clearly stated that there will only (one)an occurrences of instances.
    // but over here it is stating infinite supply. mean we can pick single item as many as times. which was not possible in 0-1.
    // for ex. wt = {2,4,6} , val = {5,11,13} and W = 10.
    // find the maximum possible value.


    public static int viaRecursion(int ind, int W, int[] value, int[] wt){

        // TC -> >= o(2^n) or we can say that exponential in nature and SC -> O(W) in worst

        if(ind == 0){
            return (W/wt[0]) * value[0];// we can also take an else where will be returning min value.

//            if(wt[0] <= W)
//            return (W/wt[0]) * value[0];
//            else return (int)-1e8;
        }
        int notPick = viaRecursion(ind-1, W, value, wt);
        int pick = Integer.MIN_VALUE;// this is min if we return again min value from base case. it might be happened out of integer range. otherwise take it as 1e9.
        if(wt[ind] <= W){
            pick = value[ind] + viaRecursion(ind, W-wt[ind], value, wt);
        }

        return Math.max(notPick, pick);
    }

    public static int viaMemoization(int ind, int W, int[] value, int[] wt, int[][] dp){

        // TC -> O(n*W) and SC -> O(n*W) + O(n)

        if(ind == 0){
            return (W/wt[0]) * value[0];
        }
        if(dp[ind][W] != -1)return dp[ind][W];

        int notPick = viaMemoization(ind-1, W, value, wt, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            pick = value[ind] + viaMemoization(ind, W-wt[ind], value, wt ,dp);
        }

        return dp[ind][W] = Math.max(notPick, pick);
    }


    public static int viaTabulation(int[] value, int[] wt, int W){

        // TC and SC will be O(n*W).

        int[][] dp = new int[value.length][W+1];
        // base case if ind == 0

        for(int w = 0; w <= W; w++){
            dp[0][w] = (w/wt[0]) * value[0];
        }

        for(int ind = 1; ind < value.length; ind++){
            for(int w = 0; w <= W; w++){
                int notPick = dp[ind-1][w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w){
                    pick = value[ind] + dp[ind][w-wt[ind]];
                }
                dp[ind][w] = Math.max(notPick, pick);
            }
        }
        return dp[value.length-1][W];
    }

    public static int viaSpaceOptimization(int[] value, int[] wt, int W){

        int[] prev = new int[W+1], curr = new int[W+1];

        for(int w = 0; w <= W; w++){
            prev[w] = (w/wt[0]) * value[0];
        }

        for(int ind = 1; ind < value.length; ind++){
            for(int w = 0; w <= W; w++){
                int notPick = prev[w];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= w){
                    pick = value[ind] + curr[w-wt[ind]];
                }
                curr[w] = Math.max(notPick, pick);
            }
            prev = curr;
        }
        return prev[W];
    }

    public static int viaMoreSpaceOptimization(int[] value, int[] wt, int W){
        int[] prev = new int[W+1];
        for(int w = 0; w <= W; w++){
            prev[w] = (w/wt[0]) * value[0];
        }

        for(int i = 1; i < value.length; i++){
            for(int w = 0; w <= W; w++){
                int notPick = prev[w];
                int pick = 0;
                if(w >= wt[i]){
                    pick = value[i] + prev[w-wt[i]];
                }
                prev[w] = Math.max(pick, notPick);
            }
        }
        return prev[W];
    }
    public static void main(String[] args) {
        int[] value = {5,11,13};
        int[] wt = {2,4,6};
        int W = 10;

       // System.out.println(viaRecursion(wt.length-1, W, value, wt));

//        int[][] dp = new int[value.length][W+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(value.length-1, W, value, wt, dp));

       // System.out.println(viaTabulation(value, wt, W));

     //   System.out.println(viaSpaceOptimization(value, wt, W));

        System.out.println(viaMoreSpaceOptimization(value, wt, W));
    }
}
