package Level_01_Hashmap_and_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class V_06_Introduction_to_Heap_PriorityQueue {

    // In heap, we have two types of it first one is mean_heap, and second one is max_heap which is implemented by PriorityQueue.

    // So, according to Queue, PQ is also same for the inserting from last and deleting from the front means First in First out rule.
    // Functions in Priority Queue is also same as Queue, that is nothing but add, remove, peek.

    // But according to name we can understand that this is based on priority means which ever is having the highest priority, that will come out first from all of them
    // According to priority queue functionalities we can set that whose value is having the highest priority that can be smaller or greater value.

    // Note -> By default Priority Queue gives the priority for the smallest value, means it is By Default but, accordingly we can change it.

    // For ex. If we have values in PQ like that, 10,2,80,33,9 then when we will try to trigger peek() then it will give 2 according to by default nature.
    // So, peek() will take O(1), add() and remove() both will take O(log n) time complexity.

    // We have a structure for this, but we will see afterwards, but let us see it's by default nature that is for smaller value.
    // Why lon(n), we will see but as of now, I can understand it from the Algo notes(gate academy), heap is based on tree data structure, see notes for better understanding.


    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // So, as we know that this by default means it give priority for the smallest value.
        int[] ranks = {22,99,3,11,88,4,1};

        // Complexity of this loop will be O(n*log(n)), n times for outer loop, and for adding elements in Queue takes O(log n) means log n, n times means n log n.

        for(int it : ranks){
            pq.add(it);
        }

        // This is having O(n log n) time complexity.
        System.out.print("Min heap : ");
        while(!pq.isEmpty()){
            System.out.print(pq.peek() + " "); //O(1)
            pq.remove(); // O(log n).
        }
        // So, result will come in sorted order.

        // So, this is known as Heap_sort that is having O(n log n) time complexity, we have also in-place heap sort means that will not take any extra space
        // But this solution is taking extra O(n) space.

        // But what should we have to do to tell PQ that hey please give the priority for the highest value.

        System.out.println();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());// it will work in reverse mode of by default.

        for (int val : ranks){
            pq2.add(val);
        }
        System.out.print("Max heap : ");
        while (!pq2.isEmpty()){
            System.out.print(pq2.peek()+" ");
            pq2.remove();
        }
    }
}
