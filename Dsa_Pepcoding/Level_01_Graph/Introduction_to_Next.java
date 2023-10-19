package Level_01_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Introduction_to_Next {

  /*
    Graph ->  Graph have been vertices and edges. and edge can be weighted and can be  not.
              To represent it we use Adjacency Matrix which is a 2-D matrix
              initially it consists 0 and when we need to represent an edge then we put 1 accordingly
              but we use when vertices < 10000. otherwise 2-D matrix can't form.

     The most Popular presentation of Graph is Adjacency List -> this is Array of ArrayList of edges Array
     for ex. we make array int[] arr means this arr is array of integer like that
     adjacency list is also made of Array of ArrayList of edges

   */
    public static class Edge{
        int src; // source
        int nbr; // neighbour
        int wt; // weight

      Edge(int src, int nbr, int wt){
          this.src = src;
          this.nbr = nbr;
          this.wt = wt;
      }
  }

    public static void main(String[] args){
        int vertices = 7;// 0,1,2,3,4,5,6 in native language gola
           // type      array
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));
        graph[2].add(new Edge(2,5,10));// only for the hamiltonian cycle

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,3));

        graph[5].add(new Edge(5,2,10));// only for the hamiltonian cycle
        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));

        int src = 0;
        int dest = 6;
        boolean[] visited = new boolean[vertices];
//        boolean path = hasPath(graph, src, dest, visited);
//        System.out.println(path);

       // printAllPaths(graph, src, dest, visited, src + "");

//        multiSolver(graph,src,dest,visited,"",0,3,40);
//        System.out.println("Smallest path : " + sPath);
//        System.out.println("Smallest path weight = " + sPathWt);
//        System.out.println("Largest path : " + lPath);
//        System.out.println("Largest path weight = " + lPathWt);
//        System.out.println("Ceil path : " + cPath);
//        System.out.println("Ceil path weight = " + cPathWt);
//        System.out.println("Floor path : " + fPath);
//        System.out.println("Floor path weight = " + fPathWt);
//        System.out.println("Kth largest weight = " + pq.peek().wsf);


        // Get connected components of a Graph.

