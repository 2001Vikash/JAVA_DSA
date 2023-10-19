package Level_01_Trees.Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Generic_Tree_MultiSolver {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node){
        String str = node.data + " -> ";
        for(Node child : node.children){
            str += child.data + " ";
        }
        str += ".";
        System.out.println(str);
        for(Node child  : node.children){
            display(child);
        }
    }
    public static Node constructTree(int[] arr){
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }


    // These are properties
    // According to these declaration they will always present in heap memory there is no any requirement in function passing

    static int size;
    static int min;
    static int max;
    static int height;
    public static void multiSolver(Node node, int depth){
      size++;
      min = Math.min(min, node.data);
      max = Math.max(max, node.data);
      height = Math.max(height, depth);

      for(Node child : node.children){
          multiSolver(child, depth + 1);
      }
    }

    // Predecessor and Successor of An Element

    // means whatever value given by the user before value of that value is Predecessor
    // after value of that value is Successor value in Euler Path means in preOrder traversal
    // Root node has not any predecessor means null
    // and last leaf node in Euler path hasn't successor means null
    static Node predecessor;
    static Node successor;
    static int state; // to identify the these two values
    public static void predecessorAndSuccessor(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state == 1){
               successor = node;
               state = 2;
        }

         for(Node child : node.children){
             predecessorAndSuccessor(child, data);
         }
    }


    // Ceil and Floor in Generic Tree
    // Ceil -> smallest among larger or another name is just larger
    // Floor -> Largest among smaller or another name is just smaller
    // if we passed smallest value from the tree's data value then Ceil is that passing value(min value) but Floor is -infinitive
    // if we passed largest value from the tree.data then Floor is max value of the tree but Ceil is +infinitive

    static int ceil;
    static int floor;
    public static void ceilAndFloor(Node node, int data){
        // for  the ceil
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }
        // for the floor
        if(node.data < data){
            if(node.data > floor){
                floor = node.data;
            }
        }
        for(Node child : node.children){
            ceilAndFloor(child, data);
        }
    }


    // Kth largest element in the Generic tree
    // if k == 3 the find the 3rd largest value
    // here we are going to use ceil floor value concepts
    // for ex if the asked for k == 3
    // then firstly we find the floor for the +infinitive that is 120
    // and after that find the floor for 120 that is 110
    // and after that find the floor for the 110 that is 100 and this is also our 3rd largest value


    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            ceilAndFloor(node, factor);// will set floor just smaller from the factor that is +infinitive
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }


    // Node with Maximum Subtree Sum
    // MSST -> Max sum subtree
    static int maximumSUmNode = 0;
    static int maximumSum = Integer.MIN_VALUE;
    public static int returnSumAndCalculateMSST(Node node){
        int sum = 0;
        for(Node child : node.children){
            int childSum = returnSumAndCalculateMSST(child);
            sum += childSum;
        }
        sum += node.data;
        if(sum > maximumSum){
            maximumSUmNode = node.data;// here we are trying to calculate something else and return something else
            maximumSum = sum;
        }
        return sum;
    }


    // Diameter Of Generic Tree
    // It is defined as maximum no. of edges in between any two Nodes in the tree
    public static int diameter = 0;
    public static int calculateDiameterReturnHeight(Node node){
        int deepestChildHeight = -1;
        int secondDeepestChildHeight = -1;
        for(Node child : node.children){
            int childHeight = calculateDiameterReturnHeight(child);
            if(childHeight > deepestChildHeight){
                secondDeepestChildHeight = deepestChildHeight;
                deepestChildHeight = childHeight;

            }else if(childHeight > secondDeepestChildHeight){
                secondDeepestChildHeight = childHeight;
            }
        }
        if(deepestChildHeight + secondDeepestChildHeight + 2 > diameter){
            // it means dch + sdch + 2 means via me
            diameter = deepestChildHeight + secondDeepestChildHeight + 2;
        }
        deepestChildHeight += 1;

        return deepestChildHeight;
    }


    // Iterative Pre_Order and Post_Order Traversal
// for this we will make a pair class Stack that will have node and state(initial: -1 means node is in preorder right now)

    /* Algo ->
             if state == -1 then Print in preOrder & state++
             if state == childSize Print in postOrder & pop
             if state == 0 to childSize - 1, then state++ and make a new pair for that child
     */
     static class Pair{
         Node node;
         int state;
         Pair(Node node, int state){
             this.node = node;
             this.state = state;
         }
    }
    public static void iterativePreAndPostOrder(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        String preOrder = "";
        String postOrder = "";
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == -1){
                preOrder += top.node.data + " ";
                top.state++;
            }else if(top.state == top.node.children.size()){
                postOrder += top.node.data + " ";
                st.pop();
            }else {
                // Means in between
                Pair childPair = new Pair(top.node.children.get(top.state), -1);
                st.push(childPair);
                top.state++;
            }
        }
        System.out.println(preOrder);
        System.out.println(postOrder);
    }



    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructTree(arr); // travel and cause effect is another name of this strategy.
        // Initialize the all properties
//        size = 0;
//        min = Integer.MAX_VALUE;
//        max = Integer.MIN_VALUE;
//        height = 0;
//        int depth = 0; // because height is nothing but deepest node
//        multiSolver(root, depth);
//
//        System.out.println("Size = "+ size);
//        System.out.println("Min = "+ min);
//        System.out.println("Max = "+ max);
//        System.out.println("Height = "+ height);

//        predecessor = null;
//        successor = null;
//        state = 0;
//        predecessorAndSuccessor(root, 100);
//        if(predecessor == null){
//            System.out.println("Not Found");
//        }else{
//            System.out.println("predecessor : "+predecessor.data);
//        }
//        if(successor == null){
//            System.out.println("Not Found");
//        }else{
//            System.out.println("successor : "+successor.data);
//        }

        // Ceil and Floor

//        ceil = Integer.MAX_VALUE; // smallest among larger so here max value is like identity element for this
//        floor = Integer.MIN_VALUE;// largest among smaller so here min value is like identity element for this
//        ceilAndFloor(root, 65);
//        System.out.println("Ceil : " + ceil);
//        System.out.println("Floor : " + floor);


        // Kth largest element in the Generic tree

       // System.out.println(kthLargest(root, 3));


        // Node with Maximum Subtree sum

//        returnSumAndCalculateMSST(root);
//        System.out.println(maximumSum + ", "+ maximumSUmNode);


        // Diameter of Generic Tree
//        calculateDiameterReturnHeight(root);
//        System.out.println(diameter);


        // Iterative Pre_Order and Post_Order Traversal

          // iterativePreAndPostOrder(root);

    }
}
