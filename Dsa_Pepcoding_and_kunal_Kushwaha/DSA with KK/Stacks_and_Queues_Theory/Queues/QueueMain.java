package Stacks_and_Queues_Theory.Queues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
//        queue.insert(4);
//        queue.insert(3);
//        queue.insert(15);
//        queue.insert(48);
//        queue.insert(94);
//
//        queue.display();
//
//        System.out.println(queue.remove());
//
//        // but O(n) for just removing it is not a very good thing
//
//        queue.display();

        // To make complexity for removing O(1) then we need to use Circular queue concept.

//        CircularQueue queue = new CircularQueue(5);
//        queue.insert(4);
//        queue.insert(3);
//        queue.insert(15);
//        queue.insert(48);
//        queue.insert(94);
//
//        queue.display();
//
//        System.out.println(queue.remove());
//
//        queue.insert(133);
//
//        queue.display();

        DynamicQueue queue = new DynamicQueue(5);
        queue.insert(4);
        queue.insert(3);
        queue.insert(15);
        queue.insert(48);
        queue.insert(94);
        queue.insert(100);
        queue.display();

        System.out.println(queue.remove());

        queue.insert(133);

        queue.display();
    }
}
