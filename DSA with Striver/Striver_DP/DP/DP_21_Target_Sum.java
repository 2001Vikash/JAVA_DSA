package DP;

public class DP_21_Target_Sum {

    // So here in this question we have to assign the +ve and -ve numbers and find out the assigning way to achieve the target.
    // or we can say that how many ways to assign the sign to numbers that will give the target.
    // for ex. if we assign -1,2,3,-1 = 3 so this the first way to achieve the target. and second way can be 1,-2,3,1 = 3.

    // So in this question we can go for recurrence as +ve and -ve call for a number and add both of them and check that they are equal to the target or not.

    // But can we solve this problem using previous thing whatever we did.
    // and Answer is to this question is YES we can.
    // It is same as s1-s2 = D, here s1 can be +ve numbers of set and s2 can be -ve numbers of set.
    // so without assigning any sign we can find our answer.
    // actually this question is exactly same as that question . There are only language difference.
    // Divide the array in to 2 subsets such that s1 - s2 = target.

    // This is related to DP_18 and DP_17.

    public static int viaTabulation(int[] arr, int target){
        int[][] dp = new int[arr.length][target+1];
        // base case
        for(int i = 0; i < arr.length; i++)dp[i][0] = 1;
        if(arr[0] <= target){
            dp[0][arr[0]] = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            for (int tar = 0; tar <= target; tar++) {
                int notPick = dp[i - 1][tar];
                int pick = 0;
                if (arr[i] <= tar) {
                    pick = dp[i - 1][tar - arr[i]];
                }
                dp[i][tar] = pick + notPick;
            }
        }
        return dp[arr.length-1][target];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        int target = 3;
        int totSum = 0;
        for(int a : arr)totSum += a;

        if((totSum-target) < 0 || (totSum - target) % 2 != 0){
            System.out.println("Not Possible");
        }else{
            System.out.println("No. of ways to assigning sign is = " + viaTabulation(arr, (totSum-target)/2));
        }
    }
}
