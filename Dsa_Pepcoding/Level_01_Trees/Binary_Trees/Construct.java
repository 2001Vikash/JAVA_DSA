package Level_01_Trees.Binary_Trees;

import java.util.Stack;

public class Construct {
//    public static class Node{
//        int data;
//        Node left;
//        Node right;
//
//        Node(int data, Node left, Node right){
//            this.data = data;
//            this.left = left;
//            this.right = right;
//        }
//    }
//    public static class Pair{
//        Node node;
//        int state; // 1 -> mean left child , 2 -> means right child, 3 means pop
//        Pair(Node node, int state){
//            this.node = node;
//            this.state = state;
//        }
//    }
//
//    public static void main(String[] args) {
//        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null}; // because off we need to put some null values in this.
//
//        Node root = new Node(arr[0], null,null);
//        Pair rootPair = new Pair(root, 1);
//
//        Stack<Pair> st = new Stack<>();
//        st.push(rootPair);
//        int idx = 0;
//        while(st.size() > 0){
//            Pair top = st.peek();
//            if(top.state == 1){
//                idx++;
//                if(arr[idx] != null){
//                    top.node.left = new Node(arr[idx], null, null);
//                    Pair leftPair = new Pair(top.node.left, 1);
//                    st.push(leftPair);
//                }else{
//                    top.node.left = null;
//                }
//                top.state++;
//            }else if(top.state == 2){
//                idx++;
//                if(arr[idx] != null){
//                    top.node.right = new Node(arr[idx], null,null);
//                    Pair rightPair = new Pair(top.node.right, 1);
//                    st.push(rightPair);
//                }else{
//                    top.node.right = null;
//                }
//                top.state++;
//
//            }else{
//                // means state = 3 which means pop
//                st.pop();
//            }
//        }
//    }


    // Revision that how to construct a Binary tree

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

    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair rootP = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rootP);
        int ind = 0;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                ind++;
                if(arr[ind] != null){
                    top.node.left = new Node(arr[ind], null, null);
                    Pair lp = new Pair(top.node.left , 1);
                    st.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                ind++;
                if(arr[ind] != null){
                    top.node.right = new Node(arr[ind], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }else {
                    top.node.right = null;
                }
                top.state++;
            }else{
                st.pop();
            }
        }


        display(root);
    }

    // here I am going to right a display code for it.

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data;
        str+= " <- " + node.data + " -> ";
        str+= node.right == null ? "." : node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}
