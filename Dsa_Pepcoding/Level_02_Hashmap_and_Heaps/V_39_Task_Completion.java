package Level_02_Hashmap_and_Heaps;

import java.util.ArrayList;
import java.util.HashSet;

public class V_39_Task_Completion {

    // In this problem, we are given two integers N and M, and an array of numbers with length M.
    // N represents the total number of tasks assigned to a group of 5 students.
    // Out of these five students, three students completed M number of tasks of their choices and left the group.
    // Task completed by these students are represented by the given array.
    // Now, the remaining two students (s1 and s2) have to complete all the remaining tasks.
    // They decided to complete the remaining tasks in an alternate way:
    // First of the remaining tasks will be completed by s1.
    // Second of the remaining tasks will be completed s2.
    // Third of the remaining tasks will be completed by s1... and so on.
    // You have to find the tasks that s1 and s2 have to complete.

    public static void main(String[] args) {
        int work = 15;
        int cmpByThree = 6; // and remaining work will be done by remaining students that is 2.
        int[] arr = {2,5,6,7,9,4}; // this represents that all three students are done arr[i] works, where i = 0 to i = n-1.
        // we have to do work from 1 to work that is 15, in this we have done some work that is given in the array via three workers.

        HashSet<Integer> completed = new HashSet<>();
        for(int val : arr)completed.add(val);

        boolean flag = true;
        ArrayList<Integer> studentOne = new ArrayList<>();
        ArrayList<Integer> studentTwo = new ArrayList<>();

        for(int i = 1; i <= work; i++){
            if(!completed.contains(i)){
                if(flag){
                    studentOne.add(i);
                }else {
                    studentTwo.add(i);
                }
                flag = !flag; // this is used to toggle the flag, means if true then do false, vice versa.
            }
        }
        // We can to flag's work using counter = 0, if it is even then add in One, otherwise in Two, and do counter++;

        System.out.println(studentOne);
        System.out.println(studentTwo);
    }
}
