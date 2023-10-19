package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_20_Check_if_two_Strings_are_K_Anagrams_of_each_other_or_Not {

    // You are given two strings s1, s2 and a number K. You have to find if two strings are K-anagrams of each other or not.
    // Two Strings are called K-anagrams if:
    // -> Both s1 and s2 have the same number of characters.
    // -> After changing K-characters in any string, s1 and s2 become anagram of each other.
    // Here we have to replace at most k-characters means up-to k-characters, means less than k will be considerable.

    public static void main(String[] args) {
        String s1 = "aabbbc";
        String s2 = "badaba";
        int k = 3;

        // we are allowed to do replace only, not remove, or add.
        // if both string are not having equal length it means we can not go further return that not possible.

        if(s1.length() != s2.length()){
            System.out.println("Not possible");
            return;
        }

        // we will make frequency map then we will check the difference in both string character's occurrence, we will focus on either +ve or -ve difference
        // if they are less than equal to k means it is possible to be k-anagrams after replacing at most k-characters.
        // Or we will make frequency map for s1 and then after subtract the frequency for s2, then after check that how many are reaming if they are less than equal to the k, means Yes.

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        }

        for(int i = 0; i < s2.length(); i++){
            char ch = s1.charAt(i);
            if(map.getOrDefault(ch, 0) > 0){
                map.put(ch, map.get(ch) - 1);
            }
        }
        int count = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            count += entry.getValue();
        }
        if(count > k){
            System.out.println("FALSE");
        }else{
            System.out.println("TRUE");
        }
    }
}
