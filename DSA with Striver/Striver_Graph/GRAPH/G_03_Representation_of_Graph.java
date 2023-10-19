package GRAPH;

import java.util.ArrayList;

public class G_03_Representation_of_Graph {


    // First of all in question they will be giving us two things N -> no. of nodes in graph, M -> no. of edges in graph.
    // firstly we will see for the undirected graph then see for directed graph.
    // they will give M rows for edges like that 1,2 1,3 3,4 2,4 2,5 4,5 order can be anything they can give 1,2 or 2,1 like that, first 1,3 then 1,2 like that.

    // To store it we will use two data structures 1. Adjacency Matrix, 2. Adjacency List.

    // For matrix, we have to see that they are giving 1-based indexing or 0 if 1 then we will make matrix[N+1][N+1], and if 0 then m[N][N]. where N is no. of nodes
    // n+1 because we have required 5th index if 1-5 are giving, so we have to make n+1 because we know that in array indexing will be start from 0.
    // If in matrix we have 1 on a particular index then it means there will be an edge between i, j and for undirected graph we have put 1 at j, i.
    // So it will take O(n^2) space to store graph that's why it's not an appreciable method. It is not used widely but, we can be used it if graph is smaller.



   /* public static void main(String[] args) {

        int N = 3;
        int M = 3;

        int adj[][] = new int[N+1][N+1];

// In general
       adj[u][v] = 1;
       adj[v][u] = 1;

        // edge 1 -> 2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2 -> 3
        adj[2][3] = 1;
        adj[3][2] = 1;

        // edge 1 -> 3
        adj[1][3] = 1;
        adj[3][1] = 1;
    } */


    // For Adjacency List -> for this we will use ArrayList of ArrayList and if index is started from n then we have to add exactly n+1 list.
    // SC -> O(2*M) where M is the number of edges or in really we can say that O ( V + E ). where V is no. of nodes, and E is no. of Edges.


    /*
    public static void main(String[] args) {

        int n = 3, m = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        // In general
      //  adj.get(u).add(v);
      // adj.get(u).add(v);

        // If graph is directed then remove adj.get(u).add(v).

        // edge 1 -> 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2 -> 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // edge 1 -> 3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // every List which is in adj will contain every neighbour elements of itself.


        // Now let us print the all edges

        for(int i = 0; i <= n; i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    } */


    // But what if we have given weighted graph then how will we store let us see.

    // In this case for the case of matrix instead of putting of 1 at any particular index we will put edge weight over there.
    // So it will be looked like adj[u][v] = wt, adj[v][u] = wt. for undirected graph and in directed graph we take only one of them u,v.

    // But in case of Adjacency List we will be store pair of edges and weights.
    // we will see it when we will be solving problem on it.
}
