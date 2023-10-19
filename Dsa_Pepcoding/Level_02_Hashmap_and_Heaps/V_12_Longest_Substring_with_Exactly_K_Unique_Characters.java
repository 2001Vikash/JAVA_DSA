package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_12_Longest_Substring_with_Exactly_K_Unique_Characters {

    // Problem states that we are given a string str and a number k, We have to find length of the longest substring that has exactly k unique characters
    // If no such substring exists print "-1".

    // For solution, we will use Acquire and release strategy using HashMap.

    public static void main(String[] args) {
        String str = "aabcbcdbca"; // Ans, will be bcbc.
        int k = 2;

        String ans = "";
        int i = -1, j = -1;
        HashMap<Character,Integer> fmap = new HashMap<>();

        while(true){
            boolean f1 = false, f2 = false;

            // Acquire
            while(i < str.length()-1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

                if(fmap.size() == k){
                    String pStr = str.substring(j+1, i+1);
                    if(ans.length() == 0 || ans.length() < pStr.length()){
                        ans = pStr;
                    }
                }
                if(fmap.size() > k)break; // now go for the release
            }

            // release
            while (j < i){
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if(fmap.get(ch) == 1){
                    fmap.remove(ch);
                }else{
                    fmap.put(ch, fmap.get(ch) - 1);
                }
                if(fmap.size() == k){
                    String pStr = str.substring(j+1, i+1);
                    if(ans.length() == 0 || ans.length() < pStr.length()){
                        ans = pStr;
                    }
                    break;
                }
            }

            if(!f1 && !f2)break;
        }

        if(ans.length() == 0){
            System.out.println("Answer is not possible. -1");
            return;
        }
        System.out.println(ans);
    }
}
