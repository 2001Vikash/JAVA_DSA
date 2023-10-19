package Step_03_Array.Hard;

public class V_28_Maximum_Product_SubArray {

    // In this problem we are given an integers array, and we have to find the maximum product subArray in the given array. Array can contain -ve, +ve both.
    // And, as we know that subArray means any contiguous part of the array will be known as subArray of that array.

    public static void maximumProductSubArray(){
        int[] arr = {2,3,-2,4};
        int n = arr.length;

        // If this problem comes in Interview then we will start elaborating from Brute to optimal solution.

        // Brute force -> In this we will generate all the subArrays and try to find out the product of them, and maximize.
        // TC -> O(n^3) near about, SC -> O(1).

 /*       int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int pr = 1;
                for(int k = i; k <= j; k++){
                    pr *= arr[k];
                }
                maxProduct = Math.max(maxProduct, pr);
            }
        }
        System.out.println(maxProduct); */

        // Better Solution ->  In this we will be solving in O(n^2), means we are going to remove last loop in previous solution.

       /* int maxPr = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int pr = 1;
            for(int j = i; j < n; j++){
                pr *= arr[j];
                maxPr = Math.max(maxPr, pr);
            }
        }
        System.out.println(maxPr);*/


        // Optimal Solution -> Now we have to move for the Optimal solution, means we have to do it may be in O(n), or little-bit more.

        // For this problem we are having two optimal solution one is based on Observation based which is more intuitive,
        // and second one is using modification of Kadane's Algorithm.
        // Note -> Never tell to the interviewer second solution as optimal because that is not intuitive, just you have to see for the knowing purpose not for the interviewer.

        // So, here we will be learning Observation based solution because it is having same time complexity, much more intuitive as well.

        // Observations -> If array contains elements like this,
        //                1. All +ve -> then do multiplication of all and, that will be our answer.
        //                2. Even -ve, others are +ve -> do the same thing as above.
        //                3. Odd -ve, others are +ve -> So, removal of 1-ve out of odd number of -ve will leave us with even number of -ve, hence the idea
        //                   is to remove 1 -ve, so we now see which 1 -ve to remove, and on removal how is the array shaped.
        //                   So, whenever we will ignore 1 -ve, means we will have two possibly subArrays exist, and check them. and as well we have to see that two -ve comes in one subArray, that is only, way to maximize.
        //                   means, whenever we ignore one -ve, we will have suffix, and prefix subArrays as answer, so do that.
        //                4. What if we will have 0 => So, ignore the 0 and take all subArrays ignoring 0, take max of all. means in the way if we will see the product as 0, starts from 1.


          int prefix = 1, suffix = 1, maxPr = Integer.MIN_VALUE;

          for(int i = 0; i < n; i++){
              if(prefix == 0)prefix = 1;
              if(suffix == 0)suffix = 1;

              prefix *= arr[i];
              suffix *= arr[n-i-1];

              maxPr = Math.max(maxPr, Math.max(prefix, suffix));
          }

             System.out.println(maxPr);
    }


    public static void main(String[] args) {
        maximumProductSubArray();
    }
}
