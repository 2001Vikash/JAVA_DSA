package DP;

import java.util.Arrays;

public class DP_39_Buy_and_Sell_Stocks_with_CoolDown {

    // CoolDown means can not buy right after Sell. And You can buy and sell unlimited times with this coolDown condition
    // in this question we will change only when we are selling at that time instead of going day+1, you have to go for day+2 because you are not
    // eligible to buy right after sell.

    public static int viaRecursion(int day, int buy, int[] price){
        if(day >= price.length)return 0; // why >= because if we are at n-1 we go for +2 then it exceeds n that's why.

        if(buy == 1){
            return Math.max(-price[day] + viaRecursion(day + 1, 0, price), viaRecursion(day + 1, 1, price));
        }
        return Math.max(price[day] + viaRecursion(day + 2, 1, price), viaRecursion(day + 1, 0, price));
    }

    // Let us memoize it

    public static int viaMemoization(int day, int buy, int[] price, int[][] dp){
        if(day >= price.length)return 0;
        if(dp[day][buy] != -1)return dp[day][buy];

        if(buy == 1){
            return dp[day][buy] = Math.max(-price[day] + viaRecursion(day + 1, 0, price), viaRecursion(day + 1, 1, price));
        }
        return dp[day][buy] = Math.max(price[day] + viaRecursion(day + 2, 1, price), viaRecursion(day + 1, 0, price));
    }


    // let us apply Tabulation

    public static int viaTabulation(int[] price){
        int n = price.length;
        int[][] dp = new int[n + 2][2]; // n+2 because we have requirement of day+2.
        // there is no need to write base cases because they are 0.

        for(int day = n-1; day >= 0; day--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 1){
                    dp[day][buy] = Math.max(-price[day] + dp[day+1][0], dp[day+1][1]);
                }else{
                   dp[day][buy] = Math.max(price[day] + dp[day+2][1], dp[day+1][0]);
                     }
            }
        }

        return dp[0][1];
    }

// We can not do more space optimization because we ind+1, ind+2 means hypothetically we have requirement of three arrays .
    // but we will do for better understanding

    public static int viaTabulation2(int[] price){
        int n = price.length;
        int[][] dp = new int[n + 2][2]; // n+2 because we have requirement of day+2.
        // there is no need to write base cases because they are 0.

        for(int day = n-1; day >= 0; day--){

            dp[day][1] = Math.max(-price[day] + dp[day+1][0], dp[day+1][1]);// buy

            dp[day][0] = Math.max(price[day] + dp[day+2][1], dp[day+1][0]);// sell

            // this also will run because internal loop was only for execute these two statements one by one.
        }

        return dp[0][1];
    }

    public static int viaMoreSpaceOptimization(int[] price){
        int n = price.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
     //   int[] curr = new int[2]; // yha pr error aa rha hai

        for(int day = n-1; day >= 0; day--){
            int[] curr = new int[2];// yha thikk hai
            curr[1] = Math.max(-price[day] + front1[0], front1[1]);// buy

            curr[0] = Math.max(price[day] + front2[1], front1[0]);// sell

            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }

    public static void main(String[] args) {
        int[] prices = {4,9,0,4,10};

       // System.out.println(viaRecursion(0, 1, prices));// initially we have liberty to buy.

//        int[][] dp = new int[prices.length][2];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(0, 1, prices, dp));

       // System.out.println(viaTabulation(prices));
      //  System.out.println(viaTabulation2(prices));

        System.out.println(viaMoreSpaceOptimization(prices));
    }
}
