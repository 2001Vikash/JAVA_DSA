package DP;

import java.util.Arrays;

public class DP_50_Minimum_Cost_to_Cut_the_Stick_Partition_Dp {


    // In this question we have given that an array which means a[i] tells a position where we have to cut the stick.
    // and also given the length of stick as for ex. n = 7 means 0 1 2 3 4 5 6 7 and 0 1 1 length and so on.
    // you have to find the min cost to cut the stick. and Cost is length of stick that you are cutting.
    // for ex. if you are cutting at 1 means cost will be length of stick that is n initially.
    // and you can follow cut in any order to minimize cost.

    // So whenever we are cutting we have to make sure that given array must be in sorted order because we can solve them independently.
    // for ex, 1 3 4 5 2 we have and, we are cutting from 4 then we will have 1 3 4, and 4 5 2 and, we can solve both independently because
    // 2 is on left side means it is dependent that means array must be in sorted order.
    // means if elements will be in sorted order then there will no any dependency between sub-problems.

    // for ex. we have given cutting array 1,3,4,5 so to find the cost or length of stick we will do a work
    // we will put 0 at start and 7 at the end. and cost = length of that stick in which a[i]. so to find cost = cuts[j+1] - cuts[i-1] = 7 - 0 = 7 for first cut.


    public static int viaRecursion(int i, int j, int[] cuts){
        if(i > j){
            return 0; // because i == j means we can make cut at cut[i or j]. that's why i > j
        }

        int mini = (int)1e9;

        for(int ind = i; ind <= j; ind++){
            int cost = (cuts[j+1] - cuts[i-1]) + viaRecursion(i, ind-1, cuts) + viaRecursion(ind+1, j, cuts);
            mini = Math.min(mini, cost);
        }

        return mini;
    }


    public static int viaMemoization(int i, int j, int[] cuts, int[][] dp){
        // TC - O(n^3)..
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1)return dp[i][j];

        int mini = (int)1e9;

        for(int ind = i; ind <= j; ind++){
            int cost = (cuts[j+1] - cuts[i-1]) + viaMemoization(i, ind-1, cuts, dp) + viaMemoization(ind+1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }


    public static int viaTabulation(int[] cuts){
        int n = cuts.length;
        int[][] dp = new int[n][n];

        for(int i = n-2; i >= 1; i--){
            for(int j = i; j <= n-2; j++){
               // here either j will start from i or 1 if 1 then if(i > j) then continue. // == will give some answer.
                int mini = (int)1e9;

                for(int ind = i; ind <= j; ind++){
                    int cost = (cuts[j+1] - cuts[i-1]) + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }
        return dp[1][n-2];
    }


    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1,3,4,5};
        int[] cuts = new int[arr.length + 2];
        cuts[0] = 0;
        cuts[arr.length+1] = n;
        for(int i = 1; i < cuts.length - 1; i++){
            cuts[i] = arr[i-1];
        }
        Arrays.sort(cuts);


       // System.out.println(viaRecursion(1, arr.length, cuts));

//        int[][] dp = new int[cuts.length][cuts.length];
//        for(int[] a : dp)Arrays.fill(a, -1);
//        System.out.println(viaMemoization(1, arr.length, cuts, dp));

        System.out.println(viaTabulation(cuts));
    }
}
