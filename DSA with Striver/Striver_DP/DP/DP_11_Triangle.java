package DP;

import java.util.Arrays;

public class DP_11_Triangle {

    // Fixed Starting Point and Variable Ending Point.

    // In this question starting point is fixed and ending can vary because we need to reach in the last row.

    // so here in this question instead of starting recursion from the end we start from the starting index
    // because ending point is not fixed and first point is fixed that's why we prefer start from the starting.


    public static int viaRecursion(int i, int j, int[][] grid, int row){
        // Time complexity -> 2 to the power of 1 + 2 + 3 + .... + n.
        // Space complexity -> O(n) for the stack space because we are only going to 0 to last row.

        if(i == row - 1){
            return grid[i][j];
        }
        int down = grid[i][j] + viaRecursion(i+1, j, grid, row);
        int diagonal = grid[i][j] + viaRecursion(i+1, j+1, grid, row);

        return Math.min(down, diagonal);
    }

    // Now we can apply Memoization here because there are many OverLapping Sub-problems here.

    public static int viaMemoization(int i, int j, int[][] grid, int row, int[][] dp){

        // Time complexity -> O(n*n) not exactly, Space comp. -> Recursion stack space and for the dp as well n^2.

        // Recursion is always top-down approach
        if(i == row-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = grid[i][j] + viaRecursion(i+1, j, grid, row);
        int diagonal = grid[i][j] + viaRecursion(i+1, j+1, grid, row);

        return dp[i][j] = Math.min(down, diagonal);
    }

    // In order to remove stack space we need to apply Tabulation

    public static int viaTabulation(int[][] grid, int row){
        // we know that tabulation is exactly reverse of memoization that is thumb rule.
// TC -> O(n*no.of col)., sc -> O(n*n)
        int[][] dp = new int[row][row];
        for(int i = row-1; i >= 0; i--){
            for(int j = i; j >= 0; j--){// we need to follow the flow of first loop in second loop as well
                if(i == row-1){
                    dp[i][j] = grid[i][j];
                }else{
                    int down = grid[i][j] + dp[i+1][j];
                    int diagonal = grid[i][j] + dp[i+1][j+1];
                    dp[i][j] = Math.min(down, diagonal);
                }
            }
        }

        return dp[0][0];
    }

    public static int viaSpaceOptimization(int[][] grid){
        int[] front = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            front[i] = grid[grid.length - 1][i];
        }
        for(int i = grid.length - 2; i >= 0; i--){
            int[] curr = new int[grid.length];
            for(int j = i; j >= 0; j--){
                int down = grid[i][j] + front[j];
                int diagonal = grid[i][j] + front[j+1];
                curr[j] = Math.min(down, diagonal);
            }
            front = curr;
        }
        return front[0];
    }

    public static void main(String[] args) {
        int[][] grid = {{1},{2,3},{3,6,7},{8,9,6,10}};
       // System.out.println(viaRecursion(0,0,grid,4));

//        int[][] dp = new int[4][4];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(0,0,grid,4,dp));

     //   System.out.println(viaTabulation(grid, 4));

        System.out.println(viaSpaceOptimization(grid));
    }
}
