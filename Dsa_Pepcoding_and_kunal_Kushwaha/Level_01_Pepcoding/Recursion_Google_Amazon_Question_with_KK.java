package Level_01_Pepcoding;

import java.util.ArrayList;

// Data types lecture of kk dekhna hai
public class Recursion_Google_Amazon_Question_with_KK {

    // Question => Letter combinations of a phone number (Google question)


//    public static void main(String[] args) {
//        String comb = "23";
//        keypadComb("", comb);
//        System.out.println(returnComb("", comb));
//    }
//    static void keypadComb(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        int digit = up.charAt(0) - '0';// this will convert '3' as 3
//
//        for (int i = (digit-1)*3; i < (digit*3); i++) {
//            if(i < 26) {
//                char ch = (char) ('a' + i);
//                keypadComb(p + ch, up.substring(1));
//            }else {
//                break;
//            }
//        }
//    }
//    static ArrayList<String> returnComb(String p, String up){
//        ArrayList<String> list = new ArrayList<>();
//        if(up.isEmpty()){
//            list.add(p);
//            return list;
//        }
//        int digit = up.charAt(0) - '0';
//        for (int i = (digit-1)*3; i < (digit*3); i++) {
//           if(i < 26){
//               char ch = (char)('a'+i);
//               ArrayList<String> ans = returnComb(p+ch, up.substring(1));
//               list.addAll(ans);
//           }else{
//               break;
//           }
//        }
//        return list;
//    }



    // Question -> Dice Problem (Amazon)

    // for ex. 4 -> [1,2,3,4,5,6] so answer is [4,2 2, 1 3, 1 1 2] like that


    public static void main(String[] args) {
        diceComb("", 4);
        System.out.println(diceCombRet("", 4));
    }
    static void diceComb(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            diceComb(p+i, target-i);
        }
    }
   static ArrayList<String> diceCombRet(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
       ArrayList<String> ans = new ArrayList<>();
       for (int i = 1; i <= 6 && i <= target; i++) {
           ans.addAll(diceCombRet(p+i, target-i));
       }
       return ans;
   }
}
