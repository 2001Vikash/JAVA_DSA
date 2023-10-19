package DP;

import java.util.Arrays;

public class DP_09_Unique_Paths_02 {
    // Question -> Maze Obstacles -> Please refer from codeStudio.

    public static int viaRecursion(int i, int j, int[][] grid){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0 || grid[i][j] == -1){
            return 0;
        }

        int up = viaRecursion(i-1, j, grid);
        int left = viaRecursion(i, j-1, grid);

        return up + left;
    }

    public static int viaMemoization(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0 || grid[i][j] == -1){
            return 0;
        }
        if(dp[i][j] != 1){
            return dp[i][j];
        }
        int up = viaMemoization(i-1, j, grid, dp);
        int left = viaMemoization(i, j-1, grid, dp);
        return dp[i][j] = up + left;
    }

    public static int viaTabulation(int[][] grid){
        int[][] dp = new int[grid.length][grid.length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == -1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int up = 0, left = 0;

                    if(i > 0) up = dp[i-1][j];
                   if(j > 0)  left = dp[i][j-1];

                   dp[i][j] = up + left;
                }
            }
        }
        return dp[grid.length-1][grid.length-1];
    }

    public static int viaSpaceOptimization(int[][] grid){
        int[] prev = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            int[] curr = new int[grid.length];
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] == -1){
                    curr[j] = 0;
                }else if(i == 0 && j == 0){
                    curr[j] = 1;
                }else{
                    int up = 0, left = 0;
                    if(i > 0)up = prev[j];
                    if(j > 0)left = curr[j-1];

                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[grid.length-1];
    }

    public static void main(String[] args) {
        int[][] grid = { {0,0,0},
                         {0,-1,0},
                         {0,0,0} };

       // System.out.println(viaRecursion(2,2,grid));

//        int[][] dp = new int[grid.length][grid.length];
//        for(int[] a : dp) Arrays.fill(a, 1);
//        System.out.println(viaMemoization(2,2,grid, dp));


    //    System.out.println(viaTabulation(grid));

        System.out.println(viaSpaceOptimization(grid));
    }
}
