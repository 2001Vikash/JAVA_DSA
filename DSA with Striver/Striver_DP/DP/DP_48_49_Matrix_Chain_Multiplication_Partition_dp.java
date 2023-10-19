package DP;
import java.util.Arrays;
public class DP_48_49_Matrix_Chain_Multiplication_Partition_dp {

    // from here we are going to start new pattern dp that is Partition DP.

    // In partition dp problems like whenever multiple ways to solve a problem and if they are asking the best possible solution then we have to think about it.
    // for ex. (1+2+3)*5 and (1+2) + (3*5) both will give different answers
    // Like that in partition problem they will be giving an array and, probably we have to solve the array in two or more ways or in two portion.
    // to solve this type of problems we have to make two pointers like i from starting and j from the end.

    // So first problem we will solve on this topic is MCM -> that is matrix chain multiplication.

    // let us assume we have given three different matrices A,B,C and their dimensions 10*30, 30*5, 5*60 respectively.
    // If we have two matrix like that 10*30 and 30*5 can they multiply -> YES because 30 is matching according to matrix multiplication law.
    // how many operation(multiply) We have to perform in multiplication of 10*30 and 30*5 matrices that is => 10*30*5 = 1500.
    // So we have to multiply the given matrix., first we will multiply AB then with C. and no. of operation -> (10*30*5)+(10*5*60) = 4500.
    // This is very high operations, can we do it another ways, if we will go A*(BC) then operation will be 27000 which is more than previous.
    // so first way is right.
    // if ABCD is given then we have a lot of ways to multiply , and we have to find the minimum one. this is sign of partition DP.

    // If we have given an array of N length then we have to understand this is given dimension of N-1 matrices.
    // for ex. {10,20,30,40,50} => A->10*20, B->20*30, C->30*40, D->40*50, or we can say A->arr[0]*arr[1] and so on. means ith have dimension arr[i-1]*arr[i].
    // so tell me the minimum number of operations to be required for multiplication. this is question


    // Whenever we see Partition DP types things -> We have to follow some certain rules
    //                               1. Start with entire block/array, always mark with i as start and j as end.
    //                               2. try all partitions, run a loop to try all partitions.
    //                               3. return the best possible 2 partitions, because if put partition at one place then array will be divided into 2 parts.
    //                               4. Base case in this question when i == j then we will return 0 because single matrix will not take any operation.



    public static int viaRecursion(int i, int j, int[] arr){

        // TC -> Exponential in nature, and SC -> O(n).

        if(i == j){ // i > j will also work
            return 0; // means whenever we have only one single matrix then there will no operation means 0.
        }

        int mini = (int)1e9;

        for(int k = i; k <= j-1; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + viaRecursion(i, k, arr) + viaRecursion(k+1, j, arr);
            mini = Math.min(mini, steps);
        }

        return mini;
    }


    // There are overLapping sub-problems then we can apply memoization.


    public static int viaMemoization(int i, int j, int[] arr, int[][] dp){

        // TC -> O(n*n*n) last n is for internal loop. O(n^3), SC->O(n^2) + O(n).

        if(i == j)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int mini = (int)1e9;

        for(int k = i; k <= j-1; k++){

            int steps = arr[i-1] * arr[k] * arr[j] + viaMemoization(i, k, arr, dp) + viaMemoization(k+1, j, arr, dp);
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;
    }


    // To remove extra stack space then we have to apply Tabulation.
    // rules -> copy the base case, write down changing states, copy the recurrence.
    // We know that top-down means bigger problem to smaller problem and tabulation is reverse of this smaller problem to bigger problem.

    public static int viaTabulation(int[] arr){
        int n = arr.length;

        int[][] dp = new int[n][n];

        // there is no need to fill base case because that is zero, which is by-default.

        for(int i = n-1; i >= 1; i--){
//            for(int j = 0; j < n; j++){
            // there is no any meaning of starting j from 0 to till because one thing we know for sure that i is always left from j
            // but when i = n-1, and j = 0 then it will be false because it's not on left. so we start from i+1.

            for(int j = i+1; j < n; j++){
                    int mini = (int)1e9;
                    for (int k = i; k <= j - 1; k++) {
                        int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                        mini = Math.min(mini, steps);
                    }


                  dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }



    public static void main(String[] args) {
        int[] arr = {10,30,5,60};

      //  System.out.println(viaRecursion(1, arr.length-1, arr));

        int[][] dp = new int[arr.length][arr.length];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(viaMemoization(1, arr.length-1, arr, dp));


     //   System.out.println(viaTabulation(arr));
    }

}
