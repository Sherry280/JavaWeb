package Thread1;

public class MyThread {
    public static void main(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(true){

                }
            }
        };
        t.start();
    }
}
