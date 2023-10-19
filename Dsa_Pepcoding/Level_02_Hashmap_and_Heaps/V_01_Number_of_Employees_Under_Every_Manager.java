package Level_02_Hashmap_and_Heaps;
import java.awt.*;
import java.util.*;
public class V_01_Number_of_Employees_Under_Every_Manager {

    // In this problem we have given an integer and that much, times given two strings with space separated, in which
    // first string shows that, this is an employee, and second string show that this is a manager, and relation is that employee report to the manager.
    // for ex. If F -> F, means F's manager is F it means F is CEO(root).
    // So, in this question we have to find that how many people report to another people directly and in-directly.

    // When we see it clearly then we will realize that this information is given in the form of tree.
    // We can solve this problem easily if we will be able to build tree, then after just we have to return the size for every node,
    // so we can do it with postOrder traversal(change and return strategy).

    public static void solution(HashMap<String, String> map){

        // with the help of this map we have to construct the tree

        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";
        for(String emp : map.keySet()){
            String man = map.get(emp);
            if(man.equals(emp)){
                ceo += man;
            }else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);
                }else{
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(man, emps);
                }
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);

        for(String man : result.keySet()){
            System.out.println(man + " takes reports of " + result.get(man) + " employees.");
        }
    }

    private static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String,Integer> result){
        if(!tree.containsKey(man)){
            result.put(man, 0);
            return 1;
        }

        int sz = 0;
        for(String emp : tree.get(man)){
            int cz = getSize(tree, emp, result);
            sz += cz;
        }

        result.put(man, sz);
        return sz+1;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "C");
        map.put("B", "C");
        map.put("C", "F");
        map.put("D", "E");
        map.put("E", "F");
        map.put("F", "F");

        solution(map);
    }
}
