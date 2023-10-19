package DP;

import java.util.Collections;

public class DP_28_Longest_Palindromic_Subsequence {

    // for ex. s1 = "bbbab" => ab, bb, bbb, bbbb, bab. means it can be contiguous and can not be but, it will follow the order with sure.

    // we can solve this using brute force like generate all the subsequences and check that which one is longest and as well as a palindrome.

    // But can we solve it using LCS and answer is to that is YES.

    // Idea is that firstly we have to find the Palindromic subsequences
    // Instead of thinking to generate all subsequence we can do like that

    // Reverse the string and try to find out the longest common subsequence in both right and reverse order. that will be our answer.
    // so when we will search LCS we will find same string in reverse string if that thing will be palindrome.
    // because we are searching common subsequence and if something which is common in both that means they are palindrome because second string is
    // reverse of the first string. if they are matching then it means they are palindrome.

    public static int viaTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];


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
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];


        for(int i = 1; i <= n; i++){
           int[] curr = new int[m+1];
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
        String s1 = "bbabcbcab";
        String s2 = "";
        for(int i = s1.length()-1; i >= 0; i--)s2 += s1.charAt(i);


       // System.out.println(viaTabulation(s1, s2));

        System.out.println(viaSpaceOptimization(s1, s2));
    }
}
