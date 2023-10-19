package DP;

import java.util.Arrays;

public class DP_20_Minimum_Coins {

    // Infinite Supplies Pattern.

     // we can think first of all to solve it using greedy
    // for ex. we have denomination of coins like that {1,2,3} and target is 7.
    // so find out the min no, of coins that can make the target.
    // take bigger element of the array that would be 3 means 7/3 = 2 means we have required 2 coins of 3 denomination.
    // what will remaining, thing 7-3*2 = 1 so, 1/2 = 0 no, 1/1 = 1 yes we can take 1 coin of 1 denomination.
    // total coin is 3.

    // Where does Greedy will fail ?
    // for ex. {9,6,5,1}, target = 11 and then greedy approach will take 9 first then after 2 1's which will be 3 coins, but we can achieve this
    // target in 2 coins. So same problem is over here as well, that is Uniformity.


    // that's why we are going to trying out all combos to form target that is 0/1 knapsack problem.

    // So here we can easily see that there are infinite no. of supply of coins means we can take a many times.

    // Note => Whenever we will see infinite supply or Multiple use then always for the Take condition we will stand at same index.
    // that is the main thing of this question.
    // because if go for ind-1 then we can't use that element again that will create problem.


    public static int viaRecursion(int ind, int target, int[] coins){

        // TC >= O(2^n) or we can say that it's like exponential in nature.
        // SC >= O(n) or we can say in worst case it will be like O(target).

        if(ind == 0){
            if(target % coins[ind] == 0)return target / coins[ind];
            else return (int)1e9;
        }

        int notTake = viaRecursion(ind-1, target, coins);// o + call
        int take = (int)1e9;
        if(coins[ind] <= target){
            take = 1 + viaRecursion(ind, target-coins[ind], coins); // 1 + call because here we are going to take it.
        }

        return Math.min(take, notTake);
    }

    public static int viaMemoization(int ind, int target, int[] coins, int[][] dp){

        // TC = O(n*target) and SC = O(n*target) + O(target).

        if(ind == 0){
            if(target % coins[ind] == 0)return target / coins[ind];
            else return (int)1e9;
        }
        if(dp[ind][target] != -1)return dp[ind][target];

        int notTake = viaMemoization(ind-1, target, coins, dp);// o + call
        int take = (int)1e9;
        if(coins[ind] <= target){
            take = 1 + viaMemoization(ind, target-coins[ind], coins, dp); // 1 + call because here we are going to take it.
        }

        return dp[ind][target] = Math.min(take, notTake);
    }

    // Tabulation -> steps => base case, (ind, tar), copy recurrence

    public static int viaTabulation(int[] coins, int target){
        int[][] dp = new int[coins.length][target + 1];
        // base case
        for(int tar = 0; tar <= target; tar++){
            if(tar % coins[0] == 0)dp[0][tar] = tar / coins[0];
            else dp[0][tar] = (int)1e9;
        }

        for(int ind = 1; ind < coins.length; ind++){
            for(int tar = 0; tar <= target; tar++){
                int notTake = dp[ind-1][tar];
                int take = (int)1e9;
                if(coins[ind] <= tar){
                    take = 1 + dp[ind][tar-coins[ind]];
                }
                dp[ind][tar] = Math.min(take, notTake);
            }
        }
        return dp[coins.length-1][target];
    }

    public static int viaSpaceOptimization(int[] coins, int target){
        int[] prev = new int[target + 1], curr = new int[target+1];
        // base case
        for(int tar = 0; tar <= target; tar++){
            if(tar % coins[0] == 0)prev[tar] = tar / coins[0];
            else prev[tar] = (int)1e9;
        }

        for(int ind = 1; ind < coins.length; ind++){
            for(int tar = 0; tar <= target; tar++){
                int notTake = prev[tar];
                int take = (int)1e9;
                if(coins[ind] <= tar){
                    take = 1 + curr[tar-coins[ind]];
                }
                curr[tar] = Math.min(take, notTake);
            }
            prev = curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 8;
       // System.out.println( viaRecursion(coins.length-1, target, coins));

//        int[][] dp = new int[coins.length][target+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(coins.length-1, target, coins, dp));

      //  System.out.println(viaTabulation(coins, target));

        System.out.println(viaSpaceOptimization(coins, target));
    }
}
