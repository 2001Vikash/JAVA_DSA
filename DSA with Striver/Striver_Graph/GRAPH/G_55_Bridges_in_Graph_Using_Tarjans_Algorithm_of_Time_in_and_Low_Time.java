package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class G_55_Bridges_in_Graph_Using_Tarjans_Algorithm_of_Time_in_and_Low_Time {

    // Bridges means If we remove an edge from the graph and after the removal of that edge if graph will have two or more components then,
     // We will say that edge is working as Bridge in the graph.
    // Which algo is used to solve this problem so, answer is we will use DFS with some extension, that is known as Tarjan's algo.
    // Problem is stating that print all the Bridges like (4,5) is a bridge.

    // To solve this problem we have required of two arrays one is time[] = DFS time of Insertion. and second one is lowTime[] = Lowest time of Insertion.
    // time[] = while doing the DFS traversal keep a track in which step are you reaching a node, the step at which you reach the node that is known as time of Insertion.
    // lowTime[] = Minimal lowest time of insertion of all adjacent nodes apart from parent. (Parent will not be considered).

    // Let us start the algo -> Initially we will assume that time and lowestTime as 1. for better understanding Please watch the video again at the time of revision.


    // SC -> O(V+2E) for the graph if we created over here(it will be done if they are given edges) + O(3V).
    // TC => O(v+2e) for DFS in undirected graph.

    public static int timer = 1;

    public static void tarjanAlgoUsingDFS(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj ,
                                                          int[] timeIn, int[] lowestTime, List<List<Integer>> bridges){
        vis[node] = true;
        timeIn[node] = lowestTime[node] = timer;
        timer++;

        for(int it : adj.get(node)){
            if(it == parent)continue; // if we will not do it then it will convert all the lowestTime as 1 for every node.

            if(!vis[it]){ // if node is not visited then call DFS for it.
                tarjanAlgoUsingDFS(it, node, vis, adj, timeIn, lowestTime, bridges);
                // after returning from DFS call we have to check that current edges can be a bridge or not, and take the lowestTime from adjacent node.
                lowestTime[node] = Math.min(lowestTime[it], lowestTime[node]);

                if(lowestTime[it] > timeIn[node]){
                    bridges.add(Arrays.asList(node, it));
                }
            }else{// if it is visited then take adjacent node lowestTime.
                lowestTime[node] = Math.min(lowestTime[it], lowestTime[node]);
            }
        }
    }

    public static void main(String[] args) {
        int v = 12; // 1-base indexing.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= v; i++)adj.add(new ArrayList<>());

        // undirected graph
        adj.get(1).add(2);
        adj.get(1).add(4);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.get(4).add(1);
        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(9);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(7);
        adj.get(8).add(9);
        adj.get(8).add(10);

        adj.get(9).add(6);
        adj.get(9).add(8);

        adj.get(10).add(8);
        adj.get(10).add(11);
        adj.get(10).add(12);

        adj.get(11).add(10);
        adj.get(11).add(12);

        adj.get(12).add(10);
        adj.get(12).add(11);

        boolean[] vis = new boolean[v+1];
        int[] timeIn = new int[v+1];
        int[] lowestTime = new int[v+1];
        List<List<Integer>> bridges = new ArrayList<>();
        tarjanAlgoUsingDFS(1,-1, vis, adj, timeIn, lowestTime, bridges);

        System.out.println("Bridges in the given graph : " + bridges);
    }
}
