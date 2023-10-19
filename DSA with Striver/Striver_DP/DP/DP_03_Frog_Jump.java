package DP;

import java.util.Arrays;

public class DP_03_Frog_Jump {

    // Problem -> When you are coming for the revision of this Question please refer the websites.

    // Why a greedy solution does not work here ?
    // if we check for this ex {30,10,60,10,60,50} then we will stick via greedy because we try always for the minimal.
    // greedy will give 60 but minimum answer is 40. frog can take jump 1 or 2.

    // Recursion  -> Try all possible ways.
        //        -> find minimum.

    // So what we need to do
    // -> treat as index , do all stuffs on that index, take the min of all stuffs.

    public static int viaRecursion(int ind, int[] arr){// treat n as an index.
        if(ind == 0){
            return 0; // if I am at 0 index then there is no energy required to jump 0 to 0
        }
        int leftRec = viaRecursion(ind-1, arr) + Math.abs(arr[ind] - arr[ind-1]);// do all stuffs at ind
        int rightRec = Integer.MAX_VALUE;
        if(ind > 1) {// due to index out of bound
           rightRec  = viaRecursion(ind - 2, arr) + Math.abs(arr[ind] - arr[ind - 2]);
        }
        return Math.min(leftRec, rightRec); // take the min of all possibles.
    }

    // So there are multiple overlapping sub problems means we definitely try out DP with Memoization.

    // Now Recursion -> DP
    // Memoization -> Look at the parameters are changing. in this question only one parameter will change that it ind.
    // so we create Dp[n+1], give the base case, check previously computed or not, then stored the calculated value.

    // TC -> O(n). And SC -> O(n)+O(n).

    public static int viaMemoization(int ind, int[] arr, int[] Dp){
        if(ind == 0){
            return 0;
        }
        if(Dp[ind] != -1){
            return Dp[ind];
        }
        int leftCall = viaMemoization(ind-1, arr, Dp) + Math.abs(arr[ind] - arr[ind-1]);
        int rightCall = Integer.MAX_VALUE;
        if(ind > 1){
            rightCall = viaMemoization(ind-2, arr, Dp) + Math.abs(arr[ind] - arr[ind-2]);
        }
        return Dp[ind] = Math.min(leftCall, rightCall);
    }

    public static int viaTabulation(int n, int[] arr){
        // Now it's time to solve it using tabulation that is Bottom-up.
        // Memoization -> top-down but tabulation is exactly reverse of the memoization.
        // In actuality, we are trying to convert recursive solution to iterative solution.

        // Step 1 -> see in Memoization how many size Dp will be used over there. make it same as
        // Step 2 -> look at the base case that is dp[0] = 0.
        // Step 3 -> see how recursion executing like go from n-1 to 0. with the help of loop.
        // Step 4 -> see what's the stuffs(means function calls) down in the recursion replace with dp as well in the loop.
        int[] Dp = new int[n];
        Dp[0] = 0;
        for(int i = 1; i < n; i++){
            int left = Dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = Dp[i-2] + Math.abs(arr[i] - arr[i-2]);// function will be replaced by the Dp that's it.
            }

            Dp[i] = Math.min(left, right);
        }
         return Dp[n-1];
    }

    public static void main(String[] args) {
        int n = 6;
        int[]arr = {30,10,60,10,60,50};// energy taken by frog is arr[i] = abs(arr[i]-arr[i-1] and same for 2.
        //System.out.println(viaRecursion(n-1, arr));// due to treat as ind.

//        int[] Dp = new int[n];// because we are using 0-based indexing we can also make n+1 it's also all right.
//        Arrays.fill(Dp, -1);
//        System.out.println(viaMemoization(n-1, arr, Dp));

    //    System.out.println(viaTabulation(n, arr));



        // We are definitely stack space is reducing here via Tabulation method.

        // But apart from this can we reduce space as well, like Dp.

        // Note *** -> If we see in tabulation like Dp[ind-1] and Dp[ind-2] similar like then definitely there will be space optimization.

        // because in this type of case we can do Dp's work via variables.


        // Via Space Optimization.

        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int left = prev1 + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }

    // We need to follow up(aage krna hai follow up, means) the next one that says ....
    // here is k jump so frog can take jump i+1, i+2, i+3, i+4, ..... up to k.
}
