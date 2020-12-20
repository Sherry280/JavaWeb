package lesson3;

public class SynchronizedTest {
    /**
     * 有一个教室，50个座位，同时有三个老师在安排同学的座位
     * 每个老师安排100个同学到这个教室里
     * 座位编号0-49/1-50，三个线程同时启动来安排同学的座位
     * 同学可以循环操作来安排，直到座位安排满
     */

    static class QSeats implements Runnable {
        private static int seats = 50;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (this) {
                    if (seats > 0) {
                        System.out.println(Thread.currentThread().getName() +
                                "还有" + seats-- + "个座位");
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads=new Thread[3];
        QSeats qSeats=new QSeats();
        for(int i=0;i<3;i++){
            threads[i]=new Thread(qSeats);
        }
       for(int i=0;i<3;i++){
           threads[i].start();
       }

    }

//    public static void main1(String[] args) throws InterruptedException {
//
//        Thread t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    synchronized (SafeThread.class){
//                        if(seats>0){
//                            try {
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(Thread.currentThread().getName()+
//                                    "还有"+seats--+"个座位");
//                        }
//
//                    }
//
//                }
//            }
//        });
//        t1.start();
//
//
//        Thread t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    synchronized (SafeThread.class){
//                        if(seats>0){
//                            try {
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(Thread.currentThread().getName()+
//                                    "还有"+seats--+"个座位");
//                        }
//
//                    }
//
//                }
//            }
//        });
//        t2.start();
//
//        Thread t3=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    synchronized (SafeThread.class){
//                        if(seats>0){
//                            try {
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println(Thread.currentThread().getName()+
//                                    "还有"+seats--+"个座位");
//                        }
//
//                    }
//
//                }
//            }
//        });
//        t3.start();
//
//
//    }
}
