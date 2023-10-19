package com.company;

public class CWH_31_Methods {
//    static int logic(int x, int y){// int x, int y is optional.
//         int  z;
//         if(x>y){
//             z = x+y;
//         }
//         else{
//             z=(x+y)*5;
//         }
//         return z;
//    }
//    public static void main(String[] args) {
//        int a=5,b=6,c;
//        c = logic(a,b);
//        System.out.println(c);
//        int a1=2,b1=1,c1;
//        c1 = logic(a1,b1);
//        System.out.println(c1);
//    }
    // NOW WE HAVE ALSO AN OTHER METHOD TO CALLING METHOD. THAT MEANS WITHOUT STATIC WITH MAKING OBJECT.
//    int logic(int x, int y) {
//        int z;
//        if (x > y) {
//            z = x + y;
//        }
//        else{
//            z= (x+y)*5;
//        }
//        return z;
//    }
//public static void main(String[] args) {
//          CWH_31_Methods obj = new CWH_31_Methods();// ITS NEW OBJECT.
//     int a=5,b=6,c;
//       c= obj.logic(a,b);
//          int a1=2,b1=1,c1;
//       c1= obj.logic(a1,b1);
//    System.out.println(c);
//    System.out.println(c1);
//
//}
    int sum(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        CWH_31_Methods call = new CWH_31_Methods();
        int c= call.sum(2,3);
        System.out.println(c);
    }
}