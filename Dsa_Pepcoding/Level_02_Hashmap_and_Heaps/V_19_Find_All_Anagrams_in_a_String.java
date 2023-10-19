package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_19_Find_All_Anagrams_in_a_String {

    // In this problem you are given two strings s1 and s2.
    // You have to find the count of s2's anagrams that are present in s1.
    // Also, you have to print the start indices of such anagrams in s1.

    // Anagram -> A string s1 said to be Anagram of s2 if both are having same frequency map, in key and value both, means count of same characters
    //            should be equal to in both strings, abac, caab are anagrams. Order not matter only frequency map must be same in the term of key-values

    // To solve this problem we will use one acquire and one release strategy.

    public static boolean compare(HashMap<Character,Integer> smap, HashMap<Character,Integer> pmap){
        for(char sch : smap.keySet()){
            if(!Objects.equals(pmap.getOrDefault(sch, 0), smap.get(sch))){
                return false;
            }
        }
        return true;
    }

    public static void allAnagrams(String src, String pat){
        int count = 0;
        String indices = "";
        int n = src.length();
        int m = pat.length();
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();

        for(int i = 0; i < m; i++){
            char pch = pat.charAt(i);
            pmap.put(pch, pmap.getOrDefault(pch, 0) + 1);

            char sch = src.charAt(i);
            smap.put(sch, smap.getOrDefault(sch, 0) + 1);
        }

        int i = m;

        while(i < n){
            if(compare(smap, pmap)){
                count++;
                indices += (i-m + " ");
            }

            char ach = src.charAt(i); // acquiring char
            smap.put(ach, smap.getOrDefault(ach, 0) + 1);

            // releasing char
            char rch = src.charAt(i - m);
            if(smap.get(rch) == 1){
                smap.remove(rch);
            }else{
                smap.put(rch, smap.get(rch) - 1);
            }
            i++;
        }
        // for last iteration
        if(compare(smap, pmap)){
            count++;
            indices += (i-m + " ");
        }
        System.out.println("Number of Anagrams is = " + count + ", and Starting indices of them is = " + indices);
    }

    public static void main(String[] args) {
        String src = "cbaebabacd";
        String pattern = "abc";
        // So, we have to find that given pattern is Anagram with how much src substrings.

        allAnagrams(src, pattern);
    }
}
