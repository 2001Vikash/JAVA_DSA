package Level_01_Hashmap_and_Heaps;

import java.util.ArrayList;
import java.util.HashMap;

public class V_05_Longest_Consecutive_Sequence_or_Subsequence {

    // Problem states that we have given an array in which n number of elements are existed, Now we have to find a consecutive sequence
    // which is containing More numbers, It means may be there will be a sequence which can contains numbers like 1,2,3,4,5 like that or 8,9,10,11,12.
    // If both sequence is having same number of elements then we have to return smaller one according to sorting order for ex. in above ex ans. will be first.

    // In solution, we will fill a HashMap<Integer, Boolean> here  boolean tells that this number is starting from its sequence which not true but
    // this is approach which we will follow to solve this question.
    // Now, in second step we will check that whatever entries we have that will be starting or not with the help of checking n-1 is present in map or not.
    // If present it means that will be not a starting point then do false, and at the end those will be remaining that will be starting of their sequence.
    // After then whichever is having true we will find the starting and end point for that particular sequence and maximize it.


    // SC -> O(n), TC -> O(n) because while loop will run at max n times that's why we are saying that this is O(n) time complexity.


    public static void main(String[] args) {
        int[] arr = {10,5,9,1,11,8,6,15,3,12,2};
        int n = arr.length;

        HashMap<Integer, Boolean> map = new HashMap<>();

        // n times

        for(int it : arr){
            map.put(it, true);
        }

        // n times

        for(int it : arr){
            if(map.containsKey(it-1)){
                map.put(it, false);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int startIndex = 0;
        int maxLength = 0;

        // n times

        for(int it : arr){
            if(map.get(it)){ // means which ever is having true it means they are starting point just we have to find the length and starting point.
                int len = 1;
                int tempStartInd = it;

                // Summation of all steps will be n always so, instead of saying n*n we will say it n+n.

                while(map.containsKey(tempStartInd + len)){
                    len++;
                }
                if(len > maxLength){
                    maxLength = len;
                    startIndex = tempStartInd;
                }
            }
        }

        for(int i = 0; i < maxLength; i++){
            ans.add(startIndex + i);
        }

        System.out.println(ans);
    }
}
