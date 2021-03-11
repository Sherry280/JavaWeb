public class Single1Demo {
    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数Single（）是不可见的
        //Single1 s=new Single1();
        Single1 s1=Single1.getInstance();
        Single1 s2=Single1.getInstance();
        System.out.println(s1==s2);

    }
}
