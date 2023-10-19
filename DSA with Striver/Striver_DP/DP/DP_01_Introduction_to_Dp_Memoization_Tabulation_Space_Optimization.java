package DP;

import javax.swing.text.TabableView;
import java.util.Arrays;

public class DP_01_Introduction_to_Dp_Memoization_Tabulation_Space_Optimization {

    /*
    Dynamic Programming -> Those who can not remember the past are condemned to repeat it.(famous cote)

                           There are two ways to solve the Dynamic Programming Problems.
                           1 -> Tabulation means Bottom-up DP approach
                           2 -> Memoization means Top-down DP approach(Recursion)
             Bottom up does not mean that go from 0 to n it can be vice versa. it means accumulate the base case and go till ans.
             Top up does not mean that go from n to 0 it can be vice versa according to the condition. it means from start to go for base case.
     */


    // Question 01 --> Fibonacci Number -> In this when we are going to solve it using recursion then we need to face again and same thing to solve
                                         // that is known as Overlapping Sub-Problems so actually
    // When a problem will occur and, it has been solved previously then there is no need to solve again so that is the place
    // where Memoization jumps in -> So memoization means we tend to store the value of sub-problems to again re-use which is saved in some Map/tables
    // If we have one parameter for the recursion call then we need to create 1-D array. and so on.

    //So basically Memoization means nothing but stored a value and when again his requirement will come then return it.

    // There are some steps to convert recursion in to Memoization
    // Firstly we need to create an array of size (n+1) because in Fibonacci 0 is as well.or arrays are 0 based indexing that's why we are doing this.
    // And after that we store the value at the time of returning fib(n-1) + fib(n-2) like that.
    // before the calling of new function call that this value has been called previously or not if yes then return otherwise go. like we can store -1 in array firstly to check that this is called or not


    // Memoization -->
             // means this approach -> TC -> O(n). and Space complexity -> O(n) + O(n).

    public static void main(String[] args) {
        int n = 5;
        int[] DP = new int[n+1];
       // Arrays.fill(DP, -1);
        //System.out.println(fibMemoization(5, DP));
      //  System.out.println(fibTabulation(n, DP));

        System.out.println(fibWithoutExtraSpace(n));
    }
    public static int fibMemoization(int n, int[] DP){
        if(n <= 1){
            return n;
        }
        if(DP[n] != -1){
            return DP[n];
        }
        return DP[n] = fibMemoization(n-1, DP) + fibMemoization(n-2, DP);
    }


    // Tabulation Format -> So how we can convert a recursion in to Tabulation format.(Bottom up)
    // so what is means by bottom up -> means try to go from base case to required answer. means (reverse of recursion).
    // We use here Dp[n+1] as well
    // what is base cae in memoization that's thing we need to do dp[0] = 0 and dp[1] = 1 like that in tabulation for fibonacci
    // and after that try to see recurrence relation

    // TC -> O(n) and SC -> O(n) and there is no any recursion stack space is required.

    public static int fibTabulation(int n, int[] DP){
        DP[0] = 0;
        DP[1] = 1;
        for(int i = 2; i <= n; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }
        int ans = DP[n];
        return ans;
    }


    // Space Optimization -> how do we eliminate O(n) space means a much better way to do it.

    public static int fibWithoutExtraSpace(int n){
        int pre2 = 0;
        int pre1 = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = pre1 + pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}
