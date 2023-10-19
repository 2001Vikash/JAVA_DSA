package Stacks_and_Queues_Theory.Stacks;

public class CustomStack {
    int ptr = -1;
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is Full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Can not pop from an empty Stack");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        // OR
        return data[ptr--];
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Can not peek from an empty Stack");
        }
        return data[ptr];
    }
    public boolean isFull() {
        return ptr == data.length-1; // means ptr is at last index
    }

    private boolean isEmpty() {
        return ptr == -1; // means stack is empty
    }
}
