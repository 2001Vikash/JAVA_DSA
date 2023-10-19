package DP;

public class DP_35_Best_TIme_to_Buy_and_Sell_Stock {

    // From here we are going to start DP on Stocks.
    // here we have to complete till space optimization because DP on stocks they will expect to us for space optimization.

    // In given array n numbers of days. You have to decide the day to Buy a stock and as well to sell.
    // you have to maximize the profit.
    // allowed to buy and sell only once.

    // if you are selling on ith day then you buy on the minimum price from 1st to i-1th day.



    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

        int profit = 0;
        int mini = arr[0];

        for(int i = 1; i < arr.length; i++){
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }

        // Why does it come in DP because here we are calculating min throughout the array, that's why
        //but definitely a constructive algorithm

        System.out.println(profit);
    }
}
