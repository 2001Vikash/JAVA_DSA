package Level_02_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_03_Check_If_an_Array_can_be_Divided_Into_Pairs_Whose_Sum_is_Divisible_By_K {

    // before the thinking about array we have to understand the divisible rule, for ex. if we have k = 7, and first number is 44, which 7*6 + 2, then
    // Second number of pair can be 7 * 11 + 5, here 5 is nothing but 7-2 = 5.
    // So, if we see general view that we will realize that if we have K, and first number is (kn + x), then second number can be (km + (k-x)). We will use it

    // Note => Means if a number is dividing by k and leaving 'x' remainder, then second number should leave (k-x) remainder if we divide that number with K.
    // Second case => if a number is leaving 0 remainder, means second number must be divisible by k.

    // To solve this problem we will use frequency map, where we will put remainder and their frequency for every element which come in array.
    // Here are three cases : 1. if remainder is k, then another remainder should present with same frequency.
    //                        2. if remainder is 0 means frequency must be Even otherwise we can not make pairs.
    //                        3. if k/2 remainder is present then it's frequency must be Even, otherwise pair will not be possible. because complement will be same
    // So, instead of checking rem = k/2, we will check 2 * rem = k, because in case of k = 11, k/2 = 5, and it will check even for 5 but, for 5 we have
    // requirement of 6, means it will be wrong, means in case of even k, it will work but not for odd k, that's why we use 2 * rem = k.



    public static boolean pairSumDivisibleByK(int k, int[] arr){

        HashMap<Integer, Integer> rfmap = new HashMap<>();

        for(int it : arr){
            int rem = it % k;
            int oldFq = rfmap.getOrDefault(rem, 0); // for the null exception handling
            rfmap.put(rem, oldFq + 1);

            /* Or -> another way to make frequency map

            => Above code will help us to implement same thing in 2 lines.

            if(rfmap.containsKey(rem)){
                rfmap.put(rem, rfmap.get(rem) + 1);
            }else{
                rfmap.put(rem, 1);
            }*/
        }

        for(int it : arr){
            int rem =  it % k;
            if(rem == 0){
                int fq = rfmap.get(rem);
                if(fq % 2 != 0){
                    return false;
                }
            }else if(2 * rem == k){
                int fq = rfmap.get(rem);
                if(fq % 2 != 0){
                    return false;
                }
            }else{
                int fq = rfmap.get(rem);
                int otherFq = rfmap.getOrDefault(k-rem, 0);
                // here can occur nullPointerException if (k-rem)'s element not present in array.
                if(fq != otherFq){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {77,22,56,11,45,34,78,29,23,55};
        int k = 10;
        System.out.println(pairSumDivisibleByK(k, arr));
    }

}
