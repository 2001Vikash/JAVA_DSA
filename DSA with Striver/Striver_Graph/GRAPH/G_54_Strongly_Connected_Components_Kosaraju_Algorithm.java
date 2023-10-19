package GRAPH;

import java.util.ArrayList;
import java.util.Stack;

public class G_54_Strongly_Connected_Components_Kosaraju_Algorithm {

    // This problem is generally known as SCC, that is based on Kosaraju's Algorithm.
    // In interview there can be two types of questions on this 1. figure out the no. of SCC, 2. print the SCC.

    // Note -> Strongly connected components are only valid for Directed graphs.

    // SCC -> So, every individual node will come in Strongly connected components.
    //        apart from this SCC means if every pair of nodes/vertex is reachable to each other, then they will be called as SCC.
    //        for ex. 0,1,2 in the given graph, we can give these in any order, to understand in lemon language we can say that nodes which are involved in cycle they will be coming under SCC.
    //        pair means we can take 0,2 or 0,1 or 1,2 and, if we are trying to go 0 to 2 or 2 to 0, then we can reach that is the meaning of the definition.


    // Thought process behind / intuition behind the Kosaraju's Algo which is used to solve this problem.

    // So, if we will do simply DFS then we will start from the very first node and, we will end up at last node so, in this way we can not find SCC,
    // but assume that if we have 4 SCCs, so, we know that SCC1 is go for SCC2 and so on, so if we reverse the edges that are helping to connect the SCCs,
    // then after that apply DFS then we will easily find the SCCs because DFS call will not go further beyond the SCC1 because edges that are helping to connect
    // the SCCs they are reversed. But question arises that if I do not know about the SCCs then how do we reverse the edges.
    // So, fine it is right but,  we can reverse all the edges that will be not a problem I think, then after Will this make change in SCCs => No.
    // Because SCCs says that every pair of vertex is reachable to each other that's it and, if we reverse all the edges there will be no any change occur in SCCs.
    // So, for understanding it please draw the graph and reverse it then try to find out the SCCs, So, it will be understandable more.

    // So, reversal of edges, will help us to go for the next SCCs at the time of doing DFS, but how do I know that we have to start from 0, because it might be possible that 0 can be in any SCCs.
    // This is  where something like starting time and Finishing time will come. We will see it but right now we have to understand the meaning of reversing the edges that is nothing but, we are trying to stop DFS to go for the next SCCs.
    // Because if we do not know about starting point then what will happen if our starting point is part of last SCCs and, we are reversing then DFS will not stop at only one SCCs it will go for next as well that's why we use finishing time to find first elements.


    // Now let us know Kosaraju's Algo => It states that hey
    //  1. Sort all the edges according to finishing time.
    //  2. Reverse the graph
    //  3. Do a DFS,   So these are three steps come in Kosaraju's Algo.

    // Finishing time is nothing but If we will apply DFS on a graph then when DFS call will come back, so these type of all points comes under finishing points.
    // Sort according to finishing time is nothing but Do DFS and at the time of coming back store the nodes/vertex that is sorting according to finish time.

    // So, after reversing the graph apply the DFS, and now we know that who is part of SCC1 that is nothing but that guy who is ending in last means top element if stack if we are using stack for storing the elements who are sorted according to finishing time.
    // So. pop the first element from the stack and do DFS after that we can find our desired answer that is algo working.
    // And, DFS will happen same no. of times as the no. of SCCs.

    // TC -> O(V+E) for DFS(2 times) + O(V+E) for reversing the graph, SC -> O(V+E) + O(V) for vis + O(V) for stack.


    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = true;

        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    public static void dfsForNextStep(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfsForNextStep(it, vis, adj);
            }
        }
    }

    public static int KosarajuAlgoSCCs(int v, ArrayList<ArrayList<Integer>> adj){

        // Step - 1. Sort the graph according to finishing time, meanwhile we have to use DFS with stack to store the elements according to their finishing time.
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }

        // Step 2 -> Reverse the graph.

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < v; i++)adjRev.add(new ArrayList<>());

        for(int i = 0; i < v; i++){
            for(int it : adj.get(i)){
                // i -> it, reverse it -> i
                adjRev.get(it).add(i);
            }
        }

        vis = new boolean[v]; // or we can do vis[i] = false; in previous loop where we are reversing the graph.

        // Step -3 : According to stack make DFS call, means now we make DFS call according to finishing time.

        int sccCnt = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                sccCnt++;
                dfsForNextStep(node, vis, adjRev);
            }
        }

        return sccCnt;
    }

    // for printing, we can send an ArrayList in DFS call and at the time of returning we will add the node, and store in main function at the time of call in the listOfList.


    public static void main(String[] args) {
        int v = 8; // 0-based indexing
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++)adj.add(new ArrayList<>());

        adj.get(0).add(1);

        adj.get(1).add(2);

        adj.get(2).add(0);
        adj.get(2).add(3);

        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(4).add(7);

        adj.get(5).add(6);

        adj.get(6).add(4);
        adj.get(6).add(7);
        // 7 is not connected with anyone.

        System.out.println("No. of SCCs = " + KosarajuAlgoSCCs(v, adj));

    }
}
