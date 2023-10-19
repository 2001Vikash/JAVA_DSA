package Level_01_Trees.Binary_Trees;

public class Introduction {

    // Binary tree -> There is allowed only max two child for the node and not necessary to say that left child is small and right is big
    // Root node has max two child and leaf node have 0 child and for the middle node it can be 0, 1, 2.
    // main difference between Generic tree and Binary tree is only for the no of child allowed
    // Binary trees are used to solve the mathematical operation like 2 + 3 * 5 and so on
    public static class Node{
        int data;
        Node left;
        Node right;
        // There is no requirement of the list
        // left , right are able to handle the tree

        // Constructor
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
