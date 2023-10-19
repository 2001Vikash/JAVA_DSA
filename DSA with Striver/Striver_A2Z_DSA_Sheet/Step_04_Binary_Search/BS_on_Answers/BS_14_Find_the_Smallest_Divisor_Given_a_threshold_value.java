package Step_04_Binary_Search.BS_on_Answers;

public class BS_14_Find_the_Smallest_Divisor_Given_a_threshold_value {

    // In this problem we have to find the smallest divisor, for the given threshold value.
    // In this problem, we are given an array of integers and a threshold value, for ex. if we assume that our answer(divisor) will be x, it means
    // if we do division of every array elements with answer, and take the ceil value then after add it up, that should be lesser than equal to threshold value.
    // So, we will start from 1 to between maximum element in the array, and we have to check for every possible answer and take min one.

    public static void smallestDivisor(){
        int[] arr = {1,2,5,9};
        int threshold = 7;
        int n = arr.length;


        // Brute force -> O(n * max(arr)), SC -> O(1).

        int maxi = 9; /// in this question, we have to find it particularly.
      /*  for(int div = 1; div <= maxi; div++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (Math.ceil((arr[i]*1.0) / (div*1.0)));
            }
            if(sum <= threshold){
                System.out.println("Smallest divisor is = " + div);
                return;
            }
        }
        System.out.println("Not found");*/

        // Optimal solution -> As we can see that, this problem is also similar like BS on answers, so here we can apply BS in defined range.
        // TC -> O( log(max(arr) * n), SC -> O(1)

        // So as we know that if we will take max as divisor, then we will find minimal sum = no. of elements in the array,
        // if it is not, means there will be possible divisor.

        if(n > threshold){
            System.out.println("Not possible");
            return;
        }

        int low = 1, high = maxi;
        int divisor = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (Math.ceil((arr[i]*1.0) / (mid*1.0)));
            }

            if(sum <= threshold){
                divisor = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        System.out.println("Smallest divisor is = " + divisor); // "low" will show divisor as well. Due to opposite polarity,
    }

    public static void main(String[] args) {
        smallestDivisor();
    }
}
