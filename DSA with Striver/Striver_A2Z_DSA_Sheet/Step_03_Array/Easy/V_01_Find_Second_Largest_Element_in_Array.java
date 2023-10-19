package Step_03_Array.Easy;

public class V_01_Find_Second_Largest_Element_in_Array {

    // Array -> it is nothing but a data structure which contains similar kind of elements like Integers, characters, strings, booleans, etc.

    // Note -> maximum size of array that we can define is 10^6 when we are doing it inside the main function, if we declare globally then 10^7.

    // Firstly we will see the largest element in to the array, and this is easy to find the max in array with the help of loop.

    // In interview, we must have to follow this flow that is Brute force -> better solution -> Optimal solution.

    public static int maxElement(int[] arr){
        // brute force solution can be via sorting and return the last element from the array(O(n log n). Now go for another solution

        // O(n)
        int maxi = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }

    // Now we have to find the second largest, element from the array without using sorting.

    public static int secondMaxElement(int[] arr){

        // brute force can be using sorting
        // So after sorting we can say that we have to find second distinct number from last that will be our answer.

        // O(n log n) + o(n)

//        Arrays.sort(arr);
//        int ans = -1; // if not exist
//        for(int i = arr.length-1; i > 0; i--){
//            if(arr[i] != arr[i-1]){
//                ans = arr[i-1];
//                break;
//            }
//        }
//        return ans;

        // better solution -> O(n) + o(n)

//        int maxi = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] > maxi)maxi = arr[i];
//        }
//
//        int sMax = -1;
//        for(int i = 0; i < arr.length; i++){
//            if(sMax < arr[i] && arr[i] != maxi){
//                sMax = arr[i];
//            }
//        }
//
//        return sMax;

        // Optimal solution => o(n)

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE; // this is for if array contains -ve numbers as well.

        for(int i = 1; i < arr.length; i++){
            if(largest < arr[i]){
                secondLargest = largest;
                largest = arr[i];
            }else if(secondLargest < arr[i] && arr[i] != largest){ // or we can also put arr[i] < largest
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }


    // Third problem is that check the array is sorted or not.(in non-descending order)

    public static boolean isSorted(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    // Now -> next problem is that we have to remove duplicate element in-place from the sorted array. We have to modify the given array not new array
    //        whatever unique elements are present in the array they should come first after that anything can come, and after that return the number of unique elements'


    // Brute force solution can be via set data structure, that will give unique elements, then after put those elements in original array
    // then after return the size of set, as we know that set will contain everything in ascending order
    // for the set insertion it will cost log n, then for insertion overall TC will be O(n log n) + o(n), and SC -> O(n)

    // In order to optimize this solution we have to use two pointer method, that will be optimal solution.

    // O(n), SC -> O(1)
    public static int uniqueElements(int[] arr){
        int n = arr.length;
        int i = 0;
        for(int j = 1; j < n; j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }

        return i+1;
    }





    public static void main(String[] args) {
        int[] arr = {3,23,4,5,67,89,89,24};
        System.out.println("Max element in the given array will be = " + maxElement(arr));
        System.out.println("Second largest element in array is = " + secondMaxElement(arr));
        System.out.println("IsSorted : " + isSorted(arr));

        System.out.println("Number of unique elements in given array = " + uniqueElements(arr));
    }
}
