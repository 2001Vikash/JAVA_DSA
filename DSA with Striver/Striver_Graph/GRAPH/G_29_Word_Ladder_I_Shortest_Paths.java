package GRAPH;

import java.util.*;

public class G_29_Word_Ladder_I_Shortest_Paths {

    // Problem states that We have given two distinct words startWord and targetWord, and a list denoting word list of unique words of equal lengths.
    // find the length of the shortest transformation sequence from startWord to targetWord.
    // Keep the following conditions in the mind:
    // 1. A word can only consist of lowerCase character.
    // 2. only one letter can be changed in each transformation.
    // 3. Each transformed word must exist in the wordList including the targetWord.
    // 4. startWord may or may not be part of the wordList.

    // for ex. startWord = "hit", targetWord = "cog" , wordList = {hot, dot, dog, lot, log, cog} and all of them are having same length 3.
    // Now in order to reach for targetWord we can change in startWord. We can change any character at a time either 'h' or 'i' or 't'.
    // So let us change 'i' into 'o' so it will be "hot" which is also in wordList, then 'h' to 'd' so "dot" which is also a part of the wordList.
    // Now change the 't' to 'g' means "dog" then after change 'd' in to the 'c' that will give "cog" which is our targetWord and as well it is part of our wordList.
    // To find targetWord we have done 5 transformation that is shortest.
    // If not to possible to convert startWord to targetWord then we will return 0.

    // If we see this problem and try to solve it via brute force approach like we will check for every character from a to z and whichever is valid(means present in wordList) we will take that.
    // So here in this problem we can see that we are doing things in levelOrder and trying to generate the endWord with the putting character from a to z at the place of every character.
    // So it means here to solve this problem we will use BFS that will be the optimal approach to solve this very Hard problem.
    // As we know that we will apply BFS so, we have to make queue data structure and, we will insert the startWord into the queue and then
    // after we will try to find right word which exist into the wordList. We have to store wordList into a set data structure that will help us in searching at a very low cost of time.
    // And word is find into the set we will remove that element because if we are finding that element at less level then, there is no any meaning to get that element in future with higher level. here are not using visited array that's why we will remove that element from the set.
    // Note => For better understanding at the time of revision please refer the striver graph 29 video.


    public static class Pair{
        String str;
        int stp;
        Pair(String s, int st){
            this.str = s;
            this.stp = st;
        }
    }

    public static int solution(String startWord, String targetWord, ArrayList<String> wordList){

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startWord, 1));

        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        set.remove(startWord);

        while(!q.isEmpty()){
            Pair rem = q.remove();
            String word = rem.str;
            int steps = rem.stp;
            if(word.equals(targetWord)){
                return steps;
            }

            for(int i = 0; i < word.length(); i++){
                char[] arr = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String check = new String(arr);
                    if(set.contains(check)){
                        set.remove(check);
                        q.add(new Pair(check, steps+1));
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        String startWord = "hit";
        String targetWord = "cog";

        System.out.println(solution(startWord, targetWord, wordList));


        // basic concepts to convert a string into char array and vice versa.

//        char[] arr = startWord.toCharArray();
//        System.out.println(Arrays.toString(arr));
//        String str = new String(arr);
//        System.out.println(str);
    }
}
