package Level_01_Pepcoding;

public class Queues_Basics {

    // Introduction and Usages

//    public static void main(String[] args) {
//// Interface --> It means only declaration of a function. for ex Queue, Dequeue it is implemented by ArrayDequeue class.
//        // and ArrayDequeue has body of function which name can queue , dequeue etc.
//        Queue<Integer> q = new ArrayDeque<>();// here we can not make queue as new because it is just name or interface.
//        // for add or enq but java provides add for  add an element in queue/
//        // and remove for removing and peek() for top element
//        q.add(10);
//        System.out.println(q);
//        q.add(20);
//        System.out.println(q);
//        q.add(30);
//        System.out.println(q);
//        // for peek
//        System.out.println(q.peek());
//        System.out.println(q);
//        // for removing
//        q.remove();
//        System.out.println(q);
//        q.remove();
//        System.out.println(q);
//    }



    // Build Normal Queue


//    public static class customQueue{
//        int[] data;
//        int front;
//        int size;
//        public customQueue(int cap){
//            data = new int[cap];
//            front =0;
//            size = 0;
//        }
//        int size(){
//          return size;
//        }
//        void display(){
//          for(int i=0; i<size; i++){
//              int ind = (front+i)% data.length;// % for circular traversing
//              System.out.print(data[ind]+" ");
//          }
//            System.out.println();
//        }
//        void add(int val){
//          if(size == data.length){
//              System.out.println("Queue Overflow");
//          }else{
//              int rear = (front+size)% data.length;// % for circular traversing
//              data[rear] = val;
//              size++;
//          }
//        }
//        int remove(){
//            if(size == 0){
//                System.out.println("Queue Underflow");
//                return -1;
//                }else{
//                    int val  = data[front];
//                    front = (front + 1) % data.length;// % for circular traversing
//                    size--;
//                    return val;
//                }
//        }
//        int peek(){
//         if(size == 0){
//             System.out.println("Queue Underflow");
//             return -1;
//         }else{
//             return data[front];
//         }
//        }
//    }
//    public static void main(String[] args) {
//
//       customQueue c = new customQueue(5);
//       c.add(10);
//       c.add(20);
//       c.add(30);
//       c.add(40);
//       c.add(50);
//        c.display();
//      //  c.add(60);
//        c.remove();
//        c.remove();
//        c.add(60);
//        c.display();
//    }


    // Build Dynamic Queue.

        public static class customQueue{
        int[] data;
        int front;
        int size;
        public customQueue(int cap){
            data = new int[cap];
            front =0;
            size = 0;
        }
        int size(){
          return size;
        }
        void display(){
          for(int i=0; i<size; i++){
              int ind = (front+i)% data.length;// % for circular traversing
              System.out.print(data[ind]+" ");
          }
            System.out.println();
        }
        void add(int val){
          if(size == data.length){
              int[] ndata = new int[2* data.length];
              for(int i=0; i<size; i++){
                  int ind = (front+i)% data.length;
                  ndata[i] = data[ind];
              }
              data = ndata;
              front =0;
              int rear = (front+size)% data.length;// % for circular traversing
              data[rear] = val;
              size++;
          }else{
              int rear = (front+size)% data.length;// % for circular traversing
              data[rear] = val;
              size++;
          }
        }
        int remove(){
            if(size == 0){
                System.out.println("Queue Underflow");
                return -1;
                }else{
                    int val  = data[front];
                    front = (front + 1) % data.length;// % for circular traversing
                    size--;
                    return val;
                }
        }
        int peek(){
         if(size == 0){
             System.out.println("Queue Underflow");
             return -1;
         }else{
             return data[front];
         }
        }
    }
    public static void main(String[] args) {

       customQueue c = new customQueue(5);
       c.add(10);
       c.add(20);
       c.add(30);
       c.add(40);
       c.add(50);
        c.display();
      //  c.add(60);
        c.remove();
        c.remove();
        c.add(60);
        c.display();
        c.add(70);
        c.add(80);
        c.add(90);
        c.display();
    }
}
