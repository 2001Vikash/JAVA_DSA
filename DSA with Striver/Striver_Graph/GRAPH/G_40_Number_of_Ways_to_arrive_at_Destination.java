package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G_40_Number_of_Ways_to_arrive_at_Destination {

    // This is different from all standard problems and as well it is an interesting problem.

    // You are in a city of 'n' intersections numbered from 0 to n-1 with bi_directional roads between some intersections. The inputs are generated
    // such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
    // According to above statement, this is showing a graph.

    // Now, you are given an integer n and a 2D integer array roads where roads[i] = [u,v,time], means that there is a road between u and v that takes 'time'.
    // minutes to travel. You want to know in how many ways you can travel from intersection '0' to intersection 'n-1' in the shortest amount of time.
    // Return the number of ways you can arrive at your destination in the shortest amount of time.
    // Since the answer may be large, return it modulo (int)(1e9) + 7.

    //We can say that if someone is reaching at destination with the shortest distance we will be counting that paths, but it might bw wrong let see how=>
    // It work some of the examples which is more state and forward or easy example but, it will not work for complex ex. for this (watch vide0_40 Striver).

    // As usual, we will apply Dijkstra, but there is need of an extra array that is ways like how many ways we have to reach a particular node.

    // TC -> same as Dijkstra's algorithm that is nothing but O(e log v).

    public static class Pair{
        int node;
        int time;
        Pair(int n, int t) {
            this.node = n;
            this.time = t;
        }
    }

    public static int solutionViaDijkstraWithSomeExtension(int src, int dest, ArrayList<ArrayList<Pair>> adj){
        // According to question src will always be zero.

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(src, 0));
        int[] dist = new int[dest+1];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        int[] ways = new int[dest+1];
        ways[src] = 1;// it means we have only one way to start from the src node, because we are storing the no. of ways to reach a node, and that is thing which we are storing 1 as at src.

        while (!pq.isEmpty()){
            Pair rem = pq.remove();
            int dis = rem.time;
            int node = rem.node;

            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int adjDis = it.time;

                if((dis + adjDis) < dist[adjNode]){
                    dist[adjNode] = dis + adjDis;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                    ways[adjNode] = ways[node];
                }
                else if((dis + adjDis) == dist[adjNode]){
                    ways[adjNode] = ways[adjNode] + ways[node];
                }
            }
        }

        return ways[dest];
    }


    public static void main(String[] args) {

        int n = 7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0; i < n; i++)adj.add(new ArrayList<>());
        int src = 0, dest = n-1;

        // City with intersections.

        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,5));
        adj.get(0).add(new Pair(6,7));

        adj.get(1).add(new Pair(0,2));
        adj.get(1).add(new Pair(2,3));
        adj.get(1).add(new Pair(3,3));

        adj.get(2).add(new Pair(1,3));
        adj.get(2).add(new Pair(5,1));

        adj.get(3).add(new Pair(1,3));
        adj.get(3).add(new Pair(5,1));
        adj.get(3).add(new Pair(6,3));

        adj.get(4).add(new Pair(0,5));
        adj.get(4).add(new Pair(6,2));

        adj.get(5).add(new Pair(2,1));
        adj.get(5).add(new Pair(3,1));
        adj.get(0).add(new Pair(6,1));

        adj.get(6).add(new Pair(0,7));
        adj.get(6).add(new Pair(3,3));
        adj.get(6).add(new Pair(4,2));
        adj.get(6).add(new Pair(5,1));


        System.out.println(solutionViaDijkstraWithSomeExtension(src, dest, adj));
    }
}
