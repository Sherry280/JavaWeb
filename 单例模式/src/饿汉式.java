public class 饿汉式 {
    /**
     * 线程安全，比较常用，但是容易产生垃圾，因为一开始就初始化
     * 优点：没有加锁，执行效率会提高
     * 缺点：类加载时就初始化，浪费内存
     */
    private static 饿汉式 instance=new 饿汉式();
    private 饿汉式(){}
    public static 饿汉式 getInstance(){
        return instance;
    }
}
