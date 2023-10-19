package GRAPH;

import java.util.Arrays;

public class G_09_Flood_Fill_Algorithm {


    // In this problem we have given a matrix filled with numbers and, also we have initial color as starting index row, col.
    // And also we have given a newColor and we have convert all colors with this newColor if someone is having initial color and connected in
    // four direction L,R,U,D
    // This is how wwe flood fill for any given matrix starting from a given index.
    // For this we can use BFS which will go in level wise we can also do it via DFS.
    // In this we will use DFS for understanding purpose


    // TC -> O(n*m) + o(n*m*4) but we can write O(n*m).
    // SC -> O(n*m) + O(n*m) for recursion stack space in worst case if all elements having initialColor. for deltaRow, and col those can come in Constant.


    public static void solutionViaDFS(int row, int col, int n, int m, int[][] mat, int[][] ans, int[] delRow, int[] delCol, int iniColor, int newColor){

        ans[row][col] = newColor;

        // Instead of calling DFS for four direction we will use delRow, delCol for this which make more readable code.

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor){ // for ans, this will work as visited array.
                ans[nRow][nCol] = newColor;
                solutionViaDFS(nRow, nCol, n, m, mat, ans, delRow, delCol, iniColor, newColor);
            }
        }
    }



    public static void main(String[] args) {
        int[][] mat = { {1,1,1},
                        {2,2,0},
                        {2,2,2} };

        // If we will be working for a company then we should not change the data we must have to make copy of that data and do work because data is imp.

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = mat;
        int newColor = 3;
        int initialColor = mat[2][0];
        solutionViaDFS(2, 0, n, m, mat, ans, delRow, delCol, initialColor, newColor);

        for(int[] a : ans){
            System.out.println(Arrays.toString(a));
        }

    }
}
