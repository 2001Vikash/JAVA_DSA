package Level_01_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_03_Get_Common_Element_I {

    // Question -> In this problem we have given two arrays they can be in sorted order and can not be means it is not necessary that they are in sorted order.
    // So, we have to find the common element from the both array, if some elements are repeating itself then take them at once only.
    // Means find the common elements uniquely from the both arrays.

    // So, in solution we will make a frequency map, and when we will compare from the second array then if we find a element then print and remove from
    // the map, it means if that element will appear again then we will not take because that will not be present in the frequency map.


    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,3,5};
        int[] arr2 = {1,1,1,2,2,4,5};

        // There is no certain reason to make frequency map, we can do it via HashSet which consists only keys not values.
        // but no problem we will use hash map there is no problem.

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int it : arr1){
            if(map.containsKey(it)){
                map.put(it, map.get(it) + 1);
            }else {
                map.put(it, 1);
            }
        }

        // Now

        for(int it : arr2){
            if(map.containsKey(it)){
                System.out.println(it);
                map.remove(it);
            }
        }
    }
}
