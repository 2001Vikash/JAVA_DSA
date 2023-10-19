package Level_01_Pepcoding;

public class Recursion_Level_01_with_KK {

    // n = 5 print till 1.

//    public static void main(String[] args) {
//        int n = 5;
//        print(n);
//    }
//    static void print(int n){
//        if(n < 1){
//            return;
//        }
//        System.out.println(n);5,4,3,2,1
//        print(n-1);
 //      System.out.println(n); // 1,2,3,4,5
//    }


    // Factorial of a Number

//    public static void main(String[] args) {
//        System.out.println(fact(6));
//    }
//    static int fact(int n){
//        if( n <= 1){
//            return 1;
//        }
//        return n * fact(n-1);
//    }


    // Sum of N numbers

//    public static void main(String[] args) {
//        System.out.println(sum(5));
//    }
//    static int sum(int n){
//        if(n == 1){
//            return 1;
//        }
//        return n + sum(n-1);
//    }


    // sum of digits.

    // Time complexity is Log(n). means no. of digit in number which is calculated in log(n) time.
//    public static void main(String[] args) {
//        System.out.println(sumOfDigits(8987));
//    }
//    static int sumOfDigits(int n){
//        if(n == 0){
//            return 0;
//        }
//        return (n%10) + sumOfDigits(n/10);
//    }

    // Product of all the digits

//        public static void main(String[] args) {
//        System.out.println(productOfDigits(1342));
//    }
//    static int productOfDigits(int n){
//        if(n == 0){ // or n%10 == n means if one digit remaining then return n that is digit.
//            return 1;
//        }
//        return (n%10) * productOfDigits(n/10);
//    }


    // Concept

//    public static void main(String[] args) {
//       fun(5);
//    }
//    static void fun(int n){
//        if(n == 0){
//            return;
//        }
//        System.out.println(n);
//       // fun(n--); // it's not working
//        //fun(--n); // but it's working
//
//        //  n-- vs --n --> both are equal to n = n-1
//        // but n-- -> It will pass the value of n first then after reduce by 1. means n is remains same.
//        // --n --> it will reduce by 1 first then pass.
//    }


    // Reverse a number using recursion

//    public static void main(String[] args) {
//      //reverse(2435, 0);
//      //  System.out.println(rev2(1234));
//
//         // To check a number is palindrome or not
//        int n = 12321;
//        int rev = rev2(n);
//        if(n == rev){
//            System.out.println("YES it's a palindromic number");
//        }else{
//            System.out.println("NO");
//        }
//    }
//    // first way
//    static void reverse(int n, int sum){ // here we can make sum as Global variable.
//        if(n == 0){
//            System.out.println(sum);
//            return;
//        }
//       int rem = n%10;
//        sum = sum*10 + rem;
//        reverse(n/10, sum);
//    }
//
//    // Second way
//
//    static int rev2(int n) {
//        // sometimes you might need some additional variables in the argument
//        // int that case, make another function
//
//        int digits = (int)(Math.log10(n)) + 1;
//        return helper(n, digits);
//    }
//   private static int helper(int n , int digits){
//        if(n%10 == n){
//            return n;
//        }
//        int rem = n%10;
//        return rem*(int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
//    }


    // This is also help to find palindrome

//    public static void main(String[] args) {
//        int n = 1234;
//        String s = Integer.toString(n);
//        System.out.println(s.charAt(2));
//    }



    // Count the number of zeros in a given number using recursion

    //imp. concept...how to pass a value to above calls.

//    public static void main(String[] args) {
//        int n = 100030; // if we put 0 front of the number then it will take n as octal number
//        System.out.println(countZeros(n,0));
//    }
//    static int countZeros(int n, int count){
//        if(n == 0){
//            return count;
//        }
//        int digit = n%10;
//        if(digit == 0){
//            return countZeros(n/10, count+1);
//        }else{
//            return countZeros(n/10,count);
//        }
//
//    }


    // Number of steps to reduce a number to zero. using recursion


    public static void main(String[] args) {
        int n = 41;
        System.out.println(numberOfSteps(n));
    }
    static int numberOfSteps(int n){
        return helper(n , 0);
    }
    static int helper(int n, int steps){
        if(n == 0){
            return steps;
        }
        if(n%2 == 0){
            return helper(n/2, steps+1);
        }else{
            return helper(n-1, steps+1);
        }
    }
}
