package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class G_16_Number_of_Distinct_Islands_Constructive_Thinking_and_DFS {


    // Given a boolean 2D matrix n*m, you have to find the number of distinct islands where a group of connected 1's (horizontally or vertically)
    // forms an Island. Two Island are considered to be distinct if and only if one Island is equal to another (not rotated or reflected).
    // In this problem we have to find distinct shape of island if we store all shapes in set data structure then we will be able to find the answer
    // But how we can store an Island in the set that is new question let us see
    // So for that storing we will right the indexes of shapes and after that there will be a base shape means from that we will be going in 4 directions
    // so for the checking of next thing we will subtract base index from every index and if we will find same indexes as previously we saved via the same process so, we can say they are identical or not.
    // means this subtraction method will be applied for every coming island and will be stored in set iff set have not previously saved that indexes.
    // But there is a catch means we have to follow the order for every one like if we are going left or up or down or right then we have fix like in which direction we will go first then after and so on.
    // And as well if we are following BFS then follow this throughout the grid or if we are following the DFS then follow for the throughout the grid.


    public static void dfs(int row, int col, int[][] grid, boolean[][] vis, ArrayList<ArrayList<Integer>> list, int baseRow, int baseCol){
        vis[row][col] = true;
        int r  = row - baseRow;
        int c = col - baseCol;
        ArrayList<Integer> li = new ArrayList<>();
        li.add(r);
        li.add(c);
        list.add(li);

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nR = row + delRow[i];
            int nC = col + delCol[i];

            if(nR >= 0 && nR < grid.length && nC >= 0 && nC < grid[0].length && !vis[nR][nC] && grid[nR][nC] == 1){
                vis[nR][nC] = true;
                dfs(nR, nC, grid, vis, list, baseRow, baseCol);
            }
        }
    }

    public static int solution(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<ArrayList<Integer>>> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    dfs(i, j, grid, vis, list, i, j);
                    st.add(list);
                }
            }
        }

        return st.size();
    }



    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},
                        {1,0,0,0,0},
                        {0,0,0,1,1},
                        {1,1,0,1,0}};


        System.out.println("Number of distinct Islands = " + solution(grid));
    }

}
