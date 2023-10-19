package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class DP_41_42_43_Longest_Increasing_Subsequence_and_Printing_Solution_with_Binary_Search {

    // Here we are starting LIS pattern means -> The Longest Increasing Subsequence.

    // In this question we will try to find the length of the Longest common sub-sequence.
    // It has to be in increasing mode means even equal elements will not be allowed.

    // first of all let us try by all subsequences/ways
    // So we will take f(ind, prev_ind), => meaning of f(3,0) is length of LIS starting from ind, whose prev-Ind is 0.
    // .


    public static int viaRecursion(int ind, int prevInd, int[] arr){

        // TC -> O(2^n) and SC -> O(n).

        if(ind == arr.length){
            return 0;
        }

        int notTake = viaRecursion(ind+1, prevInd, arr);
        int take = -(int) 1e9;
        if(prevInd == -1 || arr[ind] > arr[prevInd]){
            take = 1 + viaRecursion(ind+1, ind, arr);
        }

        return Math.max(take, notTake);
    }

    // Let us memoize it because there are overLapping sub-problems.

    public static int viaMemoization(int ind, int prevInd, int[] arr, int[][] dp){

        // TC -> O(n*n), SC -> O(n*n) + O(n)

        if(ind == arr.length){
            return 0;
        }

        if(dp[ind][prevInd+1] != -1)return dp[ind][prevInd+1];

        int notTake = viaMemoization(ind+1, prevInd, arr, dp);
        int take = -(int) 1e9;
        if(prevInd == -1 || arr[ind] > arr[prevInd]){
            take = 1 + viaMemoization(ind+1, ind, arr, dp);
        }

        return dp[ind][prevInd+1] = Math.max(take, notTake);
    }


    // Let do Tabulation

    public static int viaTabulation(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        // there is no need to write base case because that is 0.

        for(int ind = n-1; ind >= 0; ind--){
            for(int prevInd = ind-1; prevInd >= -1; prevInd--){
                int notTake = dp[ind+1][prevInd+1];
                int take = -(int) 1e9;
                if(prevInd == -1 || arr[ind] > arr[prevInd]){
                    take = 1 + dp[ind+1][ind+1];// because we are taking prevInd+1
                }

                dp[ind][prevInd+1] = Math.max(take, notTake);
            }
        }
        return dp[0][-1+1];
    }


    public static int viaSpaceOptimization(int[] arr){

        // TC -> O(n^2) and SC -> O(n) * 2.

        int n = arr.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];

        for(int ind = n-1; ind >= 0; ind--){
            for(int prevInd = ind-1; prevInd >= -1; prevInd--){
                int notTake = next[prevInd+1];
                int take = -(int) 1e9;
                if(prevInd == -1 || arr[ind] > arr[prevInd]){
                    take = 1 + next[ind+1];// because we are taking prevInd+1
                }

                curr[prevInd+1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[-1+1];
    }


    // There are more optimal solution and in a different way Tabulation method which is in different way.
   // in this method  we will make dp[i] => which signifies -> the length of the longest increasing sub-sequence that ends at index i.

    // let us first do in space complexity O(n) instead if O(n) * 2;

    public static int viaDiffTabulation(int[] arr){

        // TC -> O(n^2) and SC -> O(n)

        int n = arr.length;
        // please initialize dp with 1.
        // because every number have one authority to be a part of LIS itself.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;// means itself a number

        for(int i = 0; i < n; i++){
            for(int pre = 0; pre < i; pre++){
                if(arr[pre] < arr[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[pre]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }


    // So how to print LIS , we can do it BackTrack via previous solution DiffTabulation.

    // for this we have to create Hash array , in this initially we can store index value. or we can simply do it at the time looping.

    public static void printingLIS(int[] arr){

        // TC -> O(n^2) and SC -> O(n)

        int n = arr.length;
        // please initialize dp with 1.
        // because every number have one authority to be a part of LIS itself.
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;// means itself a number

        int[] hash = new int[n];
        int lastInd = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int pre = 0; pre < i; pre++){
                if(arr[pre] < arr[i] && dp[i] < 1 + dp[pre]){
                    dp[i] =  1 + dp[pre];
                    hash[i] = pre;
                }
            }
            if(dp[i] > ans){
                ans = dp[i];
                lastInd = i;
            }
        }

        int[] print = new int[ans];

        int i = 0;
        print[i] = arr[lastInd];
       while(hash[lastInd] != lastInd){
           lastInd = hash[lastInd];
           print[++i] = arr[lastInd];
       }

       for(int j = print.length-1; j >= 0; j--){
           System.out.print(print[j] + " ");
       }

    }


    // Via Binary search we can do it.

    // Intuition => let us form a new array and put the first element and check for next element if that is greater than previous then put that
    // in same array and if not then please create another array to put but before putting we have to check if something is smaller in previous
    // array and that follows the subsequence rule put it as well and so on. So and in last check which array has the longest length take it, and we can print as well.
    // that is main intuition behind this approach but, we will not do it this question by this because it will take a lot of space and as well hectic more.

    // So here BS will come in action instead of creating new array can rewrite in same array -> YES
    // because instead of creating new array and fitting the element we will see like in which place current element can be put.
    // and to check that place we will apply Binary search to find the right place to put the current element in existing array.
    // it never means like if someone is not following subsequence rule then it will be considered as part of LIS no,
    // we know that we are rewriting/overwrite only and in last we will find our desired result but not right subsequence we wll only find our length
    // of the LIS. that's  why we will do it. If we want to print then we have to go via previous approach.
    // BS will never create problem because we know that we are going in increasingly manner.


    public static int viaBS(int[] arr){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();// because we don't know about the length of LIS.

        list.add(arr[0]);

        for(int i = 1; i < n; i++){
            if(arr[i] > list.get(list.size()-1)){
                list.add(arr[i]);
            }else{
                // apply Binary search to find the right index to rewrite
                int s = 0;
                int e = list.size()-1;
                int target = arr[i];

                while (s <= e){
                    int m = s + (e - s) / 2;
                    if(target <= list.get(m)){
                        e = m - 1;
                    }else{
                        s = m + 1;
                    }
                }
                list.set(s, target);
            }
        }

        return list.size(); // instead of returning this we can create a variable l because list.size() will take little-bit more time in cal.
    }


    public static void main(String[] args) {

    //    int[] arr = {10,9,2,5,3,7,101,18};

     //   int[] arr = {5,4,11,1,16,8}; // to understand optimal tabulation method

       // System.out.println(viaRecursion(0,-1, arr));

//        int[][] dp = new int[arr.length][arr.length+1];
//        for(int[] a : dp) Arrays.fill(a, -1);

        // We can not pass -1, but we need to pass that's why we will use index shifting means -1,-> 0, 0 -> 1 and so on.
      //  System.out.println(viaMemoization(0, -1, arr, dp));


       // System.out.println(viaTabulation(arr));

       // System.out.println(viaSpaceOptimization(arr));

       // System.out.println(viaDiffTabulation(arr));

        // for printing LIS
     //   printingLIS(arr);



        // To understand Binary search code
        int[] arr = new int[]{1,7,8,4,5,6,-1,9};// this is also a way to represent array.

        System.out.println(viaBS(arr));
    }
}
