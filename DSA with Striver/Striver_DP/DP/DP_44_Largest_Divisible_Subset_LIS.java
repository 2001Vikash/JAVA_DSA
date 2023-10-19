package DP;

import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DP_44_Largest_Divisible_Subset_LIS {


    // Here we are trying to find the Largest divisible subsets.
    // Subset means if arr = 1,16,7,8,4 -> there will be no any requirement of order like subsequences
    // it can be 1,16,8 is a subset, 1,8,16 is also a subset and so on.
    // here we have to find pairs if they are following a[i] % a[j] or a[j] % a[i].
    // and we have to find the largest one according to main arr answer would be 1,16,8,4. and we have to check divisibility for every element.

    // Given => Array have distinct numbers for sure and you can print any answers.

    // First of all we can sort it because order not matters according to question and then after we will try to relate it with LIS.
    // So after sorting array will be 1,4,7,8,16 if we take 1, 4, 8 , means if 4 divisible by 1 and 8 is divisible by 4 it means
    // 8 will be divisible by 1 for sure that is the main thing to sort the array.
    // In actuality after sorting we will be trying to find the largest divisible subsequence.
    // We just need to check a[i] % a[j] == 0 not reverse of this because we know that array os sorted. second advantage of sorting.


    // So we will use LIS printing code with two things sort the array and change the if condition.

    public static void solutionViaLIS(int[] arr){
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int len = 1;
        int lastInd = 0;
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int pre = 0; pre < i; pre++){
                if(arr[i] % arr[pre] == 0 && 1 + dp[pre] > dp[i]){
                    dp[i] = 1 + dp[pre];
                    hash[i] = pre;
                }
            }
            if(dp[i] > len){
                len = dp[i];
                lastInd = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[lastInd]);
        while(hash[lastInd] != lastInd){
            lastInd = hash[lastInd];
            list.add(arr[lastInd]);
        }

        Collections.reverse(list);
        System.out.println(list);
    }


    public static void main(String[] args) {
        int[] arr = {1,16,7,8,4};

        solutionViaLIS(arr);
    }
}
