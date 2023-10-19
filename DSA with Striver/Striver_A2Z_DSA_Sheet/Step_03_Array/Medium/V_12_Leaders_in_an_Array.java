package Step_03_Array.Medium;

import java.util.ArrayList;

public class V_12_Leaders_in_an_Array {

    // Problem states that find the Leaders in array here Leaders means Everything in the right should be smaller.
    // One thing we have to observe that last element will be always a Leader because there will be no anything in right of last element.

    public static void solution(){
        int[] arr = {10,22,12,3,0,6};
        int n = arr.length;

        // Brute force -> In this way we will select first element as leader and check that if anyone is greater than that then that will be not leader
        // Means if we will not find any greater element then that will be leader. TC -> O(n^2) near about not exactly. O(n) space in worst case

        // Optimal solution -> So, we will find max from last and as we know that if a number which is bigger than the max one it means everything in right
        // All are small so, that will be a Leader.

        ArrayList<Integer> ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for(int  i = n-1; i >= 0; i--){
            if(arr[i] > maxi){
                ans.add(arr[i]);
                maxi = arr[i];
            }
            //maxi = Math.max(maxi, arr[i]);
        }

        System.out.println("Answer is = " + ans);
    }

    public static void main(String[] args) {
        solution();
    }
}
