package DP;

import java.util.Arrays;

public class DP_37_Buy_And_Sell_Stocks_III {

    // At max two transactions We can do.
// This problem is an extension of previous problem with some bound like we can buy and sell at most 2.

    public static int viaRecursion(int day, int buy, int cap, int[] prices){

        // TC -> exponential, SC -> o(n)->ASS

        if(cap == 0)return 0;
        if(day == prices.length)return 0;

        if(buy == 1){
            return Math.max(-prices[day] + viaRecursion(day + 1, 0, cap, prices), viaRecursion(day + 1, 1, cap, prices));
        }else{
            // means we are ready to selling

            return Math.max(prices[day] + viaRecursion(day + 1, 1, cap-1, prices), viaRecursion(day + 1, 0, cap, prices));
        }
    }

    // There are overlapping sub-problems that's why we can do memoization.

    public static int viaMemoization(int day, int buy, int cap, int[] prices, int[][][] dp){

        // TC -> O(n*2*3), SC -> O(n) + O(n*2*3).

        if(cap == 0)return 0;
        if(day == prices.length)return 0;
        if(dp[day][buy][cap] != -1)return dp[day][buy][cap];

        if(buy == 1){
            return dp[day][buy][cap] = Math.max(-prices[day] + viaRecursion(day + 1, 0, cap, prices), viaRecursion(day + 1, 1, cap, prices));
        }else{
            // means we are ready to selling

            return dp[day][buy][cap] = Math.max(prices[day] + viaRecursion(day + 1, 1, cap-1, prices), viaRecursion(day + 1, 0, cap, prices));
        }
    }

    // To remove auxiliary stack space we have to go for tabulation.

    public static int viaTabulation(int[] prices){
        int n = prices.length;
     //   int cap = 2;
        //int buy = 2;// 0 or 1

        int[][][] dp = new int[n+1][2][3];

        // base case

        // if cap == 0

        for(int d = 0; d <= n; d++){
            for(int b = 0; b <= 1; b++){
                dp[d][b][0] = 0;
            }
        }

        // if day == n.
        for(int b = 0; b <= 1; b++){
            for(int c = 0; c <= 2; c++){
                dp[n][b][c] = 0;
            }
        }  // if we do not write base cases then there will no problem because in Java all entries are 0 initially.

        // Every thing will be in reverse direction from the memoization.
        for(int day = n-1; day >= 0; day--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        dp[day][buy][cap] = Math.max(-prices[day] + dp[day+1][0][cap], dp[day+1][1][cap]);
                    }else{
                        // means we are ready to selling

                        dp[day][buy][cap] = Math.max(prices[day] + dp[day+1][1][cap-1], dp[day+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    public static int viaSpaceOptimization(int[] prices){

        // TC -> O(n*2*3) and SC -> O(1)

        int n = prices.length;

        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        // base case

        after[0][0] = after[1][0] = 0;
        for(int b = 0; b <= 1; b++){
            for(int c = 0; c <= 2; c++){
                curr[b][c] = 0;
            }
        }

        for(int day = n-1; day >= 0; day--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        curr[buy][cap] = Math.max(-prices[day] + after[0][cap], after[1][cap]);
                    }else{
                        // means we are ready to selling

                        curr[buy][cap] = Math.max(prices[day] + after[1][cap-1], after[0][cap]);
                    }
                }
            }
            after = curr;
        }

        return after[1][2];
    }


    // No we have another solution for this as well, like that
    // we know that we have to perform B S B S, 0 1 2 3 means at even we buy and for odd we will sell
    // so instead of having buy variable we can make n * 4 dp array.

    public static int viaAnotherDpUsing(int day, int transaction, int[] prices, int[][] dp){
        if(day == prices.length || transaction == 4)return 0;
        if(dp[day][transaction] != -1)return dp[day][transaction];

        if(transaction % 2 == 0){
            // buy

            return dp[day][transaction] = Math.max(-prices[day] + viaAnotherDpUsing(day + 1, transaction+1, prices, dp),
                                                                  viaAnotherDpUsing(day+1, transaction, prices, dp));
        }else {
            // sell
            return dp[day][transaction] = Math.max(prices[day] + viaAnotherDpUsing(day + 1, transaction+1, prices, dp),
                                                                 viaAnotherDpUsing(day+1, transaction, prices, dp));
        }
    }


    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};// we can not do buy-buy and sell-sell.

        //System.out.println(viaRecursion(0, 1, 2, prices));

//        int cap = 2; // means at most 2 transactions we can do.
//        int n = prices.length;
//        int[][][] dp = new int[n][2][3];
//
//        for(int[][] arr : dp){
//            for(int[] a : arr)Arrays.fill(a, -1);
//        }
//        System.out.println(viaMemoization(0, 1, cap, prices, dp));

       // System.out.println(viaTabulation(prices));

       // System.out.println(viaSpaceOptimization(prices));

        int[][] dp = new int[prices.length][4];
        // B S B S
        for(int[] a : dp)Arrays.fill(a, -1);
        System.out.println(viaAnotherDpUsing(0,0,prices,dp));
    }
}
