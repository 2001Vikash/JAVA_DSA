package DP;

import java.util.Arrays;

public class DP_24_Rod_Cutting_Problem {

    // In this question we have given a price array for ex. {2,5,7,8,10}.and N which is rod length.
    // so we have to cut the rod in to pieces. like if we have 5 length rod then for ex. we can cut rod into 5 pieces. and another way as well we have.
    // and for length 1 of rod price in the market is price[0], and so on.
    // so question is that cut the rod in such a way which will give the maximum price from the market.
    // To solve it we can see this problem in another way like collect the rod length to maximize the price.
    // We will try to pick length in all possible ways and at that time maximize the price means it's similar to the unbounded knapsack problem.
    // infinite supply of rods


    public static int viaRecursion(int ind, int N, int[] price){

        // TC -> exponential or greater than 2^n and SC -> O(N) where N is maximum length of the rod.

        if(ind == 0){
            return N * price[0];// how many rod length is remaining that much will be required to form that with the length of 1.
        }
        int notTake = viaRecursion(ind-1, N, price);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength <= N){
            take = price[ind] + viaRecursion(ind, N-rodLength, price);
        }

        return Math.max(take, notTake);
    }

    public static int viaMemoization(int ind, int N, int[] price, int[][] dp){

        //TC -> O(n*n) and SC -> O(n*n) + O(target or N).

        if(ind == 0){
            return N * price[0];// how many rod length is remaining that much will be required to form that with the length of 1.
        }
        if(dp[ind][N] != -1)return dp[ind][N];

        int notTake = viaRecursion(ind-1, N, price);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength <= N){
            take = price[ind] + viaRecursion(ind, N-rodLength, price);
        }

        return dp[ind][N] = Math.max(take, notTake);
    }

    public static int viaTabulation(int[] price, int N){
        int[][] dp = new int[price.length][N+1];
        // base case
        for(int n = 0; n <= N; n++){
            dp[0][n] = n * price[0];
        }

        for(int i = 1; i < price.length; i++){
            for(int n = 0; n <= N; n++){
                int notTake = dp[i-1][n];
                int take = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength <= n){
                    take = price[i] + dp[i][n-rodLength];
                }
                dp[i][n] = Math.max(take, notTake);
            }
        }
        return dp[price.length-1][N];
    }

    public static int viaSpaceOptimization(int[] price, int N){
        int[] prev = new int[N+1], curr = new int[N+1];
        // base case
        for(int n = 0; n <= N; n++){
            prev[n] = n * price[0];
        }

        for(int i = 1; i < price.length; i++){
            for(int n = 0; n <= N; n++){
                int notTake = prev[n];
                int take = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength <= n){
                    take = price[i] + curr[n-rodLength];
                }
                curr[n] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[N];
    }

    public static int viaMoreSpaceOptimization(int[] price, int N){
        int[] prev = new int[N+1];
        // base case
        for(int n = 0; n <= N; n++){
            prev[n] = n * price[0];
        }

        for(int i = 1; i < price.length; i++){
            for(int n = 0; n <= N; n++){
                int notTake = prev[n];
                int take = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength <= n){
                    take = price[i] + prev[n-rodLength];
                }
                prev[n] = Math.max(take, notTake);
            }
        }
        return prev[N];
    }

    public static void main(String[] args) {
        int N = 5;
        int[] price = {2,5,7,8,10};

     //   System.out.println(viaRecursion(price.length-1, N, price));

//        int[][] dp = new int[price.length][N+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(price.length-1, N, price, dp));

      //  System.out.println(viaTabulation(price, N));

      //  System.out.println(viaSpaceOptimization(price, N));

        System.out.println(viaMoreSpaceOptimization(price, N));
    }
}
