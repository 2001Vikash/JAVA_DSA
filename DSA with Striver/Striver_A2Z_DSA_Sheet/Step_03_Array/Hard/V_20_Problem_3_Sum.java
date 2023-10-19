package Step_03_Array.Hard;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.*;

public class V_20_Problem_3_Sum {

    // In this problem we have given an array of integers with -ve, +ve values, and we have to find the number of triplets which sum will be zero.
    // we have to take an elements more than once, means if 1 comes two times then we can take, but it is coming at once then we will take only once.
    // As we can not return duplicate triplets. Order can be anything. for the taking unique triplets we can sort then before storing.

    public static void threeSum(){
        int[] arr = {-1,0,1,2,-1,-4};
        int n = arr.length;

        // Brute force -> try out all the unique triplets that will give us sum = 0.

        // TC -> O(n^3) * O(log(unique triplets)), SC -> 2 * O(number of triplets)

     /*   HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                       List<Integer> li = new ArrayList<>();
                       li.add(arr[i]);
                       li.add(arr[j]);
                       li.add(arr[k]);
                       Collections.sort(li);
                       set.add(li);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set); // or we can use ans.addAll(set).
        System.out.println(ans); */

     // Better Solution -> Now we will try to optimize it from N^3 to N^2, probably.
        // So, we know that we have requirement of arr[i] + arr[j] + arr[k] = 0, so, arr[k] = -(arr[i] + arr[j]), so to search arr[k] without looping,
        // we can do it using hashing, but we have to be mindful about the current element if we have taken 1,-2 and ,we are searching for 1,
        // means when we will search 1 then we have to take care about the current 1, we can not take a number twice. we can also maintain it using hash map with index of every element but, we will do it in another way.
        // So, we will put only those elements which are coming in-between i and j.
        // TC -> O(n^2*log(m)), log(m) for set operation., SC -> O(n) + 2*O(no. of triplets).

     /*   HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            HashSet<Integer> st = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int third = -(arr[i] + arr[j]);
                if(st.contains(third)){
                    List<Integer> li = new ArrayList<>();
                    li.add(arr[i]);li.add(arr[j]);li.add(third);
                    Collections.sort(li);
                    set.add(li);
                }
                st.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set); // or we can use ans.addAll(set).
        System.out.println(ans); */

        // Optimal Solution -> In optimal solution we will have to remove the extra space that we are using for finding unique triplets

        // So, we are sorting the triplets first then after storing to avoid from duplicate triplets, so instead of doing this we will sort the array initially.
        // So algorithm will be two pointer approach.
        // TC -> O(n log n) + O(n^2), SC -> O(no of triplets) it is using for returning the list.

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i > 0 && arr[i] == arr[i-1])continue; // for avoiding duplicate triplets because we are not using set data structure for looking this.

            int j = i+1, k = n-1;
            System.out.print(arr[i] + "*");
            while(j < k){
                System.out.print(arr[i] + "+");
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                   List<Integer> li = new ArrayList<>();
                    li.add(arr[i]);
                    li.add(arr[j]);
                    li.add(arr[k]);
                    ans.add(li);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1])j++;
                    while(j < k && arr[k] == arr[k+1])k--;
                    // both loops are using for avoiding the duplicate triplets.
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        threeSum();
    }
}
