package Level_01_Trees.Generic_Tree;

import java.util.*;

public class V_02_to_32_Generic_Tree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(){
            // because of whenever we provide a parameterised constructor then java will remove the
            // by default means normal constructor
        }
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root1 = null;
        Node root2 = null;
        // here in the array -1 means we are in right of that element in Euler path
       int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
char[] arr2 = {'a','b','e','@','f','@','@','c','g','@','h','k','@','l','@','@','i','@','@','d','j','@','@','@'};

       Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size() > 0){
                    st.peek().children.add(t);
                }else{
                    root1 = t;
                }
                st.push(t);
            }
        }
        Stack<Node> st2 = new Stack<>();
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i] == '@'){
                st2.pop();
            }else{
                Node t = new Node();
                t.data = arr2[i];

                if(st2.size() > 0){
                    st2.peek().children.add(t);
                }else{
                    root2 = t;
                }
                st2.push(t);
            }
        }

     //   display(root);

     //   System.out.println(size(root));

    //    System.out.println(max(root));

     //   System.out.println(height(root));

     //   traversals(root);

//        levelOrderTraversal(root);
//        levelOrderLinewise(root);

     //   levelOrderLinewiseInZigZag(root);

     //   levelOrderTraversalLinewiseUsingSingleQueue(root);

        levelOrderTraversalLinewise3(root1);

//        levelOrderTraversalLinewise4(root);

//        display(root);
//        System.out.println();
//        removeLeaves(root);
//        System.out.println();
//        display(root);

//        display(root);
//        System.out.println();
//        mirror(root);
//        System.out.println();
//        display(root);

//        linearize(root);
//        display(root);
//          linearize2(root);
//          display(root);

