package Step_03_Array.Hard;

public class V_27_Reverse_Pairs_Hard_Interview_Question {

    // Problem states that you are given an array of integers and, we have to find the number of pairs which follows this rule :
    // i < j && a[i] > 2 * a[j]. which is slightly different from the count inversion problem.


    public static void reversePairs(){
        int[] arr = {40,25,19,12,9,6,2};
        int n = arr.length;

        // Brute force solution -> In this we will generate all the pairs
        // TC -> O(n^2) near about, SC -> O(1).

      /*  int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > 2 * arr[j])cnt++;
            }
        }
        System.out.println(cnt);*/


        // Optimal Solution -> previous approach was taking O(n^2) time complexity, so we have to optimize it means, we can go for either n log n or n possibly.
        // please watch the video again at the time of revision.
        // So, as we previously did in count inversion problem like if we have two sorted array and if one element of the left array is satisfying
        // given condition it means that all elements will also follow the conditions, but we can not do same thing over here because if we do then we can miss a lots of answer.
        // so, now to solve this problem we will check everything which are giving an answer. we will use merge sort to find two sorted array.
        // TC -> O(2*n log n) => (log n * (n + n)), here n is for merging, and another n is for finding answers.
        // SC -> O(n), for the merging in worst case as well we are changing the main array to provide that array in sorted order.

        int ans = mergeSort(0, n-1, arr);
        System.out.println("Answer is = " + ans);
    }

    public static void merge(int low, int mid, int high, int[] arr){
        int left = low, right = mid+1;
        int[] temp = new int[high - low + 1];
        int k = 0;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[k] = arr[left];
                left++;
            }else{
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        while(left <= mid)temp[k++] = arr[left++];
        while(right <= high)temp[k++] = arr[right++];

        for(int i = 0; i < temp.length; i++){
            arr[i + low] = temp[i];
        }
    }

    public static int countPairs(int low, int mid, int high, int[] arr){
        int cnt = 0;
        int right = mid + 1;
        for(int i = low; i <= mid; i++){
            while(right <= high && arr[i] > 2 * arr[right])right++;
            cnt += (right - (mid+1));
        }

        return cnt;
    }
    public static int mergeSort(int low, int high, int[] arr){
        int cnt = 0;
        if(low >= high)return cnt;

        int mid = (low + high) / 2;
        cnt += mergeSort(low, mid, arr);
        cnt += mergeSort(mid + 1, high, arr);
        cnt += countPairs(low, mid, high, arr);
        merge(low, mid, high, arr);
        return cnt;
    }

    public static void main(String[] args) {
        reversePairs();
    }
}
