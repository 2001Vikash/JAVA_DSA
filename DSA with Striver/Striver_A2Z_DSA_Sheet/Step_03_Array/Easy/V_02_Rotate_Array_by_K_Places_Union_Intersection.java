package Step_03_Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class V_02_Rotate_Array_by_K_Places_Union_Intersection {

    // Question 1: Left rotate the array by one place. for ex, 1 2 3 4 5 => 2 3 4 5 1 will be our answer.
    // It is a easy problem so, we are going to implement optimal solution directly.
    // TC -> O(n), Extra SC -> O(1), but in algo we are using O(n) space for the array
    public static void leftRotationByOnePlace(){
        int[] arr = {1,2,3,4,5};
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }

    // Question 2: Left rotate the array by D places.

    public static void leftRotationByDPlace(){
        int[] arr = {1,2,3,4,5,6,7};

        // brute force O(n*k)
        /* if(k % n == 0)return;

         k = k % n;
         for(int i = 0; i < k; i++){

             long temp = arr[0];
             for(int j = 1; j < n; j++){
                 arr[j-1] = arr[j];
             }

             arr[n-1] = temp;
         } */

        // Or brute force can be

        // O(2d) + o(1).
        /*
        int d = 2;
        int n = arr.length;
        d = d % n;

        int[] temp = new int[d];
        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }

        // shifting
        for(int i = d; i < n; i++){
            arr[i-d] = arr[i];
        }
        // copying
        for(int i = 0; i < d; i++){
            arr[i+d] = temp[i];
        }

        System.out.println(Arrays.toString(arr));*/

        // Optimal solution, TC -> o(n), sc -> o(1).

        // So, do it we will use reverse method that comes from observation.

        int n = arr.length;
        int d = 3;
        d = d % n;

        reverseArray(0, d-1, arr);//O(d-1)
        reverseArray(d, n-1, arr);// O(n-1-d)
        reverseArray(0, n-1, arr);//O(n-1)

        System.out.println(Arrays.toString(arr));
    }
    private static void reverseArray(int start, int end, int[] arr){

        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Question 3: Move all zeros to the end of the array.

    public static void moveZerosToLast(){

        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        int n = arr.length;
       // brute force : TC -> O(n) + O(n), SC -> o(x) where x is non-zero elements in array.
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] != 0)list.add(arr[i]);
        }
        for(int i = 0; i < n; i++){
            if(i < list.size()){
                arr[i] = list.get(i);
            }else{
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));*/


        // Optimal Solution
        // Here we are going to use 2-pointer approach => TC -> O(n), SC : O(1)

        int j = -1;
        // find the first 0th guy
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1)return;
        int i = j+1;
        while( i < n){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }

        System.out.println(Arrays.toString(arr));
    }

    // Question 4: Linear search => In this problem we have to identify the first occurrence of a given number.

    public static void firstOccurrence(){
        int[] arr = {6,7,8,4,1};
        int tar = 4;
        int ind = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == tar){
                ind = i;
                break;
            }
        }
        System.out.println("First occurrence of the given number is = " + ind);
    }

    // Question 5: find the union of two sorted array.

    public static void unionOfTwoSortedArray() {
        int[] a1 = {1, 1, 2, 3, 4, 5};
        int[] a2 = {2, 3, 4, 4, 5, 6};

        // Brute force can using Set data structure. TC -> o(m log m) + O(n log n) + O(n+m), O(m+n) if all are unique

        // Optimal approach using two pointer method => TC -> O(n + m), O(n+m) not for algo, to return ans, if all elements are unique.

        int i = 0, j = 0;
        int n = a1.length, m = a2.length;
        ArrayList<Integer> unionList = new ArrayList<>();
        while (i < n && j < m) {
          /*  if(a1[i] < a2[j]){
                unionList.add(a1[i]);
                i++;
                while ( i < n && a1[i] == a1[i-1])i++;
            }else if(a1[i] > a2[j]){
                unionList.add(a2[j]);
                j++;
                while (j < m && a2[j] == a2[j-1])j++;
            }else {
                unionList.add(a2[j]);
                j++;
                i++;
                while ( i < n && a1[i] == a1[i-1])i++;
                while (j < m && a2[j] == a2[j-1])j++;
            } */

            // OR we can do it in more understandable way.

            if (a1[i] <= a2[j]) {
                if (unionList.size() == 0 || a1[i] != unionList.get(unionList.size() - 1)) {
                    unionList.add(a1[i]);
                }
                i++;
            } else {
                if (unionList.size() == 0 || a2[j] != unionList.get(unionList.size() - 1)) {
                    unionList.add(a2[j]);
                }
                j++;
            }
        }

        while (i < n){
            if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != a1[i])
                    unionList.add(a1[i]);
            i++;
        }

        while (j < m){
            if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != a2[j])
                unionList.add(a2[j]);
            j++;
        }

        System.out.println(unionList);
    }

    // Question 6 : find the Intersection of two sorted array.

    public static void intersectionOfTwoSortedArray(){
        int[] a = {1,2,2,3,3,4,5,6};
        int[] b = {2,3,3,5,6,6,7};
        int n = a.length;
        int m = b.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Brute force
/*
        int[] vis = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i] == b[j] && vis[j] == 0){
                    ans.add(a[i]);
                    vis[j] = 1;
                    break;
                }
                if(b[j] > a[i])break;
            }
        }

        // TC -> O(n * m), SC -> o(m), we can take any array for the iteration or to check as visited
        System.out.println(ans);  // we can do it with less time with the help of using set data structure */

        // Optimal solution
        // We will do it using two pointer approach

        int i = 0, j = 0;

        while(i < n && j < m){
            if(a[i] == b[j]){
                ans.add(a[i]);
                i++;
                j++;
            }else{
                if(a[i] < b[j])i++;
                else j++;
            }
        }
        System.out.println(ans); // TC -> O(n+m), O(1) + o(x) where x is number of common elements
    }


    public static void main(String[] args) {
     //   leftRotationByOnePlace();

     //   leftRotationByDPlace();

       // moveZerosToLast();

     //   firstOccurrence();

     //   unionOfTwoSortedArray();

        intersectionOfTwoSortedArray();
    }
}
