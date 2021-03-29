import org.openjdk.jol.info.ClassLayout;

public class Test {
     static lock l=new lock();
    public static void main(String[] args) {
        lockTest();
    }
    public static void lockTest(){
        synchronized (l) {
            System.out.println("jjj");
            System.out.println(l.hashCode());
            System.out.println(Integer.toHexString(l.hashCode()));
            System.out.println(ClassLayout.parseInstance(l).toPrintable());


        }

    }
}
