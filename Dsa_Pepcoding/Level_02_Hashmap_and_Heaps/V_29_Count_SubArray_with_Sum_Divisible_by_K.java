package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_29_Count_SubArray_with_Sum_Divisible_by_K {

    // This problem is similar like previous problem, but here we have to count the subArray sum, instead of returning longest subArray with sum divisible by k



    public static void main(String[] args) {
       int[] arr = {2,3,5,4,5,3,4};
       int n = arr.length;
       int k = 7;

       HashMap<Integer,Integer> map = new HashMap<>(); // stores remainder's frequency.
       map.put(0, 1);
       int sum = 0, cnt = 0, rem = 0;

       for(int i = 0; i < n; i++){
           sum += arr[i];
           rem = sum % k;

           if(rem < 0)rem += k; // of remainder comes -ve then make it +ve.

           if(map.containsKey(rem))cnt += map.get(rem);

           map.put(rem , map.getOrDefault(rem, 0) + 1);
       }

        System.out.println("Answer : " + cnt);
    }
}
