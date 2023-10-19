package Level_01_Pepcoding;

import org.w3c.dom.Node;

public class LinkedList_by_Kunal_Kushwaha {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//
//        list.display();
//
//        list.insertLast(14);
//        list.insertLast(15);
//
//        list.display();
//
//        list.insert(103,3);
//        list.display();
//
//        list.insertRec(88,2);
//        list.display();
//
//        System.out.println(list.deleteFirst());
//        list.display();
//
//        System.out.println(list.deleteLast());
//        list.display();
//
//        System.out.println(list.delete(2));
//        list.display();
//
//        System.out.println(list.find(3));
//
//        DLL list = new DLL();
//                list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.display();
//
//        list.insertLast(30);
//        list.display();
//
//        list.insert(8,65);
//        list.display();

//        CLL list = new CLL();
//        list.insertLast(10);
//        list.insertLast(20);
//        list.insertLast(30);
//        list.insertLast(40);
//        list.display();
//
//        System.out.println(  list.delete(10));
//        list.display();


        // Remove Duplicates from a sorted linked list.


//        LL list = new LL();
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(4);
//        list.insertLast(4);
//
//        list.display();
//        list.duplicatesRemove();
//        list.display();

        // Merge two Sorted linked List.

//        LL list1 = new LL();
//        list1.insertLast(1);
//        list1.insertLast(3);
//        list1.insertLast(5);
//
//        LL list2 = new LL();
//        list2.insertLast(1);
//        list2.insertLast(2);
//        list2.insertLast(9);
//        list2.insertLast(14);
//
//        LL ans =  LL.merge(list1, list2);
//           ans.display();

        // Find the loop in the linked list.

//          LL l = new LL();
//          l.insertLast(1);
//          l.insertLast(2);
//          l.insertLast(3);
//          l.insertLast(4);
//          l.insertLast(5);
//          l.insertLast(3);
//        System.out.println(LL.hasCycle(l));

        // Find the length of the loop in the linked list.

//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(3);
//        System.out.println(LL.lengthOfCycle(l));

        // Find start Node in the loop
        // I need to solve this problem from the websites


        // Question --> To check that given number is Happy or not. asked by Google.
        // in this question we can not identify directly using of linked list loop method.
        // but here it is.
//        LL l = new LL();
//        System.out.println(l.isHappy(19));

        // Find the mid Node of LL
        // we can use it in websites

       // Merge Sort in Linked List
// One part of sorting is ramaining which is bubble sort in linked list but I will complete this
        // when I started kunal's video seriese from starting.

        LL l = new LL();
        l.insertLast(10);
        l.insertLast(2);
        l.insertLast(9);
        l.insertLast(7);
        l.insertLast(5);
        l.insertLast(6);
        l.insertLast(4);
        l.insertLast(8);
        l.insertLast(3);
        l.insertLast(1);
        l.display();
     //   l.mergeSort()
       // l.ans();
        l.bubbleSort();
        l.display();

        // Question --> Reversing of Linked List.

        // Using Recursion
//        LL l = new LL();
//          l.insertLast(50);
//          l.insertLast(40);
//          l.insertLast(30);
//          l.insertLast(20);
//          l.insertLast(10);
//          l.display();
//    //  l.reverseRecAndIt();
//          l.reversePart(2,4);
//          l.display();


        // Palindrome Linked list
//        LL l = new LL();
//          l.insertLast(1);
//          l.insertLast(2);
//          l.insertLast(3);
//          l.insertLast(2);
//          l.insertLast(1);
//          l.display();
//        System.out.println(l.isPalindrome());


        // Problem -->  Reordered List
//
//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.display();
//        l.reorderedList();
//        l.display();


      // Reverse Node in K groups

//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(6);
//        l.insertLast(7);
//        l.insertLast(8);
//        l.display();
//        l.reverseNodeInKgroups(3);
//        l.display();

        // Reverse Node in K groups with Alternate Manner

//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(6);
//        l.insertLast(7);
//        l.insertLast(8);
//        l.insertLast(9);
//        l.insertLast(10);
//        l.display();
//        l.reverseNodeKgroupsAlter(3);
//        l.display();

        // reverse Alternate Node.

//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(6);
//        l.insertLast(7);
//        l.insertLast(8);
//        l.insertLast(9);
//        //l.insertLast(10);
//        l.display();
//        l.rearrange();
//        l.display();

        // Rotate List

//        LL l = new LL();
//        l.insertLast(1);
//        l.insertLast(2);
//        l.insertLast(3);
//        l.insertLast(4);
//        l.insertLast(5);
//        l.insertLast(6);
//        l.insertLast(7);
//        l.insertLast(8);
//        l.insertLast(9);
//        l.insertLast(10);
//        l.display();
//       // l.rotateList(3);
//        l.reverse();
//        l.display();
    }
}
