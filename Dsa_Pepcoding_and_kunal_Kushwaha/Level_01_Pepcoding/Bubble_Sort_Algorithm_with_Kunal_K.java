package Level_01_Pepcoding;
import java.util.Arrays;
public class Bubble_Sort_Algorithm_with_Kunal_K {
    public static void main(String[] args) {

        // BUBBLE SORT --> It is also known as Syncing Sort and another name is Exchange Sort.
                              // it is also known as Stable Sorting Algorithm. for ex {10,20,20,30,10} can be sort with it. properties
        // Time complexity of Bubble Sort is O(n^2) and Space Complexity is O(1) that means constant.
        // Constant Space is known as inPlace Sorting Algorithm.
        // Time Complexity Best case : O(n) --> sorted
                         // Worst case : O(n^2).--> sorted in Opposite side.
        // means as the size of array is growing the number of comparison is also growing.

        int[] arr = {1,3,4,2,5,0,3};
        boolean swapped;
        for (int i = 0; i < arr.length ; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i ; j++) {// length - i means in last all elements are sorted.
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
//            if(i==0) System.out.println("It is first max element " + arr[arr.length - 1]);
//            if(i==1) System.out.println("it is second max element "+arr[arr.length - 2]);// and so on.
//            if(swapped){
//                continue;
//            }else{
//                break;// because of Array is already sorted.
//            }
            // or
            if(!swapped)break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
