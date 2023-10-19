package com.ApnaCollege;

import java.util.HashSet;

public class Video_18_Recursion_02 {

    // Tower Of Hanoi
    // Time complexity of this code is O(2^n).

//    public static void towerOfHanoi(int n,String beg,String aux,String end){
//        if(n==1){
//            System.out.println("Move disk "+n+" from "+beg+" to "+end);
//            return;
//        }
//        towerOfHanoi(n-1,beg,end,aux);
//        System.out.println("Move disk "+n+" from "+beg+" to "+end);
//        towerOfHanoi(n-1,aux,beg,end);
//    }
//    public static void main(String[] args) {
//        int n=3;
//        towerOfHanoi(n,"A","B","C");
//    }

    // Print a string in reverse.
      // Time complexity O(n) this is equal to the length of the string
//    public static void reverseString(String str, int l){
//        if(l==-1){
//            return ;
//        }
//        System.out.print(str.charAt(l));
//        reverseString(str,l-1);
//    }
//    public static void main(String[] args) {
//        String str = "abcde";
//        int l = str.length();
//        reverseString(str,l-1);
//    }

    // Find the first and last occurance of an element in string
     // Time Complexity O(n) where n is length of string
//    public static int first=-1;
//    public static int last = -1;
//    public static void printOcc(String str, int ind, char element){
//        if(ind ==-1){
//            System.out.println("First Ocuurance is : "+first);
//            System.out.println("Last Occurance is : "+last);
//            return;
//        }
//        if(str.charAt(ind)==element){
//            if(last==-1){
//               last = ind;
//            } else{
//               first = ind;
//            }
//        }
//        printOcc(str,ind-1, element);
//    }
//    public static void main(String[] args) {
//        String str = "abcaad";
//        int ind = str.length();
//        char element = 'a';
//        printOcc(str,ind-1, element);
//      //  System.out.println(first);
//       // System.out.println(last); // static means kahi se bhi call kre same rahega means constant rahega
//    }

    // check if an array is sorted (Strictly increasing) means 1,2,3,4,4 is not sorted because it's not in strictly increasing
   // Time Complexity O(n) n is length of array
//    public static boolean isSorted(int [] arr ,int ind) {
//        if(ind == arr.length-1){
//            return true;
//        }
//        if(arr[ind]>=arr[ind+1]){// ya phir arr[ind]<arr[ind+1] kr sakte hai isme = nhi lagana padega
//            return false;
//        }
//        return isSorted(arr,ind+1);
//    }
//        public static void main (String[]args){
//            int[] arr = {1, 2, 3, 4, 4, 5};
//            System.out.println(isSorted(arr,0));
//      }

    // Move all 'x' to the end of the string
    // TIme complexity O(n+count) if count max value is n the ans = O(n). where n is length of string

//    public static void moveX(String str,String newString,int ind,int count){
//        if(ind == str.length()){
//            for(int i=1;i<=count;i++){
//                newString = newString + 'x';
//
//            }
//            System.out.println(newString);
//            return;
//        }
//        if(str.charAt(ind)=='x'){
//            count++;
//        } else{
//            newString = newString + str.charAt(ind);
//        }
//        moveX(str,newString,ind+1,count);
//    }
//    public static void main(String[] args) {
//        String str = "axbcxxd";
//        String newString = "";
//        moveX(str,newString,0,0);
//    }

    // Remove Duplicates from string
    // Time Complexity O(n)

//    public  static boolean [] map = new boolean[26];// isame bidefault false liya hai
//    public static void removeDuplicates(String str , int ind , String newStr){
//        if(ind == str.length()){
//            System.out.println(newStr);
//            return;
//        }
//        if(map[str.charAt(ind) - 'a'] == false){
//            newStr += str.charAt(ind);
//           map[str.charAt(ind) - 'a'] = true;
//        }
//        removeDuplicates(str,ind+1,newStr);
//    }
//
//    public static void main(String[] args) {
//       // System.out.println('z'-'a'); gives us 25-0=25 position ko minus krta hai
//        removeDuplicates("abbcbdcda",0,"");
//    }

// Print the all subsequences of a string (Very Important Question). We need to learn this.
// subsequences means --> order nhi change hona chahiye aur har ek element ke 2 choice hai ki o anna chahta hai ya nhi.
    // for ex abc ke subsequences are abc,ab,bc,ac,a,b,c
     // Time Complexity O(2^n)
    public static void subsequnces(String str, int ind, String newStr){
        if(ind == str.length()){
          System.out.println(newStr);
            return ;
        }
        // to be
        subsequnces(str,ind+1,newStr+str.charAt(ind));
        // if not to be
        subsequnces(str,ind+1,newStr);
    }
    public static void main(String[] args) {
       subsequnces("abc",0,"");
    }

    // To solve exception case like as "aaa" we use HashSet. For unique subsequences.

//        public static void subsequnces(String str, int ind, String newStr,HashSet<String> set){
//        if(ind == str.length()){
//            if(set.contains(newStr)){
//                return;
//            } else{
//                System.out.println(newStr);
//                set.add(newStr);
//                return;
//            }
//        }
//        // to be
//        subsequnces(str,ind+1,newStr+str.charAt(ind),set);
//        // if not to be
//        subsequnces(str,ind+1,newStr,set);
//    }
//    public static void main(String[] args) {
//        HashSet<String> set = new HashSet<String>();// because hashset set ki trh distinct value save krta hai
//       subsequnces("aaa",0,"",set);
//    }

  // Print key combination for keypad mobile phones.
/*
0--> .
1--> abc
2--> def
3--> ghi
4--> jkl
5--> mno
6--> pqrs
7--> tu
8--> vwx
9--> yz
 */
// Time complexity O(4^n) because of pqrs have maximum length
//    public static String [] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
//    public static void printComb(String str,int ind, String combination){
//        if(ind == str.length()){
//            System.out.println(combination);
//            return;
//        }
//        char currentChar = str.charAt(ind);
//        String mapping = keypad[currentChar-'0'];
//        for(int i=0; i<mapping.length(); i++){
//            printComb(str,ind+1,combination + mapping.charAt(i));
//        }
//    }
//    public static void main(String[] args) {
//        printComb("23",0,"");
//    }
}