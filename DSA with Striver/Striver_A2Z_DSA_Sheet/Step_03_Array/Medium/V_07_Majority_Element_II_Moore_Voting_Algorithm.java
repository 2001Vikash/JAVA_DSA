package Step_03_Array.Medium;

import java.util.HashMap;

public class V_07_Majority_Element_II_Moore_Voting_Algorithm {

    // Majority elements (> n/2 times) -> we are given an array of integers, we have to find element that appears more than n/2 times, where n = arr.length

    public static void majorityElements(){
        int[] arr = {2,2,3,3,1,2,2};
        int n = arr.length;

        // Brute force -> we will find n/2 and will be checking for every element which is appearing more that n/2. => O(n^2)

        // Better Solution -> As a better solution whenever we have to count or keeping track of something, then first thing must come into mind, is Hashing.
        //                 -> Using hashing(HashMap) technique we will give better solution, (Note -> in map keys are presented in sorted order).

        // TC -> o(2n), sc->o(n), for c++, tc->o(n log n) when we use ordered map.
        
      /*  HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int val : arr){
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }
        int ans = 0;
        for(int keys : fmap.keySet()){
            if(fmap.get(keys) > (n/2)){
               ans = keys;
               break;
            }
        }
        System.out.println("Answer is = " + ans);*/
        
        
        
        //  Optimal Solution -> Which is done using Moore's Voting Algorithm.
        
        // Algorithm revolves around two things that is count and element, So, make first element of the array as a element that we are searching
        // and in next if we find same element then cnt++, if not then cnt-- till 0, when cnt comes to 0 then again assign the next element as our answer
        // and so on, then after verify that element to traverse array again if cnt > n/2 then that will be our answer otherwise return -1.

        // Though process & Intuition -> We know that we are searching that elements which is appearing more that half of array's elements, means if we will apply
        //                   the moore's voting algo then that element will not be canceled via others which are less than that elements. Here counter value does not represent anything in last.

        // TC -> O(2N), O(1)

        int count = 0, element = arr[0];

        for(int i = 1; i < n; i++){
            if(count == 0){
                element = arr[i];
            }
            if(element == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        // verify
        count = 0;
        for(int it : arr){
            if(it == element)count++;
        }
        if(count > n/2){
            System.out.println("Answer is = " + element);
        }else{
            System.out.println("Ans is not found");
        }
    }

    public static void main(String[] args) {
        majorityElements();
    }
}
