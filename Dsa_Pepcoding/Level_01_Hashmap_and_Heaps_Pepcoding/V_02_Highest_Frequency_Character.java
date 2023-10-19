package Level_01_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_02_Highest_Frequency_Character {

    // In this question we have given a String and, we have to find the highest frequency of character in the given string for ex. abracadabra, ans = a.

    public static void main(String[] args) {

        String str = "abracadabra";
        HashMap<Character, Integer> mp = new HashMap<>();

        char ans = str.charAt(0);

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i); // imp 'Character' at the time of declaration after that we can use both, char or Character.
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                Integer newVal = mp.get(ch) + 1; // if again come then increase by 1.
                mp.put(ch, newVal);
            }

            if(mp.get(ans) < mp.get(ch)){
                ans = ch;
            }
        }

        // Or  -> means instead of finding answer in first loop we can do it vai this as well.

        char ans2 = str.charAt(0);
        int maxFreq = mp.get(ans2);
        for(Character key : mp.keySet()){
            if(maxFreq < mp.get(key)){
                maxFreq = mp.get(key);
                ans2 = key;
            }
        }

        System.out.println("Maximum occurring character in given string is : " + ans);

        System.out.println("Via another option : " + ans2);
    }
}
