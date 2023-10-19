package Hashing;
import java.util.HashSet;
import java.util.Iterator;
public class Hashset {
    /*
          HashSet in Java --> It's a important data structure due to this time complexity
                             for example : Insert/add -> (1)
                                           Search/contains -> O(1)
                                           Delete/Remove -> O(1)
     */

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // insert
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);
        // values are inserted in sorted order it's not a necessary thing it can be can't be
        // because set is an unOrdered list values can be in any manner.

        // Search -> contains function is used to doing searching

        if(set.contains(1)){
            System.out.println("Yes set contains 1");
        }else{
            System.out.println("Does not contains");
        }

        System.out.println(set.remove(1));
        // remove function will also return boolean value
        // If element is removed successfully then it will return true otherwise false


        // size of set
        System.out.println(set.size());


        // In set there is a special thing that is Iterator

        Iterator it = set.iterator();
        // this iterator has two important function that is
        // hashNext , and next.

        // next -> we can assume that at initial stage it is pointing to a null value
             //   after that if we write it.next() then we find our first element of the set and so on
      //  System.out.println(it.next());
      //  System.out.println(it.next());
     //   System.out.println(it.next()); if we go for the out of bound then it will throw an exception like there is no such next value

        // hashSet() -> It returns true or false value if next value is present in set then it will give true otherwise give false.
      //  System.out.println(it.hasNext());
      //  System.out.println(it.hasNext());
      //  System.out.println(it.hasNext());

        // using two things we can iterate over the set
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }


        // We can also iterate over set using this for each loop
//        for(Integer e : set){
//            System.out.println(e);
//        }
        // or
        for(int e : set){
            System.out.println(e);
        }
    }
}
