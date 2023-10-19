package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_11_Count_of_Substrings_Having_All_Unique_Characters {

    // Problem states that -> you are given a string and, you have to find the count of valid substrings of the given string.
    //                        Valid Substring is defined as a subString that has all unique characters.

    // So, as we know that if we string as 'abcd', then we will have n(n+1)/2 - substrings, like a,ab,abc,abcd,b,bc,bcd,c,cd,d. but if we have repeating
    // character, then we have to avoid repetition of characters in substring.

    public static void main(String[] args) {
        String str = "aabcbcdbca";

        int i = -1, j = -1, cnt = 0;
        HashMap<Character, Integer> fmap = new HashMap<>();

        while(true){
            boolean f1 = false, f2 = false;
            // acquire
            while(i < str.length() - 1){
                f1 = true;

                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if(fmap.get(ch) == 2){
                    break;
                }else{
                    cnt += i-j;
                }
            }

            // release
            while(j < i){
                f2 = true;

                j++;
                char ch = str.charAt(j);
                fmap.put(ch, fmap.get(ch) - 1);

                if(fmap.get(ch) == 1){
                    cnt += i-j;
                    break;
                }
            }

            if(!f1 && !f2)break;
        }

        System.out.println("ANSWER = " + cnt);
    }
}
