package lesson7;

/**
 * 需要使用数组循环队列拥有的属性：1.存放元素的索引，2.取元素的的索引，3.当前存放元素的数量
 *
 * 实现阻塞队列：
 * 1.线程安全问题:在多线程情况下，put，take不具有原子性，4个属性，不具有可见性
 * 2.put操作存满了，需要阻塞等待，take操作，没有对象，则让其等待
 */
public class MyBlockingQueue<T> {
    //使用数组实现循环队列，只能存放固定的类型，所以使用泛型存放任意数据类型
    private Object[] queue;

    //存放元素的索引
    private int putIndex;
    //取元素的索引
    private int takeIndex;
    //当前存放元素的数量
    private int size;


    public MyBlockingQueue(int len){
        queue=new Object[len];

    }

    //存元素:1.需要考虑putIndex超过数组的长度，2.size达到最大长度
    public synchronized void put(T e) throws InterruptedException {//synchronized ()加锁针对this对象加锁
        //当阻塞等待被唤醒并再次竞争成功对象锁，恢复往后执行，条件可能会被其他线程修改
        while(size==queue.length){
            this.wait();//Or  wait()
            //throw new RuntimeException("长度超过最大长度");
        }
        queue[putIndex]=e;//存放到数组中放元素的索引
        //存放位置超过数组的最大索引，需要取模放到0位置
        putIndex=(putIndex+1)%queue.length;
        size++;
        notifyAll();//this.notifyAll()和synchronized加锁的对象是一致的


    }

    //取元素
    public T take() throws InterruptedException {
        while(size==0){
           wait();
        }
        T t= (T) queue[takeIndex];
        queue[takeIndex]=null;
        takeIndex=(takeIndex+1)%queue.length;
        size--;
        return t;

    }

    //获取当前的元素的数量
    public int size(){
        return size;
    }


    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue=new MyBlockingQueue<>(10);
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        try {
                            queue.put(j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (; ; ) {

                            int i = queue.take();
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                        }
                    }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }).start();
        }
//        queue.put("a");
//        queue.put("f");
//        queue.put("h");
//        queue.put("y");

//        queue.take();
//        for(Object s:queue.queue){
//            System.out.println(s);
//        }


    }




}
