package GRAPH;


import java.util.ArrayList;
import java.util.Scanner;

public class G_19_Detect_Cycle_in_a_Directed_Graph_using_DFS {

    // We know that about directed graph when two or more nodes are connected with directed edge that will be known as Directed graph.
    // Why will not work cycle detection algo for undirected graph for this please see lecture 19 and do dry run from your self.
    // Because in directed graph cycle will be present if we find a node which is visited on the following/same path not via different path that is main thing.
    // Means if on the same path node has to be visited again then we will tell that there is cycle in the directed graph.
    // In this problem we will be using two visited array one is for visited node and second one is for visited path. what is the work of path visited, it means that it's being in the same path.
    // As well, we have to call for the every component of graph because it might be happened some graph is not visited due to directed edges.
    // And the time of returning we will make false in path visited for that node to check same path. means here we are using backTracking.

    // TC -> same as DFS but due to directed graph not O(v+2*E) it will be only O(V+E). SC -> O(2*V).

    // We have to try it to solve it using one visited array, hint is for visited node mark as 1 and for path visited mark as 2.


    public static boolean dfsCheckForCycle(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        // traverse for adjacent node
        for(int nbr : adj.get(node)){
            // when the node is not visited
            if(!vis[nbr]){
                if(dfsCheckForCycle(nbr, vis, pathVis, adj))return true;
            }
            // if the node has been previously visited
            // but, it has to be visited on the same path for cycle means if pathVis[nbr] is true means there is cycle.
            else if(pathVis[nbr]){
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v+1];
        boolean[] pathVis = new boolean[v+1];

        for(int i = 1; i <= v; i++){
            if(!vis[i]){
                if(dfsCheckForCycle(i, vis, pathVis, adj))return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int v = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);

        adj.get(2).add(3);

        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(5);

        adj.get(5).add(6);

        adj.get(7).add(5);

        adj.get(8).add(9);

        adj.get(9).add(10);

        adj.get(10).add(8);

       System.out.println("Is there any cycle present in the given graph : " + isCyclic(v, adj));

    }
}