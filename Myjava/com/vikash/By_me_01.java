package com.vikash;
import java.util.Scanner;
public class By_me_01 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter the temperature of your water");
        float temp = sc.nextFloat();// Here 37.0 degree centigrade is the normal body temperature
        if( temp<=(37.0f+7) && temp>=(37.0f-7)){
            System.out.println("Yes water is perfect for Human body");
        }
        else{
            System.out.println("No water is not perfect for Human body");
        }
    }
}
