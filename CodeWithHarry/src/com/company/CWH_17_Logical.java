package com.company;

public class CWH_17_Logical {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c= false;
        if (a && b && c) {// & isaki associativity Left to Right hoti hai isme 2 or 3 or more compare kar sakte hai
            /* he works as AND operator its only true when both are true if both are false or any false
            then result will also false.
             */
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
         boolean a1=true;
        boolean b1=true;
        boolean c1= false;
        if(a1|| b1 ||c1){
            // ye OR ki trh work krta hai koi bhi ek true hoga to ans true hoga
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        System.out.print("NOT(a) is :: ");
        System.out.println(!a);
        // !a is like NOT gate or invertor.
        System.out.print("NOT(B) is :: ");
        System.out.println(!b);
    }
    }

