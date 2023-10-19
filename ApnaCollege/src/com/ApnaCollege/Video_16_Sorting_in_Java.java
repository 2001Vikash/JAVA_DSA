package com.ApnaCollege;

public class Video_16_Sorting_in_Java {
    // Bubble Sort
    // Time Complexity --> O(n^2)
    public static void printArray(int arr[] ){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
//    public static void main(String[] args) {
//
//
//        int []arr = {7,8,3,2,1,6,6};
//        for(int i=0;i<arr.length-1;i++){//n-1
    // kewal uper wale loop ko reverse kar de to decreasing order me array sort hoga
//            for(int j=0;j< arr.length-1-i;j++){// n-1+n-2+n-3+..
//                if(arr[j]>arr[j+1]){
//                    // Swap--> we can use bitwise operator for swapping and mujhe use explore krna hai
//                    int temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//        printArray(arr);
//    }


    // Selection Sort
    // Time Complexity --> O(n^2)
//    public static void main(String[] args) {
//           int [] arr = {7,7,8,3,3,4,1,1,2};
//           for(int i=0;i<arr.length-1;i++){
//               int smallest=i;
//               for(int j=i+1;j<arr.length;j++){
//                   if(arr[smallest]>arr[j]){
//                       smallest=j;
//                   }
//               }
//               int temp=arr[smallest];
//               arr[smallest]=arr[i];
//               arr[i]=temp;
//           }
//           printArray(arr);
//    }

    // Insertion Sort
    // Time Complexity --> O(n^2).

    public static void main(String[] args) {
        int [] arr = {7,8,3,1,2};
        // for unsorted loop
        for(int i=1;i<arr.length;i++){// first elememtn ko sorted array ka part and baki sabhi ko unsorted
            int current=arr[i];
            int j=i-1;
            while (j>=0 && (current<arr[j])){
                arr[j+1]=arr[j];
                j--;
            }
           // System.out.println(j); jb loop chalega to j=-1 ho jayega
            // placement
            arr[j+1]=current;
        }
        printArray(arr);
    }
}
