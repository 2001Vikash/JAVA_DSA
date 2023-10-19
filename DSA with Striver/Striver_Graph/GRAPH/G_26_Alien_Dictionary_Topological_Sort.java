package GRAPH;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class G_26_Alien_Dictionary_Topological_Sort {

    // Given a sorted dictionary pf an Alien language having N words and K starting alphabets of standard dictionary, find the order of characters in the Alien language.
    // Note -> Many orders may be possible for a particular test case, thus you may return any valid orders and output will be 1 if the order of string
    // returned by the function is correct else 0 denoting incorrect string returned.

    // We know that sequence in standard alphabet like a,b,c,d,e,f,g,h,i,j....z but in this question we do not have to follow the standard dictionary sequence
    // Here in this question we have to follow Alien dictionary, means we have to find out the Alien order.
    // and order will be k. means we have to make that dictionary with the help of k number of english dictionary.
    // for ex. if they are giving order like baa, abcd means we can say  that in Alien dictionary b appears before a that will be sequence for that given order.
    // for ex. baa, abcd, abca, cab, cad with the help of this we have to return Alien order which is bdac here we have to focus on something before something
    // Means as we know that if we see something before something then we have to focus on Topological sort.

    // But question is that how will we apply Topological Algo so as we know that we have given K that is standard english alphabet.
    // so initially we will do numbering for the K number of  alphabets for ex, if k = 4 then we will give a=0,b=1,c=2,d=4 like that.
    // And after that we will figure out why baa comes before abca and answer to this question is b appears before a means we directed edge from b to a like b -> a. why because according to Alien alphabet b is smaller
    // And there is no need to check first word to third one because if we are checking first and second then again we will check second and third that will maintain the flow of graph.
    // and next check abcd, abca here we will find d -> a like that we can create our graph and apply standard topological sort.
    // if we have k = 5 but in words only 4 alphabet is presented then where will we put the e that 5th alphabet so for that we will put e as single node.


    // If they are also stated that if order is not possible then what will happen so for this we have two cases.
    // Case:1 -> if we are comparing two string s1 = abcd, s2 = abc so, when comparison is over but, you do not find any unequal char it means abc is always smaller than abcd so at this place order is not possible.
    // Case:2 -> Cyclic dependency which is found by topological sort.

    public static String solution(String[] dict, int n, int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < k; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a'); // - 0 to convert in to in integer.
                    break;
                }
            }
        }

        // In this question clearly provided that Answer will be possible if not possible then we will see afterwords.

        // Apply topological sort over here and as we know that topological sort is worked for multiple components as well.

        int[] inDeg = new int[k];
        for(int i = 0; i < k; i++){
            for(int nbr : adj.get(i)){
                inDeg[nbr]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            if(inDeg[i] == 0)q.add(i);
        }

        String tps = "";
        while(!q.isEmpty()){
            int node = q.remove();
            tps += (char)('a' + node);

          for(int nbr : adj.get(node)){
              inDeg[nbr]--;
              if(inDeg[nbr] == 0)q.add(nbr);
          }
        }

        return tps;
    }


    public static void main(String[] args) {
        String[] dictionary = {"baa", "abcd", "abca", "cab", "cad"};

       System.out.println("Alien dictionary order is : " + solution(dictionary, dictionary.length, 4));

    }
}
