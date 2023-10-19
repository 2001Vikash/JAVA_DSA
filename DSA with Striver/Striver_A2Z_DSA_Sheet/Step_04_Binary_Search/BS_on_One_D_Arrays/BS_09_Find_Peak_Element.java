package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_09_Find_Peak_Element {

    // Here, in this problem we have to find the peak element in the given array, means arr[i-1] < arr[i] > arr[i+1], then we will say that arr[i] is a peak element.
  // Array can have multiple peaks, and we can return any one of them. If we will not be found any peak then return last element of the array, because
    // we are assuming, -infinitive in both ending side of the array, means first element can be also an answer, if it is bigger that next element.
    // And, in the array, consecutive number can never be equal it is mentioned in the code already.(it is imp to think solution for multiple peaks).
    public static void peakElement(){
        int[] arr = {1,2,3,4,5,6,7,8,5,1};
        int n = arr.length;

        // As brute force solution we will search linearly and try to find out the answer like this ->
        // TC -> O(n), SC -> O(1)
        /*
        for(int i = 0; i < n; i++){
            if(i == 0){
                if(arr[i] > arr[i+1]){
                    System.out.println("Peak element is found at index : " + i);
                    return;
                }else{
                   if(n == 1) return i; //or 0
                 }
            }else if(i == n-1){
                if(arr[i] > arr[i-1]){
                    System.out.println("Peak element is found at index : " + i);
                    return;
                }
            }else {
                if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                    System.out.println("Peak element is found at index : " + i);
                    return;
                }
            }

            // OR, we can do above thing using 1 if statement.

            if((i == 0 || arr[i-1] < arr[i]) && (i == n-1 || arr[i] > arr[i+1]))return i; // Amazing.
          }  */


        // So, interviewer will not be happy with O(n) solution, so we have to optimize it, means we have to think it to solve in log n, when
        // log n, comes it means we have certain kind of algorithm that is Binary search, as well we can say that array is given like in some kind of sorted manner.
        // And, in this we have to search it means we can think about Binary search.

        // Firstly, let us think if array is containing only one peak, and the after we will try to expand that for the multiple peaks in the array.
        // For sure, we can say that if array is having one element it means that will be our peak element in this case return 0.
        // So, if we have just one, then we will have three case can be, one is peak is on left of mid, or right of mid, or mid is peak itself.
        // But, how do we identify that which part we have to eliminate in BS, so if we are in decreasing line then peak will be on left, vice versa.
        // And, there will always be a peak.
/*
        if(n == 1){
            System.out.println("Peak element is found at index : " + 0);
            return;
        }
        if(arr[0] > arr[1]){
            System.out.println("Peak element is found at index : " + 0);
            return;
        }
        if(arr[n-1] > arr[n-2]){
            System.out.println("Peak element is found at index : " + (n-1));
            return;
        }
        // these are only to avoid overflow cases, we can also handle in code, but it will be better-way to avoid overflow conditions in the code.
        int low = 1, high = n-2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                System.out.println("Peak element is found at index : " + mid);
                return;
            }else if(arr[mid] > arr[mid-1]){
                // means we are in increasing half/left, means Peak will be on right
                low = mid + 1;
            }else if(arr[mid] > arr[mid+1]){
                // means we are on decreasing half/right, means peak will be on left.
                high = mid - 1;
            }
        }
        System.out.println("Peak element is not found at any index"); */


        // Now, question come into the mind that will it work for the multiple peak elements -> Yes but using a slight change,
        // why it works -> because if we are at a state where we have to eliminate a part but that part is having a peak, but we can eliminate that
        // because, we know that in next we are having another peak, that can be also a answer, so there will no problem in elimination of the array.
        // But, above code will not work for this test case {1,5,1,2,1} so for this we have to think about it.(to get more clearance please do a dry run on this ex).
        // So, instead of using else if() at last, we will use else only, that will be enough to solve this case, because whichever half we will eliminate
        // another will contain a peak.
        // Note -> Make sure that we have to visualize, Binary search using this increasing and decreasing form of graph.

        if(n == 1){
            System.out.println("Peak element is found at index : " + 0);
            return;
        }
        if(arr[0] > arr[1]){
            System.out.println("Peak element is found at index : " + 0);
            return;
        }
        if(arr[n-1] > arr[n-2]){
            System.out.println("Peak element is found at index : " + (n-1));
            return;
        }

        int low = 1, high = n-2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                System.out.println("Peak element is found at index : " + mid);
                return;
            }else if(arr[mid] > arr[mid-1]){
                // means we are in increasing half/left, means Peak will be on right
                low = mid + 1;
            }else if(arr[mid] > arr[mid+1]){
                // means we are on decreasing half/right, means peak will be on left.
                high = mid - 1;
            }
        }
        System.out.println("Peak element is not found at any index");
    }
    public static void main(String[] args) {
        peakElement();
    }
}
