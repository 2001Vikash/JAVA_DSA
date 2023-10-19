package GRAPH;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class G_06_DFS_Traversal_in_Graph {

    // DFS -> Depth First Search .... This is based on Depth but BFS was based on Level, or we can say breadth.

    // Similarly here also we have given starting node and from that we can go anywhere for neighbour nodes which is at equal distance from starting node.
    // Here after the going of any node we will try to in depth, depth, because we don't have to stop there. and when we will come again at visited node
    // or no any further neighbour elements then we will come back again so due to this behaviour we can see that in this we have to use Recursion.
    // Because we know that Recursion will go in depth first then return ,back.


    // SC -> O(n)(for list) + o(n)(vis) + O(n)(for recursion stack space if we have skewed graph means height will be n) => o(n).
    // TC -> summation of degrees for node that will be 2*E, and O(n) for recursion so TC -> O(n) + O(2*E). for an undirected graph, for directed graph it will be depended on no. of edges.

    public static ArrayList<Integer> DFS(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list,  boolean[] vis){
// or we can make as void that will also work we know that.
        vis[node] = true;
        list.add(node);

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){ // if a node is visited then we don't need to visit again otherwise we will be stuck in that.
                DFS(nbr, adj, list, vis);
            }
        }

        return list;
    }



    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 8;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(3).add(7);
        adj.get(7).add(3);

        adj.get(4).add(8);
        adj.get(8).add(4);

        adj.get(7).add(8);
        adj.get(8).add(7);

        boolean[] vis = new boolean[n+1];
        int startNode = 1;
        //vis[startNode] = true; we can do it or not -> no problem.
        System.out.println(DFS(startNode, adj, new ArrayList<>(), vis));
    }

}
