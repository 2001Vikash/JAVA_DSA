package Step_03_Array.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class V_05_2_Sum_Problem {

    // There are two variety of this question,

    // 1. You have given array and, a target then, We have to find the pair that sum will be equal to the given sum. Here if yes then return true otherwise false.\
    // 2. In second type, there will be definitely pair exists and ,we have to return their indexes, where are they.

    public static void twoSum(){
        int[] arr = {2,6,5,8,11};
        int n = arr.length;
        int target = 14;

        // Brute force => we will do it using two loops, take one and check with others, that will cost time complexity as O(n^2) and SC -> o(1)
        //                we can optimize it slightly, start the second loop from i+1, because there is no need to check same thing again and again.


        // Better approach -> we will be doing it using Hashing as HashMap.
        // Time complexity -> O(N),in c++ O(n log n), O(n) as Space complexity.

    /*    HashMap<Integer,Integer> map = new HashMap<>(); // element,ind
        for(int i = 0; i < n; i++){
            int req = target - arr[i];
            if(map.containsKey(req)){
                System.out.println("Yes");
                System.out.println("Indexes are : " + map.get(req) + "," + i);
                return;
            }else{
                map.put(arr[i], i);
            }
        }
        System.out.println("No!, Not possible"); */


        // Optimal Solution -> Can we solve it without using Hashmap, So, may we have slightly better solution than above using two pointer method.

        // This is nothing but, we can sdy that Greedy approach, This solution will work only for variety 1, not for 2
        // Because we will have to sort the array to apply this approach, means we have to store the indexes, that will make it same as better solution.
        // So, for variety 2 better solution will be optimal.

        // O(n) + O(n log n) as Time complexity
        int left = 0, right = n-1;
        Arrays.sort(arr);
        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum > target){
                right--;
            }else if(sum < target){
                left++;
            }else{
                // if(sum == target)
                System.out.println("YES");return;
            }
        }
        System.out.println("NO");
    }

    public static void main(String[] args) {
        twoSum();
    }
}
