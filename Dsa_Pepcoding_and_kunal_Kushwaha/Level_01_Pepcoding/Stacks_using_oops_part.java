package Level_01_Pepcoding;
import java.util.*;
public class Stacks_using_oops_part {

    // Build Normal Stack

//    public static class customStack{
//        int[] data;
//        int tos;
//          customStack(int cap){
//            data = new int[cap];
//            tos = -1;
//        }
//        int size(){
//          return tos+1;
//        }
//        void display(){
//          for(int i=tos; i>=0; i--){
//              System.out.print(data[i]+" ");
//          }
//            System.out.println();
//        }
//        void push(int val){
//          if(tos == data.length-1){
//              System.out.println("Stack Overflow");
//          }else{
//              tos++;
//              data[tos] = val;
//          }
//        }
//        int pop(){
//            if(tos == -1){
//                System.out.println("Stack Underflow");
//                return -1;
//            }
//            else {
//                int val = data[tos];
//                tos--;
//                return val;
//            }
//        }
//        int top(){
//              if(tos == -1){
//                  System.out.println("Stack Underflow");
//                  return -1;
//              }else{
//                  return data[tos];
//              }
//        }
//    }
//    public static void main(String[] args) {
////        int[] arr = {10,20,30,40};
//        int cap = 4;
//        customStack p1 = new customStack(cap);
//        p1.push(10);
//        p1.push(20);
//       p1.display();
//    }


    // Build Dynamic Stack

//        public static class customStack{
//        int[] data;
//        int tos;
//          customStack(int cap){
//            data = new int[cap];
//            tos = -1;
//        }
//        int size(){
//          return tos+1;
//        }
//        void display(){
//          for(int i=tos; i>=0; i--){
//              System.out.print(data[i]+" ");
//          }
//            System.out.println();
//        }
//        void push(int val){
//              // this thing makes dynamic stack.
//          if(tos == data.length-1){
//             int[] ndata = new int[2* data.length];
//             for(int i=0; i<data.length; i++){
//                 ndata[i]=data[i];
//             }
//             data = ndata;
//            //  System.out.println(data.length);
//             tos++;
//             data[tos]=val;
//          }else{
//              tos++;
//              data[tos] = val;
//          }
//        }
//        int pop(){
//            if(tos == -1){
//                System.out.println("Stack Underflow");
//                return -1;
//            }
//            else {
//                int val = data[tos];
//                tos--;
//                return val;
//            }
//        }
//        int top(){
//              if(tos == -1){
//                  System.out.println("Stack Underflow");
//                  return -1;
//              }else{
//                  return data[tos];
//              }
//        }
//    }
//    public static void main(String[] args) {
//       int cap = 2;
//       customStack p1 = new customStack(cap);
//       p1.push(10);
//       p1.push(20);
//       p1.push(30);
//        p1.display();
//        System.out.println( p1.size());
//    }


    // Minimum Stack 1.

//    public static class minStack{
//        Stack<Integer> allData;
//        Stack<Integer> minData;
//        minStack(){
//            allData = new Stack<>();
//            minData = new Stack<>();
//        }
//        int size(){
//            return allData.size();
//        }
//        void push(int val){
//            allData.push(val);
//            if(minData.size()==0  || val<=minData.peek()){
//              minData.push(val);
//            }
//        }
//        int pop(){
//          int val  = allData.pop();
//          if(val == minData.peek()){
//              minData.pop();
//          }
//          return val;
//        }
//        int top(){
//            if(size() == 0){
//                System.out.println("Stack Underflow");
//                return -1;
//            }else{
//                return allData.peek();
//            }
//        }
//        int min(){
//            if(size() == 0){
//                System.out.println("Stack Underflow");
//                return -1;
//            }
//            else{
//                return minData.peek();
//            }
//        }
//    }
//    public static void main(String[] args) {
//
//    }


    // Minimum Stack 2
// In this case we are using only one stack means here space complexity is also constant.

//    public static class minStack{
//        Stack<Integer> data ;
//        int min;
//        public minStack(){
//            data = new Stack<>();
//        }
//        int size(){
//            return data.size();
//        }
//        void push(int val){
//            if(data.size()==0) {
//                data.push(val);
//                min = val;
//            } else if(val>=min){
//                data.push(val);
//            }else{
//                // means val<min then
//                data.push(val+val-min);// push a fake value which is less than the min. for the detection
//                // which is use as time of pop.
//                min = val;// min change with original value.
//            }
//        }
//        int pop(){
//          if(data.size()==0){
//              return -1;
//          }else{
//              int val = data.pop();
//              if(val>=min){
//                  return val;
//              }else{
//                  // means val<min means yaha pr hmne fake value store ki thi.
//                  int originalValue = min;
//                  min = 2*min-val;
//                  return originalValue;
//              }
//          }
//        }
//        int top(){
//            if(data.size()==0){
//                return -1;
//            }else{
//                int val = data.peek();
//                if(val>=min){
//                    return val;
//                }else{
//                    // means val<min means yaha pr hmne fake value store ki thi.
//                   return min;
//                }
//            }
//        }
//        int getMin(){
//            if(data.size()==0){
//                return -1;
//            }else{
//                return min;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        minStack m1 = new minStack();
//        m1.push(8);
//        m1.push(47);
//        m1.push(17);
//        m1.push(7);
//        m1.push(30);
//        m1.push(2);
//        System.out.println(m1.getMin());
//        m1.pop();
//        System.out.println(m1.getMin());
//    }
}
