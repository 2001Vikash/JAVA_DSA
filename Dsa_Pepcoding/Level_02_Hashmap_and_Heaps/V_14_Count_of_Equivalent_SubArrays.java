package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_14_Count_of_Equivalent_SubArrays {

    // In this problem we have an array of integers, we have to find the count of equivalent subArrays,
    // A subArray is Equivalent -> if count of unique integers in subArray == count of unique elements in given Array.

    public static void main(String[] args) {
        int[] arr = {2,5,3,5,2,4,1,3,1,4};
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        for(int it : arr)set.add(it);

        int k = set.size(); // this shows number of distinct elements in the array.

        int i = -1, j = 1, ans = 0;
        HashMap<Integer,Integer> fmap = new HashMap<>();

        while(true){
            boolean f1 = false, f2 = false;
            // acquire
            while(i < n-1){
                f1 = true;
                i++;
                fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);

                if(fmap.size() == k){
                    ans += n - i;
                    break;
                }
            }
            // release
            while(j < i){
                f2 = true;
                j++;
                if(fmap.get(arr[j]) == 1){
                    fmap.remove(arr[j]);
                }else{
                    fmap.put(arr[j], fmap.get(arr[j]) - 1);
                }

                if(fmap.size() == k){
                    ans += n - i;
                }else{
                    break;
                }
            }

            if(!f1 && !f2)break;
        }

        System.out.println("Number of equivalent subArray = " + ans);
    }
}
