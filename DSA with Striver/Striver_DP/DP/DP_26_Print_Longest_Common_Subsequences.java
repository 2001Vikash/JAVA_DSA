package DP;

public class DP_26_Print_Longest_Common_Subsequences {

    public static void lcsPrinting(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++)dp[i][0] = 0;
        for(int j = 0; j <= m; j++)dp[0][j] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // backtracking and find the at a particular element at an index where will it been come. and go there.
        // if we are moving diagonally means i-1, j-1 then we will print.

        String ans = "";

        int i = n, j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans = s1.charAt(i-1) + ans;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        String s1 = "abde";
        String s2 = "cbde";
        lcsPrinting(s1, s2);
    }
}
