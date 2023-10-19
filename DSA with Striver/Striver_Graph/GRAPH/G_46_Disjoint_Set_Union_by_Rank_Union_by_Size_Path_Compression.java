package GRAPH;

import java.util.ArrayList;
import java.util.List;

public class G_46_Disjoint_Set_Union_by_Rank_Union_by_Size_Path_Compression {

    // Disjoint Set data structure is the most important topic in Graph. It is commonly asked in all interviews and in Online assessment as well.

    /* Why do we use this DS, for ex. if we have two graph components like that 1->2->3, and 5->6, Is 1 connected to the 5 or not.
     for this we will do simple BFS/DFS that will take O(V+E) time that is linear time and approach is Brute force as well
     So, to solve this problem Disjoint set will take constant time only. SO, via this DS we can do this work in constant time and that is the use case of this st.
     Note -> It is usually used in Dynamic graph means if graph is keep on changing its configuration at every moment.

     There are two functionalities done by this Disjoint set -> 1. findParent(), 2. Union().=> this union can be done by two methods -> 1. Rank, 2. Size.
     If we see the work of union generally then we can say that if we have two nodes or graph which is not connected then to connect them we have to use union
     At the time of doing this thing we can see that graph is changing itself continuously, but as we know that graph formation is happened like this, then
     what is difference, Now difference is at any stage someone can ask question and, we have to give answer in constant time that is what disjoint set will do.
   */

    // Let us see that implementation of Disjoint Set data structure.

    // Now, let us firstly see, the implementation of Union by Rank.
    // In order to do it we have requirement of two things one is Rank array and second one will parent array which will serve for finding the parents.
    // We assign both array with the no. of nodes in the graph.
    // Rank array will be initialized with 0, because Rank means how many nodes are coming beneath/down with the current node we will see it further next.
    // And parent array will be initialized with same node because every node is like as parent for itself initially. Parent means right above the current node.

    // To do union(u,v) => 1. find ultimate parent of u&v like as pu,pv-> pu means ultimate parent for u and same for pv.
    //                  => 2. find the rank of ultimate parents that is pu & pv.
    //                  => 3. Connect smaller rank to larger rank always and in case of equality we can connect anyone.
    // Ultimate parent means -> We have a bunch of nodes, and guy who at the top of all that will be known as ultimate parent.
    // If two nodes are connecting then height will be increased so, in this case rank will also be increased.
    // Basically we are creating a different data structure rather graph.
    // And, ultimate parent will help to find that two nodes are connected or not. if both have different ultimate parent then we will say that they are not connected.
    // And, for this things findParent() will help. but to find the ultimate parent in case of union by rank TC will be taken as log(n), but
    // how do we tell this answer in constant time if it is taking log(n) TC to find the ultimate parent.

    // So, to achieve that we apply something as Path Compression.
    // that is nothing but instead of connecting every node to their parents we will connect every node to their ultimate parent node.
    // But one catch is here that if we attach everyone to its ultimate parents then all are coming at same level means rank are same.
    // But, we will not decrease rank, and that is why we are calling it as rank not height because at the time path compression height will be decreased.
    // So generally rank in the sense a guy which is having higher rank that will bigger than who is having lower rank that's it.
    // And as we know that rank will be changed only if two nodes are connecting with same rank.

    // TC for the union by rank => O(4*alpha)(very huge mathematical calculation to find it),
    // alpha value is very, very less. means we can assume it as O(constant). and in order to find findParent() TC will be O(4*alpha).

    //Note -> So overall we can say that Disjoint set data structure works in O(4*alpha).

    // for path compression we will do recursion and at the time of returning we will store that things at place of parent.


    // Why are we connecting to smaller to larger ?
    // first thing is that we do not want to increase the height, because if we add larger to smaller then, height will be increased.
    // that will take more distance to find ultimate parent, do it on pen and paper. means more nodes will take longer time of-course
    // we are doing path compression but for that we have to travel, if larger will connect to smaller then, it will be increased for more nodes. but in reverse it will be fine.
    // Means, if we attach smaller to larger then, whichever node is having via larger that will be taken same time as previous and for smaller it will be increased which is having less, number of nodes.





    public static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
       public DisjointSet(int n){
            // this is constructor.
           for(int i = 0; i <= n; i++){
               // we are going till n because it will handle both cases like 0-based and 1-based indexing.
               rank.add(0);
               parent.add(i);
           }
        }

      public int findPar(int node){
           if(node == parent.get(node)){
               return node;
           }
          // return parent.set(node, findPar(parent.get(node)));

          // OR -> both are working.

           int ulp = findPar(parent.get(node));
           parent.set(node, ulp);
           return parent.get(node);
       }

       public void unionByRank(int u, int v) {
           int ulp_u = findPar(u);
           int ulp_v = findPar(v);
           if (ulp_u == ulp_v) return; // if both are related to same ulp means there is no need for union.

           if (rank.get(ulp_u) < rank.get(ulp_v)) {
               parent.set(ulp_u, ulp_v);
           } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
               parent.set(ulp_v, ulp_u);
           } else {
               parent.set(ulp_u, ulp_v);
               rank.set(ulp_u, rank.get(ulp_u) + 1);
           }
       }

    }

    // Now let us understand that can we do it via size means union via size -> Yes.

    // So initial configuration will look like, we have two arrays one is size initialized with 1, because every is having 1 size that is itself. and
    // second will be parent array and, that will be initialized like previous.
    // We will do same thing as previous but here in the term of size.
    // and this is keeping a track of how is it big. means we will not increase size by at the time of connecting two nodes, we will add size of smaller into larger.
    // This is more intuitive than rank method because rank is distorted means we are storing something and meaning is different.(distorted -> wrapped)
    // In case of rank if both is having different rank then rank will be remained same but in case of size we will increase size with the smaller size.

    public static class DisjointSetViaUnionBySize{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSetViaUnionBySize(int n){
            // this is constructor.
            for(int i = 0; i <= n; i++){
                // we are going till n because it will handle both cases like 0-based and 1-based indexing.
                size.add(1);
                parent.add(i);
            }
        }

        public int findPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            // return parent.set(node, findPar(parent.get(node)));

            // OR -> both are working.

            int ulp = findPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);
            if (ulp_u == ulp_v) return; // if both are related to same ulp means there is no need for union.

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));// means parent wale ki size big ho gayi.
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
                // there is no any case of else because in else case we will attach and increase the size so, this will do work for both case.
            }
        }

    }

    public static void main(String[] args) {
        // if we want to make two different DS for diff. graph then we can make two objects of DisjointSet.

//        DisjointSet ds = new DisjointSet(7); // 1-based indexing, here n is number of nodes.
//        ds.unionByRank(1,2);
//        ds.unionByRank(2,3);
//        ds.unionByRank(4,5);
//        ds.unionByRank(6,7);
//        ds.unionByRank(5,6);

        // Do not use both together like by rank and by size, use one.

        DisjointSetViaUnionBySize ds = new DisjointSetViaUnionBySize(7);
            ds.unionBySize(1,2);
            ds.unionBySize(2,3);
            ds.unionBySize(4,5);
            ds.unionBySize(6,7);
            ds.unionBySize(5,6);


        // before adding 3,7 let us check that both are belong to same component or not.
        if(ds.findPar(3) == ds.findPar(7)){
            System.out.println("Same");
        }else {
            System.out.println("Not same");
        }

        ds.unionBySize(3,7);

        // after making connection let us check again.
        if(ds.findPar(3) == ds.findPar(7)){
            System.out.println("Same");
        }else {
            System.out.println("Not same");
        }
    }

    // Both of them will take same TC so, we can use both.
}
