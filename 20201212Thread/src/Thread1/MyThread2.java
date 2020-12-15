package Thread1;

public class MyThread2 {
    public static void main(String[] args) throws InterruptedException {

        Thread[] threads=new Thread[20];
        for(int i=0;i<20;i++){
            final int n=i;
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });

        }
        for(Thread t:threads){
            t.start();
       // t.join();
        }

//        while (Thread.activeCount()>1){//获取当前存活的线程
//            Thread.yield();//让当前线程让步
//        }
        for (Thread t: threads) {
            t.join();
        }

        System.out.println("ok");



//        for(int i=0;i<20;i++){
//            final int n=i;
//            //子线程先休眠3s
//            //new thread操作有点耗费时间
//            Thread t=new Thread(new Runnable() {
//                @Override
//                public void run(){
//                    System.out.println(n);//main主线程和子线程同时执行
////                    try {
////                        Thread.sleep(3000);
////                        System.out.println(n);//n必须被final修饰   匿名内部类
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                }
//            });//申请系统创建线程t
//            t.start();//申请系统执行线程t，创建态转为就绪态，什么时候转为运行态由系统决定
//        }
//        //main线程和子线程同时执行，
//        System.out.println("ok");
    }
}
