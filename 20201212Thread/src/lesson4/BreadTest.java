package lesson4;

public class BreadTest {
    private static volatile int COUNT;
    //消费者
    public static class Consumer implements Runnable{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //一直消费
            try {
                while (true){
                    synchronized (BreadTest.class){
                        //库存到达下线
                        if(COUNT==0){//阻塞等待
                            BreadTest.class.wait();//释放对象锁
                        }else{
                            //满足条件，继续减库存
                            //库存>0，允许消费
                            System.out.printf("消费者%s消费了1个面包\n",name);
                            COUNT--;
                            //通知BreadTest()；代码进入阻塞的线程
                            BreadTest.class.notifyAll();
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    //生产者
    public static class Product implements Runnable{
        private String name;

        public Product(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //一直生产
            try {
                while (true){
                    synchronized (BreadTest.class){
                        //库存数量>98
                        if(COUNT>98){//阻塞等待
                            BreadTest.class.wait();//释放对象锁
                        }else{

                            //库存不够
                            System.out.printf("生产者%s生产了3个面包！\n",name);
                            COUNT=COUNT+3;
                            //通知BreadTest()；代码进入阻塞的线程
                            BreadTest.class.notifyAll();
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        //同时启动20个消费者线程
        Thread[] threads=new Thread[20];
        for(int i=0;i<20;i++){
            threads[i]=new Thread(new Consumer(String.valueOf(i)));

        }
        //同时启动10个生产者线程
        Thread[] threads1=new Thread[10];
        for(int i=0;i<10;i++){
            int finalI = i;
            threads1[i]=new Thread(new Product(String.valueOf(i)));

        }
        for(int i=0;i<20;i++){
            threads[i].start();
        }
        for(int i=0;i<10;i++){
            threads1[i].start();
        }

    }
}
