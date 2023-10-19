package com.company;



public class CHW_Ch02_operator {
    public static void main(String[] args) {
        int a = 4;
        int b = 6 + a, c = 6 - a, d = 6 * a, e = 6 / a,g=6%a;
        float f = 11 / 5;//iska mtlab ye bhi int value dega kyoki 11and 5 are int.
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(6==4);
        System.out.println(6==6);
        System.out.println(6>=4);// yaha pr <,> ye bhi use hota hai as a comparison operator
        int k=5;
        k+=4;//k*=4;etc
        System.out.println(6<=4);
        System.out.println(k);
        System.out.println(67>4&&53>78);// isme donop true hona chahiye tb true hoga nhi to false
        System.out.println(45<46||76>8);//isme ek bhi true hai to true hoga
        System.out.println(2&3);
        System.out.println(2|1);
    }

}

