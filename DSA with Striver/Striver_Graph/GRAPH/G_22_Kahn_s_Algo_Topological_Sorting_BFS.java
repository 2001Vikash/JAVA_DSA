package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class G_22_Kahn_s_Algo_Topological_Sorting_BFS {

    // Previously we have solved topological sorting using DFS , Now in this video let us solve it using BFS
    // Solving with BFS this Algo is also famous as Kahn's Algorithm that is nothing but topological sorting using BFS.
    // As we know that Topological sort is on only valid for the DAG that Directed Acyclic graph.

    // For the BFS we will have to use Queue data structure we know that.
    // A new thing will come over here that is InDegree array. InDegree means no. of incoming edges on a particular node/vertices
    // Initially insert in the queue first all the nodes those have 0 InDegree.
    // And after that take them out of the Queue and remove the InDegree of the adjacent node for that removing node and after that if someone is having 0 InDegree again push into the queue and so on.
    // Note -> This is not exactly same as BFS we can say that this is little-bit modified version of BFS.
    // Initially there will be always at-least one node presented which is having InDegree 0. It can be more than one but at least one must be present.
    // and after removing the element from the queue we will decrease their InDegree value like we are removing that edges due to decreasing InDegree.
    // Please watch the G-22 from striver graph at the time of revision.
    // How do we find InDegree -> for ex We have 2 -> (3) it means 3 have an incoming edge please do InDegree[3]++ like that we can find the InDegree.

    // SC -> O(n) , TC -> O(V+E) because it is DFS for Directed graph.


    public static int[] topologicalSortUsingBFSOrKahnSAlgo(int v, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[v];

        for(int i = 0; i < v; i++){
            for(int nbr : adj.get(i)){
                inDegree[nbr]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < v; i++){
            if(inDegree[i] == 0)q.add(i);
        }

        int[] tps = new int[v];
        int k = 0;

        while(!q.isEmpty()){
            int node = q.remove();
            tps[k++] = node;

            // Node is in your topological sort so please remove it from the inDegree[nbr]-- by one because at a time we are removing only one edges.

            for(int nbr : adj.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0)q.add(nbr);
            }
        }

        return tps;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 6; // where vertices will be in range of 0 to v-1.

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        // This is a directed graph.
        // And also this is possible linear ordering, vertices like 5,4,2,3,1,0 in this order we can see that for 5 -> 0, 5 come before 0 and so on for everyone.
        // As well 4,5,2,3,1,0 or 5,4,0,2,3,1 these can be also a valid linear ordering for the given graph. this is also known as Topological sorting.
        // means there can be multiple ordering but in this question we have to find only one of the topological sorting order.

        adj.get(5).add(0);
        adj.get(5).add(2);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(3).add(1);

        adj.get(2).add(3);

        System.out.println(Arrays.toString(topologicalSortUsingBFSOrKahnSAlgo(v, adj)));

    }
}

