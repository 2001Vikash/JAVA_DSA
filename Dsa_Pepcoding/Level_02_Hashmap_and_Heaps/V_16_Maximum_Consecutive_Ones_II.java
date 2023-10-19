package Level_02_Hashmap_and_Heaps;

public class V_16_Maximum_Consecutive_Ones_II {

    // In this problem you are given an array which contains only 0's and 1's and a number K.
    // You have to find the maximum number of consecutive 1's in the given array if you can flip at most K 0's.

    // To solve this problem we will be using Acquire and Release Strategy.
    // In solution, we will acquire elements till it is valid means at most k 0's, then collect the answer then after release it till it is invalid.



    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,0,1,0,1,1};
        int n = arr.length;
        int k = 2;

        /*
        int i = -1, j = -1, ans = 0;
        int cnt0 = 0;

        while(true){
            boolean f1 = false, f2 = false;
            // acquire
            while(i < n-1){
                i++;
                f1 = true;
                if(arr[i] == 0){
                    cnt0++;
                }
                if(cnt0 <= k){
                    int len = i-j;
                    ans = Math.max(len, ans);
                }else{
                    break;
                }
            }
            // release

            while(j < i){
                j++;
                f2 = true;
                if(arr[j] == 0){
                    cnt0--;
                }
                if(cnt0 == k){
                    break;
                }
            }

            if(!f1 && !f2)break;
        } */

        // Using for loop.

        int j = -1;
        int ans = 0, cnt0 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                cnt0++;
            }
            while(cnt0 > k){
                j++;
                if(arr[j] == 0){
                    cnt0--;
                }
            }
            int len = i -j;
            ans = Math.max(ans, len);
        }

        System.out.println("Answer is = " + ans);
    }
}
