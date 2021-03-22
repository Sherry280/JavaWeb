import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallerTask implements Callable<String>{

     @Override
     public String  call() throws Exception {
         return "hello";
     }
 }
public class CallableTest {
    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask=new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        System.out.println("girl");
        try{
            //等待任务执行完毕，并返回结果
            String result=futureTask.get();
            System.out.println(result);

        }catch (ExecutionException | InterruptedException exc){
            exc.printStackTrace();
        }


    }
}
