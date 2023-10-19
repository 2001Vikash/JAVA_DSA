package Step_04_Binary_Search.BS_on_Answers;

public class BS_11_Find_the_Nth_root_of_an_Integer {

    // In this problem, we have to find the Nth root M. for ex, if N = 3, M = 27 => three root of 27 = 3.
    // if Nth root is not possible then return -1.


    public static int power(int a, int b){ // this is via using recursion.
        if(b == 1){
            return a * b;
        }

        int ans = powerOf(a, b/2);

        if(b % 2 == 0){
            return ans * ans;
        }else{
            return a * ans * ans;
        }
    }
    public static int powerOf(int a, int b){
        int ans = 1;
        while(b > 0){
            if(b % 2 == 1){
                ans = ans * a;
                b = b - 1;
            }else{
                a = a * a;
                b = b / 2;
            }
        }
        return ans;
    }
    public static void nthRootOfInteger(){
        int n = 4, m = 4096;

        // As, Brute force we can do it linearly. So TC -> O(m * log n), here log n base 2 is to find 'a' to the power 'b' in log n.

        int low = 1, high = m;

        while(low <= high){
            int mid = high + (low - high) / 2;
            if(powerOf(mid, n) == m){
                System.out.println( n +"th root of " + m + " is = " + mid);
                return;
            }else if(powerOf(mid, n) > m)high = mid - 1;
            else low = mid + 1;
        }

        System.out.println("Not found");
    }

    public static void main(String[] args) {
       // nthRootOfInteger();
        System.out.println(power(2,5)); // using recursion.
    }
}
