package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_26_HashCode_and_Equal_Override {

    public static class Pair{
        int a = 0;
        String s = "";

        public Pair(int a, String s){
            this.a = a;
            this.s = s;
        }

        @Override
        public int hashCode() {
            return a % 29; // to put in to the same bucket. because hashmap is nothing but arr of linkedList.
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null)return false;
            Pair o = (Pair)obj;
            if(this.a != o.a)return false;
            if(!this.s.equals(o.s))return false;

            return true;
        }

        @Override
        public String toString() {
            return "(" + this.a + ", " + this.s + ")";// whatever we want to see at the time of printing this object instead of showing obj address.
        }
    }

    public static void solution(){
        HashMap<Pair, Integer> map = new HashMap<>();
        for(int i = 0; i < 5; i++){
            Pair p = new Pair(72, "Vikash Yadav");
            System.out.print(p + " => ");
            map.put(p, map.getOrDefault(p,0) + 1);
        }
        System.out.println(map.size());
        System.out.println(map);
    }

    public static void main(String[] args) {
        solution();
    }
}
