package Level_01_Pepcoding;
import java.util.ArrayList;
import java.util.Collections;

public class Maths_for_DSA_with_KK {

    // Prime Numbers -> A number who is divisible by 1 and itself is known as Prime Number. for ex : 2,3,5,7...
    //               --> that number who dived prime or non-prime numbers must be positive. negative numbers are ignored. they are not prime.

    // 1,2,3,4,5,6,7,8,9,10,11,12,13. so here we ignore 1 and 13 and if in between any number is divide 13 then 13 is not prime
    // otherwise prime.
    // find 13 is prime or not.
//    public static void main(String[] args) {
//        int n = 88;
//        System.out.println(prime(n));
//    }
//    private static boolean prime(int n){
//        for (int i = 2; i < n; i++) {
//            if(n%i == 0){
//                return false;
//            }
//        }
//        return true;
//    }

    // Lets another example 36.
       /*
       1 * 36
       2 * 18
       3 * 12
       4 * 9
       same thing after 6 it will just reverse
       6 * 6
       do we really need to check it that if 3*12 = 36 then 12*3 = 36 off course Not. means we can ignore.
       9 * 4
       12 * 3
       18 * 2
       36 * 1
        */
    // Hence only make check for numbers <= sqrt(n). ignore next thing because due same thing.
    // And it will also reduce Time complexity O(n) to O(sqrt(n)).

    // Time complexity -> O[sqrt(n)].

//    public static void main(String[] args) {
//        int n = 13;
//        System.out.println(isPrime(n));
//    }
//    static boolean isPrime(int n){
//        if(n <= 1){
//            return false;
//        }
//        for(int i = 2; i*i <= n; i++){
//            if(n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }

    // 1 is neither composite nor prime.

    // Question --> Find the all prime numbers till given number n.

    // Firstly we can solve it using bruit force solution for checking every number. that is O(more than n^2 like that may be n^3).
    // if we go for sqrt(n) then for printing every number total complexity will be O(n*sqrt(n)).

    // Can we solve it more optimize way --> YES

    // we know that if we check for 37 then if 2 is prime then can we need to check for multiples of 2 . -> NO
    // One more thing is also we need to focus that whenever we eliminate for 2 then it will also contain some part of 3. for ex 18
    // and it will also go till sqrt and remaining all thing will be Prime. It is also known as Sieve of Eratosthenes.

//    public static void main(String[] args) {
//        int n = 40;
//        boolean[] primes = new boolean[n+1]; // because we want included 40 also.
//        // Initially all the elements in boolean array are going to be false.
//        sieveOfEratosthenes(n, primes);
//    }

    // let's assume that false in array means Number is Prime

    // Space complexity --> Auxiliary space O(n).

    // Time complexity --> if we assume max part of calculation then
               //  we need to check 2nd loop --> n/2 + n/3 + n/5 + n/7 ... = n*log(log(n)).
      // TC -> O(n*log(log n)).

//    static void sieveOfEratosthenes(int n , boolean[] primes){
//        for(int i = 2; i*i <= n; i++){
//            if(!primes[i]){
//                for(int j = i * 2; j <= n; j = j + i){
//                    primes[j] = true;
//                }
//            }
//        }
//        for(int i = 2; i <= n; i++){
//            if(!primes[i]){
//                System.out.print(i+" ");
//            }
//        }
//    }


    // Ways to find Square root of a number..

    // for ex. if want to find sqrt of 36 that is 6 then we can check from 1 to till ans like this
    //        2*2 is = 36 no it's not and so on if a given number is perfectly square then we can find.
    // We know that whenever we work on sorted series in a range then we can apply there Binary Search.
    // It is only for perfect square number

 //   public static void main(String[] args) {
 //       int n = 31;
   //     int ans = squareRoot(n);
//        if(ans == -1){
//            System.out.println("Given Number is not a perfect square");
//        }else{
//            System.out.println(ans);
//        }
//    }
//    static int squareRoot(int n){
//        int start = 0;
//        int end = n;
//        while(start < end){
//            int mid = start + (end - start)/2;
//            if(n == mid*mid){
//                return mid;
//            }
//            if(n < mid*mid){
//                end = mid - 1;
//            }else{
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }

    // If we want decimal value also then for ex. 40 have not perfect sqrt then we go for a perfect sqrt which is less
    // than 40 then we increment value in decimal that's why we can find our answer.

    // Time complexity --> (log n) because for decimal thing we can neglect due less dominating term.

