package GRAPH;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class G_39_Minimum_Multiplications_to_reach_End {

    // Given start,end and an array arr of n numbers. At each stop, start is multiplied with any number in the array and then mod operation with 100000 is
    // done to get the newStart.
    // Your task is to find the minimum stops in which end can be achieved starting from start. If it is not possible to reach end then return -1.

    // Problem states that we have given an array with n numbers and a start point and, an end point,
    // We have to multiply start with arr[i] to get end, so we have to identify that how many numbers of multiplications will be required to get end from the start.
    // for ex, s = 3, e = 30, arr = {2,5,7} -> let us do => 3 * 2 = 6, now 6 * 5 = 30 that is end, So we can achieve it via two times of multiplications. and we have to minimize if possible.

    // Note -> There is no any restriction for multiplication, we can take a number and multiply as many as time.

    // What is work of mode in this question,
    // for ex. s = 7, e = 66175, arr[] = {3,4,65} => 7*3=21*3=63*65=4095*65=266175, now it is exceeded our mod value, 266175%100000=66175 that is our end.
    // Mod 100000 simply meaning is that we always wanted to be in range 0-10^5-1. and ans for above question is 4.

    // Here we can see that, we will start from 7 and multiply with all numbers and, again we will multiply all the numbers in the obtained multiplication.
    // It is looked like Simple Dijkstra's, but how can we identify our nodes in graph
    // So, we have given a range that is 0,1,2,3,4,......9998,9999(that is main thing) and after that due to apply mode we will fall in this range so that will be our node.
    // Here we can think to apply Binary search, but we can not because we do have to find that our end is existing or not we have to find the number of multiplications.
    // And, also there is no need to use PQ, because steps will be increased in increasing order, so we can use Queue.

    // TC -> in worst case O(10^5*n), this is very hypothetical scenario because we can generate all the numbers from 0 to 9999 via given conditions.
    // SC -> O(10^5).

    public static class Pair{
        int steps;
        int node;
        Pair(int s, int n){
            this.steps = s;
            this.node = n;
        }
    }

    public static int solutionViaDijkstra(int src, int end, int mod, int[] arr){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, src));
        int[] dist = new int[mod];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            Pair rem = q.remove();
            int step = rem.steps;
            int node = rem.node;

            for(int it : arr){
                int num = (it * node) % mod;

                if(num == end){
                    return step+1;
                }

                if(step+1 < dist[num]){
                    dist[num] = step+1;
                    q.add(new Pair(step+1, num));
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int start = 3;
        int end = 75;
        int mod = (int)1e5;
        int[] arr = {2,5,7};

        System.out.println(solutionViaDijkstra(start, end, mod, arr));
    }
}
