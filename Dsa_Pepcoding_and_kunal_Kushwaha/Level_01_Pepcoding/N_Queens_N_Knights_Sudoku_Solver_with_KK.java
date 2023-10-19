package Level_01_Pepcoding;

import java.util.ArrayList;

public class N_Queens_N_Knights_Sudoku_Solver_with_KK {

    // These are all based on Backtracking concept.

    // Question -> N-Queens Problem (In Chess)

    // If we have N x N board then place N queens in the board and for this things find the number of ways to do it.
    // Concept is in one row or column only one queen can be otherwise they will cancel each other because we know that
    // Queen can attack in 8 directions. if N queens put in N x N board then it must that every row must have a queen.

// Space complexity -> O(n^2)

    /*
    Time complexity ->
                     -> Recurrence Relation
                     T(n) = n*T(n-1) + O(n^2)
                     using AkraBazzi  formula
                     o(N^3 + N!) => Time Complexity =  O(n!)
                     4x3x2x1 = 4! for every row increasing means Option of Putting Queen will be also reduced.
     */




//    public static void main(String[] args) {
//      int n = 4;
//      boolean[][] board = new boolean[n][n];
//        System.out.println(N_Queens(board, 0));
//    }
//    static int N_Queens(boolean[][] board, int row){
//        if(row == board.length){
//            display(board);
//            System.out.println();
//            return 1;
//        }
//        int count = 0;
//        // Placing the Queen and checking for every row and col.
//        for (int col = 0; col < board.length; col++) {
//            if(isSafe(board, row, col)){
//                board[row][col] = true;
//                count += N_Queens(board, row+1);
//                board[row][col] = false;
//            }
//        }
//        return count;
//    }
//    static boolean isSafe(boolean[][] board, int row, int col){
//        // for vertically
//        for(int i = 0; i < row; i++){
//            if(board[i][col]){
//                return false;
//            }
//        }
//        // for left diagonal
//        int maxLeft = Math.min(row, col);
//        for(int i = 1; i <= maxLeft; i++){
//            if(board[row - i][col - i]){
//                return false;
//            }
//        }
//        // for right diagonal
//        int maxRight = Math.min(row, board.length - col - 1);
//        for (int i = 1; i <= maxRight; i++) {
//            if(board[row - i][col + i]){
//                return false;
//            }
//        }
//        return true;
//    }
//    static void display(boolean[][] board){
//        for(boolean[] row : board){
//            for(boolean element : row){
//                if(element){
//                    System.out.print("Q ");
//                }else{
//                    System.out.print("x ");
//                }
//            }
//            System.out.println();
//        }
//    }

    // Return List of List for every level of Recursion


//    public static void main(String[] args) {
//        int n = 4;
//        boolean[][] board = new boolean[n][n];
//        System.out.println(N_Queens(board, 0, new ArrayList<>()));
//    }
//    static ArrayList<ArrayList<Integer>> N_Queens(boolean[][] board, int row, ArrayList<ArrayList<Integer>> ans){
//        if(row == board.length){
//            ArrayList<Integer> list =  display(board , new ArrayList<>());
//            ans.add(list);
//           // System.out.println();
//            return ans;
//        }
//
//        // Placing the Queen and checking for every row and col.
//        for (int col = 0; col < board.length; col++) {
//            if(isSafe(board, row, col)){
//                board[row][col] = true;
//                 N_Queens(board, row+1, ans);
//                board[row][col] = false;
//            }
//        }
//        return ans;
//    }
//    static boolean isSafe(boolean[][] board, int row, int col){
//        // for vertically
//        for(int i = 0; i < row; i++){
//            if(board[i][col]){
//                return false;
//            }
//        }
//        // for left diagonal
//        int maxLeft = Math.min(row, col);
//        for(int i = 1; i <= maxLeft; i++){
//            if(board[row - i][col - i]){
//                return false;
//            }
//        }
//        // for right diagonal
//        int maxRight = Math.min(row, board.length - col - 1);
//        for (int i = 1; i <= maxRight; i++) {
//            if(board[row - i][col + i]){
//                return false;
//            }
//        }
//        return true;
//    }
//    static ArrayList<Integer> display(boolean[][] board, ArrayList<Integer> ans){
//        for(boolean[] row : board){
//            int step  = 1;
//            for(boolean element : row){
//                if(element){
//                   ans.add(step);
//                   // System.out.print("Q ");
//                }else{
//                   // System.out.print("x ");
//                }
//                step++;
//            }
//           // System.out.println();
//        }
//        return ans;
//    }
//   We can eliminate for loops in main function with conditions but then we need to another variable in argument.
    // for ex -> we can take like as (board, row, col, targets) here target is no of queens when it becomes 0 then return like that.




