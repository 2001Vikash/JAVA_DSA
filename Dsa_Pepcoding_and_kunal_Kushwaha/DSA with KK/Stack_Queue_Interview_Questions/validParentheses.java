package Stack_Queue_Interview_Questions;

import java.util.Stack;

public class validParentheses {
    public static void main(String[] args) {
        String str = "({[])}";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String str){
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            if(st.isEmpty()){
                return false;
            }else {
                if (ch == ')') {
                    if (st.peek() != '(') {
                        return false;
                    } else {
                        st.pop();
                    }
                } else if (ch == '}') {
                    if (st.peek() != '{') {
                        return false;
                    } else {
                        st.pop();
                    }
                } else if (ch == ']') {
                    if (st.peek() != '[') {
                        return false;
                    } else {
                        st.pop();
                    }
                }
            }
        }

//        if(st.isEmpty()){
//            return true;
//        }else {
//            return false;
//        }
        // OR

        return st.isEmpty();
    }
}
