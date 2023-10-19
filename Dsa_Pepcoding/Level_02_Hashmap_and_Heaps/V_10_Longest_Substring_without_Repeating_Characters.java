package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_10_Longest_Substring_without_Repeating_Characters {

    // Problem states that you are given a string, you have to find the length of the longest substring of the given string that contains all
    // non-repeating characters.
    // To solve it we will use acquire and release strategy using frequency map.
    // So, we will acquire till it become invalid, and after that release till it become valid again.

    public static void main(String[] args) {
        String str = "abbacbcdbadbdbbdcb";

        HashMap<Character,Integer> fmap = new HashMap<>();
        int i = -1, j = -1, ansLen = 0;

        while(true){
            boolean f1 = false, f2 = false;

            // Acquire

            while(i < str.length()-1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if(fmap.get(ch) == 2){
                    break;
                }
                int len = i - j;
                ansLen = Math.max(len, ansLen);
            }

            // release
            while(j < i){
                f2 = true;
                j++;
                char ch = str.charAt(j);
                fmap.put(ch, fmap.get(ch) - 1);
                if(fmap.get(ch) == 1){
                    break;
                }
//                // OR
//                if(fmap.get(ch) == 1){
//                    fmap.remove(ch);
//                }else{
//                    fmap.put(ch, fmap.get(ch) - 1);
//                } // it will not for releasing, do dry run to take more deep understanding.
            }

            if(!f1 && !f2)break;
        }

        System.out.println("Answer : " + ansLen);
    }
}
