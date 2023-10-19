package Level_01_Pepcoding;
import java.util.Arrays;
public class Recursion_Pattern_Questions_Bubble_sort_Selection_Sort {

    // Printing * pattern using Recursion --> In this case we know that if solve it using iteration method then we need to use of two loops
    // According to that no of loops here in recursion we can use to variable in function as reference.

//    public static void main(String[] args) {
//          int row = 4, column = 0;
//         // triangle(row, column);
//       // System.out.println();
//        //triangle2(0, 0);
//       // System.out.println();
//        triangle3(row, column);
//    }
//    static void triangle(int row, int column){
//        if(row == 0){
//            return;
//        }
//        if(column < row){
//
//            // it is printing * in column.
//
//            System.out.print("* ");
//            triangle(row, column + 1);
//        }else{
//
//            // it is for new line and changing the row
//
//            System.out.println();
//            triangle(row - 1, 0);
//        }
//    }
//    static void triangle2(int row, int column){
//        if(row == 4){
//            return;
//        }
//        if(column <= row){
//
//            // it is printing * in column.
//
//            System.out.print("* ");
//            triangle2(row, column + 1);
//        }else{
//
//            // it is for new line and changing the row
//
//            System.out.println();
//            triangle2(row + 1, 0);
//        }
//    }
//    // Same thing but some changes
//    static void triangle3(int row, int column){
//        if(row == 0){
//            return;
//        }
//        if(column < row){
//
//            // it is printing * in column.
//
//            triangle3(row, column + 1);
//            System.out.print("* ");
//
//        }else{
//
//            // it is for new line and changing the row
//
//            triangle3(row - 1, 0);// here one new line extra due to pop up function in stack then print.
//            System.out.println();
//        }
//    }


    // This Pattern printing is like Bubble Sort instead of printing we need to check or compare every element


//    public static void main(String[] args) {
//        int[] arr = {1,5,4,0,34,12,3};
//        bubbleSortWithRecursion(arr, arr.length - 1, 0);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void bubbleSortWithRecursion(int[] arr , int r, int c){
//        if(r == 0){
//            return;
//        }
//        if(c < r){
//            if(arr[c] > arr[c+1]){
//                // swap
//                int temp = arr[c];
//                arr[c] = arr[c+1];
//                arr[c+1] = temp;
//            }
//            bubbleSortWithRecursion(arr, r, c+1);
//        }else{
//           // System.out.println(Arrays.toString(arr)); // to understand that it is like as bubble sort
//            bubbleSortWithRecursion(arr , r-1, 0);
//        }
//    }



    // Selection Sort with recursion


//    public static void main(String[] args) {
//        int[] arr = {4,3,2,1};
//        selectionSort(arr, arr.length, 0, 0);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void selectionSort(int[] arr , int r , int c, int maxInd){
//        if(r == 0){
//            return;
//        }
//        if(c < r){
//            if(arr[c] > arr[maxInd]){
//                selectionSort(arr, r, c+1, c);
//            }else {
//                selectionSort(arr, r, c+1, maxInd);
//            }
//
//        }else{
//            int temp = arr[r-1];
//            arr[r-1] = arr[maxInd];
//            arr[maxInd] = temp;
//            selectionSort(arr , r-1, 0, 0);
//        }
//    }
}
