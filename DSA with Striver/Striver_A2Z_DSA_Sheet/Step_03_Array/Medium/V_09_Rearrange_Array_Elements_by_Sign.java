package Step_03_Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class V_09_Rearrange_Array_Elements_by_Sign {

    // Problem states that you are given an array with even length and, half of the array's elements are +ve and, half of the array's elements are -ve.
    // So, we have to Rearrange the given array in such way, at first position +ve then after -ve, then +Ve, then -ve and so on.

    public static void RearrangeArrayElements(){
        int[] arr = {3,1,-2,-5,2,-4};
        int n = arr.length;

        // Brute force -> So, in this we will take two array, +ve[n/2], -ve[n/2] and, put the elements accordingly then after, put one by one.
        // All the +ve elements will be at even index, and -ve elements will be at odd index.
        // TC -> O(2n), SC -> O(n)

        // Optimal solution -> In this can we remove extra space -> No, then we will do it in pass instead of doing in 2-pass.
        // In this solution we will apply same concept as previous, like put +ve at even and -ve at odd index.
        // It will be having slightly good complexity than Brute force.

        int[] ans = new int[n];
        int posInd = 0, negInd = 1;
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                ans[posInd] = arr[i];
                posInd += 2;
            }else {
                ans[negInd] = arr[i];
                negInd += 2;
            }
        }
        System.out.println("Rearranges Array is : " + Arrays.toString(ans));
    }


    // There is one variety of this problem, In this it is not mentioned that, +ve and -ve elements are coming equally.
    // And at the end if any numbers are remaining then put them into the last without altering the order.

    public static void RearrangeArrayElements_II(){
        int[] arr = {1,2,-4,-5,3,6};
        int n = arr.length;

        // So as of now, we know that +ve != -ve it means, there can be possibility of +ve > -ve or -ve > +ve.
        // So, we can not apply optimal solution for this, means we have to go for Brute force as Optimal solution.
        // TC -> O(2n), SC -> O(n).

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){
                neg.add(arr[i]);
            }else{
                pos.add(arr[i]);
            }
        }

        if(pos.size() > neg.size()){
            for(int i = 0; i < neg.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int ind = neg.size() * 2;
            for(int i = neg.size(); i < pos.size(); i++){
                arr[ind++] = pos.get(i);
            }
        }else{
            for(int i = 0; i < pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int ind = pos.size() * 2;
            for(int i = pos.size(); i < neg.size(); i++){
                arr[ind++] = neg.get(i);
            }
        }


        System.out.println("Rearranged Array is : " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
      //  RearrangeArrayElements();
        RearrangeArrayElements_II();
    }
}
