package Level_01_Hashmap_and_Heaps;

import javax.swing.text.ParagraphView;
import java.util.*;

public class V_10_Merge_K_Sorted_Lists {

    // In this problem we have given n lists with different sizes of integers, and all are sorted in non-decreasing order.
    // Now problem is that we have to merge all the lists into one lists which must be in sorted in non-decreasing order.

    // So, to solve this problem we will use priorityQueue, initially we will take first elements from all the lists and put into to queue.
    // Now, remove the elements from the PQ and which every element is going to remove we will add the next element of that list in to the PQ.
    // like this at the end we can find our merged list in sorted order.


    public static class Pair implements Comparable<Pair> {
        // to compare an object according to the value we have to right comparable class
        // Or I can use another way to do this thing in one line,
        int listInd;
        int dataInd;
        int val;
        Pair(int l, int d, int v){
            this.listInd = l;
            this.dataInd = d;
            this.val = v;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }

    // 1. Interface,
    // 2. which is nothing but contract of functions,
    // 3. Interface is look like as class in which only function names are existed not body of those functions which is in a particular Interface.
    // 4. Means, Interface only have name of functions and, signature of those functions means, return type, parameters etc.
    // 5. If a class is implementing an Interface it means in that class we have to give body of those functions which is in Interface.
    // 6. Note -> Means, When a class implement an Interface then that class says that,
    //         -> I will provide body for all functions named in Interface

    // Now next Question -> what is Comparable, this is nothing but an Interface which is already made in Java means predefined
    // And, PriorityQueue is used this Interface to compare two objects via compareTo function
    // As we know that PQ take smaller element at the peek(), so do it PQ have requirement of Comparable Interface.
    // In compareTo function which return type is Integer, Now, when value is returned +ve means this wala object is big if -ve, other wala big or 0 means equal.
    // Because in the case of Integer we can compare two things using <,>,== operators but not in case of Object that's why we have to do it via this way.
    // So, if PQ is for a class, then after PQ is done typecast of its content in to Comparable, and after that call function named as compareTo with Two objects parameter.




    public static void main(String[] args) {
      int n = 4;
        Integer[] l1 = {10,20,30,40,50};
        Integer[] l2 = {5,7,9,11,19,55,57};
        Integer[] l3 = {1,2,3};
        Integer[] l4 = {32,35};

      List<List<Integer>> lists = new ArrayList<>();
      for(int i = 0;i < n; i++)lists.add(new ArrayList<>());

      Collections.addAll(lists.get(0), l1);
      Collections.addAll(lists.get(1), l2);
      Collections.addAll(lists.get(2), l3);
      Collections.addAll(lists.get(3), l4);



   // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        // OR
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // via comparable class.
        ArrayList<Integer> ans = new ArrayList<>();

        // first step is that add the all first elements from every list into the PQ

        for(int i = 0; i < n; i++){
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            ans.add(p.val);
            p.dataInd++;
            if(p.dataInd < lists.get(p.listInd).size()){
                p.val = lists.get(p.listInd).get(p.dataInd);
                pq.add(p);
            }
        }

        System.out.println("Merged sorted list : " + ans);
    }
}
