package com.ApnaCollege;
import java.util.*;
public class Video_13_String_Builder {
    public static void main(String[] args) {
        /* String Builder
        we know that String is immutable in java means we can't perform any operation on that string
        if we try to do then there are creating new memory location && it takes time more
        so for solving this problem we use string builder in java
         */

        // Declaration of String Builder

//        StringBuilder sb=new StringBuilder("Vikash");
//           System.out.println(sb);
//        // Char at index 0
//           System.out.println(sb.charAt(0));
//        // Set char at any index
//           sb.setCharAt(0,'B');
//        System.out.println(sb);
//        // insert at any index
//        sb.insert(0,'V');
//        System.out.println(sb);
//        // delete at any index
//        sb.delete(0,1);// yaha pr ending index non-included hai means only 0 wala hi delete hoga
//        System.out.println(sb);
//       // Appending any characters means string ke last me add kr dena
//         sb.append(" yadav");
//        System.out.println(sb);
//        System.out.println(sb.length());

        // reverse a string
//        String str="Vikash";
//        for(int i=str.length()-1;i>=0;i--){
//            System.out.print(str.charAt(i));
//        } // but iski time comlexity  badh jayegi.
        // second way

//        StringBuilder sb= new StringBuilder("HELLO");
//        for(int i=0;i<sb.length()/2;i++){
//            int front=i;
//            int back=sb.length()-1-i;
//          char fronchar= sb.charAt(front);
//          char backChar= sb.charAt(back);
//            sb.setCharAt(front,backChar);
//            sb.setCharAt(back,fronchar);
//        }
//        System.out.println(sb);

        // Homework Problem is that try to solve all problems of strings with the help of sting builder form


    }
}
