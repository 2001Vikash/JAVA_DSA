package DP;

import java.util.Arrays;

public class DP_02_Climbing_Stairs {

    // Problem -> We have to count the no. of distinct way to climb the 1st to nth stairs while we can take 1 or 2 steps.

    // How do I understand that this the problem which can be solved by DP. So for this we have some points to work as sign.
    // -> count the total number of ways
    // -> like multiple ways of doing something so they can ask to use which will give the min or max output.
    // So in these type of questions where we use recursion like (try all possible ways) means
    // -> When ever we find that try all possible ways and find the best or count something then we must try to apply recursion over there.

    // Mote -> When you are going to think about Recursion then you can think about DP but first step is Recursion.
    // So Whenever we tend to apply recursion somewhere then it might be possible DP can work over there.
    // So firstly we need to figure out that this is a Recursive  problem.

    // Whenever we are going to apply DP then firstly we need to write recurrence relation..
    // Important Note *** -> Try to represent the  problem in terms of Index.
    //                    -> Do all possible stuffs on that index according to the problem statement.
    //                   ->  If the question says count all the ways -> Sum of all stuffs
    //                   -> find min -> min (of all stuffs). and same for the max.

    // This three points helps you to write the Recurrence Relation after that we can apply memoization then after we can convert in to DP.

    // So let us take ex. this questions ->
     //  Here we need to go for 0 to n th stairs
    //   so 0, 1, 2 ... n treat them like as index
    // if I am trying for recursion then f(n) -> gives no. of ways(0->n)

    // So it's exactly same as fibonacci problem. But the question requirement is to solve in O(log n) which can be possible by Matrix exponentiation.
    // We can see it in another lecture because constraints are 10^18 that is not going to solve in O(n) TC.

    // Memoization ->

    public static int findAllWays(int n){
        if(n == 0){
            return 1;// If I am at level 0 stairs the I have only one way
        }
        if(n == 1){
            return 1;
        }
        int first = findAllWays(n-1); // that is one step
        int seco = findAllWays(n-2); // that is two step
        return first + seco;
    }
    public static int findWithMemo(int n, int[] Dp){
        if(n <= 1){
            return 1;
        }
        if(Dp[n] != -1){
            return Dp[n];
        }
        return Dp[n] = findWithMemo(n-1, Dp) + findWithMemo(n-2, Dp);
    }
    public static void main(String[] args) {
        int n = 3;
        // via simple recursion
      //  System.out.println(findAllWays(n));

        // via memoization
        int[] DP = new int[n+1];
        Arrays.fill(DP, -1);
        System.out.println(findWithMemo(n, DP));

        // Via Tabulation.

        int pre1 = 1;
        int pre2 = 1;
        for(int i = 2; i <= n; i++){
            int curr = pre1 + pre2;
            pre2 = pre1;
            pre1 = curr;
        }

        System.out.println(pre1);
    }
}
