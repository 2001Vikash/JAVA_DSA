package Stacks_and_Queues_Theory.Stacks;

import java.util.Stack;

public class inBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); // it is a class
                      // this is stack memory and new object in the Heap memory
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