//        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//        for(int v = 0; v < vertices; v++){
//            if(!visited[v]){
//                ArrayList<Integer> comp = new ArrayList<>();
//                getConnected(graph, v, visited, comp);
//                comps.add(comp);
//            }
//        }
//        System.out.println(comps);

      //  System.out.println("Number of Island in the given area = " + noOfIsland());

       // perfectFriends();

      //  hamiltonianPathOrCycle(graph, 0);


        knightTour();
    }

    // Question -> Has Path -> how to find path in graph using Depth first search means DFS.

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(Edge edge : graph[src]){// graph is an array of arrayList so if we write graph[src] means this is a ArrayList of Edges that's why we need to write Edge

            if(!visited[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if (hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }

    // Print all paths

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path){
        if(src == dest){
            System.out.println(path);
            return;
        }
        visited[src] = true;
        for(Edge edge: graph[src]){
            if(!visited[edge.nbr]){
                printAllPaths(graph, edge.nbr, dest, visited, path + edge.nbr);
            }
        }
        visited[src] = false;
    }


    // MultiSolver - Smallest, Longest, Ceil(Just larger), Floor(Just smaller), KthLargest Path.

    public static class Pair implements Comparable<Pair> {
        // this is all about of the Priority queue which is a part of Hashing
        // and right now I have not idea about it.
        int wsf;
        String psf;
        Pair(int wsf, String psf){
            this.wsf = wsf;
            this.psf = psf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    public static String sPath ;// smallest path in the term of weight
    public static int sPathWt = Integer.MAX_VALUE;// smallest path weight
    public static String lPath = "";// longest path
    public static int lPathWt = Integer.MIN_VALUE;// longest path weight
    public static String cPath = "";// ceil path
    public static int cPathWt = Integer.MAX_VALUE;// ceil path weight
    public static String fPath = "";// floor path
    public static int fPathWt = Integer.MIN_VALUE;// floor path weight
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();
    // it is a minimum priority queue which helps us. To find the kth max wsf.
    // it is basically work like this firstly it will take k value and smaller of them put it on peek and compare
    // if incoming elements are more than the peek then it will take inside and remove the peek element and so on.
    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf, int k, int criteria){
        // psf -> path so far
        // wsf -> weight so far
        // criteria for ceil and floor value
        if(src == dest){
            if(wsf < sPathWt){
                sPath = psf;
                sPathWt = wsf;
            }
            if(wsf > lPathWt){
                lPath = psf;
                lPathWt = wsf;
            }
            if(wsf > criteria && wsf < cPathWt){
                cPath = psf;
                cPathWt = wsf;
            }
            if(wsf < criteria && wsf > fPathWt){
                fPath = psf;
                fPathWt = wsf;
            }
            if(pq.size() < k){
                pq.add(new Pair(wsf, psf));
            }else{
                if(wsf > pq.peek().wsf){
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(!visited[edge.nbr]){
                multiSolver(graph, edge.nbr, dest,visited,psf+edge.nbr, wsf+edge.wt, k, criteria);
            }
        }
        visited[src] = false;
    }


    // Get connected components of a Graph.

    public static void getConnected(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){


        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src]){
            if(!visited[e.nbr]){
                getConnected(graph, e.nbr, visited, comp);
            }
        }
    }


    // Is graph connected .... if every vertex has way to go for the rest of all the vertex then we say that graph is connected

    // It is nothing but same like a previous question only we need to check that if comps means bigger list has 1 size then we will say
    // that graph is connected and if we have more than 1 size then we will say that this is not a connected graph.



    // Question -> Number of Islands

    // It's an application of get component graph question.
    // In this question we have given a 2-d matrix with 0's and 1's element. all 0's are lands and all 1's are water
    // all cell is connected from their north, east, west, south. find out that how many Island over there.
    // in the 2-d array all entries are like as vertex and connection of four directions are edges.
    // here we need to visualize it as a graph.

    public static int noOfIsland(){
        int count = 0;
        int[][] arr = {{0,0,1,1,1,1,1,1},
                       {0,0,1,1,1,1,1,1},
                       {1,1,1,1,1,1,1,0},
                       {1,1,0,0,0,1,1,0},
                       {1,1,1,1,0,1,1,0},
                       {1,1,1,1,0,1,1,0},
                       {1,1,1,1,1,1,1,0},
                       {1,1,1,1,1,1,1,0}};

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    // here i and j will work as source
                    getFindConnectedGraph(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void getFindConnectedGraph(int[][] arr, int i, int j, boolean[][] visited){
        // now we have two to check the conditions one is we can give condition for every direction means in proactive manner or we can give all those
        // conditions in reverse order in the base case in reactive manner if we are going wrong then return like that.
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j]){
            // if we put it all those conditions separately then we need to use and at the place of or.
            return;
        }
        visited[i][j] = true;
        // for the north or up
        getFindConnectedGraph(arr, i-1, j, visited);
        // for the west or right
        getFindConnectedGraph(arr, i, j+1, visited);
        // for the east or left
        getFindConnectedGraph(arr, i, j-1, visited);
        // for the south or down
        getFindConnectedGraph(arr, i+1, j, visited);

    }



    // Perfect Friends problem -> It is also of getConnected components Application

    // to understand this question please refer the pepCoding video lecture
    // in this question we need to select pairs means two persons
    // so how many ways to select pairs such that the two people does not belong to the same club. so firstly find the all clubs. then try

    public static class Edge2{
        int src;
        int nbr;
        Edge2(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void perfectFriends(){
        int n = 7; // that is no. of vertices
        int k = 5; // that is no. of edges



        // for this question I am going to create another graph for this.

        // Input for this question
        /*Please Enter the next two connected vertices
        0 1
        Please Enter the next two connected vertices
        2 3
        Please Enter the next two connected vertices
        4 5
        Please Enter the next two connected vertices
        5 6
        Please Enter the next two connected vertices
        4 6

        // out put for this input.
        No. of Pairs = 16

         */

        ArrayList<Edge2>[] graph = new ArrayList[n];
        for(int v = 0; v < n; v++){
            graph[v] = new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        for(int e = 0; e < k; e++){
            System.out.println("Please Enter the next two connected vertices");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge2(v1,v2));
            graph[v2].add(new Edge2(v2,v1));
        }
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int v = 0; v < n; v++){
             if(!visited[v]){
                 ArrayList<Integer> comp = new ArrayList<>();
                 getTreeAndComps(graph, v, comp, visited);
                 comps.add(comp);
             }
        }
        int pairs = 0;
        for(int i = 0; i < comps.size(); i++){
            for(int j = i + 1; j < comps.size(); j++){
                int count = comps.get(i).size() * comps.get(j).size();
                pairs += count;
            }
        }
        System.out.println("No. of Pairs = " + pairs);
    }
    public static void getTreeAndComps(ArrayList<Edge2>[] graph, int src, ArrayList<Integer> list, boolean[] visited){
        visited[src] = true;
        list.add(src);
        for(Edge2 e : graph[src]){
            if(!visited[e.nbr]){
                getTreeAndComps(graph, e.nbr, list, visited);
            }
        }
    }


    // Question -> Hamiltonian Path and Cycles in Graphs and Graph Theory

    // Hamiltonian path -> A path which is started from the source vertex and reach for the end vertex without twice visiting at any node,
                   //      means go for the source to index in only one time visit at every node.
    // If in the visit of like this if we find a cycle then that cycle is known as hamiltonian cycle. means 0 to end and end to 0.

    public static void hamiltonianPathOrCycle(ArrayList<Edge>[] graph, int src){
        HashSet<Integer>  visited = new HashSet<>();
        hamiltonian(graph, src, visited, src + "", src);
    }
    public static void hamiltonian(ArrayList<Edge>[] graph, int src,  HashSet<Integer>  visited, String psf, int oSrc){// oSrc -> means original src
        if(visited.size() == graph.length - 1){ // or psf.length() == graph.length
//            System.out.println(psf);
//            System.out.println(visited);
            boolean checkForCycle = false;
            for(Edge e : graph[src]){
                if(e.nbr == oSrc){// oSrc -> Original source
                    checkForCycle = true;
                    break;
                }
            }
            if(checkForCycle){
                System.out.println("HC");// means hamiltonian cycle
            }else{
                System.out.println("HP");// means only hamiltonian path.
            }
            return;
        }
        visited.add(src);
        for(Edge e : graph[src]){
            if(!visited.contains(e.nbr)){
                hamiltonian(graph, e.nbr, visited, psf + e.nbr, oSrc);
            }
        }
        visited.remove(src);
    }



    // Question -> Knights Tour

    // we have n*n chatBoard and also given the starting point

    public static void knightTour(){

        int[][] chess = new int[4][4];
        int rowStart = 2;
        int colStart = 1;
        printKnightTour(chess, rowStart, colStart, 1);
    }
    public static void printKnightTour(int[][] chess, int r, int c, int move){
        // here is move means move number because we know that knight can move in to 8 direction with its conditions
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0){
            return;
        }else if(move == chess.length * chess.length){
            chess[r][c] = move;
            display(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnightTour(chess, r-2, c+1, move+1);
        printKnightTour(chess, r-1, c+2, move+1);
        printKnightTour(chess, r+1, c+2, move+1);
        printKnightTour(chess, r+2, c+1, move+1);
        printKnightTour(chess, r+2, c-1, move+1);
        printKnightTour(chess, r+1, c-2, move+1);
        printKnightTour(chess, r-1, c-2, move+1);
        printKnightTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
    }
    public static void display(int[][] chess){
        for(int[] arr : chess){
            for(int e : arr){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }




    // Breadth First Search (BFS) or Traversal -> before this whatever we was doing that all was based on Depth first search.


}
