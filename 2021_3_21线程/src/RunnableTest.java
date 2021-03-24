
class RunnableTask implements Runnable{
    @Override
    public void run() {
        System.out.println("start");
        System.out.println(Thread.currentThread());

    }
}

public class RunnableTest {
    public static void main(String[] args) {
        
        RunnableTask task=new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();
        System.out.println("88");


    }
}
