import java.util.HashMap;
import java.util.Hashtable;

public class SingleTon {
    private static SingleTon instance=null;
    public SingleTon(){}

    public static SingleTon getInstance() {
       return instance;
    }

    public static void main(String[] args) {
        Hashtable s=new Hashtable();
        HashMap a=new HashMap();

    }
}
