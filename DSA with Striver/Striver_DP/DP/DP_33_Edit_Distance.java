package DP;

import java.util.Arrays;

public class DP_33_Edit_Distance {

    // It's a famous LeetCode hard problem

    // In this problem we have given two strings s1 = horse, s2 = ros and three operations which we can do.
    // 1. Insert -> you can take any character or word and, you can insert in s1 anywhere.
    // 2. Remove -> you can take any character and remove from the s1.
    // 3. Replace -> pick up any character in string s1 and replace any given character.

    // to do these three operations you have to tell me what is the no. of minimum steps in which you can convert this string s1 in to string s2.

    // Is it always possible => YES. in n+m steps in worst case.
    // we can go like this s1 = horse, s2 = ros => replace h -> r => rorse, remove r -> rose, remove e -> ros, and answer is 3 that is minimum.
    // another ex. -> s1 = intention, s2 = execution,=> remove t, replace i to e, replace n to x, replace n to c, insert u => execution. answer = 5.

    // Basically this is also from string matching problem types.
    // so if characters are matching then no. problem but what if they are not matching, in this case we have three operations to do, insert, remove, replace
    // try out all, ways -> recursion => and find the minimum of them.

    // how to write recurrence => try to do in index form like we have requirement of (i, j), and do all stuffs for string matching, return min, base case

    // s1 = horse, s2 = ros => f(i, j) -> assume f(n-1, m-1) what does it signify, -> this signifies find the min operation to convert s1[0...i] to s2[0..j].
    // if something is matching then there is no need to do anything just we have to shrink both string.

    // if they are not matching then first of all we can do insert => in this horse if i at e and ros, j at s -> not match then insert s ahead of e
    // hypothetically s1 will be horses, s2 = ros, s match with s then move j and i will remain same at e because s hypothetically inserted next of e.
    // so there is no need to reduce i.

    // or we can perform delete operation means lets delete e and match with i-1 to j.

    // or we can do replace -> just replace e with s and move ahead i-1, j-1.


    public static int viaRecursion(int i, int j, String s1, String s2){

        // TC -> exponential -> like 3 ^ n * 3 ^ m like that
        // SC -> O(n+m) auxiliary stack space.

        // base cases will come when it's over.

        // if s1 gets exhausted -> horse, ros -> if i = -1 and assume j = 1, means we have to make ro but s1 gets exhausted, how many min operation will be
        //                         required to make ro and answer is = 2.
        //                       means f(-1, 1) -> minimum operations to convert empty string to a string s2[0...1] means ro. = 2. means return j+1.


        // if s2 gets exhausted -> s1 = horse, assume i = 2, and s2 = ros, j = -1
        //                      f(2, -1) means -> min operations to convert hor to an empty string. that is i+1.
        //                     means return i+1. delete operations. generally.

        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return viaRecursion(i-1, j-1, s1, s2); // if they are matching then move ahead no need to perform any operation means 0+ahead.
        }//else{
//            int insert = 1 + viaRecursion(i, j-1, s1, s2);
//            int delete = 1 + viaRecursion(i-1, j, s1, s2);
//            int replace = 1 + viaRecursion(i-1, j-1, s1, s2);
//
//            return Math.min(insert, Math.min(delete, replace));

            // OR

            return 1 + Math.min(viaRecursion(i,j-1,s1,s2), Math.min(viaRecursion(i-1,j,s1,s2), viaRecursion(i-1,j-1,s1,s2)));
       // }
    }

    // Try to do it viaMemoization because there are overlapping sub-problems.

    public static int viaMemoization(int i, int j, String s1, String s2, int[][] dp){

        // TC -> O(n*m), SC -> O(n*m) + O(n+m).

        if(i < 0)return j+1; // return j if i == 0, because we are using i based indexing we are assuming .same as for j.
        if(j < 0)return i+1;
        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = viaMemoization(i-2, j-1, s1, s2, dp);
        }else {
            int insert = 1 + viaRecursion(i, j - 1, s1, s2);
            int delete = 1 + viaRecursion(i - 1, j, s1, s2);
            int replace = 1 + viaRecursion(i - 1, j - 1, s1, s2);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }


    public static int viaTabulation(String s1, String s2){

        // TC -> O(n*m), SC -> O(n*m).

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        // base case.
        for(int i = 0; i <= n; i++){
            dp[i][0] = i; // i because due to 1 based indexing.
        }
        for(int j = 1; j <= m; j++){
            dp[0][j] = j;// avoid again write 0, 0.
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert =  1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }


    public static int viaSpaceOptimization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1], curr = new int[m+1];

        // base case.
       // first loop only work for 0,0 in prev which is 0.
        for(int j = 0; j <= m; j++){
            prev[j] = j;
        }

        for(int i = 1; i <= n; i++){
            curr[0] = i;// it will fill first loop work. // at j == 0, always i.
            // I don't know why it will give  wrong ans. but in c++ it is working properly.

            // but it will work when we will make curr in loop.
            // like that
            // int[] curr = new int[m+1].
            // curr[0] = i;
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
//                    int insert =  1 + curr[j-1];
//                    int delete = 1 + prev[j];
//                    int replace = 1 + prev[j-1];
//
//                    curr[j] = Math.min(insert, Math.min(delete, replace));

                    // or

                    curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
                }
            }
            prev = curr;
        }

        return prev[m];
    }


    // we can not more optimization because here j-1 is also using.


    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();

    //    System.out.println(viaRecursion(n-1, m-1, s1, s2));

//        int[][] dp = new int[n][m];// but it's easy to convert in to tabulation if we make n+1, m+1, shifting of index.
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(n-1, m-1, s1, s2, dp));


      //  System.out.println(viaTabulation(s1, s2));

        System.out.println(viaSpaceOptimization(s1, s2));
    }
}
