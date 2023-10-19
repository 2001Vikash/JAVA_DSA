package GRAPH;

import java.util.*;

public class G_30_Word_Ladder_II_Shortest_Path {

    // In ladder 1 problem we have seen that we had to find the minimum number of transformation from startWord to targetWord with the use of wordlist.

    // But In second problem is having some extension that is => And this is also one of the toughest BFS problem.

    //  Problem states that we have given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal length
     // Find all shortest transformation sequences(s) from startWord to targetWord. You can return them in any order possible.
    // Keep the following conditions in the mind.
    // 1. A word can only consist of lower characters.
    // 2. Only one letter can be changed in each transformation.
    // 3. Each transformed word must exist in the wordList including the targetWord.
    // 4. startWord may or may not be part of the wordList.
    // 5. Return an empty list if there is no such transformation sequences.

    // Here we can not apply plain BFS for that here we have to add some extension in previous algorithm because here we have to return the sequences.
    // In queue data structure we will also be store sequence.
    // Here also we will delete string from wordList when we will be completed things at that level then delete.
    // And at level a can repeat itself in another form of sequence that's why we will remove from wordList at the end of every level.


    public static ArrayList<ArrayList<String>> solution(String startWord, String targetWord, String[] wordList){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(wordList));
        int level = 0;
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        Queue<ArrayList<String>> q = new ArrayDeque<>();
        ArrayList<String> ls = new ArrayList<>();
        // why are we not using usedOnLevel because java works by reference, means whatever change will be happening that will be also changed in queue.
        ls.add(startWord);
        q.add(ls); // initially we have usedLevel is inserted in queue.

        while(!q.isEmpty()){
            ArrayList<String> list = q.peek();
            q.remove();

            // remove all words that has been used in the previous levels to transform.

            if(list.size() > level){
                level++;
                for(String e : usedOnLevel){
                    set.remove(e);
                }
            }

            String word  = list.get(list.size()-1); // means last element in the list.

            // Store the answers

            if(word.equals(targetWord)){
                // the first sequence where we reached at end.
                if(ans.size() == 0){
                    ans.add(new ArrayList<>(list));
                }else if(ans.get(0).size() == list.size()){
                    ans.add(new ArrayList<>(list));
                }
            }
           // char[] arr = word.toCharArray();
            for(int i = 0; i < word.length(); i++){
//                char[] arr = word.toCharArray();
//                char original = arr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String st = new String(arr);
                    if(set.contains(st)){
                        list.add(st);
                       // q.add(list); it will not save as new List for that we have to make new ArrayList<>().
                        q.add(new ArrayList<>(list));
                        // mark as visited on the level.
                        usedOnLevel.add(st);
                        list.remove(list.size()-1);
                    }
                }
               // arr[i] = original; // given data must be same as they provided this is important in industry use.
                // there is no need to do it because our word string will be same because we are making character array and using.
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        String[] wordList = {"pat","bot","pot","poz","coz"};
        String startWord = "bat";
        String targetWord = "coz";

        // for ex. we have two ways to reach at targetWord and, we have to return the ways in List form. and both must have equal number of transformation.

        System.out.println(solution(startWord, targetWord, wordList));
    }
}