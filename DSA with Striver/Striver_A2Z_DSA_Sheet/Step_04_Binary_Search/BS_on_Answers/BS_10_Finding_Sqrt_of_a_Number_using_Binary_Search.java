package Step_04_Binary_Search.BS_on_Answers;

public class BS_10_Finding_Sqrt_of_a_Number_using_Binary_Search {

    // From here we will start pattern from Binary Search on answers ->

    // Now, first problem is find the sqrt of an integer. We have to return the floor value only, not floor value.

    public static void sqrtUsingBSOnlyForIntegerPart(){
        int n = 25;

        // So, as brute force solution, we can do it linearly, check i = 1 to till cross the given number if we check i * i <= number.

        // Now, as an optimal solution, we will apply BS here, why are we saying, that this belongs to BS on answers because here we can see that till a certain point answer is possible.
        // And, in this case we can apply BS, because here we can eliminate things accordingly.

        int low = 1, high = 25;
        //int ans = 0;
        // but if we see in dry run, then we realize that high will always ends that point from where answer can be possible, and low will always
        // ends that point from where answer will not be possible, so instead of storing answer variable we can directly return high as answer.
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid * mid <= n){
               // ans = mid;
                low = mid + 1;
            }else{
                // not possible
                high = mid - 1;
            }
        }
        System.out.println("SQRT of given number (only integers parts : " + high);// instead of printing answer.

        // So, BS on answers will always focus on range of possible, answers, that will help us to think about Binary search.
        // This question can also be asked in this way, that find out the max possible integer, which on squaring <= number,
        // Or also then can use to ask about min, so these are some points which we have to remember that will help us to identify that this problem can be, solve using BS

    }


    public static void main(String[] args) {
        sqrtUsingBSOnlyForIntegerPart();

    }
}
