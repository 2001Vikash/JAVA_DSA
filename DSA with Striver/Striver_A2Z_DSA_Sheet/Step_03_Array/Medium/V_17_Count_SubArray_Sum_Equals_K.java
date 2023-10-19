package Step_03_Array.Medium;

import java.util.HashMap;

public class V_17_Count_SubArray_Sum_Equals_K {

    // In this problem we have to find the number of SubArray with given sum k, here subArray means contiguous part of the array is known as SubArray of the array.


    public static void numberOfSubArraySumEqualK(){
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int n = arr.length;
        int k = 3;

        // Brute force solution => In naive manner we will generate all the subArrays and then will check that how many subArrays are existing as equal to given sum K.
        // TC -> O(n^3). SC -> O(1)
    /*    int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int l = i; l <= j; l++){
                    sum += arr[l];
                }
                if(sum == k){
                    cnt++;
                }
            }
        } */


        // Better Solution -> We will do it in O(n^2) with some easy observation because there is no need to write third loop.

     /*   int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt); */


        // Optimal Approach => Here to achieve most optimal solution we will be using predixSum concept which we have already learnt in previous lectures.
        // So, prefix sum at a particular index it tells than if at this index I have sum = s, and I am searching for k, it means if preSum = s-k exists means after the removal of s-k part we we can another subArray that is intuition.
        // TC -> O(n), SC -> O(n)
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(preSum, 1);
        for(int i = 0; i < n; i++){
            preSum += arr[i];
            int remove = preSum - k;
            if(map.containsKey(remove)){
                cnt += map.get(remove);
                map.put(remove, map.get(remove) + 1);
            }

            if(!map.containsKey(preSum)){
                map.put(preSum , 1);
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        numberOfSubArraySumEqualK();
    }
}
