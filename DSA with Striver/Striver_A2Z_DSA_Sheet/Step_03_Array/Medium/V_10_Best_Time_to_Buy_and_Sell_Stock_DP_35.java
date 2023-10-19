package Step_03_Array.Medium;

public class V_10_Best_Time_to_Buy_and_Sell_Stock_DP_35 {

    // we have done it previously in DP series, for the revision purpose please go there.

    public static void stockSellAndBuy(){
        int[] arr = {7,1,5,3,6,4};

        // Intuition is -> If you are selling on ith day, you buy on the minimum price from 1st to (i-1)th day.

        // This is constructive algorithm, but we are taking it as DP, because here we are remembering previous min.

        int mini = arr[0], profit = 0;
        for(int i = 1; i < arr.length; i++){
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }

        System.out.println("Answer = " + profit);
    }

    public static void main(String[] args) {
        stockSellAndBuy();
    }
}
