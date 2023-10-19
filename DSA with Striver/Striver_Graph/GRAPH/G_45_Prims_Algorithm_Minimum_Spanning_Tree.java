package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G_45_Prims_Algorithm_Minimum_Spanning_Tree {

    // Prim's Algorithm is used to find the MST that is nothing but Minimum Spanning Tree.

    // So to apply prim's algo we have required ,
    // Priority Queue(min-heap-> because we will try to follow that path which is having less edge weight or, we can say we are taking things via greedy, and this is intuition).
    // And visited array as well, and to store the edges that are involved we have requirement of ListOFList.

    // TC -> O(E*log E), SC -> O(V) for vis, and for ans.


    public static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    // if there is no requirement of finding the MST then we can use this Pair for Priority Queue, but if we have to find the path MST?edges(which is involved in MST) and sum then
    // we use another Pair, which will consist node, parent, weight, but let us make Pair2 as EDGE.
    // Do not visit at the time adding adjacent node, only visit when we are removing from PQ.

    public static class Edge{
        int node;
        int weight;
        int parent;
        Edge(int n, int w, int p){
            this.node = n;
            this.weight = w;
            this.parent = p;
        }
    }

    public static void PrimsAlgorithm(int v, ArrayList<ArrayList<Pair>> adj){
        PriorityQueue<Edge> pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        pq.add(new Edge(0,0,-1));// it means we are 0, edges weight is 0, no parent, please make sure that if parent is -1 then do not add into ans.
        boolean[] vis = new boolean[v];
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int sum = 0;

        // loop will run for E times
        while(!pq.isEmpty()){
            Edge rem = pq.remove(); // pq will take log E, if all adjNode are connected with one node in worst case.
            int node = rem.node;
            int wt = rem.weight;
            int parent = rem.parent;

            if(vis[node])continue; // if node is already visited, then there is no need to take again so skip.

            vis[node] = true;
            sum += wt;

            // this is also a way to do it., but it takes array as list directly, there is no need to make explicitly.
          //  ans.add(Arrays.asList(new Integer[]{parent, node}));
            if(parent != -1) {
                ans.add(Arrays.asList(parent, node));
            }

            for(Pair it : adj.get(node)){ // E times
                int adjNode = it.node;
                int adjWt = it.weight;
                if(!vis[adjNode]){
                    pq.add(new Edge(adjNode, adjWt, node)); // log E again for push
                }
            }
        }

        System.out.println("Sum of all the MST edge's weight = " + sum);
        System.out.println("Involved edges : " + ans);
    }

    public static void main(String[] args) {
        int v = 5; // 0 -based indexing
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(3, 6));

        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 8));
        adj.get(1).add(new Pair(4, 5));

        adj.get(2).add(new Pair(1, 3));
        adj.get(2).add(new Pair(4, 7));

        adj.get(3).add(new Pair(0, 6));
        adj.get(3).add(new Pair(1, 8));

        adj.get(4).add(new Pair(1, 5));
        adj.get(4).add(new Pair(2, 7));

        PrimsAlgorithm(v, adj);
    }
}
