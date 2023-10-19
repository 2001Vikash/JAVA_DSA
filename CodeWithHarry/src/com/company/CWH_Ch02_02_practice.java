package com.company;



public class CWH_Ch02_02_practice {
    public static void main(String[] args) {
        //Encrypt
        char grade='B';//Which is real information
        //grade=grade+8 ye ek int value aayega kyoki char+int=int hota hai;//encrypting process
        grade=(char)(grade+8);//isse value char me hogi
        System.out.println(grade);
        //Decrypt
        System.out.println(grade-=8);// decrypting process
    }



}
