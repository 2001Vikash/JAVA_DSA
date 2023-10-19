package DP;

import java.util.Arrays;

public class DP_53_Palindrome_Partitioning_II_Front_Partition {

    // For given matrix we have to make a partition here. for ex. if we have n length string then we can make n-1 partitions definitely.
    // and every individual substring will be a palindrome. Means we definitely know that a string can be partitioned like that in which every substring will be palindrome.
    // because if we have n length string and ,we will do n-1 partition then it will follow it because every single element is like as palindrome.

    // But over here they are asking like find the minimum partitions that you will require in order to make the string as palindrome.
    // for ex. aabb so here we can do 3 partition to make it every substring as palindrome like that a, a, b, b.
    // But in this question we have to find min so can we do it like this aa, bb which will take only one partition so that is answer.
    // bababcbadcede for this ex. we have to make 4 partition to be as palindrome for every partition, bab, abcba, d ,c, ede. that is minimum.

    // we can use here to solve like this problem front partition.
    // for ex. aabb so we will say a, aab , is a palindrome 1 + check for the next, or aa, bb so yes like that we can do it.


    public static int viaRecursion(int i, String str){

        // TC -> Exponential in nature, SC -> O(n).

        if(i == str.length()){
            return 0;
        }

       // String temp = "";
        // We do not have required to store it because we know that temp will be in i to ind.
        int cost = (int)1e8;

        for(int ind = i; ind < str.length(); ind++){
          //  temp += str.charAt(ind);

            if(isPalindrome(i, ind, str)){
                int cst = 1 + viaRecursion(ind+1, str);
                cost = Math.min(cost, cst);
            }
        }
        return cost;
    }


    public static int viaMemoization(int i, String str, int[] dp){
        if(i == str.length()){
            return -1; // if 0 then we have to reduce -1 in last, for more clarification please do a dry run.
        }
        if(dp[i] != -1)return dp[i];

        int minCost = (int)1e8;
        for(int ind = i; ind < str.length(); ind++){

            if(isPalindrome(i, ind, str)){
                int cost = 1 + viaMemoization(ind+1, str, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    private static boolean isPalindrome(int i, int j, String s) {
        if(s.length() == 0)return false;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static int viaTabulation(String str){
        // TC -> O(n*n)

        int n = str.length();
        int[] dp = new int[n+1];// if we will make size n then no need to write base case return -1 from the end.

        // base case
        dp[n] = -1;

        for(int i = n-1; i >= 0; i--){
            int minCost = (int)1e8;
            for(int ind = i; ind < str.length(); ind++){

                if(isPalindrome(i, ind, str)){
                    int cost = 1 + dp[ind+1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0];
    }


    // We can not use prev and curr here because here we are not using dp[i+1] we use dp[ind+1]

    public static void main(String[] args) {
        String str = "bababcbadcede";

       // System.out.println(viaRecursion(0, str));
        // why -1 because A|B|C| for C it will be palindrome and reach base case that will return 0.
        // we will find 1 more is there any partition right of the end -> No. so reduce it or return -1 in the base case.


//        int[] dp = new int[str.length()];
//        Arrays.fill(dp ,-1);
//        System.out.println(viaMemoization(0, str, dp));


      //  System.out.println(viaTabulation(str));


    }
}
