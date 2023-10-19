package com.company;

public class CWH_09_Ch02_pre_ass {
    public static void main(String[] args) {
        /* precedence means if two operators come in operation then we see that
            which have same precedence like as (/,*,%),(+,-) etc. that means if higher
            precedence come front of lower precedence.
            ASSOCIATIVITY means if two same precedence operator come with together
            then we operate LEFT to RIGHT.
            (/,*,%)--> L to R
            (+,-)--> L to R
            ++,= --> R to L
         */
        int a=6*5-12/3;
        //L to R means jo sabse left me hoga same precedence wala wahi pahle solve hoga.
        /* =30-12/3
        =30-4
        =26.
         */
        int b=12/3-6*5;//---->
        /*=4-6*5
        =4-30
        =-26
         */
        int c,d;
        c=d=45;//R to L hoga.for example (++,=).
        //<---
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

}
