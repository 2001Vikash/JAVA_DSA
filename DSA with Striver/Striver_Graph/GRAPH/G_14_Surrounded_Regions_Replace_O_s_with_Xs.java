package GRAPH;

import java.util.Arrays;

public class G_14_Surrounded_Regions_Replace_O_s_with_Xs {


    // In this question we have given a matrix n*m where every element is either 'O' or 'X'.
    // Replace all O's with X's but with a condition ->
    // If all the O's or set of O's that is surrounded by X's from the four direction left, right, up, down then covert that into X's. if not then leave

    // Intuition is if set of O's or an O's which is not connected to the boundary then they will be definitely surrounded by X's but, somehow
    // they are connected with boundary then they will be not surrounded by X's for sure.
    // So here we have to find the connected O's and if they are not connected to the boundary means they are bound to be surrounded by X's.
    // We will apply DFS over here but, we can apply BFS as well.

    // So Algo is start from the boundary O's(they can be multiple) and mark them that will not be converted and rest of the O's will be converted into X's.

  // TC -> O(n*m) for dfs if all entry will be 'o'
    // SC -> O(n*m) + O(n*m) for dfs recursion stack space.


    public static void dfs(int row, int col, char[][] mat, boolean[][] vis){
        vis[row][col] = true;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nR = row + delRow[i];
            int nC = col + delCol[i];

            if(nR >= 0 && nR < mat.length && nC >= 0 && nC < mat[0].length && !vis[nR][nC] && mat[nR][nC] == 'o'){
                dfs(nR, nC, mat, vis);
            }
        }
    }

    public static void solution(char[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];

        // for both rows.

        for(int j = 0; j < m; j++){
            // for first row
            if(!vis[0][j] && mat[0][j] == 'o'){
                dfs(0, j, mat, vis);
            }
            // for last row
            if(!vis[n-1][j] && mat[n-1][j] == 'o'){
                dfs(n-1, j, mat, vis);
            }
        }

        // for both cols.

        for(int i = 0; i < n; i++){
            // for first col
            if(!vis[i][0] && mat[i][0] == 'o'){
                dfs(i, 0, mat, vis);
            }
            // for last col
            if(!vis[i][m-1] && mat[i][m-1] == 'o'){
                dfs(i, m-1, mat, vis);
            }
        }

        // rest of thing will be changed in 'x'

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(!vis[i][j] && mat[i][j] == 'o'){
                    mat[i][j] = 'x';
                }
            }
        }

        // for printing

        for(char[] arr : mat){
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void main(String[] args) {
        char[][] matrix = { {'x','x','x','o'},
                            {'x','o','x','0'},
                            {'x','o','o','x'},
                            {'x','x','o','x'},
                            {'o','o','x','x'} };


        solution(matrix);
    }
}
