package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class G_23_Detect_Cycle_in_Directed_Graph_via_Topological_Sort {

    // Previously we have done detect cycle in directed graph via DFS but in this let use how can we do it via BFS and for that Kahn's algo come in action.

    // As we know that Topological sort is only applicable for the DAG but here we know that we have to find cycle in the graph so,
    // according to question we have directed graph but, we have to find the cycle in graph if present.
    // So we will apply Topological sort on given graph and if it will not be possible then we will tell that there will cycle in the graph.
    // And if topological sort array is having lesser that N elements then we will say that there is problem that is cycle but
    // if equal then that will be DAG means there will no any cycle present in the graph.
    // TC -> and SC will be same a Topological sort.


    public static boolean detectCycleViaBFS(int v, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[v+1];

        for(int i = 1; i <= v; i++){
            for(int nbr : adj.get(1)){
                inDegree[nbr]++;
            }
        }

        for(int i = 1; i <=v ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

      //  ArrayList<Integer> tps = new ArrayList<>(); // instead of storing this we can take a counter as well that will be enough.

        int count = 0;

        while(!q.isEmpty()){
            int node = q.remove();
            // tps.add(node);
            count++;

            for(int nbr : adj.get(node)){
                inDegree[nbr]--;

                if(inDegree[nbr] == 0) q.add(nbr);
            }
        }

        if(count == v){
            return false;
        }else{
            return true; // means there is a cycle.
        }
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;// indexing from 1.

        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);

        adj.get(2).add(3);

        adj.get(3).add(5);
        adj.get(3).add(4);

        adj.get(4).add(2);

        System.out.println("Is there any cycle in the given graph : " + detectCycleViaBFS(v, adj));
    }
}
