package GRAPH;

import java.util.ArrayList;
import java.util.List;

public class G_56_Articulation_Point_in_Graph {

    // Articulation points means -> Nodes on whose removal the graph breaks into Multiple components.
    // Prerequisite of this question is we have to know about bridges in previous video, or we can say that we must have idea about timeIN, lowestTime etc.
    // So, as we know that timeIn[] = store the time of insertion during DFS, and lowestTime[] = min of all adjacent nodes apart from parent and vis nodes.
    // In the bridges we were not taking parent only, but in this problem we have to assume parent and visited node as well, for better understanding please re-watch the video at the time of revision.
    // So, basically in bridges problem we were removing edges only, but in Articulation point we will be removing entire node that is basic difference between those questions.
    // In this problem we have to reach somewhere before the node, not at the node. that's why there will be slightly change we have to see in the solution.
    // Updated condition will be look like that if(low[it] >= tIn[node] && parent != -1), '=' because if we are reaching at the node, no problem because,
    // We are going to remove that node, as we know that we have to reach somewhere before the node, and Parent != -1, it is a new slight change,
    // Apparently, if we are at starting point then there will no change come if we will remove the starting point, yes for the edge cases at starting point we will apply some different logic.
    // If a node is completed its DFS and that is not a parent or visited node then we will take the low of that node, but
    // In case of if at the time of returning if adjacent node is visited then we will take timeIn of that node not lowestTime that is also a change in this question.
    // for visited node why are we taking timeIn instead of taking lowestTime, because if we remove that node then we can not reach somewhere via that node.
    // Means we will take timeIn, because with this it might be possible we can reach somewhere before the node.

    // So for the starting point we have to understand that if starting is having more than one child then there will be possibility of Articulation point so, we will handle it separately.
    // We will do hashing because it might be possible that if there will be multiple components added to the articulation point then, that will be triggered two times so, we have to take care of it.

    // TC -> (V+2E) + O(V), SC -> O(3V).

    public static int timer = 0;

    public static void dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int[] timeIn, int[] lowTime, int[] mark){
        // here mark is used as hashing, means if someone is repeating itself as Articulation point then there will no difference come into the answer.

        vis[node] = true;
        timeIn[node] = lowTime[node] = timer;
        timer++;
        int child = 0;
        for(int it : adj.get(node)){
            if(it == parent)continue;

            if(!vis[it]){
                dfs(it, node, vis, adj, timeIn, lowTime, mark);
                lowTime[node] = Math.min(lowTime[node], lowTime[it]);

                if(lowTime[it] >= timeIn[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }else{
                lowTime[node] = Math.min(lowTime[node], timeIn[it]);
            }
        }
        // it is to handle the starting node if it is having more than one child.
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }

    public static List<Integer> articulationPoints(int v, ArrayList<ArrayList<Integer>> adj){
        List<Integer> ans = new ArrayList<>();
        int[] mark = new int[v];
        boolean[] vis = new boolean[v];
        int[] timeIn = new int[v];
        int[] lowTime = new int[v];

        for(int i = 0; i < v; i++){
            // if given graph is having multiple components then we have to handle them
            if(!vis[i]){
                dfs(i, -1, vis, adj, timeIn, lowTime, mark);
            }
        }
        for(int i = 0; i < v; i++){
            if(mark[i] == 1){
                ans.add(i);
            }
        }

        if(ans.size() == 0){
            ans.add(-1);
            return ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        int v = 7; // 0-based indexing.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++)adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);

        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(2).add(5);

        adj.get(3).add(0);
        adj.get(3).add(2);

        adj.get(4).add(2);
        adj.get(4).add(6);

        adj.get(5).add(2);
        adj.get(5).add(6);

        adj.get(6).add(4);
        adj.get(6).add(5);

        System.out.println(articulationPoints(v, adj));

    }
}
