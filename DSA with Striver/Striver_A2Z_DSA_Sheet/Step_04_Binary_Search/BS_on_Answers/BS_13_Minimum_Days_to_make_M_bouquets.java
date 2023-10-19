package Step_04_Binary_Search.BS_on_Answers;

public class BS_13_Minimum_Days_to_make_M_bouquets {

    // In this problem we have to find Minimum number of days to make M bouquets.

    // In this problem, we are given an array of integers as bloomDays of flowers. which is consisting, blooming days of n flowers.
    // For ex. 0th index flower will be blooming on the 7 th day, according to the given ex. in function.


    public static int isPossible(int[] arr, int day, int k){
        int cnt = 0;
        int n = arr.length;
        int res = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                cnt++;
            }else{
                res += (cnt / k);
                cnt = 0;
            }
        }
        res += (cnt / k);// because, if we will go till last with only if statement then else will never be executed, that's why we have to take care of this.
        return res;
    }

    public static void minDaysToMakeMBouquets(){
        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int n = bloomDay.length;
        int m = 2, k = 3;// here m = no. of bouquets, k = adjacent flowers required.
        // means, we have to make m bouquets, with taking k adjacent flowers from the bloomDays.
        // So, if it is possible, tell me the minimal number of days, otherwise return -1.
        // we have only one impossible case, that is if m * k > n, means we can not make m bouquets with k adjacent flowers.

        // We can surly say, that whatever the max value of the array, will always be possible answer, that will be max as well for the maximum cases.
        // And, min can be, minimal value of the array, if we take less value than min, then we can not see any bloom flower.
        // As, range we can also take 1 to max value of the array, but we have to see more minimize range if possible, Now, here we can see the desire range,

        // Brute force -> TC -> O(n * (max - min + 1), SC -> O(1).

        int day = -1;
        if(m * k > n){
            System.out.println("Not Possible : " + day);
            return;
        }

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int val : bloomDay){
            mini = Math.min(val, mini);
            maxi = Math.max(maxi, val);
        }

      /*  for(int d = mini; d <= maxi; d++){
            int res = isPossible(bloomDay, d, k);
            if(res >= m){
                System.out.println("Min day is = " + d);
                return;
            }
        }
        System.out.println("Not Possible : " + day); */

        // Instead of doing check for every day, as we know we have sorted range, means we can also apply Binary search over here to find answer,
        // means BS on answer.
        // TC -> O(log(max - min + 1) * n), SC -> O(1).

        int low = mini, high = maxi;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int possible = isPossible(bloomDay, mid, k);

            if(possible >= m){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        System.out.println("Min days is = " + ans);
    }

    public static void main(String[] args) {
        minDaysToMakeMBouquets();
    }
}
