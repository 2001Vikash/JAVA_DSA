package DP;

import java.util.Arrays;

public class DP_51_Burst_Balloons_Partition_Dp {
// at the time of revision please refer video again.

    // you have given n balloons where n is the length of the array. you have to burst them.
    // so at the time of bursting you have find some coins.
    // for ex. 3,1,5,8 and if you burst the 5 then you will find 1 * 5 * 8 = 40 coins.
    // you can burst in any sequence.
    // so maximize the no of coins. and for the boundary condition take left or right as 1.
    // for ex. we have {b1, b2, b3, b4, b5, b6} given array.
    // so let us burst b4 => b3 * b4 * b5 + {b1, b2, b3} + {b5, b6} so can we solve it like that => NO
    // Why ? => what will happen after bursting of b4 array will be {b1, b2, b3, b5, b6} like this
    // and now if we wanted to burst b3 then coins will be = b2 * b3 * b5 but, we can do it because b5, b6 is another part/sub-problems of array
    // means we can do it like this because b3 and b5 are dependent, at the time b3 or b5 bursting both will be required.
    // we can not divide and solve independently because they are dependent. because will apply these things on independent sub-problems.
    // instead of now finding like which one will be deleted first we will think like who is last guy after bursting of every guy.
    // means do work in reverse fashion. just imagine that if 8 is the last guy means cost will be 1 * 8 * 1 = 8 and so on.
    // if we will move in opposite direction the sub-problem will be independent.
    // for ex. we have array {b1, b2, b3, b4, b5, b6} then we are assuming that b4 is last guy who will be going to burst
    // it means that in previous state b4 was present that is the advantage of doing this in reverse manner.
    // because if I am bursting b4 in last then in upper state it will be presented and both sub-problems will be independent of each other because
    // they are dependent on b4, for left sub-problems b4 is right guy and for right sub-problems b4 will be left guy.
    // means if b4 is last guy will be deleted then it means in second last step b1,b4 or b2,b4 or b3,b4 or b4,b5 or b4,b6 will be
    // then it does not matter who is second last guy they will only dependent on that guy who will delete in next step.


    public static int viaRecursion(int i, int j, int[] arr){
        if(i > j) return 0;
     // so let us consider that we have last guy is ind.
        int maxi = -(int)1e9;
        for(int ind = i; ind <= j; ind++){

            int cost = arr[i-1] * arr[ind] * arr[j+1] + viaRecursion(i, ind-1, arr) + viaRecursion(ind + 1, j, arr);
            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }


    // Let us memoize it

    public static int viaMemoization(int i, int j, int[] arr, int[][] dp){
        // TC -> O(n^3) and Space C -> O(n) + (n^2).

        if(i > j)return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int maxi = -(int)1e9;
        for(int ind = i; ind <= j; ind++){

            int cost = arr[i-1] * arr[ind] * arr[j+1] + viaMemoization(i, ind-1, arr, dp) + viaMemoization(ind + 1, j, arr, dp);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }


    public static int viaTabulation(int[] arr){
        int m = arr.length;
        int[][] dp = new int[m][m];

        // there is no need to write base case because that is 0.

        int n = m - 2;

        for(int i = n; i >= 1; i--){
            for(int j = i; j <= n; j++){
                int maxi = -(int)1e9;
                for(int ind = i; ind <= j; ind++){

                    int cost = arr[i-1] * arr[ind] * arr[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi, cost);
                }

                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        int n = arr.length;
        int[] newArr = new int[n+2];
        newArr[0] = 1;
        newArr[n+1] = 1;
        for(int i = 1; i < newArr.length - 1; i++){
            newArr[i] = arr[i-1];
        }


      //  System.out.println(viaRecursion(1, n, newArr));

//        int[][] dp = new int[n+2][n+2];
//        for(int[] a : dp) Arrays.fill(a, -1);
//        System.out.println(viaMemoization(1, n, newArr, dp));

        System.out.println(viaTabulation(newArr));
    }
}
