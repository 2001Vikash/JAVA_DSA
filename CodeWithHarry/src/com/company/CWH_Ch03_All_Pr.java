package com.company;

public class CWH_Ch03_All_Pr {
    public static void main(String[] args) {

        // problem 1
       // String str = "VIKASH YADAV";
       // String str1 = str.toLowerCase(Locale.ROOT);
       // System.out.println(str1); or
       // str = str.toLowerCase(Locale.ROOT);
       // System.out.println(str);

        // problem 2
      // String text = "My name is Vikash";
      // text=text.replace(" ","_");
        // yaha pr existing string ko change nhi kra ja rha yaha pr variable ko hi update kr diya .
      // System.out.println(text);

        //Problem 3
      //  String letter = "Dear |<name>| , Thanks a lot!";
        // yha name ko is trh likhne ka mtlb hai use replace krna hai aur kuchch nhi.
            //     String letter1 = letter.replace("|<name>|","Vikash Yadav");
               //          System.out.println(letter1);

        // Problem 4
        //String myString = "Here is  Duble space and here is tripple space";
      //  System.out.println(myString.indexOf("  "));
       // System.out.println(myString.indexOf("   "));
        // and if  required spaces are not presented then printed value is -1.

        String myLetter = "Dear Vikash, \n\t This Java cource is nice. \n\t\tThanks!";
        System.out.println(myLetter);
    }
}
