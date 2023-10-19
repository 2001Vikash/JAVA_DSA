package Step_03_Array.Hard;
import java.util.*;
public class V_21_Problem_4_Sum {

    // Prerequisite is that we must have to watch 3-Sum before.

    // problem states that we have to find the 4 indexes, and if we will do sum of those index's elements = target(0). and all indexes must be unique.
    // As well, we have to take care about unique Quads.

    public static void fourSum(){
       int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5};//{1,0,-1,0,-2,2};
       int target = 8;
       int n = arr.length;

       // Brute force -> generating all the quads and whichever is giving me the target value that will be our answer.
        // As we previously see that if we want to generate triplets then we will have requirement of three loops like this here we have to use 4 loops.

        // TC -> O(n^4), SC -> O(2 * no. of quads);

     /*   HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    for(int l = k+1; l < n; l++){
                        int sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if(sum == target){
                            ArrayList<Integer> li = new ArrayList<>();
                            li.add(arr[i]);li.add(arr[j]);li.add(arr[k]);li.add(arr[l]);
                            Collections.sort(li);
                            set.add(li);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        System.out.println(ans); */


        // Better Solution -> using Hashing we will decrease the time complexity from n^4 to n^3. We will put the value in set everything in-between j and k.
        // why not outside from j and k for this do dry run on this ex. {1,2,-1,-2,2,0,-1}. target = 0.
        // tC -> O(n^3 * log m), log m for the set. SC -> O(n) + O(2* no. of quads).

      /*  HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                HashSet<Integer> st = new HashSet<>();
                for(int k = j+1; k < n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    int fourth = target - sum;
                    if(st.contains(fourth)){
                        ArrayList<Integer> li = new ArrayList<>();
                        li.add(arr[i]);li.add(arr[j]);li.add(arr[k]);li.add(fourth);
                        Collections.sort(li);
                        set.add(li);
                    }
                    st.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        System.out.println(ans); */


        // Optimal solution -> So, we will optimize same as 3-sum, means we will be using two pointer approach for the two indexes.
        // sort the array to avoid the external set data structure that is using for the avoiding duplicate quads and as well to get answer in sorted order.
        // TC -> O(n^2 * n), SC -> we are not using any extra space to solve the problem, we are just using space for returning the answer.

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && arr[i] == arr[i-1])continue;
            for(int j = i+1; j < n; j++){
                if(j != i+1 && arr[j] == arr[j-1])continue; // to avoid duplicate elements.

                int k = j+1, l = n-1;
                while(k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }else{
                        ArrayList<Integer> li = new ArrayList<>();
                        li.add(arr[i]);li.add(arr[j]);li.add(arr[k]);li.add(arr[l]);
                        ans.add(li);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1])k++;
                        while(k < l && arr[l] == arr[l+1])l--;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        fourSum();
    }
}
