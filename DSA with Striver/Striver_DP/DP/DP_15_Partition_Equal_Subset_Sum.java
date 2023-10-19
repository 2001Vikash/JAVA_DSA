package DP;

public class DP_15_Partition_Equal_Subset_Sum {
    // problem is to divide the array into exactly two subsets which will having equal sum.
    // so basically we can see this problem like that we have total sum s, and we have to find a subset which has sum = s/2.
    // means remaining thing is bounded to give sum s/2.

    public static boolean viaTabulation(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length][target+1];

        // base case
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = true;
        }
        if(arr[0] < target + 1) {
            dp[0][arr[0]] = true;// second base case
        }

        for(int ind = 1; ind < arr.length; ind++){
            for(int tar = 1; tar <= target; tar++){
                boolean nonTake = dp[ind-1][tar];
                boolean take = false;
                if(tar >= arr[ind]){
                    take = dp[ind-1][tar-arr[ind]];
                }

                dp[ind][tar] = take || nonTake;
            }
        }
        return dp[arr.length-1][target];
    }

    public static boolean solution(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)sum += arr[i];

        if(sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        return viaTabulation(arr, sum);
    }
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        System.out.println(solution(arr));
    }
}
