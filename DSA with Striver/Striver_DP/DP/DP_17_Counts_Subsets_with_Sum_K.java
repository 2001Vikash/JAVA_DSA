package DP;

import java.util.Arrays;

public class DP_17_Counts_Subsets_with_Sum_K {
    // you have to count the number of subsets

    // we can try via dp matrix in question 14.
    public static int viaDP_14(int[] arr, int tar){
        boolean[][] dp = new boolean[arr.length][tar + 1];
        for(int i = 0; i < arr.length; i++)dp[i][0] = true;
        if(arr[0] <= tar){
            dp[0][arr[0]] = true;
        }
        for(int ind = 1; ind < arr.length; ind++){
            for(int t = 1; t <= tar; t++){
                boolean notTake = dp[ind-1][t];
                boolean take = false;
                if(arr[ind] <= t){
                    take = dp[ind-1][t-arr[ind]];
                }
                dp[ind][t] = take || notTake;
            }
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(dp[i][tar]){
                count++;
            }
        }
        return count;
    }


    // In recursion call f(n-1, 3) -> means till the n-1th index , how manu=y subsets will give you the sum = 3. that is meaning of this
// TC -> O(2^n), SC -> O(n) for recursion stack space.
    public static int viaRecursion(int ind, int[] arr, int tar){
        if(tar == 0)return 1;
        if(ind == 0)return (arr[0] == tar) ? 1 : 0;

        /*
        // if 0 is also in our constraint then we need to change the base case like that
        // ex. 0,0,1 and sum is 1, ans, must be 4.
        if(ind == 0){
          if(sum == 0 && arr[0] == 0)return 2;
          if(sum == 0 || sum == arr[0])return 1;
          return 0;
         }
         */

        int notPick = viaRecursion(ind-1, arr, tar);
        int pick = 0;// 0 because we are adding
        if(arr[ind] <= tar){
            pick = viaRecursion(ind-1, arr, tar-arr[ind]);
        }
        return pick + notPick;

        // or

//        int count = 0;
//        count += viaRecursion(ind-1, arr, tar);
//        if(arr[ind] <= tar){
//            count += viaRecursion(ind-1, arr, tar-arr[ind]);
//        }
//        return count;
    }

    // We know that there are two parameters who are changing means we need to make 2-d array dp.

    public static int viaMemoization(int ind, int[] arr, int tar, int[][] dp){

        // TC-> O(n*tar), SC-> O(n*tar) + O(n) recursion stack space.(height of the tree)

        if(tar == 0)return 1;
        if(ind == 0)return (arr[0] == tar) ? 1 : 0;
        if(dp[ind][tar] != -1)return dp[ind][tar];

        int notPick = viaMemoization(ind-1, arr, tar, dp);
        int pick = 0;
        if(arr[ind] <= tar){
            pick = viaMemoization(ind-1, arr, tar-arr[ind], dp);
        }
        return dp[ind][tar] = pick + notPick;
    }

    // we don't want extra space O(n) that's why we follow tabulation.

    public static int viaTabulation(int[] arr, int tar){
        int[][] dp = new int[arr.length][tar+1];
        // base cases
        for(int i = 0; i < arr.length; i++)dp[i][0] = 1;
        if(arr[0] <= tar){
            dp[0][arr[0]] = 1;
        }
        for(int ind = 1; ind < arr.length; ind++){
            for(int t = 0; t <= tar; t++){
                int notPick = dp[ind-1][t];
                int pick = 0;
                if(arr[ind] <= t){
                    pick = dp[ind-1][t-arr[ind]];
                }
                dp[ind][t] = pick + notPick;
            }
        }

        return dp[arr.length-1][tar];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
      //  System.out.println("Number of subset equals to the target = " + viaDP_14(arr, 3));

      //  System.out.println(viaRecursion(arr.length-1, arr, 3));

          int tar = 3;
//        int[][] dp = new int[arr.length][tar+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(arr.length-1, arr, tar, dp));

        System.out.println(viaTabulation(arr, tar));
    }
}
