package lesson4;
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

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Singleton2 singleton2=Singleton2.getInstance();
        }
    }

}
