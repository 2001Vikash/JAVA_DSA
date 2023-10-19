package DP;

import java.util.Arrays;

public class DP_05_Maximum_sum_of_Non_Adjacent_Elements {
    // Refer question from codeStudio

    // what does come first in mind that is let's try out all subsequences with the given constraints and pick that have maximum sum.

    // here we have to find all subsequences means apply recursion first and then try to see overlapping sub-problems.
    // to find subSequences with the help of pick/non-pick.

    // treat as ind, do stuffs on that index, return best.

    // so print subsequence with no adjacent element.


    public static int viaRecursion(int ind, int[] arr){

        // Time complexity -> O(2^n) in indeed something less than that.

        if(ind == 0){
            return arr[ind];// if we at 0 then it means 1 has not picked. means pick this and return.
        }
        if(ind < 0){
            return 0;
        }
        int pick = arr[ind] + viaRecursion(ind - 2, arr);// because adjacent elements are not allowed to take that is constraints.
        int not_pick = viaRecursion(ind - 1, arr);

        return Math.max(pick, not_pick);
    }

    public static int viaMemoization(int ind, int[] arr, int[] dp){

        // Time complexity -> O(n)
        // Space complexity -> O(n) for recursion stack + O(n) for dp.

        if(ind == 0){
            return arr[ind];
        }
        if(ind < 1){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = arr[ind] + viaMemoization(ind - 2, arr, dp);
        int not_pick = viaMemoization(ind - 1, arr, dp);

        return dp[ind] = Math.max(pick, not_pick);
     }

     public static int viaTabulation(int[] arr){

        // Time complexity -> O(n).
         // Space complexity -> O(n) and not any auxiliary space for the stack.

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            int pick = arr[i];
            if(i > 1){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length - 1];
     }

    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
      //  System.out.println(viaRecursion(arr.length - 1, arr));

//        int[] dp = new int[arr.length];
//        Arrays.fill(dp, -1);
//        System.out.println(viaMemoization(arr.length - 1, arr, dp));

    //    System.out.println(viaTabulation(arr));



        // Space Optimization

        // Basically if we see clearly we can see that only previous two values are required for the further calculation.
        // instead of using a dp array we can use two variables.

        // Time complexity -> O(n)
        // Space complexity -> O(1).

        int prev2 = 0;
        int prev1 = arr[0];
        for(int i = 1; i < arr.length; i++){
            int take = arr[i];
            if(i > 1)take += prev2;
            int nonTake = prev1;
            int curr = Math.max(take, nonTake);
            prev2 = prev1;
            prev1 = curr;
        }

        System.out.println(prev1);
    }
}
