package GRAPH;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class G_24_Course_Schedule_I_and_II_Or_Prerequisite_Task_Topological_Sort {

     // There are total of N task, labeled from 0 to N-1. One task may have pre-requisites, for ex. to do task 0 you to first complete task 1,
    // which is represented as a Pair(0,1).
    // Given the total number of task N and a list of pre-requisite pairs p, find if it is possible to finish all tasks.
    // means if we have pair like 2,3 then if we want to perform 3 then firstly we have to complete 2 before 3 that is the meaning of pre-requisite task.
    // when we can not perform task, if we find the cyclic dependency then we can not perform for ex. if we have pairs like 1,2  4,3  2,4  4,1
    // in this 1,2  2,4  4,1 is showing cyclic dependency that's why we can't perform it
    // means for the given pair of class we have to return true if we can perform operation and if not then return false.

    // To solve this problem we will use Topological sort because according to this algo we have to sure about two things that is graph must be directed
    // and second one is DAG that is directed acyclic graph means graph have not any cycle then only we can apply topological sort
    // So in order to solve this question we know given pairs are directed because they are given 1,2 and 1 has to be done before 2 means 1 -> 2 this the direction of graph'
    // after that we have to find topological sort and if topological list is having N no. of elements then we will tell that yes this possible and if not then return false;

    // But instead of using DFS we will use BFS because next problem is based on this problem where we have to find ordering.


    public static ArrayList<Integer> courseSchedule2(int[][] pair){ // or pre-requisite task.

        // with the help of given pairs we have to create the directed graph in order to use topological sorting.
        //In this problem we have to return ordering if possible and if not then return empty array.

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = pair.length;

        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }
        // graph is formed
        for(int i = 0; i < v; i++){
            adj.get(pair[i][1]).add(pair[i][0]);
        }

        // Now from here we will apply topological sort.

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[v+1];

        for(int i = 1; i <= v; i++){
            for(int nbr : adj.get(i)){
                inDegree[nbr]++;
            }
        }

        for(int i = 1; i <= v; i++){
            if(inDegree[i] == 0)q.add(i);
        }

        ArrayList<Integer> tps = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.remove();
            tps.add(node);

            for(int nbr : adj.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        if(tps.size() == v){
            return tps;
        }
        return new ArrayList<>();
    }


    public static boolean courseSchedule1(int[][] pair){

        // with the help of given pairs we have to create the directed graph in order to use topological sorting.

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = pair.length;

        for(int i = 0; i <= v; i++){
            adj.add(new ArrayList<>());
        }
        // graph is formed
        for(int i = 0; i < v; i++){
            adj.get(pair[i][0]).add(pair[i][1]);
        }

        // Now from here we will apply topological sort.

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[v+1];

        for(int i = 1; i <= v; i++){
            for(int nbr : adj.get(i)){
                inDegree[nbr]++;
            }
        }

        for(int i = 1; i <= v; i++){
            if(inDegree[i] == 0)q.add(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int node = q.remove();
            count++;

            for(int nbr : adj.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        if(count == v){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] pair = {{1,2}, {4,3}, {2,4}, {4,1}};

        System.out.println(courseSchedule1(pair));


        // In course schedule II problem is same but in that pair is given in the reverse manner.

        System.out.println(courseSchedule2(pair));


        // Pattern -> whenever we see something before something in problem then we must have to think about topological sort.

    }
}
