package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_36_Double_Pair_Array {

    // In this problem, you are given an array of integers with even Length n.
    // You have to tell if it is possible to re-order the given array such that for every i in range [0, n/2], arr[2*i + 1] = 2 * arr[2*i]. this condition holds true.
    // Means if arr[2*i+1] = 2 * arr[2*i], should be satisfies so,
    // if i = 0, arr[1] = 2 * arr[0]
    //  i = 1, arr[3] = 2 * arr[2]
    // i = 2, arr[5] = 2 * arr[4]..., from here we can understand that we have to arrange the array such that arr[i] = 2 * arr[i-1], then we can say that above properties is satisfied.

    // Now we are going to solve for +ve integers firstly, then after we will see for -ve numbers as well.

    // So, of we see that at every index we will have two possibility, one is next number can be 2 times of current, or previous can be current / 2.
    // So, if number is even then only we can see /2, not for the odd, because if we have 15, and 15/2 = 7 , but this is wrong because 7 * 2 = 14.
    // So, instead of thinking for division, we will try to search double only.

    // But if we only use double method, then we can face problem if bigger number is present before the smaller number. it means we have to sort the array.
    // sorting method also help us to avoid /2, means freely we can use current * 2 for the next value.
    // Also, we have to focus on 0, when 0 comes, we have to handle it because 2 times of 0 will be 0.

    // But we can not do it for -ve, because we can not find -4 before the -8, because -8 is smaller, so here we have to use current/2, but we can not do it
    // due to -15 and -7, so we will try to sort it in order of its absolute values.
    // Now, we are introducing a new thing that is we have to sort it using its absolute value.




    public static void main(String[] args) {
        int[] arr = {-8,-3,8,8,4,-6,-4,2,0,2,1,4,0,16,8,4};
        int n = arr.length;
        // So, as we know that if n is odd, then we can not divide array into two parts, because we have to arrange the array.

        if(n % 2 != 0){
            System.out.println("Not possible");
            return;
        }
        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int i = 0; i < n; i++)fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);

      // To sort the array according to its absolute value, we have to use lambda function. But to apply this function we have convert this array into Integer from int.
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++)a[i] = arr[i];

        Arrays.sort(a, (x,y)->{
            return Math.abs(x) - Math.abs(y); // means it will not work on primitive data types, we have to make class for it like Integer.
        });
     //Arrays.sort(a, (x,y)->Math.abs(x) - Math.abs(y)); both are same.
     //   System.out.println(Arrays.toString(a));


        for(Integer it : a){
            if(fmap.get(it) == 0)continue;

            // means if double of element is not present or, if double of element is present but having 0 frequency.
            if(fmap.getOrDefault(2 * it, 0) == 0){
                System.out.println("FALSE");
                return;
            }

            // Now we know that 2 * element is present in the array, means we can for a pair so, do it.
            fmap.put(it, fmap.get(it) - 1);
            fmap.put(2 * it, fmap.get(2 * it) - 1);
        }

        System.out.println("TRUE");
    }
}
