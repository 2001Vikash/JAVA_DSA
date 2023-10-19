package DP;

import java.util.Arrays;

public class DP_47_Number_Of_Longest_Increasing_Subsequence {

       // Here we have to find the number of the longest increasing subsequence
    // for ex. 1,3,4,5 and 1,3,5,7 means there two the longest increasing which has equal length.
    // So to solve this intuition is that -> we have to maintain another array that named as count
    // and in count array we will manage the number of LIS with same length and in last find the max of count array that will be our answer.
    // means whenever dp[i] is same means no change in dp[i] then we will increase the count value that is the intuition.

    public static int solution(int[] arr){
        int n = arr.length;
        int[] dp = new int[n], count = new int[n];
        int maxi = 1;

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int pre = 0; pre < i; pre++){
                if(arr[pre] < arr[i] && 1 + dp[pre] > dp[i]){
                    dp[i] = 1 + dp[pre];
                    count[i] = count[pre];
                }else if(arr[pre] < arr[i] && 1 + dp[pre] == dp[i]){
                    count[i] += count[pre];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int numberOfLIS = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi) numberOfLIS += count[i];
        }

        return numberOfLIS;
    }



    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};

        System.out.println(solution(arr));
    }
}
