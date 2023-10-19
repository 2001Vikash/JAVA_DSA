package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class G_28_Shortest_Path_in_Undirected_Graph_having_unit_distance {

    // You have to find the shortest distance from a given source in which edges are having unit distance.
    // And if path is not possible then please return the value -1.
    // So from the given node we have to find the shortest path for every node which comes in the graph.

    // To solve this problem we will apply Plain BFS algorithm how? we will se afterwards.
    // But instead of storing Integer value in BFS queue we will be storing pairs that is having node and the distance from the neighbour node.


    public static int[] solution(int v, int src, ArrayList<ArrayList<Integer>> adj){

        // Apply Plain BFS

        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        int[] dist = new int[v];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0; // distance from src node to src node will be 0 that is minimal.

        while(!q.isEmpty()){
            int node = q.remove();

            for(int nbr : adj.get(node)){
                if(dist[node] + 1 < dist[nbr]){
                    dist[nbr] = dist[node] + 1;
                    q.add(nbr);
                }
            }
        }

        for(int i = 0; i < v; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        // Why is it working because in BFS we know that traversal is being in level order like firstly for distance 1 and then 2 and so on. It means
        // We have already things in sorted order that's why it is good method to do it instead of doing it via standard algorithm.
        // because question is for unit distance.
        // We can say it plain BFS but, we can say that in this we are using greedy algo to find minimal distance as well so, we can say that it is a small bit of greedy extension.

        return dist;
    }

    public static void main(String[] args) {
        int v = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(6);

        adj.get(3).add(0);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);

        adj.get(7).add(6);
        adj.get(7).add(8);

        adj.get(8).add(6);
        adj.get(8).add(7);

        System.out.println(Arrays.toString(solution(v, 0, adj)));
    }
}
