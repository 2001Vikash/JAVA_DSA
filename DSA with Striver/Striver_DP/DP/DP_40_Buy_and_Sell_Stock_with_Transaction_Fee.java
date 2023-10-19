package DP;

public class DP_40_Buy_and_Sell_Stock_with_Transaction_Fee {

    // Best time to buy and sell stock with transaction fee.

    // here we can buy and sell unlimited times but one more extra thing will be working here like
    // at every completion of B S transaction fee will be reduced from you profit. for ex. if you buy and sell two stocks
    // and your profit is 7, 5 => then you have to give transaction fee like that 7-2 = 5, 5-2 = 3
    // thereby you profit will be 5 + 3 = 8, if transaction fee = 2;


    public static int viaRecursion(int day, int buy, int[] price, int tranFee){
        if(day == price.length){
            return 0;
        }

        if(buy == 1){
            // we can reduce tranFee over here as well there will no any problem.
            return Math.max(-price[day] + viaRecursion(day+1,0, price, tranFee), viaRecursion(day+1, 1, price, tranFee));
        }
        return Math.max(price[day] - tranFee + viaRecursion(day+1,1, price, tranFee), viaRecursion(day+1, 0, price, tranFee));

    }

// here we know that how to memoize and to do tabulation , space optimization, more space optimization.

    // here we will see solve this question via 4 variables, rather we have done it before but we will do for  better understanding

    public static int viaFourVariables(int[] price, int tranFee){
        int n = price.length;

        int aheadBuy, aheadNotBuy, currBuy, currNotBuy;

        aheadBuy = aheadNotBuy = 0; // base case

        for(int day = n-1; day >= 0; day--){

            currBuy = Math.max(-price[day] + aheadNotBuy, aheadBuy);
            currNotBuy = Math.max(price[day] - tranFee + aheadBuy, aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }

//     long maximumProfit(vector<long long>&prices, int n, int fee) {
//         long buy=-1e9,sell=0;
//        for(long long p:prices) {
//            int tmp = buy;
//            buy = max(buy, sell-p);
//            sell = max(sell, tmp+p-fee);
//        }
//        return sell;
//    } // this is also a good solution.


    public static void main(String[] args) {
        int[] price = {1,3,2,8,4,9};
        int tranFee = 2;

        System.out.println(viaRecursion(0, 1, price, tranFee));

        System.out.println(viaFourVariables(price, tranFee));
    }
}
