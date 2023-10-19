package Level_02_Hashmap_and_Heaps;

import java.util.HashSet;

public class V_43_Powerful_Numbers {

    // In this problem, we are given three numbers A, B and X. you have to print all powerful numbers that have value less than or equal to X.
    // A number is powerful if it is equal to A^i + B^j for i >= 0 and j >= 0. Here, we can say that X will work as Bound.
    // means => A^i + B^j <= Bound(X), as well we have to find unique solution.
    // Please re-watch the video again that will help you understand this problem in depth, because, it basically based on maths in which we are defining
    // range of i and j, which are near about 20. It means we can generate every possible combinations.

    public static void main(String[] args) {

        int x = 2, y = 3, bound = 10;

        HashSet<Integer> set = new HashSet<>(); // it is for the unique answers.

        for(int i = 1; i < bound; i *= x){ // log(bound) base x
            for(int j = 1; i+j <= bound; j *= y){ // log(bound) base y
                set.add(i+j);
                if(y == 1)break; // because it will never terminate, as we know that 1 to the power everything will be 1.
            }
            if(x == 1)break;
        }
        System.out.println(set);
        // So, TC -> O(log(bound) base x * log(bound) base y) and as we know that log bound * log bound will be max combinations means space will be same as TC.

    }
}
