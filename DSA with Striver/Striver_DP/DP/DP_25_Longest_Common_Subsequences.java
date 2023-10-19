package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DP_25_Longest_Common_Subsequences {

    // From here we are going to start DP on Strings. and we will be solving problems like Comparison, replaces/edit.

    // Subsequences -> abc -> a,b,c,ab,bc,ac,abc,"".
     //               So subsequences can be consecutive, can be non-consecutive, but as long as it will maintain the order in the String.

    // LCS -> means we have two strings, S1 and S2. And we have to find the Longest common subsequences.

    public static int viaRecursion(int ind1, int ind2, String s1, String s2){

        // Time complexity -> O(2^n*2^m) = O(2^n+m) and Space complexity O(n+m). because n+m is the depth of recursion tree.

        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1 + viaRecursion(ind1-1, ind2-1, s1, s2);
        }

        return Math.max(viaRecursion(ind1-1, ind2, s1, s2), viaRecursion(ind1, ind2-1, s1,s2));
    }

    public static int viaRecursion2(int ind1, int ind2, String s1, String s2){

        // Time complexity -> O(2^n*2^m) = O(2^n+m) and Space complexity O(n+m). because n+m is the depth of recursion tree.

        if(ind1 == 0 || ind2 == 0){ // due to this thing we can easily write tabulation.
            return 0;
        }
        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
            return 1 + viaRecursion2(ind1-1, ind2-1, s1, s2);
        }

        return Math.max(viaRecursion2(ind1-1, ind2, s1, s2), viaRecursion2(ind1, ind2-1, s1,s2));
    }

    public static int viaMemoization(int i, int j, String s1, String s2, int[][] dp){

        // TC -> O(n*m) and SC -> O(n*m) + O(n+m) for recursion stack space. and (n+m) because we are deleting alternate characters from both strings on words

        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + viaMemoization(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(viaMemoization(i-1, j, s1, s2, dp), viaMemoization(i, j-1, s1, s2, dp));
    }

    public static int viaMemoization2(int i, int j, String s1, String s2, int[][] dp){

        // TC -> O(n*m) and SC -> O(n*m) + O(n+m) for recursion stack space. and (n+m) because we are deleting alternate characters from both strings on words

        if(i == 0 || j == 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1 + viaMemoization2(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = Math.max(viaMemoization2(i-1, j, s1, s2, dp), viaMemoization2(i, j-1, s1, s2, dp));
    }

    public static int viaTabulation(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // base case, write changing parameters with reverse fashion via loops
        // for the base case we will use shifting of Index. without this we can do it. but it will be tricky.

        // base case
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
       for(int i = 0; i <= m; i++){
           dp[0][i] = 0;
       }

       for(int i = 1; i <= n; i++){
           for(int j = 1; j <= m; j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
               }else{
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
           }
       }
       return dp[n][m];
    }

    public static int viaSpaceOptimization(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[] prev = new int[m+1], curr = new int[m+1];
        // base case, write changing parameters with reverse fashion via loops
        // for the base case we will use shifting of Index. without this we can do it. but it will be tricky.

        // base case
        for(int j = 0; j <= m; j++){
            prev[j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "dbce";
        String s2 = "abce";

       // System.out.println(viaRecursion(s1.length()-1, s2.length()-1, s1, s2));


//        int[][] dp = new int[s1.length()][s2.length()];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(s1.length()-1, s2.length()-1, s1, s2, dp));

     //   System.out.println(viaRecursion2(s1.length(), s2.length(), s1, s2));

//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization2(s1.length(), s2.length(), s1, s2, dp));

        System.out.println(viaTabulation(s1, s2));

        System.out.println(viaSpaceOptimization(s1, s2));
    }
}
