package GRAPH;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G_37_Path_with_Minimum_Effort {

    // Problem id given like that ->
    // You are a hiker preparing for an upcoming hike. You are given heights, a 2_D arrays of size row * columns, where height[row][col] represents the height
    // of cell(row,col). You are situated in the top-left-cell(0,0), and you hope to travel to the bottom-right-cell(rows-1, columns-1)(ie. 0 based indexing)
    // you can move up, down, left or right and you wish to find a route that requires the minimum effort.
    // A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
    // It means we have to find absolute difference for every root and find the maximum for all and return the minimum from all of those maximum values.

    // to solve this question we will use Dijkstra's algorithm because we know that it is used to finding the Shortest path, something like src to destination.
    // We will be taking a PQ(min-heap) and a distance array to solve this question, and in Queue we will store diff/effort, row, col.
    // Nothing but apply plain Dijkstra's Algorithm. But, distanceArr will be filled with max of all difference in the path.

    // Note -> whenever we will find destination in PQ then we will return because we know that we can not find more minimum answer because
    //      -> if PQ is showing the minimal one, then there will no any chance to get more minimum answer that is main point which we have to understand.
    //   -> so check for destination while taking out of PQ and not while inserting.
    //   -> As we know that Dijkstra's always take track of the shortest path value, but in this problem we have to find the minimal path value, taking as maximum absolute difference from every consecutive cell.

    // TC -> for Dijkstra E log V, where E -> total number of edges(n*m*4), V -> number of nodes(n*m).
    // TC -> O(n*m*4*log(n*m))., SC -> O(n*m).



    public static class Pair{
        int distance;
        int row;
        int col;
        Pair(int d, int r, int c){
            this.distance = d;
            this.row = r;
            this.col = c;
        }
    }

    public static int solutionViaDijkstraAlgo(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);
        pq.add(new Pair(0,0,0));
        int[][] distAsEffort = new int[n][m];

        for(int[] a : distAsEffort) Arrays.fill(a, (int) 1e9);
        distAsEffort[0][0] = 0; // that is nothing but (0,0) in this question.

        int[] dR = {-1, 0, 1, 0};
        int[] dC = {0, 1, 0, -1};

        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            int diff = rem.distance;
            int r = rem.row;
            int c = rem.col;

            if(r == n-1 && c == m-1){ // or dest[0],dest[1].
                return diff; // we will find minimal value because we are using Min_Heap that is very important things.
            }

            for(int i = 0; i < 4; i++){
                int nR = r + dR[i];
                int nC = c + dC[i];

                if(nR >= 0 && nR < n && nC >= 0 && nC < m){
                    int newEffort = Math.max(Math.abs(grid[nR][nC] - grid[r][c]), diff);
                    if(newEffort < distAsEffort[nR][nC]){
                        distAsEffort[nR][nC] = newEffort;
                        pq.add(new Pair(newEffort, nR, nC));
                    }
                }
            }
        }

        return 0;// if result is not found.
    }



    public static void main(String[] args) {
        int[][] grid = {{1,2,2},
                        {3,8,2},
                        {5,3,5}};
        // given in the question.

        int[] src = {0,0};
        int[] destination = {grid.length-1, grid[0].length-1};

        System.out.println(solutionViaDijkstraAlgo(grid));
    }
}
