package DP;

import java.util.Arrays;

public class DP_32_Distinct_Subsequences {

// So basically this problem is based on String matching problem. or we can say that DP on Strings type problems.

    // In this question we have given two strings and find out the number of occurrences of string s2 in string s1.
    // means we have to follow different methodology to find it means trying out all, ways. and we know that to do this we have to go for recursion.

    // so question is stated that count the ways. so this type of problem what we did previously that is make function and in base case return 0 or 1 accordingly.
    // and write the all function calls state and sum up those and return.

    // ways to write recursion =>
    // 1. express everything in terms of indexes(i, j over here).
    // 2. explore all possibilities.
    // 3. return summation of all possibilities.
    // 4. base case.

    // f(n-1, m-1) means => no. of distinct subsequences of s1[0....j] in s1[0....i].

    public static int viaRecursion(int i, int j, String s1, String s2){

        // TC -> Exponential or 2^n * 2^m in big O
        // SC -> O(n+m) for recursion stack space.

        if(j < 0){
            return 1;// it means we have matched all string s2. which means we will have one answer.
        }
        if(i < 0){
            return 0;// it means we have not matched s2 means j will be remaining means return 0.
        }
//        int match = 0, notMatch = 0;
//        if(s1.charAt(i) == s2.charAt(j)){
//            //                        take                            not take means search another possibilities.
//            match = viaRecursion(i-1,j-1,s1, s2) + viaRecursion(i-1, j, s1, s2);
//        }else{
//            notMatch = viaRecursion(i-1, j, s1, s2);// if not match then search in next part.
//        }
//        return match + notMatch;

        // OR

        if(s1.charAt(i) == s2.charAt(j)){
            // means if char are matching then we have two cases like I can take that from string s1 and I will not take it, I will search another same char.

            return viaRecursion(i-1,j-1,s1,s2) + viaRecursion(i-1, j, s1, s2);
        }else{
            return viaRecursion(i-1, j, s1, s2);
        }
    }

    // Try out via 1-based Indexing.

    public static int viaOneBasedIndexing(int i, int j, String s1, String s2){
        if(j == 0)return 1;
        if(i == 0)return 0;// if we write i at first then a problem will occur when i and j both will be 0.

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return viaOneBasedIndexing(i-1,j-1,s1,s2) + viaOneBasedIndexing(i-1, j, s1, s2);
        }else{
            return viaOneBasedIndexing(i-1, j, s1, s2);
        }
    }

    // There are overLapping sub-problems we can do memoization.

    public static int viaMemoization(int i, int j, String s1, String s2, int[][] dp){

        // TC -> o(n*m), SC -> O(n*m) + O(n+m) which is for recursion stack space.(auxiliary stack space)

//        if(j < 0)return 1;
//        if(i < 0)return 0;
//        if(dp[i][j] != -1)return dp[i][j];
//
//        if(s1.charAt(i) == s2.charAt(j)){
//            return dp[i][j] = viaMemoization(i-1, j-1, s1, s2, dp) + viaMemoization(i-1, j, s1, s2, dp);
//        }else{
//            return dp[i][j] = viaMemoization(i-1, j, s1, s2, dp);
//        }

        // via 1-based indexing => due to this we can convert this in to tabulation easily.
        // this is one way to do 1-based indexing but, we can also make dp[n+1][m+1] for 1 based indexing.

        if(j == 0)return 1;
        if(i == 0)return 0;
        if(dp[i-1][j-1] != -1)return dp[i-1][j-1];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i-1][j-1] = viaMemoization(i-1, j-1, s1, s2, dp) + viaMemoization(i-1, j, s1, s2, dp);
        }else{
            return dp[i-1][j-1] = viaMemoization(i-1, j, s1, s2, dp);
        }
    }

    // Tabulation to remove extra auxiliary stack space.

    public static int viaTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        // base case

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;// if j == 0
        }
        for(int j = 1; j <= m; j++){
            dp[0][j] = 0;// why from 1 because we have written i = 0, j = 0 as 1 and, again we are writing 0. that will create problem so we need to care.

        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static int viaSpaceOptimization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1], curr = new int[m+1];

        // base case


       prev[0] = curr[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public static int viaMoreSpaceOptimization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];

        // base case


        prev[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 1; j--){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
//                else{
//                    prev[j] = prev[j];
//                } // there is no need to write it.
            }
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

       // System.out.println(viaRecursion(s1.length()-1, s2.length()-1, s1, s2));

       // System.out.println(viaOneBasedIndexing(s1.length(), s2.length(), s1, s2));


//        int n = s1.length();
//        int m = s2.length();
//        int[][] dp = new int[n][m];
//        for(int[] a : dp) Arrays.fill(a, -1);
     //   System.out.println(viaMemoization(n-1, m-1, s1, s2, dp));
        // via 1-based indexing
       // System.out.println(viaMemoization(n, m, s1, s2, dp));

     //   System.out.println(viaTabulation(s1, s2));

      //  System.out.println(viaSpaceOptimization(s1, s2));

        System.out.println(viaMoreSpaceOptimization(s1, s2));
    }
}
