// Program for printing Armstrong number.
// for example:: 123 = 1+8+27=36.
package com.vikash;
import java.util.Scanner;
public class By_me_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number");
        int num = sc.nextInt();
        int n=num;// taki num same bna rhe kyoki ab operation n ke sath hoga
        int sum=0, l;
        while (n!=0){
               l=n%10;
            sum = sum+(l*l*l);// Math.pow(l,3); // ye bhi use kr sakte hai
            n = n/10;
        }
        System.out.println(sum);// chunki yaha n=0 ho gya hai but num=input hi rahega.
        if(sum == num){
            System.out.println("Your numer is  Armstrong ");
        }
        else{
            System.out.println("Your number is not Armstrong");
        }
    }
}
