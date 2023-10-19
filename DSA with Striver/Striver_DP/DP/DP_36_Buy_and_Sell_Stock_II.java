package DP;

import java.util.Arrays;

public class DP_36_Buy_and_Sell_Stock_II {

    // Here in this problem you are allowed to buy and sell as many times as you want.
    // Buy and then you have to sell you cant go for buy, buy and then sell, sell that's not a right way.
    // means you have to release the stock first if you are holding. and after releasing you can't buy same stock and sell on same or different day.

    // here we can see that there are a lot of ways to buy and sell, for ex. I can buy 7 and sell on 1 to last day as I wish to sell,
    // So whenever we see a lot of ways, so We try all, ways and find the best one.


    // try out all, ways means -> Recursion.

    // Procedure -> express everything in terms of index (and buy), do all stuffs, find the maximum possible ans, base case.

    // but for the index we have to think like if we will take only one changing parameters and if we are in middle of the array then
    // how can we know that I can buy the particular one or not, because If I have bought previously then I can not buy again before sell.
    // So we have to carry a variable which will tell that you can buy a particular stock or not.
    // and If I can not buy a stock then I have two ways, first one is I can sell and second one is I can not sell.


    // let us assume buy = 0 means you can't buy and 1 means you can buy.
    // f(0,1) what does it signify? => start on 0th day with buy, what is the maximum profit I can make.


    public static int viaRecursion(int day, int buy, int[] arr){

        // Time complexity -> O(2^n) and SC -> O(n)

        if(day == arr.length){
            return 0;
        }

        int profit = 0;

//        if(buy == 1){
//            int take = -arr[day] + viaRecursion(day + 1, 0, arr);
//            int notTake = viaRecursion(day + 1, 1, arr);
//            profit += Math.max(take, notTake);
//            return profit;
//        }else{
//            int sell = arr[day] + viaRecursion(day + 1, 1, arr);
//            int notSell = viaRecursion(day + 1, 0, arr);
//            profit += Math.max(sell, notSell);
//            return profit;
//        }

        // Or we can do it in less lines

        if(buy == 1){
            profit = Math.max(-arr[day] + viaRecursion(day + 1, 0, arr), viaRecursion(day + 1, 1, arr));
        }else{
            profit = Math.max(arr[day] + viaRecursion(day + 1, 1, arr), viaRecursion(day + 1, 0, arr));
        }
      return profit;
    }


    // There are overLapping sub-problems means we can apply Memoization.

    public static int viaMemoization(int day, int buy, int[] arr, int[][] dp){

        // TC -> O(n*2), and SC -> O(n*2) + O(n).

        if(day == arr.length)return 0;
        if(dp[day][buy] != -1)return dp[day][buy];

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-arr[day] + viaRecursion(day + 1, 0, arr), viaRecursion(day + 1, 1, arr));
        }else{
            profit = Math.max(arr[day] + viaRecursion(day + 1, 1, arr), viaRecursion(day + 1, 0, arr));
        }
        return dp[day][buy] = profit;
    }


    public static int viaTabulation(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+1][2];

        // base case
        dp[n][0] = dp[n][1] = 0;// because we know that if ind == n then return 0.

        for(int day = n-1; day >= 0; day--){
            for(int buy = 1; buy >= 0; buy--){
                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-arr[day] + dp[day+1][0], dp[day+1][1]);
                }else{
                    profit = Math.max(arr[day] + dp[day+1][1], dp[day+1][0]);
                }
                dp[day][buy] = profit;
            }
        }
//        for(int[] a : dp){
//            System.out.println(Arrays.toString(a));
//        }
        return dp[0][1]; // it's 0, 1 because this is which I passed in memoization in initial stage, so our answer will at 0,1.
    }


    public static int viaSpaceOptimization(int[] arr){
        int n = arr.length;
        int[] ahead = new int[2], curr = new int[2];

        // base case
        ahead[0] = ahead[1] = 0;// because we know that if ind == n then return 0.

        for(int day = n-1; day >= 0; day--){
            for(int buy = 1; buy >= 0; buy--){
                int profit = 0;

                if(buy == 1){
                    profit = Math.max(-arr[day] + ahead[0], ahead[1]);
                }else{
                    profit = Math.max(arr[day] + ahead[1], ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
       // System.out.println(Arrays.toString(ahead));
        return ahead[1];
    }


    public static int viaUsingOfFourVariables(int[] arr){
        int n = arr.length;

        int aheadNotBuy, aheadBuy, currNotBuy = 0, currBuy = 0;


        // base case
        aheadNotBuy = aheadBuy = 0;// because we know that if ind == n then return 0.

        for(int day = n-1; day >= 0; day--){

                currBuy = Math.max(-arr[day] + aheadNotBuy, aheadBuy);

                currNotBuy = Math.max(arr[day] + aheadBuy, aheadNotBuy);

                aheadBuy = currBuy;
                aheadNotBuy = currNotBuy;
//            System.out.println(aheadBuy + " " + aheadNotBuy);
        }
        // System.out.println(Arrays.toString(ahead));
        return aheadBuy;
    }


    public static long viaAmazingSolution(int[] prices, int N){
        long maxProfit=0;
        for(int i=1;i<N;i++){
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
}

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

      //  System.out.println(viaRecursion(0, 1, arr));// initially you have liberty to buy

//        int[][] dp = new int[arr.length][2];// 0 and 1.
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(0, 1, arr, dp));

        //System.out.println(viaTabulation(arr));

      //  System.out.println(viaSpaceOptimization(arr));

        //System.out.println(viaUsingOfFourVariables(arr));

        System.out.println(viaAmazingSolution(arr, arr.length));
    }
}