//    public static void main(String[] args) {
//        int n = 40;
//        int precisionValue = 3;// it means how many decimal value you want
//        System.out.printf("%.3f" , binarySearchSQRT(n, precisionValue));
//    }
//    static double binarySearchSQRT(int n , int p){
//        int start = 0;
//        int end = n;
//        double squareRoot = 0.0;
//
//        // for perfect sqrt as well as integer value of decimal answer.
//        while (start <= end){
//            int mid = start + (end - start) / 2;
//            if(mid*mid == n){
//                return mid;// root == mid -> it is perfect sqrt.
//            }
//            if(mid*mid > n){
//                end = mid - 1;
//            }else{
//                start = mid + 1;
//            }
//        }
//        squareRoot = end;
//
//        // for decimal values.
//        double increment = 0.1;
//        for (int i = 1; i <= p; i++) {
//            while (squareRoot*squareRoot <= n){
//                squareRoot += increment;
//            }
//            squareRoot -= increment;
//            increment /= 10;
//        }
//
//        return squareRoot;
//    }


    // There is another method to find sqrt that is NEWTON RAPHSON METHOD.

    // formula = (x + n/x) / 2. where x is sqrt we have assumed that is closest to our answer and perfect value for perfect sqrt.

    // It's biggest edge is that it will reduce errors. whatever possible
    // error = |root - x|

    // first step -> Assign x to n
                // -> lets assume that you will find your answer when error < 1
                // -> update the value of x = root.

    // Time complexity -> O((log n) f(n)) where f(n) = cost of calculating f(x)/f'(x) with some n digit precision
    // It is taken from fast fourier transform


//    public static void main(String[] args) {
//        double n = 49.0;
//        System.out.println(newtonSQRT(n));
//    }
//    static double newtonSQRT(double n){
//        double x = n;
//        double root;
//        while (true){
//             root = (x + (n/x)) / 2;
//            if(Math.abs(root - x) < 0.5){
//                break;
//            }
//            x = root;
//        }
//        return root;
//    }



    // Factors of a number

    // n = 20 then factors of 20 is = 1,2,4,5,10,20.
    // we can use a loop and check 1 to till n that which number divide it then we can get answer with O(n) time complexity

//    public static void main(String[] args) {
//        int n = 20;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if(n % i == 0){
//                list.add(i);
//            }
//        }
//        System.out.println("These are factors of "+ n +" = " + list);
//    }

    // Problem in this code is something we are repeating here 20%1 yes means 20 * 1 = 20 and we are also checking for
    //   20 % 20 yes means 1 * 20 = 20. this is repeating we find it divide by first factor means only go for till sqrt value

    // And now Time complexity is O(sqrt(n)).

//    public static void main(String[] args) {
//        int n = 20;
//        for (int i = 1; i*i <= n ; i++) {
//            if(n%i == 0){
//                if(n/i == i){
//                    System.out.print(i+" ");
//                }
//                System.out.print(i+" "+ n/i + " ");
//            }
//        }
//    }


    // Both time complexity O(sqrt(n)) and space complexity for sorting.


//        public static void main(String[] args) {
//        int n = 36;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i*i <= n ; i++) {
//            if(n%i == 0){
//                if(n/i == i){
//                   // System.out.print(i+" ");
//                    list.add(i);
//                }else {
//                    // System.out.print(i+" "+ n/i + " ");
//                    list.add(i);
//                    list.add(n/i);
//                }
//            }
//        }
//            Collections.sort(list);
//            System.out.println(list);
//    }



    // Some modulo(%) properties....

    /*
    * -> (a+b)%m = ((a%m) + (b%m)) % m.
    * -> (a-b)%m = ((a%m) - (b%m)) % m.
    * -> (a * b) % m = ((a%m)*(b%m)) % m
    * -> (a/b) %m = ((a%m) * (b^-1 % m)) % m. here b^-1 is also known as multiplicative modulo inverse where b and m are co-primes
    * -> co-primes means a and b is said to be co-prime if there is no any common factor except 1.
    * -> (a%m)%m = a%m.
    * -> m^x % m = 0 for all x > 0. means for +ve value of x.
    * -> Extra: If p is a prime number which is not a divisor of b, then ab^p-1 % p = a % p due to formats little theorem which will covered in Advance DSA course

     */


    // Die - Hard example it is like as we have 8 litre milk we need to give 4 litre milk in two places using 3 and 5 litre napna.

}
