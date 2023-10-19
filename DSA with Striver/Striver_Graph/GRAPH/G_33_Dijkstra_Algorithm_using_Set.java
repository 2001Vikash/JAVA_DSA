package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class G_33_Dijkstra_Algorithm_using_Set {



    // Now in this video will be solving Dijkstra's Algorithm using Set data structure. which is the fastest method.
    // Why did we use Priority queue because we always wanted to take minimal value from the queue that's why we used min-heap.

    // Definition of set -> Set stores unique value and the smallest element will be at the top in the set or at first position.
    //                      and we know that set data structure stores everything in ascending order. and same thing, we were doing in the Priority Queue.
    // And there is another reason to use Set data structure for ex if we reach at any index and, we are not finding distance as infinity it means that
    // someone is visited from another way before current way and if current way is having lesser distance than previous it means in set data structure
    // there is an entry of that previous way with higher distance so please remove it that is the biggest advantage of set data structure.
    // because random removal is not possible in the Priority Queue data structure because it accesses things in an order.
    // and put the better way in to the set but before putting we have to remove previous thing from the set. because there is no any significance to check for that again because we have already a good way to reach.

    // So remove the already existing ways-> which will improve very miner change in Time complexity. It depends on graph. and as well we know that set.remove() can be logarithmic time complexity.
    // So, can we say that Set data structure is having good TC than PriorityQueue => No, because we are erasing some future iteration but as well we are taking log n time to remove.
    // So, it totally depends upon the size of graph. and vice versa is also not a right statement because both are good and, we can use both accordingly.

    // but in Java using TreeSet or HashSet it is not possible that's why we prefer to use priority queue in Java but in case of c++ we can use both.


    public static class Pair{
        int distance;
        int node;
        Pair(int d, int n){
            this.distance = d;
            this.node = n;
        }
    }


    /*public static int[] solution(int v, int src, ArrayList<ArrayList<Pair>> adj){
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(0, src));
        int[] dist = new int[v];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;

        while(!set.isEmpty()){
          //  Pair rem = set.remove(); // because here we have to give an Object to remove because there is no any removeFirst type operation in Java Set DS.
            for(Pair it : set){
                int d = it.distance;;
                int n = it.node;
                set.remove(it);
                for(Pair e : adj.get(n)){
                    int newDist = e.distance;
                    int newNode = e.node;
                    if(d + newDist < dist[newNode]){
                        // erase if existed
                        if(dist[newNode] != (int)1e9){
                            set.remove(dist[newNode]);// this is also a problem
                        }
                    }
                }

            }
        }
    }*/



    public static void main(String[] args) {
        int v = 6; // from 0 to 5.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(4,1));
        adj.get(0).add(new Pair(4,2));

        adj.get(1).add(new Pair(4,0));
        adj.get(1).add(new Pair(2,2));

        adj.get(2).add(new Pair(4,0));
        adj.get(2).add(new Pair(2,1));
        adj.get(2).add(new Pair(3,3));
        adj.get(2).add(new Pair(1,4));
        adj.get(2).add(new Pair(6,5));

        adj.get(3).add(new Pair(3,2));
        adj.get(3).add(new Pair(2,5));

        adj.get(4).add(new Pair(1,2));
        adj.get(4).add(new Pair(3,5));

        adj.get(5).add(new Pair(6,2));
        adj.get(5).add(new Pair(2,3));
        adj.get(5).add(new Pair(3,4));

//        Set<Integer> s = new HashSet<>();
//        Integer[] arr = {5,4,6,7,3,2,9,1,2,4};
//        s.addAll(Arrays.asList(arr));
//        System.out.println(s);   // This is example to understand about set data structure.


    }
}
