package Level_02_Hashmap_and_Heaps;

import java.util.HashSet;

public class V_33_Pairs_with_Equal_Sum {

    // Problem states that you are given an array of distinct integers, you have to find if there are two pairs(A,B) and (C,D) present in the given
    // array which satisfies the condition A + B = C + D.

    // As we know that, we have nC2 pairs exists, where n is the number of elements.
    // so, for this we will check every pair, and whenever we will find answer return true.


    public static void main(String[] args) {
        int[] arr = {2,9,3,5,8,6,4};
        int n = arr.length;

        // O(n^2) -> it will be better solution, we have not another way to do it till now.
        // But if we are given a target and, if they are asking about pairs sum = target, then we can do that in O(n) time complexity, using Hashmap
        // like we will put arr[i] in map, and then after search in map that target-arr[i] exists or not, if yes then return true, otherwise false.

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int sum = arr[i] + arr[j];
                if(!set.contains(sum)){
                    set.add(sum);
                }else{
                    System.out.println("TRUE");
                    return;
                }
            }
        }
        System.out.println("FALSE");
    }
}
