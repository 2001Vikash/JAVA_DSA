package Level_01_Pepcoding;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Arrays_and_ArrayList_by_Kunal_Kushwaha {
   // public static void main(String[] args) {
        // Arrays are using for stored same type of elements/data in more quantity.
        // means Array is collection of similiar data types which can be int, float, String etc.

        // for example
        //int[] roleNumbers = new int[5];
        //or
      //  int[] roleNumbers = {23,24,25};

        // So

       // int[] ros; // declaration of array . ros is getting defined in the stack.
// here is compile time
        // int is data type and ros is reference variable.

      //  ros = new int[4]; //initialisation :  actually here object is being created in the heap memory.
        // and here is Runtime.
        // it means Dynamic memory Allocation(at the runtime memory allocation)
        // Array memory allocation in c/c++ is continuous.
        // In Java there is no any concept of pointers means you can't find address using java.
        //Means in Java it totally depends on JVM that it is continuous or not.
        //array object in heap and heap can be continuous or can not be.
        // new is used to create an object in heap memory.

    //    System.out.println(ros[1]);// by default it gives 0 for integer in java if we did not gave value.

   //   String[] ar = new String[4];
      //  System.out.println(arr[0]);// means in String it gives null(literal) bydefault in java.
        //String str = null; // we can write as aloso "".
        // each element of array like as an Object and stored in heap memory also somewhere.
        // by default value for int is 0 and String is null so these are called reference variable;
        // and Array is nothing but collection of these reference variable in java.

//    Scanner sc=  new Scanner(System.in);
    // Array of Primitive
     //   int[] arr = new int[5];
//        arr[0] = 23;
//        arr[1] = 45;
//        arr[2] = 48;
//        arr[3] = 50;
//        arr[4] = 52;
//        // so internally it looks like as [23,45,48,50,52]
//        System.out.println(arr[3]);

        // input using for loop.

//        for(int i=0; i< arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
//        for(int i=0; i<arr.length; i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//        for(int j : arr){// for every element in array is j.
//            System.out.print(j+" ");
//        }
  //   System.out.println(Arrays.toString(arr));


        // Array of Object

//        String[] str = new String[4];
//        for(int i=0; i<str.length; i++){
//            str[i] = sc.next();
//        }
//
//        System.out.println(Arrays.toString(str));
//
//    }


    // Array Passing in functions

//    public static void main(String[] args) {
//        int[] nums = {3,4,5,12};
//        System.out.println(Arrays.toString(nums));
//        change(nums);
//        System.out.println(Arrays.toString(nums));
//    }
//    static void change(int[] arr){// here we pass same reference for this arr also.
//        // arr and nums both are pointing to the same objects.
//        // means if we change any one of them the real value is changed.
//        // and this is also know as mutable behaviour.
//
//        arr[0]=99;
//    }


    //  2-D Array....


    public static void main(String[] args) {
      //  int[][] arr = new int[3][3]; // no of columns size is not necessary to specified.
                         // but the no of rows mandatory. first box is for row and second is col.
        // or
//        int[][] arr = { {1,2,3},
//                        {4,5},
//                        {7,8,9} };// it is nothing but array of arrays.
//        System.out.println(arr[1][0]);

        // Taking Input

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please Enter the content of array");
//        int[][] arr = new int[3][3];
//        System.out.println(arr.length);// it will give no. of row.
//        for(int row=0; row<arr.length; row++){
//            for(int col=0; col<arr[row].length; col++){
//                arr[row][col] = sc.nextInt();
//            }
//        }

        // For Output

//        for(int row=0; row<3; row++){
//            for(int col=0; col<3; col++){
//                System.out.print(arr[row][col]+" ");// if we replace row with col and vice versa then it creates Transpose of Matrix.
//            }
//            System.out.println();
//        }

        // Another way for printing
//
//        for(int row = 0; row<arr.length; row++){
//            System.out.println(Arrays.toString(arr[row]));
//        }

        // using for each loop

//        for(int[] a : arr){// because 2 D array is nothing but array of array. so here we use array type of data types.
//            System.out.println(Arrays.toString(a));
//        }



        // ArrayList.....

        // Why we need an ArrayList?
        // Ans --> Here arrays are fix size so overcome for this problem we go for ArrayList which has Dynamic size.

        // Means ArrayList is same as Array but in size it's Dynamic.

        //  Syntax..

        ArrayList<Integer> list = new ArrayList<>(5);// ArrayList is class. It is also known as collection Framework.
                                      // after new this is constructor. we can pass initial capacity.
        // We can also write without any data types it will take automatically.
        // here we can't use primitive data types we need to use wrapper classes.

        list.add(29);
        list.add(49);
        list.add(20);
        list.add(99);
        list.add(79);
        list.add(21);// means if we give initial capacity it's nice but we can also add elements more than 10.
        System.out.println(list);
        System.out.println(list.contains(29));
        list.set(0,100);
        System.out.println(list);
        list.add(0,102);
        System.out.println(list);
        System.out.println(list.get(0));


        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list1 = new ArrayList<>(5);
        for(int i=0; i<5; i++){
         //   list1.add(sc.nextInt());
            //or
         //   list.set(i,sc.nextInt());
        }
        System.out.println(list1);
        // or
//        for(int i=0; i<5; i++){
//            System.out.println(list1.get(i));
//        }

        /*
        How is it saying that no size is required. if we initial size is 10 but still we can put 1000 and many
           more elements. how is it possible? Why is size not fixed?

           1. --> In reality Size is actually fixed internally.
           2. --> If we assume that our arraylist is full or remains 50% whatever.
                 then after a new ArrayList is created with may be double size of previous or whatever we can check.
      old one is deleted and all old elements are stores in new List first then after going for next element that's it.
         with O(1) time complexity.
         */


        // Multi-dimensional  ArrayList.....

//        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
//        // Initialisation part
//        for (int i=0; i<3; i++){
//            list2.add(new ArrayList<>()); // here we add some lists in the list.
//        }
//        System.out.println(list2);
//
//        // Add elements.
//
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                list2.get(i).add(sc.nextInt());
//            }
//        }
//        System.out.println(list2);


        // Swap... and Max.... and reverse the array...

        // work on edge cases here.
        // for example

        int[] arr = {1,3,23,9,18};

        swap(arr, 1,3);
//        for (int i:arr
//             ) {
//            System.out.print(i+" ");
//        }
        //or
        System.out.println(Arrays.toString(arr));

        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);
        max = 0;
        // max between two indexes

        for(int i=3; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("max in range " +max);

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int ind1, int ind2){
        if(arr.length ==0 ){
            return;
        }
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            swap(arr,start, end);
            start++;
            end--;
        }
    }
}
