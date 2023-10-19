package Level_01_Pepcoding;

public class Arrays {
//    public static void swap(int[] a , int i, int j){
//        int temp= a[i];
//        a[i]=a[j];
//        a[j]=temp;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[3];
//        arr[0]=12;
//        arr[1]=23;
//        arr[2]=33;
//        int[] a = arr;
//       // a[2]=54;
//        swap(arr, 0,2);
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }
//        // means value change ho jayegi.

    //  }

// Span Of an Array.

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//            arr[i]=sc.nextInt();
//        }
//        int max=arr[0];// if max=0 lete hai aur array me kewal negative value hai tb kabhi ans aayega hi nhi wh 0 hi rhega.
//        int min = arr[0];
//        for(int i=1; i<n; i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }
//        int span = max - min;
//        System.out.println(span);

        // Find element in an array.

//        int num = sc.nextInt();
//        int ind = -1;
//        for(int i=0; i<n; i++){
//            if(arr[i]==num){
//                ind = i;
//                break;
//            }
//        }
//        System.out.println(ind);


        // Bar Chart

//        int[] arr = {3,2,3,4};
//        int n= arr.length;
//        int max=arr[0];
//        for(int i=0; i<n; i++){
//            if(arr[i]>max){
//                max=arr[i];
//            }
//        }
//
//        for(int i=max; i>=1; i--){
//            for(int j=0; j<n; j++){
//                  if(arr[j]>=i){
//                      System.out.print("*\t");
//                  }else {
//                      System.out.print("\t");
//                  }
//            }
//            System.out.println("");
//        }

        // Sum Of Two Arrays.

//        int[] a = {1,2,3,4,5};
//        int[] b = {1,3,4,2,4,5};
//         int n = a.length;
//         int m = b.length;
//         int c=0;
//         int[] sum = new int[n>m?n:m];
//         int i=n-1,j=m-1,k=sum.length-1;
//         while(k>=0){
//             int d=c;
//             if(i>=0){
//                 d+=a[i];
//             }
//             if(j>=0){
//                 d+=b[j];
//             }
//             c=d/10;
//             int s = d%10;
//             sum[k]=s;
//             i--;
//             j--;
//             k--;
//         }
//         if(c!=0){
//             System.out.print(c+" ");
//         }
//         for(int val:sum){
//             System.out.print(val+" ");
//         }

        // Subtraction of two array
// Here is one assumption that a is big always.


        int[] a = {1,0,0,0};
        int[] b =   {9,9,9};
        int n = a.length;
        int m = b.length;
        int[] sub = new int[n];
        int i=n-1, j=m-1, k=n-1;
        int borrow=0;
        while(k>=0){
            int d=0;
            int jVb = j>=0 ? b[j] : 0;
            int r = a[i] - borrow;
            if (r>= jVb) {
                d = r - jVb;
                borrow=0;
            } else {
                r = r + 10;
                d = r - jVb;
                borrow = 1;
            }

            sub[k]=d;
            i--;
            j--;
            k--;
        }
        int ind =0;
        while(ind<n){
            if(sub[ind]==0){
                ind++;
            }else{
                break;
            }
        }
        while(ind<n){
            System.out.print(sub[ind]+" ");
            ind++;
        }
    }

    public static void sort(int[] arr) {
    }

//    public static boolean toString(int[] arr) {
//    }
}

