package com.Striver;
import java.util.*;
public class Video_18_K_th_Permutation_Sequence {
    // Firstly we need to explain bruit force solution to the interviewer and then go for the optimal solution
    // if we use recursion  here then time complexity is like as n!*n and
    // for sorting a data structure means m log m where m can be n!*n.
    // But if we go for optimal solution of this question then we need to for mathematical solution .
    // and in this case time complexity is O(n^2). and Space Complexity is O(n).
    public static String getPermutation(int n, int k){
        int fact = 1;
        List<Integer> numbers =  new ArrayList<>();
        for(int i=1; i<n; i++){// because we need to calculate (n-1)!. kyoki pahle wale ko to fix kr de rhe hai.
            fact = fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k-1;// kyoki indexing 0 se ho rhi hai ds me.
        while(true){
            ans = ans+" " + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k=k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(4,19));
    }
}
