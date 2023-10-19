package GRAPH;

import java.util.ArrayList;

public class G_48_Number_of_Provinces_Disjoint_Set {

    // Number of Provinces -> Given an undirected graph with V vertices. We say two vertices U and V belong to a single province if there is a path from
    // U to V or V to U. Your task is to find the number of provinces.
    // Note -> A province is a group of  directly or indirectly connected cities and no other cities out-side of the group.
    // In-sort problem is about to find the no. of connected components. And, we have already solved this problem using traversal technique but over here we will try to solve this problem using Disjoint set.

    // In disjoint set we have learned the findPar(), so number of provinces is nothing but number of boss(ultimate parent) in the given graph.
    // So, simple we can do if(findPar(u) == u) means this is a boss cnt++ and so on.

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

    public static int solution(int v, int[][] adjMat){

        DisjointSet ds = new DisjointSet(v);

        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
                if(adjMat[i][j] == 1){
                    ds.UnionBySize(i,j);
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= v; i++){
            if(ds.parent.get(i) == i){
                cnt++; // or we can also call ds.findPar() which will do recursion so this is a good way to do it.
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int v = 7;// 1- based indexing.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= v; i++)adj.add(new ArrayList<>());

        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(2);

        adj.get(4).add(5);

        adj.get(5).add(4);

        adj.get(6).add(7);

        adj.get(7).add(6);

        // We have to make adjMatrix for this graph. '1' if edge is present otherwise '0'.
        // The matrix represents the adjMatrix for the graph shown with three components.

        int[][] adjMat = new int[v+1][v+1]; // because we are using 1 based indexing.

        for(int i = 0; i <= v; i++){
            for(int it : adj.get(i)){
                adjMat[i][it] = 1;
            }
        }

        System.out.println("The number of Provinces is = " + solution(v, adjMat));
    }
}
