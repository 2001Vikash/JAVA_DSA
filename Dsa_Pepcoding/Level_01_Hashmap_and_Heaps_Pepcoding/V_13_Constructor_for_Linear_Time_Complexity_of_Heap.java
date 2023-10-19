package Level_01_Hashmap_and_Heaps;

import java.util.ArrayList;

public class V_13_Constructor_for_Linear_Time_Complexity_of_Heap {

    // In previous implementation we were taking n log n time for adding because we were calling add for every entry and, as
    // we know that when add() will be calling then, upHeapify will be called as well, so when we will reach at last level of
    // tree then we will have n/2 elements at last level assume if we call up-heapify for every one then we can easily see that we are taking n log n time
    // So, can we do it this thing in linear time -> Yes.

    public static class PriorityQueue{
        ArrayList<Integer> dataList;
//       public PriorityQueue(int[] arr){
        // jaja jayada log waha jayada kaam
//            dataList = new ArrayList<>();
//            // previously we were doing which is taking n log n time.
//            for(int val : arr){
//                this.add(val); // that will take n log n.
//            }
//        }

        // Now let us do it in O(n)
        public PriorityQueue(int[] arr){
            // jaha jayada log waha km kaam that is basic difference in both method
            dataList = new ArrayList<>();
            // previously we were doing which is taking n log n time.
            for(int val : arr){
                dataList.add(val);
            }
            for(int i = dataList.size() / 2 - 1; i >= 0; i--){
                downHeapify(i); // it will save time for last level elements, means for n/2 elements there is no any call, and for n/4 elements it will
                // call only for 1 height, and so on, Now we are doing it in O(n).
            }
        }
       public void add(int val){
           dataList.add(val);
           upHeapify(dataList.size()-1);
       }
       private void upHeapify(int i){
           if(i == 0)return;

           int pi = (i-1)/ 2;
           if(dataList.get(pi) > dataList.get(i)){
               // swap
               swap(i, pi);
               upHeapify(pi);
           }
       }
       private void swap(int i, int j){
           int ith = dataList.get(i);
           int jth = dataList.get(j);
           dataList.set(i, jth);
           dataList.set(j, ith);
       }

       public int remove(){
           if(this.size() == 0){
               System.out.println("Underflow");
               return -1;
           }
           swap(0, dataList.size()-1);
           int removedData = dataList.remove(dataList.size()-1);
           downHeapify(0);
           return removedData;
       }
       private void downHeapify(int pi){
           int leftChildInd = 2 * pi + 1;
           int mini = pi;

           if(leftChildInd < dataList.size() && dataList.get(leftChildInd) < dataList.get(mini)){
               mini = leftChildInd;
           }

           int rightChildInd = 2 * pi + 2;
           if(rightChildInd < dataList.size() && dataList.get(rightChildInd) < dataList.get(mini)){
               mini = rightChildInd;
           }
           if(mini != pi){
               swap(mini, pi);
               downHeapify(mini);
           }
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
        int[] arr = {5,4,6,9,3,2,8,1};
        PriorityQueue pq = new PriorityQueue(arr);
        System.out.println(pq.dataList); // it will contain both property CBT and HOP.
    }
}
