package DP;

public class DP_16_Partition_A_Set_Into_Two_Subsets_with_Minimum_Absolute_Sum_Difference {
    // here we know that last row of the dp array in lecture 14 will tell us like target 0 is possible or not
    // target 1 is possible or not ..... up till last column.

    public static void main(String[] args) {
        int[] arr = {3, 2, 7};
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) totSum += arr[i];

        // here we can also put space optimized solution.

        boolean[][] dp = new boolean[arr.length][totSum + 1];

        for (int i = 0; i < arr.length; i++) dp[i][0] = true;
        if (arr[0] <= totSum) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < arr.length; ind++) {
            for (int tar = 1; tar <= totSum; tar++) {
                boolean nonTake = dp[ind - 1][tar];
                boolean take = false;
                if (arr[ind] <= tar) {
                    take = dp[ind - 1][tar - arr[ind]];
                }
                dp[ind][tar] = take || nonTake;
            }
        }

        int mini = (int) 1e9;
        for (int s1 = 0; s1 <= totSum / 2; s1++) {// we don't need to check from 1 to last because value will repeat from half.
            if (dp[arr.length - 1][s1]) {
                mini = Math.min(mini, Math.abs((totSum - s1) - s1));
            }
        }
        System.out.println("Minimum absolute sum difference is = " + mini);
    }
}
