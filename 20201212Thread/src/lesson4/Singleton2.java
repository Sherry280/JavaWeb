package lesson4;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Singleton2 {
    private static volatile Singleton2 INSTANCE;
    private Singleton2(){

    }
    private static Singleton2 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton2.class){
                if(INSTANCE==null){
                    INSTANCE=new Singleton2();


                }
            }
        }
        return INSTANCE;
    }

}
