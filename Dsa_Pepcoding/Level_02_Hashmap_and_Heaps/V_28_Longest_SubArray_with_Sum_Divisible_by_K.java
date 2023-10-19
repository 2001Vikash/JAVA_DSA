package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_28_Longest_SubArray_with_Sum_Divisible_by_K {

    // In this problem you are given an array of integers and a number k, you have to find length of the longest subArray whose sum is divisible by k.

    // for the solution we will be using subArray Sum equal to k but in the term of division,
    // let us say that we have current sum s2 and if we divide it by k then it gives remainder x, now if we are having a previous sum which gives us
    // remainder as x, means in-between we are having a subArray which gives remainder 0, for ex,
    // s2 = kn + x, s1 = km + x, so, subArray -> s2-s1 = k(n-m), which is divisible by k.
    // As well, we have to focus on +ve and -ve numbers, In map we will store remainder and corresponding indexes. and we will not update index if they are repeating because we are searching max length subArray.

    // for the +ve remainder there will be no problem, but when remainder will be -ve then we have to add +k into that remainder, otherwise we will miss the answer.
    // See, if we have k = 7, and remainder = 5, then we can write like as num = 7n-5 => so, 7n-5+7-7, 7(n-1) + 2 is also right but, now it is having remainder as 2
    // it means -5 , and -5 + 7 = 2, both are similar remainder there is no any difference in-between both. means we have to put remainder in range 0 to k-1,
    // but, in reality remainder comes -(k-1) to (k-1), but if we want to eliminate -ve part then we will add +k in every -ve remainder that will be also right.



    public static void main(String[] args) {
        int[] arr = {5,8,-3,-9,-7,4,11,2,9,-16,8,-9};
        int n = arr.length;
        int k = 7;

        HashMap<Integer,Integer> map = new HashMap<>(); // remainder vs index
        int sum = 0, rem = 0, maxLen = 0;
        map.put(0, -1); // means 0 remainder at -1 index.

        for(int i = 0; i < n; i++){
            sum += arr[i];
            rem = sum % k;

            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem)){
                int idx = map.get(rem);
                int len = i - idx;
                maxLen = Math.max(maxLen, len);
            }else{
                map.put(rem, i);
            }
        }

        System.out.println("Answer = " + maxLen);
    }
}
