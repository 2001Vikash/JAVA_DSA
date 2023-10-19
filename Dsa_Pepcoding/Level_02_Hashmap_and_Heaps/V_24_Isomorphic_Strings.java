package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_24_Isomorphic_Strings {

    // You are given two strings s1 and s2, you have to determine if they are Isomorphic or not.
    // Two Strings are called Isomorphic if ->
    // -> every character of s1 can be mapped with character of s2.
    // -> A character of s1 can be mapped to only one character.
    // -> All occurrences of a character must be replaced with another character while preserving the order of character.

    // Isomorphic means every character must be followed the one-one mapping concept means if 'a' is mapped with 'x' then in string wherever 'a' will come that should be mapped with 'x'.
    // And if 'a' is mapped with 'x' and p is also mapped with 'x' then that will not be an Isomorphic string. means there is only one to one mapping exists not many to one or one to many.

    // to solve this problem we will use two HashMaps, one is char vs char that will tell us that char of s1 is mapped with char of s2, and second one \
    // will be char vs boolean, and in this we will check that which char of s2 has used.


    public static void main(String[] args) {
         String s1 = "abacba";
         String s2 = "xyxzyx"; // if we replace z with y, then answer should come as false.

        // if both are not having same length then they can not be an Isomorphic.
        if(s1.length() != s2.length()){
            System.out.println("FALSE");
            return;
        }

        HashMap<Character,Character> m1 = new HashMap<>(); // it is used for mapping characters of both strings.
        HashMap<Character, Boolean> m2 = new HashMap<>(); // it is used to know that s2's characters are mapped or not.

        for(int i = 0; i < s1.length(); i++){
            char s1ch = s1.charAt(i);
            char s2ch = s2.charAt(i);

            if(m1.containsKey(s1ch)){
                char ch = m1.get(s1ch);
                if(ch != s2ch){
                    System.out.println("FALSE");
                    return;
                }
            }else{
                if(!m2.containsKey(s2ch)){
                    m2.put(s2ch, true);
                    m1.put(s1ch, s2ch);
                }else{
                    System.out.println("FALSE");
                    return;
                }
            }
        }

        System.out.println("TRUE");
    }
}
