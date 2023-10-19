package Level_01_Pepcoding;

public class Mathematical_Operation_in_Number_System {
    //  public static void main(String[] args) {

    // Any Base Addition.

//        int n1=236;
//        int n2=754;
//        int base =8;
//        int ans=0;
//        int carry=0;
//        int p=1;
//        while(n1>0 || n2>0 || carry>0){
//            int r1 = n1%10;
//            int r2 = n2%10;
//            int res  = r1 + r2 + carry;
//            int r3 = res%base;
//             carry = res/base;
//            ans = ans + r3*p;
//            p=p*10;
//            n1=n1/10;
//            n2=n2/10;
//
//        }
//        System.out.println(ans );// ans is also in given base.

    // Any Base Subtraction

//        int n1=1212;
//        int n2=236;
//        int base =8;
//        int p=1;
//        int ans=0;
//        int r1=0,r2=0,r=0;
//        int borrow =0;
//        while(n1>0){
//             r1 = n1%10-borrow;
//             r2 = n2%10;
//            if(r1 >= r2){
//               r = r1-r2 ;
//               ans+=r*p;
//            }
//            else{
//                r1=r1+base;
//                int k = r1-r2;
//                borrow=1;
//                ans+=k*p;
//            }
//            p*=10;
//            n1=n1/10;
//            n2=n2/10;
//        }
//        System.out.println(ans);


    // Any Base Multiplication.


//    public static int multiplicationWithSingleDigit(int n1, int n2r1, int base){
//        int p=1;
//        int s=0;
//       int c=0;
//        while (n1>0 || c>0){
//            int n1r1 = n1%10;
//            int m = n1r1*n2r1+c;
//            c=m/base;
//            int r = m%base;
//            s+=r*p;
//            p*=10;
//            n1=n1/10;
//        }
//        return s;
//    }
//    public static int sum(int a, int b, int base){
//        int sum =0;
//        int f=1,c=0;
//        while(a>0 || b>0 || c>0){
//            int r1 = a%10;
//            int r2 = b%10;
//            int d = r1+r2+c;
//            c=d/base;
//            int k = d%base;
//            sum+=k*f;
//            f*=10;
//            a=a/10;
//            b=b/10;
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int n1=234;
//        int n2=74;
//        int base=8;
//        int p=1;
//        int ans=0;
//      while(n2>0){
//          int n2r1 = n2%10;
//          int res1 = multiplicationWithSingleDigit(n1,n2r1,base);
//          ans = sum(ans, res1*p , base);
//          p*=10;
//          n2=n2/10;
//      }
//        System.out.println(ans);
//    }

    // Division is like that normal but we need to check ans is in given base or not.
}





