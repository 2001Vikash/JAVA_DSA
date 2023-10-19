package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_25_Word_Pattern {

    // In this problem : You are given two strings s1 and s2 represents a word of length of N space-separated words
    // You have to find if the words in s2, follow the exact order as characters in s2.

    // Means in s2 we will have words and in s1 we will have, may be characters so, we have to do mapping and check that they are following one-to-one mapping or not.

    public static void main(String[] args) {
        String s1 = "abbcaa";
        String s2 = "Vikash Yadav Yadav Name Vikash Vikash";

        String[] arrS2 = s2.split(" ");

        HashMap<Character,String> mapped = new HashMap<>();
        HashMap<String,Boolean> used = new HashMap<>();

        if(s1.length() != arrS2.length){
            System.out.println("FALSE");
            return;
        }

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            String s = arrS2[i];

            if(mapped.containsKey(ch)){
                if(!mapped.get(ch).equals(s)){
                    System.out.println("FALSE");
                    return;
                }
            }else{
                if(used.containsKey(s)){
                    System.out.println("FALSE");
                    return;
                }else{
                    mapped.put(ch, s);
                    used.put(s, true);
                }
            }
        }

        System.out.println("TRUE");
    }
}
