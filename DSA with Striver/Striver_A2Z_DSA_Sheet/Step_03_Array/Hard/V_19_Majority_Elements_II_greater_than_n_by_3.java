package Step_03_Array.Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class V_19_Majority_Elements_II_greater_than_n_by_3 {


// In this problem we are given an integer array and, we have to find the majority element in the array that are appearing more than floor of n/3.
 // for ex. if we have 8 elements in the array then we have to find that element which is appearing more than 2 times, means 8/3 = 2.66 means floor = 2

    // So, if we observe that, how many integers at max be there in the answer, that will be 2 at max. for ex, if we have 8 elements in
    // the array it means we can have at max 2 elements which can appear more than 3 times, because we have requirement of more than 2 means minimal 3,
    // So, if 2 elements are appearing 3 times which is min, then 3+3 = 6, we can see that we will have only 8-6 = 2 remaining elements.
    // for 9, 9/3 floor = 3, we have requirement of 3+1 that is 4 minimal, 4+4 = 8, 9-8=1 yes it is definitely right that at max 2 elements can more than floor of length/3.
    // At min can be 0.



    public static void majorityElementsII(){
        int[] arr = {1,1,1,3,3,2,2,2};
        int n = arr.length;

        // Brute force -> In this we will try to find the count of every element and check that count is greater than floor of length/3 or not.

        // TC -> O(n^2), O(2).

       /* ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int element = arr[i];
            int count = 0;
            if(ans.size() == 0 || element != ans.get(0)) {
                for (int j = 0; j < n; j++) {
                    if (element == arr[j]) count++;
                }
            }
            if(count > n/3){
                ans.add(arr[i]);
                if(ans.size() == 2)break;// as we know that this will be max answer as we can get.
            }
        }
        System.out.println(ans); */


        // Better Solution -> We have to reduce the time complexity from O(n^2). which will be done via HashMap. means using Hashing.

        // TC -> O(n) , SC -> O(n). // In c++ space can O(n*log n) for ordered map, but in case of unOrdered map it will be O(n * 1) but in worst case it can be O(n*n).

       /* HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int it : arr){
            fmap.put(it, fmap.getOrDefault(it, 0) + 1);// that is frequency map
        }
        // then after count the keys and check which are coming more than n/3.

        for(int e : fmap.keySet()){
            if(fmap.get(e) > n/3){
                System.out.print(e + " ");
            }
        }

        // In better solution we are doing 2 time iteration, can we do it in one iteration in Better solution. => Yes

        HashMap<Integer,Integer> fmap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int it : arr){
            fmap.put(it, fmap.getOrDefault(it, 0) + 1);
            if(fmap.get(it) > n/3){
                if(ans.size() == 0 || ans.get(0) != it) ans.add(it);
            }
        }
        System.out.println(ans);*/

        // Optimal Solution -> this approach is derived from the majority elements more than n/2 problem than Moore's voting algorithm.
        //                  -> So, we had applied that, if element is same then do cnt++, or cnt--, due to  this in the last we found a possible answer and check.

        // Same thing we will apply here as well, instead of making one cnt, here we know that there can two possible answer it means we will make cnt1, cnt1 and el1, el2.

        int cnt1 = 0, cnt2 = 0, el1 = (int)1e9, el2 = (int)1e9;

        for(int i = 0; i < n; i++){
            if(cnt1 == 0 && arr[i] != el2){ // as we know that el1 and el2 should be unique that's why we have done this.
                cnt1 = 1;
                el1 = arr[i];
            }
            else if(cnt2 == 0 && arr[i] != el1){
                cnt2 = 1;
                el2 = arr[i];
            }else if(arr[i] == el1)cnt1++;
            else if(arr[i] == el2)cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        // do a manual check for the potential answer.
        for(int it : arr){
            if(el1 == it)cnt1++;
            if(el2 == it)cnt2++;
        }
        if(cnt1 > n/3){
            System.out.print(el1 + ", ");
        }
        if(cnt2 > n/3){
            System.out.print(el2);
        }
    }

    public static void main(String[] args) {
        majorityElementsII();
    }
}
