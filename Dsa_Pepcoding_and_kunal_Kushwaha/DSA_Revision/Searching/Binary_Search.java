package DSA_Revision.Searching;

public class Binary_Search {
    public static void main(String[] args) {

        // First thing for binary search we need to understand that array must be in sorted order.

      int[] arr = {1,2,3,5,67};
       // System.out.println(BS(arr, 67));

        // using Recursion

        System.out.println(BSRec(arr, 0, arr.length-1, 6));
    }
    static int BS(int[] arr, int target){
        int s = 0;
        int e = arr.length-1;
        int ans = -1;
        while (s <= e){
            int mid = s + (e-s) / 2;
            if(arr[mid] == target){
                ans = mid;
                break;
            }
            if(target > arr[mid]){
                s = mid + 1;
            }else{
                e = mid - 1; // this is for less than cases
            }
        }
        return ans;
    }
    static int BSRec(int[] arr, int s, int e, int target){
        if(s > e){
            return -1;
        }
        int mid = s + (e-s) / 2;

        if(arr[mid] == target)return mid;

        if(target > arr[mid]){
            return BSRec(arr, mid+1, e, target);
        }else{
            return BSRec(arr, s, mid-1, target);
        }
    }
}
