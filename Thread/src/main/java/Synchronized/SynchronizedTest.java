package Synchronized;

public class SynchronizedTest {
    public static Object object=new Object();
    public  synchronized void eat(){
        System.out.println("eat banana");
    }

    public static void main(String[] args) {
        SynchronizedTest s=new SynchronizedTest();
        s.eat();
        System.out.println("mm");//javap -c SychronizedTest
//        synchronized (object){
//            System.out.println("hello baby");
//        }

    }
}
