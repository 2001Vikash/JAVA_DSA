package GRAPH;

public class G_01_Introduction_to_graph {

    // Types of graph -> Undirected graph, Directed graph.

    // Graph consists Node/Vertices, there is no any specific order to, numbering the node. We can make in any order numbering of the Nodes.

    // And graph also consists Edge which is used to connect the two nodes in the graph. Edge can be directed and undirected .

    // In undirected graph there will no any directed edges like if we connect the node 1 to node2 then , also we can go node2 to node1 via that edge.
    // But in directed graph We can go only in specified direction, also we can make multiple directed edges in directed graph, for ex, 1 -> 2, 2 -> 1.


    // Cycles in a Graph -> Graph does not mean that have an enclosed structure, Binary tree can be also a graph because BT fulfill the all properties of graph.
    //                  -> Cycle -> If we are starting from a Node and do end at that Node that means we can say that graph has cycle type structure.

    // If we find a cycle in undirected graph then we will call that cyclic undirected graph.

    // If we do not find cycle in directed graph then we will be called as Directed Acyclic graph (DAG).

    // Path -> Can contain a lot of Nodes/vertices and each of them are reachable.
    // Note -> A node can not appear twice in a path, It can only appear once.

    // Degrees in the graph -> The number of edges that go inside + go outside that is known as Degree of Undirected graph.
    //               property -> In undirected graph { total degree of a graph = 2 * no. of edges } because every node is connected with two nodes in undirected graph.
    

    // Directed graph -> Degree => there will be two degree -> 1. In-degree(node), 2. Out-degree(node)
    // In-degree => the no. of incoming edges on a Node, Out-degree => the no. of outgoing edges from a Node.

    // Edge Weights -> It might be possible in problem, they will be used a weight for edges like for every edge they can give weight for that.
    // Note => In case if the weight is not provided then we will assume always unit weight that is 1.


}
