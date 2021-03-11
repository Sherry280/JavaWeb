public class 懒汉式线程安全 {
    /**
     * 线程安全：能够在多线程下很好的工作
     * 但是效率很低，99%的情况下不需要同步;该方法也不常用
     * 优点：第一次调用才初始化，避免内存泄漏
     * 缺点：必须加锁synchronized才能保证单例，但加锁会影响效率！
     */
    private static 懒汉式线程安全 instance=null;
    private 懒汉式线程安全(){}
    public static synchronized 懒汉式线程安全 getInstance(){
        if(instance==null){
            instance=new 懒汉式线程安全();
        }
        return instance;
    }
}
