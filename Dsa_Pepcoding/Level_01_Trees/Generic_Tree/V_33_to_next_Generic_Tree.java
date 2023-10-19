package Level_01_Trees.Generic_Tree;
import java.util.*;
public class V_33_to_next_Generic_Tree {
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
            }else {
                Node t = new Node();
                t.data = arr2[i];

                if (st2.size() > 0) {
                    st2.peek().children.add(t);
                } else {
                    root2 = t;
                }
                st2.push(t);

            }
        }

      //  System.out.println(areSimilarInShape(root1, root2));

      //  System.out.println(areMirror(root1, root2));

//        System.out.println(isSymmetric(root1));
//        System.out.println(isSymmetric(root2));

    }


    // Are trees similar in shape (Generic Tree)
    // There is no consideration of the value of the node
    // we need to check that every node have same no of children or not for ex root node and their children

    public static boolean areSimilarInShape(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i = 0; i < n1.children.size(); i++){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if(!areSimilarInShape(c1, c2)){ // or areSimilarInShape(c1 , c2) == false
                return false;
            }
        }
        return true;
    }


    // Are Trees mirror in Shape or not

    public static boolean areMirror(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i = 0; i < n1.children.size(); i++){
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if(!areMirror(c1, c2)){
                return false;
            }
        }
        return true;
    }


    // Is Generic Tree Symmetric or Not

    // for our face is symmetric like that we need to identify symmetry
    // there is a special thing in symmetric tree these are self mirror images

    public static boolean isSymmetric(Node node){
        return areMirror(node, node);
    }





}
