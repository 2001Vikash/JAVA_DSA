package Level_02_Hashmap_and_Heaps;

import java.util.*;

public class V_23_Group_Shifted_Strings {

    // In this problem you are given an array of strings, you have to group the given strings in such a way that all strings in a group are shifted
    // versions of each other.
    // Two strings s1 and s2 are shifted :
    // -> Length of both the string is same.
    // -> The difference between ASCII values(gap between characters) of every character of s1 and s2 is constant.
    // Note -> Every string consists of lower-case English letters.

    // Here we have to observe one thing that is ASCII difference between characters of a string, will be same as those strings which are eligible for grouping.
    // so, we will make this as Key, we will use hashmap of string vs ArrayList, string will ASCII difference of characters of immediate strings with '#' separater.
    // We will follow alphabets in circular manner, means if we will find difference as -ve then we will add +26 in that, anf go on.


    public static String getKey(String str){
        String key = "";

        for(int i = 1; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            int diff = curr - prev;

            if(diff < 0)diff += 26;

            key += diff + "#";
        }

        key += "."; // this is not imp but, for better convention
        return key;
    }

    public static ArrayList<ArrayList<String>> solve(String[] arr){

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : arr){
            String key = getKey(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(ArrayList<String> val : map.values()){
            ans.add(val);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"acd","dfg","wyz","yab","mop","bdfh","a","x","moqs"};
        System.out.println(solve(arr));
    }
}
