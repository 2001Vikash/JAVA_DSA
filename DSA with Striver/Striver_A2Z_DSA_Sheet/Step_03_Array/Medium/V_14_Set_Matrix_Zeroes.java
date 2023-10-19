package Step_03_Array.Medium;

import java.util.Arrays;

public class V_14_Set_Matrix_Zeroes {

    // Problem states that we are given n*m matrix filled with 0 and 1 only. After that we have to make column and zero if we find a zero in row or column.

    public static void printMatrix(int[][] mat){
        for(int[] arr : mat) System.out.println(Arrays.toString(arr));
    }

    public static void setMatrixZero(){
        int[][] mat = { {1,1,1,1},
                        {1,0,0,1},
                        {1,1,0,1},
                        {1,1,1,1} };
        int n = mat.length;
        int m = mat[0].length;

        // Brute force
        // TC -> O((n*m)*(n+m)) + O(n*m), in general we can say that this will be near about O(n^3).
/*
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    for(int row = 0; row < n; row++)if(row != i)mat[row][j] = -1;
                    for(int col = 0; col < m; col++)if(col != j)mat[i][col] = -1;
                }
            }
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)if(mat[i][j] == -1)mat[i][j] = 0;

        printMatrix(mat);  */


        // Better Approach ->  In better solution instead of marking simultaneously, we will keep a track for that and at the end we will mark as zero.
        // That will cost less time than the Brute force solution. SC -> O(n*m) + O(n*m), SC -> O(n+m). so, we have to remove the extra space in optimal
/*
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    mat[i][j] = 0;
                }
            }
        }
        printMatrix(mat); */


        // Optimal Solution -> As of now we know that to traverse a matrix we will have to give TC as O(n^2), we can not optimize it more, that's why
        //                  -> in optimal solution we will try to remove extra space. We will solve it in constant space.
        // Previously we were keeping track with the help of other matrix, but now here can we keep track in matrix itself, so yes but, we have to
        // take care of common place that is 0,0 if we are assuming that we will keep track into 0th row, and 0th column. Please refer video again for optimal solution for better understanding.
        // One thing we have to take care that we will not solve in initial stage for 0th row and 0th col, we will solve it separately.
        // And 0,m-1, is dependent upon 0,0 it means if we will solve 0th column first then it might be possible that 0,m-1 hampered so for this we will solve 0th row first then after we will be solving 0th col.


        // int[] col = new int[m] => matrix[..][0]
        // int[] row = new int[n] => matrix[0][..]

        int col0 = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    // mark the ith row
                    mat[i][0] = 0;
                    // mark the jth col
                    if(j != 0)
                        mat[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }
        // skip the first row and first column and handle it separately.

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(mat[i][j] != 0){
                   // check for col & row
                    if(mat[i][0] == 0 || mat[0][j] == 0){
                        mat[i][j] =  0;
                    }
                }
            }
        }

        if(mat[0][0] == 0){
            for(int j = 0; j < m; j++){
                mat[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i < n; i++)mat[i][0] = 0;
        }

        printMatrix(mat);
    }

    public static void main(String[] args) {
        setMatrixZero();
    }
}
