package DP;

import java.util.Arrays;

public class DP_34_Wildcard_Matching {

    // This problem is also based on String matching problem.

    // What does question state ? =>
    //                 In this question we have given two strings as usual s1, s2.
    // and in those strings you will be having characters. and you can have ? and you could have *.
    // ? -> matches with single characters.
    // * -> matches with sequence of length 0 or more.
    // Note -> ? and * will be only in the string s1 not in s2.

    // for ex. s1 = "?ay", s2 = "ray" => y, a matches and r matches with ? because if ? will come means matches with single char. means you need to retrun true.

    // for ex. s1 = "ab*cd", s2 = "abdefcd" => d,c, a, b are matches And remaining portion is matches with * because it says
    // if * will come then it means matches with sequence of length 0 or more. hence return true.
    // for ex. s1 = **abcd, s2 = abcd it will return true as well.
    // for ex. s1 = ab?d, s2 = abcc, a, b matches and c matches with ? but c does not match with d that's why it will return false.

    // s1 = ab*cd, s2 = abdefcd, when main problem will occur off-course at the time when * will come.
    // so we don't know what length should be required for * to matching that's why we will try all possible ways to do that
    // whenever all possible ways comes in action it means Recursion but here we have to try Recursion with String Matching.

    // rules for recurrence -> express in terms of indexes i, j, do all comparisons, and return true if any one is giving true otherwise false.


    public static boolean viaRecursion(int i, int j, String s1, String s2){

        // TC -> Exponential, SC -> o(n+m)

        if(i < 0 && j < 0)return true;
        if(i < 0 && j >= 0)return false;
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(s1.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            return viaRecursion(i-1, j-1, s1, s2);
        }
        if(s1.charAt(i) == '*'){
            //       for empty string                     for taking sequence of some length
            return viaRecursion(i-1, j, s1, s2) || viaRecursion(i, j-1, s1, s2);// we can do it via a for loop. but it's a nice way to solve it.
        }
        return false;// if they are neither match, nor ?, nor *, means they are alphabet characters and not matching means return false.
    }


    // There are overlapping sub-problems that's why we have to apply memoization.

    public static boolean viaMemoization(int i, int j, String s1, String s2, int[][] dp){

        // TC -> O(n*m), SC -> O(n+m) + O(n*m).

        if(i < 0 && j < 0)return true;
        if(i < 0 && j >= 0)return false;
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(s1.charAt(k) != '*')return false;
            }
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            int match = viaMemoization(i-1, j-1, s1, s2, dp) ? 1 : 0;
            dp[i][j] = match;
            return match == 1;
        }

        if(s1.charAt(i) == '*'){
            int emptyStringAndTakeSequence = (viaMemoization(i-1, j, s1, s2, dp) || viaMemoization(i, j-1, s1, s2, dp)) ? 1 : 0;
            dp[i][j] = emptyStringAndTakeSequence;
            return emptyStringAndTakeSequence == 1;
        }

        return false;
    }

    // we can remove auxiliary stack space using tabulation method.

    public static boolean viaTabulation(String s1, String s2){

        // TC -> o(n*m), SC -> O(n*m)

        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];

        // base case

//        for(int i = 0; i <= n; i++){
//            for(int j = 0; j <= m; j++){
//                if(i == 0 && j == 0)dp[i][j] = true;
//                if(i == 0 && j > 0)dp[i][j] = false;
//
//                if(j == 0 && i > 0){
//                    boolean flag = true;
//                    for(int k = 0; k < i; k++){
//                        if(s1.charAt(k) != '*'){
//                            flag= false;
//                            break;
//                        }
//                    }
//                    dp[i][j] = flag;
//                }
//            }
//        }

        // OR

        dp[0][0] = true;
        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
        }

             for(int i = 1; i <= n; i++){
                    boolean flag = true;
                    for(int k = 0; k < i; k++){
                        if(s1.charAt(k) != '*'){
                            flag= false;
                            break;
                        }
                    }
                    dp[i][0] = flag;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s1.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }


    public static boolean viaSpaceOptimization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        boolean[] prev = new boolean[m+1];
        prev[0] = true;
        for(int j = 1; j <= m; j++){
            prev[j] = false;
        }

        for(int i = 1; i <= n; i++){
            boolean[] curr = new boolean[m+1];
            boolean flag = true;
            for(int k = 0; k < i; k++){
                if(s1.charAt(k) != '*'){
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?'){
                    curr[j] = prev[j-1];
                }else if(s1.charAt(i-1) == '*'){
                    curr[j] = prev[j] || curr[j-1];
                }else{
                    curr[j] = false;
                }
            }

            prev = curr;
        }

        return prev[m];
    }

    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";
        int n = s1.length();
        int m = s2.length();


      //  System.out.println(viaRecursion(n-1, m-1, s1, s2));

//        int[][] dp = new int[n][m];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(n-1, m-1, s1, s2, dp));

     //   System.out.println(viaTabulation(s1, s2));


        System.out.println(viaSpaceOptimization(s1, s2));
    }
}
