package com.ApnaCollege;

import java.util.Scanner;

public class Video_15_Bit_Manipulation {
    public static void main(String[] args) {
  //      System.out.println(2<<1);// Left Shift  yha 2 binary number ka work karega aur 1 kitni bar.
        // left shift me ydi msb 1 hai to for ex 100 ka left shift 1000 hoga jabki rule se 000 hona chahiye. doubt hai
        // doubt clear ho gya left shift me puri value left ki trf jati hai aur right me ek 0 lg jata hai bs.
    //   System.out.println(5>>1);// Right shift but isme last me one hai to remove ho ja rha hai

        // Get Bit --> means to check in a given binary number at a position bit is 0 or 1.
        // first step is that we need to make bit mask like as 1<<position and again bit mask ke sath &(and) operation
        // krayenge if non zero value aati hai to bit 1 tha aur ydi zero aati hai to bit 0 tha.
//        int n=5;
//        int pos=2;// imp thing is that position indexing is counting from Right to Left.
//        int bitMask=1<<pos;
//        if((bitMask & n)==0){
//            System.out.println("Bit was '0' ");
//        }else{
//            System.out.println("Bit was '1' " );
//        }

        // Set Bit --> set only 1 at a given position in any binary number if 1 is already then no problem.
        // here is also use concept of bitmask.
        // and perform |(or) operation between bitmask and n.
//        int n=5;
//        int pos=1;
//        int bitMask=1<<pos;
//        int result = bitMask | n;
//        System.out.println(result);

        // Clear Bit --> In any Binary number at any position we can change bits as 0 only with the help of clear bit.
        // first step is that bitmask concept
        // and second step is that perform an operation n and(&) with ~(not)bitmask.
//        int n=5;
//        int pos=2;
//        int bitMask=1<<pos;
//        int newNumber=((~bitMask) & n);
//        System.out.println(newNumber);

        // Update Bit --> yaha diya jayega ki 0 ko 1 banana hai ya 1 ko 0 .
        // set bit and clear bit dono ka use krenge.
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter your bit in which you want to update at a position");
        int bit =sc.nextByte();
        int n=5;
        int pos=2;
        int bitMask = 1<<pos;
        if(bit==0|| bit==1){
            if(bit==0){
                // means clear operation
                int newNumber=(~bitMask) & n;
                System.out.println(newNumber);
            }else {
                // means set operation
                int newNumber= bitMask | n;
                System.out.println(newNumber);
            }
        }else{
            System.out.println("Oops in binary number system has only two bits that is 0 and 1. PLease press right key");
        }
    }
}
