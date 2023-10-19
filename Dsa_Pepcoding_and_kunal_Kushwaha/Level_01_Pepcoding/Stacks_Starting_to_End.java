package Level_01_Pepcoding;
import java.util.*;
public class Stacks_Starting_to_End {
//    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();
//        st.push(10);
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.push(20);
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.push(30);
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.push(40);
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.pop();
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.pop();
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        st.pop();
//        System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//       // st.pop();// chunki yagha pr empty stack ke error aa rha hai but websites pr work karega.
//       // System.out.println(st+"--> "+ st.peek()+" , "+st.size());
//        // yaha chunki koi bhi element nhi hai stack me to peek ke liye error aayega isliye peek  htana padega.
//       // System.out.println(st+"--> "+st.size());
//    }

    // Duplicate Brackets

    // If duplicate brackets are present then print true otherwise false;
//    public static void main(String[] args) {
//        String op = "((a+b)+(c+d))";
//        Stack<Character> st = new Stack<>();
//        for(int i=0; i<op.length(); i++){
//            char c = op.charAt(i);
//            if(c==')'){
//                if(st.peek() == '('){
//                    System.out.println(true);
//                    break;// yaha return bhi ho sakta hai koi error nhi hoga
//                }else {
//                    while(st.peek() != '('){
//                        st.pop();
//                     //   System.out.println(st);
//                    }
//                    st.pop();
//                  //  System.out.println(st);
//
//                }
//            }else{
//                st.push(c);
//              //  System.out.println(st);
//            }
//
//        }
//
//         System.out.println(false);
//        // true ke case me true false dono ans aayega isiliy function ka use krna hai aur break ke jgh return use krenege.
//
//    }


    // Balanced Brackets with the help of () , {}, and [].


//    public static void main(String[] args) {
//        String str = "[{(a+b)+(c+d)+{(e/f)}}]" +
//                "";
//        Stack<Character> st = new Stack<>();
//        for(int i=0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if(ch=='(' || ch=='{' || ch=='[' ){
//                st.push(ch);
//            }
//            else if(ch==')'){
//                  if(st.size()==0){// means closing bracket jyada hai
//                    System.out.println(false);
//                    return;
//                }
//               else if(st.peek() != '('){
//                    System.out.println(false);
//                    return;
//                }
//                else {
//                    st.pop();
//                }
//            }
//            else if (ch=='}') {
//                 if(st.size()==0){// means closing bracket jyada hai
//                    System.out.println(false);
//                    return;
//                }
//                else if(st.peek() != '{'){
//                    System.out.println(false);
//                    return;
//                }
//                else {
//                    st.pop();
//                }
//            } else if (ch == ']') {
//                if(st.size()==0){// means closing bracket jyada hai
//                    System.out.println(false);
//                    return;
//                }
//                else if(st.peek() != '['){
//                    System.out.println(false);
//                    return;
//                }
//                else {
//                    st.pop();
//                }
//            }
//        }// bar bar use hone code ka function bhi bna sakte hai.
//        if(st.size()==0){
//            System.out.println(true);
//        }else{
//            System.out.println(false);// means opening bracket jyada hai.
//        }
//    }


    // Next Greater Element to the Right
    // But Its time complexity is O(n^2) hai but we need to in  O(n).

    // Same question from 122 to 198 with different approaches


    //public static void main(String[] args) {


//        int[] arr = {2,5,9,3,1,12,6,8,7};
//        int[] narr = new int[arr.length];

//        for(int i=0; i<arr.length; i++){
//            int count =0;
//            for(int j=i+1; j<arr.length; j++){
//                if(arr[i]<arr[j]){
//                    narr[i]=arr[j];
//                    count=1;
//                    break;
//                }
//            }
//            if(count==1){
//                continue;
//            }else {
//                narr[i] = -1;
//            }
//        }
//        for(int k : narr){
//            System.out.print(k+" ");
//        }


