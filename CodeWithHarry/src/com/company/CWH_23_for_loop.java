package com.company;
import java.util.Scanner;
public class CWH_23_for_loop {
    public static void main(String[] args) {
     //  for(int i =1;i<=10;i++){
// // Here firstly assign value of i=1; then check the condition; then print the value of i and ; update i++;
//   // that means int i=1;
        // Most important thing is that condition is check a boolean manner.
        // that means we can use more condition parallel like as i<10&&i>20 etc.
//       //      i<=10;
//       // print the value of i;
//       // i++;
   //        System.out.println(i);
   //   }
//          Scanner sc= new Scanner(System.in);
//        System.out.println("Enter your value");
//          int n = sc.nextInt();
//          for (int i=1; i<=n;i=i+2){
//              System.out.println(i);// first n tk kitne odd numbers hai print karega
//          }
        // Or we know that 2n=even numbers
                    //  2n+1= odd numbers
//      for(int i=0;i<n;i++){
//            System.out.println(2*i+1);// aur ye first n odd  numbers print karega
//        }
//        for(int i=10;i>0;i--){
//            System.out.println(i);
//        }
        //OR
//        for(int i=10;i!=0;i--){
//            System.out.println(i);
//        }
//        // imp :: for loop as an Infinite loop.
//        for(int i=5;i>0;i++){
//            System.out.println(i);
//        }
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your value");
          int n = sc.nextInt();
          for(int i=n;i!=0;i--){
              System.out.println(i);
          }
    }
}
