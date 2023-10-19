package Level_01_Bit_Manipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class Next_from_Introduction {

    // RightMost set Bit (RSB) means from the right side if we come to left side then whenever first '1' will come that is our RSB.
    // We need to find Right most set bit Mask in O(1).
    // for ex.  0000...26times1001100 for RSB mask => 000....29times100.
    // RSB = x & x'' means 2's complement of x, because any number in case of RSB will see like that A times 1's & 0's 1 B times 0's like that
    // Let us understand how? -> if x = A times 1's & 0's 1 B times 0's
                              //   ~x = A times 0's & 1's 0 B times 1's
                              //    +                                 1
                              // x'' = A times 0's & 1's 1 B times 0's
     //           now x & x'' = A times 0's 1 B times 0's that is a Mask.

    /*
    for ex.  x = 72 = 25 0's 1001000
                ~x =  25 1's 0110111
                            +      1
            x'' = 25 1's 0111000
          x & x'' = 25 0's 0001000 that mask.

          so we know that we can find x'' = (~x + 1) or we can also write -x that is also equal to 2's complement of x.
     */

    public static void main(String[] args) {
//        int n = 72;
//        int rightMostSetBitMask = (n & -n);
//        System.out.println(Integer.toBinaryString(rightMostSetBitMask));

      //  kernighanSAlgo(8);

     //   System.out.println(josephusProblem(8));

        System.out.println(solutionOfNBitGreyCode(3));
    }


    // Kernighan's Algorithm -> Which is used to count set bits in an integer in O(1). here we also see the utility of rightMostSetBitMask.
    // Another way we have to check bits we can take right shift 1 and check for every bit and count but, it's not an efficient way

    // That's why we use Kernighan algo. In this we count only 1 for ex. 00010000100010001 firstly count first 1 then directly jump on 2nd 1 and so on.

// This algo is used in Fenwick Tree.
    public static void kernighanSAlgo(int n){
        int count = 0;
        while(n != 0){
            int rightMostSetBitMask = n & -n;
            n = n - rightMostSetBitMask;
            count++;
        }
        System.out.println("Number of Set Bits is = " + count);// instead of checking every bit here we are only checking set bit. if yes then count++.
    }


  // Question -> Josephus Problem Algorithm using Bit Manipulation.

    // In this question we have for ex. n = 10 , n peoples are sitting in circular manner and kill them alternate manner so in the last whoever remains print.
    // here we are trying to represent every number in the term of (2^x+l) => where (2*l+1) is our survivor.

    // Basically to understand why it is working we need to write  Binary representation of the numbers
    // for ex. 1010 => 1000 + 010 -> 2^x + l like that this is working.

    public static int powerOf2(int n){
        int i = 1;
        while(i * 2 <= n){
            i = i * 2;
        }
        return i;
    }
    public static int josephusProblem(int n){
        int hp2 = powerOf2(n);
        int l = n - hp2;

        return (2*l + 1);
    }



    // Question -> N Bit Grey code. To know about question please refer the Pep coding Video.
    // Grey bit means only change come in one bit.

    public static ArrayList<String> solutionOfNBitGreyCode(int n){ // where n is required bit grey code
        if(n == 1){
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("0");
            baseRes.add("1");
            return baseRes;
        }

        ArrayList<String> result = solutionOfNBitGreyCode(n-1);
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < result.size(); i++){
            String str = result.get(i);
            ans.add("0" + str);
        }
        for(int i = result.size() - 1; i >= 0; i--){
            String str = result.get(i);
            ans.add("1" + str);
        }

        return ans;
    }



    // Question -> Minimum number of Software Developers

    // for ex. we have to hire developers for 5 skills (a, b, c, d, e)
    // and first developer has knowledge about (c, e) and second has (a, b), and third has (b, c, d, e).
    // so find out the no. of minimum no. of developer that can complete our work.


}
