package Thread2;

public class Thread4 {
    //Interrupted中断操作
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    System.out.println(i+":"+Thread.interrupted());//会重置标志位
                    //Thread.sleep(1000);
                }

            }

        });
        t.start();//开始设置的t中断标志位=false
        System.out.println("t start");
        //Thread.sleep(5000);
        t.interrupt();  //标志位设置为true
        //告诉t线程，（设置为true）要中断，由t线程决定是否进行中断
        System.out.println("t stop");



        //有一种特殊的情况：t start--->t  stop----->0 false--->1 true--->false

    }
}
