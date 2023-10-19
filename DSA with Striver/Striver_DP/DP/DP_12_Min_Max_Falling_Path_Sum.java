package DP;

import java.util.Arrays;

public class DP_12_Min_Max_Falling_Path_Sum {
    // Variable starting and Ending points

    // we can not apply greedy approach here because values are not in uniformity manner.
    // so we know that to write recurrence we need to do three things
    // 1 -> take i, j as index.
    // 2 -> do all stuffs means explore all the paths like in this we have three paths up, left, right diagonally we can take move.
    // 3 -> find the maximum in all.

    public static int viaRecursion(int i, int j, int[][] grid){
        // time complexity is like exponential in nature. it's near about 3^n. and space complexity is O(n) that recursion height space.

        if(j < 0 || j >= grid[0].length){
            return (int)-1e9; // due to integer range overflow , here we need to find the max then we need to return minimum value.
        }
        if(i == 0){
            return grid[i][j];
        }
        int up = grid[i][j] + viaRecursion(i-1, j, grid);
        int leftDiagonal = grid[i][j] + viaRecursion(i-1, j-1, grid);
        int rightDiagonal = grid[i][j] + viaRecursion(i-1, j+1, grid);

        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

// There are multiple overlapping sub-problems that's why we can use Memoization(top-down) here. one cathe here is that we explore all starting point then
    // after we can see overlapping sub-problems.

    public static int viaMemoization(int i, int j, int[][] grid, int[][] dp){

        // TC -> O(n*m) and SC -> O(n*m) for dp and + O(n) recursion stack space.

        if(j < 0 || j >= grid[0].length){
            return (int)-1e9;
        }
        if(i == 0){
            return grid[0][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = grid[i][j] + viaRecursion(i-1, j, grid);
        int leftDiagonal = grid[i][j] + viaRecursion(i-1, j-1, grid);
        int rightDiagonal = grid[i][j] + viaRecursion(i-1, j+1, grid);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    // Hypothetically we know that in recursion calling it will take more time than the O(n*m).

    // that's why we need to write Tabulation(bottom-up) that will more efficient in space as well as in time in reality.

    // steps -> 1. Base case, 2. observe i, j and convert to loops, 3. reverse of recursion, because
    // recursion is going on from n-1 to 0 so here we need to go from 0 to n-1.
    // TC -> O(n*m) + O(m) and SC -> O(n*m).

    public static int viaTabulation(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        // base case
        for(int j = 0; j < m; j++){
            dp[0][j] = grid[0][j];
        }

        // Another things

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int u = -1000, ld = -1000, rd = -1000;
                u = grid[i][j] + dp[i-1][j];
                if(j > 0)ld = grid[i][j] + dp[i-1][j-1];
                if(j < m-1)rd = grid[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.max(u, Math.max(ld, rd));
            }
        }
        int maxi = (int)-1e9;
        for(int j = 0; j < m; j++){
            maxi = Math.max(maxi, dp[n-1][j]);
        }

        return maxi;
    }

    public static int viaSpaceOptimization(int[][] grid){
        // time complexity same but space complexity is only O(m).

        int[] prev = new int[grid[0].length];
        for(int j = 0; j < grid[0].length; j++)prev[j] = grid[0][j];

        for(int i = 1; i < grid.length; i++){
            int[] curr = new int[grid[0].length];
            for(int j = 0; j < grid[0].length; j++){
                int u = -1000, ld = -1000, rd = -1000;
                u = grid[i][j] + prev[j];
                if(j > 0)ld = grid[i][j] + prev[j-1];
                if(j < grid[0].length-1)rd = grid[i][j] + prev[j+1];

                curr[j] = Math.max(u, Math.max(ld, rd));
            }
            prev = curr;
        }

        int maxi = (int)-1e9;
        for(int j = 0; j < grid[0].length; j++){
            maxi = Math.max(maxi, prev[j]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[][] grid = {{4,56,7,8},{3,1,6,5},{6,9,8,3},{12,34,54,23}};

        // basically here we have not fix starting point that's why we need to explore every points
//        int ans = (int)-1e9;
//        int[][] dp = new int[grid.length][grid[0].length];
//        for(int[] a : dp) Arrays.fill(a, -1);
//
//        for(int i = 0; i < grid[0].length; i++){
//          //  ans = Math.max(ans, viaRecursion(3, i, grid));
//
//            ans = Math.max(ans, viaMemoization(3, i, grid, dp));
//        }
//        System.out.println(ans);

      //  System.out.println(viaTabulation(grid));

        System.out.println(viaSpaceOptimization(grid));
    }
}
