package Level_01_Pepcoding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Recursion_Permutation_with_KK {

    // Permutation means if we have a String like that abc -> then permutation abc,acb,bca,bac,... like that
    // here we need a for loop to use for variable number of function calls which is depends on size of processed String + 1.

    // Substring

//    public static void main(String[] args) {
//        String str = "Vikash";
//        System.out.println(str.substring(3));// here beginIndex is inclusive and length of string is exclusive
//        System.out.println(str.substring(0,str.length()));// same like above
//        System.out.println(str.substring(1,4));// here 1 is inclusive and 4 and 4 is exclusive
//        System.out.println(str.substring(0,0)); // means 0 inclusive and 0 is also exclusive then overall result is 0 taken as exclusive
//
//        //  *** Note ->  means in substring beginIndex is inclusive and lastIndex is exclusive
//    }

    public static void main(String[] args) {
        String str = "abc";
      //  permutation("", str);
//        ArrayList<String> ans = permutation2("" , str);
//        Collections.sort(ans);
//        System.out.print(ans);
        System.out.println(permutationSorted(new ArrayList<>(), "", str));

      //  System.out.println(permutationCount2(0,"" , str));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+ " ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
            permutation(first + ch + second, up.substring(1));

        }
    }
    static ArrayList<String> permutation2(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
           ArrayList<String> ans =  permutation2(first + ch + second, up.substring(1));
           list.addAll(ans);
        }
        return list;
    }
    static ArrayList<String> permutationSorted(ArrayList<String> list, String p, String up){

        if(up.isEmpty()){
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i, p.length());
            permutationSorted(list,first + ch + second, up.substring(1));
        }
        return list;
    }
//    static int permutationCount(String p, String up){
//        if(up.isEmpty()){
//            return 1;
//        }
//        char ch = up.charAt(0);
//        int count = 0;
//        for (int i = 0; i <= p.length(); i++) {
//            String first = p.substring(0,i);
//            String second = p.substring(i, p.length());
//
//            count += permutationCount(first + ch + second, up.substring(1));
//
//        }
//        return count;
//    }
//    static int permutationCount2(int count, String p, String up){
//        if(up.isEmpty()){
//            return 1;
//        }
//        char ch = up.charAt(0);
//
//        for (int i = 0; i <= p.length(); i++) {
//            String first = p.substring(0,i);
//            String second = p.substring(i, p.length());
//
//            permutationCount2(count+1,first + ch + second, up.substring(1));
//            System.out.println(count);
//        }
//        return count;
//    }
}
