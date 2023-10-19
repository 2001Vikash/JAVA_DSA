package GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class G_53_Most_Stones_Removed_with_Same_Row_or_Column_DSU {

    // On gfg this problem is named as Maximum stones removal.

    // Problem states that,
    // There are 'n' stones at some integer coordinate points on a 2D plane. Each coordinate point may have at most one stone.
    // You need to remove some stones.
    // A stone ca br removed if it shares either the same row or the same column as another stone that has not been removed.
    // Given an array stones of length 'n' where stones[i] = {Xi,Yi} represents the location of the ith stone, return the maximum possible number of
    // stones that you can remove.
    // Actually we can remove a stone if some stone come into a row two or more times, and same for the column, this is basic thing for removal.

    // So, if we see this problem with another view that will be like that, we have to connect components in 4 directions, whatever size we will find
    // from that we can remove componentSize-1 stones, and this is the way to solve this problem.
    // For example if a component which is having 1 stone then we can remove (1-1) stone that is 0, in that way we will be doing our work.

    // In sort, we can say if for given coordinate we have 3 components, every one is having size x,y,z correspondingly.
    // So, we can say that our answer will be x-1+y-1+z-1 = x+y+z-3, as we know that x+y+z = n, then ans = n - no. of connected components.

    // Now, whenever we will see connected components type thing, which algo come in to the mind, that will be a traversal(DFS or BFS) or
    // Disjoint set ds, which helps to  connect the node in a very appropriate manner.

    // In implementation part we will assume every row as node and, for column as well but with shifting, like if we have 5 rows , from 0 to 4
    // then we will start column from col+4+1, means if column is 0 then, shifted location will be 0+4+1 = 5. and so on. please see the video again at the time of revision.

    private static class DisjointSet{
        ArrayList<Integer> parent, size;

        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void UnionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u == ulp_v)return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static int solution(int[][] stones, int n){
        // Here in the question it is not mention, about the matrix so,
        // we will find the end point of row and col for the matrix/grid according to given stones coordinates.

        int maxRow = 0, maxCol = 0;
        for(int[] it : stones){
            maxRow = Math.max(maxRow, it[0]);
            maxCol = Math.max(maxCol, it[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1); // +1 for the safety reasons, we can do ti without this.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] it : stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow + 1;
            ds.UnionBySize(nodeRow, nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            if(ds.findPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        return n - cnt;

        // We can do it this question with the help of making grid or, making every coordinate as node and, give the proper name for that.
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        System.out.println("We can remove max stones = " + solution(stones,n));
    }
}
