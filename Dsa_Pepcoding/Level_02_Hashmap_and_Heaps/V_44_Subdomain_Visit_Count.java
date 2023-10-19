package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_44_Subdomain_Visit_Count {

    // A website domain generally consists of many subDomains, Now the task is to print subDomain name as well as its visit count.
    // You have to find all subDomains with their respective visit count.(Some domains may have common subDomains).
    // Return a list with pair(count and subDomains) for each subDomain.

    public static void main(String[] args) {

        String[] domains = {"150 google.com", "200 pepcoding.com", "130 contest.pepcoding.com"};
        int n = domains.length;

        HashMap<String,Integer> map = new HashMap<>();

        for(String domain : domains){
            String[] temp = domain.split(" ");
            int visitCount = Integer.parseInt(temp[0]);
            String[] str = temp[1].split("\\."); // only '.' will not work to split from '.' we have to do this convention.
            StringBuilder sb = new StringBuilder(); // we will avoid to do '+' in string because it takes lots of space and time as well.
            for(int i = str.length - 1; i >= 0; i--){
                if(i == str.length - 1){
                    sb.append(str[i]);
                }else{
                    sb.insert(0, ".");
                    sb.insert(0, str[i]);
                }
                String subDomain = sb.toString();
                if(map.containsKey(subDomain)){
                    map.put(subDomain, map.get(subDomain) + visitCount);
                }else{
                    map.put(subDomain, visitCount);
                }
            }
        }

        System.out.println(map);
    }
}
