package Level_01_Pepcoding;
import java.util.Arrays;
public class Bitwise_Operators_and_Number_System_with_KK {
    //  public static void main(String[] args) {

    // Bit manipulation
    // Bitwise Operators

        /*
         1-> AND --> if p and q both are true then it is true otherwise it will be false.
               Note -> when you AND 1 with any number , digits remains the same.

          Question can be asked like that --> Given a number n , find it is even or odd using bitwise operators.

       2 -> OR --> if p and q both are false then result will be false otherwise true.

       3 -> XOR(^) --> (VIP) (if and only if) Also known as Exclusive OR if p and q both are different then answer will be true
                                              otherwise false. or it will give false if both are same.
            Note --> if a^1 = complement of a is answer means anything XOR with 1 you will get opposite of that.
                       and a^0 = a means same. and 0^a = a it's follow associative law
                       a^a = 0 because here is no exclusive or.

       4 -> Complement Operator(~) --> a = 10 then ~a = 01.
        */


    // Number System

        /*
        1 -> Decimal number --> 0,1,2,3,4,5,6,7,8,9 ,  Base : 10.
        2 -> Binary number --> 0 and 1. , Base : 2.
        3 -> Octal number --> 0,1,2,3,4,5,6,7. , Base : 8
        4 -> Hexa Decimal --> 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F , Base : 16.
         */

    // Conversions (Vip)...

        /*
        1 --> conversion from decimal to base 'b'.
           -> keep dividing by base and take remainder and write in opposite

        2 --> Convert any Base 'b' to decimal.
           -> Multiply and add the power of base with digits.
         */

        /*
         continuing with operators...

         5 --> Left shift operator(<<) -> if 10<<1 where 10 is in decimal
                          firstly it will convert into binary then 1010 in binary = 10 in decimal
                          and left shift is = 10100 which is = 20 in decimal.
                Note : -> a << 1 is just double of that number that is 2*a.
                     A general point will be like as if a << b = a * 2^b.

         6 --> Right shift operator(>>) -> if 0011001 >> 1 is = 001100 ignore 1 bit of right most.

            Note : -> a >> b = a / 2^b. its general point.
        */

    // Question --> find a number is that it is odd or even.

    // points -> every number is calculated in binary form internally

// for ex 10011 so all digits have 2^something that is even means if last digit is 1 then number is Odd otherwise even.
    // because all previous have 2 to the power something that is even.
    // means n & 1 == 1 means odd else even because here we only want last digit we put only one and remaining thing
    // will be 0 because they will perform n & 0 except last digit

    // Odd and Even solution

//        int n =68;
//        System.out.println(isOdd(n));
//    }
//    static boolean isOdd(int n){
//        return ((n & 1) == 1);
//        if(n % 2 == 1)return true;
//
//        return false; // so here it will also work because if we want to last digit of the number then we find number % base
    // that is 10 in decimal so here we can also find n % base that is 2 = last digit. last bit is known as Least significant bit


    // Question 2 -> In the given array every number appears twice except one find it.

    // firstly I will try it our normal method that is bruit force then after bitwise operator

//        int[] arr = {1};
//        if(arr.length == 1) System.out.println(arr[0]);
//        // here we can use function and return statement here.
//        Arrays.sort(arr);
//        int i = 0;
//        while(i < arr.length){
//            if((i+2 < arr.length - 1) && arr[i] == arr[i+1]){
//                i+=2;
//            }else{
//                break;
//            }
//        }
//        if(i < arr.length && arr[i] != arr[i+1]){
//            System.out.println(arr[i]);
//        }else{
//            System.out.println(arr[i+2]);
//        }

    // we know that a^a will give 0 that XOR all the numbers and 0 ^ a = a.

//        int[] arr = {2,3,3,4,6,6,4};
//        System.out.println(unique(arr));
//        System.out.println(0^2);
//    }
//    static int unique(int[] arr){
//      int i = 0;
//      for(int j : arr){
//          i ^= j;
//          // we can understand from this question {2,-2,1,-1,3,-4,4} find a number which negative part did not available
//          // we simply do sum and in last we find our ans because all thing will be zero. order does not matter
//          // so exactly same thing we are doing here.
//      }
//      return i;
//    }


    // Question -> Find ith bit of a number for ex -> 10110110 find 5th then ans is = 1. from left to right.
    // Ans -> just and with 1 with that particular bit because we know that whatever we do 'and' with anything we can find same.
    // here we need to mask related to our required number.
    //  n -> mask with n-1 zeros is nothing but 1 << n-1.

    // Another Question can be --> set the ith bit means if 1 then remain 1 and if 0 then change into 1.
    // so here we can use OR operator and for masking XOR operator.

