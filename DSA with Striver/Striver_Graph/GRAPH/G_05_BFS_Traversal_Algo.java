package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G_05_BFS_Traversal_Algo {

    // BFS -> stands for Breadth first search in graph this is Traversal technique in graph which we used in order to traverse any graph.

    // As we know that BFS -> Breadth it is important here breadth means "Level wise". Ya so we can also take this as level wise.
    // How can we define levels see generally in the graph question they will provide use starting node of the graph so, we will assume that given node.
    // at level 0 and after that whichever node will come at a distance one we will say that they are at level-1 that's why we can understand the level concept.
    // But let say that if we have not given starting node as 1 if they will give 6 then what will happen then
    // In this case no problem we will assume that 6 is at level-0 then after whoever node at distance 1 they will come after that because for 6 that will be level-1
    // Means it will go for next level in equivalent distance in Breadth (we can understand it as level).
    // Depending on the starting node traversal will be changed.

    // For this algorithm we have some initial configuration that is
    // first of all we will define a Queue data structure and, we know that queue is followed FIFO rule that is first In first Out.
    // And secondly we have to create visited array with size n+1(if 1-based index) that is also an important part of the traversal algo for if graph have multiple components.
    // And we will put the starting node in queue and as well visited as 1 at the index of  given node that is some initial requirement which we have to do.
    // In next step whatever we have in queue we will start taking out them till the queue is not empty. and we printed.(remove, work, mark* according to pep-coding)

    // So we print and ask that who are your neighbours and take them and put in to queue and marked as 1 in visited array.
    // and so on...


    public static ArrayList<Integer> BFS(int V, ArrayList<ArrayList<Integer>> graph){

        // Where V is the no. of vertices or Node

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1]; // because 1-based indexing is given.
        Queue<Integer> q = new LinkedList<>();


      //or  ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int node = q.remove();
            // q.remove() is slightly different from q.poll() , q.poll() will return Null if q is empty but q.remove() will throw exception.
            bfs.add(node);

            for(int nbr : graph.get(node)){
                if(!vis[nbr]){
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }

        return bfs;
    }



    public static void main(String[] args) {

        int n = 3, m = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        // n+1
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // In general
        //  adj.get(u).add(v);
        // adj.get(u).add(v);

        // If graph is directed then remove adj.get(u).add(v).

        // edge 1 -> 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // edge 2 -> 3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // edge 1 -> 3
        adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(BFS(n, adj));

    }
}
