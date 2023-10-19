package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G_35_Print_Shortest_Path_in_Unweighted_Graph_Dijkstra_Algo {

    // As we know that Dijkstra's Algo is used for find the shortest path in graph which is not having any -ve cycle and -ve edge weight.
    // But in this problem we have to find the Shortest path instead of find distance from src node to every node.

    // And in this problem we have given a src which is always starting vertex and n which will always be ending or target vertex.

    // We know that Dijkstra's will give the shortest path distance but ,we have to find path so, we will do some modification in this Algo
    // Like we will try to remember where did I come from.


    public static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }
        public static ArrayList<Integer> shortestPathUsingDijkstraAlgo(int v, int src, int dest, ArrayList<ArrayList<Pair>> adj){
            ArrayList<Integer> ans = new ArrayList<>();
            // min -heap.
            PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.weight - y.weight);
            int[] dist = new int[v+1];
            Arrays.fill(dist, (int)1e9);
            dist[src] = 0;
            int[] parent = new int[v+1]; // to remember where am I coming from.
            for(int i = 1; i <= v; i++)parent[i] = i; // mark all of them to itself.

            // OR
            // parent[src] = 1;

            pq.add(new Pair(src, 0));

            while(!pq.isEmpty()){
                Pair rem = pq.remove();
                int wt = rem.weight;
                int node = rem.node;

                for(Pair it : adj.get(node)){
                    int adjNode = it.node;
                    int adjWt = it.weight;
                    if(wt + adjWt < dist[adjNode]){
                        dist[adjNode] = wt + adjWt;
                        pq.add(new Pair(adjNode, dist[adjNode]));
                        parent[adjNode] = node;
                    }
                }
            }

            // Now we have to store the answer in right way but before that we have to take care of that, if destination is not reachable then return -1.
            if(dist[dest] == (int)1e9){
                ans.add(-1);
                return ans;
            }

            int node = dest; // because we are storing where am I coming from.
            ans.add(node);
            while(parent[node] != node){
                ans.add(0, parent[node]);
                node = parent[node];
            }

           // ans.add(0, node); // for the last one where condition will be false.
            // it will work when we will not add dest in answer firstly. in that case we have to reverse the list for the answer.

            return ans;
        }

        // Time complexity -> O(E * log(V) ) + O(n) for the parent array traversal in worst case.
    // SC -> space for adj list and parent, dist array.

    public static void main(String[] args) {
        int v = 5;// 1-based indexing
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(new Pair(2,2));
        adj.get(1).add(new Pair(4,1));

        adj.get(2).add(new Pair(1,2));
        adj.get(2).add(new Pair(3,4));
        adj.get(2).add(new Pair(5,5));

        adj.get(3).add(new Pair(2,4));
        adj.get(3).add(new Pair(4,3));
        adj.get(3).add(new Pair(5,1));

        adj.get(4).add(new Pair(1,1));
        adj.get(4).add(new Pair(3,3));

        adj.get(5).add(new Pair(2,5));
        adj.get(5).add(new Pair(3,1));

        int src = 1;
        int destination = 5;

        System.out.println(shortestPathUsingDijkstraAlgo(v, src, destination, adj));

    }
}
