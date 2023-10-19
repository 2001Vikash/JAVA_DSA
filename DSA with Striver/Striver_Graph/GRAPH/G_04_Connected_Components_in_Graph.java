package GRAPH;

public class G_04_Connected_Components_in_Graph {

    // Means graph can be connected and can not be as well because if we have given n = 10 no. of nodes and m = 8 no. of edges in graph then when we will
    // draw this graph then we will find that there will be 4 different graph exist that is main thing which we need to understand that graph can be given
    // in form of connected manner and can not be.
    // means if a graph which is not connected then we can see that there are some different graphs but still we will assume them as single graph without connection.

    // But when we apply some traversal algorithm in disconnected graph then we will not be able to visit all graphs that's why we have to use
    // visited array that will us to know that Where are we. and size of the visited array will be n+1.
    // If in question 1-based indexing is given then we always run a loop from 1 -> n for any traversal algorithm.
    // If the node is not visited then we will call the traversal algorithm from that Node.
    // Initially we will be filled array with false value means unvisited that is right as well because before starting we did not visit any node.
    // And if we visit a node then we will put true in the visited array means if some reasons if we will come on that node again then we will not continue again.
    // Traversal algorithms is designed in such a manner if they start from a node then they will visit all connected nodes that is main advantage of connected components in graph.

    // Code will look like for visited
    /*
         for(int i = 1; i <= n; i++{
            if(!vis[i])
              traverse(i);
           }
     */

    // Because we know that if graph has multiple components then via the help of traversal algorithm we can not visit every node of the graph.

}