        // O(n) Solution.

//        int[] arr = {2,5,9,3,1,12,6,8,7};
//        int[] narr = new int[arr.length];
//        Stack<Integer> st = new Stack<>();
//        st.push(arr[arr.length-1]);
//        narr[arr.length-1] = -1;
//        for(int i= arr.length-2; i>=0; i--){
//            // -(pop), a(set), +(push).
//
//            while(st.size()>0 && arr[i]>=st.peek()){
//                st.pop();
//            }
//            if(st.size()==0){
//                narr[i]=-1;
//            }
//            else{
//                narr[i]=st.peek();
//            }
//            st.push(arr[i]);
//        }
//        for (int v: narr) {
//            System.out.print(v+" ");
//        }

        // Alternate Solution of this Problem

//        int[] arr = {2,5,9,3,1,12,6,8,7};
//        int[] narr = new int[arr.length];
//        Stack<Integer> st = new Stack<>();
//        st.push(0);
//        for(int i=1; i<arr.length; i++){
//            while(st.size()>0 && arr[i]>=arr[st.peek()]){
//                int pos = st.peek();
//                narr[pos] = arr[i];
//                st.pop();
//            }
//            st.push(i);
//        }
//        while(st.size()>0){
//            int pos = st.peek();
//            narr[pos] = -1;
//            st.pop();
//        }
//        for(int k:narr){
//            System.out.print(k+" ");
//        }
//    }



    // Stock Span Problem


//    public static void main(String[] args) {
//        int[] arr = {2,5,1,3,8,4};
//        int[] span = new int[arr.length];
//        Stack<Integer> st = new Stack<>();
//        st.push(0);
//        span[0]=1;
//        for(int i=1; i<arr.length; i++){
//            while(st.size()>0 && arr[i]>arr[st.peek()]){
//                st.pop();
//            }
//            if(st.size()==0){
//                span[i] = i+1;
//            }else{
//                span[i] = i-st.peek();
//            }
//            st.push(i);
//        }
//         for(int j: span){
//             System.out.print(j+" ");
//         }
//    }


    // Largest Area Histogram

//    public static void main(String[] args) {
//        int[] arr = {6,2,5,4,5,1,6};
//        int[] rb = new int[arr.length];// nse on the right
//         Stack<Integer> st = new Stack<>();
//         st.push(arr.length-1);
//         rb[arr.length-1] = arr.length;
//         for(int i=arr.length-2; i>=0; i--){
//             while(st.size()>0 && arr[i]<=arr[st.peek()]){
//                 st.pop();
//             }
//             if(st.size()==0){
//                 rb[i]=arr.length;
//             }else{
//                 rb[i] = st.peek();
//             }
//             st.push(i);
//           //  System.out.print(rb[i]+" ");
//         }
//
//        int[] lb = new int[arr.length]; // nse ont the left
//        st = new Stack<>();
//        st.push(0);
//        lb[0] = -1;
//        for(int i=1; i<arr.length; i++){
//            while(st.size()>0 && arr[i]<=arr[st.peek()]){
//                st.pop();
//            }
//            if(st.size()==0){
//                lb[i]=-1;
//            }else{
//                lb[i]=st.peek();
//            }
//            st.push(i);
//           // System.out.print(lb[i]+" ");
//        }
//
//
//        int AreaMax = 0;
//        for(int i=0; i<arr.length; i++){
//            int width = rb[i]-lb[i]-1;
//           // System.out.print(width+" ");
//            int area = arr[i]*width;
//            if(area>AreaMax){
//                AreaMax = area;
//            }
//        }
//        System.out.println(AreaMax);
//    }


    // Sliding Window Maximum Problem.

    // But we need to do in O(n) but here is time complexity like as O(n^2) for i ke last value ke liye
//    public static void main(String[] args) {
//        int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6,56,87,34,21};
//        int k = 4;// width of windows or comparing between k numbers that who is big.
//        int[] narr = new int[arr.length-k+1];
//         for(int i=0; i<=arr.length-k; i++){
//             int max=arr[i];
//             for(int j=i; j<k+i; j++){
//                if(arr[j]>max){
//                    max=arr[j];
//                }
//             }
//             narr[i]=max;
//         }
//         for(int v: narr){
//             System.out.print(v+" ");
//         }

