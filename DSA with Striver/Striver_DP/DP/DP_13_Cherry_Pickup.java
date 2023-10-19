package DP;

import java.util.Arrays;

public class DP_13_Cherry_Pickup {
    // In this question 3-D dp involved so ya it's slightly different.
    // the problem is ninja and his friends from codeStudio.
// in this question we have fixed starting point and variable ending point, because when they will go from the same cell then it's considered as once
    // try to find out all paths by Alice and all paths by Bob together

    // Rules for recurrence -> 1. Express everything in terms of (i1,j1) for Alice and (i2,j2) for Bob, 2. Explore all paths, 3. give the max sum.

    // if we have two base cases, first one is for destination and second one is for out of bound then always write second one first.

    // TC -> O(3^n*3^n)., SC -> O(n) auxiliary stack space

    public static int viaRecursion(int i, int j1, int j2, int[][] grid){
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length){
            return (int)-1e8;
        }
        if(i == grid.length-1){
            if(j1 == j2)return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        // explore all the paths for Alice and Bob simultaneously.
        // for every movement of Alice, Bob has 3 ways to go that's why we are doing this.
        // this is a nice way to write it otherwise we can write 9 different paths differently.
        int maxi = (int)-1e8;
        for(int dj1 = -1; dj1 <= +1; dj1++){
            for(int dj2 = -1; dj2 <= +1; dj2++){
                int value;
                if(j1 == j2)value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += viaRecursion(i+1, j1 + dj1, j2 + dj2, grid);
                maxi = Math.max(maxi, value);
            }
        }
        return maxi;
    }

    // Memoization -> TC-> O(n*m*m)*9(no. of different states will always time complexity), sc -> O(n*m*m)+O(n).

    public static int viaMemoization(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length){
            return (int)-1e8;
        }
        if(i == grid.length-1){
            if(j1 == j2)return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int maxi = (int)-1e8;
        for(int dj1 = -1; dj1 <= +1; dj1++){
            for(int dj2 = -1; dj2 <= +1; dj2++){
                int value;
                if(j1 == j2)value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += viaMemoization(i+1, j1 + dj1, j2 + dj2, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    // Inorder to convert it into Tabulation we need to follow some steps.
    // 1. Base case handling, 2. do all stuffs using loops like there are three things like i, j1, j2 means we have required three nested loops.

    public static int viaTabulation(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        // Base case
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2)dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // for next things

        for(int i = n-2; i >= 0; i--){
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int maxi = (int)-1e8;
                    for(int dj1 = -1; dj1 <= +1; dj1++){
                        for(int dj2 = -1; dj2 <= +1; dj2++){
                            int value;
                            if(j1 == j2)value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if((j1+dj1 >= 0 && j1+dj1 < m) && (j2+dj2 >= 0 && j2+dj2 < m)){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            }else {
                                value += (int)-1e8;
                            }

                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }

    // So whenever we were doing space optimization then we did like that 1-D dp -> 2 variables, 2-D dp -> 1-D array then it means 3-D dp-> 2-D array.

    public static int viaSpaceOptimization(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] front = new int[m][m];
        // Base case
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2)front[j1][j2] = grid[n-1][j1];
                else front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        // for next things

        for(int i = n-2; i >= 0; i--){
            int[][] curr = new int[m][m];
            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int maxi = (int)-1e8;
                    for(int dj1 = -1; dj1 <= +1; dj1++){
                        for(int dj2 = -1; dj2 <= +1; dj2++){
                            int value;
                            if(j1 == j2)value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if((j1+dj1 >= 0 && j1+dj1 < m) && (j2+dj2 >= 0 && j2+dj2 < m)){
                                value += front[j1+dj1][j2+dj2];
                            }else {
                                value += (int)-1e8;
                            }

                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            front = curr;
        }

        return front[0][m-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};

       // System.out.println(viaRecursion(0,0,grid[0].length-1, grid));
//        int r = grid.length;
//        int c = grid[0].length;
//        int[][][] dp = new int[r][c][c];
//        for(int[][] arr : dp){
//            for(int[] a : arr) Arrays.fill(a, -1);
//        }
//        System.out.println(viaMemoization(0,0,c-1, grid, dp));

      //  System.out.println(viaTabulation(grid));

        System.out.println(viaSpaceOptimization(grid));
    }
}
