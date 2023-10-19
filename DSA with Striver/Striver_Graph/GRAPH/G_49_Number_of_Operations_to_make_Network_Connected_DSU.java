package GRAPH;

import java.util.ArrayList;

public class G_49_Number_of_Operations_to_make_Network_Connected_DSU {

    // DSU -> Disjoint Set union by rank/size.

    // Problem -> Connected the graph.

    // You are given graph with n vertices and m edges.
    // You can remove one edges from anywhere and add that edge between any two vertices in one operation.
    // find the minimum number of operation that will be required to make the graph connected.

    // For ex. if we have three component of graph and, we have to connect them but not via an imaginary edges we have to connect then with the help of
    // removing edges from the graph itself that will make graph connected. And, we have to do it with minimum number of edges removal.
    // So as we now that to connect 'n' different components of graph, if we want to connect them then we have required minimum 'n-1' edges to make it a single graph.
    // So, now problem is changed that we have to find the number of connected components and return with -1 that will be minimal(we can go beyond this but not min) and our answer as well.

    // So, first observation is that we can connect any node with any other node from another graph.

    // But, but wait we still have a problem that is it states that we have to remove edges from the given graph,
    // it means we must have 'n-1' extra edges to connect n components.
    // SO, to solve this problem we have to count the number of extra edges and compare with number of connected components -1,
    // if that will be greater or equal then we will say that our answer will be otherwise return -1.

    // Now question comes that how do we count the extra edges ->
    // So, write down the edges and use dynamically connection using Disjoint set data structure.
    // And in the way if we find some edges which is already connected with its ultimate parent then we will say that this is an extra edge.
    // after that we will find connected components using DSU as wel, like if any node which ultimate parent is that node itself then we will do cnt++, like that we can find connected components.
    // And required edges will be components-1, do we have that much extra edges if yes then return that otherwise return -1.


    private static class DisjointSet{
        ArrayList<Integer> parent, size;

        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void UnionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u == ulp_v)return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static void main(String[] args) {
        int v = 8; // 1-base indexing
        // from given graph we have to find edges.
        int[][] edges = {{0,1},{0,3},{0,2},{1,2},{2,3},{4,5},{5,6},{7,8}};// undirected graph. we are showing only one edges if it is.

        int countExtraEdges = 0;
        DisjointSet ds = new DisjointSet(v);

        for(int[] it : edges){
            int u = it[0];
            int V = it[1];
            if(ds.findPar(u) == ds.findPar(V)){
                countExtraEdges++;
            }else {
                ds.UnionBySize(u,V);
            }
        }

        // count the number of connected components.
        int cntC = 0;
        for(int i = 0; i <= v; i++){
            if(ds.parent.get(i) == i){
                cntC++;
            }
        }

        int ans = cntC - 1;

        if(countExtraEdges >= ans){
            System.out.println("Answer is = " + ans);
        }else{
            System.out.println("Not possible to connect all components of graphs in minimum number of removal of edges");
        }
    }
}
