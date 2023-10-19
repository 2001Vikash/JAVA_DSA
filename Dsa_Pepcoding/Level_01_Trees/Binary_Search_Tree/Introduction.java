package Level_01_Trees.Binary_Search_Tree;

import java.util.ArrayList;

public class Introduction {

    /*
      BST ->  For All nodes this property must be true
              that is left node value < right node value
              so what is advantage of this
              basically main advantage is that searching is faster than other trees.
              at the time of searching always go for the target directly like laser guided missile.
              /
              complexity for the searching will be complete in log(n).

         something is similar like Binary tree
         for ex. -> size , sum , diameter are dependent on structure of tree means will take same time
         but if we are talking about min, max, find will have optimal solution that is log n but in
         Binary tree it will take O(n) time.
             */

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(ans, list);
//        System.out.println(ans);
//        System.out.println(list);
    }
    public static void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        for(int i = 1; i <= 10; i++){
            if(i % 5 == 0){
                System.out.println(list);
                ans.add(new ArrayList<>(list));// if we do not make new then whatever we put it on index 0 in ans that will
                // also changed in the last due to same object and they are pointing to same place that's why changed will also show.
                System.out.println(ans);
            }
            list.add(i);
        }
    }
}