        // For O(n) we need solve using Stack
// But very complex bar bar revise krna hoga

//        Stack<Integer> st = new Stack<>();
//        int[] nge = new int[arr.length];
//        st.push(arr.length-1);
//        nge[arr.length-1] = arr.length;
//        for(int i=arr.length-2; i>=0; i--){
//            while(st.size()>0 && arr[i]>=arr[st.peek()]){
//                st.pop();
//            }
//            if(st.size() == 0){
//                nge[i]=arr.length;
//            }else{
//                nge[i]=st.peek();
//            }
//            st.push(i);
//        }
//        for(int vl:nge){
//            System.out.print(vl+" ");
//
//        }
//        System.out.println();
//        int j=0;
//        for(int i=0; i<=arr.length-k; i++){
//            if(j<i){
//                j=i;
//            }
//            while(nge[j]<i+k){
//                j=nge[j];
//            }
//            System.out.print(arr[j]+" ");
//        }
//    }


    // Infix Evaluation.


//    public static int precedence(char operator) {
//        if (operator == '+') {
//            return 1;
//        }// because * and / have same precedence but greater than + and -.
//        else if(operator=='-'){
//            return 1;
//        } else if (operator == '*') {
//            return 2;
//        }else {
//            return 2;
//        }
//    }
//        public static int operation(int v1, int v2, char op ){
//            if (op == '+') {
//                return v1+v2;
//            }else if(op=='-'){
//                return v1-v2;
//            }else if(op=='*'){
//                return v1*v2;
//            }else{
//                return v1/v2;
//            }
//        }
//    public static void main(String[] args) {
//      String exp = "2+(5-3*6/2)";
//      Stack<Integer> operands = new Stack<>();
//      Stack<Character> operators = new Stack<>();
//      for(int i=0; i<exp.length(); i++){
//          char ch = exp.charAt(i);
//          if(ch == '('){
//           operators.push(ch);
//          }else if(Character.isDigit(ch)){
//                  operands.push(ch-'0'); // char to int
//          }else if(ch == ')'){
//             while(operators.peek()!='('){
//                 char opt = operators.pop();
//                 int v2 = operands.pop();
//                 int v1 = operands.pop();
//                 int opv = operation(v1,v2,opt);
//                 operands.push(opv);
//             }
//             operators.pop();
//          }else if (ch=='+' || ch=='-' || ch=='*' || ch=='/'){
//              // ch is wanting higher priority operators to solve first.
//              while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())){
//                  char opt = operators.pop();
//                  int v2 = operands.pop();
//                  int v1 = operands.pop();
//                  int opv = operation(v1,v2,opt);
//                  operands.push(opv);
//              }
//              // ch is pushing itself.
//              operators.push(ch);
//          }
//      }
//        while(operators.size()!=0){
//            char opt = operators.pop();
//            int v2 = operands.pop();
//            int v1 = operands.pop();
//            int opv = operation(v1,v2,opt);
//            operands.push(opv);
//        }
//        System.out.println(operands.peek());
//    }



