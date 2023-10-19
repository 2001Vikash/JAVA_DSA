package Level_01_Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Construct_to_next_all_level_01_BST {

    // if we have a sorted array to make BST then we can use low, high, mid like Binary search
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
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? ".": node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static int size(Node node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }
    public static int sum(Node node){
       if(node == null){
           return 0;
       }
       int ls = sum(node.left);
       int rs = sum(node.right);
       int ts = ls + rs + node.data;
       return ts;
    }
    public static int min(Node node){
        if(node.left != null){
            return min(node.left);
        }else{
            return node.data;
        }
    }
    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    // Another code for finding max

//    public static int Max(Node node){
//        if(node == null){
//            return Integer.MIN_VALUE;
//        }
//        int r = Max(node.right);
//        int ans = Math.max(node.data, r);
//        return ans;
//    }
    public static boolean find(Node node, int target){
        // log(n) time complexity for this code because it's only run exactly same height of the tree
        // because every time it divided tree in to part and go for right part
         if(node == null){
             return false;
         }
         if(target > node.data){
             return find(node.right, target);
         }else if(target < node.data){
             return find(node.left, target);
         }else{
             return true;
         }
    }
    public static Node construct(int[] arr, int low, int high){// at low small element lie and at high big element lie
        if(low > high){ // means till low <= high
            return null;
        }
        int mid = (low + high) / 2;

        int data = arr[mid];
        Node leftChild = construct(arr, low, mid - 1);
        Node rightChild = construct(arr, mid + 1, high);

        Node node = new Node(data, leftChild, rightChild);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {12 ,25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
      //  display(root);
//        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(min(root));
//        System.out.println(max(root));
//        System.out.println(find(root, 11));
       // System.out.println(Max(root));

//        display(root);
//        addNewNode(root, 60);
//        System.out.println();
//        display(root);
//
//        remove(root, 50);
//        System.out.println();
//        display(root);

//        replaceWithSumOfLarger(root);
//        display(root);

       // System.out.println(LCA(root, 12, 87));

       // printInRange(root, 27, 72);

      //  targetSum(root,root,100);

       // targetSum2(root, 100);

        // targetSum 3
        bestApproach(root, 100);
    }

    // Question -> Add node to a BST

    public static Node addNewNode(Node node, int data){
        if(node == null){
          return new Node(data,null,null);
        }
        if(data > node.data){
            node.right =  addNewNode(node.right , data);
        }else if(data < node.data){
            node.left = addNewNode(node.left, data);
        }else{
            // Nothing to do if data is equal.
        }
        return node;
    }


    // Question -> Remove a Node from the BST

    // To do this question we need to focus on three cases only
    // 1 -> if node has o child means leaf node --> remove it without doing any changes on put it null at the place of node
    // 2 -> if node has one child left or right --> child of that node is added with the parent of that node
    // 3 -> if node has 2 child like root node --> so in this we need to remove that node from the left side max node to make tree BST as well
                                                   // at the time of delete left side max it always a leaf node means there is no any problem

    public static Node remove(Node node, int data){
        if(node == null){
            return null;
        }
        if(data > node.data){
            node.right = remove(node.right, data);
        }else if(data < node.data){
            node.left = remove(node.left, data);
        }else{
            // work
            if(node.left != null && node.right != null){
                // means two child
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);
                return node;
            }else if(node.left != null){
                // one child -> left
                return node.left;
            }else if(node.right != null){
                // one child -> right
                return node.right;
            }else{
                // no child that is  leaf node so return only null that will be attached with respective side
                return null;
            }
        }
        return node; // apart from the special case
    }


    // Question -> Replace with sum of larger
    // Property of BST -> if we traverse BST inOrder then we will find a sorted array.
    // so in this question we need to apply inOrder in reverse order.

    public static int sum = 0;
    public static void replaceWithSumOfLarger(Node node){
        if(node == null){
            return;
        }
        // inOrder in Reverse means
        // inOrder -> L N R but in Reverse -> R N L where L-left, R-right, N-node.

        replaceWithSumOfLarger(node.right);

        int originalData = node.data;
        node.data = sum;
        sum += originalData;

        replaceWithSumOfLarger(node.left);
    }


    // LCA of a BST -> means the Lowest common Ancestor of BST.
    // so we will have given two values and find out the LCA. here we will use node to root path concept
    // but here we will not use node to path concept exactly here we will use BST where will path go for different way that is our LCA.

    public static int LCA(Node node, int d1, int d2){
        if(node == null){
            System.out.println("These elements are not in this tree");
            return -1;
        }
        if(d1 < node.data && d2 < node.data){
            return LCA(node.left, d1, d2);
        }else if(d1 > node.data && d2 > node.data){
            return LCA(node.right, d1, d2);
        }else{
            // path diversion
            return node.data;
        }
    }


    // Print in Range (BST) in increasing order means inOrder

    public static void printInRange(Node node, int d1, int d2){
        if(node == null){
            return;
        }
        if(d1 > node.data && d2 > node.data){
            printInRange(node.right, d1, d2);
        }else if(d1 < node.data && d2 < node.data){
            printInRange(node.left, d1, d2);
        }else{
            printInRange(node.left, d1, d2);
            System.out.print(node.data + " ");
            printInRange(node.right, d1, d2);
        }
    }


    // Target sum Pair in BST
     // Time complexity -> O(n*log n) where log n for the find and space complexity log n or height
    public static void targetSum(Node root, Node node, int target){
        if(node == null){
            return;
        }
        targetSum(root, node.left, target);

        int remaining = target - node.data;
        if(node.data  < remaining){
            if(find(root, remaining)){
                System.out.println(node.data + " " + remaining);
            }
        }

        targetSum(root, node.right, target);
    }

    // Another approach for the targetSum question
    // using arrayList

    // Time complexity O(n) and Space complexity O(n)
    public static void travelAndFill(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        travelAndFill(node.left, list);
        list.add(node.data);
        travelAndFill(node.right, list);
    }
    public static void targetSum2(Node root, int target){
        ArrayList<Integer> list = new ArrayList<>();
        travelAndFill(root, list);
        int s = 0;
        int e = list.size() - 1;
        while(s < e){
            int sum = list.get(s) + list.get(e);
            if(sum > target){
                e--;
            }else if(sum < target){
                s++;
            }else{
                System.out.println(list.get(s) + " " + list.get(e));
                s++;
                e--;
            }
        }
    }

    // Now we are going to try to solve with TC -> O(n) and SC -> O(height or log n) for the same question

    // This is Best approach

    // we are going to find Iterative InOrder and ReverseIterative InOrder
    // due to this space will not exceed from the height
    public static class ITPair{
        Node node;
        int state;
        ITPair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void bestApproach(Node root, int tar){
        Stack<ITPair> leftStack = new Stack<>();
        Stack<ITPair> rightStack = new Stack<>();
        leftStack.push(new ITPair(root, 0));
        rightStack.push(new ITPair(root, 0));

        Node left = getNextFromNormalInorder(leftStack);
        Node right = getNextFromReverseInorder(rightStack);
        while(left.data < right.data){
            if(left.data + right.data < tar){
                left = getNextFromNormalInorder(leftStack);
            }else if(left.data + right.data > tar){
                right = getNextFromReverseInorder(rightStack);
            }else{
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(leftStack);
                right = getNextFromReverseInorder(rightStack);
            }
        }
    }
    public static Node getNextFromNormalInorder(Stack<ITPair> st){
        while(st.size() > 0){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                // we want things in Inorder that's why we returned from here
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;// never going to execute but due syntax we need this
    }
    public static Node getNextFromReverseInorder(Stack<ITPair> st){
        while(st.size() > 0){
            ITPair top = st.peek();
            if(top.state == 0){
                if(top.node.right != null){
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(top.node.left != null){
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            }else{
                st.pop();
            }
        }
        return null;
    }
}
