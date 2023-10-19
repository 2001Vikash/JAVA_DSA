package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_35_Rabbits_in_the_Forest {

    // In this problem, there are some rabbits in the forest and each rabbits has some color.
    // Some(possibly all) are selected from them and, they tell you about the number of other rabbits having the same color as them.
    // you are given an array that contains the answers of all selected rabbits.
    // You have to find the minimum number of rabbits that could be in the forest.

    // Means if we have data like that {2,2,3,1,0,2,2,3,1} here 2 means 0th rabbit tells us that in forest there are 2 rabbits instead of me
    // may be all rabbits are giving information may be not, so we have to find that minimum number of rabbits in the forest.
    // So, as we know that we have to find minimum, means we will try to merge similar thing till possibility.


    public static void main(String[] args) {
        int[] arr = {2,2,3,1,0,2,2,3,1};
        int n = arr.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int ans = 0;

        for(int key : map.keySet()){
            int groupSize = key + 1;
            int reportees = map.get(key);
           // int numberOfGroups = (int)Math.ceil((reportees * 1.0) / (groupSize * 1.0));

            // OR
            int numberOfGroups;
            if(reportees % groupSize == 0){
                numberOfGroups = reportees / groupSize;
            }else{
                numberOfGroups = reportees / groupSize + 1;
            }
            ans = groupSize * numberOfGroups;
        }

        System.out.println("Answer is = " + ans);
    }
}
