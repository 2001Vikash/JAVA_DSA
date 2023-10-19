package Stacks_and_Queues_Theory.Stacks;

public class DynamicCustomStack extends CustomStack{ // since we make a lot of things in CustomStack that means we just need to extend it rather than writing code again and again


    public DynamicCustomStack(){
        super();// It will call CustomStack().
    }

    public DynamicCustomStack(int size){// it will call parent constructor which takes an argument that is size
        super(size);
    }

    // So in Dynamic stack only problem occur in Push method
    // if we don't want to use push method from the parent class then we need to override
    @Override
    public boolean push(int item){
        // This takes care of it being full
        if(this.isFull()){
            // double the array size
            int[] temp = new int[data.length * 2];
            // copy all previous items in new data

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        // at this point we know that array is Not Full
        // hence we can insert item

        return super.push(item);
    }
}
