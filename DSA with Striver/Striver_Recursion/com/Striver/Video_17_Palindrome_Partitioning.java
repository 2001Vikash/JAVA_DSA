package com.Striver;
import java.util.*;
public class Video_17_Palindrome_Partitioning {
    // Palindrome Partitioning
    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
         palindrome(0,s,list,ans);
        return ans;
    }
    public static void palindrome(int ind , String s , List<String> list ,List<List<String>> ans ){
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind; i<s.length(); i++){
           if(isPalindrome(s,ind,i)){

               list.add(s.substring(ind , i+1));
               palindrome(i+1,s,list,ans);
               list.remove(list.size()-1);// kyoki palindrome wali string to ans  me stored hai  once time.
           }
        }
    }
    public static boolean isPalindrome(String s , int start , int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
      String s = "aabb";
        System.out.println(partition(s));
    }
}
