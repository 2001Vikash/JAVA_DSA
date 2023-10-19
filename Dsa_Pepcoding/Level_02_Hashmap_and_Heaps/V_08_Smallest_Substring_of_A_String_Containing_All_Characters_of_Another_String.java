package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_08_Smallest_Substring_of_A_String_Containing_All_Characters_of_Another_String {

    // Problem states that (On leetCode we can find same problem as Minimum window Substring)
    // you are given two strings s1 and s2 containing lowerCase english alphabets, you have to find the smallest subString of s1 that contains all the
    // characters of s2 in any order, if no such subString exists, return blank string.

    // In solution, we will use Acquire-Release method, we will take a matchCount which will increase only if we will acquire right character,
    // initially we will put all character from s1 in frequency map, then do it.


    public static String solution(String s1, String s2){
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>(); // means for String s2.
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int i = -1, j = -1;
        int matchCount = 0, desiredMatchCount = s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();// means for String s1.

        while(true){
            boolean flag1 = false, flag2 = false;

            // Acquire

            while(i < s1.length()-1 && matchCount < desiredMatchCount){
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    matchCount++;
                }
                flag1 = true;
            }

            // Collect the answers and Release.

            while(j < i && matchCount == desiredMatchCount){
                String potentialAns = s1.substring(j+1, i+1);
                if(ans.length() == 0 || potentialAns.length() < ans.length()){
                    ans = potentialAns;
                }

                j++;
                char ch = s1.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch) - 1);
                }

                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    matchCount--;
                }

                flag2 = true;
            }

            if(!flag1 && !flag2){
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "dbaecbbabdcaafbddcabgba";
        String s2 = "abbcdc";

       // System.out.println("Answer is = " + solution(s1, s2));
        String s = "-1";
        System.out.println(s.length());
    }
}
