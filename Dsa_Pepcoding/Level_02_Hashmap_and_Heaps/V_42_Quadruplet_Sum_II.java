package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_42_Quadruplet_Sum_II {

    // In this problem, we are given four arrays A,B,C,D of integers, All arrays are of same length N. we have to find out the count of all
    // unique quadruplets a,b,c,d such that A[a] + B[b] + C[c] + D[d] = 0.

    // To solve this question we will two arrays in one array and then after we will have two arrays, and we have to search target as 0 using hashmap.

    public static void solution(int[] A, int[] B, int[] C, int[] D, int target){
        // TC -> O(n^2), SC -> O(n^2)
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;

        for(int e1 : A){
            for(int e2 : B){
                map.put(e1 + e2, map.getOrDefault(e1+e2, 0) + 1);
            }
        }

        for(int e3 : C){
            for(int e4 : D){
                int req = target - (e3 + e4);
                cnt += map.getOrDefault(req, 0);
                // may be one sum is adding again and again
                if(map.containsKey(req)) {
                    if (map.get(req) == 1) {
                        map.remove(req);
                    } else {
                        map.put(req, map.get(req) - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
