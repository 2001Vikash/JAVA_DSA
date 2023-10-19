package GRAPH;

import java.util.ArrayList;

public class G_07_Number_of_Provinces {


    // Provinces means if we have given graph then can we go for every node from every node(directly or indirectly) so, we will say that this is province.
    // And we have given multiple graphs, so we have to find the number of provinces.
    // Or in simple way we can say that we have to find, how many connected components over here.

    // Sc -> o(n) + O(n)
    // TC -> O(n) + O(v+2E).

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis){

        vis[node] = true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
                dfs(nbr, adj, vis);
            }
        }
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

        int count = 0;

        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                count++;
            }
        }

        System.out.println("Number of Provinces = " + count);
    }
}
