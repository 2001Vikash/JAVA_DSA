package Step_04_Binary_Search.BS_on_One_D_Arrays;

public class BS_08_Single_Element_in_Sorted_Array {

    // In this problem we have to find that element which appears once in the array rest of all appearing twice and, it is guaranteed.
    public static void singleElementInSortedArray() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        int n = arr.length;

        // As we Brute force solution, we will check two things, if current element is not having similar, left or right elements, that will be single.
        // TC -> O(n).

      /*  int ans = 0;
      // here is one edge case that is if n == 1 then return arr[0].
        for(int i = 0; i < n; i++){
            if(i == 0){
                if(arr[i] != arr[i+1]){
                    ans = arr[i];
                    break;
                }
            }else if(i == n-1){
                if(arr[i] != arr[i-1]){
                    ans = arr[i];
                    break;
                }
            }else{
                if((arr[i] != arr[i+1]) && arr[i] != arr[i-1]){
                    ans = arr[i];
                    break;
                }
            }
        }
        System.out.println(ans); */

        // Second brute force can be using XOR, we know that XOR with same numbers will be 0 and XOR with 0 will be that number itself. TC -> O(n)

        // As we know that array is sorted, means we have to think about the Binary search and, that will be our optimal solution as well.TC -> O(log n)

        // So, if we have to apply binary search then we have to think about elimination, n to n/2 and so on as well we have to focus on answer.

        // If elements are coming twice means may be one element is at even index, and second one is at odd, index, and we know that indexing are started
        // from even index, it means if first element (which are same can be anything) comes at odd index and second one comes at even index, it means,
        // we are in right half, because we know that there will be definitely, one element exists which is coming once, so from that place order will be changed that part will be right.
        // Means -> (even,odd) => it means, I am on left half and my element is on right half means eliminate the left half.
        //       -> (odd, even) => it means, I am on right half and my element is on left half means eliminate the right half.

        // But, how do we figure it out that which one is eve, odd or odd, even, very simple, check that wherever we are standing that index is
        // even or odd, if even then go for odd, and if odd then go for the even, and like this easily we can identify that which one part we have to eliminate.

        // If we want to find single number then we have to know about the left and right of that current element if they are not equal then we can say that
        // this is a single element, but for this we have to focus on lots of edges case like what if i == 0, or i == n-1, so to avoid these conditionals
        // we will start from low = 1, and, high = n-2, and check for 0, and n-1 separately.

        if(n == 1){
            System.out.println("Answer : " + arr[0]);
            return;
        }

        // for the eliminating edge cases we are going to do
        if(arr[0] != arr[1]){
            System.out.println("Answer : " + arr[0]);
            return;
        }
        if(arr[n-1] != arr[n-2]){
            System.out.println("Answer : " + arr[n-1]);
            return;
        }

        int low = 1, high = n-2;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if((arr[mid-1] != arr[mid]) && (arr[mid] != arr[mid + 1])){
                System.out.println("Answer : " + arr[mid]);
                return;
            }

            if((mid % 2 == 1 && arr[mid-1] == arr[mid]) || (mid % 2 == 0 && arr[mid] == arr[mid+1])){
                // means we are on left half, and our element is on right half
                low = mid + 1;
            }else{
                // means we are on right half, and our element is on left half -> there is no need to check because if we are not in left, means we are in right.
                high = mid - 1;
            }
        }

        System.out.println("Element is not found");
    }

    public static void main(String[] args) {
        singleElementInSortedArray();
    }
}
