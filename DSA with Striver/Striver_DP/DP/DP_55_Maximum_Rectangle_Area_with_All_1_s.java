package DP;

import java.util.Stack;

public class DP_55_Maximum_Rectangle_Area_with_All_1_s {


    // You have given an N*M matrix filled with 0's and 1's.
    // and you have to find the maximum rectangle area which is created by 1's.

    // Requisite for  this question is the Largest rectangle area in histogram. (next greater element)
    // because here we will make things like histogram for every row and find area and like that in last we can find our desired output.

    // We can do it via leftSmall array and rightSmall array to find histogram area.
    // but this is two pass solution but let us see that how we can do it in one pass.

    // To do in one pass we have to run loop for one more iteration to use the elements that's are remaining in the stack.

    // Largest rectangle area in Histogram. that have TC -> O(n) + O(n), and SC -> O(n).

    // So in order to solve this question we will use it and form histogram for every row with doing sum if 1 is coming.

    public static int largestRectangleAreaHistogram(int[] arr){

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for(int i = 0; i <= n; i++){

            while(!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])){
                int height = arr[st.pop()];
                int width;
                if(st.isEmpty()) width = i;
                else width = i - st.peek() - 1; // rs - ls - 1
                maxArea = Math.max(maxArea, width*height);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int solution(int[][] matrix){

        int largestRectangleArea = 0;

//        for(int[] a : matrix){
//            largestRectangleArea = Math.max(largestRectangleArea, largestRectangleAreaHistogram(a));
//        } // due to this we are only passing every row but, we have to create histogram but if we send only one row then height will not increase of histogram

        // so let us do it in a  right way


        // TC -> O(n*(n+m)). or O(n*m)
        // SC -> O(n).
        // why do we solve this in DP because here we are using previous remembering concept to increase histogram height.

        int n = matrix.length;
        int m = matrix[0].length;
        int[] histogram = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    histogram[j]++;
                }else {
                    histogram[j] = 0;
                }
            }
            largestRectangleArea = Math.max(largestRectangleArea, largestRectangleAreaHistogram(histogram));
        }

        return largestRectangleArea;
    }


    public static void main(String[] args) {
        int[][] matrix = {  {1,0,1,0,0},
                            {1,0,1,1,1},
                            {1,1,1,1,1},
                            {1,0,0,1,0} };

        System.out.println(solution(matrix));
    }
}
