package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_13_Count_of_Substrings_with_Exactly_K_Unique_Characters {

    // Problem states that You are given a string str and a number K. You have to find the count of valid substring of the given string
    // Valid subString is defined as a substring that has exactly K unique characters.

    // To solve this we will use Acquire Release strategy but in little-bit different way, that is nothing using two hashmap.

    // In acquire and release we will involve two hashmaps one is smaller that will contain exact K-1 distinct chars, and second one is big
    // which will contain exact K distinct characters.

    // TC -> O(3n)
    public static void removeInMap(HashMap<Character,Integer> map, char ch){
        if(map.get(ch) == 1){
            map.remove(ch);
        }else {
            map.put(ch, map.get(ch) - 1);
        }
    }

    public static int solutionForKEqualToOne(String s){
        int ans = 0;
        int i  = -1, j = -1;
        HashMap<Character,Integer> map = new HashMap<>();

        while(true){
            boolean f1 = false, f2 = false;

            //acquire
            while(i < s.length() - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if(map.size() == 2){
                    removeInMap(map, ch);
                    i--;
                    break;
                }
            }

            // release
            while (j < i){
                f2 = true;
                if(map.size() == 1){
                    ans += i - j;
                }
                j++;
                char ch = s.charAt(j);
                removeInMap(map, ch);
                if(map.size() == 0){
                    break;
                }
            }
            if(!f1 && !f2)break;
        }
        return ans;
    }

    public static int solution(String s, int k){
        int ans = 0;

        if(k == 1){
            return solutionForKEqualToOne(s);
        }

        HashMap<Character,Integer> mapb = new HashMap<>(); // big hashmap
        HashMap<Character,Integer> maps = new HashMap<>();// small hashmap.
        int ib = -1, is = -1, j = -1;

        while(true){
            boolean f1 = false, f2 = false, f3 = false;

            // acquire in big map
            while (ib < s.length() - 1){
                f1 = true;
                ib++;
                char ch = s.charAt(ib);
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
                if(mapb.size() == k + 1){ // k is required
                    removeInMap(mapb, ch);
                    ib--;
                    break;
                }
            }

            // acquire in small map
            while(is < ib){
                f2 = true;
                is++;
                char ch = s.charAt(is);
                maps.put(ch, maps.getOrDefault(ch, 0) + 1);
                if(maps.size() == k){ // k - 1 is required
                    removeInMap(maps, ch);
                    is--;
                    break;
                }
            }

            // Release
            while (j < is){
                f3 = true;
                if(mapb.size() == k && maps.size() == k-1){
                    ans += ib - is;
                }
                j++;
                char ch = s.charAt(j);
                removeInMap(mapb, ch);
                removeInMap(maps, ch);
                if(mapb.size() < k || maps.size() < k-1){
                    break;
                }
            }

            if(!f1 && !f2 && !f3)break;
        }

        return ans;
    }


    // Without using HashMap, because in worst case Map will take O(n) time, that's why we are using hash[26] size this is near about constant space.
    public static int forKEqualToOne(String s){
        int ans = 0;
        int i  = -1, j = -1;
        int[] hash = new int[26];
        int distinct = 0;
        while(true){
            boolean f1 = false, f2 = false;

            //acquire
            while(i < s.length() - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                if(hash[ch-'a'] == 0){
                    distinct++;
                }
                hash[ch-'a']++;

                if(distinct == 2){
                    if(hash[ch-'a'] != 0){
                        if(hash[ch-'a'] == 1){
                            distinct--;
                            hash[ch-'a']--;
                        }
                    }
                    i--;
                    break;
                }
            }

            // release
            while (j < i){
                f2 = true;
                if(distinct == 1){
                    ans += i - j;
                }
                j++;
                char ch = s.charAt(j);
                if(hash[ch-'a'] != 0){
                    if(hash[ch-'a'] == 1){
                        distinct--;
                        hash[ch-'a']--;
                    }
                }
                if(distinct == 0){
                    break;
                }
            }
            if(!f1 && !f2)break;
        }
        return ans;
    }

    public static int solve(int k, String s){
        int ans = 0;

        if(k == 1){
            return forKEqualToOne(s);
        }

//        HashMap<Character,Integer> mapb = new HashMap<>(); // big hashmap
//        HashMap<Character,Integer> maps = new HashMap<>();// small hashmap.

        int[] hb = new int[26];
        int[] hs = new int[26];

        int ib = -1, is = -1, j = -1;
        int distinctBig = 0, distinctSmall = 0;

        while(true){
            boolean f1 = false, f2 = false, f3 = false;

            // acquire in big map
            while (ib < s.length() - 1){
                f1 = true;
                ib++;
                char ch = s.charAt(ib);
                if(hb[ch-'a'] == 0){ // to convert into integer.
                    distinctBig++;
                    hb[ch-'a']++;
                }else{
                    hb[ch-'a']++;
                }
                if(distinctBig == k+1){ // k is required
                    ib--;
                    if(hb[ch-'a'] != 0){
                        if(hb[ch-'a'] == 1){
                            distinctBig--;
                        }
                        hb[ch-'a']--;
                    }
                    break;
                }
            }

            // acquire in small map
            while(is < ib){
                f2 = true;
                is++;
                char ch = s.charAt(is);
                if(hs[ch-'a'] == 0){
                    distinctSmall++;
                }
                   hs[ch-'a']++;
                if(distinctSmall == k){ // k - 1 is required
                    is--;
                    if(hs[ch-'a'] != 0){
                        if(hs[ch-'a'] == 1){
                            distinctSmall--;
                        }
                        hs[ch-'a']--;
                    }
                    break;
                }
            }

            // Release
            while (j < is){
                f3 = true;
                if(distinctBig == k && distinctSmall == k-1){
                    ans += ib - is;
                }
                j++;
                char ch = s.charAt(j);
                if(hb[ch-'a'] != 0){
                    if(hb[ch-'a'] == 1){
                        distinctBig--;
                    }
                    hb[ch-'a']--;
                }
                if(hs[ch-'a'] != 0){
                    if(hs[ch-'a'] == 1){
                        distinctSmall--;
                    }
                    hs[ch-'a']--;
                }
                if(distinctBig < k || distinctSmall < k-1){
                    break;
                }
            }

            if(!f1 && !f2 && !f3)break;
        }

        return ans;
    }


    public static void main(String[] args) {
        String str = "abcabdabbcfa";
        int k = 1;

        System.out.println("Answer is = " + solve(k, str) );

    }
}
