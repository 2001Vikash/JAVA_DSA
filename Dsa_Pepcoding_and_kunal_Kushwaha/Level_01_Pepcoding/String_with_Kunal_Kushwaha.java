package Level_01_Pepcoding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class String_with_Kunal_Kushwaha {
    public static void main(String[] args) {
      // String name = "Vikash Yadav";
       // In java everything which is start with capital letter is known as class.
        // so here Sting is a data type and "name" is a reference variable and "Viaksh Yadav"  is an Object.
        // Sting pool --> it is a separate memory structure inside the Heap. means if we make two variable
                       // for a same object then there is no any heap space for second variable means
                       // it is also pointed to first pointing heap that means same pool.
                     // means it says that there is already exists a type of object point it.
        // for ex. String name1 = "VY"; and String name2 = "VY". that means both will point same pool which consists 'VY'.
        // If we change in 'VY' or modify it then it will never change because String is IMMUTABLE(for security reasons for ex password)
        // in JAVA. if we want to modify then we will need to make new Object.
       // System.out.println(name);
//        String str = "Vikash";
//        System.out.println(str);
//        str = "Yadav";// so here we did not change str object here we made a new Object again. that's why it will work.
//        System.out.println(str);


        // Comparison of Strings.

//     String a = "Vikash";
//     String b = "Vikash";
//        System.out.println(a == b);
//        // so checks if reference variable are pointing to same Object.

        // How to create different Object of same value?

//        String a = new String("Vikash");
//        String b = new String("Vikash");
//        // Creating these values outside the pool but in the heap.
//        System.out.println(a == b);// thsat's he will give false.
        // we need to use '==' as .equals().
       // System.out.println(a.equals(b));// but here only checking value not reference. because .equals is a method
        // but == is a comparator. means it will give true.

        // Output

//        String a = null;
//        System.out.println(a);
//        System.out.println(new int[] {1,2});// here java will confuse that which type of object you want because there are
//        // many objects that's why it will give us random value.
//        // if we want to print it then we can like this
//        System.out.println(Arrays.toString(new int[] {1,2}));
//        int n = 10;
//        System.out.println(n);// here .toString will not work
//        // but same thing we can do it like as
//        Integer num = new Integer(10);// here we are using some rapper class.
//        System.out.println(num.toString());



        //  PRETTY PRINTING


//        float a = 453.12745f;
//        System.out.printf("Formatted number is %.2f\n" , a);// it will give ans in rounding of.
//
//        // value of pi
//        System.out.println(Math.PI);
//        System.out.printf("Pie : %.3f%n" , Math.PI);// %n is also for newLine
//        System.out.printf("Hello my name is %s and I am %s" , "Vikash" , "Good");


        // Operators

        //  '+' Operator works as operator overload. to support string concat in java.
//        System.out.println('a' + 'b');// it will add ascii value of this.
//        System.out.println("a" + "b");// but in string concat ho jayega and here operator '-' will not apply only for '+'.
//        System.out.println('a' + 3);// but in character it will add ascii value.
//        System.out.println((char)('a' + 3));
//        System.out.println("a" + 1);
        // this is same as after a few steps : "a" + "1".
        // integer will be converted to Integer that will call toString().

    //    System.out.println("Vikash" + new ArrayList<>());// object that will call toString() that means simple concat

        // It's very important.

      // System.out.println(new Integer(56) + new ArrayList<>());
        // we can use many time primitive data types with operators
        // but if we to use complex object then anyone of them should be a String for ex.
     //   System.out.println(new Integer(56) + "It's mandatory for here" + new ArrayList<>());
         // and entire result will be as String.



        // Performance of String it's very important for interview.


//        String series = "";
//        for(int i = 0; i < 26; i++){
//            char ch = (char)('a' + i);
//            System.out.print(ch + " ");
//            series = series + ch;// but there is some problem that new object created every time like as ch.
            // because we know that string is immutable means we can't change original string .
            // so basically creating new object and coping old string and concat that's why so many memory wastage.
            // and they have also no reference variable. and space complexity is O(n^2) is so bad.
    //    }
      //  System.out.println(series);

        // What is the solution of this problem ??
        // Ans --> We need to use another Data Types because String will not allow us to change or modify.
                 // that's why we need to use a data types who allow us to modify things.

        // So that solution is StingBuilder data types it will allow to modify string .
        // It will do changes in only one object.



        // STRING BUILDER

//         StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < 26; i++) {
//            char ch = (char)('a' + i);
//            builder.append(ch);// this is mutable.
//        }
//        System.out.println(builder);
//        // we can also change this into String
//        System.out.println(builder.toString());
//        System.out.println(builder.reverse());



        // Methods in String.

//        String name = "Vikash Yadav";
//       // System.out.println(Arrays.toString(name.toCharArray()));
//        System.out.println(name.toLowerCase());// it will not change original string Because String is immutable.
//        System.out.println(name);
//        System.out.println("  Vikku  ".strip());
//        String str = "Hello my name is Vikku you know";
//        System.out.println(Arrays.toString(str.split(" ")));


        // String palindrome

//        String str = "abcbb";
//        boolean flag = false;
//        for(int i = 0; i < str.length()/2; i++){
//            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
//                flag = false;
//                break;
//            }
//            flag = true;
//        }
//        if(flag){
//            System.out.println("Palindrome");
//        }else{
//            System.out.println("Not Palindrome");
//        }
    }
}
