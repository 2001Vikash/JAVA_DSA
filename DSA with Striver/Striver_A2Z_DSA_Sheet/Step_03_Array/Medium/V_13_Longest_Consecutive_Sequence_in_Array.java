package Step_03_Array.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class V_13_Longest_Consecutive_Sequence_in_Array {

    // Problem states that ->
    // You are given an array of integers and our task is to find the longest consecutive Sequence in that array.
    // Consecutive means 1,2,3,4 like that, so we have to maximize this sequence if possible otherwise 1 will always be, as answer because single element be in sequence.



    public static void longestConsecutiveSequence(){
        int[] arr = {102,4,100,1,101,3,2,1,1};
        int n = arr.length;

        // Brute force solution -> As brute force solution will pick one element from the array and search +1 element in the array if found then cnt++, and so on.
        // TC -> o(n^2), SC -> O(1).

        // Better Solution -> As optimal solution we will do via sorting, because We want to bring all consecutive elements in array then apply linear search to get answer.
        // TC -> (n log n) + O(n), SC -> O(n) for merge sorting.

       /* Arrays.sort(arr);
        int longest = 1;
        int cnt = 1;
        for(int i = 0; i < n-1; i++){
            int first = arr[i];
            int second = arr[i+1];
            while(i < n-2 && first == second){
                i++;
                first = arr[i]; second = arr[i+1];
            }
            if(first + 1 == second){
                cnt++;
            }else{
                cnt = 0;
            }
            longest = Math.max(longest, cnt);
        }

        System.out.println(longest);*/

        // OR we can write better solution like that as well.

      /*  Arrays.sort(arr);
        int longest = 1, cnt = 1, pre = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] == pre + 1){
                cnt++;
                pre = arr[i];
            }else if(arr[i] != pre){
                cnt = 1;
                pre = arr[i];
            }
            longest = Math.max(longest, cnt);
        }
        System.out.println(longest); */


        // Optimal solution -> So, we can do it using HashMap, I have done it in level-02 pepcoding hashmap, so here we will apply same concept but with set.
        // Logic is that if we find a previous element then we will be sure that current number is not starting number of sequence then ignore it.
        // TC -> O(N) + O(2N)(near about) , SC -> O(N).

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int it : arr)set.add(it);

        for(int it : set){
            if(!set.contains(it-1)){
                int cnt = 1;
                while (set.contains(it+1)){
                    cnt++;
                    it++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        System.out.println(longest);
    }

    public static void main(String[] args) {
        longestConsecutiveSequence();
    }
}
