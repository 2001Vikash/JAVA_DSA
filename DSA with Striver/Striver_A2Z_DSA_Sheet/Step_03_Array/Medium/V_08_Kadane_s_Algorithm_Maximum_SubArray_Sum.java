package Step_03_Array.Medium;

public class V_08_Kadane_s_Algorithm_Maximum_SubArray_Sum {

    // Maximum SubArray Sum , as we know that SubArray means contiguous part of the array.

    public static void maxSubArraySum() {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;

        // Brute Force will be try out all the SubArrays and find the maximum sum subArray which will cost time complexity as O(n^3) using three loops.

        // Better approach -> it will be using two loops TC -> O(n^2), means there is not need to re-iteration again and again that we can do brute force work in O(n^2) that will be better approach.

        // Optimal approach => Via Kadane's Algorithm.
        // It says that add the elements into sum variable if sum < 0 then do sum = 0, and also to got max answer make maxi and update it in every iteration if we found good answer.

        // TC -> O(n), SC -> O(1)

        int maxi = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            maxi = Math.max(sum, maxi);
            if(sum < 0)sum = 0;
        }
        System.out.println("Maximum SubArray sum is = " + maxi);


        // To print the subArray will do some extra thing in it, it will be a followup question

        int startInd = -1, endInd = -1;
        int maxSum = Integer.MIN_VALUE;
        int s = 0, start = 0;

        for(int i = 0; i < n; i++){
            if(s == 0){
                start = i;
            }
            s += arr[i];
            if(maxSum < s){
                maxSum = s;
                startInd = start;
                endInd = i;
            }

            if(s < 0)s = 0;
        }

        for(int i = startInd; i <= endInd; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        maxSubArraySum();
    }
}
