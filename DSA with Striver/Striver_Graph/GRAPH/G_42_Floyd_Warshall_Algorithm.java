package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;

public class G_42_Floyd_Warshall_Algorithm {

    // This algorithm is  also used for the shortest path algorithm. This algorithm is very different from the Dijkstra and BellManFord algorithms.
    // As we know that in Dijkstra and BellmanFord, we were using just single source, means we had to find just single source shortest, path.
    // But Floyd warshall is used to find the shortest path from every node to every node, means we have to make every node as src and destination as well.
    // Means, in this as we see that there are multiple source, that's why this is known as Multi-source shortest, path algorithm.
    // It helps us to detect -ve cycle as well.
    // To find answer Note -> Go via every vertex/node, this is work/logic of this algo.
    // We will be using Directed graph over here as well, but in case if we have undirected graph then we will split that things in directed edges with same weights like previous.

    // As usual before applying Floyd warshall we have to calculate costMatrix, like adjacencyMatrix, from the given graph. for better understanding at the time of revision please re-watch the video again.
    // So, when we will complete via every one and, fill the matrix then in last we will find the shortest path for everyone to everyone.

    // The algorithm is not much intuitive as the other ones. It is more of a brute force, where all combination of paths have been tried to get the shortest path.
    // Nothing to be panic much on hte intuition, it is a simple brute on all paths. Focus on the three 'for' loops. first on is for 'via',
    // and remaining two loops is using for the iterating the matrix.

    // How to detect a -ve cycle via this algo =>  if the casting of node to node is -ve, means less than 0, it means there will be a -ve cycle, because
    // As we know that node to node distance will be 0. But if -ve cycle is present then it will come lesser than '0'.


    // Time complexity -> O(n^3), SC -> O(n^2), this is nothing but, we are using costMatrix.

    // But what if we apply Dijkstra -> Dijkstra can not handle -ve cycle, but if there is no any -ve cycle then we can apply Dijkstra for all the nodes as src node
    // Which will take time => v * e log v. still better than Floyd warshall.


    public static void FloydWarshallAlgo(int[][] costMatrix){
        // do it in place, means there is no need to make another new matrix for calculation, update the given matrix into the answer.

        // if given cost is '-1' then convert it into '1e9'. for comparison. and in the last do same thing if some entry will be 1e9 then do it as -1.

        int n = costMatrix.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(costMatrix[i][j] == -1){
                    costMatrix[i][j] = (int)1e9;
                }
                if(i == j)costMatrix[i][j] = 0;// cost from node to itself will be 0.
            }
        }


        // This is original algorithm.

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // here we can make one extra condition that is if node is not reachable then continue, for this see the next problem.
                    costMatrix[i][j] = Math.min(costMatrix[i][j], costMatrix[i][via] + costMatrix[via][j]);
                }
            }
        }

        // if there will any -ve cycle then do it. and basically to do it we changed -1 to 1e9, because it is based on the -ve values.
        // we will check only for self node, that will give our answer, if -ve cycle will be present.

       for(int i = 0; i < n; i++){
           if(costMatrix[i][i] < 0){
               System.out.println("There is a -ve cycle in the given graph");
               return;
           }
       }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(costMatrix[i][j] == (int)1e9){
                    costMatrix[i][j] = -1;
                }
            }
        }
    }


    public static class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }

    public static void main(String[] args) {

        int v = 4; // 0-based indexing
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); // we can also create direct adjMatrix, but I am doing it for better understanding.
        for(int i = 0; i < v; i++)adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1,2));

        adj.get(1).add(new Pair(0, 1));
        adj.get(1).add(new Pair(2,3));

        adj.get(3).add(new Pair(0,3));
        adj.get(3).add(new Pair(1,5));
        adj.get(3).add(new Pair(2,4));

        // make the adjMatrix/costMatrix => if distance will be not given then write as '-1', we can also do it using '1e9', but we are doing according to gfg pattern.

        int[][] costMatrix = new int[v][v];
        for(int i = 0; i < v; i++){
            for(Pair it : adj.get(i)){
                int j = it.node;
                int wt = it.weight;
                costMatrix[i][j] = wt;
            }
        }

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                // if i!= j because that will be always 0, and remaining 0 will be changed into -1.
                if(i!= j && costMatrix[i][j] == 0)costMatrix[i][j] = -1;
            }
        }

        // Above thing will not be a requirement, this is only for better understanding to convert a graph into adjMatrix.

        FloydWarshallAlgo(costMatrix);
        for(int[] a : costMatrix){
            System.out.println(Arrays.toString(a));
        }

    }
}
