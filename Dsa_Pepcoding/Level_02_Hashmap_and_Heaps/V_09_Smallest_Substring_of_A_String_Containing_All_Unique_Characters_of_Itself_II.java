package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_09_Smallest_Substring_of_A_String_Containing_All_Unique_Characters_of_Itself_II {

    // This problem is also same the previous problem where we were two strings but here we have only one string and ,we have to find the unique
    // character in given string and do same thing as previous.

    public static void main(String[] args) {
        String str = "bbacacdcbbcaadcdca";

        HashSet<Character> set = new HashSet<>();// to extract unique characters from the string.
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            set.add(ch);
        }

        int i = -1, j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        int len = str.length();
        while(true){
            boolean f1 = false, f2 = false;
            // acquire till it is invalid means map.size < set.size
            while(i < str.length()-1 && map.size() < set.size()){
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            // collect the answer and Release till map.size == set.size
            while(j < i && map.size() == set.size()){
                int pAnsLen = i - j;
                len = Math.min(len, pAnsLen);

                j++;
                char ch = str.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
                f2 = true;
            }

            if(!f1 && !f2){
                break;
            }
        }

        System.out.println("Answer : " + len);
    }
}
