package Thread2;

public class Thread3 {
    private static volatile boolean STOP=false;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10000&&!STOP;i++){
                        System.out.println(i);
                        Thread.sleep(1000);
//                        Thread.sleep(100000);通过标志位实现，无法解决线程阻塞带来的中断问题
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println("t start!");
        //模拟，让他先执行5s，然后中断
        t.join(5000);
        STOP=true;

        System.out.println("t stop");
    }
}
