package lesson4;

public class Singleton {
    private static volatile Singleton INSTANCE;
    private Singleton(){}
    private static Singleton getInstance(){
        if(INSTANCE==null){
            synchronized(Singleton.class){//竞争对象锁，竞争成功之后才进行加锁
                if(INSTANCE==null)//保证了我在之后休眠的时候，防止其他线程把INSTANCE的值进行修改
                    INSTANCE=new Singleton();//volatile作用的
                //1.创建初始化内存空间；2.new 对象 3.赋值给共享变量
                //其他代码使用对象，使用INSTANCE对象，调用它的属性的时候
            }
        }
        return INSTANCE;
    }
    //进行重排序操作：不依赖共享变量
    //volatile禁止指令重排序的作用：分解后的指令，volatile修饰的变量，这行指令禁止重排序
    //重排序只保证自己线程内，不保证其他的线程

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            Singleton s=Singleton.getInstance();
        }
    }


}
