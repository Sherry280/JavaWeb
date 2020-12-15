package Thread1;

public class MyThread3 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t");
            }
        });
        t.start();
        System.out.println("main");
        //t和main同时并发执行，但main线程正处于运行态，很快执行后续代码
        //打印main和t这个操作，本来应该乱序随机的，但是先打印main的概率比较高


    }
}
