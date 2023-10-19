package com.company;

import java.util.Scanner;

public class Ch_01_Kanetkar_let_us_c_in_java {
    public static void main(String[] args) {

        // PROBLEM --> (a)

//        Scanner sc= new Scanner(System.in);
//        System.out.println("Please Enter your basic salary Ramesh ji !");
//        float basic_salary = sc.nextFloat();
//        float dearness_allowance = basic_salary*0.4f;
//        float rent_allowance = basic_salary*0.2f;
//        float gross_salary = (basic_salary+dearness_allowance+rent_allowance);
//        System.out.println("Ramesh's gross salary is = "+gross_salary);
//


        // PROBLEM --> (b)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter distance between two cities in KM!");
//        float distance = sc.nextFloat();
//        System.out.println("Distance in meters = "+distance*1000);
//        System.out.println("Distance in feet =  "+(distance*3280.84f));
//        System.out.println("Distance in inches = "+(distance*39370.07874f));
//        System.out.println("Distance in centimeters = "+(distance*100000));

        // PROBLEM -->(c)

//        Scanner sc= new Scanner(System.in);
//        System.out.println("Please enter your obtained numbers out of 100!");
//        System.out.println("Enter your numbers of sub1");
//        byte sub1 = sc.nextByte();
//        System.out.println("Enter your numbers of sub2");
//        byte sub2 = sc.nextByte();
//        System.out.println("Enter your numbers of sub3");
//        byte sub3 = sc.nextByte();
//        System.out.println("Enter your numbers of sub4");
//        byte sub4 = sc.nextByte();
//        System.out.println("Enter your numbers of sub5");
//        byte sub5 = sc.nextByte();
//        float aggregate_numbers = (sub1+sub2+sub3+sub4+sub5);
//        float percentage = (aggregate_numbers*100)/500;
//        System.out.println("Aggregate marks = "+aggregate_numbers+", Percentage = "+percentage);

        // PROBLEM --> (d)

//         Scanner sc= new Scanner(System.in);
//        System.out.println("Please enter  temperature of your city in Fahrenheit");
//         float fahrenheit = sc.nextFloat();
//         float formula = ((fahrenheit - 32) * (5.0f/9));
//        System.out.println("temperature in centigrade = "+formula);

        // PROBLEM --> (e)

//        Scanner sc = new Scanner(System.in);
//        float lof_R = sc.nextFloat();
//        float bof_R = sc.nextFloat();
//        float radof_C = sc.nextFloat();
//        float Aog_R = (lof_R*bof_R);
//        float perof_R = 2*(lof_R+bof_R);
//        float Aof_C = (3.14f*radof_C*radof_C);
//        float cirof_C = (2*3.14f*radof_C);
//        System.out.println("Area of Rectangle = "+Aog_R+", Perimeter of Rectangle = "+perof_R);
//        System.out.println("Area of circle = "+Aof_C+", circumstances of circle = "+cirof_C);

        // PROBLEM --> (f)


      //  int [] A = new int[9];
        int a=1189,b=841,c=a/2;
        System.out.println("A0"+"="+a+"x"+b);
//        A[1]=841*594;  taken as example.

        for(int i=1;i<9;i++){
            System.out.println( "A"+i+"="+b+"x"+(c));
            b=c;
            c = b/2;
        }
    }
}
