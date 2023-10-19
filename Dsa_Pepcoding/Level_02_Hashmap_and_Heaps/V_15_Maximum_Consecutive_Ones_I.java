package Level_02_Hashmap_and_Heaps;

public class V_15_Maximum_Consecutive_Ones_I {

    // In this problem we are given an array arr with contains only 0's and 1's. You have to find the maximum number of consecutive one's in the given
    // array if you can flip at most one zero.
    // To solve this problem we will use Acquire and Release strategy.

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,1};
        int n = arr.length;
        // Using for loop.

        int j = -1;
        int ans = 0, cnt0 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                cnt0++;
            }
            while(cnt0 > 1){
                j++;
                if(arr[j] == 0){
                    cnt0--;
                }
            }
            int len = i - j;
            ans = Math.max(ans, len);
        }

        System.out.println("Answer is = " + ans);
    }
}
