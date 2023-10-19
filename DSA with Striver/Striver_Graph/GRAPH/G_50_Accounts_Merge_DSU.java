package GRAPH;

import java.util.*;

public class G_50_Accounts_Merge_DSU {

    // In this video we are going to solve problem Merging details. Problem states that

    /*

   Bob, a teacher of St. Joseph school given a task by his principal to merge the details of the students where each element details[i] ia a list of strings
   where the first element details[i][0] is a name of the students, and the rest of the elements are emails representing emails of the student.
   Two details definitely belong to the same student if if there is some common email to both detail. After merging the details, return the details of the
   student in the following format: the first element of each detail is the name of the students, and the rest of the elements are emails in sorted order.
   The details themselves can be returned in any order. Note: Two details have the same name, they may belong to different people a people could have
   the same name. A person can have any number of details initially , but all of their details definitely have the same name.

   Note -> In case 2 or more same email belongs to 2 or more different names merge with first name only, Print in the order in sorted way to
           according to the name of the details.


   So for ex. if we find two same names but different email account then we will not merge because they will be details of the different people.
   but if we find same name, and some email account common as well, it means they are same and, merge them with removing of repetitive details, in sorted order.

   Note -> means if name is same then for merging there will must be at-least 1 email common.
           Accounts ordering do not matter but, emails ordering should be in sorted order.

   As we know that the data structure that helps us in connecting or merging dynamically(means in the way) that is Disjoint Set data structure.

   So initially we will give indexes for all the name like 0,1,2...and after that apply Disjoint set on that sequence.
   and, for the mails recognition probably we will take a map data structure.
   at the time of adding in map when we will find that mails are same then it means that must be a part of previous thing so let us merge them.
   and, after doing this we will again traverse the map and according to the ultimate parent we will add things. and in last sort them individually.
     */

    private static class DisjointSet{
        ArrayList<Integer> parent, size;

        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulp = findPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void UnionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u == ulp_v)return;

            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> details){
        int n = details.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < details.get(i).size(); j++){ // j=1 because at 0 index name is present which is identified as indexes.
                String mails = details.get(i).get(j);
                if(!mapMailNode.containsKey(mails)){
                    mapMailNode.put(mails, i);
                }else{
                   // ds.UnionBySize(i, mapMailNode.get(mails)); this is not working for all test cases on gfg.
                    ds.UnionBySize(mapMailNode.get(mails),i); // this is working.
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for(int i = 0; i < n; i++) mergeMail[i] = new ArrayList<>();

        for(Map.Entry<String, Integer> it : mapMailNode.entrySet()){ // that is the way to extract data from the map using this loop.
            String mail = it.getKey();

            int node = ds.findPar(it.getValue());
            mergeMail[node].add(mail);
        }


        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(mergeMail[i].size() == 0)continue;

            Collections.sort(mergeMail[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<String>> details = new ArrayList<>();
        for (int i = 0; i < n; i++) details.add(new ArrayList<>());

        details.get(0).add("John");
        details.get(0).add("j1@com");
        details.get(0).add("j2@com");
        details.get(0).add("j3@com");

        details.get(1).add("John");
        details.get(1).add("j4@com");

        details.get(2).add("Raj");
        details.get(2).add("r1@com");
        details.get(2).add("r2@com");

        details.get(3).add("John");
        details.get(3).add("j1@com");
        details.get(3).add("j5@com");

        details.get(4).add("Raj");
        details.get(4).add("r2@com");
        details.get(4).add("r3@com");

        details.get(5).add("Mary");
        details.get(5).add("m1@com");

        System.out.println(solution(details));
    }
}
