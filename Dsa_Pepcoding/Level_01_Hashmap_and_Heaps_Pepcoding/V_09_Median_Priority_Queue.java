package Level_01_Hashmap_and_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class V_09_Median_Priority_Queue {

    // In this problem we have to return the median value from the Queue, for ex. if we have inserted 10,20,30 and, asking median like as peek()
    // then the answer should be 20, if we have 10,20,30,40, there are two median, here we have to return smaller one that is 20 rather than 30.
    // But as we know that when we trigger q.peek() then PQ will return smaller one(by default) but for this function we have to return median that's it.
    // Now, if someone is wanting to move from PQ then as we know that we used to remove peek() from the PQ it means median will remove itself.

    // Means if someone is wanting to add then do it, if peek() then give median and, if they want to remove then remove peek() which is nothing but median.
    // If median PQ is having 0 size then return -1.

    // Solution =>

    // Implementation -> So, to solve this problem we will use two PQ as left = max_heap(max PQ), right = min_heap(min PQ) anc half of the sorted data
    //                   will be put into the left PQ which is smaller than the median or equal, and right PQ will have grater than median, do it on paper for better understanding.

    // Note -> make sure that both PQs do not have difference in size 2 or more, try to take same size, or 1 difference
    //        if somewhere we find difference in size as 2 then from the bigger remove one element and put it in another one.
    //        means size gap in between both PQs must be less than or equal to the 1, if we find more than 1 then do removal from bigger one and, put it in smaller one.
    //        Initially put the elements into left PQ till size difference must be less than 2, if 2 then remove and put in second that right half.
    //        And at once if we will put element in right PQ then we will check that if current element is bigger than peek() then put it in right PQ otherwise put in left PQ.
    //        And at that time if someone is asking median then whichever is having maximum size that's peek() value will be median.
    //        if both is having same size then left half's PQ is having median element in its peek().
    //        for the removal if size is equal then remove from the left half's PQ., if not equal then remove from the max size part.


    public static class MedianPriorityQueue{
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianPriorityQueue(){
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val){
            if(right.size() > 0 && val > right.peek()){
                right.add(val); // means if some elements are present in right and upcoming value is bigger then, right's peek(), then put it in right side.
            }else {
                left.add(val);
            }

            if(left.size() - right.size() == 2){
                right.add(left.remove());
            }else if(right.size() - left.size() == 2){
                left.add(right.remove());
            }
        }

        public int remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else if(left.size() >= right.size()){
                return left.remove();
            }else{
                return right.remove();
            }
        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return -1;
            } else if(left.size() >= right.size()){
                return left.size() == 0 ? -1 : left.peek(); // there is no need to do this but for the sake of knowledge.
            }else{
                return right.peek();
            }
        }

        public int size(){
            return left.size() + right.size();
        }
    }



    public static void main(String[] args) {

        MedianPriorityQueue mpq = new MedianPriorityQueue();
        mpq.add(10);
        mpq.add(20);
        System.out.println("Median : " + mpq.peek());
        mpq.add(30);
        System.out.println("Median : " + mpq.peek());
        mpq.add(40);
        System.out.println("Median : " + mpq.peek());
        mpq.add(50);
        mpq.add(60);
        System.out.println("Median : " + mpq.peek());

        System.out.println("Removed element : " + mpq.remove());
        System.out.println("Median : " + mpq.peek());
        System.out.println("Removed element : " + mpq.remove());
        System.out.println("Median : " + mpq.peek());
        System.out.println("Removed element : " + mpq.remove());

    }
}
