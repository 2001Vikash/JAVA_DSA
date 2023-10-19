package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_18_Count_of_Substrings_Having_at_most_K_Unique_Characters {

    // This problem is an extension of previous problem, here we have to count the number of that strings which is having at most K unique characters.

    public static int solutionUsingWhileLoop(String s, int k){
        int n = s.length();
        int ans = 0;

        int i = -1, j = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while(true){
         //   boolean f1 = false, f2 = false;

            // acquire
            while(i < n-1){
             //   f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.size() <= k){
                    ans += i-j;
                }else{
                    break;
                }
            }
           if(i == n-1 && map.size() <= k){
               break; // instead of using boolean f1,f2 we can do that thing in this way as well there is no problem.
           }
            // release
            while(j < i){
           //     f2 = true;
                j++;
                char ch = s.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
                if(map.size() == k){
                    ans += i-j;
                    break;
                }
            }

          //  if(!f1 && !f2)break;
        }

        return ans;
    }

    public static int solutionUsingForLoop(String s, int k){
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int j = -1;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.size() <= k){
                ans += i-j;
            }
            while(j < i && map.size() > k){
                j++;
                char c = s.charAt(j);
                if(map.get(c) == 1){
                   map.remove(c);
                }else{
                    map.put(c, map.get(c) - 1);
                }

                if(map.size() == k){
                    ans += i-j;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        int k = 2;

        System.out.println("Answer is = " + solutionUsingWhileLoop(str, k));
        System.out.println("Answer is = " + solutionUsingForLoop(str, k));
    }
}
