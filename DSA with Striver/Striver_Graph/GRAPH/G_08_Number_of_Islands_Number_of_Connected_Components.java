package GRAPH;

import java.util.ArrayDeque;
import java.util.Queue;

public class G_08_Number_of_Islands_Number_of_Connected_Components {

    // In this given problem we have 2-D matrix filled with 0 and 1 here 0 means water and 1 means island.
    // And we have to find the islands or connected 1's. and all the 8 direction of connectivity is allowed.
    // Think every entry in the matrix as node then via traversing try to find connected components.
    // For this here we will use BFS and, we can also use DFS as well there will no problem.

    // SC -> O(n^2)  and we can also use the given array as well for marking but, even we will use that given array that's why we will say that O(n^2).
    // Also, we can assume queue space as well O(n^2) if all are 1's so, we can add this but, it will not happen.
    // TC -> roughly we can say that O(n^2).



    public static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void BFS(int row, int col, boolean[][] vis, int[][] mat){
        vis[row][col] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, col));
        int n = mat.length;
        int m = mat[0].length;

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            // if we will remove first then when we will remove second then it will give null pointer exception.
             q.remove();

            // Instead of going in 8 direction we can apply this shortcut to fulfill that case.

            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int newRow = r + delRow;
                    int newCol = c + delCol;

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == 1 && !vis[newRow][newCol]){
                        vis[newRow][newCol] = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = { {0,1,1,0},
                        {0,1,1,0},
                        {0,0,1,0},
                        {0,0,0,0},
                        {1,1,0,1} };

        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!vis[row][col] && mat[row][col] == 1){
                    count++;
                    BFS(row, col ,vis, mat);
                }
            }
        }

        System.out.println("Number of Islands = " + count);
    }
}
