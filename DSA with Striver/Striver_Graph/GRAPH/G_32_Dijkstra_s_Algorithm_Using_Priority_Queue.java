package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class G_32_Dijkstra_s_Algorithm_Using_Priority_Queue {

    // This is the most important algorithm if we are solving problem like Shortest path finding.
    // Algorithm states that :
                 // You have given a source node and, we have to find the shortest path for every node from the source node in the term of edge weight.
                 // We can implement this Algo via three methods one is via Queue which will take more time.
                //  Second is Priority Queue that will take less time that Queue and Third will be via Set method which is fastest.
                // We will see only two methods one is Priority Queue and Second one is via Set method.

    // Let see vai priority queue in this video.
    // We will always have a distance array which is used to keep track of how much are we taking in a path.
    // and Minimum heap data structure which is having [dist,node], it means if we are storing something in this data structure, the shorter distance will be at the top.
    // Priority queue will work like minimum-heap data structure. and if distance will be same at any point then decision will be taken via the minimal node.
    // put dist[src] = 0 and rest of filled with infinity means very big integer.
    // And as well put the 0, src in to the priority queue. things will be happened like BFS.

    // Note -> Dijkstra's is not applicable for the -ve edge weight cycles.

    // Time complexity -> O(E*log V) where E is total no. of edges and, V is total number of nodes in the graph.

    /* Why ? =>
               Dijkstra's does not work in graph that is having a single -ve edge weight and -ve weight cycle. because it falls in an infinite loop.

               we can easily see that the main problem is only -ve edge weight.
               for ex. 0 -> 1 which is having -2 edge weight. 0 to 1 it will take -2 and if again , if we come on 0 it will take -4 that is good from previously
               and if we repeat this thing again and , again we will find better distance and will never stop that is the problem with -ve edge weight.
     */

    // Note -> If we will put Queue at the place of Priority Queue that will give also correct answer but tae more time to execute.


// Another way to implement priority queue with Min-heap.

//    public static class Pair implements Comparable<Pair>{
//        int node;
//        int wt;
//        Pair(int n, int w){
//            this.node = n;
//            this.wt = w;
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            return this.wt - o.wt;
//        }
//    }

    public static class Pair {
        int node;
        int wt;
        Pair(int n, int w){
            this.node = n;
            this.wt = w;
        }

    }


    public static int[] DijkstraAlgorithmViaPriorityQueue(int v, int src, ArrayList<ArrayList<Pair>> adj){

        // Min heap

       // PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparingInt(x -> x.wt));
        // OR
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.wt-y.wt);

       // PriorityQueue<Pair> pq = new PriorityQueue<>(); // implemented by implementing Comparable<Pair> class in Pair class.

        int[] dist = new int[v];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0; // because distance from the src node to src node will be zero that will be minimal.
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            int weight = rem.wt;
            int node = rem.node;

            for(Pair it : adj.get(node)){
                int newWt  = it.wt;
                int newNode = it.node;
                if(weight + newWt < dist[newNode]){
                    dist[newNode] = weight + newWt;
                    pq.add(new Pair(newNode, dist[newNode]));
                }
            }
        }

        return dist;
    }



    public static void main(String[] args) {
        int v = 6; // from 0 to 5.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,4));
        adj.get(0).add(new Pair(2,4));

        adj.get(1).add(new Pair(0,4));
        adj.get(1).add(new Pair(2,2));

        adj.get(2).add(new Pair(0,4));
        adj.get(2).add(new Pair(1,2));
        adj.get(2).add(new Pair(3,3));
        adj.get(2).add(new Pair(4,1));
        adj.get(2).add(new Pair(5,6));

        adj.get(3).add(new Pair(2,3));
        adj.get(3).add(new Pair(5,2));

        adj.get(4).add(new Pair(2,1));
        adj.get(4).add(new Pair(5,3));

        adj.get(5).add(new Pair(2,6));
        adj.get(5).add(new Pair(3,2));
        adj.get(5).add(new Pair(4,3));


        System.out.println(Arrays.toString(DijkstraAlgorithmViaPriorityQueue(v, 0, adj)));
    }
}
