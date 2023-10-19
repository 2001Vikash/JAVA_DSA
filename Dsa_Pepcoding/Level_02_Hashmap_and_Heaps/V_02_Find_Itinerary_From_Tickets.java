package Level_02_Hashmap_and_Heaps;

import java.util.HashMap;

public class V_02_Find_Itinerary_From_Tickets {

    // In this problem we have given tickets with starting station to destination station with space separated strings for ex. chennai -> goa
    // In output we have to find the root of the users like from where to where he is going or, we can say that tell about the route of the users
    // So, main thing is that we have to identify src and destination in this problem, means in given data one station is like that
    // we are not going anywhere, from that station means that will be destination, and src can be we are not coming at that station from anywhere.

    // So, to do it we are going to use Hashmap, so for the given src we will put true and, for the destination we will put false initially.
    // we have to find overall starting station then after question will be solved.

    public static void main(String[] args) {
        HashMap<String,String> dataMap = new HashMap<>();
        dataMap.put("Chennai", "Bangalore");
        dataMap.put("Bombay", "Delhi");
        dataMap.put("Goa", "Chennai");
        dataMap.put("Delhi", "Goa");

        // Now let us make a Hashmap of string vs boolean

        HashMap<String, Boolean> map = new HashMap<>();

        for(String key : dataMap.keySet()){
            String val = dataMap.get(key);
            map.put(val, false);
//            if(map.containsKey(key)){
//                map.put(key, false);
//            }else{
//                map.put(key, true);
//            }
            // We can do it like this as well
            if(!map.containsKey(key)){
                map.put(key, true);
            }
        }

        String src = "";
        for(String key : map.keySet()){
            if(map.get(key)){
                src = key;
                break;
            }
        }

       while(true){
//           String dest = dataMap.get(src);
//           System.out.print(src + " -> ");
//           src = dest;

           // OR
           if(dataMap.containsKey(src)){
               System.out.print(src + " -> ");
               src = dataMap.get(src);
           }else{
               System.out.print(src + ".");
               break;
           }

       }
      //  System.out.print("End");
    }
}
