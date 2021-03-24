package 类加载过程;

public class child extends parent {
    private static int a=9;
    private  int b=5;
    private static final String s="88";

    static{
        System.out.println("child static");
    }

    {
        System.out.println("child shiliCode");
    }
    public child(){
        System.out.println("child constructor");
    }
}
