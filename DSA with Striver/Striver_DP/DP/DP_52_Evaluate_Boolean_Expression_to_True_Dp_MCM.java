package DP;

import java.util.Arrays;

public class DP_52_Evaluate_Boolean_Expression_to_True_Dp_MCM {

    // So in this question we have given a String which is consisting some boolean value and expression like that
    // | -> OR, & -> AND, ^ -> XOR.
    // So can say that when we will go to evaluate in a simple way then T|T&F = F.
    // but what they want to perform like to solve the given string in a such way that at the end of the day you get True.
    // for the given example what can we do, ex. T|T&F => (T)|(T&F) => (T) | (F) => T, this is a one way to do it.
    // So you have to find the number of ways to solve given expression that will give true at the end of day.
    // one thing we know here that is start with true or false and in an alternate manner operator then operand and so on.
    // so at every operator we will try to divide into sub-problems and solve them

    // So we can see that this problem is like that MCM.
    // so if we divide it into two sub-problems then we can relate with MCM that the number of total ways
    // so if operator is & then number of ways = x * y where x is no. of ways the left is true and y for the right part.

    // So in actually here we are using MCM but let us se -> (exp1) | (exp2) -> so if we know that exp1 will give 3 times true and 2 times false
    // and in same manner exp2 will give 2 times true and 3 times false then we evaluate here like how many ways we to find true.
    // because we know that in case of OR if both are F then it will give false otherwise true.
    // so 3 T from exp1 and 2 T from exp2 interact and will give 3 * 2 = 6 T, because T, T, T and T, T. so we have 6 ways to find true.
    // and as well 3 T * 2 F = 6 T, 2 F * 3 T = 6 T so overall 6 + 6 + 6 = 18,
    // if someone is asking me about false then 2 F * 3 F = 6 F. so we will use this concept as MCM. like that we will do for ^ , &.

    // To understand in more deep way, then please watch the video again.


    public static int viaRecursion(int i, int j, boolean isTrue, String exp){

        // TC => exponential

        if(i > j)return 0;
        if(i == j){
            if(isTrue){
                return exp.charAt(i) == 'T' ? 1 : 0; // if it is true means there is a way.
            }else{
                // means we are looking for a false
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ways = 0;

        for(int ind = i+1; ind <= j-1; ind += 2){

            int leftT = viaRecursion(i, ind-1, true, exp); // because I am looking for no. of ways to give true.
            int leftF = viaRecursion(i, ind-1, false, exp);
            int rightT = viaRecursion(ind+1, j, true, exp);
            int rightF = viaRecursion(ind+1, j, false, exp);

            if(exp.charAt(ind) == '&'){
                if(isTrue){
                    ways = ways + (leftT * rightT); // multiplication because we are wanting to total number of ways like MCM problem
                }else{
                    ways = ways + (leftF * rightT) + (leftT * rightF) + (leftF * rightF);
                }
            }else if(exp.charAt(ind) == '|'){
                if(isTrue){
                    ways = ways + (leftT * rightT)+ (leftT * rightF) + (leftF * rightT);
                }else{
                    ways += (leftF * rightF);
                }
            }else {
                // means for '^' , XOR case

                if(isTrue){
                    ways = ways + (leftT * rightF) + (leftF * rightT);
                }else {
                    ways = ways + (leftT * rightT) + (leftF * rightF);
                }
            }
        }
        return ways;
    }


    public static int viaMemoization(int i, int j, boolean isTrue, String exp, int[][][] dp){
        if(i > j)return 0;
        if(i == j){
            if(isTrue){
                return exp.charAt(i) == 'T' ? 1 : 0; // if it is true means there is a way.
            }else{
                // means we are looking for a false
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        if(dp[i][j][isTrue ? 1 : 0] != -1)return dp[i][j][isTrue ? 1 : 0];

        int ways = 0;

        for(int ind = i+1; ind <= j-1; ind += 2){

            int leftT = viaMemoization(i, ind-1, true, exp, dp); // because I am looking for no. of ways to give true.
            int leftF = viaMemoization(i, ind-1, false, exp, dp);
            int rightT = viaMemoization(ind+1, j, true, exp, dp);
            int rightF = viaMemoization(ind+1, j, false, exp, dp);

            if(exp.charAt(ind) == '&'){
                if(isTrue){
                    ways = ways + (leftT * rightT); // multiplication because we are wanting to total number of ways like MCM problem
                }else{
                    ways = ways + (leftF * rightT) + (leftT * rightF) + (leftF * rightF);
                }
            }else if(exp.charAt(ind) == '|'){
                if(isTrue){
                    ways = ways + (leftT * rightT)+ (leftT * rightF) + (leftF * rightT);
                }else{
                    ways += (leftF * rightF);
                }
            }else {
                // means for '^' , XOR case

                if(isTrue){
                    ways = ways + (leftT * rightF) + (leftF * rightT);
                }else {
                    ways = ways + (leftT * rightT) + (leftF * rightF);
                }
            }
        }
        return dp[i][j][isTrue ? 1 : 0] = ways;
    }



    public static void main(String[] args) {
        String expression = "T|T&F^T";
        int n = expression.length();

// here I am passing true initially because I am looking for no. of ways which will give me True.
      //  System.out.println(viaRecursion(0, n-1, true, expression));

        int[][][] dp = new int[n][n][2];// 0 or 1
        for(int[][] ar : dp){
            for(int[] a : ar) Arrays.fill(a, -1);
        }
        System.out.println(viaMemoization(0, n-1, true, expression, dp));
    }
}

