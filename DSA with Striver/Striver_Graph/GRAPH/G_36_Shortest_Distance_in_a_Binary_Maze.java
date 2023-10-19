package GRAPH;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class G_36_Shortest_Distance_in_a_Binary_Maze {


    // In this problem we have given n*m matrix grid where each element can either be '0' or '1'. You need to find the shortest distance between a given
    // source cell to a destination cell. The path can only be created out of a cell if its value is '1'.
    // If the path is not possible between source cell and destination cell, then return -1.
    // In this question it is not mentioned that what would be the distance, in this case we must have to assume in any question distance or weight as '1'.
    // Also, we have to move in 4 direction that is left, right, up, down.
    // Whenever we will see a problem related with the Shortest path then we have to think about those algorithms which is used to find the shortest path for ex. Dijkstra's Algo.

    // As of now we will be solving this problem via Dijkstra algo using Priority Queue, we will see the reason to use it and as well what will be happened if we will use Queue or a Set data Structure.

    // Over here we have 2-D matrix for traversing, It means that we have to make distance array with same size means 2-D array with n*m size.
    // In priority Queue we will store the Distance, row, and col, because we know that node is nothing but grid[i][j] and, for the source we will put distance is zero.
    // after that apply plane Dijkstra's algo.

    // Note -> As we know that we use priority queue for minimal of them but in this case we will insert all those nodes which is at distance 1.
    //      -> means every entry have same distance so there is no any significance to use Priority Queue, instead of this we can use Queue.
    //     -> Because they will be storing in already increasing fashion, so there is no need to use PQ, we can use simple Queue as well and, that will be better.
    //     -> So, with the help of Queue we can reduce the O(log n) time complexity for finding a element in PQ, yes of-course it will be helpful when element in not stored in sorted manner.

    // So, we have figured it out that we can solve this problem using Dijkstra's but Dijkstra's uses PQ, but in this problem we can use simple Queue which is better for this particular problem.
    // In this problem there is no any adjacency list, only we have to traverse the grid in four direction like left, right, up, down.

    // for the traversing in four direction do not use 4 things in a simple way because this will not be considerable in Interview, do it via dRow, dCol.

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

    public static int solutionViaDijkstra(int[] src, int[] dest, int[][] grid){

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, src[0], src[1])); // (distance, row, col).
        int n = grid.length;
        int m = grid[0].length;
        int[][] distArr = new int[n][m];
        for(int[] a : distArr) Arrays.fill(a, (int)1e9);
        distArr[src[0]][src[1]] = 0; // this is source index and distance will be 0 as we know.
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // but what if src and destination both are same then in that case we will not find our ans, because we are checking for one step next.
        // check here for this edge case, because if we will not do it here then code will return -1, which is wrong.

        if(src[0] == dest[0] && src[1] == dest[1]){
            return 0;
        }

        while(!q.isEmpty()){
            Pair rem = q.remove();
            int dis = rem.distance;
            int r = rem.row;
            int c = rem.col;

            // Why not here ,we are checking the destination condition, because if we will check in next if condition then we can reduce the iteration.

            // Traverse in four direction to find the minimal distance till given destination.

            for(int i = 0; i < 4; i++){
                int nR = r + dRow[i];
                int nC = c + dCol[i];

                // check for the validity

                if(nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 1 && dis + 1 < distArr[nR][nC]){
                    if(nR == dest[0] && nC == dest[1]){
                        return dis+1;
                        // because as we know that we are inserting things in Queue in Increasing manner and, at this stage if we are finding our destination.
                        // then it means it will be minimal, because if we will go next iteration then we will not find the more minimal distance.
                    }
                    // go next and check.
                    distArr[nR][nC] = dis + 1;
                    q.add(new Pair(dis+1, nR, nC)); // at the place of dis+1, we can also put disArr[nR][nC], both are same thing.
                }
            }
        }

        return -1; // if we will not be able to reach the destination them return -1.
    }


    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},
                        {1,1,0,1},
                        {1,1,1,1},
                        {1,1,0,0},
                        {1,0,0,0}};

        int[] src = {0,1};
        int[] dest = {2,2};

        System.out.println(solutionViaDijkstra(src, dest, grid));
    }
}
