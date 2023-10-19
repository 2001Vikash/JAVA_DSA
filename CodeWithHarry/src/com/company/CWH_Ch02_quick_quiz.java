package com.company;

public class CWH_Ch02_quick_quiz {
    public static void main(String[] args) {
        float x=51;
        float y=2;
        float ans=(x-y)/2;//parenthesis important hai nhi to L to R solve krega jo glt ho jayega.
        System.out.println(ans);
        float a=5,b=6,c=7,result;
        result=((b*b)-(4*a*c))/(2*a);
        // yaha bhi parenthesis wala sabse pahle solve hoga kyoki parenthesis ki precedence sabse high hota hai
        System.out.println(result);
    }
}
