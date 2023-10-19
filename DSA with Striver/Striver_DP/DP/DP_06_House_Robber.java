package DP;

// To know about problem then please refer the websites codeStudio.

// this question is same as previous that was maxSum but in this question is one more constraint that is first and last house are adjacent that means
 // in circular manner house are. so means first and last house we can't take because they are also adjacent.
// Is really necessary to think any other logic answer is -> NO , because this the extension of previous question.

import java.util.Arrays;

public class DP_06_House_Robber {

    public static int viaMemoizationAns1(int ind, int[] arr, int[] dp){// here we are taking all elements except last
        if(ind == 0){
            return arr[ind];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = arr[ind] + viaMemoizationAns1(ind-2, arr, dp);
        int notPick = viaMemoizationAns1(ind-1, arr, dp);
        return dp[ind] = Math.max(pick, notPick);
    }

    public static int viaMemoizationAns2(int ind, int[] arr, int[] dp){// here we are excepting first element.
        if(ind == 1){
            return arr[ind];
        }
        if(ind < 1){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = arr[ind] + viaMemoizationAns2(ind-2, arr, dp);
        int notPick = viaMemoizationAns2(ind - 1, arr, dp);

        return dp[ind] = Math.max(pick, notPick);
    }

    // And same thing for tabulation we know that.

    // let us do it using space optimization.
    public static int solve(int[] arr){
        int prev2 = 0;
        int prev1 = arr[0];
        for(int i = 1; i < arr.length; i++){
            int pick = arr[i];
            if(i > 1)pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,3};
//        int[] dp1 = new int[arr.length];
//        int[] dp2 = new int[arr.length];
//        Arrays.fill(dp1, -1);
//        Arrays.fill(dp2, -1);
//        int ans1 = viaMemoizationAns1(arr.length - 2, arr, dp1);
//        int ans2 = viaMemoizationAns2(arr.length - 1, arr, dp2);
//        System.out.println(Math.max(ans1, ans2));

        int[] temp1 = new int[arr.length - 1];
        int[] temp2 = new int[arr.length - 1];
        for(int i = 1; i < arr.length; i++){
            temp1[i-1] = arr[i];
        }

        for(int i = 0; i < arr.length-1; i++){
            temp2[i] = arr[i];
        }

        System.out.println(Math.max(solve(temp1), solve(temp2)));
    }
}
