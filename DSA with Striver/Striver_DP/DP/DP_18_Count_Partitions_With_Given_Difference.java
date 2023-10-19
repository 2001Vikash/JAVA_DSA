package DP;

public class DP_18_Count_Partitions_With_Given_Difference {

    /*
    in this question we have to find s1-s2 = D where s1 >= s2.
    we know that s1 = totSum - s2;
                 totSum - s2 - s2 = D
                 s2 = (totSum-D)/2, so basically we are searching for a subset with sum s2 = (totSum-D)/2.
                 here we have to clear two check that one is totSum-D >= 0 and (totSum-D) % 2 == 0.
                 thereby we can find our desired output.
     */

    // exactly same as DP_17.

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
        int[] arr = {5,2,6,4};
        int diff = 3;
        int totSum = 0;
        for(int e : arr)totSum += e;

        if((totSum-diff < 0) || (totSum-diff) % 2 != 0){
            System.out.println("Not a possible case.");
            return;
        }
        System.out.println(viaTabulation(arr, (totSum-diff)/2));
    }
}
