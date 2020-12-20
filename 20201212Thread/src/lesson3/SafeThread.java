package lesson3;

public class SafeThread {
    //有一个变量COUNT=0，同时启动20个线程，每个线程循环1000次，每次循环COUNT++
    //等着20个线程个子线程执行完毕，预期COUNT的值为20000
    private static int COUNT=0;
    private static synchronized void creament(){
        COUNT++;
    }
    private synchronized void sum(){
        COUNT++;
    }
    public static void main(String[] args) throws InterruptedException {
        SafeThread s=new SafeThread();
        Class clazz=SafeThread.class;
        //尽量同时启动，不让new thread耗时影响
        Thread[] threads=new Thread[20];
        for(int i=0;i<19;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        //线程安全，加锁    synchronized
                        s.sum();
                        //creament();
//                        synchronized (clazz) {
//                            COUNT++;
//                        }
                    }
                }
            });
        }
        for(int i=0;i<1;i++){
            threads[19+i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        s.sum();//实例同步方法的加锁
//                        synchronized (clazz) {//
//                          COUNT++;
//                        }
                      // creament();//静态方法的加锁
                    }
                }
            });
        }
        for(Thread t:threads){
            t.start();
        }
        //让main线程等待所有的线程池行完毕
        for(Thread t:threads){
            t.join();
        }
        System.out.println(COUNT);







    }

}
