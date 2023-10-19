package Level_02_Hashmap_and_Heaps;
import java.util.*;
public class V_34_Recurring_Sequence_in_a_Fraction {

    // In this problem, you are given two numbers which represents the numerator and denominator of a fraction.
    // You have to covert this fraction into a decimal.
    // If the decimals are repeating recursively, then you have to put the recurring sequence inside a bracket.

    // let see what will be the output for all these test cases -> here we are doing it for +ve numbers only.
    // 1. 8/4 = 2, 2. 37/2 = 18.5, means divide it till 0 or repetition.
    // 3. 428/125 = 3.424, 4. 14/3 = 4.66666... so ans will be -> 4.(6), means repeating part, put it into bracket.
    // 5. 47/18 = 2.6(1), 5. 93/7 = 13.2857142 -> 2 is repeated means ans = 13.(285714)

    // In repetition case, we have to be conscious that, when did current remainder come? because we have to put brackets, to do it position will be required.


    public static void main(String[] args) {

        int n = 428; //  numerator.
        int m = 125; // denominator.

        StringBuilder ans = new StringBuilder(); // here we are taking stringBuilder, because we have to append '(' at any required position, so this will be easy in stringBuilder.
        int q = n / m;
        int r = n % m;
        ans.append(q);

        if(r == 0){
            System.out.println(ans);
            return;
        }else{
            ans.append(".");
            HashMap<Integer,Integer> map = new HashMap<>();
            while(r != 0){
                if(map.containsKey(r)){
                    int len = map.get(r);
                    ans.insert(len, "(");
                    ans.append(")");
                    break;
                }else{
                    map.put(r, ans.length());
                    r = r * 10;
                    q = r / m;
                    r = r % m;
                    ans.append(q);
                }
            }
        }

        System.out.println(ans);
    }
}
