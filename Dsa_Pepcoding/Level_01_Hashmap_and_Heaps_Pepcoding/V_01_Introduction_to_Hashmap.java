package Level_01_Hashmap_and_Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class V_01_Introduction_to_Hashmap {

    // It is used for doing a lots of operations in O(1) that is the speciality of the hashMap.
    // When do we use it => When we have information in form of table, for ex. when we store the value against key. for ex. Population map.
    // country   population => india-135, china-200, Us-20, UK-15 etc.

    // Functions of HashMap -> generally we see key value pairs, or funda in the Hashmap.

    // 1. mp.put(key , value) -> it will update those things which is already present in map, for ex if we have key India, and we update value as 140, then it removes the 135 and sets 140.
    // If key is not present in the map then it will insert that information in map.

    // 2. mp.get("India") -> it will give the value against "India" that is 135. And if we are giving wrong Key then it will give NULL.

    // 3. mp.containsKey("India") -> gives value in True/False.

    // Declaration -> HashMap<what,vs what> mp = new HashMap<>() => String, Integer, or Integer, Integer, String , String etc.

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 135);
        map.put("China", 200);
        map.put("Pak", 40);
        map.put("US", 30);
        map.put("UK", 20);

        System.out.println(map);

        map.put("Nigeria", 5);
        map.put("US", 25);

        System.out.println(map);

        // Note -> In hashmap we can not control where they would get inserted, means stored in Out of Order.

        System.out.println(map.get("India"));
        System.out.println(map.get("Utopia"));

        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Utopia"));

        System.out.println(map.containsValue(135));
        System.out.println(map.containsValue(14));

        System.out.println(map.values());// print the value in the form of array, without in any order.

        System.out.println(map.keySet()); // it will give the all keys, it will be required when we will use loops.
        // or we can show it like that
        Set<String> keys = map.keySet();
        System.out.println(keys);

        // we can use loop on this

        for(String key : map.keySet()) {
            Integer val = map.get(key);// using this we can find the value
            System.out.print(key + " " + val + " , ");

            // Imp Note -> All those functions run in O(1) that is the biggest advantage of HashMap. So, it will be increased performance of code at lots of place.
        }

            // Direct for each loop on map.

            for(Map.Entry<String, Integer> it : map.entrySet()){
                Integer val = it.getValue();
                String key = it.getKey();
                System.out.println(key + " " + val);
            }


            // there is also a function which is used for removing keys from the map
        // mp.remove(key).
    }
}
