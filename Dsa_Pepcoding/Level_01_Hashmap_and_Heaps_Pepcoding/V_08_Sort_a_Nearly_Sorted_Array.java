package Level_01_Hashmap_and_Heaps;

import java.util.PriorityQueue;

public class V_08_Sort_a_Nearly_Sorted_Array {

    // This problem can also be known as Sort K-sorted Array.

    // In this question we have given k-sorted array means array is not sorted it is in form of k sorted
    // k-sorted, means an element from the array can be placed up to k index left or right from its original position, and we have to sort the array.
    // for ex. 1,2,3,4,5,6,7,8,9 => k-sorted can be => 2,3,1,4,6,7,5,8,9 if k = 2. means an element can go at max 2 distance, it can go 1,0 as well but 2 is max.
    // to solve this problem we can use O(k) space, and O(n log k) time that is constraint of this question.

    // Solution =>

    // To solve this problem we will use PQ, and initially we will store k+1 elements into the PQ because an element for the initial stage that can
    // go only in right at most 2 steps that is nothing but for 0 it can be 2nd index that's why we are inserting k+1 elements into PQ
    // Then after remove() and add() will be continuing for till end of the array and at the end we will find our sorted array.


    public static void main(String[] args) {
        int[] arr = {2,3,1,4,6,7,5,8,9 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int k = 2;
        for(int i = 0; i < k+1; i++)pq.add(arr[i]);

        int i = k+1;
        while(!pq.isEmpty()){
            int val = pq.remove();
            System.out.print(val + " ");
            if(i < arr.length){
                pq.add(arr[i]);
                i++;
            }
        }
    }
}
