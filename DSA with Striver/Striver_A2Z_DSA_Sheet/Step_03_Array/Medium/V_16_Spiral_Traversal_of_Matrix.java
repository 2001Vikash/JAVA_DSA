package Step_03_Array.Medium;

import java.util.ArrayList;

public class V_16_Spiral_Traversal_of_Matrix {

    // Problem states that you are given an N x M matrix and, we have to traverse the matrix in spiral manner means for in first column and then after last
    // column then in last row and so on.

    public static void spiralMatrix() {
        int[][] mat = {{1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {19, 32, 33, 34, 25, 8},
                {18, 31, 36, 35, 26, 9},
                {17, 30, 29, 28, 27, 10},
                {16, 15, 14, 13, 12, 11}};

        int n = mat.length;
        int m = mat[0].length;

        // Note -> This problem does not have multiple solution there is only one solution that is Optimal.
        // This question can be asked in Interview to know about yor implementation skill and as well how clean code are you writing.

        // When we will go for traversing in spiral manner then we will see that there are a pattern that is nothing but,
        // we will go first right then bottom, then left, then upper direction and so on.=> right -> bottom -> left -> up

        ArrayList<Integer> list = new ArrayList<>();

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {

            //right

            for (int i = left; i <= right; i++) {
                list.add(mat[top][i]);
            }
            top++;

            // bottom

            for (int i = top; i <= bottom; i++) {
                list.add(mat[i][right]);
            }
            right--;

            // left

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(mat[bottom][i]);
                }
                bottom--;
            }

            // up

            if (left <= right){
            for (int i = bottom; i >= top; i--) {
                list.add(mat[i][left]);
            }
            left++;
         }
    }

        System.out.println("Spiral Order of Matrix is = " + list);
    }

    public static void main(String[] args) {
           spiralMatrix();
    }
}
