package Level_01_Hashmap_and_Heaps;

import java.util.PriorityQueue;

public class V_07_K_Largest_Elements_in_an_Array {

    // For ex 2,10,5,17,7,18,6,4 we have given array and, we have to find the k largest, elements from this array if k = 2, then the answer will 17,18.
    // And, we can use space only O(k), and time O(n log k).

    // Now, to solve this problem we will use PQ with by default, we are giving the highest priority for the smallest value because we want drop that value.
    // So, we will add elements into the PQ only k times after that we will traverse the array and if we will find the better/greater element from the peek() if the PQ
    // then we will remove that and, insert the new element so, due to this in the last wr will have k largest, elements in PQ, print them.
    // So, via this method we can do it in TC -> O(n log k), SC -> O(K).

    public static void main(String[] args) {
        int[] arr = {2,10,5,17,7,18,6,4};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 3;
        for(int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }
}
