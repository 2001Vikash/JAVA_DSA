package DP;

public class DP_56_Count_Square_SubMatrices_with_All_1_s {


    // we have given n*m matrix filled with 0's and 1's. and we have to figure out square sub-matrices there.
    // square sub-matrices means length of height = length of breadth.

    // if there will be n 1's in given matrices then for size 1 there will be n square matrices, and like that we have to find for the 2*2, 3*3 and so on.

    // Basically we can think brute force solution for this question but that code will be very complex.

    // So we will use here DP for this problem but not so much intuitive because there will no any case of recursion.


    public static int solution(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++)dp[i][0] = arr[i][0];
        for(int j = 0; j < m; j++)dp[0][j] = arr[0][j];

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(arr[i][j] == 0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        int sum = 0;

        for(int[] a : dp){
            for(int e : a) sum += e;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},
                          {1,1,1,1},
                          {0,1,1,1}};

        System.out.println(solution(matrix));
    }
}
