package GRAPH;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Queue;

public class G_10_Rotten_Oranges {

    // In this question we have given a 2-D matrix in which 0 means empty cell, 1 means fresh oranges, 2 means rotten oranges.
    // So we have to find the minimum time required to rot all oranges. A rotten orange at A[i][j] can rot other fresh oranges from UP, DOWN, LEFT, RIGHT.
    // and for rotting neighbouring guy it will take one unit of time.
    // What is main thing over here that is rotten oranges can be more than one. and all will be start rotting simultaneously.
    // If it is not possible to rotten all fresh oranges then we will have to return -1.
    // So here we will apply BFS because we have to move in neighbouring direction not in depth order because we have to find min time.
    // And BFS will go at level 1 then level 2 and so on.
    // because we have multiple starting point and we have to go simultaneously at level 1 then we have to create a queue i which can be many entry according
    // Question given rotten oranges that is the main thing which we have to consider at the time making queue.

    // TC ->  O(n*m) + O(n*m*4) => O(n*m).
    // SC -> O(n*m) for vis and queue.

    public static class Pair{
        int row;
        int col;
        int time;
        Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }

    public static int onlyViaBFS(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] vis = new int[n][m];

        int freshOrange = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(mat[i][j] == 1)freshOrange++;
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int tm = 0;
        int tt = 0;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.remove();
            tm = Math.max(tm, t);

            for(int i = 0; i < 4; i++){
                int nR = r + delRow[i];
                int nC = c + delCol[i];

                if(nR >= 0 && nR < n && nC >= 0 && nC < m && vis[nR][nC] != 2 && mat[nR][nC] == 1){
                    q.add(new Pair(nR, nC, t+1));
                    vis[nR][nC] = 2;
                    tt++;
                }
            }
        }

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(vis[i][j] != 2 && mat[i][j] == 1){
//                    return -1;
//                }
//            }
//        }   // We can do this thing via taking a count variable.

        if(tt != freshOrange)return -1;

        return tm;

    }



    public static void main(String[] args) {
        int[][] mat = { {0,1,2},
                        {0,1,1},
                        {2,1,1} };

        System.out.println("Total rotten time will be : " + onlyViaBFS(mat));
    }
}
