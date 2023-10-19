package Level_02_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_06_Count_of_All_SubArrays_with_Zero_Sum {

    // This is exactly similar as previous problem. Here we have to change little-bit, but algo will be same.

    public static void countAllSubArraysWithZeroSum(int[] arr){
        HashMap<Integer,Integer> fMap = new HashMap<>();
        int cnt = 0;
        int sum = 0;
        fMap.put(sum , 1);// it means 0 came once.
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(fMap.containsKey(sum)){
                cnt += fMap.get(sum);
                fMap.put(sum, fMap.get(sum) + 1);
            }else{
                fMap.put(sum ,1);
            }
        }
        System.out.println("Number of all subArrays with sum zero is = " + cnt);
    }

    public static void main(String[] args) {
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        countAllSubArraysWithZeroSum(arr);
    }
}
