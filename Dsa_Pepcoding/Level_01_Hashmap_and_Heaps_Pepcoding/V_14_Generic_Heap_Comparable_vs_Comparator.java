package Level_01_Hashmap_and_Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentMap;

public class V_14_Generic_Heap_Comparable_vs_Comparator {

    // So, how PQ supports comparable, comparator and, how can we achieve it in our self-made PQ.
    // Means if we have integer type data then we can sort them in accordingly but what will happen if we have class then how can we sort but
    // as we know that Java PQ can do it using comparable interface with the help of compareTo function. And, we have seen what is Interface.

    public static class Student implements Comparable<Student> {
        int rno;
        int ht;
        int wt;
        Student(int r, int h, int w){
            this.rno = r;
            this.ht = h;
            this.wt = w;
        }
        public int compareTo(Student other){
            return this.rno - other.rno; // if we want in increasing order, and if we want in decreasing order then return o.rno - this.rno.
            // means this for mean_heap, if we want max_heap then reverse it
        }

        // if we want to print then we have override toString method otherwise we see class name with address.

        public String toString(){
            return "Rno. = " + this.rno + ", Ht = " + this.ht + ", wt = " + this.wt;
        }
    }

    // So, we can implement comparable in student class, but if we want for height, and weight for both then we have to write comparator class

    public static class studentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.ht - s2.ht;
        }
    }
    public static class studentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2){
            return s1.wt - s2.wt;
        }
    }

    // So to achieve Java PQ let use give it generic support

    public static class PriorityQueue<T> {
        ArrayList<T> dataList;
        Comparator comp;

        public PriorityQueue(){
            dataList = new ArrayList<>();
            comp = null; // if someone is not passing comparator
        }

  // for comparator class

        public PriorityQueue(Comparator comp){
            dataList = new ArrayList<>();
            this.comp = comp;
        }
        private boolean isSmaller(int i, int j){

            // for comparing with generic support we have to do typecast it into comparable.

            if(comp == null) {
                Comparable ith = (Comparable) dataList.get(i);
                Comparable jth = (Comparable) dataList.get(j);

                if (ith.compareTo(jth) < 0) { // ith = this, jth = other, means when -ve value will come
                    return true;
                } else {
                    return false;
                }
            }else {
                T ith =  dataList.get(i);
                T jth =  dataList.get(j);
                if(comp.compare(ith, jth) < 0){
                    return true;
                }else{
                    return false;
                }
            }

            //return (dataList.get(i) < dataList.get(j));
        }
        public void add(T val){
            dataList.add(val);
            upHeapify(dataList.size()-1);
        }
        private void upHeapify(int i){
            if(i == 0)return;

            /*
             for class comparison, it will typecast into comparable and, will call compareTo.

             Comparable par = (Comparable) data.get(pi);
             Comparable child = (Comparable) data.get(i);
             if(child.compareTo(par) < 0) then do swap

             why less than 0, because here child is related to this, and par is related to other, if this is big then it will return -ve value.
             */

            int pi = (i-1)/ 2;
            if(isSmaller(i, pi)){
                // swap
                swap(i, pi);
                upHeapify(pi);
            }
        }
        private void swap(int i, int j){
            T ith = dataList.get(i);
            T jth = dataList.get(j);
            dataList.set(i, jth);
            dataList.set(j, ith);
        }

        public T remove(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            swap(0, dataList.size()-1);
            T removedData = dataList.remove(dataList.size()-1);
            downHeapify(0);
            return removedData;
        }
        private void downHeapify(int pi){
            int leftChildInd = 2 * pi + 1;
            int mini = pi;

            if(leftChildInd < dataList.size() && isSmaller(leftChildInd, mini)){
                mini = leftChildInd;
            }

            int rightChildInd = 2 * pi + 2;
            if(rightChildInd < dataList.size() && isSmaller(rightChildInd, mini)){
                mini = rightChildInd;
            }
            if(mini != pi){
                swap(mini, pi);
                downHeapify(mini);
            }
        }
        public T peek(){
            if(this.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            return dataList.get(0);
        }
        public int size(){
            return dataList.size();
        }
    }

    public static void main(String[] args) {
      //  PriorityQueue<Student> pq = new PriorityQueue<>();

        // if we will pass like this then we can find data in sorted order accordingly
//        PriorityQueue<Student> pq = new PriorityQueue<>(new studentWtComparator());
        PriorityQueue<Student> pq = new PriorityQueue<>(new studentHtComparator());
        pq.add(new Student(12, 180, 81));
        pq.add(new Student(18, 182, 82));
        pq.add(new Student(7, 178, 79));
        pq.add(new Student(10, 170, 76));
        pq.add(new Student(9, 165, 71));
        pq.add(new Student(1, 185, 86));

        while (pq.size() > 0){
            System.out.println(pq.remove());
        }
    }
}
