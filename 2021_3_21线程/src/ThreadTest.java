public class ThreadTest {
    /**
     * 创建线程的三种方式
     * 1.Thread类
     * 2.Runnable()接口
     * 3.Callable()
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("start");
            //使用this来获取当前线程
            System.out.println(this);
        }
    }
    public static void main(String[] args) {
        //创建线程
        MyThread thread1=new MyThread();
        MyThread thread2=new MyThread();
        //启动线程
        thread1.start();
        thread2.start();
        System.out.println("end");

    }
    public static void main1(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("start");
                //使用this来获取当前线程
                System.out.println(this);

            }
        };
        t.start();
        System.out.println("end");

    }



}
