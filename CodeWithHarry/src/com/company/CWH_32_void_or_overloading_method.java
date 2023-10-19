package com.company;

public class CWH_32_void_or_overloading_method {
//        static void change2(int [] arr){
//            arr[0]=98;
//        }
//    static void change1(int a){// here int a or int [] arr means arguments.
//        a=98;
//    }
//    static void tellJoke(){
//        System.out.println("Ka a Bhaveshwa ka hal ba tor thik ba n!");
//    }
//    public static void main(String[] args) {
//         tellJoke();
//         // CASE 1 --> changing the value.
//         int x=45;
//         change1(x);
//        System.out.println("run after changing th value :: "+x);// RESULT--> NOT CHANGED.
//        // CASE 2 --> CHANGING THE VALUE IN ARRAY'S ELEMENTS
//        int [] marks = {56,76,86,54,67,89,65};
//        change2(marks);
//        System.out.println("After changing the value : "+marks[0]);
//        /* RESULT --> VALUE CHANGED.  WHY?
//        ANS --> Because we pass the reference/address int void function or we can say we paas the object same as
//                   previous time when we passed the int x=45 but not changed because here we passed directly object as reference
//                   but in the case of array we pass reference of object as marks then arr will behave like as marks
//                   so we know that if arr has the address of marks[0]=arr[0]. so it can be easily changed.
//         */

        // METHOD OVERLOADING --> Two or more methods have same name but work differently. but every method has different parameters.

           static void foo() {// here no required of arguments.
               System.out.println("Hello Good Morning!");
           }
           static void foo(int a){// here required one argument so this is different from first foo.
               System.out.println("Hello "+a+" Good Morning");
           }// HERE IS MORE IMP THINGS THAT IS IF WE FIRSTLY US FOO AS VOID AND NEXT TIME IF WE WANT USE AS INT USING SAME PARAMETERS THEN
    // ITS NOT A OVERLOADING METHOD . COMPILER GIVES AN ERROR. SO ONLY WE CAN CHANGE PARAMETERS . WE CAN USE INT WITH DIFFERENT PARAMETERS.
           static void foo(int a, int b){
               System.out.println("Hello "+a+" bro "+b +" good morning");
           }

    public static void main(String[] args) {
              foo();
              foo(300);// here 300 is an Arguments which is passed in parameters as a reference.
        // THAT MEANS --> ARGUMENTS ARE ACTUAL.
              foo(200,500);
    }
    }

