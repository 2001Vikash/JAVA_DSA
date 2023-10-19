package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Math.*; // its using for trignometry function.
public class Ch_02_kanetkar {
    public static void main(String[] args) {

        // PROBLEM --> (a)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your five digit number!");
//        int number = sc.nextInt();
//        int sum =0;
//        sum = sum+number%10;
//        number = number/10;
//        sum = sum+number%10;
//        number = number/10;
//        sum = sum+number%10;
//        number = number/10;
//        sum = sum+number%10;
//        number = number/10;
//        sum = sum+number%10;
//        number = number/10;
//        System.out.println(sum);

        // PROBLEM -->(b)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your five digit number!");
//        int number = sc.nextInt();
//        int reversesum = 0,a;
//        a=number%10;
//        number=number/10;
//        reversesum=reversesum+a*10000;
//        a=number%10;
//        number=number/10;
//        reversesum=reversesum+a*1000;
//        a=number%10;
//        number=number/10;
//        reversesum=reversesum+a*100;
//        a=number%10;
//        number=number/10;
//        reversesum=reversesum+a*10;
//        a=number%10;
//        number=number/10;
//        reversesum=reversesum+ a*1;
//        System.out.println(reversesum);
//  FOR ANY INPUTS.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your  number!");
//        int number = sc.nextInt();
//        int reversesum = 0,a;
//        for(int i=number;number!=0;i--) {
//            a = number % 10;
//            number = number / 10;
//            reversesum = (reversesum) * 10 + a;
//        }// here is one bugs if 00001 ko reverse karte hai to ans 1 aayega blki 10000 aana chahiye.

//        System.out.println(reversesum);

        //PROBLEM -->(c)

        // If the angle given then we can use this formula Area=1/2*base*height.
        // But now in this case we have only given the length of triangle then we can use
        // this formula  Area = root of s(s-a)*(s-b)*(s-c). where s = a+b+c/2.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the length of three sides of triangle on by on assuming a,b,c.");
//        int a =sc.nextInt();
//        int b =sc.nextInt();
//        int c =sc.nextInt();
//        float  sum =a+b+c;
//
//        float s =sum/2;
//
//        float result = s*(s-a)*(s-b)*(s-c);
//       //double area = Math.pow(result,1/2.0f);//or
//       double area = Math.sqrt(result);// double isliye ki decimal value aur kam ho jayegi.
//        System.out.println("Area of triangle is = "+area);

        // PROBLEM --> (d)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter cartesian co-ordinates (x,y) one by one");
//        int x= sc.nextInt();
//        int y=sc.nextInt();
//        double r = Math.sqrt((x*x) + (y*y));
//        float degrees = y/x;
//        double fie = Math.toRadians(degrees);// kyoki hamre pass to ek integer value hai jo degree nhi hai.
//       // double tanValue = Math.tan(fie);// ye tan(fie) ke liye hai.
//
//        double tanIvalue = Math.atan(fie);
//        System.out.println("Polar co-ordinates ("+r*Math.cos(tanIvalue)+","+r*Math.sin(tanIvalue)+")");

        // PROBLEM --> (e)

//         Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your value of longitude and latitude in radion. ");
//         float l1 = sc.nextFloat();
//        float l2 = sc.nextFloat();
//        float g1 = sc.nextFloat();
//        float g2 = sc.nextFloat();
//        double degl1 = Math.toDegrees(l1);
//        double degll2 = Math.toDegrees(l2);
//        double degg1 = Math.toDegrees(g1);
//        double degg2 = Math.toDegrees(g2);
//        double difblongitude = degg2-degg1;
//        // Formula For Distance in Nautical Miles
//        //D = 3963 * acos( sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 – lon1) )
//       double D = 3963 * Math.acos( Math.sin(l1) * Math.sin(l2) + Math.cos(l1) * Math.cos(l2) * Math.cos(difblongitude) );
//        System.out.println("Distance between two city in nautical miles is = "+D);

        //  PROBLEM -->(f)

//          Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the velocity of wind meter per hour.");
//          float v= sc.nextFloat();
//        System.out.println("Enter the value of temperature in celsius.");
//        float temp = sc.nextFloat();
//        double wcf = 35.74+0.6215*temp + (0.4275*temp - 35.75)* Math.pow(v,0.16f);
//        System.out.println("Wind chill factor = "+wcf);

        // PROBLEM --> (g)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your angle in degrees");
//        double deg = sc.nextDouble();
//        System.out.println(Math.sin(deg));
//        System.out.println(Math.cos(deg));
//        System.out.println(Math.tan(deg));

        // PROBLEM -->(h)
          // Swapping two value using third variable.
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of C");
//        int C = sc.nextInt();
//        System.out.println("Enter the value of D");
//        int D = sc.nextInt();
////        int temp;
////        temp=C;
////        C=D;
////        D=temp;
////        System.out.println("Value after swapping = "+"(C="+C+" , D="+D+")");
//        C=C+D;
//        D=C-D;
//        C=C-D;
//        System.out.println(C+","+D);

        // PROBLEM -->(i)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of N!");
//        int N = sc.nextInt();
//         int count,result=0;
//        // notes we have = 1,2,5,10,50,100.
//       count = N/100;
//       result+=count;
//       N= N-(count*100);
//        System.out.println("required note of Rs. 100 is = "+count);
//        count = N/50;
//        result+=count;
//        N= N-(count*50);
//        System.out.println("required note of Rs. 50 = "+count);
//        count = N/10;
//        result+=count;
//        N= N-(count*10);
//        System.out.println("required note of Rs. 10 = "+count);
//        count = N/5;
//        result+=count;
//        N= N-(count*5);
//        System.out.println("required note of Rs. 5 = "+count);
//        count = N/2;
//        result+=count;
//        N= N-(count*2);
//        System.out.println("required note of Rs. 2 = "+count);
//        count = N/1;
//        result+=count;
//        N= N-(count*1);
//        System.out.println("required note of Rs. 1 = "+count);
//        System.out.println("So the total minimum number of required notes is = "+result);
    }
}
