package Stack_Queue_Interview_Questions;

import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String str  = "(()()))";
        System.out.println(requirementsForValid(str));
    }
       public static int requirementsForValid(String str){
           Stack<Character> st = new Stack<>();

           for(int i = 0; i < str.length(); i++){
               char ch = str.charAt(i);
               if(ch == '('){
                   st.push(ch);
               }
               if(ch == ')'){
                   if(st.size() != 0 && st.peek() == '('){
                       st.pop();
                   }else{
                       st.push(ch);
                   }
               }
           }

           return st.size();
       }
}