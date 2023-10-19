package Step_04_Binary_Search.BS_on_Answers;

public class BS_12_Koko_Eating_Bananas {

    // In this problem we have to return the min integer K such that koko can eat all bananas within h hours.
    // In this question we are given an array named as piles and an integer h, every index i having piles[i] bananas.
    // Here K is nothing but K => No. of bananas / hours

    public static int requiredTime(int[] piles, int k){
        int reqT = 0;
        for(int i = 0; i < piles.length; i++){
            reqT += Math.ceil((piles[i] * 1.0) / (k * 1.0)); // 1.0 to get value in decimal. means typecasting
        }

        return reqT;
    }
    public static void kokoEatingBananas(){
        int[] piles = {3,6,7,11};
        int n = piles.length;
        int h = 8;

        // So, as extreme brute force solution that we can think is to start with 1 banana/hour and go till it is not satisfied given time bound.
        // And, we will check till max value of piles because after that if we will increase k's value that hours will be remained same.
        // TC -> O(n * max(piles)).

      /*  for(int i = 1; i < piles[n-1]; i++){
            int reqTime = requiredTime(piles, i);
            if(reqTime <= h){
                System.out.println(i);
                return;
            }
        } */

        // Optimal solution -> Here easily we can see that we have a range in which we have to find our answers, means this belongs Binary on Answers.
        // Means we can apply Binary search over here to reduce the time complexity of this question.
        // As well, it is very important to identify the range that will give minimal time complexity and satisfy our condition as well.
        // TC -> O(log(max(piles) * n);

        int low = 1, high = piles[n-1];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int reqTime = requiredTime(piles, mid);

            if(reqTime <= h){
                // go for more min
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans); // as well, we can return low, instead of returning ans.
        // Because we know that high is standing always possible point and low at that is not possible, when they will end, at that time polarity will
        // also be changed, means low will be standing at min possible point and high will be standing at higher not possible point.
    }

    public static void main(String[] args) {
        kokoEatingBananas();
    }
}
