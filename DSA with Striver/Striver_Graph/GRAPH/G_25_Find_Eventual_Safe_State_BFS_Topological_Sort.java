package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class G_25_Find_Eventual_Safe_State_BFS_Topological_Sort {


    // We have already done this problem while we did cycle detection,  but since now we are going to do it via Topological sort.

    // For knowing about problem please see problem from GFG for the better understanding.
    // Basically we have to find safe node that will find this like that if node is ending at a terminal node then that will be known as safe node.
    // And a terminal node is nothing but if any node is having 0 outgoing edges that will be known as terminal node and.
    // for checking safe node we have to check for all path if all path is ending at a terminal node then only we will say that node is a safe node.

    // So as we know that all the terminal nodes will be safe node.
    // To find initial terminal node we have to find a node such that having outgoing degree is 0.
    // We know that in Topological sort everything is solved in sense of inDegree but in this problem we are seeing outDegree
    // So to convert this problem into inDegree we have to reverse the every edge in given graph so with the help of this instead if seeing outDegree we can work on inDegree that is the intuition of this question.

    // Now apply Topological sort.
    // According to this algo -> 1. get all the nodes with inDegree is 0, 2. do a removal of edges on adjacent nodes.

    // Now we can say after the reversing of graph that any node which is having inDegree is 0 that will be a terminal node. it is just for understanding from here we just have to apply plane Topological sort.

    // TC -> similar to Topological sort and for sorting the safeNode list and SC -> Extra space for the Reverse Adjacency list. this is similar like tracing back or, we can say that Backtracking method.


    public static ArrayList<Integer> eventualSafeStateViaBFS(int v, ArrayList<ArrayList<Integer>> adj){

        // Reversing the graph.

        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < v; i++)revAdj.add(new ArrayList<>());

        for(int i = 0; i < v; i++){
            for(int nbr : adj.get(i)){
                revAdj.get(nbr).add(i);
            }
        }

        int[] inDegree = new int[v];
        for(int i = 0; i < v; i++){
            for(int nbr : revAdj.get(i))inDegree[nbr]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < v; i++)
            if(inDegree[i] == 0)q.add(i);

        ArrayList<Integer> safeNode = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.remove();
            safeNode.add(node);// because whoever node is in the queue that is having inDegree 0.

            for(int nbr : revAdj.get(node)){
                inDegree[nbr]--;

                if(inDegree[nbr] == 0)q.add(nbr);
            }
        }

        Collections.sort(safeNode);

        return safeNode;
    }


    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 7; // means nodes will in range of  0 to 6.

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(5);

        adj.get(3).add(0);

        adj.get(4).add(5);

        // and for 5 and 6 there is no any neighbour means outgoing degree is 0 means in this graph they are also terminal node.
        // As we check for 0 is a safe node or not then answer is to that is not a safe node because it is directed toward itself via a cycle
        // means we can not go at a terminal node from 0 and same thing will be happened with 1. like that we will check a node is safe or not.
        // 0 have one path which is end up at a terminal node but, we have to see this condition for all paths if any path is violating the condition then we will say that this is not a safe node.
        // And every terminal node will be also a safe node.

        System.out.println("Safe nodes are : "+ eventualSafeStateViaBFS(v, adj));

    }
}
