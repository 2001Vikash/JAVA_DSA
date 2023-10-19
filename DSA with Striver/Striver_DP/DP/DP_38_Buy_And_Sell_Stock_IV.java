package DP;

import java.util.Arrays;

public class DP_38_Buy_And_Sell_Stock_IV {

// Here in this problem we will ab allowed to only at most k transactions.

    // first of all we can solve it via using third problem.

    public static int viaTabulation(int[] prices, int k){
        int n = prices.length;
        //   int cap = 2;
        //int buy = 2;// 0 or 1

        int[][][] dp = new int[n+1][2][k+1];// slight change instead of using 3 we can remove via k

        // base case

        // if cap == 0

        for(int d = 0; d <= n; d++){
            for(int b = 0; b <= 1; b++){
                dp[d][b][0] = 0;
            }
        }

        // if day == n.
        for(int b = 0; b <= 1; b++){
            for(int c = 0; c <= k; c++){
                dp[n][b][c] = 0;
            }
        }  // if we do not write base cases then there will no problem because in Java all entries are 0 initially.

        // Every thing will be in reverse direction from the memoization.
        for(int day = n-1; day >= 0; day--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    if(buy == 1){
                        dp[day][buy][cap] = Math.max(-prices[day] + dp[day+1][0][cap], dp[day+1][1][cap]);
                    }else{
                        // means we are ready to selling

                        dp[day][buy][cap] = Math.max(prices[day] + dp[day+1][1][cap-1], dp[day+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }

    // And we also solved stock-3 via a different method that is transaction number
    // B S B S if we will be allowed for 2 transaction.
    // means if we want to perform 2 transactions then we have 4 transactions number
    // that means if we want to perform k transactions then we will have to 2 * k transactions number.

    public static int viaTransactionNumber(int day, int tranNo, int[] prices, int k){
        if(day == prices.length || tranNo == 2 * k){
            return 0;
        }

        if(tranNo % 2 == 0){
            // buy
            return Math.max(-prices[day] + viaTransactionNumber(day+1, tranNo+1, prices, k),
                                          viaTransactionNumber(day+1,tranNo, prices, k));
        }
        // sell
        return Math.max(prices[day] + viaTransactionNumber(day + 1, tranNo + 1, prices, k),
                                      viaTransactionNumber(day + 1, tranNo, prices, k));
    }

    public static int viaTransactionNumberMemoization(int day, int tranNo, int[] prices, int k, int[][] dp){
        if(day == prices.length || tranNo == 2 * k){
            return 0;
        }
        if(dp[day][tranNo] != -1)return dp[day][tranNo];

        if(tranNo % 2 == 0){
            // buy
            return dp[day][tranNo] = Math.max(-prices[day] + viaTransactionNumberMemoization(day+1, tranNo+1, prices, k, dp),
                    viaTransactionNumberMemoization(day+1,tranNo, prices, k, dp));
        }
        // sell
        return dp[day][tranNo] = Math.max(prices[day] + viaTransactionNumberMemoization(day + 1, tranNo + 1, prices, k, dp),
                viaTransactionNumberMemoization(day + 1, tranNo, prices, k, dp));
    }


    public static int viaTransactionNumberTabulation(int[] prices, int k){
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        // we can easily see that all base case are 0 then there is no need to write it.

        for(int day = n-1; day >= 0; day--){
            for(int tranNo = 2 * k - 1; tranNo >= 0; tranNo--){
                if(tranNo % 2 == 0){
                    // buy
                    dp[day][tranNo] = Math.max(-prices[day] + dp[day+1][tranNo+1], dp[day+1][tranNo]);
                }else{
                // sell
                   dp[day][tranNo] = Math.max(prices[day] + dp[day+1][tranNo+1], dp[day+1][tranNo]);
                     }
                }
          }

        return dp[0][0];
    }


    public static int viaTransactionNumberMoreSpaceOptimization(int[] prices, int k){
        int n = prices.length;
        int[] ahead = new int[2*k+1], curr = new int[2*k+1];

        // we can easily see that all base case are 0 then there is no need to write it.

        for(int day = n-1; day >= 0; day--){
            for(int tranNo = 2 * k - 1; tranNo >= 0; tranNo--){
                if(tranNo % 2 == 0){
                    // buy
                    curr[tranNo] = Math.max(-prices[day] + ahead[tranNo+1], ahead[tranNo]);
                }else{
                    // sell
                    curr[tranNo] = Math.max(prices[day] + ahead[tranNo+1], ahead[tranNo]);
                }
            }
            ahead = curr;
        }

        return ahead[0];
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;

      //  System.out.println(viaTabulation(prices, k));

     //   System.out.println(viaTransactionNumber(0, 0, prices, k));

//        int[][] dp = new int[prices.length][2*k];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaTransactionNumberMemoization(0,0,prices, k, dp));

    //    System.out.println(viaTransactionNumberTabulation(prices, k));

        System.out.println(viaTransactionNumberMoreSpaceOptimization(prices, k));
    }
}
