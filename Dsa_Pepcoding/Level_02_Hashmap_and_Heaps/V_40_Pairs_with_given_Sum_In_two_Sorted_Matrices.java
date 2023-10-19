package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_40_Pairs_with_given_Sum_In_two_Sorted_Matrices {

    // In this problem you are given a number N, and two matrices A and B with N * n dimension.
    // You are also given a number 'x', you have to find the count of all valid pairs from matrices whose sum is equal to the 'x'.
    // A pair is called valid if one element of the pairs is selected from the A and second one is selected from the B.

    // So, as we know that if we have a sorted array and, we have to do this same thing, then we were doing using two pointer method as optimal solution.

    // As Brute force solution, we can do it in O(n^4), means scan both matrices together, and try to find out the pairs. or we can say that generate all the pairs and check that which are giving 'x'.
    // Second approach, can be using HashMap(frequency map), we will store every element of A in Map and do iteration on B, and check that, X - B[i][j] is present in map or not if yes then do cnt++.
    // And, last one will be using two pointer that will be optimal solution.


    public static int betterSolution(){
        // TC -> O(n^2), SC -> O(n^2)

        int n = 3;
        int[][] A = {{1,5,6},{8,10,11},{15,16,18}};
        int[][] B = {{2,4,7},{9,10,12},{13,16,20}};
        int x = 21;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int[] a : A){
            for(int val : a){
                map.put(val, map.getOrDefault(val, 0) + 1); // to handle duplicate elements, if 1,1 is coming twice, then it may be give 2 pairs
            }
        }

        int cnt = 0;

        for(int[] b : B){
            for(int val : b){
                int req = x - val;
                if(map.containsKey(req)){
                    cnt += map.get(req);
                }
            }
        }

        return cnt;
    }

    public static int optimalSolution(){

        int n = 3;
        int[][] A = {{1,5,6},{8,10,11},{15,16,18}};
        int[][] B = {{2,4,7},{9,10,12},{13,16,20}};
        int x = 21;

        int cnt = 0;

        for(int i = 0, j = 0; i < n && j < n; i++, j++){

        }

        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(betterSolution());
    }
}
