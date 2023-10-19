package Level_02_Hashmap_and_Heaps;

import java.util.HashSet;

public class V_37_Arithmetic_Sequence {

    // Check Arithmetic sequence.
    // In this problem, we are given an array of integers, we have to find if elements of the given array can be arranged to form an arithmetic progression.
    // AP is defined as the sequence of numbers where the difference between any two consecutive numbers is the same.

    public static void main(String[] args) {
        int[] arr = {17,9,5,29,1,25,13,37,21,33};
        int n = arr.length;

        // So, as we know that An = a0 + (n-1)*d is property of AP, from this we can find d using min and max element of the array divided by n-1. where n will be size of array or number of elements in AP
        // a, a+d, a+2d...., a+(n-1)d, we will use it.

        // edge case
        if(n == 1){ // if n == 1 then we can not find d.
            System.out.println("TRUE"); // one element will always be in AP.
            return;
        }

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int val : arr){
            maxi = Math.max(maxi, val);
            mini = Math.min(mini, val);
            set.add(val);
        }

        int d = (maxi - mini) / (n-1);
        int a0 = mini;

        for(int i = 0; i < n; i++){
            int ai = a0 + i * d;
            if(!set.contains(ai)){
                System.out.println("FALSE");
                return;
            }
        }

        System.out.println("TRUE");
    }
}
