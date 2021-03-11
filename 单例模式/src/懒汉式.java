public class 懒汉式 {
    /**
     * 线程不安全
     * 不支持多线程，因为没有加锁synchronized,所以严格意义上来说不算是单例模式
     */
    private static 懒汉式 instance=new 懒汉式();
    private 懒汉式(){}
    public static 懒汉式 getInstance(){
        if(instance==null){
            instance=new 懒汉式();
        }
        return instance;
    }
}
