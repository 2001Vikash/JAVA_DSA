package Level_02_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_33_Count_the_Number_of_SubArrays_with_Equal_0s_1s_2s {

    public static void main(String[] args) {

        int[] arr = {1,1,2,0,1,0,1,2,1,2,2,0,1};
        int n = arr.length;

        HashMap<String, Integer> map = new HashMap<>(); // we are going to store gap, in string
        String initialKey = "0#0"; // 0-0 = 0, 0-0 = 0
        //In future if gap will be same means count of numbers are growing equally.
        map.put(initialKey, 1);
        int maxLen = 0;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0, cnt = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] == 0)cnt0++;
            else if(arr[i] == 1)cnt1++;
            else cnt2++;

            String key = (cnt1 - cnt0) + "#" + (cnt2 - cnt1);
            if(map.containsKey(key)){
                cnt += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        System.out.println("Answer is = " + cnt);
    }
}
