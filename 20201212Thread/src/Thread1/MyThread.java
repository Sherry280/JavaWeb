package Thread1;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("t");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //t.join()无条件等待，当前线程阻塞并等待，一直等到调用线程执行完
        //t.join(1000);//main线程限时 等待，直到t线程执行完，当前线程再往后执行
       // t.join(4000);
        t.wait(4);
        System.out.println("main");
    }
}
