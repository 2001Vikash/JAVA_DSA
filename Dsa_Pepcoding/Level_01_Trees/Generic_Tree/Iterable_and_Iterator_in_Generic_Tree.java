package Level_01_Trees.Generic_Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

public class Iterable_and_Iterator_in_Generic_Tree  {


   // to make it iterable we need to implement it
    // In this we will try to write some code which provides a feature where we can apply directly for each loop on that tree
    // and we will be able to print in preOrder, postOrder, min, max and ,many more things...

    public static class GenericTree implements Iterable<Integer>{
        // There is no more work of this it is only for looking semantic correct
        // for(int val : gt) if we do not make it then we can use root because this is also behave as a tree
        // root achha nhi lagega ki root pr loop lga rha hu jab tree leekhenge tb achha lagega ki tree pr loop lga rhe hai
        Node root;
        GenericTree(Node root){
            this.root = root;
        }

        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator<Integer> spliterator() {
            return Iterable.super.spliterator();
        }
    }
    public static class GTPreorderIterator implements Iterator<Integer> {
        Integer nextVal;
        Stack<Pair> st;
        public GTPreorderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root , -1));
            next();// for the set on first value
        }
        @Override
        public boolean hasNext() {
           // return false;//next value is present or not
            if(nextVal == null){
                return false;
            }else{
                return true;
            }
        }

        @Override
        public Integer next() {// return the current value and ready for the next value for the class
          //  return null;
            Integer forReturn = nextVal;
            // moved nextVal forward, if not possible set it to null
            nextVal = null;
            while(st.size() > 0) {
                Pair top = st.peek();
                if (top.state == -1) {
                  nextVal = top.node.data;
                  top.state++;
                  break;
                }else if(top.state >= 0 && top.state < top.node.children.size()){
                    Pair childPair = new Pair(top.node.children.get(top.state), -1);
                    st.push(childPair);
                    top.state++;
                }else{
                    st.pop();
                }
            }
            return forReturn;
        }

//        @Override
//        public void remove() {
//            Iterator.super.remove();
//        }
//
//        @Override
//        public void forEachRemaining(Consumer<? super Integer> action) {
//            Iterator.super.forEachRemaining(action);
//        }
    }

     private static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
     }
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

    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = constructTree(arr);
        // for the whole generic tree
        GenericTree gt = new GenericTree(root);

        // What are Interfaces?
        // Interfaces are contract of functions which have to implemented by classes which say that the implement the function
        // In this function signature hota  and there is no any function body in this
        // In java already an Interface working that is Iterable for applying the loop on those classes who want for gt.
        // in Iterable there is one function which name is Iterator and as well as it return an object named as Iterator

        // GenericTree implements Iterable<Integer> because he wants to implement loop on self

        for(int val : gt){ // syntactical sugar dependent on Iterable
            System.out.print(val + " ");
        }
        // These three lines convert like this in while loop means with same behaviour
        // converts in to like in this code
//        Iterator<Integer> gti = gt.iterator();
//        while (gti.hasNext()){  // above code and this code both are same
//            System.out.println(gti.next());
//        }

        // Difference between int i and Integer i =>
           // int i have not any default value but Integer i have a default value that is null
        // if we write int i = 10 then it will place in the stack same as but if we
        // write the Integer i = 10 then in the stack there is an address and on that address in the heap memory 10 will present

    }
}