    // Infix Conversions in to Prefix and Postfix. Both have not any type of brackets.


//    public static int precedence(char op){
//        if(op == '+' || op == '-'){
//            return 1;
//        }else {
//            return 2;// hum yaha error nhi handle kr rhe hai but kewal * and / allow hai 2 kw liye.
//        }
//    }
//    public static void main(String[] args) {
//       String exp = "a*(b-c)/d+e";
//       Stack<String> post = new Stack<>();
//       Stack<String> pre = new Stack<>();
//       Stack<Character> ops = new Stack<>();
//       for(int i=0; i<exp.length(); i++){
//           char ch = exp.charAt(i);
//           if(ch == '('){
//               ops.push(ch);
//           }else if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A') && ch<='Z') {
//               post.push(ch + "");// if we add empty String int to a char then he converts in char to String
//               pre.push(ch + "");// char to String
//
//           } else if(ch == ')'){
//                while(ops.peek()!='('){
//                    char op = ops.pop();
//
//                    String posv2 = post.pop();
//                    String posv1 = post.pop();
//                    String posAns = posv1+posv2+op;
//                    post.push(posAns);
//
//                    String prev2 = pre.pop();
//                    String prev1 = pre.pop();
//                    String preAns = op + prev1+prev2;
//                    pre.push(preAns);
//                }
//                ops.pop();
//               }
//           else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
//               while(ops.size()>0 && ops.peek()!='(' && precedence(ch)<=precedence(ops.peek())){
//                   char op = ops.pop();
//
//                   String posv2 = post.pop();
//                   String posv1 = post.pop();
//                   String posAns = posv1+posv2+op;
//                   post.push(posAns);
//
//                   String prev2 = pre.pop();
//                   String prev1 = pre.pop();
//                   String preAns = op + prev1+prev2;
//                   pre.push(preAns);
//               }
//               ops.push(ch);
//           }
//       }
//       while(ops.size()>0){
//           // We can make a function named as process and code content is reduced.
//           char op = ops.pop();
//
//           String posv2 = post.pop();
//           String posv1 = post.pop();
//           String posAns = posv1+posv2+op;
//           post.push(posAns);
//
//           String prev2 = pre.pop();
//           String prev1 = pre.pop();
//           String preAns = op + prev1+prev2;
//           pre.push(preAns);
//       }
//        System.out.println(post.peek());
//        System.out.println(pre.peek());
//    }



    // PostFix evaluation and Conversion into PreFix and InFix.


//    public static int operation(int v1, int v2, char op){
//        if(op == '+'){
//            return v1+v2;
//        }else if(op == '-'){
//            return v1-v2;
//        }else if(op == '*'){
//            return v1*v2;
//        }else if(op == '/'){
//            return v1/v2;
//        }else{
//            return 0;
//        }
//    }
//    public static void main(String[] args) {
//        String exp = "264*8/+3-";
//        Stack<Integer> value = new Stack<>();
//        Stack<String> inFix = new Stack<>();
//        Stack<String> preFix = new Stack<>();
//        for(int i=0; i<exp.length(); i++){
//            char ch = exp.charAt(i);
//            if(ch>='0' && ch<='9'){// only for understanding otherwise we can put it in else case for avoiding comparison
//                value.push(ch-'0');
//                inFix.push(ch+"");
//                preFix.push(ch+"");
//            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
//                // for value
//                int v2 = value.pop();
//                int v1 = value.pop();
//                int v = operation(v1,v2,ch);
//                value.push(v);
//                // for Infix
//                String inv2 = inFix.pop();
//                String inv1 = inFix.pop();
//                String inAns = "(" + inv1 + ch + inv2 + ")";
//                inFix.push(inAns);
//                // for PreFix
//                String prev2 = preFix.pop();
//                String prev1 = preFix.pop();
//                String preAns = ch + prev1 + prev2;
//                preFix.push(preAns);
//            }
//        }
//        System.out.println(value.peek());
//        System.out.println(inFix.peek());
//        System.out.println(preFix.peek());
//    }



    // Prefix evaluation and conversions into Infix and Postfix.


//        public static int operation(int v1, int v2, char op){
//        if(op == '+'){
//            return v1+v2;
//        }else if(op == '-'){
//            return v1-v2;
//        }else if(op == '*'){
//            return v1*v2;
//        }else if(op == '/'){
//            return v1/v2;
//        }else{
//            return 0;
//        }
//    }
//    public static void main(String[] args) {
//        String exp = "-+2/*6483";
//        Stack<Integer> vs = new Stack<>();
//        Stack<String> ins = new Stack<>();
//        Stack<String> pos = new Stack<>();
//        for(int i=exp.length()-1; i>=0; i--){// because nhi to operator pahle aa jayenge or error ho jayega.
//            char ch = exp.charAt(i);
//            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
//                // for value
//                int v1 = vs.pop();// because we are traversing in reverse manner.
//                int v2 = vs.pop();
//                int v = operation(v1,v2,ch);
//                vs.push(v);
//                // for Infix
//                String inv1 = ins.pop();// because we are traversing in reverse manner.
//                String inv2 = ins.pop();
//                String inv = "(" + inv1 + ch + inv2 + ")";
//                ins.push(inv);
//                // for Postfix
//                String pov1 = pos.pop();// because we are traversing in reverse manner.
//                String pov2 = pos.pop();
//                String pov = pov1 + pov2 + ch;
//                pos.push(pov);
//            }else{
//                vs.push(ch-'0');
//                ins.push(ch+"");
//                pos.push(ch+"");
//            }
//        }
//        System.out.println(vs.pop());
//        System.out.println(ins.pop());
//        System.out.println(pos.pop());
//    }


