package Level_01_Pepcoding;

public class Introduction_to_Number_System_and_Conversion {
    public static void main(String[] args) {
        // Conversion of Decimal to any Base
//        int number = 634;
//        int base = 8;
//        int ans =0;
//        int res=0;
////        for(int i=number; number!=0; number=number/base){
////            int rem = number%base;
////            ans=ans*10+rem;
////        }
////       for(int i=ans; ans!=0; ans=ans/10){
////           int r = ans%10;
////           res = res*10+r;
////       }
////        System.out.println(res);
//        // using only one loop.
//        int p=1;// is nothing but 10^0=1.
//        for(int i=number; number!=0; number=number/base){
//            int rem = number%base;
//            ans = ans+rem*p;
//            p=p*10;
//        }
//        System.out.println(ans);

        // Any base to decimal.
//        int number = 634;
//        int inputBase =8;
//        int outputBase=10;
//        int ans =0;
//        int p=1;
//        while(number>0){
//            int rem = number%outputBase;
//            ans = ans + rem*p;
//            p=p*inputBase;
//            number=number/outputBase;
//        }
//        System.out.println(ans);

        // Any Base to any base. --> isme pahle decimal me phir use destination me.

        // Any base to decimal.
        int number = 172;
        int inputBase =8;

        int ans =0;
        int p=1;
        while(number>0){
            int rem = number%10;
            ans = ans + rem*p;
            p=p*inputBase;
            number=number/10;
        }
        int dest = ans;
        // Decimal to any base.
        int p2 = 1;
        int res = 0;
        int outputBase = 2;
        for(int i=dest; dest!=0; dest=dest/outputBase){
            int r=dest%outputBase;
            res+=r*p2;
            p2*=10;
        }
        System.out.println(res);// that is any base to any base.
    }

}

