package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_22_Group_Anagrams {

    // Problem states that ->
    // You are given an array of strings. You have to group anagrams together.
    // In this problem we are given an array of strings, and we have to group them according to Anagrams. And return the list of list.

    // To solve this problem we will use HashMap of frequency map and ArrayList, like this we can solve it.

    // In hashMap, key can not be everything, those things can be key in HashMap which is having .equals() function and hashCode() function.

    public static void main(String[] args) {
        String[] arr = {"abcc", "acbc", "badc", "abcd", "dabb", "babd", "dbca", "cabc"};

        HashMap<HashMap<Character,Integer>, ArrayList<String>> map = new HashMap<>();
        // We can not make key as anything, we will see afterwards, but as of now HashMap can be a key of HashMap, there will no problem, but
        // At the place of value -> We can put anything.

        for(int i = 0; i < arr.length; i++){
            String s = arr[i];
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            if(map.containsKey(fmap)){
                map.get(fmap).add(s);
            }else{
                ArrayList<String> li = new ArrayList<>();
                li.add(s);
                map.put(fmap, li);
            }
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
       /* for(Map.Entry<HashMap<Character,Integer>, ArrayList<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }*/

        // OR
        for(ArrayList<String> val : map.values()){
            ans.add(val);
        }

        System.out.println(ans);
    }
}
