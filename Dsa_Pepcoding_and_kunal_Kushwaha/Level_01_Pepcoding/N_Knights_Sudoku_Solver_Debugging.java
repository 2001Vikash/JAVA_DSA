package Level_01_Pepcoding;

public class N_Knights_Sudoku_Solver_Debugging {

    // N - knights Problem

//    public static void main(String[] args) {
//       int n = 3;
//       boolean[][] board = new boolean[n][n];// here all things initially false.
//      // knights(board, 0);
//        N_Knights(board,0,0,n);
//    }
//    // Thoda - Thoda clear hai.
//    static void N_Knights(boolean[][] board, int row, int col, int knights){
//        if(knights == 0){
//            display(board);
//            System.out.println();
//            return;
//        }
//        if(row == board.length - 1 && col == board.length){
//            return; // means skip it
//        }
//        if(col == board.length){
//            N_Knights(board, row+1, 0, knights);
//            return;
//        }
//        if(isSafe(board, row, col)){
//            board[row][col] = true;
//            N_Knights(board, row, col+1, knights-1);
//            board[row][col] = false;
//        }
//        N_Knights(board, row, col+1, knights);
//    }
//    static void knights(boolean[][] board, int row){
//        if(row == board.length){
//            display(board);
//            System.out.println();
//            return;
//        }
//        for (int col = 0; col < board.length; col++) {
//            if(isSafe(board, row, col)){
//                board[row][col] = true;
//                knights(board, row+1);
//                board[row][col] = false;
//            }
//        }
//    }
//     static boolean isSafe(boolean[][] board, int row, int col){
//        if(isValid(board, row-2, col+1))
//         if(board[row-2][col+1]){
//            return false;
//        }
//        if(isValid(board, row-2, col-1))
//          if(board[row-2][col-1]){
//             return false;
//         }
//        if(isValid(board, row-1, col+2))
//          if(board[row-1][col+2]){
//             return false;
//         }
//        if(isValid(board, row-1, col-2))
//          if(board[row-1][col-2]){
//             return false;
//         }
//         return true;
//     }
//     static boolean isValid(boolean[][] board, int row, int col){
//        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
//            return true;
//        }
//        return false;
//     }
//    private static void display(boolean[][] board) {
//        for(boolean[] row : board){
//            for(boolean element : row){
//                if(element) {
//                    System.out.print("K ");
//                }else{
//                    System.out.print("* ");
//                }
//            }
//            System.out.println();
//        }
//    }





    // Sudoku Solver


    public static void main(String[] args) {
                int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
                if(solve(board)){
                    display(board);
                }else{
                    System.out.println("Can not Solve");
                }
    }
    static void display(int[][] board){
        for(int[] row : board){
            for(int nums : row){
                System.out.print(nums+" ");
            }
            System.out.println();
        }
    }
    static boolean solve(int[][] board){
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(!emptyLeft){
                break;
            }
        }
        if(emptyLeft){
            return true; // sudoku is solved
        }


      // if somewhere 0

        for (int number = 1; number <= 9; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;

                if(solve(board)){
                    return true;// found the ans.
                    // means if solve return true then we return true otherwise perform backtrack and return false;
                }else{
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false; // sudoku can't solve
    }
    static boolean isSafe(int[][] board, int row, int col, int num){
        // For row
        for (int i = 0; i < board.length; i++) {
           if(board[row][i] == num){
               return false;
           }
        }
        // for col
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == num){
                return false;
            }
        }
        // for sub board with 3x3
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for (int j = colStart; j < colStart+sqrt; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
