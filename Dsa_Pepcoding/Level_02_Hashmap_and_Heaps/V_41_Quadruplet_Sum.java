package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_41_Quadruplet_Sum {

    // In this problem we are given an array of N integers, and an integer 'x'.
    // You have to find all unique quadruplets (a,b,c,d) which satisfies this condition -> a + b + c + d = x.

    public static void createResult(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> part, int val){
        for(ArrayList<Integer> p : part){
            p.add(0, val);
            res.add(p);
        }
    }
    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int target, int si, int ei){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(si < ei){
            int sum = arr[si] + arr[ei];

            if(sum < target)si++;
            else if(sum > target)ei--;
            else{
                res.add( new ArrayList<>(Arrays.asList(arr[si], arr[ei])));
                // internal thing will return a list, and if we want to add then make it new, because that will return a list only, not a reference/instance,
                //so, if we want to add, then we have to give the address to that with the help of using new keyword.
                si++;
                ei--;
                while(si < ei && arr[si] == arr[si-1])si++;
                while(si < ei && arr[ei] == arr[ei+1])ei--;
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] arr, int target, int si, int ei){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i = si; i <= ei; i++){

            if(i == 0 || arr[i-1] != arr[i]) {
                int newTarget = target - arr[i]; // a + b + c = x, so, we have to search b and c, then we will send x-a.
                ArrayList<ArrayList<Integer>> part = twoSum(arr, newTarget, i + 1, ei);

                createResult(res, part, arr[i]);
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target, int si, int ei){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i = si; i <= ei; i++){

            if(i == 0 || arr[i-1] != arr[i]) {
                int newTarget = target - arr[i]; // a + b + c = x, so, we have to search b and c, then we will send x-a.
                ArrayList<ArrayList<Integer>> part = threeSum(arr, newTarget, i + 1, ei);

                createResult(res, part, arr[i]);
            }
        }
        return res;
    }


    // So, we can implement Quadruple sum at once place, so with the help of this we can avoid createRes step.

    public static void quadSum(int[] arr, int n, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i != 0 && arr[i-1] == arr[i])continue;
            for(int j = i + 1; j < n; j++){
                if((j != i+1) && arr[j-1] == arr[j])continue;

                int si = j+1, ei = n-1;
                while(si < ei){
                    int sum = arr[i] + arr[j] + arr[si] + arr[ei];
                    if(sum < target)si++;
                    else if(sum > target)ei--;
                    else{
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[si], arr[ei])));
                        si++;
                        ei--;
                        while(si < ei && arr[si] == arr[si-1])si++;
                        while(si < ei && arr[ei] == arr[ei+1])ei--;
                    }
                }
            }
        }

        System.out.println(res);
    }


    public static void main(String[] args) {
       int[] arr = {2,8,7,2,3,10,2,4,3,2,10,10,4,5,5,7,8,7,5,2,4,4};
       int n = arr.length;

       Arrays.sort(arr);

      // System.out.println(twoSum(arr, 7, 0, n-1)); // -> TC -> O(n) + n log n for sorting
      //  System.out.println(threeSum(arr, 17, 0, n-1)); // -> O(n^2) + "
      //  System.out.println(fourSum(arr, 21, 0, n-1)); // O(n^3) + sorting. // we have to see that why this is giving wrong answer.

        quadSum(arr, n ,21);
    }
}
