package DSA_Revision.Recursion;

public class Subsets_Subsequences {
    public static void main(String[] args) {
        String s = "abc";
        subsequences("", s);
    }
    static void subsequences(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        // peak
        subsequences(p+ch, up.substring(1));
        // not peak
        subsequences(p, up.substring(1));
    }
}
