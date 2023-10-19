package GRAPH;

public class G_34_Dijkstra_Algorithm_Why_PQ_and_Not_Q_Intuition {

    // If we do it via a Queue instead of doing via PriorityQueue. and Time complexity is O(E*log V) why? we will be seeing all these things.
    // And what is intuition behind the Dijkstra's Algorithm that is also another question which can come in to the mind.

    // When will we use Queue then if from node  a -> b to node b if there were two path then in case of queue we will explore both path and at the end
    // we will take the minimal distance path but in case of Priority Queue we will not be exploring, all those paths which is having more distance to reach.
    // that is main difference between two things and that will increase the time complexity as well due to some more iteration. which is a bit of time-consuming.
    // So, we can say that at the time of using Queue data structure we are solving problem using Brute force solution like explore all paths and take the minimal.
    // but, if We will use Priority Queue then we can say that we will be using Greedy approach(minimal first) to find the right answer that is also a difference in deep manner.
    // It means as we use Priority queue we can avoid the unnecessary path exploration and as well we can avoid some extra iteration.  and that is the intuition behind the using of Priority Queue data structure.


    /* Time complexity -> Why it is O(E * log V).  where E -> total number of edges and V is the number of Nodes.

              => pseudocode for dijkstra's algorithm.

                  while(!pq.isEmpty(){  ->  assume that in worst case this while loop will run for all the nodes that is 'V'.

                  -> means v * the entire things which is coming down.

                     dist, node = pq.top() and remove the top element from the queue. => it will take time log(heap-size) at the worst case

                     for(Iterate on adjacent nodes){ => this is number of edges in the graph

                     -> assume that we have most dense graph(for worst case) like every is connected to all other nodes
                        means in worst case edges will be at max 'V-1'


                        if(conditional check)
                           update dist
                           push in pq -> and again push will take log(heap-size).
                     }
                  }

                  ==> After the seeing above things we can write these things like that,

                TC ->   O(V * (pop vertex from Min_Heap + no. of edges on each vertex * push into PQ ))
                TC -> O(V * ( log(heap-size) + (V-1) * log(heap-size) ))
                TC -> O(V * ( log(heap-size) * (V-1+1) ))
                TC -> O(V * ( V * log(heap-size) ))
                TC -> O(V^2 * log(heap-size) )

                -> Now we have to figure out this heap size :
                                   if we see in worst case like we have a dense graph and every one is giving minimal distance(Hypothetically) in worst case
                                   then it means if we push the first src node and, when iteration will happen then "V-1" nodes will be pushed into the PQ
                                   so this thing will be happened for every node like 'V-1' + 'V-1' + ... V times  will be entered into PQ
                                   It means we can see easily that this will be near about - V^2 nodes will be entered into PQ at worst case that is hypothetical.
                So,
                    TC -> O(V^2 * log(V^2) )
                    TC -> O(V^2 * 2 * log(V) )

                    -> V is no. of nodes -> So if everyone is connected to each other and, we have 'V' node and 'V-1' edges then how much total number of edges will have
                                               that is nothing but (V-1) * V = near about V^2 which is nothing but total number of edges and, we can write as 'E'

                    Now,
                        TC -> O( E * 2 * log(v) ) where 2 is constant so, we can ignore in worst case

                        TC -> O(E * log(V)). => hence proved in worst case or, we can say that very hypothetical time complexity for the Dijkstra's algo will be O(E*log(v)).


     */


}

