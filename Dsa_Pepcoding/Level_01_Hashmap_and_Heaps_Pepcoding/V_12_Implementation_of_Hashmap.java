package Level_01_Hashmap_and_Heaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class V_12_Implementation_of_Hashmap {

       // In this question we have to implement hashmap with our own not predefined So, as we know that we have functionalities like put, size, remove, etc.

    // Functionalities like -> put(update, insert), get(key dene pr value or null), containsKey, remove, keySet(gives all keys), size.
    // And we have to write in o(1) time complexity for every one except keySet.
    // Watch the pepcoding video for better understanding.

    // In hashmap we have to give generic support k,v that is nothing but key,value pair. We wil make array of linkedList, which is called as bucket.

    // START

    public static class HashMap<K,V>{ // generic support, because K,V can be anything, like Integer, string etc.
        private class HMNode{ // this is nothing but key value pair
            K key;
            V value;
            HMNode(K key, V val){
                this.key = key;
                this.value = val;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = bucket.length;

        public HashMap(){
            intiBuckets(4);
            size = 0;
        }
        private void intiBuckets(int N){
            buckets = new LinkedList[N];
            for(int bi = 0; bi < buckets.length; bi++){
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value) throws Exception{
            int bi = hashFunctionToGetBucketIndex(key);
            int di = getIndexWithInBucket(key, bi);

            if(di != -1){
                // update
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                // insert
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            // Here one thing is remaining that is reHash, if lambda cross the threshold value k, that is 2 for this situation we are assuming.

            double lambda = (size * 1.0) / buckets.length;
            if(lambda > 2.0){ // here 2.0 is a threshold value that is nothing but k.
                reHash();
            }
        }

          private void reHash() throws Exception{
            // So, if lambda cross the threshold point then we will do make double size of bucket, and put the previous element into the new bucket.
              // because if in lambda denominater will increase then lambda value will be decreased that means we can come into range again.
              // elements can go at another place in new bucket, because we are increasing bucket length, and doing modulo to put element,
              // to understand assume hashCode value = 42,46 and calculate things we will understand this thing.

              LinkedList<HMNode>[] oldBucket = buckets;
              intiBuckets(oldBucket.length * 2);
              size = 0; // now again it would be handled from put again because if new element is inserted in map then size++ hota hai in put.

              for(int i = 0; i < oldBucket.length; i++){
                  for(HMNode node : oldBucket[i]){
                      put(node.key, node.value);
                  }
              }
        }
        private int hashFunctionToGetBucketIndex(K key){
            // In java, we have hashCode which is applicable for every data types
            int hc = key.hashCode(); // it can be anything like +ve, -ve, 0, bigger number, or smaller number but, (it will give where are our element
            // we have re requirement of only till N numbers, means we will do modulo to get number if N range
            return Math.abs(hc) % buckets.length; // to come always in bucket, that's why we are taking abs then, modulo.
        }
        private int getIndexWithInBucket(K key, int bi){
            int di = 0;
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1; // means element not found.
        }

        public V get(K key) throws Exception{
            int bi = hashFunctionToGetBucketIndex(key);
            int di = getIndexWithInBucket(key, bi);
            if(di != -1){
                // means key os found
                return buckets[bi].get(di).value;
            }else{
                // key not found
                return null;
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunctionToGetBucketIndex(key);
            int di = getIndexWithInBucket(key, bi);

            if(di != -1){
                // means key os found
                return true;
            }else{
                // key not found
                return false;
            }
        }

        public V remove(K key) throws Exception{
            int bi = hashFunctionToGetBucketIndex(key);
            int di = getIndexWithInBucket(key, bi);

            if(di != -1){
                // means key os found
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }else{
                // key not found
                return null;
            }
        }

        public ArrayList<K> keySet() throws Exception{
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < buckets.length; i++){
                for(HMNode node : buckets[i]){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size(){
            return size;
        }
       // END
    }


    public static void main(String[] args) throws Exception{

        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("India", 140);
        mp.put("China", 142);
        mp.put("Pak", 50);
        mp.put("UK", 20);
        mp.put("US", 35);

        System.out.println(mp.get("India"));
        System.out.println(mp.get("Nigeria"));

        System.out.println(mp.remove("Pak"));
        System.out.println(mp.get("Pak"));

        for(String keys : mp.keySet()){
            System.out.print(keys + " ");
        }
    }

    // Average time complexity of HashMap is constant not in worst case, if every element will come in one bucket
    // then it will not be good as much as want, means that will be O(n).
}
