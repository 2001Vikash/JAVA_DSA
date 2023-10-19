package GRAPH;

import java.util.ArrayList;
import java.util.Collections;


public class G_47_Kruskal_Algorithm_Minimum_Spanning_Tree {

    // This algorithm is also helped to find the Minimum spanning tree which is already we have learned via Prim's Algorithm.

    // In this algo we will be using Kruskal's Algorithm with the help of Disjoint set.

    // First task -> Sort all the edges according to their weights.
    // we are going to use Disjoint set data structure that will give findParent(), and UnionByRank() or UnionBySize().
    // And as we know that if we are making disjoint set ds for given graph then initially every node will be looking like a single node with parent and rank.

    // TC -> O(V+E) + O(M*log M) + O(M*4*alpha*2) where M is no, of edges. , S ->O(M) which is used to store the edges.

    public static class DisjointSet{
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        public DisjointSet(int n){
            for(int i = 0; i <= n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findPar(int node){
            if(node == parent.get(node)){
                return node;
            }
           // return parent.set(node, findPar(parent.get(node))); // it will give wrong answer when we will submit it
            int ulp = findPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node); // use this it will be giving right answer.
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


    public static class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int weight;
        int node;
        int adjNode;
        Edge(int w, int n, int a){
            this.weight = w;
            this.node = n;
            this.adjNode = a;
        }
        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight;
        }
    } // here we can use semi colan but ,it is not required in Java.

    public static void KruskalAlgorithm(int v, ArrayList<ArrayList<Pair>> adj){
        // According to given graph we have to make edges and sort them into increasing order in the term of weights.

        // O(V+E)
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i = 1; i <= v; i++){
            for(Pair it : adj.get(i)){
                int adjNode = it.node;
                int wt = it.weight;
                edges.add(new Edge(wt, i, adjNode));
            }
        }

        // Sort the edges
        Collections.sort(edges); // if we have M edges then O(M*log M)
        // OR
        // if do not want to implement edges class to comparable then we can use it directly.
       // Collections.sort(edges, (a,b)->a.weight-b.weight);

        DisjointSet ds = new DisjointSet(v);
        int mstWt = 0;
        // O(M * 4 * alpha * 2) -> * 2 because we are using 4*alpha twice at a time.
        for(Edge it : edges){
            int node = it.node;
            int adjNode = it.adjNode;
            int wt = it.weight;
            if(ds.findPar(node) != ds.findPar(adjNode)){
                mstWt += wt;
                ds.UnionBySize(node, adjNode);
            }
        }

        System.out.println("Sum of MST edges = " + mstWt);
    }

    public static void main(String[] args) {
        int v = 6;  // 1-based indexing.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= v; i++)adj.add(new ArrayList<>());

        adj.get(1).add(new Pair(2,2));
        adj.get(1).add(new Pair(4,1));
        adj.get(1).add(new Pair(5,4));

        adj.get(2).add(new Pair(1,2));
        adj.get(2).add(new Pair(3,3));
        adj.get(2).add(new Pair(4,3));
        adj.get(2).add(new Pair(6,7));

        adj.get(3).add(new Pair(2,3));
        adj.get(3).add(new Pair(4,5));
        adj.get(3).add(new Pair(6,8));

        adj.get(4).add(new Pair(1,1));
        adj.get(4).add(new Pair(2,3));
        adj.get(4).add(new Pair(3,5));
        adj.get(4).add(new Pair(5,9));

        adj.get(5).add(new Pair(1,4));
        adj.get(5).add(new Pair(4,9));

        adj.get(6).add(new Pair(2,7));
        adj.get(6).add(new Pair(3,8));

        KruskalAlgorithm(v, adj);

    }
}
