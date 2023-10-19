package GRAPH;

public class G_43_Find_the_City_with_the_smallest_number_of_Neighbours_at_a_Threshold_Distance {

    // Problem states that ->
    // There are 'n' cities numbered from 0 to n-1. Given the array edges where edges[i] = [from, to, weight] represents a bidirectional and weighted edge
    // between cities 'from' and 'to' and the given the integer distance Threshold. You need to find out a city with the smallest number of cities that
    // are reachable through some path and whose distance is at most Threshold distance, if there are multiple such cities, our answer will be the
    // city with the greatest number.
    // Note -> that the distance of a path connecting cities i and j is equal to the sum of the edge's weight along that path.
    // Means, whenever we will find the shortest path to reach at a node then we will check that distance is lesser than equal to threshold distance.

    // In order to solve this problem we have requirement of Floyd Warshall Algorithm. Can be also done via Dijkstra because there is any -ve cycle mention.
    // At the time of doing via Dijkstra we have to do it for every node, means we have to make src every node at once.


    public static int solution(int[][] dist, int threshold){
        int n = dist.length;

        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // if we do not write it then no problem but, it is good.
                    if(dist[i][via] == (int)1e9 || dist[via][j] == (int)1e9)continue;// because if we go then we will not find answer, we can go but if we skip then it will be better for TC.
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int countCity = n; // we have to find smaller that's why consider it as large.
        int cityNo = -1;// initially there is no any city is found.
        for(int city = 0; city < n; city++){
            int count = 0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(dist[city][adjCity] <= threshold){
                    count++;
                }
            }
            if(count <= countCity){
                countCity = count;
                cityNo = city;
            }
        }
        return cityNo;
    }


    public static void main(String[] args) {

        // As we know that to solve this problem via floyd warshall we have required adjMatrix, instead of making graph we will make adjMatrix directly,
        // previously we have seen that how to convert a graph into adjacencyMatrix.
        // Since this is undirected graph but, we use it as directed graph using two directed edges between two nodes.
        // We will denote 1e9, if there is no any direct edge.

        int val = (int)1e9;
       int[][] adjMatrix = {   {0,3,val,val},
                               {3,0,1,4},
                               {val,1,0,1},
                               {val,4,1,0} };

        System.out.println("Answer is = " + solution(adjMatrix, 4));

    }
}
