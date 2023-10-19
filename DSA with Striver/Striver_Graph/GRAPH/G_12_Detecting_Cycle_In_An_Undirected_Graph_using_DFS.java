package GRAPH;

import java.util.ArrayList;

public class G_12_Detecting_Cycle_In_An_Undirected_Graph_using_DFS {


     // In this we will apply DFS and, we know that DFS goes in depth-depth and return.
    // we call DFS and, if we reach at a node that has been previously visited means there are cycle and that node is staring node this is intuition behind this
    // Here also we put node,parentNode and go for call if we find a node which is visited but not via its parent then return true. if at one we find true then no need to make further call return true.

    // TC -> O(n+2*E), SC -> O(n) + o(n)



    public static class Pair{
        int node;
        int parent;

        Pair(int n, int p){
            this.node = n;
            this.parent = p;
        }
    }

    public static boolean viaDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                if(viaDFS(nbr, node, adj, vis)){
                    return true;
                }
            }else if(parent != nbr){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(5).add(7);
        adj.get(7).add(5);

        adj.get(7).add(6);
        adj.get(6).add(7);

        adj.get(6).add(3);
        adj.get(3).add(6);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(3).add(1);
        adj.get(1).add(3);

        // for one component we can call for multiple as well.

        System.out.println("Is there cycle in graph : " + viaDFS(1, -1, adj, new boolean[v+1]));
    }
}
