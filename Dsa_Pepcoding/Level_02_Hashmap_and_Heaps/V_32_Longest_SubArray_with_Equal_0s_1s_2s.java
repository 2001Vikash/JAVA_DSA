package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_32_Longest_SubArray_with_Equal_0s_1s_2s {

    // In this problem you are given an array that contains only 0s, 1s and 2s. you have to find length of the longest subArray with equal number of 0s,1s and 2s.

    // In solution => So, firstly we will count 0s -> X0, 1s -> X1, 2s -> X2, if in future gaps of X1-X0 and X2-X1 are coming same it means that will be our desired possible subArray.
    //  In this we will make hashmap and key will be X1-X0#X2-X1.

    public static void main(String[] args) {
        int[] arr = {1,1,2,0,1,0,1,2,1,2,2,0,1};
        int n = arr.length;

        HashMap<String, Integer> map = new HashMap<>(); // we are going to store gap, in string
        String initialKey = "0#0"; // 0-0 = 0, 0-0 = 0
        map.put(initialKey, -1); // this key is coming at index -1, means we are in initial stage.
        int maxLen = 0;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0)cnt0++;
            else if(arr[i] == 1)cnt1++;
            else cnt2++;

            String key = (cnt1-cnt0) + "#" + (cnt2-cnt1);

            if(map.containsKey(key)){
                maxLen = Math.max(maxLen, i - map.get(key));
            }else{
                map.put(key, i);
            }
        }

        System.out.println("Answer is = " + maxLen);
    }
}
