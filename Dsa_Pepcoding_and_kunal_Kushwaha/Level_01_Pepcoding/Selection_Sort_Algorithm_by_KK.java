package Level_01_Pepcoding;
import java.util.Arrays;
public class Selection_Sort_Algorithm_by_KK {
    public static void main(String[] args) {

        // In this we select an element and put it on right place/index for that.
        // so we can find max/min element in array and put it at the right index.
        // It's time complexity is O(n^2) for the worst case and in best case O(N).
        // And it also unstable algorithm means it's not stable as bubble sort.
        // so why we use because it performs well on small lists/array.

        int[] arr = {4,5,1,0,-1,2,3};
        for (int i = 0; i < arr.length ; i++) {
            int maxInd = 0;
            for (int j = 0; j < arr.length - i ; j++) {
                if(arr[maxInd] < arr[j]){
                    maxInd = j;
                }
            }
            int temp = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[maxInd];
            arr[maxInd] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
