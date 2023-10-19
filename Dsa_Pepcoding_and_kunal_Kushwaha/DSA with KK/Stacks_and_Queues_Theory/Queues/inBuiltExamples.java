package Stacks_and_Queues_Theory.Queues;

import java.util.*;

public class inBuiltExamples {
    public static void main(String[] args) {
//        Queue<Integer> queue = new Queue<Integer>() { // it is an Interface
//            // it internally works like as Linked List
//            @Override
//            public boolean add(Integer integer) {
//                return false;
//            }
//
//            @Override
//            public boolean offer(Integer integer) {
//                return false;
//            }
//
//            @Override
//            public Integer remove() {
//                return null;
//            }
//
//            @Override
//            public Integer poll() {
//                return null;
//            }
//
//            @Override
//            public Integer element() {
//                return null;
//            }
//
//            @Override
//            public Integer peek() {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator<Integer> iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public <T> T[] toArray(T[] a) {
//                return null;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection<? extends Integer> c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//        };

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(3);
//        queue.add(6);
//        queue.add(5);
//        queue.add(19);
//        queue.add(1);
//
//        System.out.println(queue);
//
//        System.out.println(queue.peek());// it's only get the head element of queue but didn't remove it.
//
//        System.out.println(queue.remove());
//        System.out.println(queue);
//
//        System.out.println(queue.poll());
//        System.out.println(queue);


        // Deque
        // Here in this we can insert and remove from the both side of the Queue
        // NULL elements not allowed here. no capacity restriction and it is faster than linkedList Queue.
        // to create Deque object we use ArrayDeque

        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(89);
        deque.addLast(78);
        deque.addFirst(98);
        deque.removeLast();
        deque.removeFirst();
        deque.remove();// same as removeFirst.

        System.out.println(deque);
    }
}
