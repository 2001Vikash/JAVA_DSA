package com.company;
// Who lines of program are executed known as control.
public class CWH_24_break_continue {
    public static void main(String[] args) {
        // BREAK
//        for(int i=0;i<5;i++){
//            System.out.println(i);
//            System.out.println("Hare Krishna");
//            if(i==2){
//                System.out.println("ends the loop");
//                break;// its mean that if given condition is true then come out of the Loop.
//            }
//        }
//        int j=0;
//        while (j<5){
//            System.out.println("Hare Krishna -->"+j);
//            if(j==2){
//                System.out.println("Ends the loop");
//                break;
//            }
//            j++;
//        }
//        int k=0;
//        do{
//            System.out.println("Hare Krishna -->"+k);
//            //k++;
//            if(k==2){
//                System.out.println("Ends loop");
//                break;
//            }
//           // k++;
//        }while(k<5);
        // CONTINUE
//        for (int i=0;i<5;i++){
//            if (i==2){
//                System.out.println("Ends loop");
//                continue;// its directly means that ydi i==2 true hai to niche ke statement ko i==2 ke na run kare
//                //  aur 'i' ki next value ke liye run kare.
//            }
//            System.out.println("Hare krishna-->"+i);
//        }
        int j=0;
        while (j<5){
            j++;
            if(j==2){
               // System.out.println("Ends Loop");
                continue;
            }
           // j++;
            System.out.println("Hare Krishna-->"+j);
             //j++;
        }
    }
}