//        System.out.println(findAnElement(root, 110));
//        System.out.println(findAnElement(root, 1100));

      //  System.out.println(nodeToRootPath(root, 110));

      //  System.out.println(lowestCommonAncestor(root,60,110));
       // System.out.println(distanceBetweenTwoNodes(root1,60, 110));




    }

    // For Displaying tree
    public static void display(Node node){

        // d(10) = selfD(10) + d(20) + d(30) + d(40)

        String str = node.data + " -> ";
        for(Node child : node.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        // Remaining things will print by the next recursion calls
        for(Node child : node.children){
            display(child);
        }
    }

    // To find out the size of the tree

    public static int size(Node node){
        int size = 0;
        for(Node child : node.children){
            int childSize = size(child);
            size += childSize;
        }
        size += 1; // for the node.data

        return size;
    }


    public static int max(Node node){
        int max = Integer.MIN_VALUE;

        for(Node child : node.children){
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);

        return max;
    }

    // Height of a Generic Tree
    // To find it firstly we need to identify the Depth of the tree according to two types
    // due to edges and due to Nodes only difference is one in between both.
    // Height -> Depth of the deepest Node is Height of the tree

    // This  solution is in term of the Edges.
    public static int height(Node node){
        int ht = -1; // Why -1 because of it also help to handle base case
        for(Node child : node.children){
            int htc = height(child);
            ht = Math.max(ht, htc);
        }
        ht += 1;

        return ht;
    }


    // Traversals in a Generic Tree
    // PreOrder --> Euler path -> Node left side (Before going deep in the Recursion)(Firstly Root Node visited)
    // PostOrder --> Euler path -> Node right side(While coming out of the Recursion)(Root node visited in last)

    public static void traversals(Node node){
        // Euler's left, on the way deep in the recursion , or Node's preArea
        System.out.println("Node Pre "+ node.data);

        for(Node child : node.children){
            // Edge Pre
            System.out.println("Edge Pre "+ node.data + "--"+ child.data);

            traversals(child);

            //Edge Post
            System.out.println("Edge Post "+ node.data + "--"+ child.data);
        }

        // Euler's right, on the way out of recursion , or Node's postArea
        System.out.println("Node Post "+ node.data);
    }


    // Level Order Traversal in Generic Tree

    // So do this we need to use Queue data structure with Operation -> r -> remove, p -> print, a -> add
    // So we need to follow the rule that is remove print and add the children in the queue
    public static void levelOrderTraversal(Node node){
       Queue<Node> q = new ArrayDeque<>();
       q.add(node);
       while (q.size() > 0){
          node = q.remove();
           System.out.print(node.data+" ");
           for(Node child : node.children){
               q.add(child);
           }
       }
        System.out.println(".");
    }


    // LevelOrder Linewise in Generic Tree -> means Every levels elements print in different lines

    public static void levelOrderLinewise(Node node){
        Queue<Node> mainQ = new ArrayDeque<>();
        Queue<Node> childQ = new ArrayDeque<>();

        mainQ.add(node);
        while(mainQ.size() > 0){
            node = mainQ.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children){
                childQ.add(child);
            }

            if(mainQ.size() == 0){
                mainQ = childQ;
                childQ = new ArrayDeque<>();
                System.out.println();
            }
        }
    }


    // Level Order LineWise but im zig zag form means firstly we are going to follow right to left and
    // After that left to right and so on

    public static void levelOrderLinewiseInZigZag(Node node){
        // To solve this Question we need two stacks rather than using of two queues
        // and a flag/level variable
        // remove print add
        Stack<Node> mainSt = new Stack<>();
        Stack<Node> childSt = new Stack<>();
        mainSt.push(node);
        int level = 1;
        while(mainSt.size() > 0){
            node = mainSt.pop();
            System.out.print(node.data + " ");

            if(level % 2 == 1){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    childSt.push(child);
                }
                }else{
                for(int i = node.children.size() - 1; i >= 0; i--){
                    Node child = node.children.get(i);
                    childSt.push(child);
                }
            }
            if(mainSt.size() == 0){
                mainSt = childSt;
                childSt = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }


    // More approaches for Level Order traversal linewise

    // Instead of using two queues we use a marker like as null we put in queue and use only one queue
// We can call this approach as Delimiter


    public static void levelOrderTraversalLinewiseUsingSingleQueue(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));

        while (q.size() > 0){
            node = q.remove();
            if(node.data == -1){
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                }
            }else{
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    q.add(child);
                }
            }
        }
    }


    // There is another approach that we can call as Count approach

    public static void levelOrderTraversalLinewise3(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(q.size() > 0){
            int childrenInCurrentLevel = q.size();

            for(int i = 0; i < childrenInCurrentLevel; i++){
                node = q.remove();
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    // Another approaches ->> Pair class using in this -> consists Node and level

    private static class Pair{
        Node node;
        int level;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void levelOrderTraversalLinewise4(Node node){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));

        int level = 1;
        while(q.size() > 0){
            Pair p = q.remove();
            if(p.level > level){
                level = p.level;
                System.out.println();
            }

            System.out.print(p.node.data + " ");
            for(Node child : p.node.children){
                Pair chilPair = new Pair(child, p.level + 1);
                q.add(chilPair);
            }
        }
    }

    // Remove Leaves from a Generic tree

    public static void removeLeaves(Node node){
//        for(Node child : node.children){
//            removeLeaves(child);
//        }

//        for(Node child : node.children){
//            // So due to using of this Loop we can't remove and access concurrently
//            // it throws an error called 'ConcurrentModificationException'.
//            if(child.children.size() == 0){
//                node.children.remove(child);
//            }
//        }
        // So if we want to remove this error then we can use another loop liek as

//        for(int i = 0 ; i < node.children.size(); i++){
//            Node child = node.children.get(i);
//            // but in this code there is a Logical error
//            // that is removing concept of the list from the front
//            // whenever we remove anything from the list, list size is reduced by one
//            // so at that i pointer will same but one element will remain for checking
//            // and that element will never go to check
//            // for example if we have ArrayList and we need to remove even element from the list
//            // so if we will be going to remove from the front
//            // then some elements must be remained.
//
//            // To remove this logical error
//            // we remove from the end of the List
//            // Means Loops are started from the end and check and removed
//            if(child.children.size() == 0){
//                node.children.remove(child);
//            }
//        }

        for(int i = node.children.size() - 1; i >= 0; i--){
            // But there is also a problem that post order removal in the tree
            // 80 ke child the but due to post order 80 will be treated as leaf node and removed
            // so to remove this problem we need to put it in preOrder
            // means recursion call ko iske baad rakhe

            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for(Node child : node.children){
            removeLeaves(child);
        }
    }


    // Mirror of a tree

    public static void mirror(Node node){
        for(Node child : node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
    }


    // Linearize a Generic tree -> Arranges it like as linear tree in preOrder it means every node have only one child

    public static void linearize(Node node){
        for(Node child : node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lastChild = node.children.remove(node.children.size() - 1);
            Node secondLastChild = node.children.get(node.children.size() - 1);
            Node secondLastTail = getTail(secondLastChild);
            secondLastTail.children.add(lastChild);
        }
    }
    private static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }



    // Linearize with an Efficient way  because of previous solution is in O(^2)
    // means here we are going to try to solve it in O(n) complexity

    public static Node linearize2(Node node){
        // lkt -> last ki tail
        if(node.children.size() == 0){
            return node;
        }

        Node lkt = linearize2(node.children.get(node.children.size() - 1));
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastKiTail = linearize2(secondLast);
            secondLastKiTail.children.add(last);
        }

        return lkt;
    }


    // Find an element in a Generic tree

    public static boolean findAnElement(Node node, int data){
        if(node.data == data){
            return true;
        }
        for(Node child : node.children){
            boolean findInChild = findAnElement(child, data);

            if(findInChild){
                return true;
            }
        }
        return false;
    }


    // Node to Root path

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for(Node child : node.children){
            ArrayList<Integer> pathTillChild = nodeToRootPath(child, data);
            if(pathTillChild.size() > 0){
                pathTillChild.add(node.data);
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }


    // Lowest common Ancestor in generic Tree


    public static int lowestCommonAncestor(Node node, int d1, int d2){
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);
//        System.out.println(path1);
//        System.out.println(path2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)){
            i--;
            j--;
        }
        // here we have first unequal element
        // so to find equal element we need to one back
        i++;
        j++;
        return path1.get(i);
    }


    //Distance between two Nodes(in terms of edges) in Generic Tree

    public static int distanceBetweenTwoNodes(Node node, int d1, int d2){
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);
        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        int ans = i + j; // it says that next element which is not equal is 'i' distance from the currebt node
        return ans;
    }
}

