package com.company;

public class CWH_10_Ch02 {
    public static void main(String[] args) {
        byte x=5;
        short y=6;
        int z=7;
        int a=x+y;
        System.out.println(a);
        float b=4.5f+x;
        System.out.println(b);
        // Increment and Decrement Operator
        int i=56;
        System.out.println(i++);

        System.out.println(i);
        System.out.println(++i);//same as i-- and --i me bhi hoga

        System.out.println(i);
        char m='a';
        System.out.println(m++);
        System.out.println(m);
        System.out.println(++m);
        int s=7;
        int l= ++s *8;//yaha pr ++ ka precedence high hai * se mtlb ++ wala pahle solve hoga
        System.out.println(l);
    }
}
