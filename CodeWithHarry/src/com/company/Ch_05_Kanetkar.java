package com.company;
import java.util.Scanner;
public class Ch_05_Kanetkar {
    public static void main(String[] args) {

        // problem --> (a)

//          int emp = 10;
//          int work_time = 40,over_time=2;
//          for(int i=1;i<=10;i++) {
//              if (work_time+over_time > 40) {
//                  system.out.println("this is for "+i+" man");
//                  system.out.println("base salary "+work_time*12+" overtime "+over_time*12);
//              }
//              else {
//                  system.out.println("this is for "+i+" man");
//                  system.out.println("you have only your base salary =" + work_time * 12);
//              }
//          }

        // problem -->(b)

//     Scanner sc=  new Scanner(System.in);
//        System.out.println("Enter your number");
//        int n=sc.nextInt();
//        int fact =1;
//        for(int i=1;i<=n;i++){
//            fact = fact*i;
//        }
//        System.out.println(fact);

        // PROBLEM -->(c)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the both value one by one");
//        int a=sc.nextInt();
//        int b=sc.nextInt();
////       double c= Math.pow(a,b);
////        System.out.println(c);
//        int pow = 1;
//        for(int i=1;i<=b;i++){
//            pow = pow*a;
//        }
//        System.out.println(pow);

        // PROBLEM -->(d)
//        int i=0;
//        while (i<=255){
//            System.out.println("The ASCII value of "+(char)i+" = "+i);// char i means integer ki character value
//            i++;
//        }

//        for(int i=0;i<=255;i++){
//            System.out.println("The ASCII value of "+(char)i+" = "+i);// char i means integer ki character value
//        }
//        char ch1 = 'a';
//        int ascii = ch1;
//        System.out.println("ASCII of a is = "+ascii);

        // PROBLEM -->(e)

        //  int sum =0; yaha rakhenge to value bar bar 0 nhi hogi to har number chechk nhi ho payega
//      for(int i=1;i<=500;i++){
//          int n=i,sum=0;
//          for(int j=n;j!=0;j--){
//              sum=sum+((n%10)*(n%10)*(n%10));
//              n=n/10;
//          }
//          if(i==sum) {
//              System.out.println("Armstrong =" + sum);
//          }
//      }

        // PROBLEM -->(f)

        // now in mode of continue.....

        // PROBLEM -->(g)

//        Scanner sc = new Scanner(System.in);
//        int count_pos=0,count_neg=0,count_0=0;
//        int i=5;
//        while(i!=0){
//            System.out.println("If you want to exit please press 's' and want to continue then press 'n'");
//            char b =sc.next().charAt(0);
//            if(b=='s'){
//                break;
//            }
//            else {
//                int n= sc.nextInt();
//                if(n>0){
//                    count_pos+=1;
//                }
//                else if(n<0){
//                    count_neg+=1;
//                }
//                else {
//                    count_0+=1;
//                }
//            }
//
//        }
//        System.out.println("Pressing zero's by user = "+count_0);
//        System.out.println("Pressing positive numbers by user = "+count_pos);
//        System.out.println("Pressing negative numbers by user = "+count_neg);

        // PROBLEM --> (h)

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the integer value");
//        int n = sc.nextInt();
//        int rem,reverse=0, m = 0,a;
//
//        for (int i = n; n != 0; i--) {
//            rem = n % 8;
//            n = n / 8;
//            // System.out.print(rem);// its reverse value gives us octal value of an integer.//
//            m=m*10+rem;
//        }
//        //System.out.println(m);
//
//          for(int j=m;m!=0;j--){
//              a=m%10;
//              m=m/10;
//              reverse = reverse*10 +a;
//          }
//        System.out.println(reverse);

         //  PROBLEM -->(i)

        Scanner sc  = new Scanner(System.in);
        System.out.println("Please enter the five set of no. one by one in integer");
        int a =sc.nextInt();
        int b =sc.nextInt();
        int c =sc.nextInt();
        int d =sc.nextInt();
        int e =sc.nextInt();
        int big,small;
        if(a>b&&a>c&&a>d&&a>e){
            System.out.println("Big number is = " +a);
            big =a;
        }
        else if(b>c&&b>d&&b>e){
            System.out.println("Big number is = "+b);
            big =b;
        }
        else if(c>d&&c>e){
            System.out.println("Big number is = "+c);
            big=c;
        }
        else if(d>e){
            System.out.println("Big number is = "+d);
            big=d;
        }
        else {
            System.out.println("Big number is = "+e);
            big=e;
        }
        if(a<b&&a<c&&a<d&&a<e){
            System.out.println("Small number is = " +a);
            small=a;
        }
        else if(b<c&&b<d&&b<e){
            System.out.println("Small number is = "+b);
            small=b;
        }
        else if(c<d&&c<e){
            System.out.println("Small number is = "+c);
            small=c;
        }
        else if(d<e){
            System.out.println("Small number is = "+d);
            small=d;
        }
        else {
            System.out.println("Small number is = "+e);
            small=e;
        }
        System.out.println("Range is big-small = "+(big-small));
    }
}

