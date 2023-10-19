package Stacks_and_Queues_Theory.Stacks;

public class StackMain {
    public static void main(String[] args) throws StackException {
//        CustomStack stack = new CustomStack(5);
//        stack.push(34);
//        stack.push(45);
//        stack.push(2);
//        stack.push(9);
//        stack.push(18);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
     //   System.out.println(stack.pop()); // here it throws an exception


        DynamicCustomStack stack = new DynamicCustomStack(5);
            stack.push(34);
            stack.push(45);
            stack.push(2);
            stack.push(9);
            stack.push(18);
            stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
