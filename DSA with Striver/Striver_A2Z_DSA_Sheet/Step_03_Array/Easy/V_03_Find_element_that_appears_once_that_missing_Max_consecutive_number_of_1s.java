package Step_03_Array.Easy;

public class V_03_Find_element_that_appears_once_that_missing_Max_consecutive_number_of_1s {

    // Question 1: Find missingNumber in an array

    // Problem states that we are given N-1 numbers in an array from 1 to N, so we have to find the missing number.

    public static void missingNumber(){
        int n = 6;
        int[] arr = {1,2,3,4,6};

        // Brute force -> we will do it in O(n^2), let us take 1 and do linear search, if not found then that will be our answer.

        // Better solution via Hashing
        /*

       // TC -> O(n) + o(n), SC -> O(n)

        int[] hash = new int[n+1];
        for(int i = 0; i < arr.length; i++){
            hash[arr[i]] = 1;
        }
        int ansInd = -1;
        for(int i = 1; i <= n; i++){
            if(hash[i] == 0){
                ansInd = i;
                break;
            }
        }
        System.out.println(ansInd);*/


        // Optimal Solution => There will be two optimal solution one is sum, another one is XOR.

        // using sum

        // Sum of first n natural numbers = n(n+1)/2

        /*
        int totSum = (n * (n+1)) / 2; // it can give integerOverFlow exception when inout is big, that's why next solution is slightly better than this. XOR never exceed the int max value
        int sum = 0;
        for(int it : arr)sum += it;
        int ans = totSum - sum;
        System.out.println(ans);*/

        // using XOR => XOR with same numbers will always be 0, And, O XOR with any number will be that number.
        int ans = n;
        int i = 1;
        for(int it : arr){
            ans ^= it ^ (i++);
        }

        System.out.println(ans);
    }

    // Maximum consecutive 1's

    public static void maxConsecutiveOnes(){
        int[] arr = {1,1,0,1,1,1,0,1,1};
        int maxAns = (int)-1e9;
        int cnt = 0;
        for(int it : arr){
            if(it == 1){
                cnt++;
            }else{
                cnt = 0;
            }
           maxAns = Math.max(maxAns, cnt);
        }
        System.out.println("Maximum consecutive 1's is = " + maxAns);
    }

    // Question 2: Find the number that appears once and other are twice.

    public static void numberThatAppearsOnce(){

        // Brute force solution can be using two loops
        // we will try to count the number of occurrence of every element into the array, and check that whose element is having occurrence as 1 that will be our answer.

        int[] arr = {1,4,3,2,3,1,4};
        // Better solution can be using Hashing.
        // For Hash array size, we will find max element in array then after we will make that max+1, size.
       /*
        int maxi = arr[0];
        for(int i = 1; i < arr.length; i++)maxi = Math.max(arr[i], maxi);

        int[] hash = new int[maxi+1];

        for(int i = 0; i < arr.length; i++){
            hash[arr[i]]++;
        }
        int ans = -1;
        for(int i = 0; i < arr.length; i++){
            if(hash[arr[i]] == 1){
                ans = arr[i];
                break;
            }
        }
        System.out.println("Element " + ans + " is coming only once in the array rest of all are coming twice");

        Note -> Instead of using HashArray, If we use HashMap, then that will be more effective for this problem as well for -ve values, and for bigger values
                So, in hashMap, we will make frequency map and check that which element is having 1 frequency that will be our answer.
        */


        // Optimal solution will be done vai XOR. As we know that XOR with same numbers will give 0, and XOR with 0 means that number itself.

        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        }
        System.out.println("Element " + xor + " is coming only once in the array rest of all are coming twice");
    }

    public static void main(String[] args) {

       // missingNumber();

       // maxConsecutiveOnes();

        numberThatAppearsOnce();

    }
}
