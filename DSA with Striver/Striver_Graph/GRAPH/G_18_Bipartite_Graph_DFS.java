package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;

public class G_18_Bipartite_Graph_DFS {

    // Now same question we will solve via DFS that will work in depth-depth traversing.
    // TC and SC will be same as DFS algo that is O(v+2*E) which is nothing but O(V+E).

    public static boolean dfs(int node, int color, int[] colorVis, ArrayList<ArrayList<Integer>> adj){

        colorVis[node] = color;

        for(int nbr : adj.get(node)){
            if(colorVis[nbr] == -1){
                if(!dfs(nbr, 1-color, colorVis, adj))return false;
            }
            else if(colorVis[nbr] == color){
                return false;
            }
        }
        return true;
    }

    public static boolean solution(int v, ArrayList<ArrayList<Integer>> adj){
        int[] colorVis = new int[v+1];
        Arrays.fill(colorVis, -1);

        for(int i = 1; i <= v; i++){
            if(colorVis[i] == 1){
               if(!dfs(i, 0, colorVis, adj)){
                   return false;
               }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(4).add(7);
        adj.get(7).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(7).add(8);
        adj.get(8).add(7);


        System.out.println("Is given graph is Bipartite : " + solution(v, adj));
    }
}
