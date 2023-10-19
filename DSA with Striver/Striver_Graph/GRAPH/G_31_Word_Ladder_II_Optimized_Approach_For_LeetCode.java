package GRAPH;

import java.nio.channels.Pipe;
import java.util.*;

public class G_31_Word_Ladder_II_Optimized_Approach_For_LeetCode {

    // when we try to submit the word ladder-II problem on LeetCode it gave TLE why?
    // for the interview purpose there is no need to solve this problem via this method we can do it via the previous solution that will be sufficient.
    // To solve this problem on leetCode then we have to solve this problem via CP way.
    // So, for this we have two steps
    // Steps-1: Follow the Word Ladder-I and find the minimum steps/transformation. and, store the steps for every string.
    // Step-2: Backtrack in the map/used data structures from end -> begin to get the answer.

    // Why is it working because here when are finding the steps and ,we are starting from back then it means the exploration of path will be minimum.
    // Which saves a lots of time.


    public static void dfs(String word, String beginWord, ArrayList<String> seq, ArrayList<ArrayList<String>> ans,  HashMap<String, Integer> map){
        if(word.equals(beginWord)){
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq); // because we know that if we will reverse then this will be changed everywhere so answer will be wrong that's why we to again reReverse it.
            return;
        }

        int steps = map.get(word);

        for(int i = 0; i < word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] arr = word.toCharArray();
                arr[i] = ch;
                String temp  = new String(arr);
                if(map.containsKey(temp) && map.get(temp) + 1 == steps){
                    seq.add(temp);
                    dfs(temp, beginWord, seq, ans, map);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }

    public static ArrayList<ArrayList<String>> solution(String beginWord, String endWord, ArrayList<String> wordList){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        int len = beginWord.length();
        set.remove(beginWord); // because wew are using it.

        while(!q.isEmpty()){
            String word = q.remove();
            int step = map.get(word);
            for(int i = 0; i < len; i++){
               for(char ch = 'a'; ch <= 'z'; ch++){
                   char[] arr = word.toCharArray();
                   arr[i] = ch;
                   String temp = new String(arr);
                   if(set.contains(temp)){
                       q.add(word);
                       set.remove(word);
                       map.put(word, step+1);
                   }
               }
            }
        }

        if(map.containsKey(endWord)){
            ArrayList<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, beginWord, seq, ans, map);
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        String startWord = "hit";
        String targetWord = "cog";

        ArrayList<String> wl = new ArrayList<>(Arrays.asList(wordList));

        System.out.println(solution(startWord, targetWord, wl));
    }

}
