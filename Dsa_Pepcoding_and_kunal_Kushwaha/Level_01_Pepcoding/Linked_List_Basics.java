package Level_01_Pepcoding;

public class Linked_List_Basics {

    // Introduction to Linked List. And Data members and how we can make it.

//    public static class Node{
//        int data;
//       Node next;
//    }
//    public static class LinkedList{
//        Node head;
//        Node tail;
//        int size;
//    }
//    public static void main(String[] args) {
//
//    }

    // Add last Display and size in a Linked List.

//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class LinkedList{
//        Node head;
//        Node tail;
//        int size;
//        void addLast(int val) {
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if (size == 0) {
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//        int size(){
//            return size;
//        }
//        void display(){
//            Node temp = head;
//            while(temp != null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        LinkedList l = new LinkedList();
//        l.addLast(10);
//        l.addLast(20);
//        l.display();
//    }



    // Remove First from Linked List

//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class LinkedList{
//        Node head;
//        Node tail;
//        int size;
//        int size(){
//            return size;
//        }
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//        void display(){
//            Node temp = head;
//            while(temp != null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//        void removeFirst(){
//            if(size == 0){
//                System.out.println("Empty Linked List");
//            }else if(size == 1){
//                head = tail = null;
//                size = 0;
//            }else{
//                head = head.next;
//                size--;
//            }
//        }
//    }
//    public static void main(String[] args) {
//       LinkedList l = new LinkedList();
//       l.addLast(10);
//       l.addLast(20);
//        System.out.println(l.size());
//        l.display();
//        l.removeFirst();
//        l.display();
//        l.removeFirst();
//       // l.display();
//        l.removeFirst();
//    }


    // Get Value in a Linked List.

//    public static class Node{
//        int data ;
//        Node next;
//    }
//    public static class LinkedList{
//        Node head;
//        Node tail;
//        int size;
//        int getSize(){
//            return size;
//        }
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//        void removeFirst(){
//            if(size == 0){
//                System.out.println("Empty List");
//            }else if(size == 1){
//                head = tail = null;
//                size = 0;
//            }else{
//                head = head.next;
//                size--;
//            }
//        }
//        int getFirst(){
//            if(size == 0){
//                System.out.println("Empty List");
//                return -1;
//            }else{
//                return head.data;
//            }
//        }
//        int getLast(){
//            if(size == 0){
//                System.out.println("Empty List");
//                return -1;
//            }else{
//                return tail.data;
//            }
//        }
//        int getAtAnyIndex(int ind){
//            if(size == 0){
//                System.out.println("Empty List");
//                return -1;
//            }
//            else if(ind >= size || ind < 0){
//                System.out.println("Wrong index out of bound");
//                return -1;
//            }else{
//                Node temp = head;
//                for(int i=0; i<ind; i++){
//                    temp = temp.next;
//                }
//               return temp.data;
//            }
//        }
//        void display(){
//            Node temp = head;
//            while(temp != null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        LinkedList l = new LinkedList();
//       l.addLast(10);
//       l.addLast(20);
//       l.addLast(30);
//        System.out.println(l.getSize());
//        l.display();
//        System.out.println(l.getFirst());
//        System.out.println(l.getLast());
//        System.out.println( l.getAtAnyIndex(1));
//        l.removeFirst();
//        l.display();
//        l.removeFirst();
//        l.display();
//        l.removeFirst();
//        l.display();
//        l.removeFirst();
//    }


//    Add First in the Linked List.


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList{
//        Node head;
//        Node tail;
//        int size = 0;
//        void addFirst(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = head;
//            head = temp;
//            if(size == 0){
//                tail = head;
//            }
//                size++;
//            }
//        void display(){
//            Node temp = head;
//           for(int i=0; i<size; i++){
//               System.out.print(temp.data+" ");
//               temp = temp.next;
//           }
//            System.out.println();
//        }
//        }
//
//    public static void main(String[] args) {
//       linkedList l = new linkedList();
//       l.addFirst(10);
//       l.display();
//       l.addFirst(20);
//       l.display();
//       l.addFirst(30);
//       l.display();
//       l.addFirst(40);
//       l.display();
//    }


    // Add at Index in Linked List


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList{
//        Node head;
//        Node tail;
//        int size;
//        void addFirst(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = head;
//            head = temp;
//            if(size == 0){
//                tail = head;
//            }
//                size++;
//            }
//            void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//        void addAtAnyIndex(int ind, int val){
//            Node temp = new Node();
//
//            if(ind == 0){
//              addFirst(val);
//            }else if(ind > size || ind<0){
//                System.out.println("Invalid Argument");
//            }
//            else if(ind == size){
//// iske bina bhi work ho ja rha hi
//            addLast(val);
//            }
//            else{
//                Node t = head;
//                for(int i=0; i<ind-1; i++){
//                    t=t.next;
//                }
//                temp.data = val;
//                temp.next = t.next;
//                t.next = temp;
//                size++;
//            }
//        }
//        void display(){
//            Node temp = head;
//            while(temp!=null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        linkedList l = new linkedList();
//        l.addAtAnyIndex(0,10);
//        l.addAtAnyIndex(1,20);
//        l.addAtAnyIndex(2,30);
//        l.display();
//        l.addAtAnyIndex(1,140);
//        l.display();
//        l.addAtAnyIndex(2,67);
//        l.display();
//        l.addAtAnyIndex(4,233);
//        l.display();
//        l.addAtAnyIndex(0,455);
//        l.display();
//        l.addAtAnyIndex(7,56);
//        l.display();
//    }


    // Remove lats in linked list


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList{
//        Node head;
//        Node tail;
//        int size;
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//        int removeInLast(){
//            if(size == 0){
//                System.out.println("List is empty");
//                return -1;
//            }else if(size == 1){
//                int val = head.data;
//                head = tail = null;
//                size = 0;
//                return val;
//            }else{
//                Node temp = head;
//                for(int i=0; i<size-2; i++){// chunki last ind is size-1 and second last is size-2.
//                    temp = temp.next;
//                }
//                int val = tail.data;
//                temp.next = null;
//                tail = temp;
//                //tail.next = null;// both are correct.
//                size--;
//                return val;
//            }
//        }
//                void display(){
//            Node temp = head;
//            while(temp!=null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        linkedList l = new linkedList();
//        l.addLast(10);
//        l.addLast(20);
//        l.addLast(30);
//        l.display();
//        System.out.println(l.removeInLast());
//        l.display();
//    }


    // Remove at any index

//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList {
//        Node head;
//        Node tail;
//        int size;
//
//        void display() {
//            Node temp = head;
//            while (temp != null) {
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//
//        void removeFirst() {
//            if (size == 0) {
//                System.out.println("Empty List");
//            } else if (size == 1) {
//                head = tail = null;
//                size = 0;
//            } else {
//                head = head.next;
//                size--;
//            }
//        }
//
//        int removeInLast() {
//            if (size == 0) {
//                System.out.println("List is empty");
//                return -1;
//            } else if (size == 1) {
//                int val = head.data;
//                head = tail = null;
//                size = 0;
//                return val;
//            } else {
//                Node temp = head;
//                for (int i = 0; i < size - 2; i++) {// chunki last ind is size-1 and second last is size-2.
//                    temp = temp.next;
//                }
//                int val = tail.data;
//                temp.next = null;
//                tail = temp;
//                //tail.next = null;// both are correct.
//                size--;
//                return val;
//            }
//        }
//        void removeAtAnyIndex(int ind){
//            if(ind>=size || ind<0){
//                System.out.println("Invalid argument");
//            }
//            else if(ind == 0){
//                removeFirst();
//            }else if(ind == size-1){
//                removeInLast();
//            }else{
//                Node temp = head;
//                for(int i=0; i<ind-1; i++){
//                    temp = temp.next;
//                }
//                temp.next = temp.next.next;
//                size--;
//            }
//        }
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//    }
//
//    public static void main(String[] args) {
//        linkedList l = new linkedList();
//        l.addLast(10);
//        l.addLast(20);
//        l.addLast(30);
//        l.addLast(40);
//        l.addLast(50);
//        l.display();
//        l.removeAtAnyIndex(2);
//        l.display();
//        l.removeAtAnyIndex(0);
//        l.display();
//        l.removeAtAnyIndex(2);
//        l.display();
//    }


    // REVERSE A LINKED LIST DATA ITERATIVE


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList{
//        Node head;
//        Node tail;
//        int size;
//        void addLast(int val){
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if(size == 0){
//                head = tail = temp;
//            }else{
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//        }
//       void display(){
//            Node temp = head;
//            while(temp!=null){
//                System.out.print(temp.data+" ");
//                temp = temp.next;
//            }
//           System.out.println();
//       }
//       private Node getNodeAt(int inx){// isko kewal class me hi use kr skte hai main se call nhi kr sakte hai
//            Node temp = head;
//            for(int i=0; i<inx; i++){
//                temp = temp.next;
//            }
//            return temp;// yaha pr node ko return krna hai
//       }
//       void reverseLinkedList(){
//            // using data properties means without using next node.
//           int li = 0;
//           int ri = size-1;
//           while(li<ri){
//               Node left = getNodeAt(li);
//               Node right = getNodeAt(ri);
//               // using swapping properties.
//               int temp = left.data;
//               left.data = right.data;
//               right.data = temp;
//               li++;
//               ri--;
//           }
//       }
//    }
//    public static void main(String[] args) {
//        linkedList l = new linkedList();
//        l.addLast(10);
//        l.addLast(20);
//        l.addLast(30);
//        l.addLast(40);
//        l.addLast(50);
//        l.display();
//        l.reverseLinkedList();
//        l.display();
//    }


    // REVERSE A LINKED LIST POINTER ITERATIVE


//    public static class Node{
//        int data;
//        Node next;
//    }
//    public static class linkedList {
//        Node head;
//        Node tail;
//        int size;
//        void addLast(int val) {
//            Node temp = new Node();
//            temp.data = val;
//            temp.next = null;
//            if (size == 0) {
//                head = tail = temp;
//
//            } else {
//                tail.next = temp;
//                tail = temp;
//            }
//            size++;
//
//        }
//
//        void display() {
//            Node temp = head;
//            while (temp != null) {
//                System.out.print(temp.data + " ");
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//        void reverseLinkedList(){
//            // using pointer iterative.
//
//            Node curr = head;
//            Node prev = null;
//            for(int i=0; i<size; i++){
//                Node ocn = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = ocn;
//
//            }
//            Node temp = head;
//            head = tail;
//            tail = temp;
//        }
//    }
//
//    public static void main(String[] args) {
//        linkedList l = new linkedList();
//        l.addLast(10);
//        l.addLast(20);
//        l.addLast(30);
//        l.addLast(40);
//        l.addLast(50);
//        l.display();
//       l.reverseLinkedList();
//        l.display();
//    }


}
