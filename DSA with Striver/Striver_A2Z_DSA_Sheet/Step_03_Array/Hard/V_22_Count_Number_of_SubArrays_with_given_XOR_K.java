package Step_03_Array.Hard;

import java.util.Arrays;
import java.util.HashMap;

public class V_22_Count_Number_of_SubArrays_with_given_XOR_K {


    // In this problem we are given an integers array, and an integer k, we have to find a SubArray which XOR will give value K.

    public static void countNumberOfSubArraysWithGivenXorK(){
        int[] arr = {4,2,2,6,4};
        int k = 6;
        int n = arr.length;

        // Brute force -> generate all the subArrays.
        // TC -> O(n^3) near about, SC -> O(1).

       /* int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int xor = 0;
                for(int l = i; l <= j; l++){
                    xor = xor ^ arr[l];
                }
                if(xor == k){
                    cnt++;
                }
            }
        } */

        // Better Solution -> We will generate all subArrays in O(n^2), means we are going to remove third loop as we did previously.
        // TC -> O(n^2), SC -> O(1)

       /* int cnt = 0;
        for(int i = 0; i < n; i++){
            int xor = 0;
            for(int j = i; j < n; j++){
                xor = xor ^ arr[j];
                if(xor == k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt); */


        // Optimal Solution ->  for better understanding at the time of revision please go and watch video again. We are using same concept like as subArray sum.
        // if we have subArray 4,2,2,6 means Is there a subArray ending at 6 & having a XOR of k, (formula : x = XR ^ k), where XR is XOR of till 6, x is XOR of some elements from starting.
        // for ex, if we have XOR = XR till 6, then think hypothetically there are a XOR as x, and some parts are making XOR as k, then x ^ k = XR
        // do a XOR with both side, x^k^k = XR^k => x = XR^K that is our formula.
        // means if someone is from starting giving me XR^k that is x, it means there are some elements which are giving XOR as k that's it.
        // TC -> O(n): depending ono the map , SC -> O(n)

        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int XR = 0;
        map.put(XR, 1);
        for(int i = 0; i < n; i++){
            XR ^= arr[i];
            int x = XR ^ k;
            if(map.containsKey(x)){
                cnt += map.get(x);
            }
            map.put(XR, map.getOrDefault(XR, 0) + 1);
        }
        System.out.println(cnt);
    }

   public static int closest3Sum(int A[], int N, int X)
    {

        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){

            int j = i+1, k = N-1;
            while(j < k){
                int sum = A[i] + A[j] + A[k];
                int dif = Math.abs(X-sum);
                if(sum < X){
                    if(dif < diff){
                        diff = dif;
                        ans = sum;
                    }
                    j++;
                }else if(sum > X){
                    if(dif < diff){
                        diff = dif;
                        ans = sum;
                    }
                    k--;
                }else{
                    return sum;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

      //  countNumberOfSubArraysWithGivenXorK();


        // Another problem different from this particular video.
        int[] arr = {6,-2,-5,7,-9};
        int x = 3;
        int n = 5;
        System.out.println(closest3Sum(arr, n, x));
    }
}
