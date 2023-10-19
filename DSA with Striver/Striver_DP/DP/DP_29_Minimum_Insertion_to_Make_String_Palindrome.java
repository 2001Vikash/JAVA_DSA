package DP;

public class DP_29_Minimum_Insertion_to_Make_String_Palindrome {
    // insertions/operations.
    // for ex. s = "abcaa" and you can insert any character anywhere in the string.

    // So if we forget minimum then what will come in our mind that is just reverse the string and add that makes it palindrome.
    // here number of operations will be length(s) but we have to find the Min that is different from out naive thinking.

    // So answer can be like aabcbaa, we can make it palindrome with the help of 2 insertion/operation.

    // Let us keep the portion of the string that is already palindrome.
    // for ex. abcaa => a, aa, aaa, aba, aba, aca, aca and so on. but here we will be keep the longest possible palindrome.
    // So we will be keeping the longest palindrome and match with original string and whichever part is not matching reverse it and add.

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

    public static void main(String[] args) {
        String s1 = "abcaa";
        String s2 = "";
        for(int i = s1.length()-1; i >= 0; i--)s2 += s1.charAt(i);

        int ans = s1.length() - viaTabulation(s1, s2);

        System.out.println("Minimum number of insertions/operations will be required to make this string palindrome = " + ans);
    }
}
