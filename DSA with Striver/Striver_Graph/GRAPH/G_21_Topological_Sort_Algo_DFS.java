package GRAPH;

import java.util.ArrayList;
import java.util.Stack;

public class G_21_Topological_Sort_Algo_DFS {

    // In this lecture we will learn Topological sorting using DFS that is nothing but depth first search.

    // Topological sorting is only exists on DAG that is Directed Acyclic graph , means any directed graph that has not any cycle.

    // Definition of Topological sort -> Linear ordering of vertices such that if there is an edge between u & v, u appears before v in that ordering.
    // To see definition with example please go in main function and explore graph.

    // Why only DAG? -> because according to definition if an edge between u and v then u must be appeared before v but if we take undirected graph then
    // There will be violation of this definition because in undirected graph u appears before v and v appears before u both are correct.
    // Acyclic because if we have a cycle in the graph then assume 1->2, 2->3, 3->1 so order will be 1,2,3 but 3 comes before 1 it is not possible because
    // 1 comes before 3 then it's reverse means violation of definition of Topological sorting. means no, any present cyclic dependency in graph.

   // In algo we start from 0 for the DFS call and also declare a stack (LIFO DS) and before going back from the function call take that vertex and put it into the stack.
    // And in the last whatever value in the stack take out one by one and that will be one of the linear ordering. that is known as topological sort for the given graph.

    // SC -> O(n) + O(n) and TC -> similar to DFS algo like O(V+E) in worst case.



     public static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
         vis[node] = true;

         for(int nbr : adj.get(node)){
             if(!vis[nbr]){
                 dfs(nbr, vis, st, adj);
             }
         }

         st.push(node);
     }

    public static void topologicalSortUsingDFS(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }

        System.out.println("Linear ordering is : " + list);
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 6; // where vertices will be in range of 0 to v-1.

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        // This is a directed graph.
        // And also this is possible linear ordering, vertices like 5,4,2,3,1,0 in this order we can see that for 5 -> 0, 5 come before 0 and so on for everyone.
        // As well 4,5,2,3,1,0 this can be also a valid linear ordering for the given graph. this is also known as Topological sorting.
        // means there can be multiple ordering but in this question we have to find only one of the topological sorting order.

        adj.get(5).add(0);
        adj.get(5).add(2);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(3).add(1);

        adj.get(2).add(3);

        topologicalSortUsingDFS(v, adj);
    }
}
