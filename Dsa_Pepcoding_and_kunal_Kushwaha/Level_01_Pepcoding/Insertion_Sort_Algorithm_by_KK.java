package Level_01_Pepcoding;
import java.util.Arrays;
public class Insertion_Sort_Algorithm_by_KK {
    public static void main(String[] args) {

        // Insertion Sort --> In this we try to sort array partially. means try to sort parts in parts.
        //                so we select an element and insert the sorted part of the array at the correct position.
        /*
          Time Complexity
                   in worst case (descending sorted) --> O(n^2). and best case (Array is already sorted) --> O(n).
                   total number of comparisons n(n-1)/2.                       total no of comparisons (n-1).
         */
        // Why use Insertion sort ?.
        /* Ans -->
        1 --> It's adaptive means steps get reduced if array is sorted.
              means no. of swapped reduced as bubble sort.
        2 --> It is also Stable
        3 --> Use for smaller value of n means works good when array is partially sorted (means parts in parts)
              that means it takes part in hybrid sorting algorithms (we can say we use it internally in may be merge sort etc).
         */

        int[] arr = {98,-23,-78,0,1,2};

        for (int i = 0; i < arr.length - 1; i++) {// we can put arr.length - 1 with only < also.
                 for(int j = i + 1; j > 0; j--){
                     if(arr[j] < arr[j-1]){
                         int temp = arr[j];
                         arr[j] = arr[j-1];
                         arr[j-1] = temp;
                     }else{
                         break;// because next things are already sorted.
                     }
                 }
        }
        System.out.println(Arrays.toString(arr));
    }
}
