package Level_01_Pepcoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SimpleTimeZone;

public class Backtracking_Introduction_Maze_Problem_with_KK {
    // What -> Firstly we will try to find out that what we need to do. or what is question?
    // How -> then after try to find out that how can we do it.

    // Question -> Rat in Maze , find out the number of way in Maze if a rat goes to (0,0) to (n,n). (2-D matrix type maze) if only allow to go right
           //      and down.
    // RD+(remaining) or DR(remaining) like as process and un process

//    public static void main(String[] args) {
//       // System.out.println(countNumberOfPathInMaze(4,4));
//       // printPathInMaze("",3,3);
//       // System.out.println(path("", 3,3));
//        System.out.println(pathDiagonally("", 3,3));
//    }
//    static int countNumberOfPathInMaze(int row, int col){
//        if(row == 1 || col == 1){
//            return 1;
//        }
//        int count = 0;
////        count += countNumberOfPathInMaze(row-1, col);
////        count += countNumberOfPathInMaze(row, col-1);
////
////        return count;
//
//        // OR
//
//        int down = countNumberOfPathInMaze(row-1, col);
//        int right = countNumberOfPathInMaze(row, col-1);
//
//        return right + down;
//    }
//
//    // Print the actual path in maze.
//
//   // Exactly same as subset process and un process.
//    static void printPathInMaze(String p, int row, int col){
//        if(row == 1 && col == 1){
//            System.out.print(p + " ");
//            return;
//        }
//        // Down means add D
//        if(row > 1) {
//            printPathInMaze(p + 'D', row - 1, col);
//        }
//            // Right means add R
//        if(col > 1){
//            printPathInMaze(p + 'R', row, col - 1);
//        }
//    }
//    // Returning in a List
//
//    static ArrayList<String> path(String p, int r, int c){
//        if(r == 1 && c == 1){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> list = new ArrayList<>();
//        if(r > 1){
//            list.addAll(path(p + 'D', r-1, c));
//        }
//        if(c > 1){
//            list.addAll(path(p+'R', r ,c-1));
//        }
//        return list;
//    }
//
//    // if we want add one more path that is diagonally
//
//    static ArrayList<String> pathDiagonally(String p, int r, int c){
//        if(r == 1 && c == 1){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> list = new ArrayList<>();
//        // Diagonally and D
//        if(r > 1 && c > 1){
//            list.addAll(pathDiagonally(p+'D', r-1, c-1));
//        }
//        // Down OR Horizontally
//        if(r > 1){
//            list.addAll(pathDiagonally(p + 'H', r-1, c));
//        }
//        // Right or Vertically
//        if(c > 1){
//            list.addAll(pathDiagonally(p+'V', r ,c-1));
//        }
//
//        return list;
//    }



    // Maze with Obstacles...

    // Let's say that if we have a boolean matrix in which , false means River means we can't cross it change your root then find the possible path
    // Rat can only run go either right or down

    //NOTE ->  Whenever we land a new cell that is river or not. if yes then return from there. and it's not backtracking it is only stop the recursion call.


//    public static void main(String[] args) {
//        boolean[][] maze = {
//                              {true, true, true},
//                              {true, false, true},
//                              {true, true, true}
//                                                  };
//        pathWithRestriction("", maze, 0,0);
//    }
//    static void pathWithRestriction(String p, boolean[][] maze, int row, int col){
//        if(!maze[0][0]){
//            System.out.println("Rat can't go further");
//            return;
//        }
//        if(row == maze.length-1 && col == maze[0].length-1){
//            System.out.println(p);
//            return;
//        }
//        if(!maze[row][col]){
//            return;
//        }
//
//        // Down
//        if(row < maze.length-1){
//            pathWithRestriction(p+'D', maze, row+1, col);
//        }
//        // Right
//        if(col < maze[0].length-1){
//            pathWithRestriction(p+'R', maze, row, col+1);
//        }
//    }




    // BACKTRACKING


    // Let's say why we are using this. Assume in same question that if we want go in four direction then problem will be created because we can stuck there due to go forward as well backward like that hence we stuck in endless loop and this is real backtracking problem
    // UP, DOWN, LEFT, RIGHT -> If we add 2 more cases up and left then it's all right but one problem will be occurred that is StackOverflow.

    // Means Do not move back in the same path and for this thing we need a pointer that will help us to know that hey you can't come back.
    // and 1 call completion we need to change that pointer as well for another calls.

    // All the calls that you are visited mark those as false by the way this is not backtracking, so that it does not go there same like as river problem
    // so if one call is visited then it will create problem for another call due to our original array will be changed.
    // common sense marking false == I have that cell in my current path so when that path is over, for ex. you are in another recursion call
    // those cells should not be false in that case *** while we are moving back we restore the maze as it was. and this is known as BACKTRACKING
    // BACKTRACKING  -> means while we are going back in recursion calls then we will be performing some changes that is known as backtracking and whatever change made via that recursion calls it will restored what it was.
    // means when the function is returned change the changes that you made previously.


    public static void main(String[] args) {
                boolean[][] maze = {
                              {true, true, true},
                              {true, true, true},
                              {true, true, true}
                                                  };
              //  ratInMazeWithBacktracking("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        ratInMazeWithBacktrackingPrintLevelOfRecursion("", maze, 0,0, path, 1);// step is initially 1.
    }
    static void ratInMazeWithBacktracking(String p, boolean[][] maze,  int row, int col){

        if(row == maze.length-1 && col == maze[0].length-1){// id don't put -1 then it will never true because we are only going for length-1
            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }

        // now I am considering this block is in my path hence

        maze[row][col] = false;

        // Down
        if(row < maze.length-1){
            ratInMazeWithBacktracking(p+'D', maze, row+1, col);

        }
        // Right
        if(col < maze[0].length-1){
            ratInMazeWithBacktracking(p+'R', maze, row, col+1);

        }
        // Up
        if(row > 0){
            ratInMazeWithBacktracking(p+'U', maze, row-1, col);

        }
        // Left
        if(col > 0){
            ratInMazeWithBacktracking(p+'L', maze, row, col-1);

        }

        // this line where the function will be over
        // so before the function gets removed , also remove the changes that were made by that function.
        maze[row][col] = true;
    }

    // Print the matrix following the path. It is nothing but print the level of Recursion at you are.

    // so for this we can not pass count variable in argument because it is primitive data types that means it will unique for every level of call
    // that's why we need to put an object type data type that can be ArrayList or array.

    static void ratInMazeWithBacktrackingPrintLevelOfRecursion(String p, boolean[][] maze, int row, int col, int[][] path, int step){
        if(row == maze.length-1 && col == maze[0].length-1){
            // for last step
            path[row][col] = step;

            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][col]){
            return;
        }
        maze[row][col] = false;
        path[row][col] = step;

        // Down
        if(row < maze.length-1){
            ratInMazeWithBacktrackingPrintLevelOfRecursion(p+'D', maze, row+1, col, path, step+1);
        }
        // Right
        if(col < maze[0].length-1){
            ratInMazeWithBacktrackingPrintLevelOfRecursion(p+'R', maze, row, col+1, path, step+1);
        }
        // Up
        if(row > 0){
            ratInMazeWithBacktrackingPrintLevelOfRecursion(p+'U', maze, row-1, col, path, step+1);
        }
        // Left
        if(col > 0){
            ratInMazeWithBacktrackingPrintLevelOfRecursion(p+'L', maze, row, col-1, path, step+1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
