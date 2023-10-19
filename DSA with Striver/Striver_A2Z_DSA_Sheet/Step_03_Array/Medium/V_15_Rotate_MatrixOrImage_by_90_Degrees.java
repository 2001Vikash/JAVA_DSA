package Step_03_Array.Medium;

import java.util.Arrays;

public class V_15_Rotate_MatrixOrImage_by_90_Degrees {

    // Problem states that you have given an n*n matrix and your task is to rotate the given matrix by 90 degree in clockWise direction.

    public static void printMatrix(int[][] mat){
        for(int[] arr : mat) System.out.println(Arrays.toString(arr));
    }


    public static void reverse(int[] arr){
        int s = 0, e = arr.length - 1;
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public static void rotateMatrix(){
        int[][] mat = { {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        int n = mat.length;;

        // Brute force -> In this we will make an Answer matrix and traverse the given matrix take an element and put that its correct position in ansMatrix.
        // TC -> O(n^2), SC -> O(n^2).
        /*
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[j][n-1-i] = mat[i][j];
            }
        }
        printMatrix(ans);*/

        // Optimal solution -> In optimal solution we will have to solve this problem in-place means without taking any extra spaces.

        // In this approach we can observe that first row comes in first column but in reverse manner. This observation will help us to get answer.
        // So, to get answer firstly we have to find the transpose of matrix, then after reverse the all rows that will be our answer.

        // to get transpose of matrix.

        // TC -> O(n/2 * n/2) + O(n*n/2)

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(i != j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }

        // reverse the every row that will give us Rotated matrix by 90 degree clock wise.

        for(int[] arr : mat)reverse(arr);

        printMatrix(mat);
    }

    public static void main(String[] args) {
          rotateMatrix();
    }
}
