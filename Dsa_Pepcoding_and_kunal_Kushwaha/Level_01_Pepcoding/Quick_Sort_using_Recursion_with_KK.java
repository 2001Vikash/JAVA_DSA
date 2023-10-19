package Level_01_Pepcoding;
import java.util.Arrays;
public class Quick_Sort_using_Recursion_with_KK {
    /*
    Quick sort is also using to sort an array but question is how

        * Pivot -> choose any element -> after first pass all the elements is less than pivot will be on LHS of pivot and greater RHS on Pivot

         We know that in bubble sort after every pass largest element get placed at last index but

           here unique thing is that  after every pass Pivot will be at its right position

           Here one nice difference than merge sort
            if array is sorted then in merge sort recursion call go till end but in quick sort if sorted then it will never go next.
            and here space complexity is also constant O(1).

        ** How to put Pivot at correct position ?

          * we take 2 pointers start and end  and assume pivot.
          * whenever we find a violation LHS and RHS of the Pivot swap it
          * and also will take low and high pointer to know that which position you are working now.

          * Let's assume that we always pick last element of the array as Pivot. But we can pick it randomly

        **  How to pick Pivot ->
                * we can pick random element
                * we can pick normal element
                * or we can pick middle element always.

      *** Recurrence Relation for the Quick sort.. very important..
          T(n)  =  T(k)     +   T(n-k-1)    +    O(n).
               for sort LHS   for sort RHS    putting Pivot at correct Position

      Worst case :
                   When we pick pivot as max(may be min) element which is at last index then recursion call reduced n-1 very small than n/2 like that
                means when k = 0 means one part of the array is empty.

        Time Complexity :
                          when k = 0 T(k) will be = T(0) and T(n-k-1) = T(n-1)
                          T(n) = T(n-1) + O(n).
                 -> O(n^2) => check space and time complexity lecture for complete derivation

      Best case : T(n) = T(n/2) T(n/2) + O(n) means pivot is middle element and at correct index. O(n*log(n)) that is merge sort


      ***  Very Important Note for Quick Sort:

                * Not stable (defined stability in previous videos)
                * In-Place that is why preferred for the array means no extra space yes of course recursion will take space but no extra space
                      like as merge sort. we know that in merge sort we make mix array which is take O(n) extra space
                * Merge sort is better in the linked list due to memory allocation that is not continuous.


        --> we can explore : Hybrid Sorting Algorithm (Tim Sort) : We use merge sort + Insertion sort(IS works well with partially sorted data)

                            In java some internal sorting algorithm like for arrays (Arrays.sort() ) and for list (Collections.sort() ).
     */

    public static void main(String[] args) {
        int[] arr = {10, 15,12,8,9,16};
      //  quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static void quickSort(int[] arr, int low, int high){ // low and high to know that which part of array is in using.
        if(low >= high){
            return;
        }
        // And s and e for swapping
        int s = low;
        int e = high;

        int mid = s + (e-s) / 2;
        int pivot = arr[mid]; // here I assume middle element as Pivot.

        // also a reason why if its already sorted it will not work.

        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            // when find violation either in LHS or RHS then swap
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // Now my pivot is at correct position then Please sort two half of the array basically go for the recursion call
        quickSort(arr ,low , e);
        quickSort(arr, s, high);
    }
    static void quickSort2(int[] arr, int low, int high){
        if(low < high){
            int j = partioning(arr, low, high);
            quickSort2(arr, low, j);// here j will sorted then why we take it because of this is work for biggest end element of that
            quickSort2(arr, j+1, high);
        }
    }
    static int partioning( int[] arr, int l, int h){
        int i = l;
        int j = h;
        int pivot = arr[i];
        while(i < j){
            // left hand side of the pivot
//            do{
//                i++;
//            }while (i < arr.length && arr[i] <= pivot);
            while(i < arr.length && arr[i] <= pivot){
                i++;
            }
            // Right hand side of the pivot
//            do{
//                j--;
//            }while (j >= 0 && arr[j] > pivot);
            while(j >= 0 && arr[j] > pivot){
                j--;
            }

            // swapping

            if(i < j){
                swap(arr, i, j);
            }
        }
        // j is right position for the pivot
        swap(arr, l, j);
        return j;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
