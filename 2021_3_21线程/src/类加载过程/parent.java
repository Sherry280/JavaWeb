package 类加载过程;

public class parent {
    private static int a=9;
    private  int b=5;
    private static final String s="88";

    static{
        System.out.println("parent static");
    }

    {
        System.out.println("parent shiliCode");
    }
    public parent(){
        System.out.println("parent constructor");
    }
}
