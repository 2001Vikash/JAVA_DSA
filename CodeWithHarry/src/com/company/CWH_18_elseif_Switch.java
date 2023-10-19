package com.company;
import java.util.Scanner;
public class CWH_18_elseif_Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Age");
         int age=sc.nextInt();// -> its indicates switch enhance mode.
   // enahance mode ki best quality ye hai ki isme break ki jaroorat nhi hoti hai
        switch(age){// in switch case variable can be anything.like String , char ,bool ,float etc.
            case 18:
                System.out.println("You are going to become adult!");
                System.out.println("You are going to become adult!");
                System.out.println("You are going to become adult!");
                break;// ise nhi lahayenge to case 18 true hone pr yahA SE niche tk sabhi print ho jayega
            case 23:// aur ek bar break hone ke baad ye switch loop se bahar nikal jayega23
                System.out.println("You are going to a job!");
                break;
            case 60:
                System.out.println("You are going to become retired!");
                break;
            default:
                System.out.println("Enjoy your life!");
        }
        System.out.println("Thanks for using my java code ! ");
      /*
       if(age>56){
             System.out.println("You are experienced!");
         }// inme se koi bhi ek true ho gya to whi print ho jayega aahe nhi execute hoga
         //that means in sabhi me se koi ek execute hoga
         else if (age>46){
             System.out.println("You are semi-experienced!");
         } else if (age>36) {
             System.out.println("You are semi-semi-experienced");
         }
         else{
             System.out.println("You are not experienced!");
         }// aur ye if-else-if ladder yhi end  ho jayega .

       */
      //  if (age>18){
         //   System.out.println("You are in teen age!");// mtlb ye bhi execute hoga kyoki ye dusra ladder hai
         //   if(age>2){
         //       System.out.println("You are baby");
        //    }
     //   }// aur kewal if har jagah likhate hai to sabi execute honge
        // ya phir if ke andar if karte jaye to wh bi sahi hoga but bad looking
    }
}
