package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_04_Count_Distinct_Elements_In_Every_Windows_of_Size_K {

    // Problem states that we have given an array, and an integer k which is nothing but window size for the array, and we have to check that,
    // How much different elements are present in every k size window.

    // For the solution we will use HashMap, and Acquire-release group strategy, and this strategy is used at vast in a lots of problem related HashMap
    // We will use frequency HashMap, and we will acquire k-1 elements and put kth elements and print distinct elements and remove first elements
    // To identify first elements we will use another pointer j, that will increase by at the time of removing only.
    // As we know that if we have an element x with frequency 2 and, if we remove it then frequency will not decrease by 1,
    // means x is removed from map with its frequency, that's why for release we will put that element in map with -1 frequency.

    public static void solution(int k, int[] arr){
        int n = arr.length;
        if(k > n){
            System.out.println("Invalid argument");
            return;
        }

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int i = 0; i < k-1; i++){
            fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
        }

        // Now apply, acquire and release strategy

        ArrayList<Integer> ans = new ArrayList<>();


        for(int i = k-1, j = 0; i < n; i++, j++){
            // Acquire
            fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
            // Print
            ans.add(fmap.size());
            // Release
            int oldFq = fmap.get(arr[j]);
            if(oldFq == 1){
                fmap.remove(arr[j]);
            }else{
                fmap.put(arr[j], oldFq - 1);
            }
        }

        System.out.println(ans);
    }


    public static void main(String[] args) {
        int[] arr = {2,5,5,6,3,2,3,2,4,5,2,2,2,2,3,6};
        int k = 4;
        // we have to find no. of distinct elements in every window. for ex, in 0 to 3, 1 to 4, 2 to 5 and so on.
        solution(k, arr);


       /*

       // Imp Note about HashMap delete.

       HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 1);
        mp.put(2,1);
        mp.put(1, mp.getOrDefault(1, 0)+1);
        System.out.println(mp);
        mp.remove(1);
        System.out.println(mp);*/
    }
}
