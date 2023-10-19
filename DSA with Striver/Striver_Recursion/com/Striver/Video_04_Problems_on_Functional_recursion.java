package com.Striver;

public class Video_04_Problems_on_Functional_recursion {

    //  Reverse an array using recursion

//    public static void reverseArray(int [] arr,int i){
//        if(i== arr.length){
//            return;
//        }
//        reverseArray(arr , i+1);
//        System.out.print(arr[i] + " ");
//    }
//    public static void main(String[] args) {
//          int [] arr = {1,2,3,4,5};
//          reverseArray(arr,0);
//    }

    // reverse an array using swapping

//    public static void revArray(int [] arr ,int i) {
//        if (i == arr.length/2) {
//            return;
//        }
//        int temp = arr[i];
//        arr[i] = arr[arr.length-1-i];
//        arr[arr.length-1-i] = temp;
//        revArray(arr, i + 1);
//    }
//    public static void printArray(int arr[],int l){
//        for(int i=0;i<l;i++){
//            System.out.println(arr[i]);
//        }
//    }
//    public static void main(String[] args) {
//        int [] arr ={1,2,3,4,5};
//        revArray(arr,0);
//        printArray(arr,arr.length);
////        for(int i=0;i<arr.length;i++){
////            System.out.println(arr[i]);
////        } // so it is also work as printArray function
    // so kyo reverse array print ho rha hai kyoki humne array ko swap kr diya hai chunki in case of function ke paas
    // reference jata hai to waha se o change kr deta hai. aur har jagah same ho jata hai.
//
//    }

// Check a String is palindrome or not using recursion.


    // Time complexity O(n/2).


//    public static boolean checkPalindrome(String str, int i){
//        if(str.charAt(i) != str.charAt(str.length()-1-i)){
//            return false;
//        }
//        if(i==str.length()/2){
//            return true;
//        }
//        return checkPalindrome(str,i+1);
//    }
//    public static void main(String[] args) {
//        System.out.println(" Is is it Palindrome :: "+checkPalindrome("madam",0));
//    }
}
