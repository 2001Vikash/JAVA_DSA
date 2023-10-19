package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class G_17_Bipartite_Graph_BFS {


    // Here we are going to learn about Bipartite graph and, we will solve it via BFS that is nothing but level order traversal.

    // Definition -> If we color the graph with 2 colors such that no adjacent nodes or neighbour nodes have same color that is known as Bipartite graph.

    // if we have a linear graph (means Graph will not have any cycle), We can color without any problem it means
    // Note -> Linear graph with no cycle is always Bipartite graph.
    // Note -> If cycle found in a graph with Even length then that will always be a Bipartite graph.

    // Means If graph is having Odd length cycle will never be a Bipartite graph.

    // So to solve this problem we use BFS and we that the requirement of BFS that is nothing but a Queue and a visited array.
    // Instead of having boolean visited array we will take an int array filled with -1 means there is no any color at a particular node.
    // And we will color the node with green and yellow where 0 -> green, 1 -> yellow.
    // for traversal, we can start from any given node but let us start form starting node that is 1 in the given example.

    // TC -> O(V+E). it means it is similar to BFS.


    public static boolean isBipartiteWithBFS(int v, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1); // that is first node from where we can start
        int[] colorVis = new int[v];
        Arrays.fill(colorVis, -1);

        while(!q.isEmpty()){
            int node = q.remove();

            for(int nbr : adj.get(node)){
            // if the adjacent node is yet not colored
            // you will give the opposite color of node
                if(colorVis[nbr] == -1){
                    colorVis[nbr] = 1 - colorVis[node]; // means opposite of the node
                    q.add(nbr);
                }
                // If the adjacent node having same color means
                // someone did color it on some other path
                else if(colorVis[nbr] == colorVis[node]){
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


       // System.out.println("Is given graph is Bipartite : " + isBipartiteWithBFS(v, adj));

        // But if we want to solve it for connected component then we can call this via a for loop for every node. like that

        // Remember one thing whenever code is failed for larger test cases it means we have to make it for the connected components.

//        for(int i = 1; i <= v; i++){
//            if(color[i] == -1){
//                if(isBipartiteWithBFS() == false){
//                    return false;
//                }
//            }
//      }


    }
}
