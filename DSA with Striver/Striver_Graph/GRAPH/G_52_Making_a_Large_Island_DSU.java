package GRAPH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class G_52_Making_a_Large_Island_DSU {

    // Making a large Island problem is also known as Maximum connected graph. It is a hard problem

    // In this question you are given n * n(but we will be doing it for n*m) binary grid. A grid is said to be binary if every value in grid is either 1 or 0.
    // you can change at most one cell in grid from 0 to 1.
    // You need to find the largest group of connected 1's.
    // Tow cells are said to be connected if both are adjacent to each other and both have same value.

    // Solution :
    // According to question adjacent elements are those who are only sharing the sides(T,R,D,L) not diagonally.
    // In question, we will have some components of graph and, we have to connect them converting only at one place, and we have to try to maximize it in size.
    // So, we have to find the largest one, with converting one 0 to 1. Means it is not necessary that if we connect two are three components then
    // they will give the largest value, it might be possible that we have a large component and if we are adding 1 then it will be maximum which will be our answer.

    // How do we solve this problem, what are we looking for,
    // So firstly we are looking for components that are connected, after that convert a 0 to 1 to find the largest connected graph component,
    // So, basically what are we doing, we are checking every 0, so we are doing this thing dynamically we can say. if a change which will give max ans, that will be our ans.
    // For dynamic change in graph as we know that we use Disjoint set to solve this type of problem.

    // So in this question we have given a grid and, if we want to take information from that then we have requirement of two things (row,col)
    // But, as we know that in disjoint set ds we use single node, so in order to convert grid to usable for disjoint set we make it n*m. As previous.
    // So formula if we have (row,col) and, if we want to know corresponding node then we will use node = row * m + col.
    // (row*m) because that many number of elements are travelled via us.

    // If we think about the brute force solution then we can say that we will pick every '0' and check in four direction to find the connected components
    // and, whatever answer is coming store it and go for next check and, at the end we will find our answer as maximum.

    // But how do we know about the size of connected components, here Disjoint set ds will be coming into the action.
    //So, step 1. initially we will store the connected components into the disjoint set data structure, that will be going to help us, to find the next things.
    // And, we can find the size of components using UnionBySize in DisjointSet DS, means if we do work with UnionByRank then that will be not working.
    //step 2. try converting every 0 to 1 and find the maximum answer as much as we can get.

    // But, there is an edge case that is nothing but if we are at a position where we are going to check U,R,L,D and assume that
    // if we find components with the help of R and D, but what if both are telling about single components it means we will be finding wrong answer.
    // SO, problem occurring due to duplicate elements, To solve this problem instead of storing the size of components we will be storing their parents
    // in to the set data structure that will handle duplicate elements, and at the end we will be finding our answer.and add 1 for the current cell which is converting from 0 to 1.


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

    private static boolean isValid(int adjRow, int adjCol, int n, int m){
        return (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m);
    }

    public static int solution(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        // step 1. -> storing all components into Disjoint set ds.

        DisjointSet ds = new DisjointSet(n*m);
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 0)continue; // if cell is having 0 then there is no any connection
                // if not then go to check in all 4 directions to find the components.
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                for(int i = 0; i < 4; i++){
                    int adjRow = row + dr[i];
                    int adjCol = col + dc[i];
                    if(isValid(adjRow, adjCol, n, m) && grid[adjRow][adjCol] == 1){// if that is not 1 means no components will be finding.
                        // means we have to connect them node and adjNode, to do this we have to find the nodeNo and, adjNodeNo
                        int nodeNumber = row * m + col;
                        int adjNodeNumber = adjRow * m + adjCol;
                        ds.UnionBySize(nodeNumber, adjNodeNumber);
                    }
                }
            }
        }

        // Step 2. -> try to convert every 0 to 1 and find the max answer.

        int maxAns = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(grid[row][col] == 1)continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                Set<Integer> st = new HashSet<>();
                for(int i = 0; i < 4; i++){
                    int adjRow = row + dr[i];
                    int adjCol = col + dc[i];
                    if(isValid(adjRow, adjCol, n, m) && grid[adjRow][adjCol] == 1){
                        int adjNodeNumber = adjRow * m + adjCol;
                        st.add(ds.findPar(adjNodeNumber));
                    }
                }
                int totalSize = 0;
                for(int e : st){
                   totalSize += ds.size.get(e);
                }
                maxAns = Math.max(maxAns, totalSize+1);// +1 for the current cell.
          }
        }

        // But what if all entries in the grid is 1. so for that we have to find the ulp for that.
        for(int cellNo = 0; cellNo < n*m; cellNo++){
            maxAns = Math.max(maxAns, ds.size.get(ds.findPar(cellNo)));
        }

        return maxAns;
    }



    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},
                        {1,1,0,1,1},
                        {1,1,0,1,1},
                        {0,0,1,0,0},
                        {0,0,1,1,1},
                        {0,0,1,1,1}};

        int[][] grid2 = {{1,1,0,1,1},
                         {1,1,0,1,1},
                         {0,0,0,0,0},
                         {0,0,0,0,0},
                         {1,1,1,1,1},
                         {1,1,1,1,1}};

        System.out.println("Answer = " + solution(grid2));
    }
}
