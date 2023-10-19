package Level_01_Pepcoding;
import java.lang.reflect.Array;
import java.util.*;
public class Linked_List_Next_From_Basic {

    // Linked List to Stack Adapter --> means linked list behaves as stack.


/* so basically in linked list we have 4 major things.

    addLast   removeLast    getLast --> it is inferior for use because in removeLast we have not time complexity O(1).
                                                    but in case of java it seems like O(1). but we assume that it's not equal to O(1).
                                                    but here we see that removeLast which is coding by us not java.
    addFirst  removeFirst  getFirst --> it is superior because we know that in case of first time complexity is O(1) everywhere.
     */

//    public static class LLtoStackAdapter{
//        LinkedList<Integer> list ;
//        public LLtoStackAdapter(){
//            list = new LinkedList<>();
//        }
//        int size(){
//            return  list.size();
//        }
//        void push(int val){
//            list.addFirst(val);
//        }
//        int pop(){
//            if(size() == 0){
//                System.out.println("Stack Underflow ");
//                return -1;
//            }else{
//                return list.removeFirst();
//            }
//        }
//        int top(){
//            if(size() == 0){
//                System.out.println("Stack Underflow");
//                return -1;
//            }else{
//                return list.getFirst();
//            }
//        }
//        void display(){
//            int k = size();
//            while(k!=0){
//                System.out.print(pop()+" ");
//                k--;
//            }
//        }
//    }
//    public static void main(String[] args) {
//       LLtoStackAdapter st = new LLtoStackAdapter();
//       st.push(10);
//       st.push(20);
//       st.push(30);
//       st.display();
//    }


    // Linked List to Queue Adapter

//    public static class LLtoQueueAdapter{
//        LinkedList<Integer> list;
//       public  LLtoQueueAdapter(){
//            list = new LinkedList<>();
//        }
//        int size(){
//           return list.size();
//        }
//        void add(int val){
//            list.addLast(val);
//        }
//        int remove(){
//           if(size()==0){
//               System.out.println("Queue Underflow");
//               return -1;
//           }else{
//               return list.removeFirst();
//           }
//        }
//        int peek(){
//            if(size()==0){
//                System.out.println("Queue Underflow");
//                return -1;
//            }else{
//                return list.getFirst();
//            }
//        }
//    }
//    public static void main(String[] args) {
//        LLtoQueueAdapter q = new LLtoQueueAdapter();
//        q.add(10);
//        q.add(20);
//        System.out.println(q.remove());
//        System.out.println(q.peek());
//        q.add(30);
//        System.out.println(q.remove());
//        System.out.println(q.peek());
//    }
    // NOTE --> PASCAL'S TRIANGLE ON GFG NHI BNA HAI.


    // Kth element from the end in the linked list.
// But here constraints is that we can not use size properties. and we need to use iteration method.

//    public static class Node {
//        int data;
//        Node next;
//    }
//    public static class kthElementFromEnd{
//        Node head;
//        Node tail;
//
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//          if(head == null){
//              head = tail = temp;
//          }else{
//              tail.next = temp;
//              tail = temp;
//          }
//        }
//        int kthNode(int k){
//            Node fast = head;
//            Node slow = head;
//            for(int i=0; i<k; i++){
//                fast = fast.next;
//            }
//            while(fast!=tail){
//                fast = fast.next;
//                slow = slow.next;
//            }
//            return slow.data;
//        }
//    }
//    public static void main(String[] args) {
//       kthElementFromEnd ans = new kthElementFromEnd();
//       ans.addLast(10);
//       ans.addLast(20);
//       ans.addLast(30);
//       ans.addLast(40);
//       ans.addLast(50);
//       int k=1;
//        System.out.println(ans.kthNode(k));
//    }


