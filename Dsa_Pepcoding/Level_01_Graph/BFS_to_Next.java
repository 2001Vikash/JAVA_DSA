package Level_01_Graph;

import java.lang.reflect.Array;
import java.util.*;

public class BFS_to_Next {
    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;// 0 to 6
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int v = 0; v < vertices; v++){
            graph[v] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,25));// to understand  difference between dijkstra and prims 40 ko 25 kre.

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));
    //    graph[2].add(new Edge(2,5,10));// only for the hamiltonian cycle

        graph[3].add(new Edge(3,0,25));// to understand  difference between dijkstra and prims 40 ko 25 kre.
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

    //    graph[5].add(new Edge(5,2,10));// only for the hamiltonian cycle
        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));

      //  BFS(graph, 2);

       // cycleDetectionWithBfs(graph);

      //  isBipartiteGraph(graph, 0);

       // numberOfInfectedPeoples(graph, 6, 3);// BFS is right for this because it grows in radius

//        DijkstraAlgo(graph, 0);
//        System.out.println();
//        primsAlgorithm(graph, 0);


        // This is not going to work for the topological sort because there are need to directed graph but this graph is undirected.

      //  TopoLogicalSort(graph);


        IterativeDFS(graph, 0 , 6);
    }


    // Breadth First Search (BFS) or Traversal -> before this whatever we was doing that all was based on Depth first search.
   // In tree it is like as a level order traversal.

    // In questions -> you have been given a src vertex and apply the BFS over there.

    // Note -> Algo => r m* w a* -> remove, mark(star), work, add(star). here we are going to use queue data structure in the visualization
    //            m* means mark it and star means if it is already marked then continue. do nothing. and same for add star means add who is not marked.

    // So basically BFS grows in the term of radius like at 0 level 1 distance, 1 level 2distance and on abd try out the minimum distance path.

    public static class Pair{
        int v;
        String psf; // path so far.
        Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge>[] graph, int src){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src+""));
        boolean[] visited = new boolean[graph.length];
        while(q.size() > 0){
            // r m* w a*
            Pair rem = q.removeFirst();// remove
            if(visited[rem.v]){
                continue; // skip if already marked
            }
            visited[rem.v] = true;// mark *
            System.out.println(rem.v + " @ " + rem.psf);// work

            for(Edge e : graph[rem.v]){// add * if not added
                if(!visited[e.nbr]){
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }

    }


    // Is Graph cyclic or not

    // same concept like BFS to detect a cycle in graph we can use BFS and DFS as well.
    // but here we need to take care about that graph is connected or not. that's why we will use get connected comp. concept as well
    public static void cycleDetectionWithBfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int v = 0; v < graph.length; v++){// this is for unconnected graph.
            if(!visited[v]){
                // traverse
                boolean cycle = isCyclic(graph, v, visited);
                if(cycle){
                    System.out.println("Yes cycle is found");
                    return;// or we can use break as well.
                }
            }
        }
        System.out.println("No there is no any cycle is found here.");

    }
    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src+""));// there is no any work of psf but we put for better understanding
        while(q.size() > 0){
            Pair rem = q.removeFirst();
            if(visited[rem.v]){
               // continue;
                // so no need to continue if it is visited already then it means there is cycle.
                // means to go for a node there are two ways that is showing cycle
                // so return true;
                return true;
            }
            visited[rem.v] = true;
            for(Edge e : graph[rem.v]){
                if(!visited[e.nbr]){
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
        return false;
    }



    /* Question -> Is graph Bipartite :

                Definition -> A graph is said to be Bipartite if it is possible to divide the vertices of graph in to two mutually
                              exclusive(means interSection must be 0 means no common vertices in both) and exhaustive
                              (means all vertices present either in set1 or in set2  means union of both must be equal to all vertices) subsets.
                              such that all the edges are across set ( means there is no any edges in between same set).

                Meaning -> This question is nothing. but it is extension of cyclic graph.

                        Note ***-> Every non-cyclic (acyclic) graphs are Bipartite.
                                if cycle length is odd then that is not a Bipartite graph and if length is even then definitely it will Bipartite.

                      So for dividing to sets we will being used BFS algo.
     */

    public static class Pair2{
        int v;
        String psf;
        int level;
        Pair2(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }
    public static void isBipartiteGraph(ArrayList<Edge>[] graph, int src){
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int v = 0; v < graph.length; v++){
            if(visited[v] == -1){
                boolean ans = checkBipartiteNess(graph, v, visited);
                if(!ans){
                    System.out.println("Not a Bipartite graph");
                    return;
                }
            }
        }
        System.out.println("It's a Bipartite graph");
    }

    private static boolean checkBipartiteNess(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<Pair2> q = new ArrayDeque<>();
        q.add(new Pair2(src, src + "", 0));
        while(q.size() > 0){
            Pair2 rem = q.removeFirst();
            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]){
                    return false;// means odd length cycle detected
                }
            }else{
                visited[rem.v] = rem.level;
            }
            for(Edge e : graph[rem.v]){
                if(visited[e.nbr] == -1){
                    q.add(new Pair2(e.nbr, e.nbr + rem.psf, rem.level + 1));
                }
            }
        }
        return true;
    }




    // Question on BFS -> Spread of Infection.

    // for Question please refer the websites and here given time in 1 second infection spread with neighbour then after 3 second how much peoples infected

    public static class Pair3{
        int v;
        int time;
        Pair3(int v, int time){
            this.v = v;
            this.time = time;
        }
    }
    public static void numberOfInfectedPeoples(ArrayList<Edge>[] peoples, int src, int time){
        ArrayDeque<Pair3> q = new ArrayDeque<>();
        int[] vis = new int[peoples.length];
        int count = 0;
        q.add(new Pair3(src, 1));
        while(q.size() > 0){
            Pair3 rem = q.removeFirst();
            if(vis[rem.v] > 0){
                continue;
            }
            vis[rem.v] = rem.time;
            if(rem.time > time){
                break;
            }
            count++;

            for(Edge e : peoples[rem.v]){
                if(vis[e.nbr] == 0){
                    q.add(new Pair3(e.nbr, rem.time + 1));
                }
            }
        }
        System.out.println(count);
    }




    // Dijkstra Algorithm in Graph (Single Source Shortest Path in weights)

    // used to find shortest path in weighted graph.

    // when ever we have required of shortest path in terms of edges then apply BFS.

    // this is exactly same as BFS but here we are using Priority queue

    public static class Pair4 implements Comparable<Pair4> {// here we are implementing because this is an Interface
        int v;
        String psf;
        int wsf;
        Pair4(int v, String psf, int wsf){
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair4 o) {
            return this.wsf - o.wsf;
        }
    }
    public static void DijkstraAlgo(ArrayList<Edge>[] graph, int src){
        PriorityQueue<Pair4> pq = new PriorityQueue<>();
        pq.add(new Pair4(src, src + "", 0));
        boolean[] vis = new boolean[graph.length];
        while(pq.size() > 0){
            Pair4 rem = pq.remove();
            if(vis[rem.v]){
                continue;
            }else{
                vis[rem.v] = true;
            }
            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
            for(Edge e : graph[rem.v]){
                if(!vis[e.nbr]){
                    pq.add(new Pair4(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }




    // Prims Algorithm -> Minimum Spanning tree --> Minimum wired required to connect all Pcs

    // MST -> Minimum spanning tree is such a sub-graph which consists ->
                                              // Subgraph
                                              // Tree(Acyclic/non-cyclic)
                                              // spanning(means all vertex are present over there.
    // so there are many spanning trees but MST is whom that have minimum edges wt sum is known as Minimum spanning tree.
    // To find MST we two types of algorithm one is Prims and other is Kruskal Algo. here we are going to see Prims

    // prims uses for finding minimum spanning tree but dijkstra for single source shortest path

    public static class Pair5 implements Comparable<Pair5> {
        int v;
        int av; // acquired vertex
        int wt;
       Pair5(int v, int av, int wt){
            this.v = v;
            this.av = av;
            this.wt = wt;
        }
        public int compareTo(Pair5 o){
            return this.wt - o.wt;
        }
    }
    public static void primsAlgorithm(ArrayList<Edge>[] graph, int src){
        PriorityQueue<Pair5> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        pq.add(new Pair5(src, -1, 0));
        while(pq.size() > 0){
            Pair5 rem = pq.remove();
            if(visited[rem.v]){
                continue;
            }
            visited[rem.v] = true;
            if(rem.av != -1){
                // first wale ko skip krna o imaginary hai jo assume hua hai
                System.out.println("[ " + rem.v + " - " + rem.av + " @ " + rem.wt + " ]");
            }

            for(Edge e : graph[rem.v]){
                if(!visited[e.nbr]){
                    pq.add(new Pair5(e.nbr, rem.v, e.wt));
                }
            }
        }
    }




    // Order of Compilation -> It is for directed graph which is also known as Topological sort algorithm with DFS
    // for this we have directed acyclic graph.

    // Topological Sort -> A permutation of vertices for a directed acyclic graph is called topological sort if for all directed edges uv like
    //                      u --> v, u appears before v in the graph. If there is no any dependencies between two nodes then they can come according
    // to requirement means u can come after v or before v according to its requirement

    // for example if we have files like one dependent with another so we can arrange all those file in Reverse Topological sorting order.
    // means order of work will be in reverse of Topological sort.
    // so for topological sort we use stack.


    public static void TopoLogicalSort(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < graph.length; v++){
            if(!visited[v]){
                topoLogicalSort(graph, v, visited, st);
            }
        }
        System.out.println(st);
        while (st.size() > 0){
            System.out.print(st.pop() + " "); // both are different printing
        }
    }
    public static void topoLogicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st){

        visited[src] = true;
        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                topoLogicalSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src);// we need to add in postOrder only we can't do this in PreOrder because we don't know that if anyone is dependent the current
                     // edge and he is not a part of that combination of graph means different component
    }





    // Iterative DFS ->

    // To achieve this we only replace queue with stack in BFS.
    // so doing this we can perform reverse euler in depth that is DFS.

    // But what is the significance of this if we have already DFS with recursion.
    // Let us see We know that when we are calling a function in recursion then it will go in to the system stack that is not object stack
    // which we make that is system stack which has very less size .
    // In java we can only make 10000 calls in recursion stack after that it will give StackOverFlow exception.
    // When does it occur -> If we have a linear graph/tree like 0 -- 1 -- 2 -- 3.... and so on then this time we need to use Iterative DFS
    // to avoid StackOverFlow exception.
    // and to perform Iterative DFS we use also stack that is not call stack it is object of stack class which is in Heap memory.


    public static class Pair6{
        int v;
        String psf;
        Pair6(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }

    public static void IterativeDFS(ArrayList<Edge>[] graph, int src, int dest){
        boolean[] vis = new boolean[graph.length];
        Stack<Pair6> st = new Stack<>();
        st.push(new Pair6(src, src + ""));
        while(st.size() > 0){
            Pair6 rem = st.pop();
            if(vis[rem.v]){
                continue;
            }
            vis[rem.v] = true;
            if(rem.v == dest){
                System.out.println(rem.psf);
            }
            for(Edge e : graph[rem.v]){
                if(!vis[e.nbr]){
                    st.push(new Pair6(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}
