package DP;

import java.util.Arrays;

public class DP_46_Longest_Bitonic_Subsequence_LIS {

    // This question is also based on LIS.
    // Bitonic means you can take something as increase and decrease.
    // for ex., 1,2,10,4,2,1, or 1,11,10,4,2,1 this is Bitonic Subsequence and here in this question We have to return Longest Bitonic subsequence length.
    // It is not only meaning increasing and decreasing, It can jub be increasing or decreasing.
    // Means The Longest increasing/decreasing subsequence is also a Bitonic Subsequence.
    //              {1,11,2,10,4,5,2,1}
    // LIS -> DP1 = {1,2,2,3,3,4,2,1} from normal mode.
    // LIS -> dp2 = {1,5,2,4,3,3,2,1} from the back or if we reverse the array that will be LIS
    // because what we are finding increasing and decreasing so for increasing we will calculate normal LIS dp
    // and for decreasing we will calculate LIS in reverse array .
    // So at 10 what does signify -> at 10 we have 3 length of LIS and 4 length of LDS including 10 like that, 1,2,10 and, 10,4,2,1
    // but, we can see that 10 is common that why answer is 3 + 4 - 1 = 6.
    // so via this we can find entire bitonic like that, 1+1 - 1 = 2 and so on, 1,6,3,6,5,6,3,1 and our answer will be max of this bitonic.


    public static int viaLIS(int[] arr){
        int n = arr.length;
        int[] dp1 = new int[n]; // for forward calculation
        int[] dp2 = new int[n]; // for backward calculation

        // for forward LIS

        for(int i = 0; i < n; i++){
            dp1[i] = 1;
            for(int pre = 0; pre < i; pre++){
                if(arr[pre] < arr[i] && 1 + dp1[pre] > dp1[i]){
                    dp1[i] = 1 + dp1[pre];
                }
            }
        }

        // for backward calculation

        for(int i = n-1; i >= 0; i--){
            dp2[i] = 1;
            for(int pre = n-1; pre > i; pre--){
                if(arr[pre] < arr[i] && 1 + dp2[pre] > dp2[i]){
                    dp2[i] = 1 + dp2[pre];
                }
            }
           // ans = Math.max(ans, dp1[i] + dp2[i] - 1); // we can calculate here as well instead of looping again.
        }

       // System.out.println(Arrays.toString(dp1) + " " + Arrays.toString(dp2));

        int ans = 1;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {1,11,2,10,4,5,2,1};

        System.out.println(viaLIS(arr));
    }
}