    // Mid of a Linked List without using of size of the list.


//    public static class Node{
//        int data;
//        Node next;
//        Node head;
//        Node tail;
//        int size;
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(head == null){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//        }
//        int midElement(){
//            Node fast = head;
//            Node slow = head;
//            while (fast.next!=null && fast.next.next!=null){// both cases helps us foe odd and even cases.
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            return slow.data;
//        }
//        void display(){
//        Node temp = head;
//        while(temp!=null) {
//            System.out.print(temp.data+" ");
//            temp = temp.next;
//        }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        Node n = new Node();
//        n.addLast(10);
//        n.addLast(20);
//        n.addLast(30);
//        n.addLast(40);
//        n.display();
//        System.out.println(n.midElement());
//    }


    // Merge two sorted Linked List

    // ye code clear nhi bn pa rha hai.


//    public static class Node {
//        int data;
//        Node next;
//    }
//    public static class LinkedListNew{
//        Node head;
//        Node tail;
//
//
//        public static LinkedList<Integer> mergeTwoSortedList(LinkedList l1, LinkedList l2) {
//            LinkedList ans = new LinkedList();
//            Node one = l1.head;
//            Node two = l2.head;
//            return ans;
//        }
//    }
//    public static void main(String[] args) {
//        LinkedListNew l = new LinkedListNew();
//       LinkedList l1 = new LinkedList();
//       int n = 5;
//       for(int i=0; i<n; i++){
//           int p = 10;
//           l1.addLast(p);
//           p+=10;
//       }
//        LinkedList l2 = new LinkedList();
//        int m = 7;
//        for(int i=0; i<m; i++){
//            int p = 7;
//            l1.addLast(p);
//            p+=10;
//        }
//    }


    /* Java program to merge two
sorted linked lists */
//import java.util.*;

    /* Link list node */
//    class Node
//    {
//        int data;
//        Node next;
//        Node(int d) {data = d;
//            next = null;}
//    }
//
//    class MergeLists
//    {
//        Node head;
//
//        /* Method to insert a node at
//        the end of the linked list */
//        public void addToTheLast(Node node)
//        {
//            if (head == null)
//            {
//                head = node;
//            }
//            else
//            {
//                Node temp = head;
//                while (temp.next != null)
//                    temp = temp.next;
//                temp.next = node;
//            }
//        }
//
//        /* Method to print linked list */
//        void printList()
//        {
//            Node temp = head;
//            while (temp != null)
//            {
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//
//
//        // Driver Code
//        public static void main(String args[])
//        {
//	/* Let us create two sorted linked
//	lists to test the methods
//	Created lists:
//		llist1: 5->10->15,
//		llist2: 2->3->20
//	*/
//            MergeLists llist1 = new MergeLists();
//            MergeLists llist2 = new MergeLists();
//
//            // Node head1 = new Node(5);
//            llist1.addToTheLast(new Node(5));
//            llist1.addToTheLast(new Node(10));
//            llist1.addToTheLast(new Node(15));
//
//            // Node head2 = new Node(2);
//            llist2.addToTheLast(new Node(2));
//            llist2.addToTheLast(new Node(3));
//            llist2.addToTheLast(new Node(20));
//
//
//            llist1.head = new Gfg().sortedMerge(llist1.head,
//                    llist2.head);
//            llist1.printList();
//
//        }
//    }
//
//    class Gfg
//    {
//        /* Takes two lists sorted in
//        increasing order, and splices
//        their nodes together to make
//        one big sorted list which is
//        returned. */
//        Node sortedMerge(Node headA, Node headB)
//        {
//
//	/* a dummy first node to
//	hang the result on */
//            Node dummyNode = new Node(0);
//
//	/* tail points to the
//	last result node */
//            Node tail = dummyNode;
//            while(true)
//            {
//
//		/* if either list runs out,
//		use the other list */
//                if(headA == null)
//                {
//                    tail.next = headB;
//                    break;
//                }
//                if(headB == null)
//                {
//                    tail.next = headA;
//                    break;
//                }
//
//		/* Compare the data of the two
//		lists whichever lists' data is
//		smaller, append it into tail and
//		advance the head to the next Node
//		*/
//                if(headA.data <= headB.data)
//                {
//                    tail.next = headA;
//                    headA = headA.next;
//                }
//                else
//                {
//                    tail.next = headB;
//                    headB = headB.next;
//                }
//
//                /* Advance the tail */
//                tail = tail.next;
//            }
//            return dummyNode.next;
//        }
//    }
//
//// This code is contributed
//// by Shubhaw Kumar


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class LL{
//        Node head;
//        Node tail;
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(head == null){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//        }
//        void diplay(){
//            Node temp = head;
//            while(temp!=null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//        public static LinkedList mergeToSortedLL(LinkedList l1, LinkedList l2){
//            LinkedList res = new LinkedList();
//            return res;
//        }
//    }
//    public static void main(String[] args) {
//        // First Linked List
//       LL l1 = new LL();
//        l1.addLast(10);
//        l1.addLast(20);
//        l1.addLast(30);
//        l1.diplay();
//     // Second Linked List
//        LL l2 = new LL();
//        l2.addLast(10);
//        l2.addLast(20);
//        l2.addLast(30);
//        l2.diplay();
//
//    }

    // Important Notes --> We need to learn merge implementing rule in intelliJ.

    public static void main(String[] args) {
        int l=0,k=1;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(5);
        int[] arr  = {1,2,3};
        while(l!=k){
            int n= a.get(a.size()-1);
            a.set(0,n);
            //System.out.println(a.get(0)+" ");
            for(int i=1; i<a.size(); i++){
             //   int m = a.get(i-1);
                 a.set(i,arr[i-1]);
                System.out.print(a.get(i)+" ");
            }
            l++;
        }
    }
}
