package Hashing;
import java.util.*;
public class Hashmap {

    public static void main(String[] args) {
        // Hashmap in java is used to store two values simultaneously. that is key <-> value with pairs
        // key always will be unique and value can be repeated corresponding the key value
        // HashMaps is also an unOrdered maps or list or set of element means there is no any guarantee
        // to find our elements as it as insertion. it might be same or different

        // country(key), population(value)

        HashMap<String, Integer> map = new HashMap<>();

        // Insertion

        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 140);
        System.out.println(map);
        map.put("China", 150);
        // means if I again insert a new value for a key then it will update the old value with new value
        // if key is already exists.
        System.out.println(map);


        // Search or Lookup

        System.out.println(map.containsKey("China"));
        System.out.println(map.containsValue(130));

        // for retrieving value
        System.out.println(map.get("China"));
       // if not present then it will return null.
    }
}
