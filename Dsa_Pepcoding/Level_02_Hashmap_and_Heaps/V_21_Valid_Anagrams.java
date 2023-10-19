package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_21_Valid_Anagrams {

    // In this problem we are given two strings s1 and s2, now we have to identified that they ara Anagrams to each other or not.

    // As we know that two strings will be Anagrams if each character come same no. of times in both string. means we have to make frequency map of them.

    public static void main(String[] args) {
        String s1 = "pepcoding";
        String s2 = "odingpepc";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch : s2.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
            }else{
                System.out.println("FALSE");
                return;
            }
        }

        if(map.size() == 0){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
}
