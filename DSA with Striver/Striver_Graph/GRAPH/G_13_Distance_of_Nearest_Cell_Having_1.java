package GRAPH;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;

public class G_13_Distance_of_Nearest_Cell_Having_1 {


    // In this question we have given Binary grid means filled with 0 and 1, so find the nearest 1  distance from a zero and in case of 1 that will be nearest itself.
    // And we can go up, left, right, down and there are no any diagonal distance calculation.
    // we will solve it via BFS because we know that BFS works on level wise traversal not via DFS because it's work on to go in depth and return.
    // Here we will apply BFS because firstly we want distance one and then distance two and so on.
    // So in initial we will put in queue where we have to start for checking distance means where ever 1 is given in the matrix we will put in queue and
    // correspondingly  true in visited array. means this is nothing but multi-source BFS.


    // TC -> O(n*m*4) + O(n*m)
    // SC -> O(n*m)


    public static class Pair{
        int row;
        int col;
        int step;
        Pair(int r, int c, int s){
            this.row = r;
            this.col = c;
            this.step = s;
        }
    }

    public static void solution(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new Pair(i, j,0));
                }
            }
        }
// n * m
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            q.remove();
            dist[row][col] = step;

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};

            for(int i = 0; i < 4; i++){
                int nR = row + delRow[i];
                int nC = col + delCol[i];

                if(nR >= 0 && nR < n && nC >= 0 && nC < m && !vis[nR][nC]){
                    vis[nR][nC] = true;
                    q.add(new Pair(nR, nC, step+1));
                }
            }
        }


        for(int[] arr : dist){
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void main(String[] args) {

        int[][] matrix = {{0,0,0},
                          {0,1,0},
                          {1,0,1}};

        solution(matrix);
    }

}
