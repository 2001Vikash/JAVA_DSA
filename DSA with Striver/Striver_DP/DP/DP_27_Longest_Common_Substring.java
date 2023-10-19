package DP;

import java.util.Arrays;

public class DP_27_Longest_Common_Substring {

    // Substring -> It must be consecutive. that is the main difference between substring and subsequence like subsequence can be consecutive and can not be
     //           --> but substring must be consecutive. for ex. abc, cjk, klp and so on from both ex.

// Can we solve this using viaRecursion and answer is to that Yes but, we will have been required one more changing variable that's create 3-D DP.
    // So this is not a right way to solve it.

    // We will use the Tabulation method to solve it using some slight changes in the subsequences code in the form of tabulation method.

    // Note => Whenever I will revise this that time I will have to draw the table with my self that will create more understanding for me.


    // We are going to solve it directly viaTabulation due to time complexity.

    public static int viaTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // base case
        for(int i = 0; i <= n; i++)dp[i][0] = 0;
        for(int j = 0; j <= m; j++)dp[0][j] = 0;// we can do it without filling 0 because in java 0 is by default value

        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static int viaSpaceOptimization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];

        // base case


        int ans = 0;
        for(int i = 1; i <= n; i++){
            int[] curr = new int[m+1];
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                    ans = Math.max(ans, curr[j]);
                }else{
                    curr[j] = 0;
                }
            }

            prev = curr;

        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Longest common subsequence => acjkp and Longest common substring => cjk.

     //   System.out.println(viaTabulation(s1, s2));

        System.out.println(viaSpaceOptimization(s1, s2));
    }
}
