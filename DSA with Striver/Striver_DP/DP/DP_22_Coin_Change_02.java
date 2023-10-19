package DP;

public class DP_22_Coin_Change_02 {

    // Ways to make coin change -> In this question any element can be used any no. of times

    public static int viaRecursion(int ind, int target, int[] arr){

        // Time complexity -> >= O(2^n) or we can say that exponential in nature.
        // Space complexity -> >= O(n) or in worst case it will be like O(target).

        if(ind == 0){
            return (target % arr[0] == 0) ? 1 : 0;
        }
        int notTake = viaRecursion(ind-1, target, arr);
        int take = 0;
        if(target >= arr[ind]){
            take = viaRecursion(ind, target-arr[ind], arr);
        }

        return take + notTake;
    }


    // We can optimize this using memoization because there are overLapping sub-problems.

    public static int viaMemoization(int ind, int target, int[] arr, int[][] dp){

        // TC -> o(n*target), SC -> O(n*target) + >= O(n) for stack space or O(target).

        if(ind == 0){
            return (target % arr[0] == 0) ? 1 : 0;
        }
        if(dp[ind][target] != -1)return dp[ind][target];

        int notTake = viaMemoization(ind-1, target, arr, dp);
        int take = 0;
        if(target >= arr[ind]){
            take = viaMemoization(ind, target-arr[ind], arr, dp);
        }
        return dp[ind][target] = notTake + take;
    }

    // We can reduce extra recursion stack space via Tabulation.

    public static int viaTabulation(int[] arr, int target){
        int[][] dp = new int[arr.length][target+1];

        // base case
        for(int tar = 0; tar <= target; tar++){
            if(tar % arr[0] == 0)dp[0][tar] = 1;
            else dp[0][tar] = 0;
        }

        for(int i = 1; i < arr.length; i++){
            for(int tar = 0; tar <= target; tar++){
                int notTake = dp[i-1][tar];
                int take = 0;
                if(tar >= arr[i]){
                    take = dp[i][tar-arr[i]];
                }
                dp[i][tar] = take + notTake;
            }
        }

        return dp[arr.length-1][target];
    }

    public static int viaSpaceOptimization(int[] arr, int target){
        int[] prev = new int[target+1], curr = new int[target+1];

        // base case
        for(int tar = 0; tar <= target; tar++){
            if(tar % arr[0] == 0)prev[tar] = 1;
            else prev[tar] = 0;
        }

        for(int i = 1; i < arr.length; i++){
            for(int tar = 0; tar <= target; tar++){
                int notTake = prev[tar];
                int take = 0;
                if(tar >= arr[i]){
                    take = curr[tar-arr[i]];
                }
                curr[tar] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};// for ex. 1,1,1,1 ,, 1,1,2  ,, 2,2  ,, 1,3 like that we will solve it.
        int target = 4;

       // System.out.println(viaRecursion(arr.length-1, target, arr));

//        int[][] dp = new int[arr.length][target+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(arr.length-1, target, arr, dp));

      //  System.out.println(viaTabulation(arr, target));

        System.out.println(viaSpaceOptimization(arr, target));
    }
}
