package lesson3;

public class SynchronizedTest2 {
    private static int COUNT=50;

    public static void main(String[] args) {
        new Thread(new Task(10)).start();
        new Thread(new Task(20)).start();
        new Thread(new Task(50)).start();
//        Task task=new Task();
//        for(int i=0;i<3;i++){
//            new Thread(task).start();
//        }
    }
    private static class Task implements Runnable{
        //设置每个老师可以安排的学生的数量
        private int num;
        public Task(int num){
            this.num=num;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                synchronized (SynchronizedTest2.class){
                    if(COUNT>0&&num>0){
                        COUNT--;
                        num--;
                        System.out.printf("%s:COUNT=%d,num=%d\n",Thread.currentThread().getName(),COUNT,num);
                       // System.out.println(Thread.currentThread().getName()+":"+COUNT);

                    }

                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
