package lesson7;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                5,//核心线程数
                10,//最大线程数-----正式员工加上临时工
                60,
                TimeUnit.SECONDS,//idle线程的空闲时间，偷懒时间：临时工的最大的存活时间，超过时间就解雇
                new LinkedBlockingQueue<>(),//阻塞队列，任务存放的地方（快递公司）
                new ThreadFactory() {//创建线程的工程类
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(new Runnable() {
                            @Override
                            public void run() {
                                long start=System.currentTimeMillis();
                                r.run();
                                long end=System.currentTimeMillis();
                                System.out.println("任务执行了"+(end-start)+"毫秒");
                            }
                        });
                    }
                },//创建线程的工厂类，
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略：达到最大线程数并且阻塞队列已满，采取的拒绝策略有4种
                /**
                 * 4种拒绝策略：
                 * AbortPolicy:直接抛RejectedExecutionException
                 * CallerRunPolicy:
                 * DiscardPolicy:谁交给我任务，我拒绝执行，交给我的任务，直接丢弃掉
                 * DiscardOldestPolicy：丢弃阻塞队伍中最旧的任务
                 */


        );//线程池创建出来以后，只要有任务放进去，他就自己执行了
        for(int i=0;i<20;i++){
            final int j=i;
            //线程池执行任务有2种：1.execute() 2.submit()
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            });
        }

    }
}
