package Level_01_Pepcoding;

import java.util.ArrayList;
import java.util.List;

public class Subset_Subsequence_String_with_KK {

    // Basics String Questions using Recursion

    // Remove a's from the given String

//    public static void main(String[] args) {
//        // we have two approaches
//        // 1 -> Pass the answer String in argument
//        // 2 -> create the answer variable in function body.
//
//        String str = "baccad";
//        System.out.println(removeA(0, "", str, 'a'));
//        System.out.println( removeA2(0,str,'c'));
//        System.out.println(removeA3(0, str, 'a'));
//        removeA4("", str);
//        System.out.println(removeA5(str));
//    }
//    static String removeA(int i, String ans, String str, char target){
//        if(i == str.length()){
//            return ans;
//        }
//        if(str.charAt(i) == target){
//            // skip
//           return removeA(i+1, ans, str, target);
//        }else{
//            // add it in the answer
//
//           // ans = ans + str.charAt(i);
//           return removeA(i+1, ans + str.charAt(i), str, target);
//        }
//    }
//    static String removeA2(int i, String str, char target){
//        if(i == str.length()){
//            return "";
//        }
//        if(str.charAt(i) != target){
//            return str.charAt(i) + removeA2(i+1, str, target);
//        }
//        return removeA2(i+1, str, target);
//    }
//    static String removeA3(int i, String str, char target){
//        if(i == str.length()){
//            return "";
//        }
//        String ans = "";
//        if(str.charAt(i) != target){
//            ans += str.charAt(i);
//        }
//        String ans2 = removeA3(i+1, str, target);
//        ans += ans2;
//        return ans;
//    }
//    static void removeA4(String ans, String str){// here ans is processed and str can be taken as unprocessed
//        if(str.isEmpty()){
//            System.out.println(ans);
//            return;
//        }
//        char ch = str.charAt(0);
//        if(ch == 'a'){
//            removeA4(ans, str.substring(1));
//        }else {
//            removeA4(ans + ch, str.substring(1));
//        }
//    }
//    static String removeA5(String str){
//        if(str.isEmpty()){
//            return "";
//        }
//        char ch = str.charAt(0);
//        if(ch == 'd'){
//           return removeA5(str.substring(1));
//        }else {
//           return ch + removeA5(str.substring(1));
//        }
//    }


    // Remove a String from the given String.

//    public static void main(String[] args) {
//       String str = "abcdapplgfg";
//        System.out.println(removeApple(str));
//        System.out.println(removeAppNotApple(str));
//    }
//    static String removeApple(String str){
//        if(str.isEmpty()){
//            return "";
//        }
//        if(str.startsWith("apple")){
//            return removeApple(str.substring(5));
//        }else {
//            return str.charAt(0) + removeApple(str.substring(1));
//        }
//    }
//    static String removeAppNotApple(String str){
//        if(str.isEmpty()){
//            return "";
//        }
//        if(str.startsWith("app") && !(str.startsWith("apple"))){
//            return removeAppNotApple(str.substring(3));
//        }else {
//            return str.charAt(0) + removeAppNotApple(str.substring(1));
//        }
//    } // Time complexity is O(size of String).


    /*
    Subsets : for Arrays and Subsequences for Strings
              dealing with
              -> Permutation and Combinations
              -> Subsets means non-adjacent collections means same as set theory. It may be adjacent as well for ex {2,3,4} -> {2,3} is a subset and continuous as well.
              -> We will solve it using Recursion as well as iteration.
              -> In this type of problems firstly we need to focus on what we are doing then after how we will do.
              -> so here subsequences of 'abc' => a,b,c,ab,ac,bc,abc,we can put empty as well
              -> Very important point that *** this pattern of taking some elements and removing some is known as subsets problem
     */

    // Subsequences ->  Using Recursion

//    public static void main(String[] args) {
//        String str = "abc";
//        // processed will be initially empty
//       // subsequences("", str);
//       // System.out.println(subsequences2("", str, new ArrayList<>()));
//      //  System.out.println(subsequences3("", str));
//       // System.out.println(subsequences4("", str));
//        String str1 = "ab";
//        subsequenceAscii("", str1);
//    }
//    static void subsequences(String p, String up){// here we put p in argument so benefit of this when function will return it is removed from the stack for that function call
//        // p -> stands for processed and up -> unprocessed
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch = up.charAt(0);
//
//        // Add it
//        subsequences(p + ch, up.substring(1)); // it will call first which is in left side of the tree
//// here up.substring(1) is creating new object and we know that string is immutable and also p+ch is also creating new one like that due to immutability.
//        // ignore it
//        subsequences(p, up.substring(1)); // right side of the tree
//    }
//
//    // if we want to add it in arrayList
//
//    // 1 -> pass in the argument or make global list
//    static ArrayList<String> subsequences2(String p, String up, ArrayList<String> ans){
//        if(up.isEmpty()){
//            if(p.isEmpty()){
//                String k = "{}";
//                ans.add(k);
//            }else{
//                ans.add(p);
//            }
//            return ans;
//        }
//        char ch = up.charAt(0);
//        // pick
//         subsequences2(p+ch, up.substring(1), ans);
//        // not pick
//         subsequences2(p, up.substring(1), ans);
//
//         return ans;
//    }
//    // if list is in function body
//    static ArrayList<String> subsequences3(String p, String up){
//        ArrayList<String> ans = new ArrayList<>();
//        if(up.isEmpty()){
//            if(p.isEmpty()){
//                String k = "{}";
//                ans.add(k);
//            }else{
//                ans.add(p);
//            }
//            return ans;
//        }
//        char ch = up.charAt(0);
//       ArrayList<String> left =  subsequences3(p+ch, up.substring(1));
//        ans.addAll(left);
//
//        ArrayList<String> right = subsequences3(p, up.substring(1));
//        ans.addAll(right);
//
//        return ans;
//    }
//    // same thing with some changes
//    static ArrayList<String> subsequences4(String p, String up){
//        if(up.isEmpty()){
//            ArrayList<String> ans = new ArrayList<>();
//            if(p.isEmpty()){
//                String k = "{}";
//                ans.add(k);
//            }else{
//                ans.add(p);
//            }
//            return ans;
//        }
//        char ch = up.charAt(0);
//        ArrayList<String> left =  subsequences4(p+ch, up.substring(1));
//        ArrayList<String> right = subsequences4(p, up.substring(1));
//        left.addAll(right);
//        return left;
//    }
//
//    // Print all the subsets and also contain to the ASCII value of the characters
//
//    // if we want to ASCII value of a character then we need to add with 0 for ex. char ch = 'a'; ASCII value of a is ch + 0 = 97. like that
//
//    static void subsequenceAscii(String p , String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch = up.charAt(0);
//        subsequenceAscii(p + ch, up.substring(1));
//        subsequenceAscii(p, up.substring(1));
//        // for ASCII value
//        subsequenceAscii(p+(ch+0), up.substring(1));
//    }



    // Subset for array  with iteration

 // Time complexity -> O(n*2^n)
    // Space -> O(n*2^n)
    public static void main(String[] args) {
        int[] arr = {3,4,5};
        System.out.println(subset(arr));
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
              //  System.out.println(internal);
                internal.add(num);
             //   System.out.println(internal);
                outer.add(internal);
              //  System.out.println(outer);
            }
        }
        return outer;
    }

    // Here I need to continue this again
}