    // N - Knights problem (Like horses in chess we know that it goes 2.5 distance in this 2 is direct and .5 is in any direction if possible.)
                              // ( r-2, c+1)
                              // (r-2, c-1)
                              // (r-1, c+2)
                              // (r-1, c-2) where r -> Row and c -> Column

    // Here also N x N board and N knights and put it with another cancellation avoidance.


    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
      //  N_Knights(board,0,0,4);
        knight(board, 0);
    }
    static void N_Knights(boolean[][] board, int row, int col, int knights){
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length - 1 && col == board.length){
            return; // means skip it
        }
        if(col == board.length){
            N_Knights(board, row+1, 0, knights);
            return;
        }
        if(isSafe(board, row, col)){
            board[row][col] = true;
            N_Knights(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        N_Knights(board, row, col+1, knights);
    }
    static void knight(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                knight(board, row+1);
                board[row][col] = false;
            }
        }
    }
    static boolean isSafe(boolean[][] board, int row, int col){
        // 2.5 kadam horse will go.
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }
        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }
        return true;
    }
    // do not repeat yourself , hence created this function
    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }
    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean elements : row){
                if(elements){
                    System.out.print("K ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }




    // Sudoku Solver

    // we know that if put ans at a place and if it wrong then we need to remove all under things because those are all at wrong position
    // this work is nothing it is Backtracking

    // Note -> Means When a choice can affect future answers use Backtracking

    // Time complexity -> O(9^n^2).
    // Space Complexity -> O(n^2).


//    public static void main(String[] args) {
//        int[][] board = {
//                {3, 0, 6, 5, 0, 8, 4, 0, 0},
//                {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
//
//        if(solveSudoku(board)){
//            display(board);
//        }else{
//            System.out.println("Can not solve");
//        }
//    }
//
//
//
//    // Solve the Sudoku without any parameter except board
//    static boolean solveSudoku(int[][] board){
//        int n = board.length;
//        int row = -1;
//        int col = -1;
//        boolean emptyLeft = true;
//        // this is how we are replacing the r, c from argument
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(board[i][j] == 0){
//                    row = i;
//                    col = j;
//                    emptyLeft = false; // means no empty places are left
//                    break;
//                }
//            }
//            // if you found some empty element in row then break
//            if(emptyLeft == false){
//                break;
//            }
//        }
//        if(emptyLeft == true){
//            return true; // means sudoku is solved
//        }
//
//        // Backtrack
//
//        for (int number = 1; number <= 9; number++) {
//            if(isSafe(board, row, col, number)){
//                board[row][col] = number;
//                if(solveSudoku(board)){
//                    return true;// found the answer
//                }else{
//                    // backtrack
//                    board[row][col] = 0;
//                }
//            }
//        }
//        return false; // sudoku can't be solve
//    }
//    static void display(int[][] board){
//        for(int[] row : board){
//            for(int num : row){
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
//    }
//    static boolean isSafe(int[][] board, int row, int col, int num){
//        // check the row
//        for (int i = 0; i < board.length; i++) {
//            // check the number is in row or not
//            if(board[row][col] == num){
//                return false;
//            }
//        }
//
//        // Check for the col
//        for (int[] nums : board) {
//            // check the number is in col or not
//            if(nums[col] == num){
//                return false;
//            }
//        }
//
//        // For One subpart of box 3x3
//
//        int sqrt = (int)(Math.sqrt(board.length));
//        int rowStart = row - row%sqrt;
//        int colStart = col - col%sqrt;
//        for (int r = rowStart; r < rowStart+sqrt; r++) {
//            for (int c = colStart; c < colStart+sqrt; c++) {
//                if(board[r][c] == num){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
