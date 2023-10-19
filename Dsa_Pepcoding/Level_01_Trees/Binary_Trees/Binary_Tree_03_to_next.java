package Level_01_Trees.Binary_Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_03_to_next {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void construct(Integer[] arr, Node root){
        Pair rootPair = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rootPair);

        int ind = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                ind++;
                if(arr[ind] != null){
                    top.node.left = new Node(arr[ind], null, null);
                    Pair leftPair = new Pair(top.node.left, 1);
                    st.push(leftPair);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                ind++;
                if(arr[ind] != null){
                    top.node.right = new Node(arr[ind], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    st.push(rightPair);
                }else{
                    st.pop();
                }
                top.state++;
            }else{
                st.pop();
            }
        }
    }
    public static void main(String[] args) {
       // Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Integer[] arr = {50, 25, 12, null, null,37,30,null,null,40,null,null,75,62,70,null,null,77,null,null,87,null,null};// for false case to isBST.
        Node root = new Node(arr[0], null, null);
        construct(arr, root);
//        display(root);
//        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(max(root));
//        System.out.println(height(root));

//        traversalPre(root);
//        System.out.println();
//        traversalIn(root);
//        System.out.println();
//        traversalPost(root);

  //      levelOrderTraversal(root);
      //    iterativeTraversal(root);
//        System.out.println(find(root, 30));
//        System.out.println(path);

   //     printKLevelDown(root, 2);
     //   printKNodesFar(root, 75, 2);

    //    pathToLeafFromRoot(root, "", 0, 100, 200);


//        Node newRoot = crateLeftCloneTree(root);
//        display(newRoot);
//        Node normalRoot = transformBackFromLeftClonedTree(root);
//        display(normalRoot);

      //  printSingleChildNode(root, null);// because there is no any parent for the root that's why we pass the null value

       // display(removeLeaves(root));

       // System.out.println(diameter1(root));

//        DiaPair ans = diameter2(root);
//        System.out.println(ans.dia);

//        getTilt(root);
//        System.out.println("Tilt of the given binary tree is = " + tilt);

//        BSTPair ans = isBST(root);
//        System.out.println(ans.isBST);

        // Using travel and change method
        //isBalanced(root);
       // System.out.println(isBalance);

        // same question using Pairs method
      //  balPair ans = isBa(root);
       // System.out.println(ans.isBal);


        // Largest BST subtree

        BSTPair ans = isBST(root);
        System.out.println(ans.root.data + " @ " + ans.size);

    }
    public static void display(Node node){
        if(node == null){
            return;
        }
        // node self work
        String str = "";
        str += node.left == null? "." : node.left.data;
        str += " <- " + node.data + " -> ";
        str += node.right == null? "." : node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    // for the size of the tree means the no. of nodes in the tree

    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = leftSize + rightSize + 1; // 1 for the root node

        return totalSize;
    }

    // for finding the sum of all node in the tree

    public static int sum(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int totalSum = leftSum + rightSum + node.data;

        return totalSum;
    }

    // Find the maximum element in the tree

    public static int max(Node node){
        if(node == null){
            // we are returning here identity things
            return Integer.MIN_VALUE;
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        int mainMax = Math.max(leftMax, Math.max(rightMax, node.data));
        return mainMax;
    }

    // for the Height(in the terms of the edges) of the tree -> Depth of the deepest node

    public static int height(Node node){
        if(node == null){
            return -1;
            // if we want height in terms of edges then return -1 and if in the terms of nodes then return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int totalHeight = Math.max(leftHeight, rightHeight) + 1;// 1 for the node

        return totalHeight;
    }

    // Traversal in Binary Tree -> PreOrder, InOrder, PostOrder
    // Preorder -> Left in Euler and Before going deep in to recursion on left side
    //          -> NLR : node,left,right and root is first
    // Inorder -> Euler between left and right of node
    //          -> LNR : left, node, right and root after first left
    // Postorder -> In Euler right of the node
    //          -> LRN : left , right, node and root is in last

    public static void traversalPre(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");// preOrder
        traversalPre(node.left);
        traversalPre(node.right);
    }
    public static void traversalIn(Node node){
        if(node == null){
            return;
        }

        traversalIn(node.left);
        System.out.print(node.data + " ");// InOrder
        traversalIn(node.right);
    }
    public static void traversalPost(Node node){
        if(node == null){
            return;
        }
        traversalPost(node.left);
        traversalPost(node.right);
        System.out.print(node.data + " ");// postOrder
    }

    // Level Order Traversal -> space separated level by level.
    // Remove , Print , add

    public static void levelOrderTraversal(Node node){
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);
        while (mainQ.size() > 0){
            int count = mainQ.size();
            for(int i = 0; i < count; i++){
                node = mainQ.remove();
                System.out.print(node.data + " ");
                if(node.left != null){
                    mainQ.add(node.left);
                }
                if(node.right != null){
                    mainQ.add(node.right);
                }
            }
            System.out.println();
        }
    }


    // Iterative Preorder, Postorder, Inorder traversal.

    // for this we are going to use pair class with space concept
    // state 1 means in Preorder state++ and go in left, if 2 then in Inorder and state++, go in right,
    // if 3 means in Postorder and pop.

    public static void iterativeTraversal(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));
        String pre = "", post = "", in = "";
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){// pre, s++, left
                pre += top.node.data + " ";
                top.state++;
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 1));
                }
            }else if(top.state == 2){// in, s++, right
                in += top.node.data + " ";
                top.state++;
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 1));
                }
            }else{ // post, pop
                post += top.node.data + " ";
                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }


    // Find a Node and Node to Root path

  //  static ArrayList<Integer> path = new ArrayList<>();
    static ArrayList<Node> path = new ArrayList<>();
    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            path.add(node);
            return true;
        }
        boolean findInLeftChild = find(node.left, data);
        if(findInLeftChild){
            path.add(node);
            return true;
        }
        boolean findInRightChild = find(node.right, data);
        if(findInRightChild){
            path.add(node);
            return true;
        }

        return false;
    }


    // Print k levels down in preOrder

    public static void printKLevelDown(Node node, int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        printKLevelDown(node.left, k-1);
        printKLevelDown(node.right, k-1);
    }
    public static void printKLevelDownWithBlocker(Node node, int k, Node blocker){
        if(node == null || k < 0 || node == blocker){
            return;
        }
        if(k == 0){
            System.out.print(node.data + " ");
        }
        printKLevelDown(node.left, k-1);
        printKLevelDown(node.right, k-1);
    }


    // Print Nodes K Level far or k distance away

    public static void printKNodesFar(Node node, int data, int k){
        find(node, data);
        for(int i = 0; i < path.size(); i++){
            printKLevelDownWithBlocker(path.get(i), k - i, i ==0 ?null : path.get(i-1));
        }
    }


    // Path to Leaf from Root in Range
                                                  // till path     till sum
    public static void pathToLeafFromRoot(Node node, String path, int sum, int low, int high){
        if (node == null) {
            return; // in case of single child
        }
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= low && sum <= high){
                System.out.println(path + node.data +"");
            }
            return;
        }
        pathToLeafFromRoot(node.left, path+node.data+" ", sum + node.data, low, high);
        pathToLeafFromRoot(node.right, path+node.data+" ", sum + node.data, low, high);
    }


    // Transform to Left Cloned Tree
    // means har ek node ki copy uske v uske left ke bich me aa gayi

    public static Node crateLeftCloneTree(Node node){
        if(node == null){
            return null;
        }
        Node leftCloneRoot = crateLeftCloneTree(node.left);
        Node rightCloneRoot = crateLeftCloneTree(node.right);
        // post order area
        Node newLeftNode = new Node(node.data, leftCloneRoot, null);
        node.left = newLeftNode;
        node.right = rightCloneRoot;//right added easily

        return node;
    }

    // Transform Back from a Left Cloned Tree
    // means remove all those things which was made in createLeftCloneTree means do in normal form

    public static Node transformBackFromLeftClonedTree(Node node){
        if(node == null){
            return null;
        }

        Node leftNormalizedNode = transformBackFromLeftClonedTree(node.left.left);//left me to a hai but uske left me b h
        Node rightNormalizedNode = transformBackFromLeftClonedTree(node.right);

        node.left = leftNormalizedNode;
        node.right = rightNormalizedNode;// this is already assigned but we can repeat
        return node;
    }


    // Print single child Nodes
    // means whichever node have only one child we need to print that child

    public static void printSingleChildNode(Node node, Node parent){
        // means node and parent of that node is required
        if(node == null){
            return;
        }

        if(parent != null && parent.left == node && parent.right == null){
            System.out.println(node.data);
        }else if(parent != null && parent.right == node && parent.left == null){
            System.out.println(node.data);
        }

        printSingleChildNode(node.left, node);
        printSingleChildNode(node.right, node);// because of node's left child's parent is node itself na.
    }

    // Remove Leaves nodes from the Binary Tree

    public static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return null;
        }
       Node newLeftRoot = removeLeaves(node.left);
       Node newRightRoot = removeLeaves(node.right);

       node.left = newLeftRoot;
       node.right = newRightRoot;

       return node;
    }


    // Diameter of a Binary Tree....
    // means no. of edges between two farthest node of the tree is called diameter of the tree.

    public static int diameter1(Node node){
        if(node == null){
            return 0;
        }
        int ld = diameter1(node.left);// maximum distance between two nodes of  left hand side
        int rd = diameter1(node.right); // maximum distance between two nodes of  right hand side

        // maximum distance between left's deepest and right deepest
        int factor = height(node.left) + height(node.right) + 2; // including root

        int dia = Math.max(factor, Math.max(ld, rd));
        // inefficient code because height is going to call again and again means same Euler is repeating
        // complexity -> O(n^2).
        return dia;
    }

    // another approach with O(n) complexity

    public static class DiaPair{
        int ht;
        int dia;
    }
    // In this instead of height calls in Post area we return two value it means there is no any requirement of another euler
    // so in postArea we are just doing O(1) work that's why this code is in O(n).
    public static DiaPair diameter2(Node node){
        if(node == null){
            DiaPair basePair = new DiaPair();
            basePair.ht = -1;
            basePair.dia = 0;
            return basePair;
        }
        DiaPair leftPair = diameter2(node.left);
        DiaPair rightPair = diameter2(node.right);

        DiaPair myPair = new DiaPair();
        myPair.ht = Math.max(leftPair.ht, rightPair.ht) + 1;
        myPair.dia = Math.max(leftPair.ht + rightPair.ht + 2, Math.max(leftPair.dia, rightPair.dia));

        return myPair;
    }


    // Tilt of a Binary Tree -> means If we want to find tilt of a binary tree then we need to find the abs difference of sum of left child - right child
    // all tree tilt = sum of all node's tilt value
    // return sum and change in tilt
    // why returning sum because for calculating root node (for ex.) tilt we need of left sum and right rather than their tilt

    // Means change and return strategy or change and traverse strategy



    static int tilt = 0;
    public static int getTilt(Node node){
        if(node == null){
            return 0;
        }

        // will return left's sum and change tilt for left side
        int ls = getTilt(node.left);
        // will return right's sum and change tilt for right side
        int rs = getTilt(node.right);

        int localTilt = Math.abs(ls - rs);
        tilt += localTilt;
        int ts = ls + rs + node.data;
        return ts;
    }


    // Is a tree Binary Search Tree ->
    // BST -> for all node's have left child <= right child including root node.


