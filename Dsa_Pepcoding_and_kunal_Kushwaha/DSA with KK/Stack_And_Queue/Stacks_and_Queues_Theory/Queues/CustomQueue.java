package Stacks_and_Queues_Theory.Queues;

public class CustomQueue {
    // we can make it using two pointers but here we are going to solve it using one pointer that is tough.

    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length; // means end is at last index
    }

    private boolean isEmpty() {
        return end == 0; // means Queue is empty
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        int removed = data[0];
        // at the time of removal we need to shift item left onwards

        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+" <- ");
        }
        System.out.println("END");
    }
}
