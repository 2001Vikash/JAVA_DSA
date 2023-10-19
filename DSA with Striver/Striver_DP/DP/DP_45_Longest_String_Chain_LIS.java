package DP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class DP_45_Longest_String_Chain_LIS {

    // To solve this problem prerequisite, is LIS.
    // What is means of String chain so if we take first word as a then after we have to insert character in at anyplace,
    // first word can be anything from the given array, but after that whatever will come that must follow the insertion rule
    //for ex. a, ba, bda or, b, ba, bca that are the string chain,
    // We can understand it in the other words like every previous guy is the one deletion of next guys.
    // here we have to find the longest in terms of length.

    // We can relate this question with LIS but one problem is here that is string in this problem and Increasing in LIS so.
    // so instead of increasing elements here the difference between one character.
    // Instead of checking increasing order we will check the difference of one character that's means we can solve it via LIS.

    // here chain behaviour is like subset not subsequence that's why we have to sort it, for ex, xbc,pcxbcf, xb, cxbc, pcxbc,
    // according to our solution it will give 3 but in really answer is 4 that's why we will sort it first then there will no problem
    //  because we know that first guy can be anything from the array that is the main thing which we need to take into consideration.

    public static int viaLIS(String[] word){
        int n = word.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(isPossible(word[i], word[prev]) && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }
    private static boolean isPossible(String s1, String s2){
        if(s1.length() != s2.length() + 1)return false;

        int f = 0; // for s1 which has more length
        int s = 0;// for s2

        while(f < s1.length()){
            if(s < s2.length() && s1.charAt(f) == s2.charAt(s)){
                f++;
                s++;
            }else{
                f++;
            }
        }
        return (f == s1.length() && s == s2.length());
    }


    public static void main(String[] args) {
        String[] word = {"a", "b", "ba", "bca", "bda", "bdca"};

        //String[] word = {"xbc","pcxbcf", "xb", "cxbc", "pcxbc"};

       // Arrays.sort(word);// but we have to sort it via length of strings not in alphabetical order.
        // for this we have to make comparable function.

        Comparator<String> byLength = new Comparator<String>(){
            @Override public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        Arrays.sort(word, byLength);
        System.out.println(viaLIS(word));
    }
}
