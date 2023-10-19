package Level_01_Pepcoding;

import java.util.ArrayList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    // FOR INSERTION
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
        } else {
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int val, int ind) {
        if (ind < 0 || ind > size) {// if indexing is 1 based
            System.out.println("Invalid Index");
            return;
        }
        if (ind == 0) {
            insertFirst(val);
            return;
        }
        if (ind == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);// here temp.next is nothing but we store what is next value of curr node so
        // we can easily point new node and this works happens with the help of constructors.
        temp.next = node;
        size++;
    }

    // Insert Using Recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int ind, Node node) {

        if (ind == 0) {
            Node temp = new Node(val);
            temp.next = node;
            size++;
            return temp;
        }
        node.next = insertRec(val, ind - 1, node.next);
        return node;
    }

    // FOR DELETION

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size == 1) {
            return deleteFirst();
        }
        int val = tail.value;
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int ind) {
        if (ind == 0) {
            return deleteFirst();
        }
        if (ind == size - 1) {
            return deleteLast();
        }
        Node pre = get(ind - 1);
        int val = pre.next.value;
        pre.next = pre.next.next;
        size--;
        return val;
    }

    public Node get(int ind) {
        Node temp = head;
        for (int i = 0; i < ind; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //  for finding Node with the help of value
    public Node find(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    private class Node {
        private int value;
        private Node next;

        // constructor
        public Node(int value) {
            this.value = value;
        }
        public Node(){

        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    // Questions --> Remove Duplicates from a sorted linked list.

//    public void duplicatesRemove(){
//        Node temp = head;
//        while(temp.next!=null){
//            if (temp.value == temp.next.value) {
//                temp.next = temp.next.next;
//                size--;
//            }else{
//                temp = temp.next;
//            }
//        }
//        tail = temp;
//        tail.next = null;
//    }

    // Question --> Merge two Sorted linked List.

//    public static LL merge(LL first, LL second){
//        Node f = first.head;
//        Node s = second.head;
//        LL ans = new LL();
//        while(f!=null && s!=null){
//            if(f.value > s.value){
//                ans.insertLast(s.value);
//                s = s.next;
//            }else{
//                ans.insertLast(f.value);
//                f = f.next;
//            }
//        }
//        while(f!=null){
//            ans.insertLast(f.value);
//            f = f.next;
//        }
//        while(s!=null){
//            ans.insertLast(s.value);
//            s = s.next;
//        }
//        return ans;
//    }


    // Question --> Find the loop in the linked list.


//    public static boolean hasCycle(LL ll){
//        Node fast = ll.head;
//        Node slow = ll.head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(fast == slow){
//                return true;
//            }
//        }
//        return false;
//    }

    // Question --> Find the length of the loop in the linked list.

//    public static int lengthOfCycle(LL l){
//        Node fast = l.head;
//        Node slow = l.head;
//
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if(fast == slow){
//                // calculate the length
//                Node temp = slow.next;
//
//                int n=1;
//                while (temp!=fast){
//                    n++;
//                    temp = temp.next;
//                }
//                return n;
//            }
//        }
//        return 0;
//    }

    // Question --> Find the start Node into the loop.

//    public Node detectCucle(Node head) {
//        Node fast = head;
//        Node slow = head;
//        int length = 0;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == slow) {
//                // calculate the length
//                Node temp = slow.next;
//
//                int n = 1;// but we can use here a do while loop
//                while (temp != fast) {
//                    n++;
//                    temp = temp.next;
//                }
//                length = n;
//            }
//        }
//        if(length == 0){
//            return null;
//        }
//        // find the start node in loop
//        Node first = head;
//        Node second = head;
//        while(length>0){
//            second = second.next;
//            length--;
//        }
//        // keep moving as forward and they will as start node
//        while(first != second){
//            first = first.next;
//            second = second.next;
//        }
//        return first;
//
//    }


    // Question --> To check that given number is Happy or not. It is a Google question.

//    public boolean isHappy(int n){
//        int fast = n;
//        int slow = n;
//        do{
//            slow = calcSquare(slow);
//            fast = calcSquare(calcSquare(fast));
//        }while(fast!=slow);
//        if(slow == 1){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    private int calcSquare(int num){
//        int ans = 0;
//        while(num>0){
//            int rem = num%10;
//            ans+=rem*rem;
//            num /= 10;
//        }
//        return ans;
//    }


    // Find the middle node of the linked list.


//    public Node findMidNode(){
//        Node fast = head;
//        Node slow = head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }


    // Merge Sort for linked list.

    public void ans(){
        head = mergeSort(head);
      //  display();
    }
    public Node mergeSort(Node head){
       if(head == null || head.next == null){
         //  System.out.println("Its already Sorted");
           return head;
       }
       Node mid = findMidNode(head);
       Node left = head;
       Node right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
       return merge(left, right);
    }

    private Node findMidNode(Node head){
//        Node fast = head;
//        Node slow = head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        Node mid = slow.next;
//        slow.next = null;
//        return mid;

       Node slow = head, fast = head;
       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }

       return slow;
    }
//        private static LL merge(LL first, LL second){
//        Node f = first.head;
//        Node s = second.head;
//        LL ans = new LL();
//        while(f!=null && s!=null){
//            if(f.value > s.value){
//                ans.insertLast(s.value);
//                s = s.next;
//            }else{
//                ans.insertLast(f.value);
//                f = f.next;
//            }
//        }
//        while(f!=null){
//            ans.insertLast(f.value);
//            f = f.next;
//        }
//        while(s!=null){
//            ans.insertLast(s.value);
//            s = s.next;
//        }
//        return ans;
//    }

    public Node merge(Node n1, Node n2){
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        while(n1 != null && n2 != null){
            if(n1.value < n2.value){
                tail.next = n1;
                n1 = n1.next;
            }else{
               tail.next = n2;
               n2 = n2.next;
            }
            tail = tail.next;
        }

        tail.next = (n1 !=  null) ? n1 : n2;

        return dummyHead.next;
    }

    // One part of sorting is ramaining which is bubble sort in linked list but I will complete this
    // when I started kunal's video seriese from starting.
// Bubble sort

    public void bubbleSort(){
        bSort(size-1, 0);
    }
    public void bSort(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get(col);
            Node second = get(col+1);
            if(first.value > second.value){
                // swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){
                    Node prev = get(col-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }else{
                    Node prev = get(col-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bSort(row, col + 1);
        }else{
            bSort(row-1, 0);
        }
    }

    // Question --> Reversing of Linked List.

    // Using Recursion
    //   public void reverseRecAndIt(){
    //Node node = head;
    //reverse(node);
    //       reverseIt();
    //  }
//    private void reverse(){
//        if(node == tail){
//            head = tail;
//            return;
//        }
//        reverse(node.next);
//        tail.next = node;
//        tail = node;
//        tail.next = null;
//    }

    // in place reversel of linked list.
//    private void reverseIt(){
//       if(size<2){
//           return ;
//       }
//        Node prev = null;
//        Node curr = head;
//        Node next = curr.next;
//            while (curr!= null) {
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//
//                if(next!=null)
//                next = next.next;
//          }
//           head = prev;
//        }

    // Reverse just some part of the list.

//    public void reversePart(int left, int right){
//        if(left == right){
//            return;
//        }
//        // skip the first left-1 node.
//        Node curr = head;
//        Node prev = null;
//        for(int i=0; i<left-1 && curr.next!=null; i++){
//            prev = curr;
//            curr = curr.next;
//        }
//        Node last = prev;
//        Node newEnd = curr;
//        // reverse between l and r.
//        for (int i=0; i<right-left+1 && curr!=null; i++){
//            Node next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        if(last!=null){
//            last.next = prev;
//        }else{
//            head = prev;
//        }
//        newEnd.next = curr;
//    }


    // Question -->  Palindrome Linked list asked by many big companies.

    // first I will try to it my way. but in this code space complexity is not contant.

//    public boolean isPalindrome(){
//        if(head == null){
//            return false;
//        }
//        Node temp = head;
//        String str = "";
//        while(temp!=null){
//            str = str + temp.value;
//            temp = temp.next;
//        }
//        for(int i=0; i<str.length()/2; i++){
//            if(str.charAt(i) != str.charAt(str.length()-1-i)){
//                return false;
//            }
//        }
//        return true;
//    }

    // Second Method is reverse of half of the linked list and compare and again rereverse of half ll.


//    public boolean isPalindrome(){
//        Node mid = findMidNode(head);
//        Node headSecond = reverseList(mid);
//        Node rereverseHead = headSecond;
//        // compare both the half.
//        while(head!=null && headSecond!=null){
//            if(head.value != headSecond.value){
//                break;
//            }
//          head = head.next;
//          headSecond = headSecond.next;
//        }
//        reverseList(rereverseHead);
//        if(head==null || headSecond==null){
//            return true;
//        }else{
//            return false;
//        }
//    }
//        private Node findMidNode(Node head){
//        Node fast = head;
//        Node slow = head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//        private Node reverseList(Node node){
//        if(node == null){
//            return head;
//        }
//        Node prev = null;
//        Node curr = node;
//        Node next = curr.next;
//        while(curr!=null){
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//            if(next!=null){
//                next = next.next;
//            }
//        }
//        return prev;
//    }


    // Problem -->  Reordered List

    // Most Imporatant thing in LinkedList is that We need know about reversal and
    // slow fast pointer that is nothing but cycle detection.
    // These two things are continuously used in LL questions.


//    public void reorderedList(){
//        if(head == null || head.next == null){
//            return;
//        }
//        Node mid = getMid();
//        Node hs = reverseList(mid);
//        Node hf = head;
//        // rearrange
//        while(hf!=null && hs!=null){
//            Node temp = hf.next;
//            hf.next = hs;
//            hf = temp;
//            temp = hs.next;
//            hs.next = hf;
//            hs = temp;
//        }
//        // next of tail to null
//        if(hf!=null)hf.next=null;
//    }
//
//    private Node getMid(){
//        Node fast = head;
//        Node slow = head;
//        while(fast!=null && fast.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//    private Node reverseList(Node node){
//        if(node == null){
//            return node;
//        }
//        Node prev = null;
//        Node curr = node;
//        while(curr!=null){
//            Node ocn = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = ocn;
//        }
//        return prev;
//    }


    // Problem --> Reverse Nodes in K-Groups.(Leetcode --> Hard)
    // ise phir se dubara dekhna hai.

//    public void reverseNodeInKgroups(int k){
//        if(head == null || k<=1){
//            return ;
//        }
//        Node prev = null;
//        Node curr = head;
//        int j = 1;
//        while(curr!=null && (size/j)>=k){
//
//            Node last = prev;
//            Node newEnd = curr;
//            for(int i=0; i<k && curr!=null; i++){
//                Node ocn = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = ocn;
//            }
//            if(last!=null){
//                last.next = prev;
//            }else{
//                head = prev;
//            }
//            newEnd.next = curr;
//            prev = newEnd;
//            j++;
//        }
//        return;
//    }


    // Reverse Node in K groups with Alternate Manner


//    public void reverseNodeKgroupsAlter(int k){
//        if(k<=1 || head == null){
//            return ;
//        }
//        Node prev = null;
//        Node curr = head;
//        int j=1;
//        while(curr!=null && (size/j)>=k){
//            Node last = prev;
//            Node newEnd = curr;
//            for(int i=0; i<k && curr!=null; i++){
//                Node ocn = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = ocn;
//            }
//            if(last!=null){
//                last.next = prev;
//            }else{
//                head = prev;
//            }
//            newEnd.next = curr;
//            // Skip the k Nodes
//            for(int i=0; i<k && curr!=null; i++){
//                prev = curr;
//                curr = curr.next;
//            }
//           // prev = newEnd;
//
//            j+=2;
//        }
//    }

    // Reverse alternate nodes in Link List
// ise clear krna hai. And try using list.

//    public  void rearrange()
//    {
//        if(head.next==null){
//            return;
//        }
//        Node temp = head;
//
//        Node res = null;
//        while(temp.next!=null && temp.next.next!=null){
//            //store the next element
//            int val = temp.next.value;
//            //create a list of node which is deleted
//            Node node = new Node(val);
//            node.next =res;
//            res = node;
//            //delete node
//            temp.next = temp.next.next;
//            temp = temp.next;
//        }
//        //append in last
//        if(temp.next==null){
//            temp.next=res;
//        }
//        else{
//            temp.next.next=res;
//        }
//    }

    // Same question try to slove using List

// but here space complexity is not constant.

//    public void rearrange(){
//        if(head == null){
//            return;
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        Node temp = head;
//        while(temp.next!=null && temp.next.next!=null){
//            int val = temp.next.value;
//            temp.next = temp.next.next;
//            temp = temp.next;
//            list.add(0,val);
//        }
//        if(temp.next!=null){
//            list.add(0,temp.next.value);
//        }
//        for(int i=0; i<list.size() && temp!=null; i++){
//            Node node = new Node(list.get(i));
//            temp.next = node;
//            temp = node;
//        }
//        temp.next = null;
//    }

    // Question --> Rotate List.

//    public void rotateList(int k){
//        if(head == null || head.next==null || k<=0){
//            return;
//        }
//        k = k%size;
//
//        Node prev = null;
//        Node curr = head;
//        tail.next  = head;
//        for(int i=0; i<size-k && curr!=null; i++){
//            prev = curr;
//            curr = curr.next;
//        }
//        head = curr;
//        prev.next = null;
//        tail = prev;
//    }

     public void reverse(){
        Node k = reverse1(head);
     }
    private Node reverse1(Node node)
    {
        //Add your code here
        if(node == null){
            return  node;
        }

        Node  prev = null;
        Node curr = node;
        while(curr!=null){
            Node ocn = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ocn;
        }
          return prev;
    }
}

