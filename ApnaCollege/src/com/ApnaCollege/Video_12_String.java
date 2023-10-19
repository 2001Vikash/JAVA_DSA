package com.ApnaCollege;



import java.util.Scanner;

public class Video_12_String {
    public static void main(String[] args) {
        // String Declaration
//        String name="Vikash";
//        String fullName=" Vikash Yadav";
//        String sentence=" My name is Vikash Yadav";
//        System.out.println(name+fullName+sentence);

        // Taking Inputs by user
//        Scanner sc= new Scanner(System.in);
//        String name=sc.nextLine();// kewal next se kewal ek word lega aur isase pura sentence.
//        System.out.println(name);

        // Concatenation
//        String firstName="Vikash"+" "+"Ye memory me nhi rahega statement run hone ke baad automatic remove ho jayega";
//        String lastName="Yadav";
//        String fullName=firstName+" "+lastName;
//        System.out.println(fullName);
//        // length methods--> it gives the length of strings including spaces.
//        System.out.println(fullName.length());
//        for(int i=0;i<lastName.length();i++){
//            System.out.println(lastName.charAt(i));
//        }
        // Comparing of two Strings..
        String str = "Vikku";
        String str1 = "Vikku";
        /*
        .compareto function gives
        s1>s2: return a +ve value koi bhi
        s1==s2: return 0.
        s1<s2: return a -ve value. koi bhi
         */
//        if (str.compareTo(str1)==0){
//            System.out.println("Strings are Equal");
//        }
//        else{
//            System.out.println("Strings are not Equal");
//        }
///* alphabet me a b se pahel aata hai to a small hoga b se isi trh comare karke string -ve ya +ve value deta hai.
//         for example hello < wello kyoki h jo hai w se pahle aata hai to chhota ho jayega
//        aur small alphabet bda hota hai capital letter se in java */
//        System.out.println(str.compareTo(str1));
//        if(str==str1){
//            System.out.println("Equal");
//        }else{
//            System.out.println("Not Equal");
//        }
//        if(new String("yadav")==new String("yadav")){// ye non-primitive type ka string declaration hai
//            // to yaha pr == fail ho gya isiliye iska use nhi karte hai hai kyoki ye kae sari cases me stuck ho jata hai
//            // issiliye comareTo ka use karte hai
//            // aur ek reason hai ki in java Strings are Objects.
//            System.out.println("==");
//        }else{
//            System.out.println("!=");
//        }

        // Substrings
//        String sentence="My name is Vikash";
//        // substring(start index, last index) with exclude last index means last wale ek kam tk.
//        String name=sentence.substring(11,sentence.length());// last wala nhi denge to bydefault le lega.
//        System.out.println(name);
//        String name1="My name is Vikkuu";
//        String name3=name1.substring(11,name1.length()-1);
//        System.out.println(name3);
        // Parsing kahi aur se learn krna hai.

        /* Strings are immutable
        means ek bar koi string bn gayi to use hum change nhi kr sakte hai,modify nhi kar sakte hai,
        delete ya koi operation nhi kar sakte hai.
        ydi usme kuchh bhi changes lane hai to humko ek nayi string banani padegi.
         */


        // Homework Problem-1

//        Scanner sc =new Scanner(System.in);
//        System.out.println("Please enter the size of array");
//        int size=sc.nextInt();
//        String [] arr= new String[size];
//        System.out.println("Please enter your element of array");
//        int sum=0;
//        for(int i=0;i<size;i++){
//            arr[i]=sc.nextLine();// nextLine wale me confusion hai. kyoki kahi bhi nextLine use nhi hua hai array ke case me
//
//            sum=sum+ arr[i].length();
//        }
////        int sum=0;
////        for(int i=0;i<size;i++){
////            sum=sum+ arr[i].length();
////        }
//        System.out.println("Cumulative length of all strings is : "+sum);

        // Homework Problem-2

//        Scanner sc= new Scanner(System.in);
//        String old=sc.nextLine();
//        String result="";
//        for(int i=0;i<old.length();i++){
//            if(old.charAt(i)=='e'){
//                result+='i';
//            }else{
//                result+=old.charAt(i);
//            }
//        }
//        System.out.println("New Striing :: "+result);

        // Homework Problem-3

//        Scanner sc= new Scanner(System.in);
//        String old=sc.nextLine();
//        String result="";
//        for(int i=0;i<old.length();i++){
//            if(old.charAt(i)=='@'){
//                break;
//            }else{
//                result+=old.charAt(i);
//            }
//        }
//        System.out.println("user name :: "+result);
    }
}
