package DP;

public class DP_07_NinjaS_Training {
    // Please prefer the question from the websites.
    // this also belongs from the question 5 but here we can't skip anything we need to do something different
    // that is the main difference between those questions.

    // firstly we will try to solve this problem using greedy like choose things that have max value for particular.
    // then whenever Greedy fails try all possible ways and pick the maximum things that will be indeed answer.
    // whenever we think about try all possible ways what first thing will come in our mind -> Yes Recursion.
    // Recursion -> ind, do stuffs, find max.
    // in this question we take day as index.
    // According to the condition along with index we can add a parameter that will be required.

    // So when we draw the recursion tree then we see the Overlapping sub problems that means we can apply DP over here.


    public static int viaRecursion(int ind, int[][] mat, int last){
        if(ind == 0){
            int max = 0;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    max = Math.max(max, mat[ind][i]);
                }
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            int check = 0;
            if(i != last) {
                check = mat[ind][i] + viaRecursion(ind - 1, mat, i);
            }
            max = Math.max(max, check);
        }

        return max;
    }

    public static int viaMemoization(int day, int last, int[][] points, int[][] dp){

        // TC -> O(n*4)*3, SC -> O(n) + O(n*4).

        if(day == 0){
            int max = 0;
            for(int tasks = 0; tasks < 3; tasks++){
                if(tasks != last) {
                    max = Math.max(max, points[day][tasks]);
                }
            }
            return max;
        }
        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int max = Integer.MIN_VALUE;
        for(int tasks = 0; tasks < 3; tasks++){
            if(tasks != last){
                int point = points[day][tasks] + viaMemoization(day-1, tasks, points, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }

    public static int viaTabulation(int[][] mat){

        // TC -> O(n*4*3), SC -> O(n*4) and there is no any recursion stack space.

        int[][] dp = new int[mat.length][4];

        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for(int day = 1; day < mat.length; day++){
            for(int last = 0; last < 4; last++){
                int max = 0;
                for(int task = 0; task < 3; task++){
                    if(last != task){
                        int points = mat[day][task] + dp[day-1][task];
                        max = Math.max(max, points);
                    }
                }
                dp[day][last] = max;
            }
        }
        return dp[mat.length-1][3];
    }

    public static int viaSpaceOptimization(int[][] mat){

        // Here time complexity same as previous but, we have optimized space from O(n*4) to O(4) only and that is very nice optimization.

        int[] prev = new int[4];
        prev[0] = Math.max(mat[0][1], mat[0][2]);
        prev[1] = Math.max(mat[0][0], mat[0][2]);
        prev[2] = Math.max(mat[0][0], mat[0][1]);
        prev[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));
        for(int day = 1; day < mat.length; day++){
            int[] curr = new int[4];
            for(int last = 0; last < 4; last++){
                curr[last] = 0;
                for(int task = 0; task < 3; task++){
                    if(last != task){
                        curr[last] = Math.max(curr[last], mat[day][task] + prev[task]);
                    }
                }
            }
            prev = curr;
        }

        return prev[3];
    }

    public static void main(String[] args) {
        int[][] mat = {{2,1,3},
                       {3,4,6},
                       {10,1,6},
                       {8,3,7}};

       // System.out.println(viaRecursion(mat.length - 1, mat, 3));// we are passing last as 3 because it means none of them taken or doing any activity

//        int[][] dp = new int[mat.length][4];// 3 task and one is for sign that none of them are selected.
//        for(int[] a : dp) Arrays.fill(a, -1);
//
//        System.out.println(viaMemoization(mat.length-1, 3, mat, dp));

      //  System.out.println(viaTabulation(mat));

        System.out.println(viaSpaceOptimization(mat));

    }
}

