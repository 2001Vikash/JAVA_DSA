package com.ApnaCollege;
import java.util.*;
public class Video_14_Operators_and_Binary_Number_System {
    public static void main(String[] args) {
//        // post increment or a++
//        int a=10;
//        int b=0;
//        b=a++; // means pahle use kr lo phir change kr do. means b=10,a=11;
//        System.out.println(a);
//        System.out.println(b);
//
//        // Pre increment or ++a
//        int c=10;
//        int d=0;
//        d=++c;// means paghle change kr do phir use karo. means d=11, c=11;
//        System.out.println(c);
//        System.out.println(d);
       // and  pre decrement and post decrement work same as increment operators.

        /* Relational Operator
         It returns result as boolean.
         ex. ==,!=,<,>,<=,>=.*/

        /* Logical Operators
        it also gives boolean
        and--> &&, or-->||, not-->!
         */

        // Binary Number System means 0 and 1 or base 2
        // here all value converts in to Binary int java then works


        /* Bitwise Operators
       &(Binary and), |(Binary or), ^(Binary xor),  ~(Binary one's complement).
        <<(Binary Left shift),    >>(Binary Right shift). it uses  in bit manipulation.
         */

        int a=3,b=2;
        int c=a&b;
        int d=a|b;
        int e=a^b;
        int f=-1;
        System.out.println("And operation between a and b : "+c);
        System.out.println("Or operation between a and b : "+d);
        System.out.println("Xor operation between a and b  "+e);// which gives true if both inputs are different.
        System.out.println("One's complement of f : "+~f);// here its use that to convert -ve to +ve numbers or voice versa
                         // we learn about one's complement in bit manipulation.
       //  System.out.println(" 1 Left shift of a : "+ a<<1); formate yhi hai but red line aa rhi hai
        // aur right shift ke liye a>>1 here 1 means i bar right shift karna hai

        /* Assignment Operators
        =, +=,-+,*=,/=
         */

        int g=4;
        int k=g++;// g=5,k=4 hoga but yhi pr k=g+1 ho to g=4 , k=5 hoga.
        System.out.println(g+" "+k);

    }
}
