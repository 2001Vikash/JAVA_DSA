package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_27_SubArray_Sum_Equals_K {

    // In this problem we have to count of subArrays having sum equals to the K which is a given integer value.
    // So, for the solution as we know that we will be using Hashmap, and prefix sum concept, means of we have x+k as current sum, if previously
    // we had sum as x present in our map, it means in-between we are having a sum k,because at now we have x+k, and prev = x, x+k-x = k which is a subArray.


    public static void main(String[] args) {
        int[] arr = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        int n = arr.length;
        int k = 5;

        HashMap<Integer,Integer> fmap = new HashMap<>();
        fmap.put(0, 1);
        int cnt = 0;
        int currSum = 0;

        for(int i = 0; i < n; i++){
            currSum += arr[i];
            if(fmap.containsKey(currSum - k)){
                cnt += fmap.get(currSum - k);
            }
            fmap.put(currSum, fmap.getOrDefault(currSum, 0) + 1);
        }

        System.out.println("Number of SubArray Sum equals k = " + cnt);
    }
}
