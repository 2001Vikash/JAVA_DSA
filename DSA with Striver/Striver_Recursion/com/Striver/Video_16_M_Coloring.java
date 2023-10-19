package com.Striver;
import java.util.*;
public class Video_16_M_Coloring {
    // Time Complexity in worst case is O(n^m). where n is the no of nodes and m is the number of colors.
    // Space Complexity O(n).

    public static boolean isSafe(int node, List<Integer>[] G , int[] color , int i, int col){
        for(int it : G[node]){
            if(color[it]==col)return false;
        }
        return true;
    }
    public static boolean solve(int node , List<Integer>[] G, int[] color , int n , int m){
        if(node==n) return true;

        for(int i=1; i<=m; i++){
            if(isSafe(node, G, color, n ,i)){
                color[node] =i;
                solve(node+1,G,color,n,m);
                color[node]=0;
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[] G , int[] color , int i, int m){
        int n = G.length;
        if(solve(0,G,color,n,m)) return true;
        return false;
    }
    public static void main(String[] args) {
      // Iv will continue this question when I learn about graph.
    }
}
