package GRAPH;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_41_Bellman_Ford_Algorithm { // single source shortest, path algorithm

    // So, this is again an algorithm which is help us, to find the shortest path in given graph.
    // It is exact similar algo like Dijkstra to find the shortest path from src to destination that is nothing but to all the other nodes in given graph.

    // But we know that Dijkstra's algorithm can not solve that problem which is having -ve edge weight or -ve cycle. in this case Dijkstra will give TLE.
    // which is eliminated via Bellman ford algo.
    // So, Bellman ford is an algorithm which help you to detect the -ve cycle in graph as well.
    // And, Note -> Bellman ford is only applicable for the Directed graph.
    //           -> But, what will happen if graph is undirected, then in this case, we will make edges in both direction for ex.
    // if we have an undirected edge 1--2, then we can represent it in directed graph like that 1->2, and 2->1, with same edge weight.
    // In given graph edges can be in any order there is no any specific order to represent, imp thing is that everyone must be present.

    // *** Notes -> Bellman ford says that you have to relax all the edge weights 'N-1' times sequentially.
    //           -> Relax means if you have a distance array then dist[u]+wt < dist[v] then put it in distance array, this is similar to the Dijkstra.
    //           -> And we have to relax 'N-1'. times, where N is nothing but the number of nodes in the given graph. for every given nodes.
    //           -> In first iteration we will be going across all the edges then we will say that the first iteration is completed go for second and so on till n-1.
    //           -> if relaxation is infinitive then there is no need to go for the neighbour node of that node, go for next edges.

    // So after n-1 iterations distance will be having the shortest distance, that will be our answer,
    // Questions -> 1.Why 'n-1' iteration ? , 2.How to detect -ve cycle if present in graph.
    // For intuition => 0->1->2->3->4, every edges are having 1 as edges weight, where 0 is src.
    // so when we will start iteration then we will see that in first iteration 1 will be relaxed and in 2nd iteration 2 will be relaxed since we had 1.
    // we can solve 3 if we have not 2, it means in 3rd iteration we will have 2, so easily we can find/relax 3, in 4th iteration that will be last
    // we will relax 4 because we have 3. this is intuition behind to do iteration exactly 'k' times, and we can find our shortest distance array.

    // For -ve cycle -> So, as we know that at max in n-1 iteration distance array will be ready but if we have -ve cycle in the given graph
    //               -> it means, at nth iteration dist[i] will be updated, it means we have a -ve cycle. it means after n-1 reduction distance is still reducing it means we have -ve cycle.


    // TC -> O(V*E) and space is for distance array. which is taking more time than the Dijkstra.
    // So make sure that if graph is not having -ve edge weight or -ve cycle then apply Dijkstra, otherwise use BellManFord algo.


    public static class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }

    public static int[] bellmanFord(int src, int V, ArrayList<ArrayList<Integer>> edges){
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // iterate every edge n-1 times.

        for(int i = 0; i < V-1; i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // but if there is a -ve cycle present then return an array consisting with -1, as we know that for that we have to check 1 iteration again.

        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if(dist[u] != (int)1e8 && dist[u] + wt < dist[v]){
               return new int[]{-1};
            }
        }


        return dist;
    }


    public static void main(String[] args) {
        int v = 6;
        // in questions,  we will have edges like that (u,v,wt).
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++)adj.add(new ArrayList<>());

        adj.get(3).add(new Pair(2,6));
        adj.get(3).add(new Pair(4,-2));

        adj.get(5).add(new Pair(3,1));

        adj.get(0).add(new Pair(1,5));

        adj.get(1).add(new Pair(5,-3));
        adj.get(1).add(new Pair(2,-2));

        adj.get(2).add(new Pair(4,3));

        int src = 0; // source node will always be zero for this particular graph.

        // convert this graph in to the edges(u,v,wt) form which is imp in bellman ford.

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for(int i = 0; i < v; i++){
            for(Pair it : adj.get(i)){
                int u = i;
                int V = it.node;
                int wt = it.weight;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(u);
                list.add(V);
                list.add(wt);
                edges.add(list);
             //   edges.add(Arrays.asList( new Integer[]{1}));// for this we have to make ArrayList<List<Integer>.
                // Integer[] because we have requirement of List<Integer>, not List<int[]>.
            }
        }

        System.out.println(Arrays.toString(bellmanFord(0, v, edges)));
    }
}
