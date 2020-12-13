package InnerClass;
public class Main {
    public static void main(String[] args) {
       InnerClass innerClass=new InnerClass(){
           @Override
           public void Y() {
               System.out.println("B");
           }
       };
       innerClass.Y();

    }

    public static class InnerClass {
        public void Y(){
            System.out.println("A");
        }




    }

}
