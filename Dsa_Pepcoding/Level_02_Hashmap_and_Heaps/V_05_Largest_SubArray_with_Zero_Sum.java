package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_05_Largest_SubArray_with_Zero_Sum {

    // In this problem you are given am array of integers, And you have to find the length of the largest subArray with sum 0.

    // In this question we will use basic premise as -> if till index j, if sum is x, and after some next index j+k again sum is x, means between j+k, and j+1, sum is 0.

    public static void largestSubArrayWithZeroSum(int[] arr){


        // This is from striver solution in which sum can be anything, but this problem is only for sum = 0.
/*
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int sumK = 0;
        int sum = 0;
        int maxLen = 0;
        int start = -1;
        preSumMap.put(sum, -1);
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == 0){
                maxLen = Math.max(maxLen, i+1);
            }
            int remainingSum = sum - sumK;
            if(preSumMap.containsKey(remainingSum)){
               int len = i - preSumMap.get(remainingSum);
                if(maxLen < len){
                    maxLen = len;
                    start = preSumMap.get(remainingSum) + 1;
                }
            }

            if(!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
        }

        System.out.print("SubArrays are : " + "{");
        for(int i = 0; i < maxLen; i++){
            System.out.print(arr[start + i] + " ");
        }
        System.out.print("}"); */


        // from pepcoding

        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = -1;
        int sum = 0;
        map.put(sum, start);

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)) {
                int len = i - map.get(sum);
                if(maxLen < len){
                    maxLen = len;
                    start = map.get(sum) + 1;
                }
            }else{
                map.put(sum, i);
            }
        }
        System.out.print("SubArray is : " + "{");
        for(int i = 0; i < maxLen; i++){
            System.out.print(arr[start + i] + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};

        largestSubArrayWithZeroSum(arr);
    }
}
