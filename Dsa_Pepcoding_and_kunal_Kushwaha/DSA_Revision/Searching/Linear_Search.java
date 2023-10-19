package DSA_Revision.Searching;

public class Linear_Search {
    public static void main(String[] args) {
        int[] arr = {34,6,5,78,6};
        System.out.println(search(arr,78));
        String s = "Jai Shree Krishna";
        System.out.println(searchInString(s, 'S'));
    }
    static boolean search(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target)return true;
        }
        return false;
    }
    static boolean searchInString(String s , char ch){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch)return true;
        }
        return false;
    }
}
