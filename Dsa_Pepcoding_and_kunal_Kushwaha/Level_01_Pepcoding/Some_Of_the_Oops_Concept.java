package Level_01_Pepcoding;

import org.w3c.dom.ls.LSOutput;

public class Some_Of_the_Oops_Concept {
//    // This is class
//    public static class Person{// class me data members aur function ko encapsulate(means ek hi me) kr diya jata hai.
//        // and encapsulation is nothing but jisme function aur data member ko ek sath rakh dete hai.
//        // int and String are data members.
//        int age=5;// means its by default jo main me hai wahi liya jayega ydi waha kuchh bhi nhi hai tb ise liya jayega.
//        String name;
//        // and sayHi() is function of this class.
//        void sayHi(){
//            System.out.println(name + "["+age+"]" + "hello");
//        }
//    }
//    public static void main(String[] args) {
//        // Here p1 and p2 both are Objects(thoda missleading word hai) or reference of the  Objects.
//        // or p1 and p2 is are a reference to instance or Objects.
//        // we can say Instance. which is store in heap memory and referred from stack memory.
//        // and reference stored in stack memory .
//
//        Person p1 = new Person();
//        p1.age =10;
//        p1.name = "Aakash";
//        p1.sayHi();
//        Person p2 = new Person();
//        p2.age = 20;
//        p2.name = "Vikash";
//        p2.sayHi();
//
//        // for ex.
//        Person p3 = p1;// yaha new heap nhi banegi p3 and p1 dono same instance ko refer kerenge.
//        p3.age = 30;
//        p3.sayHi();
//        p1.sayHi();
//    }

    // swap game 1.

//    public static class Person{
//        int age;
//        String name;
//        void sayHi(){
//            System.out.println(name+" ["+age+" ] Hello");
//        }
//    }
//    public static void swap1(Person psn1 , Person psn2){
//        Person temp = psn1;
//        psn1 = psn2;
//        psn2 = temp;
//
//    }
//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.name = "Vikku";
//        p1.age = 21;
//
//        Person p2 = new Person();
//        p2.name = "Sattu";
//        p2.age = 20;
//
//        p1.sayHi();
//        p2.sayHi();
//       swap1(p1,p2);
//        p1.sayHi();
//        p2.sayHi();// means swapping main function tk nhi ja payegi. kyoki us reference pr swap hua aur phir return hone
//        // pr remove  ho gya. kyki yaha hmne kewal reference ko change kiya tha instance to same hi rh jayegA.
//    }


    // Swap game 2.

//    public static class Person{
//        int age;
//        String name;
//
//        void sayHi(){
//            System.out.println(name+ " ["+age+" ] Say Hi");
//        }
//    }
//    public static void swap2(Person psn1, Person psn2){
//        // For age
//        int age = psn1.age;
//        psn1.age = psn2.age;
//        psn2.age = age;
//        // Same as for name
//        String name = psn1.name;
//        psn1.name = psn2.name;
//        psn2.name = name;
//    }
//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.name = "Gk";
//        p1.age = 21;
//
//        Person p2 = new Person();
//        p2.name = "Mukku";
//        p2.age  = 20;
//
//        p1.sayHi();;
//        p2.sayHi();
//        swap2(p1,p2);
//        p1.sayHi();
//        p2.sayHi();// Yaha swap ho jayega kyoki instance hi change kr de rhe hai.
//    }


    // Swap game 3.

//    public static class Person{
//        int age;
//        String name;
//        void sayHi(){
//            System.out.println(name+ " ["+age+" ] Hello");
//        }
//    }
//    public static void swap3(Person psn1, Person psn2){
//        psn1 = new Person();
//// kisi cheej ko jb hum new krte hai usme value assign nhi ki hoti hai tb int by default 0 aur String null hoti hai.
//        int age = psn1.age;
//        psn1.age = psn2.age;
//        psn2.age = age;
//
//        psn2 = new Person();
//
//        String name = psn1.name;
//        psn1.name = psn2.name;
//        psn2.name = name;
//    }
//    public static void main(String[] args) {
//        // These three games are here that to know how memory works in the case of class and objects.
//        Person p1 = new Person();
//        p1.name = "VIKASH";
//        p1.age = 21;
//        Person p2 = new Person();
//        p2.name = "Satyam";
//        p2.age =20;
//        p1.sayHi();
//        p2.sayHi();
//        swap3(p1,p2);
//        p1.sayHi();
//        p2.sayHi();
//    }


    // Constructors and 'This' in Oops


    public static class Person{
        int age;
        String name;
        void sayHi(){
            System.out.println(name + " ["+age+" ] Hii" );
        }
        // If we forget it then java provides for our class a default constructor.
        Person(){
            // It is a constructor. we can give it also by self if we forget it then it works as by default.
            // Constructor is type of function  and  then it will call when we will make an object of a class.
            // A function without any parameter in a class is called constructor.
        }
        Person(int age, String name){
            // it's a parameterised constructor.
            this.age = age;// here this ka means hai class ke age and name se and = age means jo function me pass kiya gya hai.
            this.name = name;// and this passes in stack memory by default.
        }
    }
    public static void main(String[] args) {
       Person p1 = new Person();// its look like a function but who is being called that is known as constructor.
       p1.name = "Vikash";
       p1.age = 21;
       p1.sayHi();
        System.out.println();
       // So we another method to make object using parameterised constructor.
        Person p2 = new Person(20,"Mukku");
        p2.sayHi();

        // some stages which is important

        /*
        1--> space allocation
        2--> parsing --> means jo things function ke out hai class me o chl jayengi.
        3--> constructor fire --> same as function name. it can default(no parameter) as wll as we can also make.
                                  it fires from the new keyword from the main.
                                  if we are using parameterised constructor then java default wala remove kr dega means
                                  humko default wala bhi khud hi dena padega. otherwise error aa jayega
         */
    }
}
