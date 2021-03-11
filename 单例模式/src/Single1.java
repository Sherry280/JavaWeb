/**
 * 单例模式
 */
public class Single1 {
    //自己创建一个对象
    private static Single1 instance=new Single1();
    //私有化构造方法
    private Single1(){ }
    //提供返回该对象的静态方法
    public static Single1 getInstance(){
        return instance;
    }




}
