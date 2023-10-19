package com.company;

public class CWH_28_Multi_DIm_array {
    public static void main(String[] args) {
        // int [] marks = new int [4]; --> 1-D Array
        int [][] arr = new int[2][3];//--> 2-D Array
        arr [0][0]=101;// so we can also make any dimensions type of array.
        arr [0][1]=102;
        arr [0][2]=103;
        arr [1][0]=201;
        arr [1][1]=202;
        arr [1][2]=231;
        // Display 2-D Array elements.
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
