package Step_03_Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class V_23_Merge_Overlapping_Intervals {

    // Problem named as Merge_Overlapping_SubIntervals as well.

    // Problem states that you are given an array of n subIntervals, like {(1,3), (2,6)..}, here 1,3 is SubIntervals, it means that 1 to till 3.
    // And your task is to merge all the overlapping sub-intervals into one, and find out that how many minimum Intervals you can give.
    // Means we can skip any number, means if we are making an Interval then that should be made up of continuous elements.

    public static void mergeOverlappingSubIntervals(){
        int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        int n = arr.length;

        // Brute Force -> In this firstly we will try to club all the intervals using sorting, after that try to merge overlapping sub-intervals
        // if subInterval[i][1] > subInterval[i+1][0].
        // TC -> O(n log n) + O(2*n), not O(n^2), because if we do analysis then we will see that every element are visited twice. SC -> O(n) in worst case.

      /*  Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));// or (a,b) -> a[0]-b[0].
        //for(int[] a : arr) System.out.print(Arrays.toString(a) + " ");

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(ans.size() != 0 && arr[i][1] <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            ArrayList<Integer> li = new ArrayList<>();
            li.add(arr[i][0]);
            li.add(arr[i][1]);
            for(int j = i + 1; j < n; j++){
                if(arr[j-1][1] >= arr[j][0]){
                    li.set(1, Math.max(arr[j-1][1], arr[j][1]));
                }else break;
            }
            ans.add(li);
        }

        System.out.println(ans); */

        // Optimal Approach -> we have to optimize it from O(2n) to O(n). So, TC -> O(n log n) + O(n)

        Arrays.sort(arr, (a,b)-> a[0] - b[0]);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
         /*   if(ans.size() == 0){
                ArrayList<Integer> li = new ArrayList<>();
                li.add(arr[i][0]);
                li.add(arr[i][1]);
                ans.add(li);
            }else{
                if(ans.get(ans.size()-1).get(1) >= arr[i][0]){
                    ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
                }else{
                    ArrayList<Integer> li = new ArrayList<>();
                    li.add(arr[i][0]);
                    li.add(arr[i][1]);
                    ans.add(li);
                }
            } */
            // or
            if(ans.size() == 0 || ans.get(ans.size()-1).get(1) < arr[i][0]){
                ArrayList<Integer> li = new ArrayList<>();
                li.add(arr[i][0]);
                li.add(arr[i][1]);
                ans.add(li);
            }else{
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        mergeOverlappingSubIntervals();
    }
}
