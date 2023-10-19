package Level_01_Hashmap_and_Heaps;

import java.util.ArrayList;

public class V_11_Write_Priority_Queue_Using_Heap {

    // In this question we have to implement PriorityQueues functionalities.
    // Like -> add(), remove(), peek(), size() .

    // let us propose some solution for that,

    // code for sorting using PQ,
    /*
    for(int val : arr)pq.add(val);

    while(pq.size() > 0){
      print(pq.peek());
      pq.remove();
      }
     */

    // 1. if we do it via linked list then for add() TC -> O(1), for remove(), TC -> O(n) and same for the peek()
    // for to find smaller element for the peek() in PQ we have to search smaller element that will cost TC as O(n) and same for remove().
    // For better understanding that which one is better solution we will take above example,
    // for the solution 1, TC will be O(n^2). => O(1) + O(n*n)

    // 2. Solution can be if we will add element at appropriate place then add() will take TC O(n), but for remove(),peek() TC -> O(1)
    // because all smaller elements will be present at the starting of list.
    // for solution 2 TC will O(n^2), means we did good things for peek, remove but TC will be remained same.

    // 3. Solution 3 will be like that for add(), tc = log n, remove = log n, peek = O(1), means overall O(n log n) that will be better in all.
    // So, we will do this thing using Heap, as we know that max-heap, min-heap(tree form), means solution 3 will be done with the help of Heap.

    // Heap -> it is having two properties, as we know that it is implemented in tree form.
    // -> 1. HOP -> Heap order property, 2. CBT -> complete binary tree.

    // 1. HOP(heap order property) : (what)it means every parent will put smaller value than its child, there is no any talk about left child, or right child or which one is big
    //                               we are just telling that every parent will be smaller than its child that is meaning of heap order property.
   //                               (why)-> because we want to achieve peek() in O(1) time complexity, and that will be present at root node.

    // 2. CBT(complete binary tree) : (what), it means that whatever tree you have, h-1 level must be completely filled,
    //                                 and after we will start filling from left side.
    //                                (why) with the help of this we can perform add(),remove() in O(log n) time complexity.

    // Note -> In reality, PQ used list for the operation, because if we see the CBT in the form of list, then we can achieve it via level order traversal.
    //         So, CBT is nothing but visual view/part of the tree for the implementation of Heap/PriorityQueue.
    // Here is one main thing that is, root will be at 0th index, and children like 1,2,3,4 and so on, so
    // if parent index is pi then leftChildIndex = 2 * pi + 1, rightChildIndex = 2 * p + 2.
    // with the help of this formula we can for the parent from the child directly using these formula,
    // instead of this there is no way to go for parent in previous tree traversal concepts, it is done only with the help of CBT, that is extra capability.

    // add() => for the add to a new element in tree, we will add that element at last index of list,or tree and will call up-Heapify(recursively), which will
    //          help us to gain again HOP, and CBT, that will take log n, time complexity

    // remove() => we know that generally we remove peek() element from the PQ, that is root of tree, but we are assuming tree as list, and
    //             in list if we remove first element then that wll take O(n) time complexity, because every element will come back one index previous.
    //             but we are trying to do this operation in log n, so for that we will swap the root to last element of the tree and after that
    //             to gain HOP and CBT we will cal down-Heapify(recursively), So that we can do this thing in O(log n).
    //             we know that in list we can remove last element in O(1) operation, apart from this there is no any place to do deletion in O(1) in list.


    public static class PriorityQueue{  // min_heap.
        ArrayList<Integer> dataList;
        PriorityQueue(){
            dataList = new ArrayList<>();
        }

        public void add(int val){
            dataList.add(val);
            upHeapify(dataList.size()-1);
        }

        private void upHeapify(int i){

            if(i == 0){
                return; // for the root index there is no any further parent.
            }

            int pi = (i-1)/2; // => leftChildInd = 2 * pi + 1, we can use rightChildIndex as well, that will give also correct answer.
            if(dataList.get(i) < dataList.get(pi)){
                swap(i, pi);
                upHeapify(pi);
            }
        }

        public int remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }

            swap(0, dataList.size()-1);
            int removeVal = dataList.remove(dataList.size()-1);
            downHeapify(0);

            return removeVal;
        }

        private void downHeapify(int pi){
            int mini = pi;
            int li = 2 * pi + 1;
            int ri = 2 * pi + 2;

            if(li < dataList.size() && dataList.get(li) < dataList.get(mini)){
                mini = li;
            }

            if(ri < dataList.size() && dataList.get(ri) < dataList.get(mini)){
                mini = ri;
            }

            if(mini != pi){
                swap(mini, pi);
                downHeapify(mini);
            }
        }

        private void swap(int i, int j){
           int ith = dataList.get(i);
           int jth = dataList.get(j);
           dataList.set(i, jth);
           dataList.set(j, ith);
        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return dataList.get(0);
        }

        public int size(){
            return dataList.size();
        }
    }


    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(35);
        pq.add(45);
        pq.add(42);
        pq.add(55);
        pq.add(50);

        System.out.println(pq.dataList);

        System.out.println("Peek = " + pq.peek());

        pq.add(15);
        System.out.println(pq.dataList);
        System.out.println("Peek = " + pq.peek());

        pq.add(5);
        System.out.println(pq.dataList);
        System.out.println("Peek = " + pq.peek());

        System.out.println("removed element = " + pq.remove());
        System.out.println(pq.dataList);
        System.out.println("Peek = " + pq.peek());

    }
}
