package lesson3;

public class UnSafeThread {
    //有一个变量COUNT=0，同时启动20个线程，每个线程循环1000次，每次循环COUNT++
    //等着20个线程个子线程执行完毕，预期COUNT的值为20000
    private static int COUNT=0;
    public static void main(String[] args) throws InterruptedException {
        //尽量同时启动，不让new thread耗时影响
        Thread[] threads=new Thread[20];
        for(int i=0;i<20;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        COUNT++;
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
