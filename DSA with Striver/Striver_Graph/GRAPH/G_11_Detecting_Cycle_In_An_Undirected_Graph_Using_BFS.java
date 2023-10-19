package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class G_11_Detecting_Cycle_In_An_Undirected_Graph_Using_BFS {

    // We know the definition of cycle if we will come back to same node in graph where we are started traversing then we will say that graph has cycle.
   // In BFS as we know that this is level order traversal algorithm means firstly it will cover all nodes which are distance one from the starting node.
    // and then for distance 2 and so on.

    // Intuition is that when we start from the node 1 then we go for those node which are at distance 1 means if a time will came when we will be reaching
    // at same node instead of going different node means there will be cycle that's why we are reaching same node instead of going different-2 node at a particular distance.

    // Here in this we have to remember where did we come at a node means we have to take record of previous or parent node of a particular node.
    // means when one part will reach at meeting node then that can not go because second one has already visited and in BFS both things will happen in same distance
    // then how it is possible -> Yes only when cycle is represent.

    // TC -> O(n + 2*e) e is nothing but the degree which is summation of adjacent node = 2*e in undirected graph.
    // SC -> o(n)


    public static class Pair{
        int node;
        int pNode;
        Pair(int n, int p){
            this.node = n;
            this.pNode = p;
        }
    }

    public static boolean viaBFSUndirectedGraph( ArrayList<ArrayList<Integer>> adj, int src, boolean[] vis){

      //  boolean[] vis = new boolean[v+1];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,-1));
        vis[src] = true;

        while(!q.isEmpty()){

            int node = q.peek().node;
            int parent = q.peek().pNode;
            q.remove();

            for(int nbr : adj.get(node)){
                if(!vis[nbr]){
                    vis[nbr] = true;
                    q.add(new Pair(nbr, node));
                }else if(parent != nbr){ // Means if some is visited and, it's not parent then we will say that, this is that node where cycle is forming.
                    return true;
                }
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

//        if(viaBFSUndirectedGraph(adj, v)){
//            System.out.println("Yes there is a cycle present");
//        }else{
//            System.out.println("No cycle present in this graph");
//        }

        // when if there will multiple graphs or, we can say that connected components.

        // then we have to make visited array over here and make call BFS for every node in graphs.
        // And for this case if we find any cycle in components then we will say that there is a cycle.

        boolean[] vis = new boolean[v+1];

        for(int i = 1; i <= v; i++){
            if(!vis[i]){
                if(viaBFSUndirectedGraph(adj, i, vis)){
                    System.out.println("There is cycle");
                    return;
                }
            }
        }
        System.out.println("No cycle");
    }
}
