package GRAPH;

import java.util.ArrayList;

public class G_20_Find_Eventual_Safe_States_DFS {

    // problem ->  We have given a adjacency list consisting the nodes and edges.
              //  Each node of the graph is labelled with a distinct integer in the range of 0 to V-1.

    // A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a Terminal node. Means every path ends up at a terminal node.
    // you have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
    // In this part we will solve it using cycle detection(in a directed graph) and in next part we will solve it using topological sort using BFS.
   // And every terminal node will be also a safe node.

    // Note -> Every node will be never a safe node if they are connected with a cycle and
    //         as well if someone is pointing to the those node who is part of cycle will also never be a safe node. or we can say that anyone who leads the cycle can not be a part of safe node.


    // TC -> O(V+E). SC -> we are using 3 arrays so generally O(n). Do not go with a single array because industries requirement that code must be understandable.
                 //   so this is code quality which makes it easy for the purpose of understanding

    public static boolean dfsCheckForCycle(int node, boolean[] vis, boolean[] pathVis, boolean[] check, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        // traverse for adjacent node
        for(int nbr : adj.get(node)){
            // when the node is not visited
            if(!vis[nbr]){
                if(dfsCheckForCycle(nbr, vis, pathVis, check, adj)){
                    check[node] = false;
                    return true;
                }
            }
            // if the node has been previously visited
            // but, it has to be visited on the same path for cycle means if pathVis[nbr] is true means there is cycle.
            else if(pathVis[nbr]){
                check[node] = false;
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;
        return false;
    }

    public static void safeNode(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        boolean[] check = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                if(dfsCheckForCycle(i, vis, pathVis, check, adj));
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        // why we are using check why can we not do work with the list -> Yes we can do it but, we have to use sorting algorithm to sort the list that will take an extra O(n*log n).
        // So to that we can use only some extra memory which is very less and, we can complete our work easily.
        for(int i = 0; i < v; i++){
            if(check[i]){
               list.add(i);
            }
        }

        System.out.println("These are the safe nodes : " + list);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 7; // means nodes will in range of  0 to 6.

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(5);

        adj.get(3).add(0);

        adj.get(4).add(5);

        // and for 5 and 6 there is no any neighbour means outgoing degree is 0 means in this graph they are also terminal node.
        // As we check for 0 is a safe node or not then answer is to that is not a safe node because it is directed toward itself via a cycle
        // means we can not go at a terminal node from 0 and same thing will be happened with 1. like that we will check a node is safe or not.
        // 0 have one path which is end up at a terminal node but, we have to see this condition for all paths if any path is violating the condition then we will say that this is not a safe node.
        // And every terminal node will be also a safe node.

       safeNode(v, adj);

    }
}