    // Opposite is like that Reset ith bit..
    // if 1 -> 0 and if 0 then 0 -> 1. and for masking we can use ~(1 << (n-1)).


    // Question -> find the position of the right most set bit
    // ex. -> 10110110 looking from the right side which is the set bit the first one that occur from the right hand side.
    // Ans --> n &(-n).

    // Negative of a number in binary form..

    /*
     vip....

     1 byte = 8 bits
     so 10 => let us assume 00001010 if we go from right to left then first bit is LSB which tells us odd or even
               and last bit that is MSB which tells us a number is negative or positive.
               1 -> -ve
               0 -> +ve
               so MSB tells us number is +ve or -ve and after that things defines values of the number.

        Steps to find -ve number in binary
        1 -> find the complement of the number
        2 -> then add with 1 it is also known as 2's complement

        for ex 10 in binary in 1 byte --> 00001010
          so complement --> 11110101
                 and            +  1
                         = 11110110 => -10. means 2's complement of q number will give negative of value of that number.
     */

    /*
    Range of the numbers ::
      if we assume for 1 byte which is equal to 8 bits means 8 boxes in the memory so in binary for every box
        we have to choose to put element 0 and 1.
         so Total different or unique numbers is 2*2..8 times = 256.
         we know that MSB is for -ve or +ve indication of the number that means
         actual number is stored in bits = n - 1 if total bits is = n.
         in 1 byte actual will store in 7 bits and one for sign.
         total I can make from 7 bits = 2^7 = 256. that is 128 -ve and 128 +ve parts.
         Range -> -128 to 127 because 0 is also taken as positive part. and -0 is not a -ve number. it's +ve. we can prove it using complement rule.

          RANGE FORMULA for n bits
           -(2^n-1) to (2^n-1)-1. so using this formula we find range for float, long, int, and so on...for JAVA

     */


    // Question -> What if every number appearing odd times in array except one number find that number.

    // --> This question is not clear I need to understand it with different video.


    // Question -> Find the nth magic number.

    // for example -> the first magic number is equal to write 1 in binary and take the addition power of the 5.
    //              -> 1 = 0 0 1 -> 0*5^3 + 0*5^2 + 1*5^1 = 5
    // 2nd 2 = 0 , 1 , 0 = 25.. and so on. like 30 , 125.....

    /*
    so for ex n = 6 so here we are not going to change it into binary because we know that it will work in binary internally
     in loop -->
                n&1 => This will give me last digit in Binary we can also find it with doing %2
                n>>1 => to ignore last digit we need to right shift we can do it using division by 2.
     */

//    public static void main(String[] args) {
//        int n = 6;
//        int magicNumber = 0;
//        int p = 5;
////        while(n > 0){
////            int lastDigit = n & 1;
////            magicNumber = magicNumber + lastDigit*p;
////            p*=5;
////            n = n>>1;
////        }
//
//        // OR
//
//        while(n > 0){
//            int lastDigit = n % 2;
//            magicNumber += lastDigit*p;
//            p*=5;
//            n = n/2;
//        }
//        System.out.println(magicNumber);
//    }


    // Question -> Find no. of digits in base b.

    /*
    for ex. 6 in base 10 = 1, 6 in binary = 3. so to find in binary no of digits do right shift and count++ till the n!=0
     but there is also a formula to find it directly
      formula =>
               no of digits in base b of no. n ==> int(log n base b) + 1.
     */

    // Time complexity = log n.

//    public static void main(String[] args) {
//        int n = 10;
//        int base = 2;
//        int ans = (int)(Math.log(n) / (Math.log(base))) + 1;// if we want to change it into base b then we need to divide log base
//        // log 10 base 2 / log 5 base 2 = log 10 base 5.
//        System.out.println(ans);
//    }


    // Question -> Find the sum of the nth row in the Pascal's Triangle.

    // sum of each row in the Pascal's Triangle -> nc0 + nc1 + .... + ncn = 2^n
    // so for nth row due to 0 sum = 2^n-1.
    // Ans -> 1 << (n-1) = 1*2^n-1. because of we know that
    //  A general point will be like as if a << b = a * 2^b. here in this question a=1 and b=n-1.

//    public static void main(String[] args) {
//        System.out.println(sumOfPascalTriangleForNthRow(4));
//    }
//    static int sumOfPascalTriangleForNthRow (int n){
//        return 1 << (n-1); // == 1 * 2^n-1.
//    }


    // Question -> You are given a number . find out if its power of 2 or not.
    // so here we need to check if only one '1' is present then it is in power of for ex 100000. if 10001 then it's not.
    // we can do right shift with a count++ when find '1' till number > 0.

