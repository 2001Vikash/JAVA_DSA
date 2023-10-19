package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class G_27_Shortest_Path_in_Directed_Acyclic_graph_Topological_Sort {

    // In this problem we have given a Directed Acyclic graph and, we have to find the Shortest Path from the given source vertex.
    // And source will always be zero(0) means 0-based indexing.
    // Now from here we have to add also one more thing in the graph that is nothing but edge weight which will help us to, find the shortest path in a given graph
    // So actually here we have found the path from source path to every single node distance which must be minimal or shortest.
    // To store weighted graph we have to make ArrayList of pairs or, we can make edge class with src, nbr, and weight for src to nbr.

    // In problem, they are asking for the only single source that is nothing but 0  but, here we will solve this problem with multiple source.

    // Steps to implement the Algorithm
    // Step 1. Do  Topological sort for the  given graph. either we can use DFS or BFS for the Topological sort but here we will apply the DFS method, and we can use BFS method as well there is no problem.
    // -> So for DFS we use a stack and a visited array and, we will do it for connected components as well because graph can have multiple component or can have multiple source.
    // Step 2. take the nodes out of stack and relax the edges and In order to relax the edges we have to make a distance array initialized with infinitive.
    // -> and in distance array go to at the source node and, make it as 0 because we know that min distance from source node to source node will 0 always or, we can say it for every node is away from 0 itself.
    // -> and pop the value from stack and distance we know that is 0, because in topological sort we know that source node will always be in the first means top of the stack.
    // -> pop the top node and go for the adjacent node of that popping node and required edge weight and go at that index and update the distance if it is minimum.
    // -> at the end when all node have popped from stack our distance array will be filled with minimum distance from source node '6' in this case.


    // TC -> Plain topological sort via DFS that O(V+E),

    // Intuition -> Why did we do this problem via Topological sort =>
    //             -> In this sorting order we are moving sequentially means we start from source node and go to neighbour node and check distance as minimal.
    //            -> Why not via any standard algorithm because in this we are optimizing the number of steps to calculate distance that is only O(N+M) which is much better than any standard algorithm.
    //            -> it is only working because we know that from top of element of stack is first no one can before that and same thing for every popping node from the stack.


    public static void topologicalSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;

        for(Pair e : adj.get(node)){
            int v = e.node;
            if(!vis[v]){
                topologicalSort(v, adj, vis, st);
            }
        }

        st.push(node);
    }

    public static int[] solution(int src, int V, ArrayList<ArrayList<Pair>> adj){
        // Step 1: apply topological sort

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                topologicalSort(i, adj, vis, st);
            }
        }

        // Step 2: make distance array and relax the edges with the help of popping element from the stack.

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while(!st.isEmpty()){
            int node = st.pop();

            for(Pair e : adj.get(node)){
                int v = e.node;
                int wt = e.wt;
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
        return dist;

        // If we can reach any state then we have to fill as Integer.MAX_VALUE.
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int v = 7;
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,2));

        adj.get(1).add(new Pair(3,1));

        adj.get(2).add(new Pair(3,3));

        adj.get(4).add(new Pair(0,3));
        adj.get(4).add(new Pair(2,1));

        adj.get(5).add(new Pair(4,1));

        adj.get(6).add(new Pair(4,2));
        adj.get(6).add(new Pair(5,3));
        // in this graph assume that source is 6.

        System.out.println(Arrays.toString(solution(6, v, adj)));

    }
    public static class Pair{
        int node;
        int wt;
        Pair(int n, int w){
            this.node = n;
            this.wt = w;
        }
    }
}
