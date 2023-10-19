package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class G_38_Cheapest_Flights_within_K_Stops {

    // In this problem ->
    // There are n cities and m edges connected by same number of flights. you are given an array flights where flights[i] = [from to price] indicates that
    // there is a flight from city from to city to with cost price.
    // You are also given three integers src, dest, and k, return the cheapest price from src to destination with at most K stops. If there is no
    // such route, return -1.

    // This is solved via very good interesting algo that is used in a lot of websites in large scale.

    // for ex. 0->1, cost-100, 1->2,cost-100, 1->3,cost-600, 2->0,cost-100, 2->3,cost-200, src = 0, dest = 3, k = 1.
    // So answer will be 700, because we can take stop at only k=1 place, if k = 2 then it will be 400 only via another path.
    // K is given as atMax, it means maximum K stops we can take, we can also take lesser than K stops if we yield better cost.
    // According to this question we can say that let us solve it using simple Dijkstra's Algo, but let understand it via another example and see that
    // Why Dijkstra's Algo will be failed to solve this problem.

    // Note -> The middle points are considered as Stop, not starting and end points or, we can say that in stop we will not be taking into consideration like src and dest.

    // Problem if we will solve it via Dijkstra's algo =>
    // Ex. -> So you have given graph like that: 0 ->({1,5},{3,2}), 1->({2,5},{4,1}), 3->({1,2}), 4->({2,1}), stored like n1->({n2, dist}).
    //     -> and src = 0, dest = 2, K = 2.
    //    -> When we will do dry run then we will see that if we have minimal distance in the distance array, but via that way we can not reach to our destination
    //    -> due to K stops, it means we will have to follow another path, and it might be happened like another path is having more cost, but in
    //    -> Dijkstra's Algo that will not be taken because we have already a minimal value then we can not take another value which is large,
    //    -> because Dijkstra's is used to find the shortest path without any stop type condition, we only take that how can we reach to our destination in minimal cost.
    //   -> So, if we will not follow the another way then we will not find our answer, that is wrong thing which will be occurred if we implement Dijkstra's algo.

    // So, problem is that if we will store the things in the terms of Distance then we will not find our correct answer,
    // Now, solution of this problem is we have store the things in the term of stops instead of storing in the term of distance.
    // means we will make our first priority of judgment is Stops not distance, we will maintain distance array as well to calculate cost, but not at priority.

    // Note -> if we will make first priority as stop then there is no need of PQ, because stops will be increasing by 1 at every iteration,
    //         So we can use Queue, instead of using PriorityQueue. and, we can reduce TC by extra log n.

// Note -> Whenever we reach the destination(means reached at K), do not stop, go for K+1 because, src and dest will not be considered as stops
    //     but if we are going beyond K, it means we must have at destination.


    // we have requirement of two classes, one is for graph, and one is for Queue.

    // Note -> We can say that, this algo is some extension of Dijkstra's algo.

    // TC -> As we know that TC for Dijkstra's is E log V, but here we are not using PQ then we can remove log V.
    // So TC -> will be only O(E) where E is total number of Edges.

    public static class PairForQueue{
        int stops;
        int node;
        int cost;
        PairForQueue(int s, int n, int c){
            this.stops = s;
            this.node = n;
            this.cost = c;
        }
    }

    public static class Pair{
       int node;
        int cost;
        Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }
    }


    public static int solution(int src, int dest, int k, ArrayList<Pair>[] adj){
        Queue<PairForQueue> q = new ArrayDeque<>();
        q.add(new PairForQueue(0, src, 0));
        int[] dist = new int[adj.length];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            PairForQueue rem = q.remove();
            int cost = rem.cost;
            int stop = rem.stops;
            int node = rem.node;

            if(stop > k)continue; // it means if we are at k+1, then we can not go further because, it will be our destination, if not then continue.
            // because we know that if we are at K+1, then if node will be our destination node then we will return,
            // but we will not return because it might be possible another way as well which can provide better result
            // and, accordingly we can make change in to distance array.

            for(Pair it : adj[node]){
                int adjNode = it.node;
                int adjCost = it.cost;

                if(cost + adjCost < dist[adjNode] && stop <= k){ // we can also remove stop<=k because, in above part of the code we are checking already.
                    dist[adjNode] = cost + adjCost;
                    q.add(new PairForQueue(stop+1, adjNode, dist[adjNode]));
                }
            }
        }

        if(dist[dest] == (int)1e9)return -1;
        return dist[dest];
    }



    public static void main(String[] args) {
        // in question, We will have edges and weights but here we are using graph directly.

        int v = 5;// 0-based indexing

        // this is array of arrayList, another way to represent graph.
        ArrayList<Pair>[] adj = new ArrayList[v]; // it will store
        // if we do not add arrayList, then it will give nullPointerException,
        // because it put null things as ArrayList, because without initialization ArrayList will be null because it is an object.

       for(int i = 0; i < adj.length; i++){
           adj[i] = new ArrayList<>();
       }

        adj[0].add(new Pair(1,5));
        adj[0].add(new Pair(3,2));

        adj[1].add(new Pair(2,5));
        adj[1].add(new Pair(4,1));

        adj[3].add(new Pair(1,2));

        adj[4].add(new Pair(2,1));

        System.out.println(solution(0, 2, 2, adj));

        }
    }
