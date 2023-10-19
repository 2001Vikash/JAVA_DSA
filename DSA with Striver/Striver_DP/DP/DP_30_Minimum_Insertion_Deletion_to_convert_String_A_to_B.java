package DP;

public class DP_30_Minimum_Insertion_Deletion_to_convert_String_A_to_B {

    // We can perform a couple of operations like we can delete any char and as well we can insert also.
    // for ex. s1 = abcd, s2 = anc
    // Is every time possible to convert s1 to s2 => and answer to that is YES because first of all delete all elements from s1 and insert char similar to s2.
    // Means max operations I will have to take to convert s1 to s2 is lengthOfs1 for delete + lengthOfs2 for insert.
    // We have to find the minimum operations required.

    // In this type of question first of all we need to brainstorm like WHAT CAN I NOT TOUCH?

    // so let us look that how many minimum operations are required to convert abcd in to anc.
    // delete b and d and insert n => answer = 3.

    public static int viaRecursion(int i, int j, String s1, String s2){
        if(i < 0 || j < 0){
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + viaRecursion(i-1, j-1, s1, s2);
        }

        return Math.max(viaRecursion(i-1, j, s1, s2), viaRecursion(i, j-1, s1, s2));
    }

    public static int viaTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // base case will be dp[0][i] and dp[i][0] = 0, in java there is no need to do it because it's by default.
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
        String s1 = "abcd";
        String s2 = "anc";
        int n = s1.length();
        int m = s2.length();
        int lcs = viaTabulation(s1, s2);
        int deleteOperations = n - lcs;
        int insertOperations = m - lcs;
        int ans = deleteOperations + insertOperations;
        System.out.println(ans);
    }
}
