public class 双重校验锁 {
    /**
     * 多线程安全版本，进行二次判断，性能高的懒汉模式
     * 采用双锁机制，安全且在多线程情况下能保持高性能
     */
    private static 双重校验锁 instance=null;
    private 双重校验锁(){}
    public static 双重校验锁 getInstance(){
        if(instance==null){
            synchronized (双重校验锁.class){
                if(instance==null){
                    instance=new 双重校验锁();
                }
            }
        }
        return instance;
    }
}