    // Can we do it in simpler method -> Yes
    // 100000 = 11111 + 1. means if 100000 ye n hai
    //            and 011111 this is nothing but n-1.
    //             = 0 then power of 2 otherwise not.
    // Ans is n & (n-1) == 0 then Yes otherwise No.


//    public static void main(String[] args) {
//        int n = 2048;
    // here is one exception that n=0 it will give true means we need to fix it
    // if(n==0)return false;
//        if((n & (n-1)) == 0){
//            System.out.println("Its Power of 2.");
//        }else{
//            System.out.println("Its not power of 2.");
//        }
//    }


    // Question -> Find a raise to power b means a^b.

    // We can do it using loop with Time complexity O(b).

    // But here we will try for some different method

    // 3^6 here let n = 6 = 110 means 3^110 = 3^4 * 3^2 * 3^0. because 110 = 1*2^2 + 1*2^1 + 0*2^0 here 1 will give ans ignore 0.
    // here we run no of digits in b times means Time complexity is O(log(b)).

//    public static void main(String[] args) {
//     int base = 2;
//     int power = 12;
//     int ans = 1;
//     while(power > 0){
//         if((power & 1) == 1){
//             ans = ans*base;
//         }
//         base *= base;
//         power = power >> 1;
//     }
//        System.out.println(ans);
//    }


    // Question -> Given a number n , find the no of set bits in it.
    //              means find the number of '1's in the n.

    // first way to solve it take right shift with count variable and condition n&1 == 1.
    // another way is we know that right most we set bit did like that n & -n.

//    public static void main(String[] args) {
//        // count set bit
//
//        int n = 4;
//        // to see binary representation of a number
//        System.out.println(Integer.toBinaryString(n));
//
//        System.out.println(setBits(n));
//        // so here loop will iterate no of 1's in the number.
//    }
//    private static int setBits(int n){// Time complexity O(log n). but it's not clear for me.
//        int count = 0;
//        while(n > 0){
//            count++;
//          //  n = n - (n & -n);
//            //OR
//            n = n & (n-1);
//        }
//        return count;
//    }


    // Question ->  Find XOR of numbers 0 to a.

    // if a = 3 then the ans like that 0^1^2^3.
    /*
    it will come from some pattern when we observe it
     if                              0 --> a (XOR from 0 to a) means 0^1^2^3^....^a.
          a%4 == 0                      a
          a%4 == 1                      1
          a%4 == 2                      a+1
          a%4 == 3                      0
               these four thing are keeping repeat.
     */


    // Question -> XOR of all numbers between a and b.

    // for example if a = 2 and b = 5 then ans = 2^3^4^5
    // but we know that 0^1^2^3^4^5 what is extra 0^1 if again do XOR with extra then this thing will
    // cancel because we know that if we do XOR with same thing then will be canceled. means a^a=0
    // Ans --> if we assume a function which finds XOR 0 to x. means f(x) -> XOR of 0 to x.
    // ans = f(b) ^ f(a-1).

    // if we do XOR for every number then it will be very bad time complexity.

//    public static void main(String[] args) {
//        int a = 3;
//        int b = 9;
//        // range XOR for a , b = XOR(b)^XOR(a-1).
//        int ans = xorOfoToTillNumber(b) ^ xorOfoToTillNumber(a-1);
//
//        System.out.println(ans);
//    }
//    private static int xorOfoToTillNumber(int x){
//        if(x%4 == 0){
//            return x;
//        }else if(x%4 == 1){
//            return 1;
//        }else if(x%4 == 2){
//            return x+1;
//        }
//        return 0; // for x%4 == 3.
//    }


    // Question -> Flipping an Image asked in Google.
    // Reverse an array which contains only 0 and 1 and replace 0 with 1 and vice vesa.
    // for 0 in 1 and 1 in 0 we can do XOR with 1. it will return negation of the number.

//    public static void main(String[] args) {
//        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
//        int[][] ans = flipAndInvertImage(image);
//        for(int i = 0; i < image.length; i++){
//            for (int j = 0; j < image.length ; j++) {
//                System.out.print(ans[i][j] +" ");
//            }
//            System.out.println();
//        }
//    }
//    public static int[][] flipAndInvertImage(int[][] image){
//        for(int[] row : image){
//            // reverse this array
//            for (int i = 0; i < (image[0].length+1)/2 ; i++) {//+1 because we need to XOR with every number.
//                // if we not put +1 then for odd case it will never change middle element.
//                int temp = row[i] ^ 1;
//                row[i] = row[row.length - i - 1] ^ 1;
//                row[row.length - i - 1] = temp;
//            }
//        }
//        return image;
//    }
}