//    public static class BSTPair{
//        boolean isBST;
//        int min;
//        int max;
//    }
//    public static BSTPair isBST(Node node){
//        if(node == null){
//            BSTPair bp = new BSTPair();
//            bp.isBST = true;
//            bp.min = Integer.MAX_VALUE;
//            bp.max = Integer.MIN_VALUE;
//            return bp;
//        }
//
//        BSTPair lp = isBST(node.left);
//        BSTPair rp = isBST(node.right);
//
//        BSTPair mp = new BSTPair();
//        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
//        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
//        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
//
//        return mp;
//    }


    // Balanced Binary Tree --> Properties:
     //                            --> for all the nodes |left subtree height - right subtree height| <= 1.
    // We can solve it using pairs method and as well as Travel and change method

    public static boolean isBalance = true;

    public static int isBalanced(Node node){
        if(node == null){
            return 0;// because height is in terms of nodes if it is in terms of edges then we return -1.
        }
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);
        int gap = Math.abs(lh - rh);
        if(gap > 1){
            isBalance = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static class balPair{
        int ht;
        boolean isBal;
    }

    public static balPair isBa(Node node){

        if(node == null){
            balPair bp = new balPair();
            bp.ht = 0;
            bp.isBal = true;
            return bp;
        }

        balPair lp = isBa(node.left);
        balPair rp = isBa(node.right);

        balPair mp = new balPair();
        //              mai thik hu              mera left thik hai  and mera right thik hai
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        return mp;
    }


    // Largest BST subtree

    public static class BSTPair{
        boolean isBST;
        int min;
        int max;
        Node root; // biggest bst root
        int size; // biggest bst size -> no. of nodes in a subtree
    }
    public static BSTPair isBST(Node node){
        if(node == null){
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));


        if(mp.isBST){// means app hi root bn jate hai aur apka hi size biggest bst ka size hoga
            mp.root = node;
            mp.size = lp.size + rp.size + 1;
        }else if(lp.size > rp.size){
            mp.root = lp.root;
            mp.size = lp.size;
        }else {
            mp.root = rp.root;
            mp.size = rp.size;
        }
        return mp;
    }
}