    // Celebrity Problem
    // Firstly I will try to solve this problem in O(n^2).

//    public static void main(String[] args) {
//        int n=5;
//        int[][] cell = { {0,1,1,1,1},
//                         {1,0,1,1,0},
//                         {0,0,0,0,0},
//                         {1,0,1,1,0},
//                         {0,1,1,1,0} };
//       // celebrity means every body knows him but he do not anyone. and
//        // here is diagonal elements means khud ko khud se janana it is not valid .
//        int ind = 0;
//        for(int i=0; i<n; i++){
//            int row=0;
//            for(int j=0; j<n; j++){
//                if(cell[i][j]!=0 && i!=j){
//                    row=1;
//                }
//            }
//            if(row==0){
//                ind = i;
//                break;
//            }else{
//                continue;
//            }
//        }
//        System.out.println(ind);
//        int col =ind;
//        for(int k=0; k<n; k++){
//
//            if(cell[k][ind]!=1 && k!=ind){
//                col=0;
//               break;
//            }
//        }
//        System.out.println(col);
//        if(col==ind){
//            System.out.println("Celebrity awards goes to the "+col);
//        }else{
//            System.out.println("There is no selected celebrity");
//        }
//    }

    // But we need to solve this problen in O(n).
// kya two clelebrity ho sakte hai bilkul bhi nhi kyoki yadi koi ek celebrity bn gya to wh aur kisi ko janega hi nhi.
    // means bache me se koi celebrity nhi bn sakta hai.

//            Stack<Integer> st = new Stack<>();
//            for(int i=0; i<n; i++){
//                st.push(i);
//            }
//            while (st.size()>=2){
//                int i = st.pop();
//                int j= st.pop();
//                if(cell[i][j]==1){
//                    // means i knows j --> i is not a celebrity.
//                    st.push(j);
//                }else{
//                    // i does not know j --> j is not celebrity
//                    st.push(i);
//                }
//            }
//            int pot = st.pop();// means 2 ke paas jayada potential hai celebrity hone ki but abhi confirm nhi hai
//        // so let us check
//        for(int i=0; i<n; i++){
//            if(i!=pot){
//                if(cell[i][pot]==0 || cell[pot][i]==1){
//                    System.out.println("None");
//                    return;
//                }
//            }
//        }
//        // cell[i][pot]==0 means kya i kisi pot ko nhi janta hai ydi aisa hai to wh celebrity ho skta hai
//        // cell[pot][i]==1 means kya pot kisi i ko janta hai is case me bhi pot celebrity nhi hoga
//        // yadi uper dono false ho jate hai tb pot celebrity hoga.
//        System.out.println(pot+" is a celebrity.");
//    }


    // Merge Overlapping Intervals.

    // Concept to clear hai but isme oops ka use hua hai to jb oops krenge tb yaha aana hai.
    // It problem from 128 no video from pepcoding level 1.



    // Smallest number following pattern problem.
// we have maximum 8 length ki string which is given as "ddidi" here d means decreasing order and i means increasing order
    // and we can only take numbers between 1 to 9. without duplicity. and smallest such number.

    public static void main(String[] args) {
        String str = "ddidddid";
        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'd'){
                st.push(count);
                count++;
            }else if(ch == 'i'){
                st.push(count);
                count++;
                while(st.size()>0){
                    System.out.print(st.pop()+" ");
                }
            }
        }
        st.push(count);
        while(st.size()>0){
            System.out.print(st.pop()+" ");
        }
    }
}
// Here Stack is not completed totally because we need to complete this some knowledge of OOps Concept then after
// I will complete this thing.