package com.ApnaCollege;

public class Video_06_Advance_Pattern {
//   static  class FACT{
//        public int f(int i){
//            if(i==0){
//                return 1;
//            }
//            return i*f(i-1);
//        }
//    }
    public static void main(String[] args) {
        // 1--> Home work problem Print a solid rhombus. Video-06-->11.
//        for(int i=1;i<=5;i++){
//            for(int j=1;j<=5-i;j++){
//                System.out.print("  ");
//            }
//            for(int k=1;k<=4;k++){
//                System.out.print("# ");
//            }
//            System.out.println("");
//        }

        // 2--> Home work problem Print a number pyramid.
//        int sum=1;
//        for(int i=1;i<=5;i++){
//            for(int k=1;k<=5-i;k++){
//                System.out.print(" ");
//            }
//            for(int j=1;j<=i;j++){
//                System.out.print(+sum+" ");
//            }
//            System.out.println("");
//            sum++;
//        }

        // 3--> Home work problem Print a palindromic number pyramid.


//        int n = 5;
//        for(int i=1; i<=n; i++) {
////spaces
//            for(int j=1; j<=n-i; j++) {
//                System.out.print(" ");
//            }
////first part
//            for(int j=i; j>=1; j--) {
//                System.out.print(j);
//            }
////second part
//            for(int j=2; j<=i; j++) {
//                System.out.print(j);
//            }
//            System.out.println();
//        }
//        for(int i=1;i<=5;i++){
//            for(int k=1;k<=5-i;k++){
//                System.out.print(" ");
//            }
//            for(int j=1;j<=i;j++){
//                System.out.print(j+"");
//            }
//            for(int l=i-1;l>=1;l--){
//                System.out.print(l+"");
//            }
//            System.out.println("");
//
//        }
//        for(int i=1;i<=5;i++){
//            for(int k=1;k<=5-i;k++){
//                System.out.print("  ");
//            }
//            for(int j=i;j>=1;j--){
//                System.out.print(j+" ");
//            }
//            for(int l=1;l<=i-1;l++){
//                System.out.print(l+1+" ");
//            }
//            System.out.println("");
//
//        }

        // 10--> Print the Butterfly Pattern
//        for(int i=1;i<=4;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print("* ");
//            }
//            for(int k=1;k<=4-i;k++){
//                System.out.print("    ");// two spaces ke jagah pr hum 2*(n-i) bhi kr sakte hai.
//            }
//            for(int l=1;l<=i;l++){
//            System.out.print("* ");
//            }
//            System.out.println("");
//        }
//        for(int i=4;i>=1;i--){
//            for(int j=1;j<=i;j++){
//                System.out.print("* ");
//            }
//            for(int k=1;k<=4-i;k++){
//                System.out.print("    ");
//            }
//            for(int l=1;l<=i;l++){
//                System.out.print("* ");
//            }
//            System.out.println("");
//        }

//        // Homework  2. Print a hollow Rhombus.
//
//        for(int i=1;i<=4;i++){
//            for(int k=1;k<=4-i;k++){
//                System.out.print(" ");
//            }
//            for(int j=1;j<=4;j++){
//                if(i==1||j==1||i==4||j==4){
//                    System.out.print("# ");
//                }
//                else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println("");
//        }
//        // Video -6--> Problem -5 in pdf
//
////        for(int i=1;i<=4;i++){
////            for(int k=1;k<=4-i;k++){
////                System.out.print("   ");
////            }
////            for(int j=1;j<=i;j++){// yaha pr yadi j<=2*i-1 karte hai to next loop nhi likhna padega
////                System.out.print("*  ");
////            }
////            for(int l=1;l<=i-1;l++){
////                System.out.print("*  ");
////            }
////            System.out.println("");
////        }
////        for(int i=4;i>=1;i--){
////            for(int k=1;k<=4-i;k++){
////                System.out.print("   ");
////            }
////            for(int j=1;j<=i;j++){
////                System.out.print("*  ");
////            }
////            for(int l=1;l<=i-1;l++){
////                System.out.print("*  ");
////            }
////            System.out.println("");
////        }
//
//        // Homework Problems  1. Print a hollow Butterfly.
//
//                for(int i=1;i<=4;i++){
//            for(int j=1;j<=i;j++){
//                if(j==1||j==i){
//                    System.out.print("*");
//                }else{
//                    System.out.print(" ");
//                }
//            }
//            for(int k=1;k<=4-i;k++){
//                System.out.print("  ");// two spaces ke jagah pr hum 2*(n-i) bhi kr sakte hai.
//            }
//            for(int l=1;l<=i;l++){
//                if(l==1||l==i){
//                    System.out.print("*");
//                }else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//        for(int i=4;i>=1;i--){
//            for(int j=1;j<=i;j++){
//                if(j==1||j==i){
//                    System.out.print("*");
//                }else{
//                    System.out.print(" ");
//                }
//            }
//            for(int k=1;k<=4-i;k++){
//                System.out.print("  ");
//            }
//            for(int l=1;l<=i;l++){
//                if(l==1||l==i){
//                    System.out.print("*");
//                }else{
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }

        /*
        3. Print Pascal’s Triangle.
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
         */
        // First Way to print Pascal's Triangle
//        for(int i=1;i<=5;i++){
//            int r=1;
//            for(int k=1;k<=5-i;k++){
//                System.out.print(" ");
//            }
//            for(int j=1;j<=i-1;j++){
//                r=r*11;
//
//            }
//            System.out.print(r);
//            System.out.println("");
//        }
        // Second Way..
        /*
         0C0
        1C0   1C1
     2C0   2C1   2C2
  3C0   3C1   3C2   3C3
         */

//        int n=4,i,j;
//        FACT g = new FACT();
//        for(i=0;i<=n;i++){
//            for(int k=0;k<=4-i;k++){
//                System.out.print(" ");
//            }
//            for(j=0;j<=i;j++){
//                System.out.print(" "+g.f(i)/(g.f(i-j)*g.f(j)));
//            }
//            System.out.println("");
//        }

        //  4. Print half Pyramid.
//        for(int i=1;i<=5;i++){
//            for(int k=1;k<=5-i;k++){
//                System.out.print(" ");
//            }
//            for(int j=1;j<=i;j++){
//                System.out.print(j+" ");
//            }
//            System.out.println("");
//        }

        // 5. Print Inverted Half Pyramid

//        int res=1;
//        for(int i=4;i>=1;i--){
//            for(int j=1;j<=i;j++){
//                System.out.print(res+" ");// ya phir i ko print kra de.
//            }
//            res++;
//            System.out.println("");
//        }
//        // last question --> Video 6 print diamond pattern problem
//        for(int i=1;i<=5;i++){
//            for(int k=1;k<=5-i;k++){
//                System.out.print("  ");
//            }
//            for(int j=1;j<=i;j++){// if we want to eluminate next loop so we can take j<=(2*i)-1
//                System.out.print("* ");
//            }
//            for(int l=i-1;l>=1;l--){
//                System.out.print("* ");
//            }
//            System.out.println("");
//        }
//        for(int i=5;i>=1;i--){
//            for(int k=1;k<=5-i;k++){
//                System.out.print("  ");
//            }
//            for(int j=1;j<=i;j++){
//                System.out.print("* ");
//            }
//            for(int l=i-1;l>=1;l--){
//                System.out.print("* ");
//            }
//            System.out.println("");
//        }
        // --> row daye se baye
        // column uper se niche
    }
}
