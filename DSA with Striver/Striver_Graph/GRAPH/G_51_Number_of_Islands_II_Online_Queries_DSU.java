package GRAPH;

import java.util.ArrayList;
import java.util.List;

public class G_51_Number_of_Islands_II_Online_Queries_DSU {

    // This is second problem based on number of Islands-II. It's a problem which is kind of Online Queries. Means I give you a query and, you tell me the answer.
    // In given problem '0' is sea and '1' is Island.

    // In this problem we have given some queries in the term of axes, and we have to make island at that place. If we have already Island over there then
    // We do not place again Island at that place.
    // What is means by components in this question, so if Island share their side then we will say that this is component, not diagonally.
    // So, we will write number of group of components after every Query. We have to return online queries list like that.

    // So, as we see this problem we can observe that we are attaching things in dynamic way, which one algo will be using -> Disjoint Set data structure.

    // If we are representing every cell as a node then initially we have to give the numbers for every cell because,
    // we know that in DSU initially every node will be working as parent itself.
    // But how do we give this number, formula is -> (row,col) = (row*col) + col;
    // We will use visited array to take care of repeated things, and as well to know about the components.
    // Initially we have to assume every cell is alone and after that check for the surrounded guys

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

    public static List<Integer> solution(int n, int m, int[][] operations){
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int[] it : operations){
            int row = it[0];
            int col = it[1];
            if(vis[row][col]){ // if it is already an Island.
                ans.add(cnt);
                continue;
            }

            vis[row][col] = true;
            cnt++; // count as an individual guy.

            int[] dR = {-1,0,1,0};
            int[] dC = {0,1,0,-1};
            for(int i = 0; i < 4; i++){
                int adjRow = row + dR[i];
                int adjCol = col + dC[i];
                if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m && vis[adjRow][adjCol]){ // if it is an Island then we will go for connections.
                    int nodeNumber = row * m + col;
                    int adjNodeNumber = adjRow * m + adjCol;
                    if(ds.findPar(nodeNumber) != ds.findPar(adjNodeNumber)){
                        cnt--;
                        ds.UnionBySize(nodeNumber, adjNodeNumber);
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }


    public static void main(String[] args) {
        int n = 4,m = 5;
        int[][] operations = new int[12][2]; // it will be given in the questions.

        operations[0][0] = 0;
        operations[0][1] = 0;

        operations[1][0] = 0;
        operations[1][1] = 0;

        operations[2][0] = 1;
        operations[2][1] = 1;

        operations[3][0] = 1;
        operations[3][1] = 0;

        operations[4][0] = 0;
        operations[4][1] = 1;

        operations[5][0] = 0;
        operations[5][1] = 3;

        operations[6][0] = 1;
        operations[6][1] = 3;

        operations[7][0] = 0;
        operations[7][1] = 4;

        operations[8][0] = 3;
        operations[8][1] = 2;

        operations[9][0] = 2;
        operations[9][1] = 2;

        operations[10][0] = 1;
        operations[10][1] = 2;

        operations[11][0] = 0;
        operations[11][1] = 2;

        System.out.println("Answer : " + solution(n,m,operations));
    }
}
