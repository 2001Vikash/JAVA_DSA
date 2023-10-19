package Level_02_Hashmap_and_Heaps;
import java.util.*;

public class V_17_Longest_Substring_with_At_Most_K_Unique_Characters {

    // We have solved for exactly K but here we are going to solve for at most k.
    // As we know that problem states that you are given a string str and number k, you have to find the length of the longest substring that contains
    // at most K unique characters.

    // Here for the solution we will use Acquire and release strategy.

    public static int usingWhileLoop(String s, int k){
        int maxLen = 0;

        HashMap<Character,Integer> fmap = new HashMap<>();
        int i = -1, j = -1;

        while(true){
            boolean f1 = false, f2 = false;
            // acquire

            while(i < s.length()-1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch,0) + 1);

                if(fmap.size() <= k){
                    maxLen = Math.max(maxLen, i-j);
                }else{
                    break;
                }
            }
            // release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if(fmap.get(ch) == 1){
                    fmap.remove(ch);
                }else{
                    fmap.put(ch, fmap.get(ch) - 1);
                }

                if(fmap.size() == k){
                    maxLen = Math.max(maxLen, i-j);
                    break;
                }
            }
            if(!f1 && !f2){
                break;
            }
        }

        return maxLen;
    }
    public static int usingForLoop(String s, int k){
        int maxLen = 0;

        HashMap<Character,Integer> fmap = new HashMap<>();
        int j = -1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);

            if(fmap.size() <= k){
                maxLen = Math.max(maxLen, i-j);
            }else{
                while(j < i && fmap.size() > k){
                    j++;
                    char c = s.charAt(j);
                    if(fmap.get(c) == 1){
                        fmap.remove(c);
                    }else{
                        fmap.put(c, fmap.get(c) - 1);
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "ddacbbaccdedacebb";
        int k = 3;

        System.out.println(usingWhileLoop(str, k));
        System.out.println(usingForLoop(str, k));
    }
}
