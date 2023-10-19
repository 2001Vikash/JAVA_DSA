package Step_03_Array.Hard;

public class V_25_Find_the_Missing_Number_and_Repeating_Number {

    // In this problem we are given an array of integers of size n, and integers can come from 1 to n. So, we have to find the missing numbers.

    public static void missingAndRepeatingNumber(){
        int[] arr = {4,3,6,2,1,1};
        int n = arr.length;

        // Extreme brute force -> go and search for every number, as we know that numbers are coming from 1 to n.
        // TC -> O(n^2).
    /*    int missing = -1, repeating = -1;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
               if(arr[j] == i){
                   cnt++;
               }
            }
            if(cnt == 2)repeating = i;
            if(cnt == 0)missing = i;

            if(repeating != -1 && missing != -1)break;
        }
        System.out.println("(" + repeating + ", " + missing + ")"); */


        // Better solution -> As we know that we have to optimize time so, for this we will use hashing as we know.
        // TC -> O(2n), SC -> O(n).

      /*  int[] hash = new int[n+1];// because we are taking from 1 to 6.
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        }
        int missing = -1, repeating = -1;
        for(int i = 1; i <= n; i++){
            if(hash[i] == 0){
                missing = i;
            }
            else if(hash[i] == 2){
                repeating = i;
            }

            if(missing != -1 && repeating != -1)break;
        }
        System.out.println("(" + repeating + ", " + missing + ")"); */


        // Optimal solution -> Now, we have to remove extra space that we are using, we have to do it in constant space.
        // For this problem we have two optimal solution, one is using basic maths, and second one is using XOR methods.

        // Maths solution ->
        // here in this solution we will be taking two variables like x as repeating, and y as a missing number.
        // in first iteration we will add all arrays elements and, find the first n natural number sum, and subtract them, x-y = something,
        // we know that if we have two unknown variable then we have requirement of two equations to solve them, so that we will do another thing
        // we will find differences => square of every element in array - square of every number from 1 to n, means x^2 - y^2 = something
        // (x-y)(x+y) = something, we have already x-y, then we can find x+y, now we have two equation Now, we can find values of x and y.
        // TC -> O(2n), SC -> O(1).

      /*  long Sn = (n * (n+1)) / 2, S2n = ((n) * (n+1) * (2*n+1)) / 6;
        long S = 0, S2 = 0;
        for(int  i = 0; i < n; i++){
            S += arr[i]; // here we are doing S = S + arr[i], S is long so there is no need for typecasting
            S2 += (long)arr[i] * (long)arr[i]; // but here we have to do it because we are doing multiplication so, they can go beyond integer.
        }

        long val1 = S - Sn; // x-y
        long val2 = S2 - S2n;// x^2 - y^2
        val2 = val2 / val1; // x+y

        long x = (val1 + val2) / 2;
        long y = x - val1;
        System.out.println("Repeating number is = " + x + ", and missing number is = " + y); */


        // Using XOR method -> As we know that any number XOR with 0 will come that number itself, and if XOR with same number will give 0.
        // for better understanding re-watch the video again.

        // If we have two different numbers it means that they are bound to be different in 1 bit minimum, for ex, 001, 101, here we can say that
        // at 2nd index first number is having 0, and second is having 1, means that will be difference bit index, means we have to find first 1 from the right because XOR with different bit will be 1.
        // we have to find that and put the elements in two parts which are having 1 at difference bit index, and second are having 0.
        // now do XOR and at the end we will get out answers.
        // here we are trying to divide numbers according to differentiating index, means if a 2 is part of 0 bit, then other 2 will be coming in this as well.
        // And in last we can not say that missing number is part of 0 bit or 1, we know that we have two numbers, and in that one is missing and another one is repeating.

        // => Algo -> 1. (arr[i]) ^ (1^2^3..) = num
        //            2. find a differentiating bit index in this number, means first 1 from the right.
        //            3. put into them in two parts, one is  bit 0's part and second one is bit 1's part and XOR.

        int xor = 0;
        for(int i = 0; i < n; i++){
            xor ^= arr[i];
            xor ^= (i+1);
        }
        // xor is our number, now we have to find the differentiating bit index.
        int bitNoInd = 0;
        while (true){
            if((xor & (1 << bitNoInd)) != 0){
                break;
            }
            bitNoInd++;
        }

        int one = 0, zero = 0;

        for(int i = 0; i < n; i++){
            if((arr[i] & (1 << bitNoInd)) != 0){
                one ^= arr[i];
            }else{
                zero ^= arr[i];
            }
        }

        // do same thing for 1 to n.
        for(int i = 1; i <= n; i++){
            if((i & (1 << bitNoInd)) != 0){
                one ^= i;
            }else{
                zero ^= i;
            }
        }

        // now check that which one is missing or repeating.

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == one)cnt++;
        }

        if(cnt == 2)System.out.println("Repeating number is = " + one + ", and missing number is = " + zero);
        else System.out.println("Repeating number is = " + zero + ", and missing number is = " + one);
    }

    public static void main(String[] args) {
        missingAndRepeatingNumber();
    }
}
