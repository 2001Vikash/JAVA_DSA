package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_38_Smallest_SubArray_with_All_Occurrences_of_the_Most_Frequent_Element {

    // In this problem you are given an array of integers, you have to find the element x with the maximum frequency in the given array.
    // Also, you have to find the smallest subArray which has all occurrences of the most frequent element that is x.
    // Note -> If there are two or more elements with maximum frequency and the same subArray size then print the subArray which occurs first in the given array.

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2,3,4,2,5,6,5,5,7};
        int n = arr.length;

        HashMap<Integer,Integer> fmap = new HashMap<>(); // to store the frequency of elements in the array.
        HashMap<Integer,Integer> indexMap = new HashMap<>();// to store the starting index of elements
        int highFreq = 0;
        int sInd = 0, eInd = 0;
        int len = eInd - sInd + 1;

        for(int i = 0; i < n; i++){
            if(fmap.containsKey(arr[i])){
                fmap.put(arr[i], fmap.get(arr[i]) + 1);
            }else {
                fmap.put(arr[i], 1);
                indexMap.put(arr[i], i);
            }

            if(fmap.get(arr[i]) > highFreq){
                highFreq = fmap.get(arr[i]);
                sInd = indexMap.get(arr[i]);
                eInd = i;
                len = eInd - sInd + 1;
            }else if(fmap.get(arr[i]) == highFreq){
                int challengeLen = i - indexMap.get(arr[i]) + 1;
                if(challengeLen < len){
                    highFreq = fmap.get(arr[i]);
                    sInd = indexMap.get(arr[i]);
                    eInd = i;
                    len = eInd - sInd + 1;
                }
            }
        }

        System.out.println("Element is = " + arr[sInd]);
        System.out.println("Starting Index = " + sInd + ", ending index = " + eInd);
        System.out.println("Length of the subArray is = " + len);
    }
}
