package com.company;
import java.util.Scanner;
import java.lang.Math;
public class Ch_03_Kanetkar {
    public static void main(String[] args) {

        // PROBLEM --> (a)

//        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter the value of cost price");
//        float cost_price = sc.nextFloat();
//        System.out.println("Enter the value of selling price");
//        float selling_price = sc.nextFloat();
//        float profit,loss;
//        if(cost_price>selling_price){
//            loss= ((cost_price-selling_price)*100)/cost_price;
//            System.out.println("Seller is in Loss of "+loss+"%");
//        }
//        else{
//            profit=((selling_price-cost_price)*100)/cost_price;
//            System.out.println("Seller is in Profit of "+profit+"%");
//        }

        // PROBLEM --> (b)

//        Scanner sc= new Scanner(System.in);
//        System.out.println("Please Enter your number");
//        int num = sc.nextInt();
//        if(num%2==0){
//            System.out.println("Number is Even!");
//        }
//        else{
//            System.out.println("Number is Odd!");
//        }

        // PROBLEM --> (c)

//        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter the Year!");
//        int year = sc.nextInt();
//        if((year%4==0&&year%100!=0) || year%400==0 ){
//            System.out.println("Year is a Leap Year!");
//        }
//        else {
//            System.out.println("Year is not a Leap year! ");
//        }

        //  PROBLEM -->(d)

        // under process... need to learn gregorian calendar.

        //  PROBLEM --> (e)

//           Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of number of five digit!");// kisi bhi value ke loop lga skte hai.
//        int num = sc.nextInt();
//        int rem,sum=0,n=num;
//        rem = n%10;
//        sum =sum+rem*10000;
//        n=n/10;
//        rem = n%10;
//        sum =sum+(rem*1000);
//        n=n/10;
//        rem = n%10;
//        sum =sum+(rem*100);
//        n=n/10;
//        rem = n%10;
//        sum =sum+(rem*10);
//        n=n/10;
//        rem = n%10;
//        sum =sum+(rem*1);
//        n=n/10;
//        System.out.println(sum);
//        if(num==sum){
//            System.out.println("Equal!");
//        }
//        else{
//            System.out.println("Not Equal!");
//        }

        //  PROBLEM --> (f)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please Enter your age Ram");
//        int a = sc.nextInt();
//        System.out.println("Please Enter your age Shyam");
//        int b= sc.nextInt();
//        System.out.println("Please Enter your age Ajay");
//        int c = sc.nextInt();
//        if(a>b && a>c){
//            System.out.println("Ram is youngest!");
//        }
//        else if(b>c){
//            System.out.println("Shyam is youngest!");
//            }
//        else if(a==b&&b==c){
//            System.out.println("These are equal!");
//        }
//        else{
//            System.out.println("Ajay is youngest!");
//        }

        // PROBLEM --> (g)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the angle of triangle one by one in degree!");
//        int a= sc.nextInt();
//        int b= sc.nextInt();
//        int c= sc.nextInt();
//        int rule = a+b+c;
//        if(rule==180){
//            System.out.println("Its a valid Triangle!");
//        }
//        else {
//            System.out.println("Sorry! It is not a valid triangle");
//        }

        // PROBLEM --> (h)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number");
//        int n= sc.nextInt();
//        //  the distance from zero that a number is on the number line, without considering direction is called absolut value.
//        System.out.println("Absolute value of number is = "+Math.abs(n));
        // ya phir if else lgakr psitive ke liye +ve aur -ve ke +ve hi print karana hai.

        // PROBLEM --> (i)

//         Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the length and breadth of rectangle one by one in meters");
//        float l = sc.nextFloat();
//        float b = sc.nextInt();
//        float perimeter = 2 * (l + b);
//        float area = l * b;
//        if (perimeter > area) {
//            System.out.println("Perimeter is grater!");
//        } else if (area == perimeter) {
//            System.out.println("Both are Equal!");
//        } else {
//            System.out.println("Area is greater");
//
//        }

        //  PROBLEM --> (J)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of x1,y1");
//        int x1= sc.nextInt();
//        int y1=sc.nextInt();
//        System.out.println("Enter the value of x2,y2");
//        int x2= sc.nextInt();
//        int y2=sc.nextInt();
//        System.out.println("Enter the value of x3,y3");
//        int x3= sc.nextInt();
//        int y3=sc.nextInt();
//        float m1 = (y2-y1)/((x2-x1)*1.0f);
//        float m2 = (y3-y2)/((x3-x2)*1.0f);
//        float m3 = (y3-y1)/((x3-x1)*1.0f);
//        if(m1==m2&&m2==m3){
//            System.out.println("All three points fall on one straight line");
//        }
//        else{
//            System.out.println("No!");
//        }

        // PROBLEM -->(k)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of  centre quardnates x and y one by one ");
//        int x=sc.nextInt();
//        int y = sc.nextInt();
//        System.out.println("Enter the value of points  inside the circle");
//        int a=sc.nextInt();
//        int b= sc.nextInt();
//        System.out.println("Enter the value of radius");
//        int r = sc.nextInt();
//        double c= Math.pow(x-a,2)+Math.pow(y-b,2);
//         double D = Math.sqrt(c);
//         if(D>r){
//             System.out.println("Point is out of circle!");
//         }
//         else if(D<r){
//             System.out.println("Point is in circle!");
//         }
//         else{
//             System.out.println("Point is on the circle perimeter");
//         }

        //  PROBLEM --> (i)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the value of point  x and y one by one ");
//        int x=sc.nextInt();
//        int y = sc.nextInt();
//        if(x==0&&y==0){
//            System.out.println("Points lies on origin");
//        }
//        else if((x>0 || x<0)&&y==0) {
//            System.out.println("points on x-axis");
//        }
//        else if(x==0&&(y>0||y<0)){
//            System.out.println("points on y-axis");
//        }
//        else{
//            System.out.println("Not mention in program");
//    }
}
}
