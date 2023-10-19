package Stack_Queue_Interview_Questions;

import java.util.Stack;

public class Implement_Queue_Using_Stacks {

    // Here we need to use two stacks one is Main and second one is Helper

    // So according to the queue concept we can make two types of Queue using stacks
    // 1 -> Insertion Efficient
    // 2 -> Removing Efficient

    public static void main(String[] args) throws Exception {
        QueueUsingStack queue = new QueueUsingStack();
        queue.add(45);
        queue.remove();
        queue.peek();
        queue.isEmpty();
    }
}

 class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack(){
        first = new Stack<>();
        second = new Stack<>();
    }

    // If insertion Efficient

//     public void add(int item){
//        first.push(item);
//     }
//
//     public int remove() throws Exception{
//        while (!first.isEmpty()){
//            second.push(first.pop());
//        }
//
//       int removed = second.pop();
//
//        while ((!second.isEmpty())){
//            first.push(second.pop());
//        }
//
//        return removed;
//     }
//
//     public int peek() throws Exception{
//         while (!first.isEmpty()){
//             second.push(first.pop());
//         }
//
//         int peeked = second.peek();
//
//         while ((!second.isEmpty())){
//             first.push(second.pop());
//         }
//
//         return peeked;
//     }


     // Removing Efficient

     public void add(int item) throws Exception{
         while(!first.isEmpty()){
             second.push(first.pop());
         }
         first.push(item);
         while(!second.isEmpty()){
             first.push(second.pop());
         }
     }
     public int remove(){
         if(first.isEmpty()){
             return -1;
         }
         return first.pop();
     }
     public int peek(){
        if(first.isEmpty()){
            return -1;
        }
        return first.peek();
     }

     public boolean isEmpty(){
        return first.isEmpty();
     }
}
