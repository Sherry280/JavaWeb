package Thread2;

public class Thread2 {
    //同时启动20个线程，每个线程从0，+1的方式一直加到99999
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            Thread t=new Thread(){
                @Override
                public void run() {
                    //执行9999次
                    for(int i=0;i<10000;i++){
                        if(i==9999)
                            System.out.println(i);

                    }
                }
            };
            t.start();
        }
    }
}
