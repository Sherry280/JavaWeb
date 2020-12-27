package lesson4;

/**
 * 升级版本：面包店
 * 师傅每个生产30次，生产90个面包，10个师傅，每天最多生产900个面包
 * 消费者：也不再一直消费，把900个消费完就结束
 */
public class BreadTest2 {
    private static int CONSUMER=10;//消费者数量
    private static int CONSUMER_COUNT=5;//消费者每次消费的面包数量
    private static int PRODUCT_NUMBER=5;//生产者数量
    private static int PRODUCE_TIMES=150;//生产面包总的数量
    private static int PRODUCE_COUNT=3;//每次生产3个面包
    private static int MAX_COUNT=100;

    private static int COUNT=900;
    private static int Product_number;
    //生产者
    public static class Consumer implements Runnable{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            //只要还有面包，就一直不停的进行消费
            try {
                while(true){
                    synchronized (BreadTest2.class){
                        if(Product_number==Product_number*PRODUCE_COUNT*PRODUCE_TIMES){
                            break;
                        }
                        if(COUNT==0){
                            BreadTest2.class.wait();

                        }else{
                            System.out.println("消费者%s消费了1个面包");
                            COUNT--;
                            BreadTest.class.notifyAll();
                            Thread.sleep(1000);

                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //消费者
    public static class Product implements Runnable{
        private String name;

        public Product(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            //一直生产
            try {
                //达到生产次数
                for(int i=0;i<PRODUCE_TIMES;i++){
                    synchronized (BreadTest.class){
                        //库存数量>98
                        if(COUNT>PRODUCE_COUNT){//阻塞等待
                            BreadTest.class.wait();//释放对象锁
                        }else{

                            //库存不够
                            System.out.printf("生产者%s生产了%s个面包！\n",name,PRODUCE_COUNT);
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
        //同时启动消费者线程
        Thread[] threads=new Thread[20];
        for(int i=0;i<CONSUMER_COUNT;i++){
            threads[i]=new Thread(new BreadTest.Consumer(String.valueOf(i)));

        }
        //同时启动10个生产者线程
        Thread[] threads1=new Thread[10];
        for(int i=0;i<PRODUCE_COUNT;i++){
            threads1[i]=new Thread(new BreadTest.Product(String.valueOf(i)));

        }
        for (Thread t :
                threads) {
            t.start();
        }
        for (Thread t2:
             threads1) {
            t2.start();
        }

    }










}
