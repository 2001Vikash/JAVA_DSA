package Step_03_Array.Hard;

public class V_18_Pascal_Triangle_Finding_nCr_in_minimal_timing {

    // Before diving into the problem lets know that what is pascal triangle.
    // first row will always be having 1 and in second row, in first and last column are having 1 and so, on for every row,
    // in middle will be previous rows elements sum.

    // In this problem we can have three type of Questions like that :
    // 1. Given R & C tell the element at that place.
    // 2. Print any nth row of pascal triangle.
    // 3. for given n print the entire Pascal triangle.

    // Let us solve the first type, So, if we are given Row and Col then find out the nCr where n = row-1, c = col - 1.

    // nCr = n!/r!*(n-r)! -> to find it in easy/brute way we can find n!, r! and (n-r)! and formulate then. But this is extreme Brute force .
    // Can we do it in short way -> YES => Whatever r we have in nCr, we will expand them that much time we will expand n as well, this is short way to do it.

    // 1.
    public static int nCr(int n, int r){
        // TC -> O(r)

        long result = 1; // for the safe side means for avoiding IntegerOverFlow exception.
        for(int i = 0; i < r; i++){
            result *= (n-i);
            result /= (i+1);  // 10C3 -> 10/1*10/2*10/3 like that, why 1 first because n will be easily divisible
            // after that 2 will come then definitely a number will come which will be divisible by 2, and after that 3 will come and as we know that in continuous three one will be divisible by 3 100%.

        }
        return (int)result;
    }

    // 2. In this as we know that nth row will be having n number of elements for sure this is first observation in it.

    public static void printNthPascalTriangleRow(int n){
        // Brute force, so we know that every number in pascal triangle follow the rule n-Cr-1, so we will do it.
        // TC -> O(n*r) So, can we do it in better way -> Yes

        /*
        for(int c = 1; c <= n; c++){
            System.out.print(nCr(n-1,c-1) + " ");
        }*/

        // Optimal solution -> for n = 6 => 1 5 10 10 5 1 => 1, 5/1, 5*4/(1*2), 5*4*3/(1*2*3), 5*4*3*2/(1*2*3*4), 5*4*3*2*1/(1*2*3*4*5)
        // So here we can easily observe that we are using previous values for calculation next values means instead of calling nCr
        // again and, again we can do via this way using previous values.
        // TC -> O(n), SC -> O(1)

        int ans = 1;
        System.out.print(ans +" "); // i = 0
        for(int i = 1; i < n; i++){
            ans *= (n-i);
            ans /= i;
            System.out.print(ans + " ");
        }
    }

    public static void printEntirePascalTriangle(int n){
        // there is no need to give spaces like pattern printing, only we have to print the values in every row.

        // Naive Brute force can be using formula nCr.
        // TC -> O(row*col*r), that is too much big. => near about O(n^3)

      /*  for(int row = 1; row <= n; row++){
            for(int col = 1; col <=  row; col++){
                System.out.print(nCr(row-1,col-1) + " ");
            }
            System.out.println();
        } */

        // Let us optimize it more.
        // So, to do it we will use second type question concept which will take O(n) to generate a particular row.
        // it means for generating value n rows it will take O(n*n) time means near about O(n^2)
        // And this will be optimal solution for the type three problem in pascal triangle.

        for(int i = 1; i <= n; i++){
            printNthPascalTriangleRow(i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(nCr(10,3));

        // 1. for the given row and column please tell me the number at that place in pascal triangle.
        int row = 5, col = 3; // pascal triangle will always start from 1 index.
      //  System.out.println(nCr(row-1, col-1));

        // 2. Print any given nth row in pascal triangle.
      //  printNthPascalTriangleRow(6);

        // 3. You are given n and, you have to print entire pascal triangle.
     //   printEntirePascalTriangle(6);
    }
}
