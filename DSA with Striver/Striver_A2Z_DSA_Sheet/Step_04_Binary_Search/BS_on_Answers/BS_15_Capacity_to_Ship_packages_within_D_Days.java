package Step_04_Binary_Search.BS_on_Answers;

public class BS_15_Capacity_to_Ship_packages_within_D_Days {

    // In this problem, we have to find the "Least" capacity to ship packages with in "D" days.
    // In this problem, we have one ship, and N items or products which is given in the form of array. each of this products are having weight that is weights[i].
    // And ship will run once per day.
    // And, we have to minimize the capacity of ship, to deliver the products within the given days.

    // So, if we will be trying to find the capacity, then we will realize that, min capacity is required as max weight in array, of we will go down to that, then we can not do work.
    // And, for the max range, it will be sum of all the given elements, means we can say that if ship is having capacity of sum, it means ship can deliver the product in one day.
    // Means we can surly say that, the answer will be in between max of array and sum of all elements of the array.

    public static int daysRequired(int[] weights, int capacity){
        int days = 1, load = 0;

        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > capacity){
                days = days + 1;
                load  = weights[i];
            }else {
                load += weights[i];
            }
        }

        return days;
    }

    public static void capacityToShipPackages(){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int n = weights.length;

        // Brute force -> O((sum - max + 1) * n), SC -> O(1).

        int max = 10, sum = 55;

      /*  for(int capacity = max; capacity <= sum; capacity++){
            if(daysRequired(weights, capacity) <= days){
                System.out.println("Min capacity is = " + capacity);
                return;
            }
        }

        System.out.println("Not possible"); */


        // We can solve this question using BS on Answer, because we are having a range, and in this we have to find the minimal answer.
        // TC -> O(log(sum-max+1) * n), SC -> O(1)

        int low = max, high = sum, ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(daysRequired(weights, mid) <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        System.out.println("Capacity is = " + ans); // low can also answer due to opposite polarity.
    }

    public static void main(String[] args) {
        capacityToShipPackages();
    }
}
