package Level_01_Pepcoding;
import java.util.*;
public class Pattern_Question_with_KK {
    public static void main(String[] args) {

        // Solve any Pattern Question with this trick.

        /*
         How to approach : for every problem
          steps :
          1 --> no. of lines = no. of rows = no. of times outer loop will run.
          2 --> identify for every row number how many columns are there and types of element in the column (for ex - *,# 1,2 etc.)
          3 --> What do you need to print.
          Note : Try to find the formula relating rows and columns
         */

       // pattern1(4);
       // pattern2(5);
       // pattern3(5);
        // pattern4(5);
       // pattern5(5);
      //  pattern6(5);
       // pattern28(5);
       // pattern30(5);
       // pattern17(5);
        pattern31(5);
    }
    static void pattern1(int n){
        // no. of rows
        for(int row = 1; row <= n; row++){
            // for every row, run the columns
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            // when 1 row is printed , we need to add new line
            System.out.println();
        }
    }
    static void pattern2(int n){
        // no. of rows
        for(int row = 1; row <= n; row++){
            // for every row, run the columns
            for (int column = 1; column <= n; column++) {
                System.out.print("*  ");
            }
            // when 1 row is printed , we need to add new line
            System.out.println();
        }
    }
    static void pattern3(int n){
        // loop will run for every row that is no. of lines
        for(int row = 1; row <= n; row++){
            // identify the column for every row

             for(int col = n; col >= row; col--) {// or col = 1; col <= n - row + 1; col++
                 // print.
                 System.out.print("*  ");
             }
                 System.out.println();
        }
    }
    static void pattern4(int n){
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++){
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        // first loop will run for the no. of lines or rows
        for(int row = 1; row <= 2*n - 1; row++){
            // for col;
            int condition = 0;
            if(row > n){
                condition = n - (row -n);
            }else{
                condition = row;
            }
            for(int col = 1; col <= condition; col++){
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
    static void pattern6(int n){
        // find the no of rows
        for(int row = 1; row <= n; row++){
            // here we need to find row, column relation here is one new thing that is spaces.

            // so this loop is additional and it will work for space handling.
            for(int spaces = 1; spaces <= n - row ; spaces++){
                System.out.print(" ");
            }
            for(int col = 1; col <= row; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern7(int n){

    }

    static void pattern28(int n){
        // first loop will run for the no. of lines or rows
        for(int row = 1; row <= 2*n - 1; row++){
            // for col;
            int condition = 0;
            if(row > n){
                condition = n - (row -n);
            }else{
                condition = row;
            }
            // we need to print some spaces
            for(int spaces = 1; spaces <= n - condition; spaces++){
                System.out.print(" ");
            }
            for(int col = 1; col <= condition; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern30(int n){
        for(int row = 1; row <= n; row++){
            // for spaces
            for(int space = 1; space <= n - row; space++){
                System.out.print("  ");
            }
            for(int col = row; col >= 1; col--){
                System.out.print(col+" ");
            }
            for(int col = 2; col <= row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern17(int n){
        for(int row = 1; row <= 2*n - 1; row++){
            int condition = 0;
            if(row > n){
                condition = n - (row -n);
            }else{
                condition = row;
            }
            // for spaces
            for(int space = 1; space <= n - condition; space++){
                System.out.print("  ");
            }
            for(int col = condition; col >= 1; col--){
                System.out.print(col+" ");
            }
            for(int col = 2; col <= condition; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern31(int n){
       //  n = 2*n;
//        for(int row = 0; row <= 2*n; row++){
//            for(int col = 0; col <= 2*n; col++){
//               int res = n - Math.min(Math.min(row , col) , Math.min(2*n-row , 2*n-col));
//                System.out.print(res+" ");
//            }
//            System.out.println();
//        }

        for(int row = 1; row <= 2*n - 1; row++){
            for(int col = 1; col <= 2*n - 1; col++){
               int res = n - Math.min(Math.min(row , col) , Math.min(2*n-row , 2*n-col));
                System.out.print((res+1)+" ");
            }
            System.out.println();
        }
    }
}
