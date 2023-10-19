package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_45_First_Non_Repeating_Character {

    // In this problem, we are given a string, You have to find the index of the first non-repeating character in the given string.
    // If no such character exists then return '-1'.
    // TC -> O(2n), SC -> O(n).

    public static void main(String[] args) {
        String str = "abbcaddecfab";
        int n = str.length();

        HashMap<Character,Integer> map = new HashMap<>();

        for(Character ch : str.toCharArray())map.put(ch, map.getOrDefault(ch, 0) + 1);

        for(Character ch : str.toCharArray()){
            if(map.get(ch) == 1){
                System.out.println("First non-repeating character is = " + ch);
                return;
            }
        }
        System.out.println("Not found " + "-1");
    }
}
