package com.ApnaCollege;

public class Video_17_Recursion_01 {
//    public static void printNUm(int n){
//        if(n==0){// base casse
//            return;
//        }
//       // printNUm(n-1);// 1 2 3 4 5
//        System.out.println(n);// Print
//        printNUm(n-1); //  5 4 3 2 1 recursion
//    }
//    public static void main(String[] args) {
//        int n=5;
//        printNUm(n);
//    }

//    public static void printNum(int a){
//        if(a==6){
//            return ;
//        }
//        System.out.println(a);
//        printNum(a+1);
//       // return ; ye optional hai we can put it here or nhi bhi hoga koi dikkat nhi hoga. kyoki void function hai
//    }
//    public static void main(String[] args) {
//        int n=1;
//        printNum(n);
//    }

    // Print sum of First n natural numbers with the help of recursion


//    public static int printSum(int a){
//
//        if(a==1){
//            return 1;
//        }
//        return a+printSum(a-1);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter your numbers");
//        int n=sc.nextInt();
//        System.out.println("Sum of first "+n+" numbers is :: "+printSum(n));
//    }

//    public static  int printSum(int i,int n, int sum){
//        if(i==n+1){
//            return 0;
//        }
//       // sum+=i;
//        printSum(i+1,n,sum+i);
//        return i;
//    }
//    public static void main(String[] args) {
//    int n=2,i=1;
//        System.out.println(printSum(i,n,0));
//    }   This method creates more confusion about recursion but ist clear now and that's amazing for me


//    public static void printSum(int i,int n, int sum){
//        if(i==n){
//            sum=sum+n;
//            System.out.println(sum);
//            return;
//        }
//        sum+=i;
//        printSum(i+1,n,sum);
    //System.out.println(i); to output  15,4,3,2,1.
//    }
//    public static void main(String[] args) {
//     printSum(1,5,0);
//    }

    //  Print Factorial of a number n

//    public static int calFact(int n){
//        if(n==0 || n==1){// n==1 rahega to bar bar 0 ke pass jana nhi padega o kewal 0 ke case me hoga
//            return 1;
//        }
////        return n*calFact(n-1); or
//        int result = n*calFact(n-1);
//        return result;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n= sc.nextInt();
//        System.out.println("Factorial of given number is = "+calFact(n));
//    }

    // Print Fibonacci series till n

//    public static int  printFib(int n){
//        if(n==1){
//            return 0;
//        }
//        if (n==2){
//            return 1;
//        }
//      int result=  printFib(n-2) +printFib(n-1);
//        return result;
//    }
//    public static void main(String[] args) {
//
//        System.out.println(printFib(7));
//    }

    // Most Important

//public static void  printFib(int n,int a, int b){
//    if(n==0){
//        return ;
//    }
//    int c=a+b;
//    System.out.print(c+" ");
//    printFib(n-1,b,c);
//}
//    public static void main(String[] args) {
//        int a=0,b=1,n=7;
//        System.out.print(a+" "+b+" ");
//        printFib(n-2,a,b);
//   }

    // Print x^n (Stack height =n)

//    public static int printPow(int x,int n){
//
//        if(x==0){
//            return 0;
//        }
//        if(n==0){
//            return 1;
//        }
//
//        int d = x * printPow(x,n-1);
//        return d;
//    }
//    public static void main(String[] args) {
//         int x=2,n=5;
//        System.out.println(printPow(x,n));
//    }

    // Print x^n (Stack height =log n)

    public static int calcPow(int x, int n){
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n%2==0){
            return calcPow(x,n/2)*calcPow(x,n/2);
        } else{
            return calcPow(x,n/2)*calcPow(x,n/2)*x;
        }
    }
    public static void main(String[] args) {
       int x=2,n=5;
        System.out.println(calcPow(x, n));
    }
}
