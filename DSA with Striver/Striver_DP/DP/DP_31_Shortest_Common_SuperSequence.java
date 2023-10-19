package DP;

public class DP_31_Shortest_Common_SuperSequence {

    //  In this question we have to make a String which have string 1 and string 2 also.
    // for ex. s1 = brute, s2 = groot, then we can make a String brutegroot which has both. so this can be called common superSequence.
    // but in question we have to find the shortest string for ex. bgruoote this is also superSequence and short as well.
    // remember order has to be same. we can't change order.

    // Intuition behind this question is that common things (lcs)  should be taken once.

    public static int viaLCS(String s1, String s2){
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
        String s1 = "brute";
        String s2 = "groot";
        int n = s1.length();
        int m = s2.length();
        int lengthOfLcs = viaLCS(s1, s2);
        int ans = n + m - lengthOfLcs;
        System.out.println(ans);

        // Print the shortest common superSequence.

        // for this we have to generate DP table for LCS

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

        int i = n, j = m;
        String res = "";
        while (i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                res = s1.charAt(i-1) + res;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                res = s1.charAt(i-1) + res;
                i--;
            }else{
                res = s2.charAt(j-1) + res;
                j--;
            }
        }

        while(i > 0){
            res = s1.charAt(i-1) + res;
            i--;
        }
        while (j > 0){
            res  = s2.charAt(j-1) + res;
            j--;
        }

        System.out.println(res);
    }
}
