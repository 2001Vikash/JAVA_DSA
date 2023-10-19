package Level_01_Pepcoding;

public class Introduction_to_Recursion_with_KK_and_mostImp {
//    public static void main(String[] args) {
//        // Recursion is most important topic which is cover 90 percent of the DSA things like Binary tree , Binary search tree,graph etc.
//
//        // write a function that prints hello world
//
//        message();
//        // if I say you that you need to print 4 times without modifying this function
//        // that means we can create more than 1 function to print but it is not an efficient way to do this.
//    }
//    static void message(){
//        System.out.println("Hello World");
//        message1();
//    }
//    static void message1(){
//        System.out.println("Hello World");
//        message2();
//    }
//    static void message2(){
//        System.out.println("Hello World");
//        message3();
//    }
//    static void message3(){
//        System.out.println("Hello World");
//        message4();
//    }
//    static void message4(){
//        System.out.println("Hello World");
//    }


    // Printing numbers most important example.


//    public static void main(String[] args) {
//        print1(1);
//    }
//    static void print1(int n){
//        System.out.println(n);
//        print2(2);
//    }
//    static void print2(int n){
//        System.out.println(n);
//        print3(3);
//    }
//    static void print3(int n){
//        System.out.println(n);
//        print4(4);
//    }
//    static void print4(int n){
//        System.out.println(n);
//        print5(5);
//    }
//    static void print5(int n){
//        System.out.println(n);
//    }


    // Recursion --> according to above example we can see that function call another function with same body.
    // for example we can see that print1, print2 and all are doing same work , taking same parameters etc.
    // so we can call itself again and again with given case that is nothing but known as RECURSION.


    // All the function calls that happens in programming language they go to the Stack memory.

    // Important points
    // 1 --> While the function is not finished executing it will remain in stack.
    // 2 --> When a function finished executing it is removed from the stack.
    //      and the flow of program is restored to where that function was called.

//    public static void main(String[] args) {
//        print(1);
//    }
//    static void print(int n){
//        if(n > 5){// base condition
//            return ;
//        }
//        System.out.println(n);
//        print(n+1);// so simply Recursion means function that calls itself.
    // and this is last function call and it is known as Tail recursion.
//    }

    // Base condition --> In condition where our recursion will stop ranking new calls.

//    public static void main(String[] args) {
//       recursion(5);
//    }
//    static void recursion(int n){
//        if(n < 1){
//            return ;
//        }
//        System.out.println(n);
//        recursion(n-1);
//    }

// As we call as functions it will take separately memory. means space complexity will not constant because of recursive calls.

    // Why Recursion ??
    // Ans --> It helps us in solving bigger and complex problem in a simple way. for ex in dynamic programming.
    //       --> we can converts recursion solution into iteration solution and vice versa. means using loops.
    //       --> first try to solve complex problem using recursion then try to convert in iteration solution for
    //           optimizing code because it will hard to solve complex problem using loops that's why we use recursion.


    // VISUALIZING RECURSION -->  very very important point
    //  --> if we want to visualize then we need to make recursion tree on paper for every problem
    // --> this visualization is play very important role to understand recursion that how it works.

    // Let's take a question to understand this --> Find nth fibonacci number
    // 0th -> 0, 1st -> 1, 2nd -> 1, 3rd -> 2, 4th -> 3, 5th -> 5 ..... and so on.

    /*
    public static void main(String[] args) {
        System.out.println(nthFibonacciNumber(4));
        // means break it down into smaller problem
    }
    static int nthFibonacciNumber(int n){
//        if(n == 0){ // base condition 1
//            return 0;
//        }
//        if(n == 1){ // base condition 2
//        means here we assume 0th and 1st fibonacci number as a base condition.
//            return 1;
//        }
        // we can also replace it like as means same thing
        if(n == 0 || n == 1){
            return n;
        }
                  // firstly completed              secondly completed
        int ans = nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);// this is known as recurrence relation
        // when we write recursion formula is known as recurrence relation.
        return ans;

// If we shall give n = 50 it will take more time to execute due to 1.6^n time complexity. because off he will try
 //  to solve same thing in recursion tree again and again.
 // for example if we call n = 5 then in left side we will see that f(2) and as well as right side
 // think about it if in 5 same thing happening two times what is answer in n = 50.
   */

    // But we can find it using fibonacci formula

    public static void main(String[] args) {
        for(int i = 0; i < 51; i++){
            System.out.print(fibonacciFormula(i) + " ");
        }
    }
    static long fibonacciFormula(int n){
        // for bigger value we can use long
      return (long) ((Math.pow((1+Math.sqrt(5))/2,n) - Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));
        // we can also remove less dominating term means after '-'.
       // return (int) (Math.pow(((1+Math.sqrt(5))/2), n) / Math.sqrt(5));// it will also give same answer
        // but it will not work here I can solve it.
    }

    // Q -> How to understand and approach a problem with the help of recursion
    // Ans -> 1 --> Identify if you can break down problem into smaller problem.
    //        2 --> Write the Recurrence relation if needed.
    //        3 --> Draw the recursive tree
    // 4 -> About the tree --> ** See the flow of functions , how they are getting in stack
    //                     ** Identify and focus on left tree calls and right tree calls.
    //                    ** Draw the tree and pointer again and again using pen and paper.
    //                    ** Use a debugger to see the flow
    // 5 -> See how the values and what type of values (int , char, string , float etc) are returned at each step.
    // 6 -> See where the function call will come out of. and in the end you will come out of the main function
    //   }
    // Variables in recursion : 1 -> Argument
//                                 2 -> Return type
//                                 3 -> Body of function.


    // Binary Search using Recursion

    // Recurrence relation --> f(n) = O(1) + f(n/2). here O(1) is compare time and f(n/2) is dividing time.

    // Types of recurrence relation : 1 -> Linear recurrence relation (fibonacci)
    //                                 2 -> Divide and conquer relation (Binary Search)

    // Do not overthink it's very important

//    public static void main(String[] args) {
//        int[]arr = {1,2,3,4,5};
//         int start = 0;
//         int end = arr.length - 1;
//        System.out.println(binarySearch(arr, start, end, 4));
//    }
//    static int binarySearch(int[] arr, int start, int end, int target){
//        if(start > end){
//            return -1;
//        }
//        int mid = start + (end - start)/2;
//        if(arr[mid] == target){
//            return mid;
//        }
//        if(target > arr[mid]){
//
//            // very important point :
//            // make sure to return the result of a function call of the return type.
//            // if we not return then our original ans will be not disappear.
//
//           return  binarySearch(arr, mid + 1, end, target );
//        }
//          return binarySearch(arr, start, mid - 1, target);
//    }

}

