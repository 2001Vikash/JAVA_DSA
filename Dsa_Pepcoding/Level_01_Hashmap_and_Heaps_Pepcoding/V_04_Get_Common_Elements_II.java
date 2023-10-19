package Level_01_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_04_Get_Common_Elements_II {

    // Question -> In this problem we will take those common elements which is having minimal repetition in both arrays.
    // And, we have to follow order of second array means in which order elements are given in the second array that will the output order.
    // Or, we can say that this problem states the proper intersection between two sets, but not like that set, because in set elements can not be repetitive.

    // So, in solution we will do same as previous but here we will not remove the elements from  the map, we will reduce the frequency of the elements
    // And, if frequency is '0' then we will not consider the elements.

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,3,5};
        int[] arr2 = {1,1,1,2,2,4,5};

        HashMap<Integer,Integer> mp = new HashMap<>(); // this is frequency map

        for(int it : arr1){
            if(mp.containsKey(it)){
                mp.put(it, mp.get(it) + 1);
            }else{
                mp.put(it, 1);
            }
        }

        for(int it : arr2){
            if(mp.containsKey(it) && mp.get(it) > 0){
                System.out.println(it);
                mp.put(it, mp.get(it)-1);
            }
        }
    }
}
