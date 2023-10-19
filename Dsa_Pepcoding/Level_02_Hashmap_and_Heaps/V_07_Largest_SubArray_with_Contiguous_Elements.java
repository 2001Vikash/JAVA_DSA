package Level_02_Hashmap_and_Heaps;

import java.util.HashSet;

public class V_07_Largest_SubArray_with_Contiguous_Elements {

    // So, in this problem we have to find the largest subArray with continuous elements means repeated elements are also not allowed.
    // Thought process behind this question is if we have a subArray, so, in that subArray, max-min = i-j, it means subArray is having continuous element
    // As well we have to handle duplicate elements, for ex. 9,8,8,6 so 9-6 = 3-0, but they are not right sequence, so we have to handle it.


    public static int solution(int[] arr){
        int n = arr.length;
        int ans = 0;
        for(int i = 0; i < n-1; i++){
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> checkDuplicate = new HashSet<>();
            checkDuplicate.add(arr[i]);
            for(int j = i+1; j < n; j++){
                if(checkDuplicate.contains(arr[j])){
                    break;
                }
                checkDuplicate.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if(max - min == j - i){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {9,2,7,5,6,23,24,22,23,19,17,16,18,39,0};
        System.out.println("Largest SubArray with continuous elements length is = " + solution(arr));
    }
}
