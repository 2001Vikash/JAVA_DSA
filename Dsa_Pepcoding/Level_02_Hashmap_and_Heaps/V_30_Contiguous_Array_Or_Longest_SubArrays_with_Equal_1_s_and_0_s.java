package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_30_Contiguous_Array_Or_Longest_SubArrays_with_Equal_1_s_and_0_s {

    // So, problem states that, you are given an array that contains only 0's and 1's.
    // You have to find the length of the longest subArray with equal number of 0's and 1's.

    // So, to solve this problem we will apply longest subArray sum problem, to do that here we will assume 0 as -1 and do summation.
    // Now, in future if we will find previous sum, it means in-between sum will be 0, that means number of -1 = number of +1, and as we know that
    // No. of 0's is nothing but number of -1's,

    // S, intuition is that why are we assuming 0 as -1, because we know that if -1 and, 1 will be same it means that both are coming equal number of times.


    public static void main(String[] args) {
       int[] arr = {0,0,1,0,1,0,1,1,0,0,1,1,1};
       int n = arr.length;

       HashMap<Integer, Integer> map = new HashMap<>(); // sum Vs ind.
       int sum = 0, maxLen = 0;
       map.put(sum, -1);
       for(int i = 0; i < n; i++){
           if(arr[i] == 0) sum+= -1;
           else sum += 1; // or arr[i];

           if(map.containsKey(sum)){
               maxLen = Math.max(maxLen, i - map.get(sum));
           }else {
               map.put(sum , i);
           }
       }

        System.out.println("Answer : " + maxLen);
    }
}
