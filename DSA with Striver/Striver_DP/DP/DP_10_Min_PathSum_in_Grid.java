package DP;

import java.util.Arrays;

public class DP_10_Min_PathSum_in_Grid {

    // Why not follow greedy here because values in the grid is not uniformly.

    // here we need to find all paths means we need to apply recursive solution after that we can try for DP as well if there will be same sub-problems



    public static int viaRecursion(int i, int j, int[][] grid){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE - 10000;// but if we return this value and add something it will go integer out of range that can be -ve.
            // we need to return big value because we are trying to find out the min value.
            // because this is not our ans, means when we return big values then it is neven going to assume/take.
        }

        int up = grid[i][j] + viaRecursion(i-1, j, grid);
        int left = grid[i][j] + viaRecursion(i, j-1, grid);

        return Math.min(up, left);
    }

    public static int viaMemoization(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        if(i < 0 || j < 0){
            return 100000;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = grid[i][j] + viaMemoization(i-1, j , grid, dp);
        int left = grid[i][j] + viaMemoization(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public static int viaTabulation(int[][] grid){
        int[][] dp = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 0 && j == 0)dp[i][j] = grid[0][0];
                else{
//                    int up = 12345, left = 12345;
//                    if(i > 0)up = grid[i][j] + dp[i-1][j];
//                    if(j > 0)left = grid[i][j] + dp[i][j-1];

                    // or
                    int left = grid[i][j], up = grid[i][j];
                    if(i > 0)up += dp[i-1][j];
                    else up += 12345;// means if i is out of bound then return big value.

                    if(j > 0)left += dp[i][j-1];
                    else left += 12345;

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[2][2];
    }


    public  static int viaSpaceOptimization(int[][] grid){
        int[] prev = new int[3];
        for(int i = 0; i < 3; i++){
            int[] curr = new int[3];
            for(int j = 0; j < 3; j++){
                if(i == 0 && j == 0)curr[j] = grid[0][0];
                else{
                    int left = 12345, up = 12345;
                    if(i > 0)up = grid[i][j] + prev[j];
                    if(j > 0)left = grid[i][j] + curr[j-1];

                    curr[j] = Math.min(left, up);
                }
            }
            prev = curr;
        }

        return prev[2];
    }

    public static void main(String[] args) {
        int[][] grid = {{10,8,2}, {10,5,100}, {1,1,2}};

       // System.out.println(viaRecursion(2,2,grid));

//        int[][] dp = new int[3][3];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(2,2,grid,dp));

     //   System.out.println(viaTabulation(grid));

        System.out.println(viaSpaceOptimization(grid));

    }
}
