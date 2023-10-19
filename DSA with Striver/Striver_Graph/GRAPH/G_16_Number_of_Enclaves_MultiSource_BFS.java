package GRAPH;

import java.util.ArrayDeque;
import java.util.Queue;

public class G_16_Number_of_Enclaves_MultiSource_BFS {


    // Problem states that you have given binary grid n * m, where '0' represents a sea cell and '1' represents a land cell.
    // A move consists of walking from one land cell to another adjacent land cell ( 4-directionally) or walking off the boundary of the grid.
    // find the number of land cells in the grid for which we can not walk off the boundary of the grid in any number of moves.
    // means we can take a move on land but not in the sea so we have to find the land cell via which we can not take a move on boundary or
    // for easy we can say that move on out of the boundary.
    // count the no. land cells from where we can go from out of boundary.
    // any cell on boundary which is a land and connected to the inner cells then it means from those inner cell we can go from out of the boundary.
    // and at the end of day rest of the 1's or land cell will be our answer.

    // This problem is also like a previous problem so, previously we have applied DFS so let us apply BFS over here just for the sake of clarity.
    // Here we can do it without using of visited array to convert visited cell as 1 to 0. and remaining 1 will count in the last.
    // but we know that this is not good practice to make changes in given data.


    // SC -> O(n*m)
    // TC -> assume all entry is one then O(n*m*4).


    public static class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }

    public static int countAnswer(int[][] grid){
        int n = grid.length;;
        int m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];

        // Here we have multiple source so we have to insert in the queue.

        // for the both row boundary

        for(int j = 0; j < m; j++){
            // for first row
           if(grid[0][j] == 1){
               vis[0][j] = true;
               q.add(new Pair(0, j));
           }
          // for last row
            if(grid[n-1][j] == 1){
                vis[n-1][j] = true;
                q.add(new Pair(n-1, j));
            }
        }

        // for the both column boundary

        for(int i = 0; i < n; i++){
            // for the first column
            if(grid[i][0] == 1){
                vis[i][0] = true;
                q.add(new Pair(i, 0));
            }
            // for the last column
            if(grid[i][m-1] == 1){
                vis[i][m-1] = true;
                q.add(new Pair(i, m-1));
            }
        }

        // via this way we can also cover boundary

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(i == 0 || j == 0 || i == n-1 || j == m-1){
//                    if(grid[i][j] == 1){
//                        q.add(new Pair(i, j));
//                        vis[i][j] = true;
//                    }
//                }
//            }
//        }


        // Apply BFS

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            // Traverses all four directions

            for(int i = 0; i < 4; i++){
                int nR = row + delRow[i];
                int nC = col + delCol[i];

                if(nR >= 0 && nR < n && nC >= 0 && nC < m && !vis[nR][nC] && grid[nR][nC] == 1){
                    vis[nR][nC] = true;
                    q.add(new Pair(nR, nC));
                }
            }
        }

        int count = 0;

       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               if(!vis[i][j] && grid[i][j] == 1){
                   count++;
               }
           }
       }

        return count;
    }



    public static void main(String[] args) {
        int[][] grid = {{0,0,0,1},
                        {0,1,1,0},
                        {0,1,1,0},
                        {0,0,0,1},
                        {0,1,1,0}};

        System.out.println("Number of Enclaves is = " + countAnswer(grid));

    }
}
