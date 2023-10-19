package Level_01_Pepcoding;
import java.util.*;
import java.util.Arrays;

public class Cyclic_Sort_Most_Important_with_KK {
//    public static void main(String[] args) {
//
//        /* Cyclic Sort -->  for example {3,5,2,1,4} and sort in only using one loop or one traversal. in just one pass.
//            so **--> when given number from range 1 to n --> use cyclic sort. this is pattern for cyclic sort.
//            so above line is most important.
//            that means whenever we see that given number in the range of 1 to n then we need to try for cyclic sort.
//            so in cyclic sort we know that given number in range of 1 to n
//            if n = 5 and given array is like that {3,5,2,1,4} then we know that after sorting of the array
//            array looks like that {1,2,3,4,5} this is nothing but values = index value + 1. because of
//            index starts from 0 and when array is sorted then every element must be at its right position.
//            so in this we check every element of the array that hey it is its right position or not if yes then go
//            for the next otherwise put it at right position means directly swapped with the correct index.
//            and again check that swapped number is at right position or not.
//         */
//
//        int[] arr = {3,5,1,2,4};// elements must be single and consecutive
//        cyclicSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void cyclicSort(int[] arr){
//        int i = 0;
//        while(i < arr.length) {
//           // it is by my own
////            if (arr[i] != (i + 1)){
////                int temp = arr[arr[i] - 1];
////                arr[arr[i] - 1] = arr[i];
////                arr[i] = temp;
////            } else {
////                i++;
////            }
//
//            // new thing which I think but it only works for sorting
////            arr[i] = i+1;
////            i++; // it also works but not a efficient way.
//            int correctIndex = arr[i] - 1;
//            if(arr[i] != arr[correctIndex]){
//                int temp = arr[correctIndex];
//                arr[correctIndex] = arr[i];
//                arr[i] = temp;
//            }else{
//                i++;
//            }
//        }
//    }


    // Questions which is asked in Amazon.
    // Missing number in the given array.

//    public static void main(String[] args) {
//        int[] arr = {4,0,2,1,5,3,7,6,9,8};
//        cyclicSort(arr);
//        int ans = missingNum(arr);
//        System.out.println("Missing number is = "+ans);
//    }
//    static void cyclicSort(int[] arr){
//        int i = 0;
//        while(i < arr.length){
////            if(arr[i] == arr.length){
////                i++;
////               continue;// its means that go from start means I will also remains same we do not change.
////            } // so for this we can use only arr[i] < arr.length && arr[i]!=i in next if
//            if( arr[i] < arr.length && arr[i] != i){
//                int temp = arr[arr[i]];
//                arr[arr[i]] = arr[i];
//                arr[i] = temp;
//            }else{
//                i++;
//            }
//        }
//    }
//    static int missingNum(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//             if(arr[i] != i){
//                 return i;
//             }
//        }
//        return arr.length;// because if array is {0,1,2,3} and n = 4 that means 4 is missing in the array.
//    }



    // Find All Numbers Disappeared in an Array in the given range.
    // asked in Google.

//    public static void main(String[] args) {
//        int[] arr = {4,3,2,7,8,2,3,1,8};
//        cycleSort(arr);
//        System.out.println(missingNumber(arr));
//    }
//    static void cycleSort(int[] arr){
//        int i = 0;
//        while(i < arr.length){
//            int correctIndex = arr[i] - 1;
//            if(arr[i] < arr.length + 1 && arr[i] != arr[correctIndex]){
//                int temp = arr[i];
//                arr[i] = arr[correctIndex];
//                arr[correctIndex] = temp;
//            }else{
//                i++;
//            }
//        }
//    }
//     static List<Integer> missingNumber(int[] arr){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] != i + 1){
//                list.add(i + 1);
//            }
//        }
//        return list;
//   }



    // Find the duplicate number in range (1,n) --> Amazon Question.


//    public static void main(String[] args) {
//         int[] arr = {1,3,4,2,2};
//        System.out.println(findDuplicate(arr));
//    }
//    static int findDuplicate(int[] arr){
//        int i = 0;
//        while(i < arr.length){
//            if(arr[i] != i+1){
//                int correct = arr[i] - 1;
//                if(arr[i] != arr[correct]){
//                    int temp = arr[i];
//                    arr[i] = arr[correct];
//                    arr[correct] = temp;
//                }else{
//                    return arr[i];
//                }
//            }else{
//                i++;
//            }
//        }
//        return -1;
//    }



    // Find all the Duplicates in Array asked in Amazon and Microsoft.


//    public static void main(String[] args) {
//       int[] arr = {4,3,2,7,8,2,3,1};
//       cyclicSort(arr);
//        System.out.println(findAllDuplicates(arr));
//    }
//    static void cyclicSort(int[] arr){
//        int i = 0;
//        while(i < arr.length){
//            int correct = arr[i] - 1;
//            if(arr[i] != arr[correct]){
//                int temp = arr[i];
//                arr[i] = arr[correct];
//                arr[correct] = temp;
//            }else {
//                i++;
//            }
//        }
//    }
//    static List<Integer> findAllDuplicates(int[] arr){
//        ArrayList<Integer> list = new ArrayList<>();
//         for(int index
//             = 0; index < arr.length; index++){
//             if(arr[index] != index+1){
//                 list.add(arr[index]);
//             }
//         }
//        Collections.sort(list);
//        return list;
//    }



    // Set Mismatch


//    public static void main(String[] args) {
//        int[] arr = {1,2,2,4};
//        cyclicSort(arr);
//        System.out.println(Arrays.toString(setMismatch(arr)));
//    }
//    static int[] setMismatch(int[] arr){
//        for(int i = 0; i< arr.length; i++){
//            if(arr[i] != i+1){
//                return new int[]{arr[i], i+1};
//            }
//        }
//        return new int[] {-1, -1};
//    }
//    static void cyclicSort(int[] arr){
//        int i = 0;
//        while(i < arr.length){
//            int correct = arr[i] - 1;
//            if(arr[i] != arr[correct]){
//                    int temp = arr[i];
//                    arr[i] = arr[correct];
//                    arr[correct] = temp;
//            }else{
//                i++;
//            }
//        }
//    }



    // First Missing Positive asked in Amazon.


    public static void main(String[] args) {
        int[] arr = {0,-10,1,3,-20};
        System.out.println(missingPositiveNumber(arr));
    }
    static int missingPositiveNumber(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }

        for(i = 0; i < arr.length; i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return arr.length + 1;
    }
}
