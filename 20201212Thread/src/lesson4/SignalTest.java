package lesson4;

public class SignalTest {
    public static void main(String[] args) throws InterruptedException {
        //竞争class对象的锁
        synchronized (SignalTest.class) {
            //当前线程释放对象锁
            //SignalTest.class.wait();
            //通知调用同一个对象的wait（）阻塞的线程（唤醒后再次去竞争对象锁）
            SignalTest.class.notify();
        }//释放对象锁
    }


}
