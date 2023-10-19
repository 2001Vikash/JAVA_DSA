package Stack_Queue_Interview_Questions;

import java.util.SplittableRandom;
import java.util.Stack;

public class Largest_Rectangle_In_Histogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        //System.out.println(largestRectangleArea(heights));
        System.out.println(lReArHi(heights));
    }

    public static int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.isEmpty()){
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()){
            area = heights[popped] * i;
        }else{
            area = heights[popped] * (i-1-stack.peek());
        }
        return Math.max(max, area);
    }


    // This Solution is given by Pep_coding

    public static int lReArHi(int[] bars){
        // lb -> left boundary, rb -> right boundary
        // and here we are putting index because we can find width with the help of subtraction
        int[] rb = new int[bars.length]; // next smaller element index on the right
        Stack<Integer> st = new Stack<>();
        st.push(bars.length - 1);
        rb[bars.length - 1] = bars.length;// if there is no any next smaller element on the right then assume it

        for(int i = bars.length - 2; i >= 0; i--){
            while(st.size() > 0 && bars[i] < bars[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
               rb[i] = bars.length;
            }else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

      int[] lb = new int[bars.length]; // next smaller element index on the left
        st = new Stack<>();
        st.push(0);
        lb[0] = -1;// if there is no any next smaller element on the left then assume it

        for(int i = 1; i < bars.length; i++) {
            while (st.size() > 0 && bars[i] < bars[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }


        int maxArea = 0;
        for(int i = 0; i < bars.length; i++){
            int width = rb[i] - lb[i] - 1;
            int area = bars[i] * width;
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
