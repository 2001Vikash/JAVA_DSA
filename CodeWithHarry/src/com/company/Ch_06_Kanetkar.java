package com.company;

import com.sun.security.jgss.GSSUtil;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ch_06_Kanetkar {
    public static void main(String[] args) {

        // PROBLEM -->(a)

//        System.out.println("These are all prime numbers between 1 to 300.");
//        System.out.println("1 is neither prime nor composite");
//         int count =0;
//        for(int i=1;i<=300;i++){
//            int d=0;
//           for(int j=1;j<=i;j++){// jb jb 'i' ki new value milegi uske liye j=1 ho jayega.
//               if(i%j==0){
//                   d++;
//                  // System.out.println(d);
//               }
//              // System.out.println(d);
//           }
//              if(d==2){
//                  System.out.println(i);
//                  count++;
//              }
//        }
//        System.out.println("Total prime numbers is = "+count);
//        // here 1 is neither prime nor composite.
//        // composite means a positive integer which has more than two factors.ex 4,6,8,9,10,12,14,15...etc.

        // PROBLEM -->(b)

//        float sum=1;
//        for(int i=2;i<=7;i++){
//            float f=1;
//            for(int j=1;j<=i;j++){
//                f=f*j;
//            }
//            sum=sum+(i/f);
//        }
//        System.out.println(sum); // Or
//        float sum=0,f=1;
//        for(int i=1;i<=7;i++){
//            f=f*i;
//            sum = sum+ (i/f);
//        }
//        System.out.println(sum); // This is too much good.

         // PROBLEM --> (c)

//        for(int i=1;i<=3;i++){
//            //System.out.print(i);
//            for(int j=1;j<=3;j++){
//                for(int k=1;k<=3;k++){
//                     if(i!=j && i!=k && j!=k){
//                         System.out.println(i+""+j+""+k);
//                         // here jitne value ka combination chahiye utane loop lagane padenge.
//                     }
//                }
//            }
//        }

        //  PROBLEM --> (d)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter your number for printing table!");
//        int n = sc.nextInt();
//        System.out.println("This is the multiplication table of "+n);
//        for(int i=1;i<=10;i++){
//            System.out.println(n+"*"+i+" = "+(n*i));
//        }

        //  PROBLEM --> (e)

        // formula --> i=2+(y+0.5x) for calculating approximate level of intelligence.
        // this is for Y
//        System.out.println("Table for i , y and x");
//        System.out.println("y,  x,  i");
//        for(int y=1;y<=6;y++){
//            float i=0;
//            // this is for X.
//            for(float x = 5.5f;x<=12.5f;x=x+0.5f){
//               i= i=2+(y+(0.5f)*x);
//                System.out.println(y+", "+x+", "+i);
//            }
//        }

        // PROBLEM --> (f)

//        Scanner sc =new Scanner(System.in);
//        double a;
//        int i=1;
//        while(i<=10){
//            System.out.println(" please Enter the value of p,r,n and q one by one");
//            int p =sc.nextInt();
//            int r= sc.nextInt();
//            float n = sc.nextFloat();
//            float q=sc.nextFloat();
//            a=p*Math.pow((1+r/q),n*q);
//            System.out.println("a = "+a);
//            i++;
//        }

        //  PROBLEM --> (g)

//        Scanner sc =new Scanner(System.in);
//        System.out.println("Please enter the value of 'x' !");
//        int x= sc.nextInt();
//        double form = (x-1.0f)/x;
//         double p,r, sum=0;
//        int i=2;
//        while(i<=7){
//            p=(Math.pow(form,i));
//            r=p/2;
//            sum =sum+r;
//            i++;
//        }
//
//        System.out.println("Sum of first seven terms of natural logarithm = "+(form+sum));

        // PROBLEM --> (h)
//       int a,b,c;
//        for(c=1;c<=30;c++){
//            for(b=1;b<=30;b++){
//                for(a=1;a<=30;a++){
//                    if((c*c)==(a*a)+(b*b)){
//                        System.out.println("Pythagorean Triplets are = "+c+","+b+","+a);
//                    }
//                }
//            }
//        }

        // PROBLEM --> (i)

//        int popToday = 100000;
//        System.out.println("population in 2022 that means today = "+popToday);
//        float x=1000000/11.0f;
//        System.out.println("population in 2021 = "+x);
//        for(int i=2020;i!=2011;i--){
//            x=(10*x)/11;
//            System.out.println("Population in "+i+" = "+x);
//        }

        // PROBLEM -->(j)

        // we know that 1729 is called as Ramanujan number.
//        int r=1729;
//        for(int i=1;i<=20;i++){
//            for(int j=1;j<=20;j++){
//                if((i*i*i)+(j*j*j)==r){
//                    System.out.println(i+","+j);
//                }
//            }
//        }

        // PROBLEM --> (k)

//        System.out.println("Here is the 24 hours in a Day");
//        System.out.println("12:00 AM --> Midnight");
//        for(int i=1;i<=11;i++){
//            System.out.println(i+":00 AM");
//        }
//        System.out.println("12:00 PM --> Noon");
//        for(int i=1;i<=11;i++){
//            System.out.println(i+":00 PM");
//        }
//        System.out.println("12:00 AM --> Midnight");
//        System.out.println("Oh! 24 hrs is completed wow!");

        // PROBLEM -->(l)
//         int count=1;
        // this loop used for height of pattern
//      for(int i=1;i<=4;i++){
        // This loop used for left space of every new line
//          for(int j=1;j<=4-i;j++){
//              System.out.print(" ");// It creates spaces same line.
//          }
        //  It's used for printing numbers.
//          for(int k=1;k<=i;k++){
//              System.out.print(count+" ");
//              count++;
//          }
//          System.out.println("");
//      }
    }
}
