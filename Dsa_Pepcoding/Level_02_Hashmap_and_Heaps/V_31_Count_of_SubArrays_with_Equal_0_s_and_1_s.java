package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_31_Count_of_SubArrays_with_Equal_0_s_and_1_s {

    // Problem states that you are given an array that contains only 0's and 1's. You have to find the count of subArrays with equal number of 0's and 1's.

    public static void main(String[] args) {
        int[] arr = {0,0,1,0,1,0,1,1,0,0,1,1,1};
        int n = arr.length;

        // In solution as we know that we will assume every 0's as -1 and, then after count the subArrays.

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, cnt = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += 1;
            }

            if(map.containsKey(sum)){
                cnt += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }

        System.out.println("Answer is = " + cnt);
    }
}
