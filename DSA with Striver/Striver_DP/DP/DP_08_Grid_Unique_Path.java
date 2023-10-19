package DP;

import java.util.Arrays;

public class DP_08_Grid_Unique_Path {

    // We will have 6 questions on grids so make sure that to explore question please go for codeStudio.

    // Question -> Total Unique Path ......

      public static int viaRecursion(int i, int j){

          // Time Complexity -> O(2^m*n)
          // Space complexity -> O(path length) that is recursion stack space.
          // path length -> (m-1) + (n-1) generally.

          if(i == 0 && j == 0){
              return 1;
          }
          if(i < 0 || j < 0){
              return 0;
          }
          int left = viaRecursion(i-1, j);
          int right = viaRecursion(i, j-1);

          return left + right;
      }

      // After recursion can we apply here memoization if there are overlapping sub problems.
    // yes there are overlapping sub problems are present.

    public static int viaMemoization(int i, int j, int dp[][]){

          // Time complexity -> O(m*n).
        // Space complexity -> O((n-1) + (m-1)) + O(m*n) for the dp array.

          if(i == 0 && j == 0){
              return 1;
          }
          if(i < 0 || j < 0){
              return 0;
          }
          if(dp[i][j] != -1){
              return dp[i][j];
          }
          int left = viaMemoization(i-1, j, dp);
          int right = viaMemoization(i, j-1, dp);

          return dp[i][j] = left + right;
    }

    public static int viaTabulation(int m, int n){
          // Memoization to Tabulation
        // 1 -> Declare the base case
        // 2 -> Express all states in for loop.
        // 3 -> copy the recurrence and write.

        // Time complexity same as memoization but the Space complexity is only for DP array not for recursion stack.
          int[][] dp = new int[m][n];
          dp[0][0] = 1;
          for(int i = 0; i < m; i++){
              for(int j = 0; j < n; j++){
                  if(i == 0 && j == 0){
                      continue;
                  }
                  else{
                      int up = 0, lef = 0;

                   if(i > 0)
                    up = dp[i-1][j];

                    if(j > 0)
                     lef = dp[i][j-1];

                      dp[i][j] = up + lef;
                  }
              }
          }
          return dp[m-1][n-1];
    }

    public static int viaSpaceOptimization(int m, int n){
          // if there is a previous row and previous column , we can space optimize it.
        // there is no need to do this step in the interview.

        int[] prev = new int[n];
        for(int i = 0; i < m; i++){
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if (i == 0 && j == 0) curr[j] = 1;
                else {
                    int up = 0, left = 0;

                    if (i > 0) up = prev[j];

                    if (j > 0) left = curr[j - 1];

                    curr[j] = up + left;
                }
            }

            prev = curr;
        }

        return prev[n-1];
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
     //   System.out.println(viaRecursion(m-1, n-1));

//        int[][] dp = new int[m][n];
//        for(int[] a : dp) Arrays.fill(a, -1);

       // System.out.println(viaMemoization(m-1, n-1, dp));

       // System.out.println(viaTabulation(m, n));

        System.out.println( viaSpaceOptimization(m, n));
    }

}
